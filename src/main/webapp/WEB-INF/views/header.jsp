<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="/">Super Projekt</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar Search -->
    <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <%--<div class="input-group">--%>
            <%--<input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">--%>
            <%--<div class="input-group-append">--%>
                <%--<button class="btn btn-primary" type="button">--%>
                    <%--<i class="fas fa-search"></i>--%>
                <%--</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    </form>

    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
        <%--<li class="nav-item dropdown no-arrow mx-1">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--<i class="fas fa-bell fa-fw"></i>--%>
                <%--<span class="badge badge-danger"></span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
        <%--</li>--%>
        <%--<li class="nav-item dropdown no-arrow mx-1">--%>
            <%--<a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--<i class="fas fa-envelope fa-fw"></i>--%>
                <%--<span class="badge badge-danger"></span>--%>
            <%--</a>--%>
            <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">--%>
                <%--<a class="dropdown-item" href="#">Action</a>--%>
                <%--<a class="dropdown-item" href="#">Another action</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<a class="dropdown-item" href="#">Something else here</a>--%>
            <%--</div>--%>
        <%--</li>--%>
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-circle fa-fw"></i>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">Settings</a>
                <a class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
            </div>
        </li>
    </ul>

</nav>

<div id="wrapper">
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <h6 class="dropdown-header">Login Screens:</h6>
                <a class="dropdown-item" href="/login">Login</a>
                <a class="dropdown-item" href="/user/search">Search</a>

                <security:authorize access="hasRole('ADMIN')">
                <a class="dropdown-item" href="/admin/register">Register</a>
                <a class="dropdown-item" href="/admin/newserver">New Server</a>
                    <a class="dropdown-item" href="/user/allsetings">All setings</a>
                    <a class="dropdown-item" href="/user/seting">Add seting</a>
                </security:authorize>
                <a class="dropdown-item" href="/user/servers">Servers</a>
                <a class="dropdown-item" href="/user/banlist">Ban list</a>





                <%--<a class="dropdown-item" href="forgot-password">Forgot Password</a>--%>
                <%--<div class="dropdown-divider"></div>--%>
                <%--<h6 class="dropdown-header">Other Pages:</h6>--%>
                <%--<a class="dropdown-item" href="404">404 Page</a>--%>
                <%--<a class="dropdown-item" href="blank">Blank Page</a>--%>
            </div>
        </li>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">--%>
                <%--<i class="fas fa-fw fa-chart-area"></i>--%>
                <%--<span>Charts</span></a>--%>
        <%--</li>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">--%>
                <%--<i class="fas fa-fw fa-table"></i>--%>
                <%--<span>Tables</span></a>--%>
        <%--</li>--%>
    </ul>
        <c:if test="${not empty message}">
            <div class="alert alert-success">
                    ${message}
            </div>
        </c:if>

