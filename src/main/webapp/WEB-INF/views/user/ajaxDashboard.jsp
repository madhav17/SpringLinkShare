<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${topicCount}" var="topicCount" scope="request"/>
<c:set value="${topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>
<c:set value="${topicUnSubscribedTopic}" var="topicUnSubscribedTopic" scope="request"/>
<c:set value="${topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>
<c:set value="${recentTopics}" var="recentTopicList" scope="request"/>

<jsp:include page="/WEB-INF/views/user/dashboardSummary.jsp"/>


<div class="row">
    <div class="col-md-9">
        <c:set value="${topics}" var="topicList" scope="request"/>
        <jsp:include page="/WEB-INF/views/topic/topicListTemplate.jsp"/>
    </div>
    <div class="col-md-3">
        <jsp:include page="/WEB-INF/views/topic/recentTopic.jsp"/>
    </div>
</div>