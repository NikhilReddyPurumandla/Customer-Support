package DAO;

import java.io.IOException;
import java.sql.*;
import java.util.Set;

import model.SignupBean;
public class ServletDAO
{
        Boolean status = false; 
        static Connection con;
	static PreparedStatement ps;
	ResultSet rs;
	//static student s;
	public ServletDAO() throws SQLException, IOException
	{
	
		con = util.DbConnection.getConnection();
	
	}
        
        public Boolean login(SignupBean s) throws SQLException, IOException
        {
        	con = util.DbConnection.getConnection();
            ps = con.prepareStatement("select * from User where Mail=? and Password=?");
            ps.setString(1, s.getEmail());
            ps.setString(2, s.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) 
            {
                 status = true;
            } 
            return status;
            
            
	 }
        
        public Boolean insert(SignupBean s) throws SQLException, IOException
        {
        	con = util.DbConnection.getConnection();
            ps = con.prepareStatement("insert into User values(?,?,?,?,?,?)");
            ps.setString(1,s.getName());
            ps.setString(2,s.getDob());
            ps.setString(3,s.getGender());
            ps.setString(4,s.getEmail());
            ps.setString(5,s.getPassword());
            ps.setString(6,s.getEducation());
            int a = ps.executeUpdate();
            if (a == 1)
            {
                status = true;
            }	
	return status;		
        }
        public  static SignupBean  getDetails(String email)
        {
        	SignupBean s=new SignupBean();
        	try {
				con = util.DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from User where Mail=?"); 
				ps.setString(1,email);
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){  
	                s.setName(rs.getString(1));
	                s.setGender(rs.getString(2));
	                s.setDob(rs.getString(3)); 
	                s.setEmail(rs.getString(4));
	                s.setPassword(rs.getString(5));  
	                s.setEducation(rs.getString(6)); 
	                System.out.println(rs.getString(6));
	            }  
			
        
        
}
        	catch(Exception e) {
        		System.out.println(e);
        	}
			return s;
        }
        public static int deleteSignupBean(String email) throws SQLException
        {
       
              con = util.DbConnection.getConnection();
            ps = con.prepareStatement("delete from User where Mail=?");
            
           
            ps.setString(1,email);
            
            int status1 = ps.executeUpdate();
            
            return status1;
        }
          
          
  }