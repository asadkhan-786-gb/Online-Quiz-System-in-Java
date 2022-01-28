package oes.db;
import java.sql.*;
public class Provider {
    public static Connection getOracleConnection()
    {
        Connection con = null;
	try
        { 
            Class.forName("oracle.jdbc.OracleDriver");
            
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pass123");
	    System.out.println("Connection successful!");
	}catch (Exception e) {System.out.println(e);}
    return con;
    }
}
	