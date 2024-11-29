    <%-- 
    Document   : navbar1
    Created on : Jun 6, 2024, 10:38:04 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style/navbar.css"/>
        <script src="https://kit.fontawesome.com/f36b960bbe.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary" >
            <a class="navbar-brand" href="Studentsurvey.jsp">
                <i class="fa-solid fa-ghost"></i>
            </a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="width: 60%">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link" id="privacy" href="dieu_khoan.jsp">About us<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item     ">
                        <a class="nav-link" href="dieu_khoan.jsp">Policies<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Rules</a>
                    </li>
                </ul>                                       
            </div>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="justify-content: right">
                <a class="nav-link" style="color: #f8f9fa">Please sign in for further information !</a>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
