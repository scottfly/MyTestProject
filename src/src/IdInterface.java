package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class IdInterface {

	public interface ObjectID{
		String getObjectID();
	}
	
	
	public static class Products implements ObjectID{
		
		private final String objectid;

		public Products (String objectid){
			this.objectid = objectid;
		}
		
		@Override
		public String getObjectID() {
			// TODO Auto-generated method stub
			return objectid;
		}
		
	}
			
	public static class FinancialOrg implements ObjectID{
		private final String objectid;
		
		public FinancialOrg (String objectid){
			this.objectid = objectid;
		}

		@Override
		public String getObjectID() {
			// TODO Auto-generated method stub
			return objectid;
		}
	}

	
	public static class Company implements ObjectID{

		private final String objectid;

		public Company (String objectid){
			this.objectid = objectid;
		}
			
		@Override
		public String getObjectID() {
			// TODO Auto-generated method stub
			return objectid;
		}
		
		
	}
	
	public static class Person implements ObjectID{
		private final String objectid;
		
		public Person (String objectid){
			this.objectid = objectid;
		}

		@Override
		public String getObjectID() {
			// TODO Auto-generated method stub
			return objectid;
		}
		
		
	}
	
	
	
	
}
