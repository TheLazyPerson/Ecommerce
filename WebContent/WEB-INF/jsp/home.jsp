<%@ include file="include/include.jsp" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | Clothing Mart</title>
</head>
<body>
	<h1>Welcome!</h1>
	<a href="logout">Logout</a>
    <p>Cart <span id="cartNumber">0</span></p>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
    	<div>
			<img alt="<c:out value="${prod.name}"/>" height="150" width="100" src="<c:out value="${prod.image}"/>">
			 <br>
			 <c:out value="${prod.name}"/> 
			 <br><i>&#x20b9;<c:out value="${prod.price}"/></i><br>
			 <a href="<c:out value="${prod.id}" />" id="cartAdd">Add to Cart</a>
			 <br>
      	</div>
    </c:forEach>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   	<script type="text/javascript">
   		$(document).ready(function($) {
   			$("body").on("click", "#cartAdd", function (e) {
   				e.preventDefault();
   				console.log($(this).attr("href"));
   				var url = "cart/add?id=";
   				 url += $(this).attr("href");
   				var $cart = $("#cart-icon");
   				
   				$.ajax({
   					url: url,
   					type: "GET",
   					success: function (data) {
   						console.log("Success");
   					},
   					error: function (xhr, status, msg) {
   						console.log (xhr.responseText);
   					}
   				});
   			});
   		});
   		
   	</script>
   
</body>
</html>