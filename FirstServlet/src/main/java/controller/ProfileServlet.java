package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    //TODO Enable https for your app. set httOnly and secure flags for jsession cookie
	private Connection con;
  
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	
    
	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
	
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Cache-Control","no-store");
		  response.setHeader("Pragma","no-cache");
		  response.setDateHeader ("Expires", 0);
		 
		 HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }
			

		

		  String email= (String) request.getSession(false).getAttribute("user");
				   FirstServletLogger.FILE_LOGGER.debug("user email is:"+email);
		 
		  
     		
		 try {
             con = util.DbConnection.getConnection();
		 
         out.print("<html>");
         
         out.print("<head>");
			out.print("<meta charset=\"UTF-8\">\n" + 
					"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
					"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
					"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" + 
					"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
			
			out.print("<nav class=\"navbar navbar-inverse\">\n" + 
					"  <div class=\"container-fluid\">\n" + 
					"    <div class=\"navbar-header\">\n" + 
					"      <a class=\"navbar-brand\" href=\"#\">Customer Support</a>\n" + 
					"    </div>\n" + 
					"    <ul class=\"nav navbar-nav\">\n" + 
					"      <li><a href=\"index.jsp\">Home</a></li>\n" + 
					"      <li><a href=\"ProfileServlet\">Profile</a></li>\n" + 
					"      <li><a href=\"AddCustomer.jsp\">Add customers</a></li>\n" + 
					"      <li><a href=\"ViewCustomersServlet\">view customers</a></li>\n" + 
					"       <li><a href=\"ViewServiceServlet\"> request Tickets</a></li>\n" + 
					"       <li><a href=\"SolvedServiceServlet\"> Solved Tickets</a></li>\n" + 
					" <li><a href=\"LogServlet\">Service Logs</a></li>\n" + 
					"        <li><a href=\"LogoutServlet\">Logout</a></li>\n" + 
					"    </ul>\n" + 
					"  </div>\n" + 
					"</nav>");
			out.println("</head>");
         out.print("<body>");
         out.print("<style>\n" + 
         		//".navbar\n" + 
         		//"{\n" + 
         		//"width:100%; background-color:skyblue; height:55px;\n" + 
         		//"}\n" + 
         		".dropbtn {\n" + 
         		"    background-color:grey;\n" + 
         		"    color: white;\n" + 
         		"    padding: 16px;\n" + 
         		"    font-size: 16px;\n" + 
         		"}\n" + 
         		"footer {\n" + 
         		"      background-color: #555;\n" + 
         		"      color: white;\n" + 
         		"      padding: 15px;\n" + 
         		"    }"+
         		".nav.navbar-nav li a {\n" + 
         		"   color: #fff;\n" + 
         		" }\n" + 
         		"\n" + 
         		".nav.navbar-nav a:hover {\n" + 
         		" color: grey;\n" + 
         		"}"+
         
         		"</style>\n" + 
         		"<div class=\"navbar\"> \n");
    		
        
         out.print(" <table class='table table-hover table-bordered'>");
         out.print("<center><h1>Profile</h1></center>");

        PreparedStatement prepared=con.prepareStatement("select * from User where Mail=?");
         prepared.setString(1,email);
         ResultSet rs1=prepared.executeQuery();                
          ResultSetMetaData rsmd=rs1.getMetaData();
         while(rs1.next())
            {
            out.print("<tr>");
            out.print("<td>"+rsmd.getColumnName(1)+"</td>");
            out.print("<td>"+rs1.getString(1)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
            out.print("<td>"+rs1.getString(2)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
            out.print("<td>"+rs1.getString(3)+"</td></tr>");
            out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
            out.print("<td>"+rs1.getString(4)+"</td></tr>");   
            out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
            out.print("<td>"+rs1.getString(5)+"</td></tr>");  
            out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
            out.print("<td>"+rs1.getString(6)+"</td></tr>");  

         }

         out.print("</table>");
         out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
         
         out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
         out.print("</html>");
   

		 }
		 catch(Exception e) { 
			
			   FirstServletLogger.FILE_LOGGER.debug("exception is: "+e);
			
			 
		 }
     		}
	
	
	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	
	}

}