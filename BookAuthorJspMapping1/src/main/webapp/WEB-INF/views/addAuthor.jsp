<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Author</title>
<link rel="stylesheet" type="text/css" href="/css/addAuthor.css">
</head>
<body>
	<div align="center">
		<h1>Add Author</h1>
		<!-- create a html spring foam where the user can fill and add the vales  -->
		<form:form id="addForm" action="saveauthor" modelAttribute="author"
			method="POST">
			<%-- 	<form:hidden path="bookId" />
			<fmt:formatDate var="formattedDate" value="${author.createDate}"
				pattern="yyyy-MM-dd" />
			<form:hidden path="createDate" value="${formattedDate}" /> --%>
			<label>Author Name</label>
			<form:input path="authorName" name="authorName" />
			<br>
			<label>City</label>
			<form:input path="city" name="city" />
			<br>
			<label>State</label>
			<form:input path="state" name="state" />
			<br>
			<label>Country</label>
			<form:input path="country" name="country" />
			<br>
			<label>Number Of Books Published</label>
			<form:input path="noOfBooksPublished" name="noOfBooksPublished" />
			<br>
			<label>Language</label>
			<form:input path="language" name="language" />
			<br>
			<input type="submit" value="Submit">
			<br>
			<input type="button" value="Cancel"
				onclick="window.location.href='allauthors'">
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script type="text/javascript" src="/js/validations.js"></script>
</body>
</html>