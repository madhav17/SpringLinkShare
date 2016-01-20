<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><dec:title default="playground"/></title>


    <%--global css goes here...--%>
    <spring:url value="resources/js/jquery.js" var="jqueryJs" />
    <spring:url value="resources/js/bootstrap.min.js" var="bootStrapJs" />
    <spring:url value="resources/js/jquery.validate.js" var="validateJs" />
    <spring:url value="resources/css/bootstrap-responsive.min.css" var="bootstrapResCSS" />
    <spring:url value="resources/css/bootstrap.min.css" var="bootstrapCSS" />


    <style type="text/css">@import "${bootstrapResCSS}"; </style>
    <style type="text/css">@import "${bootstrapCSS}"; </style>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${bootStrapJs}" type="text/javascript"></script>
    <script src="${validateJs}" type="text/javascript"></script>


    <dec:head/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Sample App</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<dec:body/>

</body>