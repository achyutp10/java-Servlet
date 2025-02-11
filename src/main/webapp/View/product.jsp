<%@page import="models.ClothesDAO"%>
<%@page import="models.Clothe"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Products</title>
    <link rel="stylesheet" href="css/Products.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script
      src="https://kit.fontawesome.com/yourcode.js"
      crossorigin="anonymous"
    ></script>
    <style>
      #newsletter h4 {
        font-size: 22px;
        font-weight: 600;
        color: #818ea0;
      }

      /* ---------- */

      .cart-btn {
        background-color: #088178;
        color: #fff;
        border: none;
        padding: 10px 20px;
        font-size: 12px;
        border-radius: 4px;
        cursor: pointer;
        box-shadow: 0px 0px 5px #888888;
      }

      .cart-btn:hover {
        background-color: #0c3b38;
      }

      .cart-btn .fa {
        margin-right: 5px;
      }

      /* ------------ */
    </style>
  </head>
  <body>
  
  

    <!--header starts-->
    <section id="header">
      <a href="#"><img src="img/logo.jpg" class="logo" alt="" /></a>
      <div>
        <ul id="navbar">
          <li><a href="../view/index">Home</a></li>
          <li><a class="active" href="product">Products</a></li>

          <li><a href="Contact.html">Contact</a></li>
          <li><a href="profile">Edit Profile</a></li>
          <li><a href="../fetchOrder" class="">My Orders</a></li>
          <li>
            <a href="../fetchCart" class=""
              ><i class="fa fa-shopping-bag cart"></i
            ></a>
          </li>
          <li>
            <a href="login.jsp" class=""
              ><i class="fa fa-arrow-right-to-bracket cart"></i
            ></a>
          </li>
          <li>
            <a href="../view/index" class=""
              ><i class="fa fa-long-arrow-alt-left cart"></i
            ></a>
          </li>
        </ul>
      </div>
    </section>
    <section id="page-header">
      <h2>#StaySafe</h2>
      <p>Save More With Coupons up to 20% off!!</p>
    </section>
    <!--products items-->
    <section id="product1" class="section-p1">
     <div class="pro-container">
    	<c:forEach var="cl" items="${clotheList}">
    	<div class="pro">
          <img src="../images/${cl.image}" alt="" />
          <div class="des">
            <span>${cl.name}</span>
            <h5>${cl.brand}</h5>
            <h4>Rs ${cl.price}</h4>
          </div>
        </div>
        
         <form action="../cart" method="post">
                        <input type="hidden" name ="id" value="${cl.id}">
                        <button type="submit" class="cart-btn">
            <i class="fa fa-shopping-cart"></i> Add to cart
          </button>
        </form>
        
   	 </c:forEach>
	</div>
   </section>

    <!--newsletter starts-->
    <section id="newsletter" class="section-p1 section-m1">
      <div class="newstext">
        <h4>Sign Up For Newsletters</h4>
        <p>
          Get E-mail updates about our
          <span>latest arrivals and special offers</span>
        </p>
      </div>
      <div class="form">
        <input type="text" placeholder="Your Email Address" />
        <button class="normal">Sign Up</button>
      </div>
    </section>
    <!--footer starts-->
    <footer class="section-p1">
      <div class="col">
        <img class="logo" src="/img/logo.jpg" alt="" />
        <h4>Contact</h4>
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
          <img src="/img/googleplay.jpg" alt="" />
          <img src="/img/appstore.jpg" alt="" />
        </div>
        <p>Secured Payments Gateways</p>
        <img src="/img/cards.jpg" alt="" />
      </div>
      <div class="copyright">
        <p>&copy 2023, Hamro Ramro - E-commerce Website</p>
      </div>
    </footer>
</body>
</html>