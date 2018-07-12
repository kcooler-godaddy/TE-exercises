<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Favorite Things Page 3</title>
	</head>
	<body>
		<c:url var="summaryURL" value="Summary"/>
		<h1>Favorite Things Survey</h1>
		<h2>What is your favorite season?</h2>
		<form action="${summaryURL}" method="get">
			 <div>
		        <input value="Spring" type="radio" id="Spring" name="season" checked />
		        <label for="Spring">Spring</label>
		    </div>
		    <div>
		        <input value="Summer" type="radio" id="Summer" name="season" />
		        <label for="Summer">Summer</label>
		    </div>
		    <div>
		        <input value="Fall" type="radio" id="Fall" name="season" />
		        <label for="Fall">Fall</label>
		    </div>
		    <div>
		        <input value="Winter" type="radio" id="Winter" name="season" />
		        <label for="Winter">Winter</label>
		    </div>
			<input type="submit" value="Next >>>"/>
		</form>
	</body>
</html>