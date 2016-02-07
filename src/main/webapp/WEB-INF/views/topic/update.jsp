<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>

    <script type="text/javascript">

        jQuery(document).ready(function(){
            jQuery("#updateTopicButton").on('click',updateTopicDetail);
        });

        function updateTopicDetail(){
            var data = jQuery("#updateTopicForm").serialize();
            ajaxTemplateForSave("/topic/updateTopic","right-side-panel",data);
        }

    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <section class="panel">
            <header class="panel-heading">Update Topic</header>
            <div class="panel-body">
                <form method="post" class="form-horizontal" id="updateTopicForm">
                    <input type="hidden" name="id" value="${topic.id}">

                    <div class="form-group">
                        <label for="title" class="col-sm-2 control-label">Topic Title : </label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="title" id="title" required="true"
                                   value="${topic.title}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="link" class="col-sm-2 control-label">Topic Link : </label>

                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="link" name="link" placeholder="Link"
                                   required="true" value="${topic.link}">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="button" class="btn btn-default" id="updateTopicButton">Update Topic</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
</div>
</html>
