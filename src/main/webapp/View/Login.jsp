<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/loginsignup.css" />
<title>Login</title>
<style >
input[type=text], input[type=password] {
display: block;} 
form div {
	margin: 10px;
	 }
		</style>
</head>
<body>
<form action="login" method="get">
<% if(session.getAttribute("loginError") != null) {%>
<h2><%= session.getAttribute("loginError") %></h2> 
<% session.removeAttribute("loginError"); %>
<%} %> 
<div>
        <label for="custName">Customer Name</label> 
        <input type="text"  name="custName" id="custName"/>
</div>
        
        <div>
        <label for="pass">Password</label>
         <input type="password" id="pass" name="pass"/>
        </div>
		<div>
        <button type="submit">Login</button>
        </div>
</form>
</body>
</html>