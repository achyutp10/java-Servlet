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
    <div class="signup-box">
    
    <% if(session.getAttribute("RegisterMessage") != null) { %>
			<h2 style="color:white;"><%= session.getAttribute("RegisterMessage")%></h2>
			<% session.removeAttribute("RegisterMessage");
			}
		%>
		
		
      <h1>Sign Up</h1>
      <h4>Take a minute to fill this form</h4>
      <form
        action="../registration"
        method="post"
        enctype="multipart/form-data"
      >
        <label>ID</label>
        <input type="text" placeholder="" name="id" />
        <label>Customer Name</label>
        <input type="text" placeholder="" name="custName" />
        <div>
          <label>Gender:</label>

          <input type="radio" name="gender" value="Male" id="maleRadio" />

          <label for="maleRadio">Male</label>

          <input type="radio" name="gender" value="Female" id="femaleRadio" />

          <label for="femaleRadio">Female</label>
        </div>

        <label>Address</label>

        <input type="text" placeholder="" name="address" />

        <label>Phone Number</label>

        <input type="text" placeholder="" name="phone" />

        <label>Email</label>
        <input type="email" placeholder="" name="email" />
        <label>Profile Photo:</label>
        <input type="file" id="photo" name="profile" />

        <label>Password</label>
        <input type="password" placeholder="" name="pass" />

        <div class="btn">
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
    <p class="para-2">
      Already have an account? <a href="login.jsp">Login here</a>
    </p>
</body>
</html>