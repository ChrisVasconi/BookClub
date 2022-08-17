<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Description</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
	<a href="/dashboard"> Back to Shelves</a>
	<h1> Book</h1>
	<h2> ${books.bookTitle }  </h2>
	<h4> ${books.postedBy } read ${books.bookTitle } by ${books.authorName}</h4>
	<h4> Here are ${books.postedBy } thoughts:</h4>
		<h5> ${books.description }</h5>
</body>
</html>