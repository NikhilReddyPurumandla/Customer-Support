<!DOCTYPE html>


<html><head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  /* if(session.getAttribute("user")==null)
      response.sendRedirect("index.jsp");*/
   if(session.getAttribute("authenticated")!=null && session.getAttribute("authenticated").equals(true))
{
   response.sendRedirect("index.jsp");
}
  %> 
<style>

body {
 align: center;
 font-family: Times New Roman;
 padding-left:40%;
 



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
  height: 30px;
  width: 7cm;
  color:black;
  border-radius: 10px;
  
}

button {

  padding: 15px 30px 20px 20px;

  font-size: 50px;

  text-align: center;

  font-style: normal;

  width: 40%;

  height: 40px;

 
}
.form_bg {
    background-color:white;
    border-style: inset;
    color:grey;
    padding-left:40px;
    border-radius:50px;
 
    border:5px solid inset;
    width: 380px;
    height: 700px;
}
body {
   background-size: 100% 135%;
    background-repeat: no-repeat;
     opacity: 0.9;
}

</style>
 </head>
<body background="http://www.afromum.com/wp-content/uploads/2015/04/customer_support_.jpg">
<form action="SignupServlet" method="post" class='form_bg'>
<h1>&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp Signup</h1>
<h3> Name:</h3>
<input class="box" type="text" name="name" placeholder="name" required>
<h3>Date Of Birth:</h3>
<input class="box" type="date" name="DateOfBirth" placeholder="DOB">
<h3>Gender:</h3>
<input type="radio" name="gender" value="male"> Male
<input type="radio" name="gender" value="female"> Female
<h3>Email:</h3>
<input class="box" type="email" name="mail" placeholder="mailId" required>
<h3>Password:</h3>
<input class="box" type="password" name="password" placeholder="password" required>
<h2>Education Details</h2>
<select name="education">
<option value="M.tech">MTECH</option>
<option value="MBA">MBA</option>
<option value="B.TECH">B.TECH</option>
</select>
<br><br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button class="btn btn-primary"  type="submit">Save</button>

</form>

</body>
</html>