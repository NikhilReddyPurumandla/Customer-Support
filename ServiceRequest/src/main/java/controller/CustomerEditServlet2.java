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
 * Servlet implementation class EditServlet2
 */
public class CustomerEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
		  HttpSession session1=request.getSession(false); 
		  if(session1.getAttribute("user")==null){
		      response.sendRedirect("login.jsp");
		  }

		

		 String id2=request.getParameter("id1");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String id=request.getParameter("aid");
        String name=request.getParameter("name");  
        String houseNo=request.getParameter("hno");  
        String street=request.getParameter("street");  
        String city=request.getParameter("city");  
        String state=request.getParameter("state");  
        String zipCode=request.getParameter("zipcode"); 
        String role=request.getParameter("role"); 
        String email=request.getParameter("email");
          
        AccountBean ab=new AccountBean();
        ab.setId(id);
        ab.setName(name);  
        ab.setHouseNo(houseNo);  
        ab.setStreet(street);  
        ab.setCity(city);
        ab.setState(state);
        ab.setZipCode(zipCode); 
        ab.setRole(role);
        ab.setEmail(email);
     
        int status;
      
		try {
	
			status = UserDao.updateCustomer(ab);
		   
		 
			if(status>0){  
	            response.sendRedirect("ViewCustomersServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
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