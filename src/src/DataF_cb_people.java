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


/**
 * 
 * @author scottfly
 * 简单的增删改查
 */

public class DataF_cb_people {

	private DSLContext dslContext= null;
    //获取DSLContext对象
    private DSLContext getdslContext()
    {
    	BoneCP boneCP = DB_ConnectPool.getBoneCP();
        Connection connection = DB_ConnectPool.getConnection(boneCP);
        dslContext = DSL.using(connection);
        return dslContext;
    }
    
  //简单实体查询  一种方法
    public Result<Record> getPersonInfo(String objectid)
    {
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_people");
        Result<Record> res = getdslContext.select().from(table).where("object_id = '"+objectid+"' ").fetch();    	
        
        return res;
        /*for (Object aResult : fetch) {
            Record record = (Record) aResult;
            System.out.println(record);
            System.out.print(record.getValue("first_name"));
            System.out.println(record.getValue("last_name"));
        }*/
      }
    
    
    //验证DSL.exists方法
    public void exits()
    {
        DSLContext getdslContext = getdslContext();
      
        Condition condition = DSL.exists(DSL.select(DSL.field("username1")));
        Table<Record> table = DSL.table("shangfox_user");
        SelectQuery<Record> selectQuery = getdslContext.selectQuery(table);
        selectQuery.addConditions(condition);
        Result<Record> fetch = selectQuery.fetch();
        for (Object aResult : fetch) {
            Record record = (Record) aResult;
            System.out.println(record);
            System.out.println(record.getValue("username"));
        }
    }
    
    
    
	
}
