<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usa Page</title>
<style>
body {
	font-family: Arial, sans-serif;
}

h1 {
	text-align: center;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	width: 80%;
}

th, td {
	padding: 8px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
	font-weight: bold;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}
</style>
</head>
<body>
	<h1 align="center"> Population Page</h1>
	<div align="center">
		<table border="1">
			<thead>
				<tr>
					<th>ID State</th>
					<th>State</th>
					<th>ID Year</th>
					<th>Year</th>
					<th>Population</th>
					<th>Slug State</th>
				</tr>
			</thead>
			<c:forEach var="data" items="${jsondata}">
				<tr>
					<td>${data["ID State"]}</td>
					<td>${data["State"]}</td>
					<td>${data["ID Year"]}</td>
					<td>${data["Year"]}</td>
					<td>${data["Population"]}</td>
					<td>${data["Slug State"]}</td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>