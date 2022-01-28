package oes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oes.db.Provider;
import oes.db.Students;

public class StudentsDao {

	public static boolean doValidate(Students sd) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "select * from studenttable where userid=? and password=?";//SQL
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, sd.getUsername());
		pst.setString(2, sd.getPassword());
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
		{
			sd.setName(rs.getString("name"));
			status = true;
		}
		else
		{
			status = false;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	public static boolean insertStudent(Students st) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "insert into studenttable values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, st.getUsername());
		pst.setString(2, st.getPassword());
		pst.setString(3, st.getName());
		int val = pst.executeUpdate();
		if(val > 0)
		{
			status = true;
		}
		else
		{
			status = false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static ArrayList<Students> getAllRecords()
	{
        ArrayList<Students>  samp =new ArrayList<Students>();
		try
		{
			
		   samp.clear();
		   Connection con = Provider.getOracleConnection();
		   String sql = "select * from studenttable";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   while(rs.next())
		   {
			  Students s = new Students();
			   s.setUsername(rs.getString(1));
			  s.setPassword(rs.getString(2));
			  s.setName(rs.getString(3));
			   samp.add(s);
			 
			  
			   
		   }
		  

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return samp;
	}
	public static int deleteRecord(Students st) {
		// TODO Auto-generated method stub
		int status = 0;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "delete from  studenttable where userid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, st.getUsername());
	
		int val = pst.executeUpdate();
		if(val > 0)
		{
			status = 1;
		}
		else
		{
			status = 0;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static String getStudentName(String username) {
		// TODO Auto-generated method stub
		String name = null;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "select name from studenttable where userid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,username);
	
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			name = rs.getString(1);
		}
		else
		{
			name="DB-Error";
		}
		
	    }
		catch(Exception e)
		{
			name = e.getMessage();
		}
		return name;

   }
	public static int doUpdateNowRecord(String originalusername,String newuserid,String newpassword,String newname)
	{
		int status = 0;
		try
		{
		
		Connection con = Provider.getOracleConnection();
		String sql = "update studenttable set userid=?,password=?,name=? where userid=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,newuserid);
		pst.setString(2, newpassword);
		pst.setString(3, newname);
		pst.setString(4, originalusername);
	
		int val = pst.executeUpdate();
		if(val > 0)
		{
			status = 1;
		}
		else
		{
			status = -1;
		}
		}
		catch(Exception f)
		{
			status = 2;
			f.printStackTrace();
		}
		
	    
		return status;
	}
		
}
