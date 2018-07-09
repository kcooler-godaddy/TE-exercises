<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<c:import url="/WEB-INF/jsp/header.jsp"/>
   	<table class="table-table">
   		<tr class="row-image">
			<td></td>
			<c:forEach var="product" items="${productList}">
				<c:set var="displayBestSeller" value=""/>
  					<c:if test="${product.topSeller}">
 					<c:set var="displayBestSeller" value="BEST SELLER!" />
 				</c:if>
				<td class="column">
					<c:url value="/productDetail" var="productDetailURL">
						<c:param name="productId" value="${product.productId}"/>
					</c:url>
					<a href="${productDetailURL}">
						<img class="toy-image" alt="image of toy" src="img/${product.imageName}"/>
					</a>
					<p class="best-seller"><c:out value="${displayBestSeller}"/></p>
				</td>
			</c:forEach>
		</tr>
		<tr class="row-name">
			<td class="label">Name</td>
			<c:forEach var="product" items="${productList}">
				<td class="column"><c:out value="${product.name}"/></td>
			</c:forEach>
		</tr><tr class="row-rating">
			<td class="label">Rating</td>
			<c:forEach var="product" items="${productList}">
				<td class="column">
					<img class="stars" src="img/<fmt:formatNumber type="number" maxFractionDigits="0" value="${product.averageRating}"/>-star.png" alt="star rating">
				</td>
			</c:forEach>
		</tr><tr class="row-mfr">
			<td class="label">Mfr</td>
			<c:forEach var="product" items="${productList}">
				<td class="column"><c:out value="${product.manufacturer}"/></td>
			</c:forEach>
		</tr><tr class="row-price">
			<td class="label">Price</td>
			<c:forEach var="product" items="${productList}">
				<td class="column price">$<c:out value="${product.price}"/></td>
			</c:forEach>
		</tr><tr class="row-weight">
			<td class="label">wt. (in lbs)</td>
			<c:forEach var="product" items="${productList}">
				<td class="column"><c:out value="${product.weightInLbs}"/></td>
			</c:forEach>
		</tr>
   	</table>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
 