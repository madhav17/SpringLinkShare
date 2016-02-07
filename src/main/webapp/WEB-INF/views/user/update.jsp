<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery("#updateUser").on('click',updateUserDetail);
        });

        function updateUserDetail(){
            var userDetails = jQuery("#userInfoForm").serialize();
            ajaxTemplateForSave("/user/updateUser","right-side-panel",userDetails)
        }
    </script>
</head>

<div class="row">
    <div class="col-md-12">
        <section class="panel">
            <header class="panel-heading">Update Profile</header>
            <div class="panel-body">

                <form method="post" class="form-horizontal" id="userInfoForm">
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
                            <button type="button" class="btn btn-default" id="updateUser">Update Info</button>
                        </div>
                    </div>

                </form>
            </div>
        </section>
    </div>
</div>