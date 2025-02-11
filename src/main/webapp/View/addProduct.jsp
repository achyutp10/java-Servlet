<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
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
      form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-top: 50px;
      }

      label {
        margin-top: 10px;
        font-weight: bold;
      }

      input[type="text"],
      input[type="file"] {
        margin-bottom: 20px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        width: 300px;
        max-width: 100%;
      }

      input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.2s ease;
      }

      input[type="submit"]:hover {
        background-color: #0069d9;
      }
    </style>
</head>
<body>
 <div class="sidebar">
      <a href="../admin"><h1 class="adminHead">Admin Panel</h1></a>
      <ul>
        <li><a href="addProduct.jsp">Add Product</a></li>
        <li><a href="../fetchAllOrder">Orders</a></li>
      </ul>
    </div>
       <div class="main">
       
        <% if(session.getAttribute("SuccessMessage") != null) { %>
			<h2><%= session.getAttribute("SuccessMessage")%></h2>
			<% session.removeAttribute("SuccessMessage");
			}
		%>
		
	    <form action="../addProduct" method="post" enctype="multipart/form-data">
        <label for="id">Id</label>
        <input type="text" name="id">
        <label for="name">Name</label>
        <input type="text" name="name">
        <label for="price">Price</label>
        <input type="text" name="price">
        <label for="stock">Stock</label>
        <input type="text" name="stock">
        <label for="category">Category</label>
        <input type="text" name="category">
        <label for="brand">Brand</label>
        <input type="text" name="brand">
        <label for="rating">Rating</label>
        <input type="text" name="rating">
        <label for="picture">Image</label>
        <input type="file" name="image">
        <input type="submit" value="Add Product">
    </form>
      </div>
    <a href="../admin">Add Product</a>
</body>
</html>