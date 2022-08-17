<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Club login </title>
<link rel="stylesheet" type="text/css" href="/style/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="cont">
		<h1> Register: </h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
		
		<!-- ----No need to add form:input for hidden method because its not in model --> 
		<input type="hidden" name="_method" value="post" />
		<h3>
			<form:label path="userName"> User Name: </form:label>
			<br><form:input type="text" path="userName"/>
			<form:errors path="userName" />
		</h3>
		<h3>
			<form:label path="email"> Email: </form:label>
			<br><form:input type="text" path="email"/>
			<form:errors path="email" />
		</h3>
		<h3>
			<form:label path="password"> Password: </form:label>
			<br><form:input type="password" path="password"/>
			<form:errors path="password" />
		</h3>
		<h3>
			<Label> Confirm Password: </Label>
			<br><form:input type="password" path="confirm"/>
			<form:errors path="confirm" />
			<br><button class="button" type="submit">Submit!</button>
		</h3>
	</form:form>
	
	<h1> Login:</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
		<input type="hidden" name="_method" value="post" />
		<h3>
		<label>Email:</label>
		<form:input path="email" class="form-control"/>
		<form:errors path="email" class=""/>
		</h3>
		
		<h3>
		<label>Password:</label>
		<form:label path="password"> Password: </form:label>
		<form:input type="password" path="password" class="form-control"/>
		<form:errors path="password" class="text-danger" />
		</h3>
		<br><input type="submit" value="Login" class="btn btn sucess" />
		</form:form>
	</div>
</body>
</html>