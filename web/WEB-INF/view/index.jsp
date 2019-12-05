<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 10/14/2019
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

<video autoplay muted loop id="background">
    <source src="resources/img/videoRGB.mp4" type="video/mp4">
</video>
<div id="wrapper">
    <header>
        <h1>Sneaker Haven</h1>
    </header>
    <div id="box1">
        <img src="resources/img/nike.png" height="300px" width="300px">
        <h2>Nike</h2>
    </div>


    <div id="box2">
        <img src="resources/img/jordan.png" height="300px" width="300px">

        <a href="${pageContext.request.contextPath}/shoes/list"><h2>Jordan</h2></a>

        <!--<form:form method = "GET" action = "showSearchPage">
            <input type = "submit" value = "Jordan"/>
        </form:form>-->
</div>


    <div id="box3">
        <img src="resources/img/adidas.png" height="300px" width="300px">
        <h2>Adidas</h2>
    </div>

    <br>



</div>
</body>
</html>
