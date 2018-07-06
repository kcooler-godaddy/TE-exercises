<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 2 - Fibonacci 25</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 2 - Fibonacci 25</h1>
		<ul>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
			<li>1</li>
			<li>2</li> 
			<c:set var="previous" value="${1}"/>
			<c:set var="current" value="${2}"/>
			<c:forEach begin="3" end="25" var="i">
				<c:set var="fibNumber" value="${(current + previous)}" />
				<li>
					${fibNumber}
				</li>
				<c:set var="previous" value="${current}" />
				<c:set var="current" value="${fibNumber}" />
			</c:forEach>
		</ul>
	</body>
</html>