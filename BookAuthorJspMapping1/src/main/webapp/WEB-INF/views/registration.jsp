<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
</body>
</html> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style type="text/css">/* Center the form */
form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 50px;
}

/* Style the table */
table {
	border-collapse: collapse;
	width: 400px;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

/* Style the form elements */
input[type=text], input[type=password] {
	padding: 10px;
	margin: 5px;
	border: none;
	border-radius: 3px;
	background-color: #f2f2f2;
}

input[type=submit] {
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 3px;
	background-color: #4CAF50;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

input[type=button] {
	padding: 10px 20px;
	margin: 10px;
	border: none;
	border-radius: 3px;
	background-color: red;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

h1 {
	text-align: center;
}

/* Style the error messages */
.error {
	color: red;
	font-size: 14px;
}
</style>
</head>
<body>
	<h1>Registration Page</h1>
	<c:if test="${not empty usernameError}">
		<div class="error" style="font-size: 25px; text-align: center;">${usernameError}</div>
	</c:if>

	<form:form method="POST" action="/register" modelAttribute="userInfo">
		<table>

			<tr>
				<td>Username:</td>
				<td><form:input path="userName"  /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" required="true"/></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<%-- 	<tr>
				<td>Roles:</td>
				<td><form:input path="roles" /></td>
				<td><form:errors path="roles" cssClass="error" /></td>
			</tr> --%>
			<tr>
				<td>Roles:</td>
				<td><form:select path="roles" style="width: 190px;">
						<form:option value="" label="-- Select --" />
						<form:option value="user">User</form:option>
						<form:option value="admin">Admin</form:option>
					</form:select></td>
				<td><form:errors path="roles" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>
				<td><input type="button" value="Cancel"
					onclick="window.location.href='login'"></td>
		</table>
	</form:form>
</body>
</html>
