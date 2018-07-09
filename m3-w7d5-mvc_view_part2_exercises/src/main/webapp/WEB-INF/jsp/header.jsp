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
        	<c:url value="/productList" var="productListURL"/>
        	<c:url value="/productTable" var="productTableURL"/>
        	<c:url value="/productTiles" var="productTilesURL"/>
            <li><a href="${productListURL}">List View</a></li>
            <li><a href="${productTableURL}">Table View</a></li>
            <li><a href="${productTilesURL}">Tile View</a></li>
        </ul>
        
    </nav>
    <section id="main-content">
    	<h3>Toy Department</h3>