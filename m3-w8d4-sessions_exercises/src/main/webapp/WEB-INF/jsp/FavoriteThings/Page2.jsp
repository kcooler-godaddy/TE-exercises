<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Page 2</title>
	</head>
	<body>
		<c:url var="page3URL" value="Page3"/>
		<h1>Favorite Things Survey</h1>
		<h2>What is your favorite food?</h2>
		<form action="${page3URL}" method="get">
			<input type="text" id="food" name="food"/>
			<input type="submit" value="Next >>>"/>
		</form>
	</body>
</html>