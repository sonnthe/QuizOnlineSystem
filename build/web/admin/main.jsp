<%-- 
    Document   : firstlook
    Created on : Jun 5, 2024, 9:53:40 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="dal.subjectDAO" %>
        <%@ page import="model.subject" %>
        <%@ page import="java.util.ArrayList" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <header>
            <%@include file="navbar2.jsp" %>
        </header>
        <br>
        <%
        subjectDAO subjectDAO = new subjectDAO();
            ArrayList<subject> subject_list = subjectDAO.getSubject();
        %>
        <div class="container" style="margin-top: 50px">
            <c:forEach items="<%=subject_list%>" var="s">
                <div class="row p-3 fs-5 border rounded-4 bg-light" >
                    <a  href="Linktest?subject=${s.scode}&page=1" style="display: block;text-decoration: none;color: black">${s.sname}<br><br>
                        <span style="color: black;font-size: 75%;opacity: 50%"> ${s.description}</span></a>
                </div>
                <br>
            </c:forEach>
        </div>
        <%@include file="footer.jsp"%>
        <script src="js/js.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    </body>
</html>
