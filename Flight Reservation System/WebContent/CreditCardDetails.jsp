<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CREDIT CARD::DETAILS</title>
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
<center>
<h1>Add Credit Card Details</h1><br><br>
<s:form name="addcreditcard" action="addcreditcard" method="post">

Your User id is :
<s:property value="#session.registeredID"/>
<i>(use this user id when next time you login)</i>

<table>
<tr>
<td><s:textfield name="creditcardnumber" label="Credit Card Number"></s:textfield></td>
</tr>
<tr>
<td><s:textfield name="validfrom" label="Valid From"></s:textfield></td>
</tr>
<tr>
<td><s:textfield name="validto" label="Valid To"></s:textfield></td>
</tr>
<tr>
<td><s:textfield name="creditbalance" label="Credit Balance"></s:textfield></td>
</tr>
<tr>
<td><s:textfield name="userid" label="UserID" value="%{#session.registeredID}" readonly="true"></s:textfield></td>
</tr>
<s:submit value="submit"></s:submit>
</table>
</s:form>
</center>
	</div>
	<!-- write ur JSP code here  -->

	</div>
		
	<div id="footer">

	</div>
</div>
</body>
</html>