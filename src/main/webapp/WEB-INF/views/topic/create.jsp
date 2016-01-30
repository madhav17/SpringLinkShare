<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <c:set value="/topic/save" var="saveTopic"/>
    <c:set value="createAndSaveTopicDiv" var="topicDiv"/>

    <script type="text/javascript">

        jQuery(document).ready(function () {
            jQuery("#create").on('click', createAndSaveTopic)
        });

        function createAndSaveTopic() {
            ajaxTemplateForSave("${saveTopic}", "${topicDiv}", jQuery("#createTopicForm").serialize());
        }

    </script>
</head>
<body>

<%-- ccsClass equivalent to class in html--%>
<div id="createAndSaveTopicDiv">
    <div class="row">
        <div class="col-md-12">
            <section class="panel">
                <header class="panel-heading">Create Topic</header>
                <div class="panel-body">
                    <c:if test="${not empty msg}">
                        <div class="infoMsg">${msg}</div>
                    </c:if>
                    <%--<form:form cssClass="form-horizontal" >--%>
                    <form class="form-horizontal" id="createTopicForm">

                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">Topic Title : </label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="title" name="title" placeholder="Title"
                                       required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="link" class="col-sm-2 control-label">Topic Link : </label>

                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="link" name="link" placeholder="Link"
                                       required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" class="btn btn-default" id="create">Create Topic</button>
                            </div>
                        </div>

                        <%--</form:form>--%>
                    </form>
                </div>
            </section>
        </div>
    </div>
</div>
</html>
