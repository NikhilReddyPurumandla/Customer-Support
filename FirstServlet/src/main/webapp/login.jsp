<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<html>
<head>
<meta charset="UTF-8">
<style>
body{
background-repeat:no-repeat;
background-attatchment: fixed;
background-size:100%;
}
button {
    background-color:blue;
    color: white;
    padding: 5px 5px;
    text-align: center;
    font-size: 16px;
}
table{
border:solid blue;
}
</style>
</head>
<br><br><br><br><br>

<body background="https://img03.rl0.ru/cb73765f68c13080e513346ecb004a01/c646x220/media.licdn.com/media/AAEAAQAAAAAAAAo5AAAAJDQ2NzZkMjJjLWRlMjUtNDAyNy05MmE5LTllZWQyYThkYzYyYw.png" align="center">
<br>
<br>
<br>
<br>
<marquee><h1 style="color:purple">Welcome to login page...Your Login is Secure</h1></marquee>
<center>
<form method="post" action="LoginServlet">
<table >
<tr>
<td>
<center><font size=4 color="skyblue"><h1>SIGN IN</h1></font></center>
</td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email" required/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass" required/></td>
</tr>
<br>
<br>
<br>
<tr>
<td><br><button type="submit" >&nbsp Sign In</button></td>
<td><br><button type="reset">&nbsp &nbsp &nbsp   reset</button></td>
</tr>&nbsp &nbsp &nbsp
<tr><td><a href="signup.html">new user?Register here!!</a></td></tr>
</center>
</table>
</form>
</body>
</html>