<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
               <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
    <link rel="stylesheet" href="view/css/Contact.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    />
    <link rel="stylesheet" href="view/css/cart.css" />
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
          <li><a href="admin">Home</a></li>
          <li>
            <a href="admin" class=""
              ><i class="fa fa-long-arrow-alt-left cart"></i
            ></a>
          </li>
        </ul>
      </div>
    </section>

    <!--banner-->
    <section id="page-header" class="blog-header">
      <h2 style="font-size: 50px; font-weight: 800; color: #fff">
        #What Has Been Ordered?
      </h2>
      <p style="color: #fff; font-weight: 800">
        !!All Orders
      </p>
    </section>

    <section id="cart" class="section-p1">
      <table width="100%">
        <thead>
          <tr>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>User</td>
           
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${order}">
          <tr>
            <td>${item.product}</td>
            <td>${item.quantity}</td>
            <td>${item.price}</td>
            <td>${item.user}</td>
          </tr>
   			</c:forEach>
          <!-- // -->
        </tbody>
      </table>
    </section>

  

    <!--footer starts-->
    <footer class="section-p1">
      <div class="col">
        <img class="logo" src="img/logo.jpg" alt="" />
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