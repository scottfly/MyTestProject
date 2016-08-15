package src;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import java.util.Map;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphQLSchema schema = new ProjectSchema().getSchema();
		
		
	}

}
