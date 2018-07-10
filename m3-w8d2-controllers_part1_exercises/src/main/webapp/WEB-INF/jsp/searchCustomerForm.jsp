<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Search Customers Form"/>

<%@include file="common/header.jspf"%>

<c:url value="/customerList" var="formAction" />
<form method="GET" action="${formAction}">

	<label for="name">Name:</label>
	<label for="sort">Sort:</label>

	<input type="text" id="name" name="name" />

	<select id="sort" name="sort">
  		<option value="last_name">Last Name</option>
  		<option value="email">Email</option>
  		<option value="active">Active</option>
	</select>
	
	<input type="submit" value="Submit" />
	
</form>

<%@include file="common/footer.jspf"%>