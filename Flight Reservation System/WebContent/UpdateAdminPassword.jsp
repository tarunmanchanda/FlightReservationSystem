<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Password Change</title>
<script  type="text/javascript" src="jquery-1.11.2.js"></script>
<link rel="stylesheet" href="main3.css"/>
<link rel="stylesheet" href="navbar.css"/>
<link rel="stylesheet" href="vertical.css"/>
	  $(document).ready(
			  /* This is the function that will get executed after the DOM is fully loaded */
			  function () {
			    /* Next part of code handles hovering effect and submenu appearing */
			    $(".nav li").hover(
			      function () { //appearing on hover
			        $("ul", this).slideDown(100);
			      },
			      function () { //disappearing on hover
			        $("ul", this).slideUp(100);
			      }
			    );
			  }
			);

	  function checkNewPass()
	  {
	  	if(document.form1.newpassword.value!=document.form1.confirmpassword.value)
	  	{
	  		window.alert("new password do not match ")
	  		return false;
	  	}
	  	else
	  		return true;
	  }
</script>
</head>
<body>
<div id="container">
	<div id="header">
		<div id="top">
			<div id="logo">
			</div>
			<div id="title">
				<center><br>
					<font face="Lucida Calligraphy" size="35"> Flight Reservation System </font>
				</center>
			</div>
		</div>

		<div id="navbar">
      
            <div id="leftnav">
            </div>
			<div id="rightnav">
  		<ul class="nav">
  			<li>
  				<a href="MainPage.jsp">Home</a>
  			</li>
  			<li>
  				<a href="aboutus.jsp">AboutUs</a>
  				
  			</li>
  			<li>
  				<a href="contactus.jsp">Contact Us</a>
  				
  			</li>
			<li>
  				<a href="policy.jsp">Our Policy</a>
  				
  			</li>
  		</ul>
  	</div>

		</div>
</div>
	<div id="content">
	
	<h1>Change Your Default Password</h1>
<form name="changepassword" action="updatepassword" method="post" onsubmit="return checkNewPass()">
<s:textfield name="userid" label="UserID" value="%{#session.userid}" readonly="true"></s:textfield>
<s:password name="password" label="CURRENT PASSWORD"></s:password><br>
<s:password name="newpassword" label="NEW PASSWORD"></s:password><br>
<s:password name="confirmpassword" label="CONFIRM PASSWORD"></s:password>
<s:submit value="submit"></s:submit>
</form>
	</div>
		
	<div id="footer">
	</div>
</div>
</body>
</html>