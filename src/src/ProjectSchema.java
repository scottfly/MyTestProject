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
	
	//��ʼ��schema
	public ProjectSchema()
	{
		schema = GraphQLSchema.newSchema()
				.query(null)
				.build();
	}
	
	//����һ��schema ������һ������filed�����������ͼ��
	

	public GraphQLSchema getSchema() {
		return schema;
	}

	public void setSchema(GraphQLSchema schema) {
		this.schema = schema;
	}

}
