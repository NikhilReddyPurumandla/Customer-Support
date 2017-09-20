package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateActivityServlet1
 */
public class UpdateActivityServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActivityServlet1() {
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

        String id=request.getParameter("userid");
        out.print("<meta charset='utf-8'>"+
        		  "<meta name='viewport' content='width=device-width, initial-scale=1'>"+
        		  "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"+
        		  "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"+
        		  "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
        				
        				out.print("<head><nav class=\"navbar navbar-inverse\">\n" + 
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
        						"</nav>"+
        						"<style>"+
        						"footer {\n" + 
        		         		"      background-color: #555;\n" + 
        		         		"      color: white;\n" + 
        		         		"      padding: 15px;\n" + 
        		         		"    }"+
                                 "select {\n" + 
                                 "  padding: 6px;\n" + 
                                 "  height: 32px;\n" + 
                                 "  width: 7cm;\n" + 
                                 "  color:black;\n" + 
                                 "  border-radius: 10px;\n" + 
                                 "  \n" + 
                                 "}"+
                                 ".nav.navbar-nav li a {\n" + 
                          		"   color: #fff;\n" + 
                          		" }\n" + 
                          		"\n" + 
                          		".nav.navbar-nav a:hover {\n" + 
                          		" color: grey;\n" + 
                          		"}"+
                                 "</style>"+
        						"</head>");
        				out.println("<center>");
        out.println("<h1>Update Activity status </h1>"); 
		out.println("<html><head><meta charset=UTF-8");
		
		out.println("<body>");
		out.println("<form action='UpdateActivityServlet2' method='post'>");
		out.println("<br><h3>Service Request Id</h3>");
		out.println("<br><input class=box type=text name='srid' placeholder=Title value="+id+">");
		

		out.println("<br><h3>Update</h3>");

		out.println("<br><select name='update'>");

		out.println("<option value=recieved>recieved</option>");

		out.println("<option value=closed>closed</option>");
		out.println("</select>");
		out.println("</div><br><br>");
		out.println("<br><input  class='btn btn-success' type='submit' value='save'>");
		out.println("</form></center></body><br><br><br><br><br><br><br><br><br><br><br><br>");
				 out.print("<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>"+
				 "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
