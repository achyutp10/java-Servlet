<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/loginsignup.css" />
<link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
    />
<title>Insert title here</title>
</head>
<body>
	 <div class="login-box">
      <h1 style="color:white;">Login</h1>
      <form action="../login" method="post" class="login">
      <% if(session.getAttribute("loginError") != null) { %>
			<h2 style="color:white;"><%= session.getAttribute("loginError")%></h2>
			<% session.removeAttribute("loginError");
			}
		%>
        <label>Email</label>
        <input type="email" placeholder="" name="email"/>
        <label>Password</label>
        <input type="password" placeholder="" name="password"/>
        <div class="btn">
          <button type="submit">Login</button>
        </div>
      </form>
    </div>
    <p class="para-2">
      Not have an account? <a href="signup.jsp">Sign Up Here</a>
    </p>
</body>
</html>