<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  
<style>
.navbar
{
width:100%; height:55px;
font-family: 'Indie Flower', cursive;
}
.dropbtn {
    background-color:teal;
    color: white;
    padding: 16px;
    font-size: 16px;
}
.right{
	float: right;			
}
.a{
font-family: 'Indie Flower', cursive;
}			
.rightbar{
	background-color: teal;				
	width: 20%;	
	padding: 25px;
	height:10cm;
						
	}
			
.container{
	margin-left: 20px;
	padding: 10px;				
	width: 100%;	
			
	}
	  footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
body {
   background-size: 100% 100%;
    background-repeat: no-repeat;
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
      <a class="navbar-brand" href="#">Customer Support</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
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
<body background="https://ultimaker.com/photo/image/0x0/58e26108a06df/23950-TP-LINK-Tech-Support.jpg">
<div class="navbar">



</div>



</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer><center>Designed by Nikhil Reddy &copy2017</center></footer>
</html>