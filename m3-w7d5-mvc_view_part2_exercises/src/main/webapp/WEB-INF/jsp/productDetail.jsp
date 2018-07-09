<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<c:import url="/WEB-INF/jsp/header.jsp"/>

<div class="detail">
	<div>
		<img class="toy-image" src="img/${product.imageName}" alt="toy image">
	</div>
	<div class="info">
		<div class="product-name">
			<c:set var="displayBestSeller" value=""/>
			<c:if test="${product.topSeller}">
				<c:set var="displayBestSeller" value="BEST SELLER!" />
			</c:if>
			<c:out value="${product.name}"/>
			<span class="best-seller"><c:out value="${displayBestSeller}"/></span>
		</div>
		<div class="manufacturer">
			<c:out value="by ${product.manufacturer}"/>
		</div>
		<div class="stars-container">
			<img class="stars" src="img/<fmt:formatNumber type="number" maxFractionDigits="0" value="${product.averageRating}"/>-star.png" alt="star rating">
		</div>
		<p>
			<div class="price">
				Price: $<c:out value="${product.price}"/>
			</div>
			<div>
				<span class="weight">Weight </span><c:out value="${product.weightInLbs} lbs"/>
			</div>
		</p>
		<div>
			<p class="description"><span class="bold">Description:</span> <c:out value="${product.description}"/></p>
		</div>
	</div>
	
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>