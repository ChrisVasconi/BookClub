<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
	<h1> Books Dashboard</h1>
	<a href="/logout"> Logout</a>
	<a href="/books/new"> Add a new book!</a>
		<table>
			<thead>
				<tr>
					<th> Title</th>
					<th> Author Name</th>
					<th> Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachBooks" items="${booksList }">
					<tr>
					
						<td><a href="/books/${eachBooks.id}">${eachBooks.bookTitle }</a></td>
						<td>${eachBooks.authorName } </td>
						<td>${eachBooks.postedBy } </td>
						<td> <a href="/books/edit/${eachBooks.id}">Edit</a></td>
						<td> <a href="/books/${eachBooks.id}">Description</a></td>
							<td>
							<form method="post" action="/books/delete/${eachBooks.id }">
								<input type="hidden" name="_method" value="delete" />
								<button type="submit"> Delete</button>
							</form>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>