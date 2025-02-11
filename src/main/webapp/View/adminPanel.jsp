<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <title>Admin Pannel</title>
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

      .main h2 {
        margin-bottom: 20px;
        font-size: 24px;
        font-weight: bold;
      }

      .main p {
        font-size: 16px;
        line-height: 1.5;
      }
      
      .container {
        margin: 50px auto;
        max-width: 800px;
        font-family: Arial, sans-serif;
      }

      h2 {
        text-align: center;
      }

      hr {
        border: none;
        border-top: 1px solid #ccc;
        margin: 20px 0;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      th,
      td {
        padding: 10px;
        text-align: left;
        vertical-align: middle;
      }

      th {
        background-color: #eee;
        font-weight: bold;
      }

      tr:nth-child(even) {
        background-color: #f2f2f2;
      }

      td:last-child {
        text-align: center;
      }

      .btn {
        display: inline-block;
        padding: 10px 20px;
        background-color: #e74c3c;
        color: #fff;
        border: none;
        border-radius: 4px;
        text-decoration: none;
        font-weight: bold;
      }

      .btn:hover {
        background-color: #c0392b;
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
      <h2>Welcome, <%= session.getAttribute("loggedInEmail") %></h2>
	<br>
	<br>
	<h1>Available Products</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Category</th>
			<th>Brand</th>
			<th>Rating</th>
			<th>Photo</th>
			<th>Action</th>
		</tr>
		<c:forEach var="cl" items="${clotheList}">
			<tr>
				<td><c:out value="${cl.name}"/></td>
				<td>${cl.price}</td>
				<td>${cl.stock}</td>
				<td>${cl.category}</td>
				<td>${cl.brand}</td>
				<td>${cl.rating}</td>
				<td><img id="image" src="images/${cl.image}" height="100px" width="100px"></td>
				<td><a href="${pageContext.request.contextPath}/editProduct?id=${cl.id}">Edit</a> <a href="${pageContext.request.contextPath}/deleteProduct?id=${cl.id}">Delete</a></td>
			</tr>	
		</c:forEach>
	
	</table>
    </div>
</body>
</html>