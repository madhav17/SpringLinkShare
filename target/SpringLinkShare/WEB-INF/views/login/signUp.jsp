<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">

<form:form method="post" action="/user/register">
    <label for="firstName">First Name : </label>
    <input type="text" name="firstName" id="firstName" required="true"/>
    <br/>
    <br/>
    <label for="lastName">Last Name : </label>
    <input type="text" name="lastName" id="lastName" required="true"/>

    <br/>
    <br/>
    <label for="userName">User Name : </label>
    <input type="email" name="userName" id="userName" required="true"/>

    <br/>
    <br/>
    <label for="password">Password : </label>
    <input type="text" name="password" id="password" required="true"/>

    <br/>
    <br/>
    <input type="submit" value="Register"/>

</form:form>


</body>
</html>
