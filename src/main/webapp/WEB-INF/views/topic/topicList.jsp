<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="panel">
    <header class="panel-heading">Topic List</header>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr class="active">
                <th><b>Title</b></th>
                <th><b>Link</b></th>
                <th><b>Action</b></th>
            </tr>
            <c:forEach var="topic" items="${requestScope.topicList}">
                <tr class="active">
                    <td>${topic.title}</td>
                    <td>${topic.link}</td>
                    <td><a href="/topic/update?id=${topic.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</section>
