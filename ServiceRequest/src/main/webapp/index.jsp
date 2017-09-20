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
<style>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet"> 
.navbar
{
width:100%; background-color:teal; height:55px;
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
body{
background-repeat:repeat;
background-size:100%;
}
</style>
</head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGp25MOfvTKpR18RKfSx7vbF4A3HayFaPrEBatJCZi5skpdR9FSQ" >
<br>
<marquee direction=right> <h1>Yoga for Enterprise</h1></marquee>
<div class="navbar">
<% String id1=request.getParameter("x");
String email= (String) request.getSession(false).getAttribute("user"); 
 System.out.println("your email is:"+email);
 System.out.println("your id is:"+id1); System.out.println("your email is:"+email);
 System.out.println("your id is:"+id1);%> 
<a href=<%http://localhost:8082/FirstServlet/index.jsp?id2=+id1%>><button class="dropbtn">Home</button></a>
<a href="ProfileServlet?id2="+id1 ><button class="dropbtn">Profile</button></a>
<a href="ViewCustomerServlet?id2="><button class="dropbtn">view customers</button></a>
<a href="ViewServiceServlet?id2="+id1 ><button class="dropbtn">view requests</button></a>
<a href="LogoutServlet?id2="+id1><button class="dropbtn">Logout</button></a>




</div>

<div class="rightbar right">
<marquee direction="up" height="90%"><p>Pramati Server 3.0 was the industry's first independently developed application server to achieve J2EEv 1.3 compatibility. Achieving this industry first involved passing over 15,000 tests in the Sun Microsystems J2EE Compatibility Test Suite.<br>
</p>
<p>
This achievement of Pramati, where it beat the reigning champions, was recognized by The ServerSide in a cartoon 'The Great ECperf Race' that was posted on 16 Sept. 2002<br></p>
<p>Pramati's SocialTwist, is the creator of the social media sharing widget Tell-a-Friend. This widget service for word-of-mouth campaigns has currently served 2.09 billion impressions world-wide.</p>
</marquee>
</div>		
		
<div class="container">
<img src="https://i.ytimg.com/vi/dmuXdUXJ03k/maxresdefault_live.jpg" width="60%">
<p class="a">Pramati Technologies is a privately held company software services company based in Hyderabad, India. The company was founded in 1998 by Jay Raghavendra Pullur and released Pramati Server, its initial product, the following year.</p>

</div>

</body>

</html>