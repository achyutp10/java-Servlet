<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        font-family: sans-serif;
      }

      .sidebar {
        height: 100vh;
        width: 200px;
        position: fixed;
        top: 0;
        left: 0;
        background-color: #333;
        color: #fff;
        padding: 20px;
      }

      .adminHead {
        margin-bottom: 20px;
        font-size: 24px;
        font-weight: bold;
      }

      .sidebar ul {
        list-style: none;
        margin-bottom: 20px;
      }

      .sidebar li a {
        display: block;
        padding: 10px;
        color: #fff;
        text-decoration: none;
      }

      .sidebar li a:hover {
        background-color: #555;
      }
    .main {
        margin-left: 200px;
        padding: 20px;
      }
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
    </style>
</head>
<body>

		
		
 <div class="sidebar">
      <a href="admin"><h1 class="adminHead">Admin Panel</h1></a>
      <ul>
        <li><a href="view/addProduct.jsp">Add Product</a></li>
        <li><a href="fetchAllOrder">Orders</a></li>
      </ul>
    </div>
       <div class="main">
       
        <% if(session.getAttribute("Message") != null) { %>
			<h2><%= session.getAttribute("Message")%></h2>
			<% session.removeAttribute("Message");
			}
		%>
	 <div class="container mt-5">
      <h2 class="text-center">Update Product ${product.name}</h2>
      <hr />

      <div class="row">
        <div class="col-sm-6">
          <form action="${pageContext.request.contextPath}/updateProduct" method="post" enctype="multipart/form-data">
          
          <input type="text" value="${product.id}" name="id" hidden>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="">Name</label>
                <input type="text" class="form-control" value="${product.name}" name="name" />
              </div>

              <div class="form-group col-md-6">
                <label for="">Price</label>
                <input type="text" class="form-control" value="${product.price}" name="price" />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Stock</label>
                <input
                  type="text"
                  class="form-control"
                  value="${product.stock}"
                  name="stock"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Category</label>
                <input
                  type="text"
                  class="form-control"
                  value="${product.category}"
                  name="category"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Brand</label>
                <input type="text" class="form-control" value="${product.brand}" name="brand" />
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="">Rating</label>
                <input
                  type="text"
                  class="form-control"
                  value="${product.rating}"
                  name="rating"
                />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group col-md-6"></div>
              <label>Image:</label>
              <input type="file" id="imageChooser" onchange="onImageChange()" name="photo" />
            	<img id="image" src="images/${product.image}" height="100px" width="100px">
            </div>

            <!--  -->
            <input type="submit" value="Update" class="btn btn-primary mt-3" />
          </form>
        </div>
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