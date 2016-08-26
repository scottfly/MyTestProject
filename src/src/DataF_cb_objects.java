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
public class DataF_cb_objects {

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
    public Result<Record> getVal(String type)
    {
        DSLContext getdslContext = getdslContext();
        Table<Record> table = DSL.table("cb_objects");//表名
        Result<Record> res = getdslContext.select().from(table).where("entity_type = '"+type+"'").and("milestones = 1").orderBy(DSL.field("first_milestone_at").asc()).fetch();
        
        return res;
        /*for (Object aResult : fetch) {
            Record record = (Record) aResult;
            System.out.println(record);
        }*/
        /*Map<String, Object> fetchAnyMap = orderBy.fetchAnyMap();
        Set<String> keySet = fetchAnyMap.keySet();
        for(String s:keySet)
        {
            System.out.println("key--"+s+"--val:"+fetchAnyMap.get(s));
        }*/
    }
    
    
    
}
