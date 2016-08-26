package src;

import java.sql.Connection;  
import java.sql.SQLException;  
  
import org.jooq.DSLContext;  
import org.jooq.impl.DSL;  
  
import com.jolbox.bonecp.BoneCP;  
import com.jolbox.bonecp.BoneCPConfig; 

public class DB_ConnectPool {

    private static BoneCP boneCp = null;  
    private static BoneCPConfig boneCPConfig = null;  
    // 静态代码块加载配置文件
    static {
    	
    	// 加载JDBC驱动  
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");// 注册数据库  
            boneCPConfig = new BoneCPConfig();// bonecp数据库连接池配置  
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/crunchbase";
            boneCPConfig.setJdbcUrl(jdbcUrl);  
            boneCPConfig.setUser("root");  
            boneCPConfig.setPassword("123456");  
            // 数据库连接池的最小连接数  
            boneCPConfig.setMinConnectionsPerPartition(5);  
            // 数据库连接池的最大连接数  
            boneCPConfig.setMaxConnectionsPerPartition(10);  
            boneCPConfig.setPartitionCount(1);  
            // System.out.println("boneCPConfig"+boneCPConfig);  
        }
        catch (ClassNotFoundException e) 
        {
        	System.out.println("Excepiton in BoneCpPool,message=="+e.getMessage());
            e.printStackTrace();  
        }  
    }
    // 获取连接池  
    public static BoneCP getBoneCP() {  
        try {  
            boneCp = new BoneCP(boneCPConfig);  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return boneCp;  
    }
    
    
 // 获取连接  
    public static Connection getConnection(BoneCP boneCpP) {  
        if (boneCpP != null) {  
            try {  
                return boneCpP.getConnection();  
            } catch (SQLException e) {  
                return null;  
            }  
        } else {  
            return null;  
        }  
    }  
    
 // 关闭连接池  
    public static void closeBoneCP(BoneCP bc) {  
        bc.close();  
    }  
  
    // 关闭连接  
    public static void closeConnection(Connection con) throws SQLException {  
        con.close();  
    }  
  
    //  
    public static DSLContext getContext(Connection conDsl) {  
        return DSL.using(conDsl);  
    }  
     
	
}
