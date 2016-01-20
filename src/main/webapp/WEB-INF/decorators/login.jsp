<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><dec:title default="Login Page"/></title>


    <%--global css goes here...--%>
    <spring:url value="/resources/js/app.js" var="appJs" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootStrapJs" />
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
    <spring:url value="/resources/js/jquery.min.js" var="scripsJs" />
    <spring:url value="/resources/js/scripts.js" var="jqueryJs" />
    <spring:url value="/resources/js/jquery.backstretch.min.js" var="backstretchJs" />

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/css/font-awesome.min.css" var="fontCSS" />
    <spring:url value="/resources/css/styleLogin.css" var="styleLoginCSS" />
    <spring:url value="/resources/css/form-elements.css" var="formElementCSS" />


    <style type="text/css">@import "${bootstrapCSS}"; </style>
    <style type="text/css">@import "${fontCSS}"; </style>
    <style type="text/css">@import "${styleLoginCSS}"; </style>
    <style type="text/css">@import "${formElementCSS}"; </style>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootStrapJs}" type="text/javascript"></script>
    <script src="${appJs}" type="text/javascript"></script>
    <script src="${backstretchJs}" type="text/javascript"></script>
    <script src="${scripsJs}" type="text/javascript"></script>


    <dec:head/>
</head>
<body>

<dec:body/>

</body>