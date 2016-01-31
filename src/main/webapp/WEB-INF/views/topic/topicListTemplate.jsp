<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <script type="text/javascript">

        jQuery(document).ready(function () {
            jQuery("[name='action']").on('click', subscribeOrUnSubcribeTopic);
        });

        function subscribeOrUnSubcribeTopic() {
            var type = jQuery(this).attr('data-type');
            var topicId = jQuery(this).attr('data-value');
            console.log(type);
            var divId = "right-side-panel";
            var data = {topicId: topicId};
            type == "Subscribe" ? subscribeTopic(topicId, divId, data) : unSubscribeTopic(topicId, divId, data);
        }

        function subscribeTopic(id, divId, data) {
            console.log("Sub");
            var url = "/subscription/subscribeTopic";
            ajaxTemplateForSave(url, divId, data);
        }

        function unSubscribeTopic(id, divId, data) {
            console.log("Un");
            var url = "/subscription/unSubscribeTopic";
            ajaxTemplateForSave(url, divId, data);
        }

    </script>

</head>

<c:set var="topics" value="${topicList != null ?topicList : requestScope.topicList }" scope="request"/>
<section class="panel">
    <header class="panel-heading">Topic List</header>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr class="active">
                <th><b>Title</b></th>
                <th><b>Link</b></th>
                <th><b>Action</b></th>
            </tr>
            <c:forEach var="topic" items="${topics}">
                <tr class="active">
                    <td>${topic.title}</td>
                    <td>${topic.link}</td>
                    <c:choose>
                        <c:when test="${not empty subs}">
                            <td><a href="javascript:void (0);" class="btn btn-info" name="action" data-type="${type}"
                                   data-value="${topic.id}">${type}</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="/topic/update?id=${topic.id}">Edit</a></td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </div>

</section>
