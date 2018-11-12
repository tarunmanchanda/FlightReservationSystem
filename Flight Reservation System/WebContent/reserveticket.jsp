<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of Selected Flight</title>
<link rel="stylesheet" href="main1.css"/>

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
	<div id="info">
<ul class="vertical-nav">
    <li><a href="reservation.jsp">View Flights</a>
    </li>
          <li><a href="reservation.jsp">Book Here</a>
    </li>
       <li><a href="viewticket.jsp">View/Cancel Ticket</a>
    </li>
    <li><a href="#">Print Ticket</a>
    </li>
<li><a href="#">Chnage Password</a>
    </li>
</ul>
	</div>
	<div id="login">
<br>
<br>
<center><H6><% out.println("LOGGED IN AS: "+userid);%></H6></center>
<center><h2>Details of Your Flight</h2></center>
<CENTER><s:form name="reservation" action="reserve" method="post">
<table border="1" bgcolor="#E8E8E8">
<tr bgcolor="black" ><th align="center"><h4><font color="yellow">DETAILS OF YOUR FLIGHT</font></h4></th></tr>
	<s:textfield name="scheduleid" value="%{scheduleid}" readonly="true"  label="Schedule id"></s:textfield>
    <s:textfield name="flightid" value="%{flightid}" readonly="true" label="Route id" ></s:textfield>
	<s:textfield name="flightname" value="%{flightBean.flightname}" readonly="true" label="Flight Name"></s:textfield>
	<s:textfield name="reservationcapacity" value="%{flightBean.reservationcapacity}" readonly="true" label="Reservation Capacity" ></s:textfield>
	<s:textfield name="fare" value="%{#session.calcfare}" label="Fare(per seat)" readonly="1"></s:textfield>
    <s:submit value="Proceed"></s:submit>
	<s:hidden value="%{scheduleid}" name="scheduleid"></s:hidden>
	<s:hidden value="%{flightid}" name="flightid"></s:hidden>
	<s:hidden value="%{fared}" name="fare"></s:hidden>
</table>
</s:form></CENTER>
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