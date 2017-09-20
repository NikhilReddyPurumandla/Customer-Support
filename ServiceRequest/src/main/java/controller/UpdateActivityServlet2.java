package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.ActivityBean;
import model.ServiceBean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UpdateServiceServlet
 */
public class UpdateActivityServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActivityServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 HttpSession session1=request.getSession(false);
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }

		

		 String id2=request.getParameter("id1");
		
		String srid=request.getParameter("srid");
		String id=request.getParameter("userid");
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Timestamp updatedate=timestamp;
		String update=request.getParameter("update");
		ActivityBean ab=new ActivityBean();
		ab.setSrid(srid);
		ab.setUpdateddate(updatedate);
		ab.setUpdate(update);
		  try {
	    	   
				UserDao ud=new UserDao();
				
				if(ud.insertActivity(ab)) {
					System.out.println("updated");
					ServiceBean sb=new ServiceBean();
					Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
					Timestamp closedate=timestamp1;
					sb.setClosedate(closedate);
					sb.setId(srid);
		if(update.equals("closed")) {
			  int status;
		      
				try {
					   System.out.println("hello");
					status= UserDao.updateCloseDate(sb);
				   System.out.println("hiii");
				 
					if(status>0){  
			            response.sendRedirect("ViewServiceServlet");
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
			            out.println("<body>");
			            out.println("<a href=ViewServiceServlet>failed to update status...try again</a>");
			            out.println("</body><br><br><br><br><br><br><br><br>");
			            out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>");
			            out.println("</html>");
					}
				}
				catch(Exception e) {
			        	System.out.println(e);
			        }
		}
				RequestDispatcher rd=request.getRequestDispatcher("ViewServiceServlet");
				rd.forward(request, response);
		
				
			}
		  }
			catch(Exception e) {
				CustomerServiceLogger.FILE_LOGGER.debug("error is"+e); 
				CustomerServiceLogger.FILE_LOGGER.debug("failed to store details!!! \n try again"); 
				//System.out.println(e);
				//System.out.println("failed to store details!!! \n try again");
				
	
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
						"      <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\n" + 
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
				out.print("<a href=ViewServiceServlet.jsp>Click here to add details again</a>");
				
				out.print("</body><br><br><br><br><br><br><br><br>");
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
