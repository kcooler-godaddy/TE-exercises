<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Survey</title>
	</head>
	<body>
		<c:url var="page1URL" value="FavoriteThings/Page1"/>
		<h1>Hello! Welcome to the Favorite Things Survey.</h1>
		<a href="${page1URL}"><h2>Begin</h2></a>
	</body>
</html>