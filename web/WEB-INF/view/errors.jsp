<%--
  Created by IntelliJ IDEA.
  User: bitstudent
  Date: 12/4/2019
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<h1>ERROR</h1>

<br>
<h2>${errorMessage}</h2>
</body>
</html>
