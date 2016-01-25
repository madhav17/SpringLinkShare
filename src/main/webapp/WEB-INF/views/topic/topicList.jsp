<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="text-align: center;margin-top: 7%;">
    <p></p>
    <p></p>
    <table style="margin-left: 40%;">
        <tr>
            <th>Title</th>
            <th>Edit</th>
        </tr>
        <c:forEach var="topic" items="${requestScope.topicList}">
            <tr>
                <td>${topic.title}</td>
                <td><a href="/topic/update?id=${topic.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
