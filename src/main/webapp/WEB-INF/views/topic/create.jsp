<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>

<%-- ccsClass equivalent to class in html--%>
<div class="row">
    <div class="col-md-12">
        <section class="panel">
            <header class="panel-heading">Create Topic</header>
            <div class="panel-body">

                <form:form method="post" action="/topic/save" cssClass="form-horizontal">

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
                            <button type="submit" class="btn btn-default">Create Topic</button>
                        </div>
                    </div>


                </form:form>
            </div>
        </section>
    </div>
</div>
</html>
