<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<link rel="stylesheet" href="main3.css"/>

<script src="jquery-1.11.2.js"></script>
<link rel="stylesheet" href="navbar.css"/>
<link rel="stylesheet" href="vertical.css"/>
  <script type="text/javascript">
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
		</script>
</head>
<center>
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
	
	<h1>Register Here</h1><br>
<s:form name="newusersignup" action="register" method="post">
<s:textfield name="firstname" label="First name"></s:textfield>
<s:textfield name="lastname" label="Last name"></s:textfield>
<s:textfield name="dateofbirth" label="Date of Birth (e.g:01/01/1999)"></s:textfield>
<s:select label="Gender"
		headerKey="-1" headerValue="--- Select ---"
		list="#{'Male':'Male', 'Female':'Female', 'Others':'Other' }" 
		name="gender" />
<s:textfield name="street" label="Street"></s:textfield>
<s:textfield name="location" label="Location"></s:textfield>
<s:textfield name="city" label="City"></s:textfield>
<s:textfield name="state" label="State"></s:textfield>
<s:textfield name="pincode" label="Pincode"></s:textfield>
<s:textfield name="mobileno" label="Mobile number"></s:textfield>
<s:textfield name="emailid" label="Email id"></s:textfield>
<s:password name="password" label="Password"></s:password>

<s:submit value="submit"> </s:submit>
</s:form>
	
	</div>
		
	<div id="footer">
	</div>
</div>
</body>
</center>
</html>