package src;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
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
	
	//product list
	public static GraphQLObjectType  ProductsType = newObject()
			.name("ALLproducts")
			.field(newFieldDefinition().name("name").type(new GraphQLList(GraphQLString)).build())
			.build();
	
	public static GraphQLObjectType	rshipTargetType = newObject()
			.name("relationshipTarget")
			.field(newFieldDefinition().name("name").type(GraphQLString).build())
			.field(newFieldDefinition().name("overview").type(GraphQLString).build())
			.build();
	
	
			
			
	
	
	//cb_people(peopelType)
	public static GraphQLObjectType peopleType = newObject()
			.name("PeopleInfo")
			.field(newFieldDefinition().name("id").type(GraphQLInt).build())
			.field(newFieldDefinition().name("object_id").type(GraphQLString).build())
			.field(newFieldDefinition().name("first_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("last_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("birthplace").type(GraphQLString).build())
			.field(newFieldDefinition().name("affiliation_name").type(GraphQLString).build())
			.build();
	//cb_objects(objectsType)
	public static GraphQLInterfaceType  companyType = newInterface()
			.name("Company")
			.field(newFieldDefinition().name("name").type(GraphQLString).build())
			.field(newFieldDefinition().name("domain").type(GraphQLString).build())
			.field(newFieldDefinition().name("homepageurl").type(GraphQLString).build())
			.field(newFieldDefinition().name("overview").type(GraphQLString).build())
			.field(newFieldDefinition().name("foundedAt").type(GraphQLString).build())
			.field(newFieldDefinition().name("allProducts").type(new GraphQLList(ProductsType)).build())
			.field(newFieldDefinition().name("fundingRounds").type(GraphQLInt).build())
			.build();
			
	
	
	//查询一个或多个peopleinfo
	//dataabse select
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
						.type(new GraphQLList(peopleType))
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
