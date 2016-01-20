<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--for j spring security--%>
<html>
<head>
    <title>Link Share</title>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">

<div>


    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

<%--<form:form method="post" action="/login/home">--%>
    <%--<form name="login" action="<c:url value='/j_spring_security_check' />" method='POST'>--%>
    <form name="login" action="/login/signIn" method='POST'>
        <label for="userName">User Name : </label>
        <input type="text" name="username" id="username" required="true"/>
        <br/>
        <br/>
        <label for="password">Password : </label>
        <input type="password" name="password" id="password" required="true"/>
        <br/>
        <br/>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

        <input type="submit" name="submit" value="Login"/>
    </form>
</div>
<a href="/login/signUp"> Register </a>
</body>
</html>
