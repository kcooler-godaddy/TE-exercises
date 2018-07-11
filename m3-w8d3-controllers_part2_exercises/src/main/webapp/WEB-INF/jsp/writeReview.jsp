<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Parties for Dummies</title>
	</head>
	<body>
		<img src="img/forDummies.png" alt="Cover of book"/>
		<h1>Write a New Review</h1>

		<c:url value="/submitReview" var="formAction" />
		<form method="post" action="${formAction}">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" />
			<br/>
			<label for="rating">Star Rating:</label>
			<select id="rating" name="rating">
		  		<option value="1">1</option>
		  		<option value="2">2</option>
		  		<option value="3">3</option>
			</select>
			
			<div>
				<label for="title">Review Title:</label>
				<input type="text" id="title" name="title" />
			</div>
			<div>
				<label for="text">Review Text:</label>
				<input type="text" id="text" name="text" size="100"/>
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
			
		</form>
		
		
		
	</body>
</html>