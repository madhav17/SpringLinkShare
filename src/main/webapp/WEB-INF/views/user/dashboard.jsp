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
    <a href="/topic/create">Create Topic</a>
    &nbsp;
    &nbsp;
    &nbsp;
    <a href="/user/update?id=${user.id}">Edit Details</a>
    &nbsp;
    &nbsp;
    &nbsp;
    <a href="/login/logout">Logout</a>
</div>

<div style="text-align: center;margin-top: 7%;">
    <table style="margin-left: 40%;">
        <tr>
            <th>Title</th>
            <th>Edit</th>
        </tr>
        <c:forEach var="topic" items="${topics}">
            <tr>
                <td>${topic.title}</td>
                <td><a href="/topic/update?id=${topic.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
