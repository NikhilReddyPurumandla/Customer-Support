package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.ServiceBean;

/**
 * Servlet implementation class SolvedServiceServlet
 */
@WebServlet("/SolvedServiceServlet")
public class SolvedServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolvedServiceServlet() {
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
        ServiceBean service=new ServiceBean();
        HttpSession session1=request.getSession(false);
        if(session1.getAttribute("user")==null){
            response.sendRedirect("login.jsp");
        }

        try {
			UserDao ud = new UserDao();
			  ResultSet rs = ud.solvedService(service);
			 

			
           
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
					".nav.navbar-nav li a {\n" + 
	         		"   color: #fff;\n" + 
	         		" }\n" + 
	         		"\n" + 
	         		".nav.navbar-nav a:hover {\n" + 
	         		" color: grey;\n" + 
	         		"}"+
					 "</head>");
		  out.print("<body>");
        
        out.print(" <table class='table table-hover table-bordered '>");
        
      
        out.println("<tr class='active'><td> ID </td> <td>Title</td> <td>Account Id</td><td>Contact Id</td><td>Status</td><td>Open Date</td><td>Close date</td><td>Description</td>");
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
         
        
           out.print("</tr>");

        }

        out.print("</table>");
        out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
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
