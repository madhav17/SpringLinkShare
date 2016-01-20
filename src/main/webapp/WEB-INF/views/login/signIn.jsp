<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--for j spring security--%>
<html>
<head>
</head>
<body style="text-align: center;margin-top: 10%;background-color: cadetblue;">


<!-- Top content -->
<div class="top-content" style="background-color:#39435C;">


    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>


    <div class="inner-bg">
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
                    <h3>...or login with:</h3>

                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#">
                            Facebook
                        </a>
                        <a class="btn btn-link-2" href="#">
                            Twitter
                        </a>
                        <a class="btn btn-link-2" href="#">
                            Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<a href="/login/signUp"> Register </a>
</body>
</html>
