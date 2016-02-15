<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="recentTopics" value="${requestScope.recentTopicList }" scope="request"/>
<section class="panel">
    <header class="panel-heading">Recent Topic List</header>
    <div class="panel-body">
        <c:choose>
            <c:when test="${not empty recentTopics}">
                <table class="table table-bordered">
                    <tr class="active">
                        <th><b>Title</b></th>
                        <th><b>Created By</b></th>
                    </tr>

                    <c:forEach var="topic" items="${recentTopics}">
                        <tr class="active">
                            <td>${topic.title}</td>
                            <td>${topic.getUser().getFullName()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                No Recent Topics
            </c:otherwise>
        </c:choose>

    </div>

</section>
