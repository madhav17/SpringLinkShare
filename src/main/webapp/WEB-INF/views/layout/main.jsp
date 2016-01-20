<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

    <title></title>
    <spring:url value="/resources/css/bootstrap-responsive.min.css" var="mainCss" />
    <spring:url value="/resources/js/jquery.js" var="jqueryJs" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootStrapJs" />
    <spring:url value="/resources/js/jquery.validate.js" var="validateJs" />
    <link href="<c:url value='/rescources/css/bootstrap.min.css' />" rel="stylesheet">
    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootStrapJs}" type="text/javascript"></script>
    <script src="${validateJs}" type="text/javascript"></script>
</head>
<body>

</body>
</html>
