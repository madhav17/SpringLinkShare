<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${requestScope.topicCount}" var="topicCount" scope="request"/>
<c:set value="${requestScope.topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>
<c:set value="${requestScope.topicUnSubscribedTopic}" var="topicUnSubscribedTopic" scope="request"/>
<c:set value="${requestScope.topicSubscribedToday}" var="topicSubscribedToday" scope="request"/>

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
            <span class="sm-st-icon st-blue"><i class="fa fa-envelope-o"></i></span>

            <div class="sm-st-info">
                <span>${topicUnSubscribedTopic}</span>
                Un Subscribed Topic
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="sm-st clearfix">
            <span class="sm-st-icon st-red"><i class="fa fa-check-square-o"></i></span>

            <div class="sm-st-info">
                <span>${topicSubscribedToday}</span>
                Today Subscribed Topic
            </div>
        </div>
    </div>
</div>
