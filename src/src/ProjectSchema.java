package src;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.Scalars.GraphQLBigInteger;
import static graphql.Scalars.GraphQLBoolean;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.schema.GraphQLUnionType.newUnionType;
import static graphql.schema.GraphQLInterfaceType.newInterface;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import java.util.Collections;
import java.util.Collections;
import java.math.BigInteger;
import java.sql.Date;

import src.IdInterface.*;
import src.Db.*;
import graphql.schema.*;
import src.DataF_cb_objects;
import src.DataF_cb_people;
import src.*;

public class ProjectSchema {
	
	
	/********************************/
	
	//定义一个Entity
		 public static GraphQLInterfaceType objectEntity = newInterface()
				 .name("ObjectEntity")
				 .description("a company? a people? products or other")
				 .field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
				 .field(newFieldDefinition().name("entity_type").type(new GraphQLNonNull(GraphQLString)).build())
				 .field(newFieldDefinition().name("parent_id").type(GraphQLString).build())
				 .field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
				 .field(newFieldDefinition().name("normalized_name").type(GraphQLString).build())
				 .field(newFieldDefinition().name("category_code").type(GraphQLString).build())
				 .field(newFieldDefinition().name("founded_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("closed_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("domain").type(GraphQLString).build())
				 .field(newFieldDefinition().name("homepage_url").type(GraphQLString).build())
				 .field(newFieldDefinition().name("logo_url").type(GraphQLString).build())
				 .field(newFieldDefinition().name("description").type(GraphQLString).build())
				 .field(newFieldDefinition().name("region").type(GraphQLString).build())
				 .field(newFieldDefinition().name("overview").type(GraphQLString).build())
				 .field(newFieldDefinition().name("first_investment_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("last_investment_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("invested_companies").type(GraphQLInt).build())
				 .field(newFieldDefinition().name("investment_rounds").type(GraphQLInt).build())
				 .field(newFieldDefinition().name("first_funding_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("last_funding_at").type(GraphQLString).build())
				 .field(newFieldDefinition().name("funding_total_usd").type(GraphQLBigInteger).build())
				 .field(newFieldDefinition().name("funding_rounds").type(GraphQLInt).build())
				 .field(newFieldDefinition().name("milestones").type(GraphQLInt).build())
				 .field(newFieldDefinition().name("relationships").type(GraphQLInt).build())
				 .field(newFieldDefinition()
						 .name("refer_info")
						 .type(new GraphQLList(new GraphQLTypeReference("ObjectEntity")))
						 .build())
				 .typeResolver(new TypeResolver(){
					 
					@Override
					public GraphQLObjectType getType(Object object) {
						// TODO Auto-generated method stub
						String entity_type = ((ObjectTB)object).getEntity_type();
						if (entity_type.equals("Company")) {
	                        return company;
	                    }
						if (entity_type.equals("Person")) {
	                        return person;
	                    }
						if (entity_type.equals("Product")) {
	                        return ProductsType;
	                    }
						if (entity_type.equals("FinancialOrg")) {
	                        return FinancialOrg;
	                    }
						return null;
					}
					 
				 })
				 .build();
	
	
	
	
	
	//web type
	public static GraphQLObjectType webType = newObject()
			.name("webinfo")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("source_url").type(GraphQLString).build())
			.field(newFieldDefinition().name("source_description").type(GraphQLString).build())
			.build();
	
	//funding  rounding raise
	public static GraphQLObjectType fundingRaise = newObject()
			.name("fundingRaiseInfo")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("raised_currency_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("raised_amount").type(GraphQLBigInteger).build())
			.build();
	
	//valuation info
	public static GraphQLObjectType valuationInfo = newObject()
			.name("funding_valuationInfo")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("pre_money_valuation_usd").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("pre_money_valuation").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("pre_money_currency_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("post_money_valuation_usd").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("post_money_valuation").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("post_money_currency_code").type(GraphQLString).build())
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
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
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
			.field(newFieldDefinition().name("funding_round_type").type(GraphQLString).build())
			.field(newFieldDefinition().name("funding_round_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("raised_info").type(fundingRaise).build())
			.field(newFieldDefinition().name("valuationInfo").type(valuationInfo).build())
			.field(newFieldDefinition().name("participants").type(GraphQLInt).build())
			.field(newFieldDefinition().name("is_first_round").type(GraphQLBoolean).build())
			.field(newFieldDefinition().name("is_last_round").type(GraphQLBoolean).build())
			.field(newFieldDefinition().name("weburl").type(webType).build())
			.build();
	
	
	//funds refer to cb_funds about person 
	public static GraphQLObjectType funds = newObject()
			.name("funds_info")
			.description("who funds the company at what tiem")
			.field(newFieldDefinition().name("funds_id").type(GraphQLString).build())
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(GraphQLString).build())
			.field(newFieldDefinition().name("funds_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("raised_info").type(fundingRaise).build())
			.field(newFieldDefinition().name("weburl").type(webType).build())
			.build();
			
	//cb_invsetments describe the relationship  of   company and person.  And funding_round_id refer to cb_funding_rounds
	public static GraphQLObjectType investments = newObject()
			.name("Investments")
			.description("one company to many person    or one person to many company")
			.field(newFieldDefinition().name("funding_round_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("funded_object_id").type(new GraphQLList(GraphQLString)).build())
			.field(newFieldDefinition().name("investor_object_id").type(new GraphQLList(GraphQLString)).build())
			.build();
	
	//degree type refer to person
	public static GraphQLObjectType degree = newObject()
			.name("Degree")
			.description("degree info about person")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("degree_type").type(GraphQLString).build())
			.field(newFieldDefinition().name("subject").type(GraphQLString).build())
			.field(newFieldDefinition().name("institution").type(GraphQLString).build())
			.field(newFieldDefinition().name("graduated_at").type(GraphQLString).build())
			.build();
	
	
	//offices type refer to company
	public static GraphQLObjectType offices = newObject()
			.name("Offices")
			.description("offices info about company")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("office_id").type(GraphQLInt).build())
			.field(newFieldDefinition().name("description").type(GraphQLString).build())
			.field(newFieldDefinition().name("region").type(GraphQLString).build())
			.field(newFieldDefinition().name("address1").type(GraphQLString).build())
			.field(newFieldDefinition().name("address2").type(GraphQLString).build())
			.field(newFieldDefinition().name("city").type(GraphQLString).build())
			.field(newFieldDefinition().name("zip_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("state_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("country_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("latitude").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("longitude").type(GraphQLBigInteger).build())
			.build();
	
	//acquisitions refer to company
	public static GraphQLObjectType acquisitions = newObject()
			.name("Acquisitions")
			.description("Acquisitions info about company")
			.field(newFieldDefinition().name("acquiring_object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("acquired_object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("term_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("price_amount").type(GraphQLString).build())
			.field(newFieldDefinition().name("price_currency_code").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("acquired_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("weburl").type(webType).build())
			.build();
	
	//ipos refer to company
	public static GraphQLObjectType ipos = newObject()
			.name("Ipos")
			.description("ipos info about company")
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("valuation_amount").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("valuation_currency_code").type(GraphQLString).build())
			.field(newFieldDefinition().name("raisedinfo").type(fundingRaise).build())			
			.field(newFieldDefinition().name("public_at").type(GraphQLString).build())
			.field(newFieldDefinition().name("stock_symbol").type(GraphQLString).build())
			.field(newFieldDefinition().name("weburl").type(webType).build())
			.build();
	
	
	
	
	/********************************/	
	//product list
	public static GraphQLObjectType  ProductsType = newObject()
			.name("Products")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(new GraphQLList(GraphQLString)).build())
			.field(newFieldDefinition().name("parent_id").type(GraphQLString).build())
			.field(newFieldDefinition().name("refer_companys").type(new GraphQLList(objectEntity)).build())
			.field(newFieldDefinition()
					.name("refer_info")
					.type(new GraphQLList(objectEntity))
					.dataFetcher(DataFetch_All.companysFetcher)
					.build())
			.build();
			
	
	
	//cb_people(person interface objectEntity)			一个独立的实体
	public static GraphQLObjectType person = newObject()
			.name("PeopleInfo")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(GraphQLBigInteger).build())
			.field(newFieldDefinition().name("object_id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("first_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("last_name").type(GraphQLString).build())
			.field(newFieldDefinition().name("birthplace").type(GraphQLString).build())
			.field(newFieldDefinition().name("affiliation_name").type(GraphQLString).build())
			.field(newFieldDefinition()
					.name("refer_info")
					.type(new GraphQLList(objectEntity))
					.dataFetcher(DataFetch_All.companysFetcher)
					.build())
			.field(newFieldDefinition()
					.name("degree_info")
					.type(degree)
					.dataFetcher(DataFetch_All.degreeFetcher)
					.build())			
			.build();
	
	//cb_objects(company interface objectEntity)
	public static GraphQLObjectType  company = newObject()
			.name("Company")
			.withInterface(objectEntity)
			.field(newFieldDefinition().name("id").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("normalized_name").type(new GraphQLNonNull(GraphQLString)).build())
			.field(newFieldDefinition().name("domain").type(GraphQLString).build())
			.field(newFieldDefinition().name("homepageurl").type(GraphQLString).build())
			.field(newFieldDefinition().name("overview").type(GraphQLString).build())
			.field(newFieldDefinition().name("founded_at").type(GraphQLString).build())
			//.field(newFieldDefinition().name("allProducts").type(new GraphQLList(ProductsType)).build())
			.field(newFieldDefinition().name("funding_rounds").type(GraphQLInt).build())
			//.field(newFieldDefinition().name("fundingRounds_info").type(new GraphQLList(funding_Rounds)).build())
			//.field(newFieldDefinition().name("officeinfo").type(new GraphQLList(offices)).build())
			.field(newFieldDefinition()
					.name("refer_info")
					.type(new GraphQLList(objectEntity))
					.dataFetcher(DataFetch_All.companysFetcher)
					.build())
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
			.field(newFieldDefinition().name("funds_info").type(new GraphQLList(funds)).build())
			.field(newFieldDefinition().name("refer_companys").type(new GraphQLList(objectEntity)).build())
			.field(newFieldDefinition().name("refer_persons").type(new GraphQLList(objectEntity)).build())
			.field(newFieldDefinition()
					.name("refer_info")
					.type(new GraphQLList(objectEntity))
					.dataFetcher(DataFetch_All.companysFetcher)
					.build())
			 /**
			  *。。。other base type 
			  */
			.build();
			
			
	//api?
	public GraphQLFieldDefinition QueryPeopleInfo()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("people_info")
				.type(person)
				.argument(newArgument().name("object_id").type(GraphQLString).build())
				.argument(newArgument().name("name").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.peopleInfoFetcher)
				.build();
	}

	//
	public GraphQLFieldDefinition Queryquestion_1()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("team_info")
				.type(funding_Rounds)
				.argument(newArgument().name("funding_roundtype").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.f_roundsFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_2()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("company_info")
				.type(new GraphQLList(company))
				.argument(newArgument().name("id").type(GraphQLString).build())
				.argument(newArgument().name("name").type(GraphQLString).build())
				.argument(newArgument().name("normalized_name").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.companysFetcher)
				.build();
		
	}
	public GraphQLFieldDefinition Queryquestion_3()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("relationship_info")
				.type(rshipTargetType)
				.argument(newArgument().name("r_object_id").type(GraphQLString).build())
				.argument(newArgument().name("r_person_id").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.relationFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_4()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("degree_info")
				.type(degree)
				.argument(newArgument().name("person_object_id").type(GraphQLString).build())
				.argument(newArgument().name("institution").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.degreeFetcher)
				.build();		
	}
	
	public GraphQLFieldDefinition Queryquestion_5()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("investments")
				.type(investments)
				.argument(newArgument().name("funded_object_id").type(GraphQLString).build())
				.argument(newArgument().name("investor_object_id").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.investmentFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_6()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("fundsinfo")
				.type(funds)
				.argument(newArgument().name("object_id").type(GraphQLString).build())
				.argument(newArgument().name("funded_id").type(GraphQLBigInteger).build())
				.dataFetcher(DataFetch_All.fundsFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_7()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("milestones_info")
				.type(milesStonesType)
				.argument(newArgument().name("object_id").type(GraphQLString).build())
				.dataFetcher(DataFetch_All.milestoneFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_8()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("ipos_info")
				.type(ipos)
				.argument(newArgument().name("object_id").type(GraphQLString).build())
				.argument(newArgument().name("ipo_id").type(GraphQLBigInteger).build())
				.dataFetcher(DataFetch_All.iposFetcher)
				.build();
	}
	
	public GraphQLFieldDefinition Queryquestion_9()
	{
		return GraphQLFieldDefinition.newFieldDefinition()
				.name("office_info")
				.type(offices)
				.argument(newArgument().name("object_id").type(GraphQLString).build())
				.argument(newArgument().name("office_id").type(GraphQLBigInteger).build())
				.dataFetcher(DataFetch_All.iposFetcher)
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
						.field(Queryquestion_1())
						.field(Queryquestion_2())
						.field(Queryquestion_3())
						.field(Queryquestion_4())
						.field(Queryquestion_5())
						.field(Queryquestion_6())
						.field(Queryquestion_7())
						.field(Queryquestion_8())
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
