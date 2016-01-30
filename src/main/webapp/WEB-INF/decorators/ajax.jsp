<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
    <spring:url value="/resources/js/appCustom.js" var="customJs"/>
    <spring:url value="/resources/css/appCustom.css" var="customCSS"/>

    <script type="text/javascript" src="${customJs}"></script>
    <style type="text/css">@import "${customCSS}"; </style>
    <dec:head/>
</head>
<body>
<dec:body/>
</body>