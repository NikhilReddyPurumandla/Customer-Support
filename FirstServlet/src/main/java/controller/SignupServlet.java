package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.ServletDAO;
import model.SignupBean;

import java.sql.*;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	
	protected void doPost(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	final String name=request.getParameter("name");
	final String dateofBirth=request.getParameter("DateOfBirth");
	final String gender=request.getParameter("gender");
	final String mail=request.getParameter("mail");
	final String password=request.getParameter("password");
	final String education=request.getParameter("education");
		SignupBean bean=new SignupBean();
		bean.setName(name);
		bean.setDob(dateofBirth);
		bean.setGender(gender);
		bean.setEmail(mail);
		bean.setPassword(password);
		bean.setEducation(education);
	
	
		try {
			
			ServletDAO dao=new ServletDAO();
			if(dao.insert(bean)) {
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Success</title>");
			    out.println("<body>");
			    out.println("<fieldset>");
			    out.println("<legend align='center'>Success</legend><br/>");
			    out.println("<h1> Your Resitration is successful!</h1>");
			    out.println("<a href=login.jsp>Go to login page</a>");
			    out.println("</fieldset>");
			    out.println("</form>");
			    out.println("</body>");
			    out.println("</html>");  
		
			}
		}
		catch(Exception e) {
			
			FirstServletLogger.FILE_LOGGER.debug(e);
			FirstServletLogger.FILE_LOGGER.debug("failed to store details!!! \n try again"); 
	
			out.print("<head>");
			out.print("<body>");
			out.print("<h5>Failed to store data</h5>");
			out.print("<a href=signup.html>Click here to register again</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
