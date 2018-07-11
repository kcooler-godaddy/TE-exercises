<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<c:url value="/customerList" var="formAction" />
<form method="GET" action="${formAction}">
	<label for="name">Name:</label>
	<input type="text" id="name" name="name" />
	<label for="sort">Sort:</label>
	<select id="sort" name="sort">
  		<option value="last_name">Last Name</option>
  		<option value="email">Email</option>
  		<option value="active">Active</option>
	</select>
	<input type="submit" value="Submit" />
</form>

<table class="table">
	<tr>
	    <th>Name</th>
	    <th>Email</th>
	    <th>Active</th>
	</tr>
  	<c:forEach var="customer" items="${customers}">
  		<c:set var="activeDisplay" value="No"/>
  		<c:if test="${customer.active}">
  			<c:set var="activeDisplay" value="Yes"/>
  		</c:if>
	  	<tr>
		    <td>${customer.firstName} ${customer.lastName}</td>
		    <td>${customer.email}</td>
		    <td>${activeDisplay}</td>
	  	</tr>
	</c:forEach>
</table>




<%@include file="common/footer.jspf"%>