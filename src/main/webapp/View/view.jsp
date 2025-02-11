<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Category</th>
			<th>Brand</th>
		</tr>
		<c:forEach var="cl" items="${productList}">
			<tr>
				<td><c:out value="${cl.name}"/></td>
				<td>${cl.price}</td>
				<td>${cl.stock}</td>
				<td>${cl.category}</td>
				<td>${cl.brand}</td>
				<td><a href="${pageContext.request.contextPath}/editProduct?id=${cl.id}">Edit</a> <a href="">Delete</a></td>
			</tr>	
		</c:forEach>
	
	</table>
</body>
</html>
		
</body>
</html>