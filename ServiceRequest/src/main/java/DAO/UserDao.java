package DAO;

import java.io.IOException;
import java.sql.*;
import java.util.Set;

import javax.servlet.RequestDispatcher;

import model.AccountBean;
import model.ActivityBean;
import model.ContactBean;
import model.ServiceBean;

public class UserDao
{
        Boolean status = false; 
        static Connection con;
	public static PreparedStatement ps;
	ResultSet rs;
	
	//static student s;
	public UserDao() throws SQLException, IOException
	{
		con = util.DbConnection.getConnection();
	}
	 public ResultSet selectService(ServiceBean ab) throws SQLException
     {
     	con = util.DbConnection.getConnection();
     	PreparedStatement pstmt = con.prepareStatement("select * from ServiceRequest where CloseDate is null");
     	rs = pstmt.executeQuery();
         return rs;    
     }
	 public ResultSet logs(ActivityBean ab) throws SQLException
     {
     	con = util.DbConnection.getConnection();
     	PreparedStatement pstmt = con.prepareStatement("select * from Activity");
     	rs = pstmt.executeQuery();
         return rs;    
     }
	 public ResultSet solvedService(ServiceBean service) throws SQLException
     {
     	con = util.DbConnection.getConnection();
     	PreparedStatement pstmt = con.prepareStatement("select * from ServiceRequest where CloseDate is not null");
     	rs = pstmt.executeQuery();
         return rs;    
     }
        
     public  static ServiceBean  getServiceDetails(String id)
     {
     	ServiceBean s=new ServiceBean();
     	try {
				con = util.DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from ServiceRequest where Id=?"); 
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){  
					s.setId(rs.getString(1));
	                s.setTitle(rs.getString(2));
	                s.setAccountid(rs.getString(3));
	                s.setContactid(rs.getString(4)); 
	                s.setStatus(rs.getString(5));
	                s.setOpendate(rs.getTimestamp(6));  
	                s.setClosedate(rs.getTimestamp(7)); 
	                s.setDescription(rs.getString(8));
	              
	            }  
			
     
     
}
     	catch(Exception e) {
     		System.out.println(e);
     	}
			return s;
     }
     public static int updateCloseDate(ServiceBean s) throws SQLException
     {
    	    
	     Connection	con = util.DbConnection.getConnection();
	       PreparedStatement  ps = con.prepareStatement("update ServiceRequest set CloseDate=? where Id=?");
	         
	    
	
	         ps.setTimestamp(1,s.getClosedate());
	         ps.setString(2,s.getId());
	         
	         int status1 = ps.executeUpdate();
	         
	        System.out.println(s.getId());
	        System.out.println(s.getClosedate());
	         return status1;
     }
     public static int updateService(ServiceBean s) throws SQLException
     {
     	
    
     	con = util.DbConnection.getConnection();
         ps = con.prepareStatement("update ServiceRequest set Status=? where Id=?");
         
    
         ps.setString(1,s.getStatus());
       
         ps.setString(2,s.getId());
         
         int status1 = ps.executeUpdate();
         
       //  System.out.println(s.getUserid());
         return status1;
     }
    
        
        public ResultSet selectCustomer(AccountBean ab) throws SQLException
        {
        	con = util.DbConnection.getConnection();
        	PreparedStatement pstmt = con.prepareStatement("select * from Account a,ServiceRequest s where a.AccountId=s.AccountId ");
        	rs = pstmt.executeQuery();
            return rs;    
        }
       public  static AccountBean  getDetails(String id)
        {
        	AccountBean s=new AccountBean();
        	try {
				con = util.DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from Account where AccountId=?"); 
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){  
					s.setId(rs.getString(1));
	                s.setName(rs.getString(2));
	                s.setHouseNo(rs.getString(3));
	                s.setStreet(rs.getString(4)); 
	                s.setCity(rs.getString(5));
	                s.setState(rs.getString(6));  
	                s.setZipCode(rs.getString(7)); 
	                s.setRole(rs.getString(8));
	                s.setEmail(rs.getString(9));
	                //System.out.println(rs.getString(6));
	            }  
			
        
        
}
        	catch(Exception e) {
        		System.out.println(e);
        	}
			return s;
        }
       public static int updateCustomer(AccountBean s) throws SQLException
       {
       	
      
       	con = util.DbConnection.getConnection();
           ps = con.prepareStatement("update Account set Name=?,HouseNo=?,Street=?,city=?,State=?,ZipCode=?,Role=?,Email=? where AccountId=?");
           
      
           ps.setString(1,s.getName());
           ps.setString(2,s.getHouseNo());
           ps.setString(3,s.getStreet());
           ps.setString(4,s.getCity());
           ps.setString(5,s.getState());
           ps.setString(6,s.getZipCode());
           ps.setString(7,s.getRole());
           ps.setString(8,s.getEmail());
           ps.setString(9,s.getId());
           
           int status1 = ps.executeUpdate();
           
         //  System.out.println(s.getUserid());
           return status1;
       }
       public Boolean insertService(ServiceBean s) throws SQLException, IOException
       {
       	con = util.DbConnection.getConnection();
        Date date = new Date(0);
        System.out.println(new Timestamp(date.getTime()));
           ps = con.prepareStatement("insert into ServiceRequest values(?,?,?,?,?,?,?,?)");
           ps.setString(1,s.getId());
           ps.setString(2,s.getTitle());
           ps.setString(3,s.getAccountid());
           ps.setString(4,s.getContactid());
           ps.setString(5,s.getStatus());
           ps.setTimestamp(6,s.getOpendate());
           ps.setTimestamp(7,s.getClosedate());
           ps.setString(8,s.getDescription());
          int generatedkey=0;
           int a = ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if (rs.next()) {
              generatedkey=rs.getInt(1);   
                      System.out.println("hi user...Auto Generated Primary Key " + generatedkey);
                     
                     
           }
          
  
          // int a = ps.executeUpdate();
           if (a == 1)
           {
               status = true;
           }	
	return status;		
       }
       public Boolean insertActivity(ActivityBean s) throws SQLException, IOException
       {
       	con = util.DbConnection.getConnection();
    
           ps = con.prepareStatement("insert into Activity values(?,?,?,?)");
           ps.setString(1,s.getId());
           ps.setString(2,s.getSrid());
           ps.setTimestamp(3,s.getUpdateddate());
           ps.setString(4,s.getUpdate());
         
   
           int a = ps.executeUpdate();
           
       
           if (a == 1)
           {
               status = true;
           }	
	return status;		
       }



	private void getCurrentTimeStamp() {
		// TODO Auto-generated method stub
		
	}
       

    public static int deleteCustomer(String id) throws SQLException
    {
   
          con = util.DbConnection.getConnection();
        ps = con.prepareStatement("delete from Account where AccountId=?");
        
       
        ps.setString(1,id);
        
        int status1 = ps.executeUpdate();
        
        return status1;
    }
          
          
  }