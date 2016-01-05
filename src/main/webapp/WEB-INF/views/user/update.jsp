<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">

<form:form method="post" action="/user/updateUser">
    <input type="hidden" name="id" value="${user.id}">
    <label for="firstName">First Name : </label>
    <input type="text" name="firstName" id="firstName" required="true" value="${user.firstName}"/>
    <br/>
    <br/>
    <label for="lastName">Last Name : </label>
    <input type="text" name="lastName" id="lastName" required="true" value="${user.lastName}"/>

    <br/>
    <br/>
    <label for="password">Password : </label>
    <input type="text" name="password" id="password" required="true" value="${user.password}"/>

    <br/>
    <br/>
    <input type="submit" value="Update Info"/>

</form:form>


</body>
</html>
