package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
		
	    response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
		
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires", "0");

        request.getRequestDispatcher("login.jsp").include(request, response); 
        out.print("You are successfully logged out.Enter credentials to relogin"); 
        //System.out.println(" session");
        FirstServletLogger.FILE_LOGGER.debug("session completing");
       Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			//System.out.println("JSESSIONID="+cookie.getValue());
    			 FirstServletLogger.FILE_LOGGER.debug("JSESSIONID="+cookie.getValue());
    			break;
    		}
    	}
    	}
        HttpSession session=request.getSession(false);
      
       FirstServletLogger.FILE_LOGGER.debug("User="+session.getAttribute("user"));
        if (session != null)
        {
        	
        	session.invalidate(); 
     
         
       
		}
 

    	response.sendRedirect("logout.html");
		
        
	}

		 
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}