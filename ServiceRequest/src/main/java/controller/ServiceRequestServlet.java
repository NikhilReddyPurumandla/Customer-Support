package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ServiceBean;

/**
 * Servlet implementation class ServiceRequest
 */
public class ServiceRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		 

		 String id2=request.getParameter("id1");
		String title=request.getParameter("title");
		String accountid=request.getParameter("aid");
		String contactid=request.getParameter("cid");
		String status=request.getParameter("status");
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp opendate=timestamp;
		Timestamp closedate = null;
		
		String desc=request.getParameter("desc");
		ServiceBean ob=new ServiceBean();
		ob.setTitle(title);
        ob.setAccountid(accountid);	
        ob.setContactid(contactid);
        ob.setStatus(status);
        ob.setOpendate(opendate);
        ob.setClosedate(closedate);
       ob.setDescription(desc);
      
       try {
    	   
			UserDao ud=new UserDao();
			
			if(ud.insertService(ob))
				
			request.setAttribute("aid",accountid);
			//request.setAttribute("cid",contactid);
			
			RequestDispatcher rd=request.getRequestDispatcher("ViewServiceServlet");
			rd.forward(request, response); 

			
		}
		catch(Exception e) {
			CustomerServiceLogger.FILE_LOGGER.debug("error is"+e); 
			CustomerServiceLogger.FILE_LOGGER.debug("failed to store details!!! \n try again"); 
			//System.out.println(e);
			//System.out.println("failed to store details!!! \n try again");
			
			/*RequestDispatcher rd=request.getRequestDispatcher("Signup.html");
			rd.forward(request, response);
			
*/
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
			
			out.print("<body>");
			out.print("<h5>Failed to store data</h5>");
			out.print("<a href=ContactServlet>Click here to register again</a>");
			
			out.print("</body><br><br><br><br><br><br><br><br><br><br><br><br>");
			 out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
			out.print("</html>");
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
