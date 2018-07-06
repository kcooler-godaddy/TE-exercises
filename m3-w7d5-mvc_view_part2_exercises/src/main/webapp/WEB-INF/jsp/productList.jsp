<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Product List View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="#">Link 1</a></li>
            <li><a href="#">Link 2</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    	<h3>Toy Department</h3>
    	<table>
    		<c:forEach var="product" items="${productList}">
    			<tr>
	    			<td class="image-container">
	    					<img class="toy-image" src="img/${product.imageName}" alt="toy image">
	    			</td>
	    			<td class="information">
	    				<div class="product-name">
	    					<c:set var="displayBestSeller" value=""/>
	    					<c:if test="${topSeller}">
			 					<c:set var="displayBestSeller" value="BEST SELLER!" />
			 				</c:if>
			 				<c:out value="${product.name}"/>
			 				<c:out value="${displayBestSeller}"/>
	    				</div>
	    				<div class="manufacturer">
	    					<c:out value="by ${product.manufacturer}"/>
	    				</div>
	    				<div class="price">
	    					$<c:out value="${product.price}"/>
	    				</div>
	    				<div class="weight">
	    					<c:out value="${product.weightInLbs}"/>
	    				</div>
	    				<div class="stars-container">
	    					<img class="stars" src="img/<fmt:formatNumber type="number" maxFractionDigits="0" value="${product.averageRating}"/>-star.png" alt="star rating">
	    				</div>
	    			</td>
	    		</tr>	
    		</c:forEach> 
    	</table>
    </section>
</body>
</html>
