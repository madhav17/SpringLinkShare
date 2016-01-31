<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--for j spring security--%>
<html>
<head>
</head>
<body>


<!-- Top content -->
<div class="top-content" style="background-color:#39435C;width: 100%;height: 100%;">


    <c:if test="${not empty error}">
        <div class="infoMsg">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="infoMsg">${msg}</div>
    </c:if>


    <div class="inner-bg" style="width: 100%;height: 100%;">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Link Sharing</strong> Login Form</h1>

                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>

                            <p>Enter your username and password to log on:</p>
                        </div>

                    </div>
                    <div class="form-bottom">
                        <%--<form:form method="post" action="/login/home">--%>
                        <%--<form name="login" action="<c:url value='/j_spring_security_check' />" method='POST'>--%>
                        <form name="login" action="/login/signIn" method='POST'>
                            <div class="form-group">
                                <label class="sr-only" for="username">Username</label>
                                <input type="text" name="username" placeholder="Username..."
                                       class="form-username form-control" id="username" required="true">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-password form-control" id="password" required="true">
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">

                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#">
                            Google Plus
                        </a>
                        <a class="btn btn-link-2" href="/login/forgotPassword">
                            Forgot Password
                        </a>
                        <a class="btn btn-link-2" href="/login/signUp">
                            Register
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
