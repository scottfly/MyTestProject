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

import src.Db.*;
import graphql.schema.*;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLSchema;


public class ProjectSchema {
	
	//
	
	
	
	
	
	
	
	
	//
	private  GraphQLSchema schema;
	
	//初始化schema
	public ProjectSchema()
	{
		schema = GraphQLSchema.newSchema()
				.query(null)
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
