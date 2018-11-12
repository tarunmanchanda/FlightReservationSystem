<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Password Change</title>
<script type="text/javascript">

<link rel="stylesheet" href="main3.css"/>
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
function checkNewPass1()
{
	if(document.form1.newpassword.value!=document.form1.confirmpassword.value)
	{
		window.alert("new password do not match ")
		return false;
	}
	else
		return true;
}
</script>
</head>
<body>
<h1>Change Your Password</h1>
<form name="changepassword" action="updatepassworduser" method="post" onsubmit="return checkNewPass1()">
<s:textfield name="userid" label="UserID" value="%{#session.userid}" readonly="true"></s:textfield>
<s:password name="password" label="CURRENT PASSWORD"></s:password><br>
<s:password name="newpassword" label="NEW PASSWORD"></s:password><br>
<s:password name="confirmpassword" label="CONFIRM PASSWORD"></s:password>
<s:submit value="submit"></s:submit>
</form>
</body>
</html>