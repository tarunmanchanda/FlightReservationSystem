<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit Card to Pay</title>
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
	  $(document).ready(
			  /* This is the function that will get executed after the DOM is fully loaded */
			  function () {
			    /* Next part of code handles hovering effect and submenu appearing */
			    $(".sub-menu li").hover(
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
<body>
<% String userid = (String)session.getAttribute("userid"); %>
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
  				<a href="customersuccess.jsp">Home</a>
  			</li>
  			<li>
  				<a href="aboutus.jsp">About Us</a>
  				
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
	<div id="login">
<br>
<br>
<center><H6><% out.println("LOGGED IN AS: "+userid);%></H6></center>
<center>
	<h1>YOU ARE UNDER SECURE GATEWAY</h1>
		<H2>Your Total Amount To Pay is <s:property value="#session.totalamount"/></H2>
<br>
<br>
			<s:form action="PayAmount" method="post">
			<s:textfield name="creditcardnumber" label="Your Credit Card Number"></s:textfield>
			<s:textfield name="validfrom" label="Valid from"></s:textfield>
			<s:textfield name="validto" label="Valid to"></s:textfield>
			<s:submit value="pay"></s:submit>
</s:form>	
</center>

	</div>
	<!-- write ur JSP code here  -->

	</div>
		
	<div id="footer">
<s:form name="logout" action="logout1" method="post">
<s:submit value="logout"></s:submit>
</s:form>
	</div>
</div>
</body>
</html>