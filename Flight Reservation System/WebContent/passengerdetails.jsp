<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
  				<a href="adminsuccess.jsp">Home</a>
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
    <li><a href="#">FLIGHT</a>
    <ul class="sub-menu">
            <li><a href="AddFlight.jsp">Add Flight</a></li>
            <li><a href="ViewFlight.jsp">VIEW/MODIFY FLIGHT</a></li>
            <li><a href="ViewFlight.jsp">DELETE</a></li>
        </ul></li>
    <li><a href="#">ROUTE</a>
        <ul class="sub-menu">
            <li><a href="AddRoute.jsp">ADD ROUTE</a></li>
            <li><a href="ViewRoute.jsp">VIEW ALL ROUTE</a></li>
            <li><a href="ViewRoute.jsp">VIEW BY ID ROUTE</a></li>
        </ul>
    </li>
<li><a href="#">SCHEDULE</a>
    <ul class="sub-menu">
            <li><a href="AddShedule.jsp">ADD SCHEDULE</a></li>
            <li><a href="ViewSchedule.jsp">VIEW ALL SCHEDULE</a></li>
            <li><a href="ViewSchedule.jsp">VIEW BY ID SCHEDULE</a></li>
           
        </ul></li>
    <li><a href="#">PASSENGER</a>
        <ul class="sub-menu">
            <li><a href="viewallpassenger.jsp">PASSENGER DETAILS</a></li>
          
        </ul>
    </li>
</ul>
	</div>
	<div id="login">
<br>
<br>
<center><H6><% out.println("LOGGED IN AS: "+userid);%></H6></center>
<br>
<center><table border="1" width="60%"  bgcolor="#E8E8E8">
<tr bgcolor="black"><th align="center" colspan="3"><center><h5><font color="yellow" >Passenger Details</font></h5></center></th></tr>
<s:form name="form" action="addpassenger" method="post">

<tr><td><h4><font >Name</font></h4><td><h4><font >Age</font></h4></td>
<td><h4><font >Gender</font></h4></td><td><h4><font >Add</font></h4></td></tr>

<tr>

	<td><s:textfield name="name" value="" theme="simple" ></s:textfield></td>
     <td><s:textfield name="age" value="" theme="simple"></s:textfield></td>
	<td><s:select headerKey="-1" headerValue="-- Select --" list="#{'Male':'Male', 'Female':'Female', 'Others':'Other' }" 
		name="gender" theme="simple"/></td>
	<td><s:submit value="Add Passenger" theme="simple"></s:submit></td>

</s:form></tr>

</table>

<br>
<br>
<h2> Added Passengers for Booking</h2>
<center><s:form name="form1" action="creditcard.jsp" method="post"> 
<table border="2" cellspacing="4" cellpadding="5">
<th colspan="3" width="60%"></th>
	<tr>
		<td>Name</td>
		<td>Gender</td>
		<td>Age</td>
	</tr>
	<s:iterator value="passengerlist">
	<tr>
		<td><s:property value="name" /></td>
		<td><s:property value="gender"/></td>
		<td><s:property value="age"/></td>
	</tr>
	</s:iterator>
</table>
<br>
<s:submit value="Proceed Further " theme="simple"></s:submit>
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