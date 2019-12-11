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
    <title>Edit Shoe</title>
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
            <a href="${pageContext.request.contextPath}/shoes/list"><li>List Shoes</li></a>
            <br>
        </ul>
    </nav>
        <form:form action="editShoes" modelAttribute="aShoe" enctype="multipart/form-data">
        ID: <form:input path="shoeId"/>
        Name:  <form:input path="description"/>
        Style:  <form:input path="style"/>
        Color:  <form:input path="color"/>
        Retail:  <form:input path="retail"/>
        ReleaseDate:  <form:input path="releaseDate"/>
        <input type="submit" value="Update Shoe">

    </form:form>






</div>
</body>
</html>