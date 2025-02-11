<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Home.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
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
    </style>
    <script>
function sortProducts() {
	  var sortOption = document.getElementById("sort").value;
	  var url = "index?sort=" + sortOption;
	  window.location.href = url;
	}

</script>
</head>
<body>

 
 <!--header starts-->
    <section id="header">
      <a href="#"><img src="img/logo.jpg" class="logo" alt="" /></a>
      <div>
        <ul id="navbar">
          <li><a class="active" href="index">Home</a></li>
          <li><a href="product">Products</a></li>

          <li><a href="Contact.html">Contact</a></li>
          <li>
            <a href="../fetchCart"><i class="fa fa-shopping-bag cart"></i></a>
          </li>
          <li>
          <form action="search" method="post">
   
          <input type="text" name="search">
          	<input type="submit" value="Search">
          </form>
          </li>
        </ul>
      </div>
    </section>
    
     <section id="product1" class="section-p1">
   <div class="pro-container">
 	<c:forEach var="cll" items="${clotheListSearch}">
    	<div class="pro">
          <img src="../images/${cll.image}" alt="" />
          <div class="des">
            <span>${cll.name}</span>
            <h5>${cll.brand}</h5>
            <h4>Rs.${cll.price}</h4>
          </div>
        </div>
   	 </c:forEach>
   	 </div>
   	 </section>
   	 
   	 
    <!--banner-->
    <section id="hero">
      <h4>!! Super Offers !!</h4>
      <h2>!! Super Value Deals</h2>
      <h1>On All Products !!</h1>
      <p>Save More With Coupons up to 20% off!!</p>
      <button>Shop Now</button>
    </section>
    <!--features section-->
    <section id="feature" class="section-p1">
      <div class="fe-box">
        <img src="img/freeshipping.jpg" alt="" />
        <h6>Free Shipping</h6>
      </div>
      <div class="fe-box">
        <img src="img/order-online.jpg" height="100%" width="100%" alt="" />
        <h6>Online Order</h6>
      </div>
      <div class="fe-box">
        <img src="img/save-money.jpg" alt="" />
        <h6>Save Money</h6>
      </div>
      <div class="fe-box">
        <img src="img/promotions.jpg" alt="" />
        <h6>Promotions</h6>
      </div>
      <div class="fe-box">
        <img src="img/happysell.jpg" alt="" />
        <h6>Happy Sell</h6>
      </div>
      <div class="fe-box">
        <img src="img/support.jpg" alt="" />
        <h6>Support</h6>
      </div>
    </section>
    <!--Featured Products section-->
 <div style="text-align: center;">   
<form style="background-color: green;">

	<label for="sort">Sort By:</label>
	<select id="sort" name="sort" onchange="sortProducts()">
	<option value="">--Select Option--</option>
	<option value="name_asc">Name (A-Z)</option>
	<option value="name_desc">Name (Z-A)</option>
	<option value="price_desc">Price (High to Low)</option>
	<option value="rating_desc">Rating (High to Low)</option>
	</select>
	<input type="hidden" name="query" value="<%= request.getParameter("query") %>">

</form>
    </div>
   <section id="product1" class="section-p1">
   
   
	<h2>Featured Products</h2>
      <p>Latest Clothes</p>
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
   	 </c:forEach>
    	
	</div>
 </section>

   
    <section id="sm-banner" class="section-p1">
      <div class="banner-box">
        <h4 style="color: #000000">Crazy Offers</h4>
        <h2 style="font-size: 40px; color: #000000">
          Buy 1 and get Accessories free
        </h2>
        <span style="color: #000000"
          >The latest Mobile Phones is here on PhoneLinks</span
        >
        <button class="white" style="color: #000000">Learn More</button>
      </div>
    </section>

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
          <img src="img/googleplay.jpg" alt="" />
          <img src="img/appstore.jpg" alt="" />
        </div>
        <p>Secured Payments Gateways</p>
        <img src="img/cards.jpg" alt="" />
      </div>
      <div class="copyright">
        <p>&copy 2023, Hamro Ramro - E-commerce Website</p>
      </div>
    </footer>
</body>
</html>