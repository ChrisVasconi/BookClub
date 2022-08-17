<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/style/style.css">
</head>
<body>
<h1> Edit a book:</h1>
<a href="/dashboard"> Back to Shelves</a>
	<form:form method="post" actions="/books/edit/${books.id }" modelAttribute="books">
		<input type="hidden" name="_method" value="put" />
		<form:hidden path="creator" value="${books.creator.id }" />
		<div>
			<form:label path="bookTitle"> Title </form:label>
			<form:input type="text" path="bookTitle" />
			<form:errors path="bookTitle" />
		</div>
		<div>
			<form:label path="authorName"> Author Name </form:label>
			<form:input type="text" path="authorName" />
			<form:errors path="authorName" />
		</div>	
		<div>
			<form:label path="postedBy"> Posted By </form:label>
			<form:input type="text" path="postedBy" />
			<form:errors path="postedBy" />
		</div>	
		<div>
			<form:label path="description"> Description </form:label>
			<form:input type="text" path="description" />
			<form:errors path="description" />
		</div>	
			<button type="submit"> Edit</button>

	</form:form>
</body>
</html>