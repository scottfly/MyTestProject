package src;

import graphql.schema.*;
import src.*;
import src.Db.Acquisitions;
import src.Db.Degrees;
import src.Db.Funding_Rounds;
import src.Db.Funds;
import src.Db.Ipos;
import src.Db.Milestones;
import src.Db.ObjectTB;
import src.Db.Offices;
import src.Db.PeopleTB;
import src.Db.Relationships;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Record;
import org.jooq.Result;

import java.util.Collections;
import java.util.Collections;
import java.math.BigInteger;
import java.sql.Date;

public class DataFetch_All {

	//cb_people
	static  DataFetcher peopleInfoFetcher = new DataFetcher()
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String objectid = environment.getArgument("object_id");
			String name=""; // = environment.getArgument("name");
			if(name.isEmpty() && objectid.isEmpty())
			{
				return null;
			}
			//List<PeopleTB> respeopleInfo = new ArrayList<PeopleTB>();
			PeopleTB peo = new PeopleTB();
			
			DataF_cb_people people = new DataF_cb_people();
			Result<Record>  res_peoples = people.getPersonInfo(objectid);
			
			for(Object aResult : res_peoples){
				Record record = (Record) aResult;
								
				peo.setId((Long) record.getValue("id"));
				peo.setObject_id((String)record.getValue("object_id"));
				peo.setFirst_name((String)record.getValue("first_name"));
				peo.setLast_name((String)record.getValue("last_name"));
				peo.setAffiliation_name((String)record.getValue("affiliation_name"));
				peo.setBithplace((String)record.getValue("birthplace"));
								
			}

			return peo;
		}
	};			
	
	//cb_relationship
	static DataFetcher relationFetcher = new DataFetcher()	
	{

		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
			String person_id = environment.getArgument("object_id");
			List<Relationships> relationInfo = new ArrayList<Relationships>();
			DataF_cb_relationship relation = new DataF_cb_relationship();
			Result<Record> relation_objectid;
			
			if(company_id.isEmpty() && person_id.isEmpty())
			{
				return null;
			}
			else if(!company_id.isEmpty() && person_id.isEmpty())
			{
				relation_objectid = relation.getPersonid(company_id);
			}
			else if(!person_id.isEmpty() &&  company_id.isEmpty())
			{
				relation_objectid = relation.getCompanyid(person_id);
			}
			else
			{
				relation_objectid = relation.getAllid(person_id,company_id);
			}
			
			for(Object aResult : relation_objectid){
				Record record = (Record) aResult;
				String re_companyid =(String)record.getValue("relationship_object_id");
				String re_personid = (String)record.getValue("person_object_id");
				
				Relationships reships = new Relationships();
				reships.setPerson_object_id(re_personid);
				reships.setRelationship_object_id(re_companyid);
				
				relationInfo.add(reships);			
			}							
			return relationInfo;
		}
	}; 
	
	//cb_objects
	static DataFetcher companysFetcher = new DataFetcher()	
	{

		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String object_id = environment.getArgument("object_id");
			
			List<ObjectTB> companyInfos = new ArrayList<ObjectTB>();
			DataF_cb_objects company_object = new DataF_cb_objects();
			Result<Record> res_companys;
			
			if(object_id.isEmpty())
			{
				return null;
			}
			
			res_companys = company_object.getCompanyInfo(object_id);
			
			for(Object aResult : res_companys){
				Record record = (Record) aResult;
				ObjectTB objectinfo = new ObjectTB();
				
				objectinfo.setEntity_id((Long)record.getValue("entity_id"));
				objectinfo.setName((String)record.getValue("name"));
				objectinfo.setNormalized_name((String)record.getValue("normalized_name"));
				objectinfo.setPermalink((String)record.getValue("permalink"));
				objectinfo.setFounded_at((Date)record.getValue("founded_at"));
				objectinfo.setDomain((String)record.getValue("domain"));
				objectinfo.setHomepage_url((String)record.getValue("homepage_url"));
				objectinfo.setLogo_url((String)record.getValue("logo_url"));
				objectinfo.setOverview((String)record.getValue("overview"));
				objectinfo.setCity((String)record.getValue("city"));
				objectinfo.setFunding_rounds((int)record.getValue("funding_rounds"));
				objectinfo.setRelationships((int)record.getValue("relationships"));
				objectinfo.setInvestment_rounds((int)record.getValue("investment_rounds"));
				objectinfo.setInvested_companies((int)record.getValue("invested_companies"));
				objectinfo.setMilestones((int)record.getValue("milestones"));
				
				companyInfos.add(objectinfo);				
			}									
			return companyInfos;
		}
	};
	
	static DataFetcher degreeFetcher = new DataFetcher()
	{

		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String person_id = environment.getArgument("");
			
			List<Degrees> degreeInfo = new ArrayList<Degrees>();
			/**/
			return degreeInfo;
		}

	};
	
	static DataFetcher f_roundsFetcher = new DataFetcher()	
	{

		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String f_roundstype = environment.getArgument("");
			
			List<Funding_Rounds> roundsInfo = new ArrayList<Funding_Rounds>();
			return roundsInfo;
		}

	}; 
	

	static DataFetcher investmentFetcher = new DataFetcher()	
	{

		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
			String person_id = environment.getArgument("");
			int funding_roundid = environment.getArgument("");
					
			List<Relationships> investmentInfo = new ArrayList<Relationships>();
			
			return investmentInfo;
		}

	}; 
	
	static DataFetcher officeFetcher = new DataFetcher()	
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
				
			List<Offices> officeInfo = new ArrayList<Offices>();
			
			return officeInfo;
		}
	};

	static DataFetcher milestoneFetcher = new DataFetcher()	
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
				
			List<Milestones> milestoneInfo = new ArrayList<Milestones>();
			
			return milestoneInfo;
		}
	};
	
	static DataFetcher iposFetcher = new DataFetcher()	
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
			Long ips_id = environment.getArgument("");
				
			List<Ipos> iposInfo = new ArrayList<Ipos>();
			
			return iposInfo;
		}
	};
	static DataFetcher fundsFetcher = new DataFetcher()	
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			// TODO Auto-generated method stub
			String company_id = environment.getArgument("");
			Long fund_id = environment.getArgument("");
				
			List<Funds> fundsInfo = new ArrayList<Funds>();
			
			return fundsInfo;
		}
	};
	static DataFetcher acqFetcher = new DataFetcher()	
	{
		@Override
		public Object get(DataFetchingEnvironment environment) {
			
			// TODO Auto-generated method stub
			String acquisition_object_id = environment.getArgument("");
			String acquired_object_id = environment.getArgument("");
			Long acquisition_id = environment.getArgument("");
				
			List<Acquisitions> acqInfo = new ArrayList<Acquisitions>();
			
			return acqInfo;
		}
	};
	
}
