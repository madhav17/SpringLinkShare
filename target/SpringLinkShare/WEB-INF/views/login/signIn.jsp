<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">

<form:form method="post" action="/login/home">
    <label for="userName">User Name : </label>
    <input type="text" name="userName" id="userName" required="true"/>
    <br/>
    <br/>
    <label for="password">Password : </label>
    <input type="password" name="password" id="password" required="true"/>
    <br/>
    <br/>
    <input type="submit" value="Login"/>
</form:form>
<a href="/login/signUp"> Register </a>
</body>
</html>
