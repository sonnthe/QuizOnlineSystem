<%-- 
    Document   : mathTest
    Created on : Jun 11, 2024, 9:33:13 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="navbar2.jsp" %>
        ${requestScope.cook}
        ${requestScope.cook1}
        <br>
        <%!int question_number=1;%> 
        <div class="container-fluid" style="margin-top: 50px">
            <div class="row">
                <div class="col-9 ">
                    <form action="Edit?subject=${requestScope.subject}&testid=${requestScope.testid}" method="post">
                        <div class="row gy-2">
                            <c:forEach items="${requestScope.exam}" var="s">
                                <div class="col-2 " id="${s.id}" >
                                    <div class="p-3 fs-5 border rounded-4 bg-light" >
                                        <p>Question <%=question_number%> </p>
                                        <p style="font-size: 15px">Answered</p>
                                        <p style="font-size: 15px">Marked out of 1.00</p>
                                    </div>   
                                </div>
                                <div class="col-10 " >
                                    <div class="p-3 fs-5 border rounded-4 bg-light">
                                        <span><p>${s.question}</p></span>
                                        <input type="text" name="question" value="${s.question}" hidden>
                                        <input type="text"  class="edit<%=question_number%>" name="editedname<%=question_number%>" value="${s.question}" hidden><a href="Deletequestion?testid=${requestScope.testid}&subject=${requestScope.subject}&id=${s.id}">Delete</a>
                                        <a href="#a" onclick="openEdit(<%=question_number%>)">Edit</a>
                                        <input type="text" name="id" value="${s.id}" hidden>
                                        <input type="text" name="questionnumber" value="<%=question_number%>" hidden>
                                        <hr style="border-top: 2px solid rgba(0, 0, 0, .1);">
                                        <input  type="radio" id="right${s.id}" name="right<%=question_number%>" value="${s.right_an}" disabled >
                                        ${s.right_an}<br>
                                        <input type="text"  class="edit<%=question_number%>" name="editedright_an<%=question_number%>" value="${s.right_an}" hidden><br>
                                        <input type="radio" id="w1${s.id}" name="fwrong<%=question_number%>" value="${s.f_wrong}" disabled >
                                        ${s.f_wrong}<br>
                                        <input type="text"  class="edit<%=question_number%>" name="editedf_wrong<%=question_number%>" value="${s.f_wrong}" hidden><br>
                                        <input type="radio" id="w2${s.id}" name="swrong<%=question_number%>" value="${s.s_wrong}" disabled>
                                        ${s.s_wrong}<br>
                                        <input type="text"  class="edit<%=question_number%>" name="editeds_wrong<%=question_number%>" value="${s.s_wrong}" hidden><br>
                                        <input type="radio" id="w3${s.id}" name="twrong<%=question_number%>" value="${s.t_wrong}" disabled >
                                        ${s.t_wrong}<br>
                                        <input type="text"  class="edit" name="editedt_wrong<%=question_number%>" value="${s.t_wrong}" hidden><br>
                                        <input class="btn btn-primary mb-2 edit<%=question_number%>" type="submit" name="submit" value="Edit" hidden> 
                                        <input class="btn btn-primary mb-2 edit<%=question_number%>" onclick="cancelEdit(<%=question_number%>)" type="button" name="cancel" value="Cancel" hidden> <br>
                                    </div>   
                                </div>
                                <%question_number++;%>  
                                
                            </c:forEach>
                            
                        </div>
                        
                    </form>
                         <a class="btn btn-primary mb-2" href="Linktest?subject=${requestScope.subject}&page=1" target="_self">Back</a>   
                </div>
                <div class="col-3  bg-primary  rounded-4"  style="position: fixed; right:10px" >
                    <br>
                    <div class="row gy-2" >                        
                        <% for(int i=1;i<question_number;i++){%>  
                        <div class="col-2" class="p-3 fs-5 border rounded-4 bg-light">                            
                            <a class="btn btn-light mb-2" href="#<%=i%>" target="_self"><%=i%></a>                  
                        </div>
                        <%}%>
                    </div>                        
                </div>
                    <%question_number=1;%>
            </div>
        </div>   
        <%@include file="footer.jsp" %>
         <script>
                        function openEdit(a) {
                            var elements = document.getElementsByClassName("edit"+a);
                            if (elements[0].hidden === true) {
                                for (let index = 0; index < elements.length; index++) {
                                    elements[index].hidden = false;

                                }
                            }

                        }
                        function cancelEdit(a){
                            var elements = document.getElementsByClassName("edit"+a);
                            if (elements[0].hidden === false) {
                                for (let index = 0; index < elements.length; index++) {
                                    elements[index].hidden = true;

                                }
                            } 
                        }
    </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
