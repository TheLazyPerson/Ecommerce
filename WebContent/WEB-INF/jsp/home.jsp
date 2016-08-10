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
    <p><a href="cart/view">Cart </a><span id="cartNumber"><c:out value="${cartSize}"/></span></p>
    <p id="cartMessage"></p>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
    	<div>
			<img alt="<c:out value="${prod.name}"/>" height="150" width="100" src="<c:out value="${prod.image}"/>">
			 <br>
			 <c:out value="${prod.name}"/> 
			 <br><i>&#x20b9;<c:out value="${prod.price}"/></i><br>
			 <a href="<c:out value="${prod.id}" />" id="cartAdd">Add to Cart</a>
			 <a href="/Ecommerce/product?id=<c:out value="${prod.id}" />" >View More</a>
			 <br>
      	</div>
    </c:forEach>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   	<script type="text/javascript">
   		$(document).ready(function($) {
   			setCartSize();
   			function setCartSize() {
   				$.get("cart/size", function (data) {
   					$("#cartNumber").html(data);
   					console.log(data);
   				});
   			}
   			$("body").on("click", "#cartAdd", function (e) {
   				e.preventDefault();
   				console.log($(this).attr("href"));
   				var url = "cart/add?id=";
   				url += $(this).attr("href");
   				
   				$.ajax({
   					url: url,
   					type: "GET",
   					success: function (data) {
   						console.log("Success");
   						
   						
   						if(!isNaN(data)){
   							$("#cartNumber").html(data);
   	   						$("#cartMessage").text("Item Added Successfully");
   						}else{
   							$("#cartMessage").text("Item Out of Stock");
   						}
   						
   						setTimeout(function(){
   						  if ($('#cartMessage').length > 0) {
   						    $('#cartMessage').text("");
   						  }
   						}, 5000)
   						
   					},
   					error: function (xhr, status, msg) {
   						console.log (xhr.responseText);
   						$("#cartMessage").text("Oops! Something Went Wrong!");
   					}
   				});
   			});
   		});
   		
   	</script>
   
</body>
</html>