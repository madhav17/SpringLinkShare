<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <c:set value="${topics}" var="topicList" scope="request"/>
        <jsp:include page="/WEB-INF/views/topic/topicListTemplate.jsp"/>
    </div>
</div>