<%-- 
    Document   : navbar2
    Created on : Jun 6, 2024, 10:39:40 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/f36b960bbe.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary"  >
            <div class="container-fluid" style="width: 3%"  >
                <a class="navbar-brand" href="main">
                    <i class="fa-solid fa-ghost"></i>
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="width: 80%" >
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item" >
                        <a class="nav-link" href="dashboard">Dash Board </a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="alluser">List of Users</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="classlist">List of Subjects</a>
                    </li>
                    <li class="nav-item" >
                        <a class="nav-link" href="dashboard">Accuracies </a>
                    </li>
                   
                </ul>

            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="width: 20%" >
                <a class="nav-link" style="color: #fff">Welcome back ${sessionScope.user.getDisplay_name()} !</a>
            </div>
            <div class="collapse navbar-collapse nav-item dropdown " id="navbarSupportedContent">
                <a class="navbar-brand" href="#"  data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="fa-solid fa-circle-user"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-end"  >
                    <a class="dropdown-item" href="profile.jsp">Profile</a>
                    <a class="dropdown-item" href="Logout">Logout</a>
                </div>
            </div>
        </nav>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
