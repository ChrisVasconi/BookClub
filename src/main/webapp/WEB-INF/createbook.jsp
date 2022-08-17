<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book</title>
</head>
<body>
<a href="/dashboard"> Back to Shelves</a>
	<h1> Add a book:</h1>
	<form:form method="post" actions="/books/new" modelAttribute="books">
		<form:hidden path="creator" value="${userId }" />
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
			<button type="submit"> Add</button>

	</form:form>
</body>
</html>