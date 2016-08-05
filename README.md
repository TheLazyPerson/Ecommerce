
## Assignment:
  Create a web application, which will provide following functionalities for online shopping

### 1. Login Page
  1. Use form tag & form validators for validation.
  2. Credentials can be matched from hard coded values.
  3. If login fails a page should be displayed with appropriate message along with the “Login form”.

### 2. Product List
  1. Display all products on this page.

### 3. Product Detail
  1. Display Selected items details like product name, price, size, color, etc.
  
### 4. Add to Cart
  1. Add selected Items to cart using add to cart button.
  2. Same product can be added to cart for multiple times.
  3. If item is out of stock then throw an exception and display message "Item is out of stock"

### 5. Remove from cart
  1. Removes selected product from the cart.

### 6. View Cart
  1. Display the list of items on the cart.
  
### 7. Place Order
  1. Once user clicks on the “Place Order” button, display the list of items on cart with their price.
  2. Calculate and display the total amount payable.
  
### 8. Logout
  1. Logout from the active session.

### Notes:
  1. Application should have global error page.
  2. Apply a filter to validate session on each request.
  3. Use HTTP session to store products in the cart
  4. Implement all Spring core concepts like DI with diff types, auto wiring, bean scopes, etc.
