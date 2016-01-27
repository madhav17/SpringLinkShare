<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <section class="panel">
            <header class="panel-heading">Topic List</header>
            <div class="panel-body">

                <form:form method="post" action="/user/updateUser" cssClass="form-horizontal">
                    <input type="hidden" name="id" value="${user.id}">

                    <div class="form-group">
                        <label for="firstName" class="col-sm-2 control-label">First Name : </label>

                        <div class="col-sm-6">
                            <input type="text" name="firstName" class="form-control" id="firstName" required="true"
                                   value="${user.firstName}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="lastName" class="col-sm-2 control-label">Last Name : </label>

                        <div class="col-sm-6">
                            <input type="text" name="lastName" class="form-control" id="lastName" required="true"
                                   value="${user.lastName}"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">Password : </label>

                        <div class="col-sm-6">
                            <input type="text" name="password" class="form-control" id="password" required="true"
                                   value="${user.password}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Update Info</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </section>
    </div>
</body>
</html>
