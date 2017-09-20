package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBean;
import model.ServiceBean;

/**
 * Servlet implementation class ServiceEditServlet
 */
public class ServiceEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceEditServlet() {
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
		ServiceBean st= DAO.UserDao.getServiceDetails(id);
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
					"</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<center>");
        out.print("<form action='ServiceEditServlet2' method='get'>");  
   
       
        out.println("<b>Service id</b><br><input type='text' name='id' value='"+st.getId()+"'/><br><br>");  
        out.println("<b>Title</b><br><input type='text' name='title' value='"+st.getTitle()+"'/><br><br>");
        out.println("<b>Account id</b><br><input type='text' name='aid' value='"+st.getAccountid()+"'/><br><br>");  
        out.println("<b>Contact id</b><br><input type='text' name='cid' value='"+st.getContactid()+"'/><br><br>");  
        out.println("<b>Status</b><br><input type='text' name='status' value='"+st.getStatus()+"'/><br><br>");  
        out.println("<b>Open date</b><br><input type='text' name='odate' value='"+st.getOpendate()+"'/><br><br>"); 
      
        out.println("<b>Close Date</b><br><input type='text' name='cdate' value='"+st.getClosedate()+"'/><br><br>"); 
        
        out.println("<b>Description</b><br><input type='text' name='desc' value='"+st.getDescription()+"'/><br><br>");
       
        out.println("<input class=\"btn btn-info\" type='submit' value='save'>");  
     
        out.println("</form>");
	    out.println("</center>");
	    out.println("</body><br><br><br><br><br><br><br><br><br><br><br><br>");
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
