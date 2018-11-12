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
<table border="2" cellspacing="4" cellpadding="5">
<th colspan="3"> All Bookings </th>
	<tr>
		<td>Reservation Id</td>
		<td>Journey Date</td>
		<td>View</td>
	</tr>
	<s:iterator value="ticketlist">
	<tr>
		<td><s:property value="%{reservationid}"/></td>
		<td><s:property value="%{journeydate}"/></td>
		
		<td>
			<s:form action="viewticket" method="post">
			<s:hidden value="%{reservationid}" name="reservationid"></s:hidden>
			<s:submit value="View"/>
			</s:form>
		</td>
	</tr>
	</s:iterator>
</table>
</body>
</html>