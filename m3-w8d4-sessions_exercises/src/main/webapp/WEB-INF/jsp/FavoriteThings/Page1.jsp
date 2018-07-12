<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Page 1</title>
	</head>
	<body>
		<c:url var="page2URL" value="Page2"/>
		<h1>Favorite Things Survey</h1>
		<h2>What is your favorite color?</h2>
		<form action="${page2URL}" method="get">
			<input type="text" id="color" name="color"/>
			<input type="submit" value="Next >>>"/>
		</form>
	</body>
</html>