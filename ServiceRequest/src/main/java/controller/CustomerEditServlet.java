package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;
import DAO.UserDao;

/**
 * Servlet implementation class EditServlet
 */
public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditServlet() {
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
      
       
        String id=request.getParameter("id"); 
        try{ 
        
        	 HttpSession session1=request.getSession(false);
        	  if(session1.getAttribute("user")==null){
        	      response.sendRedirect("login.jsp");
        	  }

      
        System.out.println("id is"+id);
		AccountBean st= DAO.UserDao.getDetails(id);
        out.println("<html>");
	    out.println("<head>");
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
		out.println("<style>"+
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
				"</style>"+
				 "</head>");
	    out.println("<body><center>");
        out.print("<form action='CustomerEditServlet2' method='get'>");  
       
        out.println("<b>Account id</b><br><input type='text' name='aid' value='"+st.getId()+"'/><br><br>");  
        out.println("<b>Name</b><br><input type='text' name='name' value='"+st.getName()+"'/><br><br>");  
        out.println("<b>HouseNo</b><br><input type='text' name='hno' value='"+st.getHouseNo()+"'/><br><br>");  
        out.println("<b>Street</b><br><input type='text' name='street' value='"+st.getStreet()+"'/><br><br>");  
        out.println("<b>City</b><br><input type='text' name='city' value='"+st.getCity()+"'/><br><br>");  
        out.println("<b>State</b><br><input type='text' name='state' value='"+st.getState()+"'/><br><br>");  
        out.println("<b>Zipcode</b><br><input type='text' name='zipcode' value='"+st.getZipCode()+"'/><br><br>");
        out.println("<b>Role</b><br><input type='text' name='role' value='"+st.getRole()+"'/><br><br>");
        out.println("<b>Email</b><br><input type='text' name='email' value='"+st.getEmail()+"'/><br><br>");
        out.println("<input class=\"btn btn-info\" type='submit' value='save'>");   
        out.println("</form>");  
	    out.println("</center></body><br><br><br><br>");
	    out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
	    out.println("</html>");
        }
        catch (NullPointerException e) {
        	//System.out.println("hiee");
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