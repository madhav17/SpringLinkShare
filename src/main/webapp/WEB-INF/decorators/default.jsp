<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="g" uri="/WEB-INF/username.tld" %>
<%@ taglib prefix="p" uri="/WEB-INF/profile.tld" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><dec:title default="playground"/></title>


    <%--global css goes here...--%>
    <spring:url value="/resources/js/app.js" var="appJs"/>
    <spring:url value="/resources/js/bootstrap.min.js" var="bootStrapJs"/>
    <spring:url value="/resources/js/bootstrap-datepicker.js" var="bootStrapDatePickerJs"/>
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/js/jquery.validate.js" var="validateJs"/>
    <spring:url value="/resources/js/jquery-ui-1.10.3.min.js" var="jqueryUIJs"/>

    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS"/>
    <spring:url value="/resources/css/font-awesome.min.css" var="fontCSS"/>
    <spring:url value="/resources/css/style.css" var="styleCSS"/>
    <spring:url value="/resources/css/ionicons.min.css" var="ioniconsCSS"/>


    <style type="text/css">@import "${bootstrapCSS}"; </style>
    <style type="text/css">@import "${fontCSS}"; </style>
    <style type="text/css">@import "${styleCSS}"; </style>
    <style type="text/css">@import "${ioniconsCSS}"; </style>

    <script src="${jqueryJs}" type="text/javascript"></script>
    <script src="${jqueryUIJs}" type="text/javascript"></script>
    <script src="${bootStrapJs}" type="text/javascript"></script>
    <script src="${bootStrapDatePickerJs}" type="text/javascript"></script>
    <script src="${appJs}" type="text/javascript"></script>
    <script src="${validateJs}" type="text/javascript"></script>

    <%--<jsp:useBean id="userProfile" class="com.intelligrape.TagLibBean.UserProfile" scope="request"/>--%>

    <%-- Links varaibles   --%>
    <c:set value="/topic/create" var="createTopicLink" />

    <dec:head/>
</head>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<header class="header">
    <a href="#" class="logo">
        Link Sharing
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">

        <div class="navbar-right">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->
                <li class="dropdown messages-menu">

                    <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                        <%--<span><jsp:getProperty name="userProfile" property="fullName"/> <i class="caret"></i></span>--%>
                        <%--<span><g:UserName/><i class="caret"></i></span>--%>
                        <!-- Setting value in session when user get Logged in-->
                        <span><%= (String)session.getAttribute("username")%><i class="caret"></i></span>
                    </a>
                    <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                        <li class="dropdown-header text-center">Account</li>

                        <li class="divider"></li>

                        <li>
                            <%--<a href=<jsp:getProperty name="userProfile" property="url"/>>--%>
                            <%--<a href=<p:Profile/>>--%>
                            <a href=<%= (String)session.getAttribute("profileUrl")%>

                                Profile
                            </a>
                            <a data-toggle="modal" href="#modal-user-settings">

                                Settings
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/login/logout"> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">

                </div>
                <div class="pull-left info">
                    <p>Hello,
                        <%--<jsp:getProperty name="userProfile" property="fullName"/>--%>
                        <%--<g:UserName/>--%>
                        <%= (String)session.getAttribute("username")%>
                    </p>


                </div>
            </div>
            <ul class="sidebar-menu">
                <li class="active">
                    <a href="#">
                        <i></i> <span>Dashboard</span>
                    </a>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-tasks"></i>
                        <span>Topic</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="${createTopicLink}"><i class="fa fa-angle-double-right"></i> Create Topic </a></li>
                        <li><a href=""><i class="fa fa-angle-double-right"></i> List Topic </a></li>
                        <li><a href=""><i class="fa fa-angle-double-right"></i> Search Topic</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#">
                        <i></i> <span>Basic Elements</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i></i> <span>Simple tables</span>
                    </a>
                </li>

            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <aside class="right-side">


        <!-- row end -->
        </section><!-- /.content -->
        <div class="content">

            <dec:body/>

        </div>
        <%--<div class="footer-main">--%>
        <%--Link Sharing--%>
        <%--</div>--%>
    </aside>
    <!-- /.right-side -->

</div>
<!-- ./wrapper -->


</body>




