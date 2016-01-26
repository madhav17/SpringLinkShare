<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center;background-color: cadetblue;">
<div style="text-align: right">
</div>


<c:set value="${topics}" var="topicList" scope="request"/>
<jsp:include page="/WEB-INF/views/topic/topicList.jsp"/>
</body>
</html>
