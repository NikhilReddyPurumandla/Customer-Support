package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DbConnection {

    static Connection con;
  
    public static Connection getConnection() throws SQLException
    {
    	
        if (con == null)
        	   try
        {
        Properties props = new Properties();
  
        InputStream in = DbConnection.class.getResourceAsStream("../Jdbc.properties");
        	//FileInputStream in =(FileInputStream) DbConnection.class.getResourceAsStream("Jdbc.properties");
        	props.load(in);
        	in.close();

        	String driver = props.getProperty("MYSQLJDBC.driver");
        	if (driver != null) {
        	    Class.forName(driver) ;
        	}

        	String url = props.getProperty("MYSQLJDBC.url");
        String username = props.getProperty("MYSQLJDBC.username");
        String password = props.getProperty("MYSQLJDBC.password");
        con = DriverManager.getConnection(url, username, password);
            //Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return con;
    }
   
}