<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  HttpSession session1=request.getSession(false);
 /* if(session1.getAttribute("user")==null){
      response.sendRedirect("login.jsp");
  }*/



 
  %> 
<title>Customer Registration Page</title>
<!DOCTYPE html>


<html><head>
<meta charset="UTF-8">

  
<style>
form{
 
   border: 3px solid black;
   width:50%;
}
body {
 align:center;
 background-size:1500px 1900px;
 font-family: Times New Roman;
 color: black;
 background-repeat: no-repeat;
border-radius: 10px;
}
div {
    border: 1px solid black;
    padding:20px;
}
select {
  padding: 6px;
  height: 32px;
  width: 7cm;
  color:black;
  border-radius: 10px;
  
}
.box{
  padding: 6px;
  height: 20px;
  width: 7cm;
  color:black;
  border-radius: 10px;
  
}
button {
  padding: 15px 30px 20px 20px;
  color:black;
  background-color: white;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  width: 20%;
  height: 20px;
 
}
</style>
 </head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE8z9A8rc2btClO0QKpSWmS-TZnlMZuSTz9KS5g2WNt5VWnc87">


<h1 align="center">Register</h1>



<center>
<a href=index.jsp><button class="dropbtn">Home</button></a>
<a href=AddCustomer.jsp ><button class="dropbtn">AddCustomers</button></a>
<a href="ViewCustomersServlet"><button class="dropbtn">View Customers</button></a>

<a href="ViewServiceServlet"><button class="dropbtn">view service request</button></a>

<form action="CustomerRegServlet" method="post">





<div style="margin-bottom:10px;
margin-top:10px;
 margin-left:20px;
 margin-right: 20px">

<h2>Personal Details</h2>

<h3> Name:</h3>

<input class="box" type="text" name="name" placeholder="Name">

<h3>Address:</h3>

<h3>HouseNo:</h3>

<input class="box" type="text" name="hno" placeholder="House no">
<h3>Street:</h3>

<input class="box" type="text" name="street" placeholder="Street">

<h3>City:</h3>

<input class="box" type="text" name="city" placeholder="City">
<h3>State:</h3>

<input class="box" type="text" name="state" placeholder=State">
<h3>Zip Code:</h3>

<input class="box" type="text" name="zipcode" placeholder="Zip Code">
<h3>Email:</h3>

<input class="box" type="email" name="email" placeholder="Email">

</div>


<button type="submit">Save</button>


</form>

</center>


</body></html>