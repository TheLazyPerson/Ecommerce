<%@ include file="include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Out Of Stock | Clothing Mart</title>
</head>
<body>

	<a href="/Ecommerce/logout">Logout</a>
	<p>
		<a href="/Ecommerce/cart/view">Cart <span id="cartNumber"><c:out
					value="${cartSize}" /></span></a>
	</p>
	<p id="cartMessage"></p>
	<h3>Products</h3>
	<h1>Item Out Of Stock</h1>
</body>
</html>