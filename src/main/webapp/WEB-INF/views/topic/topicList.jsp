<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <script type="text/javascript">

        jQuery(document).ready(function () {
            jQuery(".editTopic").on('click', function () {
                updateTopic(jQuery(this).attr("data-id"));
            });
        });

    </script>
</head>

<section class="panel">
    <header class="panel-heading">Topic List</header>
    <div class="panel-body">
        <c:if test="${not empty msg}">
            <div class="infoMsg">${msg}</div>
        </c:if>
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
                    <td><a href="javascript:void (0);" class="editTopic" data-id="${topic.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</section>
