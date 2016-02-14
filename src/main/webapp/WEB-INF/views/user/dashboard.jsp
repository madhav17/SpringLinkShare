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
<div class="row" style="margin-bottom:5px;">


    <div class="col-md-3">
        <div class="sm-st clearfix">
            <span class="sm-st-icon st-green"><i class="fa fa-paperclip"></i></span>
            <div class="sm-st-info">
                <span>${topicCount}</span>
                Topic Created
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="sm-st clearfix">
            <span class="sm-st-icon st-violet"><i class="fa fa-envelope-o"></i></span>
            <div class="sm-st-info">
                <span>${topicSubscribedTopic}</span>
                Subscribed Topic
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="sm-st clearfix">
            <span class="sm-st-icon st-violet"><i class="fa fa-envelope-o"></i></span>
            <div class="sm-st-info">
                <span>${topicUnSubscribedTopic}</span>
                Un Subscribed Topic
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="sm-st clearfix">
            <span class="sm-st-icon st-green"><i class="fa fa-paperclip"></i></span>
            <div class="sm-st-info">
                <span>${topicSubscribedToday}</span>
                Today Subscribed Topic
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <c:set value="${topics}" var="topicList" scope="request"/>
        <jsp:include page="/WEB-INF/views/topic/topicList.jsp"/>
    </div>
</div>
</body>
</html>
