<%-- 
    Document   : userlist
    Created on : Jul 10, 2024, 6:41:40 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/f36b960bbe.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="navbar2.jsp" %>
        b
        <div class="container-fluid" style="margin-top: 60px; margin-bottom: 20px">
            <table class="table table-striped">
                <thead>
                <th>ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>Role</th>
                <th>Display Name</th>
                <th>Email</th>
                <th>School</th>
                <th>Phone number</th>
                </thead>
                <c:forEach items="${requestScope.userlist}" var="s">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.user_name}</td>
                        <td>${s.pass}</td>
                        <td>${s.role==1?'Admin':'User'}</td>
                        <td>${s.display_name}</td>
                        <td>${s.email}</td>
                        <td>${s.school}</td>
                        <td>${s.phone_number}</td>
                        <td><a><a href="account?action=view&id=${s.id}" target="_self">View Profile</a></td>
                        <td><a><a href="account?action=del&id=${s.id}&classid=${s.class_id}" target="_self">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
          
        </div>
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    </body>
</html>
