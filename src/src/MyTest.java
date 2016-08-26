package src;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import java.util.Map;

import org.jooq.Record;
import org.jooq.Result;

import src.DataF_cb_objects;
import src.DataF_cb_people;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphQLSchema schema = new ProjectSchema().getSchema();

		
		//mysql test
		DataF_cb_people people = new DataF_cb_people();
		Result<Record>  res_peoples = people.select("p:3");
		for(Object aResult : res_peoples){
			Record record = (Record) aResult;
			System.out.println(record.getValue("first_name"));
		}
		
		DataF_cb_objects objects = new DataF_cb_objects();
		
		Result<Record> companys = objects.getVal("company");
		
		for(Object aResult : companys){
			Record record = (Record) aResult;
			System.out.print(record);
		}
		
	}
}
