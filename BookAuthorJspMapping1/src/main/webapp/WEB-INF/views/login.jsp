<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" /><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" /><br>
        <input type="submit" value="Login" />
    </form>
</body>
</html>
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">/* Reset styles */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

/* Body styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
}

/* Login wrapper styles */
.login-wrapper {
	max-width: 500px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* Login form styles */
form {
	display: flex;
	flex-direction: column;
	margin-bottom: 50px;
}

.input-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 10px;
}

label {
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 5px;
}

input[type="text"], input[type="password"] {
	border: none;
	background-color: #f7f7f7;
	padding: 10px;
	border-radius: 5px;
	font-size: 16px;
}

input[type="text"]:focus, input[type="password"]:focus {
	outline: none;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #3e8e41;
}

/* Error message styles */
.error-message {
	color: #FF0000;
	font-weight: bold;
	margin-bottom: 10px;
}

/* Register link styles */
.register {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-bottom: 20px;
}

.register p {
	margin-right: 10px;
}

.register a {
	color: #4CAF50;
	text-decoration: none;
	font-weight: bold;
}

.register a:hover {
	text-decoration: underline;
}

/* Logged in message styles */
/* .loggedin-message {
  text-align: center;
  margin-top: 20px;
  color: #4CAF50;
  font-weight: bold;
} */
</style>
</head>
<body>
	<div class="login-wrapper">
		<h1 style="text-align: center;">Login</h1>
		<br>
		<form action="<c:url value='/login' />" method="POST">
			<div class="input-group">
				<label for="username">Username</label> <input type="text"
					id="username" name="username" required>
			</div>
			<div class="input-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" required>
			</div>
			<br>
			<c:if test="${not empty error}">
				<p class="error-message">${error}</p>
			</c:if>
			<input type="submit" value="Login">
		</form>
		<div class="register">
			<p>Don't have an account?</p>
			<a href="<c:url value='/register' />">Register</a>
		</div>
	</div>
</body>
</html>
