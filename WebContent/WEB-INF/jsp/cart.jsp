<%@ include file="include/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart | Clothing Mart</title>
</head>
<body>
	<h1>Cart</h1>
	<a href="/Ecommerce/home">home</a>
	<a href="/Ecommerce/logout">Logout</a>
    <p id="cartMessage"></p>
    <h3>Products</h3>
    
    
    <c:forEach items="${model.products}" var="prod">
    	<div>
			<img alt="<c:out value="${prod.value.name}"/>" height="150" width="100" src="<c:out value="${prod.value.image}"/>">
			 <br>
			 <c:out value="${prod.value.name}"/> 
			 <br><i>&#x20b9;<c:out value="${prod.value.price}"/></i><br>
			 <a href="/Ecommerce/cart/remove?id=<c:out value="${prod.value.id}" />" id="cartRemove">Remove to Cart</a>
			 <br>
      	</div>
    </c:forEach>
    
</body>
</html>