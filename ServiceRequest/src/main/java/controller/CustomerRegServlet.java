package controller;

import java.io.IOException;
import util.DbConnection;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.AccountBean;


import java.sql.*;
/**
 * Servlet implementation class SignupServlet
 */
public class CustomerRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
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
		
		

		 String id2=request.getParameter("id1");

		
		String Name=request.getParameter("name");
		String houseNo=request.getParameter("hno");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String  zipCode=request.getParameter("zipcode");
		String email=request.getParameter("email");
		AccountBean ob=new AccountBean();
		ob.setName(Name);
		ob.setHouseNo(houseNo);
		ob.setStreet(street);
		ob.setCity(city);
		ob.setState(state);
		ob.setZipCode(zipCode);
		ob.setRole("USER");
		ob.setEmail(email);


		try {

        	con = util.DbConnection.getConnection();
          PreparedStatement  ps = con.prepareStatement("insert into Account values(?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,ob.getId());
            ps.setString(2,ob.getName());
            ps.setString(3,ob.getHouseNo());
            ps.setString(4,ob.getStreet());
            ps.setString(5,ob.getCity());
            ps.setString(6,ob.getState());
            ps.setString(7,ob.getZipCode());
            ps.setString(8,ob.getRole());
            ps.setString(9, ob.getEmail());
          
           
            int generatedkey=0;
            int a = ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
               generatedkey=rs.getInt(1);   
                       System.out.println("Auto Generated Primary Key " + generatedkey);
                      
            }
			if(a!=0)
				 
				   out.println("<!DOCTYPE html>");
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
	         		"    }");
			out.print( ".form-group{\n" + 
					"width:250px;\n" + 
					"}"+
					".nav.navbar-nav li a {\n" + 
	         		"   color: #fff;\n" + 
	         		" }\n" + 
	         		"\n" + 
	         		".nav.navbar-nav a:hover {\n" + 
	         		" color: grey;\n" + 
	         		"}"+
					 "</style>"
					+ "</head>");
		    out.println("<title>Success</title>");
		    out.println("<body>");
		    out.print("<center>");
		    out.println("<h1>Enter Customer Contact details!</h1>");
		    out.print("<form action='ContactServlet' method='post'>");   
		    
out.println("<div class='container'>\n" + 
		"    <div class='form-group'>\n" + 
		"      <label>Account Id</label>\n" + 
		"      <input type='text' class='form-control'  name='aid' value='"+generatedkey+"'>\n" + 
		"    </div>\n" + 
		"    <div class='form-group'>\n" + 
		"      <label>Last Name</label>\n" + 
		"      <input type='text' class='form-control'  name='lname' placeholder='Last Name'>\n" + 
		"    </div>\n" + 
		"     <div class='form-group'>\n" + 
		"      <label>First Name</label>\n" + 
		"      <input type='text' class='form-control'  name='fname' placeholder='First Name'>\n" + 
		"    </div>\n" + 
		"     <div class='form-group'>\n" + 
		"      <label>Phone</label>\n" + 
		"      <input type='text' class='form-control' type='text' name='phone' placeholder='phone number'>\n" + 
		"    </div>\n" + 
		"     <div class='form-group'>\n" + 
		"      <label>Email</label>\n" + 
		"      <input type='text' class='form-control' type='email' name='email' placeholder='mail id'>\n" + 
		"    </div>\n" + 
		"    \n" + 
		"   \n" + 
		"\n" + 
		"<button class='btn btn-primary' type='submit'>Save</button>");
		    
out.print("</form>");
out.print("</center>");
out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br>");
out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
out.print("</html>");
		    
		    
		    
		
		
	}
		catch(Exception e) {
			CustomerServiceLogger.FILE_LOGGER.debug("error is"+e); 
			CustomerServiceLogger.FILE_LOGGER.debug("failed to store details!!! \n try again"); 
	
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
					"       <li><a href=\"ViewServiceServlet\">view requests</a></li>\n" + 
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
			out.print("<h5>Failed to store data</h5>");
			out.print("<a href=AddCustomer.jsp>Click here to register again</a>");
			out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br>");
			out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
			out.print("</html>");
		}
	}

}
