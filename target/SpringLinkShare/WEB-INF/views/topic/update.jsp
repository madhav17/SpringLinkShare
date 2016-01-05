
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">

<form:form method="post"  action="/topic/updateTopic">
<label for="title">Topic Title : </label>
<input type="hidden" name="id" value="${topic.id}">
<input type="text" name="title" id="title" required="true" value="${topic.title}"/>
<br/>
<br/>
<input type="submit" value="Update Topic"/>
</form:form>
</html>
