<%-- 
    Document   : toan
    Created on : Jun 11, 2024, 9:29:16 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.account" %>
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
        <br>
        <div class="container-fluid" style="margin-top: 50px">
            <div class="row">
                <div class="col-3 rounded-4" style="background-color: bisque">
                    <br>
                    <form action="search">
                        <input type="text" name="subject" value="${requestScope.subject}" hidden>
                        <input type="text" name="page" value="1" hidden>
                        <table border="0" style="border-collapse: collapse">
                            <tbody>
                                <tr>
                                    <td>Publication time:</td>
                                    <td><input class="rounded-3 " type="text" name="time"></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" name="yearSubmit" value="Search by Year"  class="btn btn-primary mb-2"></td>                                   
                                </tr>
                                <tr>
                                    <td>Level:</td>
                                    <td><select class="rounded-3 " name="level" >
                                            <option value="Hard">Hard</option>
                                            <option value="Normal">Normal</option>
                                            <option value="Easy">Easy</option>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" name="levelSubmit" value="Search by Level"  class="btn btn-primary mb-2"></td>                                   
                                </tr>
                                          
                            </tbody>
                        </table>

                    </form>

                </div>
                <div class="col-9 ">
                    <form action="Deletetest?subject=${requestScope.subject}" method="post">
                        <div class="row gy-2">


                            <c:forEach items="${requestScope.test}" var="s">
                                <div class="col-5 " >
                                    <a href="Test?subject=${requestScope.subject}&test_id=${s.id}" class="p-3 fs-5 border rounded-4 bg-light" target="_self" style="display: block;text-decoration: none;color: black">
                                        ${s.test_name}<br>
                                        <span style="color: black;font-size: 80%;opacity: 50%">Description: ${s.description}<br><br>
                                            Publication Time: ${s.publication}<br><br>
                                        Level: ${s.level}</span>
                                    </a> 

                                </div>
                            </c:forEach>

                        </div>
                    </form>
                        <nav aria-label="Page navigation example">
                        <ul class="pagination">
                           
                                <%int pageAmount =(int)request.getAttribute("pageAmount");
                                 for(int i=1;i<=pageAmount;i++){%>
                            <li class="page-item"><a class="page-link" href="Linktest?subject=${requestScope.subject}&page=<%=i%>"><%=i%></a></li>
                                <%}%>
                           
                        </ul>
                    </nav>
                </div>
            </div>
        </div> 
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    </body>

</html>
