package cn.springmvc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final String DRIVER="oracle.jdbc.driver.OracleDriver"; 
	private final String URL="jdbc:oracle:thin:@192.168.149.129:1521:myorcl";  
    private final String USERNAME="scott";  
    private final String USERPWD="tiger";  
      
    Connection conn=null;  
    PreparedStatement pst=null;  
    ResultSet rs=null;  
    public Connection getConnection() throws SQLException, ClassNotFoundException{  
        if(conn==null){  
            Class.forName(DRIVER);  
            conn=DriverManager.getConnection(URL,USERNAME,USERPWD);  
        }  
        return conn;  
    }  
      
    public int executeUpdate(String sql,Object[]params) throws SQLException, ClassNotFoundException{  
        getConnection();  
        pst=conn.prepareStatement(sql);  
        if(params!=null&params.length!=0){  
            for (int i = 0; i < params.length; i++) {  
                pst.setObject(i+1, params[i]);  
            }  
        }  
        int result=pst.executeUpdate();  
        return result;  
    }  
}
