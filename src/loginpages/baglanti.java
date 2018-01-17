/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loginpages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class baglanti {

    Connection conn = null;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String DB_CONNECTION = "jdbc:mysql://10.234.178.46:3306/javatest";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/javatest";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    
    public static Connection baglan() throws ClassNotFoundException, SQLException{
        
        Class.forName(DB_DRIVER);
        Connection conn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        return conn;
        
    }
    
    
   public static void baglantiKapat(Connection conn) throws SQLException{
       
       conn.close();
    }
   
   
    
    
    
}
