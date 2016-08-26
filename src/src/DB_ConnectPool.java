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
    // ��̬�������������ļ�
    static {
    	
    	// ����JDBC����  
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");// ע�����ݿ�  
            boneCPConfig = new BoneCPConfig();// bonecp���ݿ����ӳ�����  
            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/crunchbase";
            boneCPConfig.setJdbcUrl(jdbcUrl);  
            boneCPConfig.setUser("root");  
            boneCPConfig.setPassword("123456");  
            // ���ݿ����ӳص���С������  
            boneCPConfig.setMinConnectionsPerPartition(5);  
            // ���ݿ����ӳص����������  
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
    // ��ȡ���ӳ�  
    public static BoneCP getBoneCP() {  
        try {  
            boneCp = new BoneCP(boneCPConfig);  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return boneCp;  
    }
    
    
 // ��ȡ����  
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
    
 // �ر����ӳ�  
    public static void closeBoneCP(BoneCP bc) {  
        bc.close();  
    }  
  
    // �ر�����  
    public static void closeConnection(Connection con) throws SQLException {  
        con.close();  
    }  
  
    //  
    public static DSLContext getContext(Connection conDsl) {  
        return DSL.using(conDsl);  
    }  
     
	
}
