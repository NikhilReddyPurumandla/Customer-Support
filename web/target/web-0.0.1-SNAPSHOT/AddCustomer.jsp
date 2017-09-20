<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  HttpSession session1=request.getSession(false);
  if(session1.getAttribute("user")==null){
      response.sendRedirect("login.jsp");
  }



 
  %> 
<title>Customer Registration Page</title>
<!DOCTYPE html>


<html><head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  
<style>


.form-group{
width:250px;
}
	  footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    .nav.navbar-nav li a {
   color: #fff;
 }

.nav.navbar-nav a:hover {
 color: grey;
}
</style>

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand "href="#">Customer Support</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="index.jsp">Home</a></li>
      <li><a href="ProfileServlet">Profile</a></li>
      <li><a href="AddCustomer.jsp">Add customers</a></li>
      <li><a href="ViewCustomersServlet">view customers</a></li>
      <li><a href="ViewServiceServlet"> request Tickets</a></li>
      <li><a href="SolvedServiceServlet"> Solved Tickets</a></li>
      <li><a href="LogServlet">Service Logs</a></li>
       <li><a href="LogoutServlet">Logout</a></li>
    </ul>
  </div>
</nav>



 </head>
<body>





<center>

	
<form action="CustomerRegServlet" method="post" class="form_bg">

<div class="container">
    <div class="form-group">
      <label>Name</label>
      <input type="text" class="form-control" name="name" placeholder="Name" required>
    </div>
    <div class="form-group">
      <label>HouseNo</label>
      <input type="text" class="form-control"  name="hno" placeholder="House no">
    </div>
     <div class="form-group">
      <label>Street</label>
      <input type="text" class="form-control"  name="street" placeholder="Street">
    </div>
     <div class="form-group">
      <label>City</label>
      <input type="text" class="form-control" type="text" name="city" placeholder="City">
    </div>
     <div class="form-group">
      <label>State</label>
      <input type="text" class="form-control" type="text" name="state" placeholder=State">
    </div>
     <div class="form-group">
      <label>Zip-code</label>
      <input type="text" class="form-control" type="text" name="zipcode" placeholder="Zip Code">
    </div>
    <div class="form-group">
      <label>Email</label>
      <input type="text" class="form-control" type="email" name="email" placeholder="Email" required>
    </div>
    
   

<button class="btn btn-primary" type="submit">Save</button>
    </div>
  </form>
</center>
</body>
<br>
<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>
</html>