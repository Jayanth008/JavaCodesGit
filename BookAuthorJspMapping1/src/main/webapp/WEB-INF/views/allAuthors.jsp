<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/css/allAuthor.css">
<style>
.popup {
	display: none;
	position: fixed;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ccc;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	z-index: 9999;
}

.popup h2 {
	margin-top: 0;
}

.popup p {
	margin-bottom: 10px;
}

.popup button {
	display: block;
	margin: 20px auto 0;
}
</style>

<script>
        function openPopup(bookId) {
            var url = 'api/book/byid/' + bookId;

            fetch(url)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('popup-bookId').textContent = data.bookId;
                    document.getElementById('popup-authorName').textContent = data.authorName;
                    document.getElementById('popup-age').textContent = data.age;
                    document.getElementById('popup-city').textContent = data.city;
                    document.getElementById('popup-state').textContent = data.state;
                    document.getElementById('popup-country').textContent = data.country;
                    document.getElementById('popup-noOfBooksPublished').textContent = data.noOfBooksPublished;
                    document.getElementById('popup-noOfBooksPublishedLetters').textContent = data.noOfBooksPublishedLetters;
                    document.getElementById('popup-language').textContent = data.language;
                    document.getElementById('popup-createDate').textContent = data.createDate;
                    document.getElementById('popup-updateDate').textContent = data.updateDate;
                    document.getElementById('popup').style.display = 'block';
                })
                .catch(error => console.error('Error:', error));
        }

        function closePopup() {
            document.getElementById('popup').style.display = 'none';
        }
    </script>
</head>
<body>
	<h1 align="center">Author List</h1>
	<div align="center">
		<!-- <form action="addauthor">
			<input type="submit" value="Add Author">
		</form>
		<form action="logout">
			<input type="submit" value="Logout">
		</form> -->
		<div style="display: flex; justify-content: center; gap: 550px;">
			<form action="addauthor">
				<input type="submit" value="Add Author">
			</form>
			<form action="export" method="post">
				<button style="background-color: orange;" type="submit">Export
					to Excel</button>
			</form>
			<form action="exportToCsv" method="post">
				<button style="background-color: orange;" type="submit">Export
					to CSV</button>
			</form>
			<form action="logout">
				<input type="submit" value="Logout">
			</form>

		</div>

		<table border="1">
			<thead>
				<tr>
					<td>Book Id</td>
					<td>Author Name</td>
					<td>Age</td>
					<td>City</td>
					<td>State</td>
					<td>Country</td>
					<td>No Of Books Published</td>
					<td>No Of Books Published in letters</td>
					<td>Language</td>
					<td>Created Date</td>
					<td>Updated Date</td>
					<td>Book Published DateTime IST</td>
					<td>Book Published DateTime EST</td>
					<security:authorize access="hasAuthority('ROLE_ADMIN')">
						<td>Actions</td>
					</security:authorize>
					<!-- <td>Actions</td> -->
				</tr>
			</thead>
			<c:forEach var="author" items="${authors}">
				<tr>
					<td>${ author.bookId}</td>
					<td><a href="#" onclick="openPopup(${author.bookId});">${author.authorName}</a></td>
					<td>${ author.age}</td>
					<td>${ author.city}</td>
					<td>${ author.state}</td>
					<td>${ author.country}</td>
					<td>${ author.noOfBooksPublished}</td>
					<td>${ author.noOfBooksPublishedLetters}</td>
					<td>${ author.language}</td>
					<td>${ author.createDate}</td>
					<td>${ author.updateDate}</td>
					<td>${ author.bookPublishedDateIST}</td>
					<td>${ author.bookPublishedDateEST}</td>
					<%-- <a href="update?bookId=${author.bookId}" id="update">Update</a>
						<a href="delete?bookId=${author.bookId}" id="delete"
						onclick="if(!(confirm('Do You Want To Delete This Record?'))) return false;">Delete</a>
					 --%>
					<security:authorize access="hasAuthority('ROLE_ADMIN')">
						<td><a href="update?bookId=${author.bookId}" id="update">Update</a>
							<a href="delete?bookId=${author.bookId}" id="delete"
							onclick="if(!(confirm('Do You Want To Delete This Record?'))) return false;">Delete</a>
						</td>
					</security:authorize>


				</tr>
			</c:forEach>
		</table>
	</div>
	<%-- <c:forEach var="i" items="${authors }">
	${i }
	<br>
	</c:forEach> --%>
	<div id="popup" class="popup">
		<h2 style="text-align: center; color: blue;">Author Details</h2>
		<p>
			Book ID: <span id="popup-bookId"></span>
		</p>
		<p>
			Author Name: <span id="popup-authorName"></span>
		</p>
		<p>
			Age: <span id="popup-age"></span>
		</p>
		<p>
			City: <span id="popup-city"></span>
		</p>
		<p>
			State: <span id="popup-state"></span>
		</p>
		<p>
			Country: <span id="popup-country"></span>
		</p>
		<p>
			No of Books Published: <span id="popup-noOfBooksPublished"></span>
		</p>
		<p>
			No of Books Published in Letters: <span
				id="popup-noOfBooksPublishedLetters"></span>
		</p>
		<p>
			Language: <span id="popup-language"></span>
		</p>
		<p>
			Created Date: <span id="popup-createDate"></span>
		</p>
		<p>
			Updated Date: <span id="popup-updateDate"></span>
		</p>
		<button style="background-color: red; color: white;"
			onclick="closePopup()">Cancel</button>
	</div>
</body>
</html>