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

public class Data_cb_degrees {
	
	private DSLContext dslContext= null;
    //获取DSLContext对象
    private DSLContext getdslContext()
    {
    	BoneCP boneCP = DB_ConnectPool.getBoneCP();
        Connection connection = DB_ConnectPool.getConnection(boneCP);
        dslContext = DSL.using(connection);
        return dslContext;
    }
    
    //
    public Result<Record> getDegreesInfo(String objectid)
    {
    	
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_degrees");//表名
        
        Result<Record> res = getdslContext.select().from(table).where("object_id = '"+ objectid +"'")
        											.orderBy(DSL.field("id"))
        											.fetch();    		
    	
    	return res;
    	
    }

}
