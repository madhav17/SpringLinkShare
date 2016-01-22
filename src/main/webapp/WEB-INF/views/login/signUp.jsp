<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="top-content" style="background-color:#39435C;width: 100%;height: 100%;">


    <div class="inner-bg" style="width: 100%;height: 100%;">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Link Sharing</strong> Registration Form</h1>

                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Resgiter to our site</h3>

                            <p>Enter your details to register:</p>
                        </div>

                    </div>
                    <div class="form-bottom">
                        <form:form method="post" action="/user/register">
                            <div class="form-group">
                                <label class="sr-only" for="firstName">First Name : </label>
                                <input type="text" class="form-username form-control" name="firstName" id="firstName"
                                       required="true" placeholder="First Name"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="lastName">Last Name : </label>
                                <input type="text" class="form-username form-control" name="lastName" id="lastName"
                                       required="true" placeholder="Last Name"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="userName">User Name : </label>
                                <input type="email" class="form-username form-control" name="username" id="username"
                                       required="true" placeholder="User Name"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password : </label>
                                <input type="text" class="form-username form-control" name="password" id="password"
                                       required="true" placeholder="Password"/>
                            </div>

                            <button type="submit" class="btn">Register</button>

                        </form:form>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                            <div class="social-login-buttons">
                                <a class="btn btn-link-2" href="/login/signIn">
                                    Login
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
