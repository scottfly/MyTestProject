package src;

import java.sql.Connection;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.jooq.Table;
import org.jooq.UpdateQuery;
import org.jooq.impl.DSL;
import com.jolbox.bonecp.BoneCP;

import src.DB_ConnectPool;

public class DataF_cb_relationship {

	private DSLContext dslContext= null;
    //获取DSLContext对象
    private DSLContext getdslContext()
    {
    	BoneCP boneCP = DB_ConnectPool.getBoneCP();
        Connection connection = DB_ConnectPool.getConnection(boneCP);
        dslContext = DSL.using(connection);
        return dslContext;
    }
    
  //原生态的sql查询
    public Result<Record> getAllid(String personid,String companyid)
    {
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_relationships");//表名
        
        Result<Record> res = getdslContext.select().from(table).where("person_object_id =  '"+personid+"' ")
        										.or("relationship_object_id = '"+companyid +"'")
        										.orderBy(DSL.field("relationship_id"))
        										.fetch();
        	
    	return res;
    }
    
    //原生态的sql查询
    public Result<Record> getCompanyid(String personid)
    {
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_relationships");//表名
        
        Result<Record> res = getdslContext.select().from(table).where("person_object_id =  '"+personid+"' ")       					
        										.orderBy(DSL.field("relationship_id"))
        										.fetch();
        	
    	return res;
    }
    
    //原生态的sql查询
    public Result<Record> getPersonid(String companyid)
    {
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_relationships");//表名
        
        Result<Record> res = getdslContext.select().from(table).where("relationship_object_id = '"+companyid +"'")
        										.orderBy(DSL.field("relationship_id"))
        										.fetch();
        	
    	return res;
    }
    
    
}
