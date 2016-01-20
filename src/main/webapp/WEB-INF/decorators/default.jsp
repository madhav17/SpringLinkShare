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
    <spring:url value="/resources/js/app.js" var="appJs" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootStrapJs" />
    <spring:url value="/resources/js/bootstrap-datepicker.js" var="bootStrapDatePickerJs" />
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs" />
    <spring:url value="/resources/js/jquery.validate.js" var="validateJs" />
    <spring:url value="/resources/js/jquery-ui-1.10.3.min.js" var="jqueryUIJs" />

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/css/font-awesome.min.css" var="fontCSS" />
    <spring:url value="/resources/css/style.css" var="styleCSS" />


    <style type="text/css">@import "${bootstrapCSS}"; </style>
    <style type="text/css">@import "${fontCSS}"; </style>
    <style type="text/css">@import "${styleCSS}"; </style>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${jqueryUIJs}" type="text/javascript"></script>
    <script src="${bootStrapJs}" type="text/javascript"></script>
    <script src="${bootStrapDatePickerJs}" type="text/javascript"></script>
    <script src="${appJs}" type="text/javascript"></script>
    <script src="${validateJs}" type="text/javascript"></script>


    <dec:head/>
</head>
<body class="skin-black">
<%--<div class="navbar navbar-inverse navbar-fixed-top">--%>
    <%--<div class="navbar-inner">--%>
        <%--<div class="container">--%>
            <%--<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</a>--%>
            <%--<a class="brand" href="#">Sample App</a>--%>

            <%--<div class="nav-collapse collapse">--%>
                <%--<ul class="nav">--%>
                    <%--<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<!--/.nav-collapse -->--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<dec:body/>

</body>