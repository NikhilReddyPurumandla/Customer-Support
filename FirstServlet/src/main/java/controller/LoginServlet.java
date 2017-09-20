package controller;

import DAO.ServletDAO;
import model.SignupBean;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServletHttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		  
	}

	protected void doPost( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		HttpSession session1 = request.getSession(false);
		
		 if (session1 != null)
	        {
	        	
	        	session1.invalidate(); 
	     
	         
	       
			}
		 
		String email=request.getParameter("email");
		 String password=request.getParameter("pass");
	    SignupBean signupbean=new SignupBean();
	    signupbean.setEmail(email);
	    signupbean.setPassword(password);
        
        try {
			 ServletDAO sd=new ServletDAO();
			  if(sd.login(signupbean))
	            {
				 final HttpSession session = request.getSession(true);
					session.setAttribute("user", email);
				
					session.setMaxInactiveInterval(25*60);
			
					session.setAttribute("authenticated", true); 
					 Cookie userName = new Cookie("user", email);
				
					userName.setMaxAge(25*60);
					response.addCookie(userName);
			         String sid=request.getRequestedSessionId();
			       
			        FirstServletLogger.FILE_LOGGER.debug("hi user your id is"+sid);
			        FirstServletLogger.FILE_LOGGER.debug("index.jsp?id="+sid);
			       
				    String encodedURL = response.encodeRedirectURL("index.jsp?id="+sid);
					response.sendRedirect(encodedURL);
					
	            }
			  else
		      {
		      	out.print("<html>");
		      	out.print("<body>");
		        out.print("<h3>Username or Password incorrect</h3>");
		        out.print("<a href=login.jsp>click here to go to login page</a>");
		        out.print("</body>");
		        out.print("</html>");
		     
		      }
	            }
			
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			 FirstServletLogger.FILE_LOGGER.debug(e1);
		}
		
	  
			
	}

	private Object getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

}
