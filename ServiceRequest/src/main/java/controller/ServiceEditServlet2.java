package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import model.AccountBean;
import model.ServiceBean;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class ServiceEditServlet2
 */
public class ServiceEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditServlet2() {
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
        HttpSession session1=request.getSession(false);
        if(session1.getAttribute("user")==null){
            response.sendRedirect("login.jsp");
        }
;
		
		 String id2=request.getParameter("id1");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        String id=request.getParameter("id");
        String title=request.getParameter("title");  
        String accountid=request.getParameter("aid");  
        String contactid=request.getParameter("cid");  
        String status1=request.getParameter("status");  
         String opendate=request.getParameter("odate");
        Timestamp closedate=timestamp; 
        String description=request.getParameter("desc"); 

          
        ServiceBean ab=new ServiceBean();
        ab.setId(id);
        ab.setTitle(title);  
        ab.setAccountid(accountid);  
        ab.setContactid(contactid);  
        ab.setStatus(status1);
        //ab.setOpendate(opendate);
        ab.setClosedate(closedate); 
        ab.setDescription(description);
       
     
        int status;
      
		try {
	
			status= UserDao.updateService(ab);
		   
		 
			if(status>0){  
	            response.sendRedirect("ViewServiceServlet");  
	        }else{  
				out.print("<html>"
						+ "<meta charset=\"UTF-8\">\n" + 
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
						"      <li ><a href=\"index.jsp\">Home</a></li>\n" + 
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
	            out.println("<body>"+
	            		"Sorry! unable to update record"+
	            		"</body>");
	            out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>"
	            		+ "<html><br><br><br><br><br><br><br><br><br><br><br><br>");
	        } 
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
