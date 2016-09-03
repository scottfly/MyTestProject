package src;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.net.URL;
import java.util.Map;

import org.jooq.Record;
import org.jooq.Result;

import src.DataF_cb_objects;
import src.DataF_cb_people;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphQLSchema schema = new ProjectSchema().getSchema();
		
		
		//²âÊÔ³åÍ»µÄjar
		//URL urlOfClass = MyTest.class.getClassLoader().getResource("org.slf4j.helpers.MessageFormatter.class");
		//System.out.println(urlOfClass);
        /*
		//test one table
		String query1 = "{people_info(object_id: \"p:7\") {id,object_id,first_name,last_name,birthplace,affiliation_name}}";
		
		Map<String, Object> result1 = (Map<String, Object>) new GraphQL(schema).execute(query1).getData();
		System.out.println(result1);
		*/
		//test two refer table
		String 	query2 = "{people_info(object_id: \"p:7\") {id,first_name,last_name,affiliation_name,refer_company{id,name,normalized_name,founded_at,funding_rounds}}}";
		
		Map<String, Object> result2 = (Map<String, Object>) new GraphQL(schema).execute(query2).getData();
		System.out.println(result2);
		
		System.exit(0);
		//mysql test
		DataF_cb_people people = new DataF_cb_people();
		Result<Record>  res_peoples = people.getPersonInfo("p:7");
		for(Object aResult : res_peoples){
			Record record = (Record) aResult;
			System.out.println(record.getValue("first_name"));
		}
		
		DataF_cb_objects objects = new DataF_cb_objects();
		
		Result<Record> companys = objects.getCompanyInfo("c:3");
		
		for(Object aResult : companys){
			Record record = (Record) aResult;
			System.out.print(record);
		}
		
	}
}
