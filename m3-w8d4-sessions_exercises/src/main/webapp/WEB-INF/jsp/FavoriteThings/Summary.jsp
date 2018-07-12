<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Summary</title>
	</head>
	<body>
		<h1>Favorite Things Survey</h1>
		<table>
			<tr>
				<td style="font-weight:bold;">Favorite Color:</td>
				<td>${survey.color}</td>
			</tr>
			<tr>
				<td style="font-weight:bold;">Favorite Food:</td>
				<td>${survey.food}</td>
			</tr>
			<tr>
				<td style="font-weight:bold;">Favorite Season:</td>
				<td>${survey.season}</td>
			</tr>
		</table>
	</body>
</html>