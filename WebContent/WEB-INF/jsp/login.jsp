<%@ include file="include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign In | Clothing</title>
</head>
<body>
	
	<c:if test="${ not empty error }">
		<p>Invalid Credentials</p>
	</c:if>
	<form:form commandName="user" method="POST" action="login">
		
		<label>Username:</label>
		<form:input type="text" path="username"   />
		<font color="red"><form:errors path="username"/></font><br/><br/>
		<label>Password:</label>
		<form:input type="password" path="password" />
		
		<input type="submit" value="Sign in">		
	</form:form>
</body>
</html>