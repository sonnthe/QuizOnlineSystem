<%-- 
    Document   : profile
    Created on : Jun 23, 2024, 1:13:02 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/f36b960bbe.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="navbar2.jsp" %>
        <section style="background-color: #eee; margin-top: 50px" >
            <div class="container py-5">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4 rounded-4">
                            <div class="card-body text-center">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar"
                                     class="rounded-circle img-fluid" style="width: 150px;">
                                <h5 class="my-3">${requestScope.user.getDisplay_name()}</h5>
                                <p class="text-muted mb-1">${requestScope.user.getRole()==1?"Admin":"User"}</p>                               
                            </div>
                        </div>
                        <div class="card mb-4 mb-lg-0 ">
                            <div class="card-body p-0">
                                <ul class="list-group list-group-flush rounded-3 ">
                                    <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                        <i class="fab fa-github fa-lg text-body"></i>
                                        <p class="mb-0">mdbootstrap</p>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                        <i class="fab fa-twitter fa-lg" style="color: #55acee;"></i>
                                        <p class="mb-0">@mdbootstrap</p>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center p-3">
                                        <i class="fab fa-facebook-f fa-lg" style="color: #3b5998;"></i>
                                        <p class="mb-0">mdbootstrap</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 ">
                        <form action="">
                            <div class="card mb-4 rounded-4">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Full Name</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${requestScope.user.getDisplay_name()}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Email</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${requestScope.user.getEmail()}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">Phone</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${requestScope.user.getPhone_number()}</p>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <p class="mb-0">School</p>
                                        </div>
                                        <div class="col-sm-9">
                                            <p class="text-muted mb-0">${requestScope.user.getSchool()}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form><br>
                        <div class="row">
                            <c:forEach items="${requestScope.user.getAccuracy_id()}" var="s">
                                <div class="col-md-4">
                                    <div class="card mb-4 mb-md-0 rounded-4">
                                        <div class="card-body">
                                            <p class="mb-4"> ${s.subject}
                                            </p>
                                            <p class="mb-1" style="font-size: .77rem;">Number of test taken:${s.numberTest}</p>
                                            <p class="mt-4 mb-1" style="font-size: .77rem;">Accuracy: ${s.accuracy}%</p>
                                            <div class="progress rounded" style="height: 5px;">
                                                <div class="progress-bar" role="progressbar" style="width: ${s.accuracy}%" aria-valuenow="89"
                                                     aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>       
                        </div>
                    </div>
                </div>
                <a href="userlist?id=1" target="_self"  class="btn btn-primary mb-2">Back</a>
            </div>

        </section>
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
