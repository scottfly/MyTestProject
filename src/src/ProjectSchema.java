package src;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLBigInteger;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.GraphQLUnionType.newUnionType;
import static graphql.schema.GraphQLInterfaceType.newInterface;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Collections;
import java.math.BigInteger;

import src.Db.*;
import graphql.schema.*;


public class ProjectSchema {
	
	
	/********************************/
	//web type
	public static GraphQLObjectType webType = newObject()
			.name("webinfo")
			.field(newFieldDefinition().name("source_url").type(GraphQLString).build())
			.field(newFieldDefinition().name("source_description").type(GraphQLString).build())
			.build();
			
	//relationships type
	public static GraphQLObjectType	rshipTargetType = newObject()
			.name("relationshipTarget")
			.field(newFieldDefinition().name("person_object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("relationship_object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("start_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("end_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("is_past").type(GraphQLInt).build())
			.field(newFieldDefinition().name("sequence").type(GraphQLInt).build())
			.field(newFieldDefinition().name("title").type(GraphQLString).build())
			.build();
	
	//milestones refer to cb_milestones
	public static GraphQLObjectType milesStonesType = newObject()
			.name("milestones")
			.description("milestones information about company`s and person`s and so on")
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("milestone_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("milestone_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("description").type(GraphQLString).build())
			.field(newFieldDefinition().name("weburl").type(webType).build())
			.build();
			
	//funding_rounds refer to cb_funding_rounds
	public static GraphQLObjectType funding_Rounds = newObject()
			.name("funding_rounds")
			.description("descrip funding rounds informationg about company")
			.field(newFieldDefinition().name("funding_round_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("funded_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("funding_round_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("raised_amount_usd").type(GraphQLBigInteger).build())
			.build();
	
	
	
	
	/********************************/
	//定义一个Entity
	 public static GraphQLInterfaceType objectEntity = newInterface()
			 .name("ObjectEntity")
			 .description("a company? a people? products or other")
			 .field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			 .field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
			 .field(newFieldDefinition().name("normalized_name").type(new GraphQLNonNull(GraphQLString)).build())
			 /**
			  *。。。other base type 
			  */
			 .build();
			 
	
	
	//product list
	public static GraphQLObjectType  ProductsType = newObject()
			.name("Products")
			.field(newFieldDefinition().name("name").type(new GraphQLList(GraphQLString)).build())
			.withInterface(objectEntity)
			.build();
			
	
	
	//cb_people(person interface objectEntity)			一个独立的实体
	public static GraphQLObjectType person = newObject()
			.name("PeopleInfo")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("normalized_name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("first_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("last_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("birthplace").type(GraphQLString).build())
			.field(newFieldDefinition().name("affiliation_name").type(GraphQLString).build())
			.build();
	//cb_objects(company interface objectEntity)
	public static GraphQLObjectType  company = newObject()
			.name("Company")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("normalized_name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(GraphQLString).build())
			.field(newFieldDefinition().name("domain").type(GraphQLString).build())
			.field(newFieldDefinition().name("homepageurl").type(GraphQLString).build())
			.field(newFieldDefinition().name("overview").type(GraphQLString).build())
			.field(newFieldDefinition().name("foundedAt").type(GraphQLString).build())
			.field(newFieldDefinition().name("allProducts").type(new GraphQLList(ProductsType)).build())
			.field(newFieldDefinition().name("fundingRounds").type(GraphQLInt).build())
			 /**
			  *。。。other base type 
			  */
			.build();
	
	//cb_funds( FinancialOrg interface objectEntity)
	public static GraphQLObjectType FinancialOrg = newObject()
			.name("FinancialOrg")
			.description("about funds info relay to company and person")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("normalized_name").type(new GraphQLNonNull(GraphQLString)).build())
			 /**
			  *。。。other base type 
			  */
			.build();
	
	
	//查询一个或多个person
	//database select
	private DataFetcher peopleInfoFetcher = new DataFetcher()
			{
				@Override
				public Object get(DataFetchingEnvironment environment) {
					// TODO Auto-generated method stub
					int id = environment.getArgument("id");
					String name = environment.getArgument("name");
					if(name.isEmpty() && id == 0)
					{
						return null;
					}
					List<PeopleTB> respeopleInfo = new ArrayList<PeopleTB>();
				
					/*PeopleTB peo = new PeopleTB();
					 * peo.setId(2);
					 * peo.setObject_id("p:3");
					 * peo.setFirst_name(he);
					 * peo.setLast_name("zhenglin");
					 * peo.setBithplace("beijing");
					 * peo.setAffiliation_name("affi");
					 * respeopleInfo.add(peo);
					 * */
					return respeopleInfo;
				}
			};
			
			//api?
	public GraphQLFieldDefinition QueryPeopleInfo()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("people_info")
				.type(new GraphQLList(person))
				.argument(newArgument().name("id").type(GraphQLInt).build())
				.argument(newArgument().name("name").type(GraphQLString).build())
				.dataFetcher(peopleInfoFetcher)
				.build();
	}
	
	
			
			
			
			
			
			
			
	
	
	
	
	//
	private  GraphQLSchema schema;
	
	//初始化schema
	public ProjectSchema()
	{
		schema = GraphQLSchema.newSchema()
				.query(newObject().name("schemaQuery")
						.field(QueryPeopleInfo())
						.build())
				.build();
	}
	
	//定义一个schema 它包好一个或多个filed（即表或者视图）
	

	public GraphQLSchema getSchema() {
		return schema;
	}

	public void setSchema(GraphQLSchema schema) {
		this.schema = schema;
	}

}
