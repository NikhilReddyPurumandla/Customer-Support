<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
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
.form_bg {
    background-color:#eee;
    color:grey;
    padding:20px;
    border-radius:50px;
 
    border:1px solid teal;
    width: 320px;
    height: 280px;
}
.align-center {
    text-align:center;
}
body {
   background-size: 100% 135%;
    background-repeat: no-repeat;
}
</style>
</head>
<body background="http://www.platinumone.in/wp-content/uploads/2015/12/Customer-Service.png">
<center>
<br><br><br><br><br><br><br><br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="form_bg">
            <form method="post" action="LoginServlet">
                 <h2 class="text-center">Employee Login</h2>
                <br/>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="User id" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="pass" placeholder="Password" required>
                
                    </div>
<div class="form-group">
<a href="signup.jsp">create new account</a>
</div>
                   <div class="align-center">
                <button type="submit" class="btn btn-default" id="login">Login</button>
                    </div>
            </form>
        </div>
    </div>
</div>
</center>
</body>