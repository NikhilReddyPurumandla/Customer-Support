package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.AccountBean;
import model.ServiceBean;

/**
 * Servlet implementation class ViewServiceServlet
 */
public class ViewServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        ServiceBean ab=new ServiceBean();
        HttpSession session1=request.getSession(false);
        if(session1.getAttribute("user")==null){
            response.sendRedirect("login.jsp");
        }

        try {
			UserDao ud = new UserDao();
			  ResultSet rs = ud.selectService(ab);
		
			
           
        out.print("<html>");
        
        out.print("<head>");
        out.print("<meta charset='utf-8'>"+
        		  "<meta name='viewport' content='width=device-width, initial-scale=1'>"+
        		  "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
        		  "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"+
        		  "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
      			
    			
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
    			out.println("<style>"+
						"footer {\n" + 
		         		"      background-color: #555;\n" + 
		         		"      color: white;\n" + 
		         		"      padding: 15px;\n" + 
		         		"    }"+
						"</style>"+
						 "</head>");
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
        		"body{\n" + 
        		"background-repeat:repeat;\n" + 
        		"\n" + 
        		"background-size:100%;\n" + 
        		"}"+
        		".nav.navbar-nav li a {\n" + 
         		"   color: #fff;\n" + 
         		" }\n" + 
         		"\n" + 
         		".nav.navbar-nav a:hover {\n" + 
         		" color: grey;\n" + 
         		"}"+
        		"</style>\n");
      
        out.print(" <table class='table table-hover table-bordered '>");
        
      
        out.println("<tr class='active'><td> ID </td> <td>Title</td> <td>Account Id</td><td>Contact Id</td><td>Status</td><td>Open Date</td><td>Close date</td><td>Description</td><td>Edit</td><td>Update</td>");
        while(rs.next())
           {
           out.print("<tr>");
           
           out.print("<tr>");
           out.print("<td>"+rs.getString(1)+"</td>");
          
           out.print("<td>"+rs.getString(2)+"</td>");
         
           out.print("<td>"+rs.getString(3)+"</td>");
           
           out.print("<td>"+rs.getString(4)+"</td>");   
    
           out.print("<td>"+rs.getString(5)+"</td>");  
        
           out.print("<td>"+rs.getString(6)+"</td>");  
           
           out.print("<td>"+rs.getString(7)+"</td>");  

           out.print("<td>"+rs.getString(8)+"</td>");  
         
         
           
           out.println("<td> <a href='ServiceEditServlet?id="+rs.getString(1)+"'>edit</a></td>"
           		+ " <td><a href='UpdateActivityServlet1?userid="+rs.getString(1)+"'style='color:#006400;'>Update Status</a>");
        
           out.print("</tr>");

        }

        out.print("</table>");
        out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br>");
        out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
        out.print("</html>");
  

        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
