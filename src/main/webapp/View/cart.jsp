<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
 <link rel="stylesheet" href="view/css/cart.css" />
  <link rel="stylesheet" href="view/css/Contact.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    />
    <script
      src="https://kit.fontawesome.com/yourcode.js"
      crossorigin="anonymous"
    ></script>
</head>
<body>

	 <section id="header">
     <a href="#"><img src="view/img/logo.jpg" class="logo" alt="" /></a>
      <div>
        <ul id="navbar">
          <li><a href="view/index">Home</a></li>
          <li><a href="view/product">Products</a></li>

          <li><a href="view/Contact.html">Contact</a></li>
          <li><a href="view/profile">Edit Profile</a></li>
          <li><a href="fetchOrder" class="">My Orders</a></li>
          <li>
            <a class="active" href="fetchCart" class=""
              ><i class="fa fa-shopping-bag cart"></i
            ></a>
          </li>
          <li>
            <a href="view/login.jsp" class=""
              ><i class="fa fa-arrow-right-to-bracket cart"></i
            ></a>
          </li>
          <li>
            <a href="view/index" class=""
              ><i class="fa fa-long-arrow-alt-left cart"></i
            ></a>
          </li>
        </ul>
      </div>
    </section>
	   <section id="page-header" class="blog-header">
      <h2 style="font-size: 50px; font-weight: 800; color: #fff">
        #Let's_Buy
      </h2>
      <p style="color: #fff; font-weight: 800">
        !!Buy Something
      </p>
    </section>
	
	<c:if test="${not empty cart}">
		<section id="cart" class="section-p1 section-p1">
  <form method="POST" action="view/checkout">
    <table width="100%">
      <thead>
        <tr>
          <td>Remove</td>
          <td>Product</td>
          <td>Price</td>
          <td>Quantity</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${cart}">
          <tr>
            <td>
              <a href="${pageContext.request.contextPath}/deleteCart?id=${item.id}"><i class="far fa-times-circle"></i></a>
            </td>
            <td>${item.product}</td>
            <td>${item.user}</td>
            <td>
              <input type="number" name="quantity" value="1" max="10" min="1"/>
              <input type="hidden" name="price" value="${item.user}" />
              <input type="hidden" name="cartId" value="${item.id}" />
              <input type="hidden" name="productId" value="${item.productId}" />
              <input type="hidden" name="products" value="${item.product}" />
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <section id="cart-add" class="section-p1">
      <button type="submit" class="normal">Proceed</button>
    </section>
  </form>
</section>

	</c:if>
	<c:if test="${empty cart}">
		<p>Your cart is empty.</p>
	</c:if>
   
    
	
	    <!--footer starts-->
    <footer class="section-p1">
      <div class="col">
        <img class="logo" src="view/img/logo.jpg" alt="" />
        <h4>Cart</h4>
        <p><strong>Address:</strong>Biratnagar-03, Morang, Nepal</p>
        <p><strong>Phone:</strong>021-462768/(+977) 9812896540</p>
        <p><strong>Hours:</strong>09:00-18:00, 24/7</p>
        <div class="follow">
          <h4>Follow Us</h4>
          <div class="icon">
            <a href="#"><i class="fa-brands fa-facebook"></i></a>
            <a href="#"><i class="fa-brands fa-twitter"></i></a>
            <a href="#"><i class="fa-brands fa-instagram"></i></a>
            <a href="#"><i class="fa-brands fa-youtube"></i></a>
            <i class="fa-brands fa-reddit"></i>
          </div>
        </div>
      </div>
      <div class="col">
        <h4>About</h4>
        <a href="#">About us</a>
        <a href="#">Delivery Information</a>
        <a href="#">Privacy Policy</a>
        <a href="#">Terms & Conditions</a>
        <a href="#">Contact Us</a>
      </div>
      <div class="col">
        <h4>My Accounts</h4>
        <a href="#">Sign In</a>
        <a href="#">View Cart</a>
        <a href="#">My Wishlist</a>
        <a href="#">Track My Order</a>
        <a href="#">Help</a>
      </div>
      <div class="col install">
        <h4>Install App</h4>
        <p>From App Store or Google Play</p>
        <div class="row">
          <img src="view/img/googleplay.jpg" alt="" />
          <img src="view/img/appstore.jpg" alt="" />
        </div>
        <p>Secured Payments Gateways</p>
        <img src="view/img/cards.jpg" alt="" />
      </div>
      <div class="copyright">
        <p>&copy 2023, Hamro Ramro - E-commerce Website</p>
      </div>
    </footer>
</body>
</html>
    