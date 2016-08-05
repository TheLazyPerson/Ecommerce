<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sign In | Clothing</title>
</head>
<body>

	<form method="post" action="/home">
		<c:if test="${messages.size() > 0}">
			<div class="alert alert-danger" role="alert">  
				<c:forEach var="message" items="${messages}">
					<p>${ message.value }</p>
				</c:forEach>
			</div>
		</c:if>
		<label>Username:</label>
		<input type="email" name="username" placeholder="Username" required autofocus>
		<label>Password:</label>
		<input type="password" name="password" placeholder="Password" required>
		
		<input type="submit" value="Sign in">		
	</form>
</body>
</html>