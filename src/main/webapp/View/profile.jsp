<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
    <style>
      .container {
        margin-top: 50px;
      }

      h2 {
        text-align: center;
      }

      hr {
        border-top: 1px solid #ccc;
      }

      .row {
        display: flex;
        justify-content: center;
      }

      .col-sm-6 {
        width: 50%;
      }

      form {
        margin: 0 auto;
        max-width: 500px;
      }

      .form-group {
        margin-bottom: 20px;
      }

      label {
        font-weight: bold;
      }

      input[type="text"],
      [type="file"],
      select {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
      }

      input[readonly] {
        background-color: #f2f2f2;
      }

      .btn {
        display: block;
        margin: 0 auto;
        max-width: 200px;
        padding: 10px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
      }
      input[type="submit"]:hover {
        background-color: #0069d9;
        cursor: pointer;
      }

      /*  */

      nav {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        margin-right: 150px;
        margin-top: 20px;
      }

      nav ul {
        margin: 0;
        padding: 0;
        list-style: none;
      }

      nav li {
        margin-left: 20px;
      }

      nav li:first-child {
        margin-left: auto;
      }

      nav a {
        text-decoration: none;
        color: #333;
        font-weight: bold;
        padding: 10px;
        border-radius: 5px;
        background-color: #c6c5c5;
      }

      nav a:hover {
        background-color: #9c8a8a;
      }
    </style>
  </head>
  <body>
  
  
	<h1>Hello ${customer.name}</h1>
	<h4>This your is Profile. Change any fields as you like.</h4>
    <div class="container mt-5">
      <h2 class="text-center">PROFILE</h2>
      <img src="../images/${customer.imagepath}" height="100px" width="100px">
      <hr />
      <nav>
        <ul>
          <li><a href="../logout">Logout</a></li>
        </ul>
      </nav>
      <div class="row">
        <div class="col-sm-6">
          <form action="${pageContext.request.contextPath}/updateProfile" method="post" enctype="multipart/form-data">
            <input type="text" name="id" value="${customer.id}" hidden>
            <input type="text" name="role" value="${customer.role}" hidden>
            
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="">Name</label>
                <input type="text" class="form-control" value="${customer.name}" name="name" />
              </div>

              <div class="form-group col-md-6">
                <label for="">Address</label>
                <input type="text" class="form-control"
                  value="${customer.address}"
                  name="address"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Email ID</label>
                <input
                  type="text"
                  class="form-control"
                  value="${customer.email}"
                  name="email"
                  readonly
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Phone Number</label>
                <input type="text" class="form-control" value="${customer.phone}" name="phone" />
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Password</label>
                <input type="text" class="form-control" value="${customer.password}" name="password" />
              </div>
            </div>
<div>
			<label>Gender:</label>
			<input type="radio" name="gender" value="Male" id="maleRadio" <c:if test="${fn:toLowerCase(customer.gender) eq 'male' }">checked</c:if> />
			<label for="maleRadio">Male</label>
			
			<input type="radio" name="gender" value="Female" id="femaleRadio" <c:if test="${fn:toLowerCase(customer.gender) eq 'female'}">checked</c:if> />
			<label for="femaleRadio">Female</label>
		</div>
            <div class="form-row">
              <div class="form-group col-md-6"></div>
              <label>Profile Photo:</label>
			
			<input type="file" name="photo" onchange="onImageChange()" id="imageChooser"/>
			<img id="image" src="../images/${customer.imagepath}" height="100px" width="100px">
		</div>
		
		<div>
			<input type="submit" value="Update"/>
		</div>
          </form>
        </div>
      </div>
    </div>
    <script>
		function onImageChange(){
			var imageChooser = document.getElementById("imageChooser");
			var image = document.getElementById("image");
			image.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
  </body>
</html>
