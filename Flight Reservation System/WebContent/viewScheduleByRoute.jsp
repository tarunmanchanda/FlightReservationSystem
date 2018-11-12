<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>your search result</title>
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
<table border="1" bgcolor="#E8E8E8" width="70%">
<tr bgcolor="black" ><th align="center" colspan="9"><h4><font color="yellow" >ALL SCHEDULE DETAILS</font></h4></th></tr>

<tr ><td><h5><font>Schedule ID</font></h5><td><h5><font>Flight ID</font></h5></td>
<td><h5><font >Route ID</font></h5></td><td><h5><font >Travel Duration</font></h5></td>
<td><h5><font >Available Days</font></h5></td><td><h5><font>Departure Time</font></h5></td><td><h5><font>Source</font></h5></td><td><h5><font>Destination</font></h5></td><td><h5><font>Operations</font></h5></td></tr>
<s:iterator value="scheduleLList">
	<tr>
	<td><s:property value="scheduleid"/></td>
	<td><s:property value="flightid"/></td>
	<td><s:property value="routeid"/></td>
	<td><s:property value="travelduration"/></td>
    <td><s:property value="availabledays"/></td>
    <td><s:property value="departuretime"/></td>
 <td><s:property value="source"/></td>
 <td><s:property value="destination"/></td>
<td>
<s:form name="bookform2" action="reserveticket" method="post">

		<s:submit value="Book Now"></s:submit>
		<s:hidden value="%{scheduleid}" name="scheduleid"></s:hidden>
		<s:hidden value="%{flightid}" name="flightid"></s:hidden>
</s:form>
	
</td>
	</tr>
</s:iterator>
</table>
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