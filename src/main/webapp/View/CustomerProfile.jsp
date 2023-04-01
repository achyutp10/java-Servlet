<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello <%= session.getAttribute("loggedInId") %></h2>
	<h1>This  customer profile</h1>
</body>
</html>