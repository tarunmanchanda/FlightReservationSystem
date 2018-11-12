<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>   </h1>

<br>
	<table border="1" cellspacing="4" cellpadding="20">
	<th colspan="5"> Ticket Details</th>
	
<tr>
		<td><b>Reservation ID</b></td>
		<td><b>Journey Date</b></td>
		<td><b>No. of Seats</b></td>
		<td><b>Total Fare</b></td>
		<td><b>Flight ID</b></td>

</tr>

<tr>
		<td><s:property value="%{#session.resbean.reservationid}" /></td>
		<td><s:property value="%{#session.resbean.journeydate}"/></td>
		<td><s:property value="%{#session.resbean.noofseats}"/></td>
		<td><s:property value="%{#session.resbean.totalfare}"/></td>
		<td><s:property value="%{#session.schbean.flightid}"/></td>
</tr>
<tr><td colspan="5">------------------------------------------------------------------------------------------</td></tr>
<tr>
		<td><b>Departure Time</b></td>
		<td><b>Flight Name</b></td>
		<td><b>Source</b></td>
		<td><b>Destination</b></td>
		<td><b>Distance</b></td>
</tr>

<tr>
		<td><s:property value="%{#session.schbean.departuretime}"/></td>
		<td><s:property value="%{#session.flibean.flightname}"/></td>
		<td><s:property value="%{#session.roubean.source}"/></td>
		<td><s:property value="%{#session.roubean.destination}"/></td>
		<td><s:property value="%{#session.roubean.distance}"/></td>
</tr>
<tr><td colspan="5">------------------------------------------------------------------------------------------</td></tr>
<tr>
		<td><b>Name</b></td>
		<td><b>Age</b></td>
		<td><b>Gender</b></td>
		<td><b>Seat No.</b></td>
</tr>		
	<s:iterator value="list">
<tr>
		<td><s:property value="%{name}"/></td>
		<td><s:property value="%{age}"/></td>
		<td><s:property value="%{gender}"/></td>
		<td><s:property value="%{seatno}"/></td>
</tr>
			</s:iterator>
	</table>
</center>

<center>
<s:form>
<s:submit value="Print Ticket"></s:submit>
</s:form>
<s:form  action="cancelticket" method="post">
<s:hidden value="%{#session.resbean.reservationID}" name="res_id"></s:hidden>
<s:submit value="Cancel This Ticket"></s:submit>
</s:form>

</center>



</body>
</html>