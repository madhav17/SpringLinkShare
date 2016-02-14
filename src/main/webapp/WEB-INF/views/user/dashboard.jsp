<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <c:set value="${userNewFullName}" var="newUserName" scope="request"/>
    <script type="text/javascript">

        jQuery(document).ready(function () {

            <c:if test="${not empty newUserName}">
            console.log("${newUserName}");
            jQuery("#userName").html("${newUserName}");
            </c:if>
        });

    </script>
</head>
<body>

<c:set value="${topicCount}" var="topicCount" scope="request"/>
<c:set value="${topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>
<c:set value="${topicUnSubscribedTopic}" var="topicUnSubscribedTopic" scope="request"/>
<c:set value="${topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>

<jsp:include page="/WEB-INF/views/user/dashboardSummary.jsp"/>


<div class="row">
    <div class="col-md-12">
        <c:set value="${topics}" var="topicList" scope="request"/>
        <jsp:include page="/WEB-INF/views/topic/topicList.jsp"/>
    </div>
</div>
</body>
</html>
