<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 12/4/2019
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shoe List</title>
    <link rel="stylesheet" href="../resources/css/style.css">
</head>
<body>
<video autoplay muted loop id="background">
    <source src="images/videoRGB.mp4" type="video/mp4">
</video>
<div id="wrapper">
    <header>
        <h1>Air Jordan</h1>
    </header>
    <nav>
        <ul>
            <a href="index.html"><li>Home</li></a>
            <a href="#"><li>Nike</li></a>
            <a href="#"><li>Jordan</li></a>
            <a href="#"><li>Adidas</li></a>
            <a href="${pageContext.request.contextPath}/shoes/showAddShoeForm"><li>Add Shoe</li></a>
        </ul>
    </nav>

    <div class="listItem">
<table
        <c:forEach var="tempShoe" items="${shoes}">


            <tr>
                <td>${tempShoe.description}</td>
                <td>${tempShoe.shoeId}</td>
                <td>${tempShoe.style}</td>
                <td>${tempShoe.color}</td>
                <td>${tempShoe.retail}</td>
                <td>${tempShoe.releaseDate}</td>
                <td>${tempShoe.dateAdded}</td>
            </tr>
            <br>


        </c:forEach>
    </table

    </div>




</div>
</body>
</html>