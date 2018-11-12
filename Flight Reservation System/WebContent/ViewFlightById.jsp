<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Flight By Id</title>
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
  				<a href="#">About Us</a>
  				
  			</li>
  			<li>
  				<a href="#">Contact Us</a>
  				
  			</li>
			<li>
  				<a href="#">Our Policy</a>
  				
  			
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
            <li><a href="ViewRoute.jsp">VIEW/MODIFY ROUTE</a></li>
            <li><a href="ViewRoute.jsp">VIEW BY ID ROUTE</a></li>
        </ul>
    </li>
<li><a href="#">SCHEDULE</a>
    <ul class="sub-menu">
            <li><a href="AddShedule.jsp">ADD SCHEDULE</a></li>
            <li><a href="ViewSchedule.jsp">VIEW/MODIFY SCHEDULE</a></li>
            <li><a href="ViewShedule.jsp">VIEW BY ID SCHEDULE</a></li>
           
        </ul></li>
    <li><a href="#">PASSENGER</a>
        <ul class="sub-menu">
            <li><a href="viewpassengerbyadmin.jsp">PASSENGER DETAILS</a></li>
          
        </ul>
    </li>
</ul>
	</div>
	<div id="login">
<br>
<br>
<center><H6><% out.println("LOGGED IN AS: "+userid);%></H6></center>
<center>
<table border="1" bgcolor="#E8E8E8">
<tr bgcolor="#336699"><th align="center" colspan="6"> <font color="yellow"><h4><font >FLIGHT DETAILS</font></h4></th></tr>

<tr ><td><h4><font >Flight ID</font></h4><td><h4><font >Flight Name</font></h4></td>
<td><h4><font >Seating Capacity</font></h4></td><td><h4><font >Reservation Capacity</font></h4></td></tr>
<s:iterator value="flightBean">
	<tr>
	<td><s:property value="flightid"/></td>
	<td><s:property value="flightname"/></td>
	<td><s:property value="seatingcapacity"/></td>
	<td><s:property value="reservationcapacity"/></td>
<td><s:form name="editform" action="" method="post">
		<s:submit value="Edit"></s:submit>
		<s:hidden value="%{flightid}" name="flightid"></s:hidden>
		</s:form>
	</td>
	<td><s:form name="deleteform" action="" method="post">
		<s:submit value="Delete"></s:submit>
		<s:hidden value="%{flightid}" name="flightid"></s:hidden>
		</s:form>
	</td>
	</tr>
</s:iterator>
</table>
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