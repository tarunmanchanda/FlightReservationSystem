<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="main1.css"/>
<link rel="stylesheet" href="navbar.css"/>
<link rel="stylesheet" href="vertical.css"/>
<script src="jquery-1.11.2.js" type="text/javascript"></script>
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
$(document).ready(function() {
	$('#source').html('');
    $.getJSON("getSource", function (jsonResponse) {
    	$.each(jsonResponse.sourceList, function(key, value) {
    	//	   $('#ajaxResponse').text(jsonResponse.dummyMsg);
    		var select = $('#source');
    		$('<option>').text(value).appendTo(select);
        });
    });
 	    
	$('#source').change(function(event) {
	   var source = $("select#source").val();
	   $.getJSON('getDestination', {
	     source : source
	   }, function(jsonResponse) {
	     $('#ajaxResponse').text(jsonResponse.dummyMsg);
	     var select = $('#destination');
	     select.find('option').remove();
	     $.each(jsonResponse.destinationList, function(key, value) {
	       	$('<option>').text(value).appendTo(select);
	     });
	   });
	});
});
</script>
</head>
<sx:head/>
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
<center>
		<s:form name="form1" action="ViewReservationScheduleByRoute" method="post">
			<table>
				<tr>
					<th align="center" colspan="2"><h3>
							<font >Enter Details</font>
						</h3></th>
				</tr>

				<tr>
					<td><s:select id="source" name="source" label="Source" list="{'Select Source'}"/></td>
				</tr>
				<tr>
					<td><s:select id="destination" name="destination" label="Destination" list="{'Select Destination'}"/></td>
				</tr>
				<tr>
				<td><sx:datetimepicker  name="date" displayFormat="dd-MM-yyyy"	label="Date" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><s:submit value="Submit"></s:submit></td>
					<s:hidden value="%{date}" name="date"></s:hidden>
				</tr>
			</table>
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