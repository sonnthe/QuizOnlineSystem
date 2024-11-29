<%-- 
    Document   : mathScore
    Created on : Jun 12, 2024, 11:38:47 AM
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
    <body  >
        <%@include file="navbar2.jsp" %>
        <br>

        <!-- comment -->


        <%!int question_number=1;%> 
        <div class="container-fluid" style="margin-top: 50px">

            <div class="row">
                <div class="col-9 ">
                    <div class="p-3 fs-5 border rounded-4 bg-light">
                        <table  border="0" style="width: 100%;">
                            <thead>
                                <tr>
                                    <th>Test ID:</th>
                                    <th>${requestScope.id}</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>Marks</td>
                                    <td>${requestScope.mark}</td>
                                </tr>
                                <tr>
                                    <td>Grade</td>
                                    <td>${requestScope.grade}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div><br>
                    <div class="row gy-2">
                        <c:forEach items="${requestScope.user_answer}" var="s">
                            <div class="col-2 " >
                                <div class="p-3 fs-5 border rounded-4 bg-light">
                                    <p id="${s.id}">Question <%=question_number%> </p>
                                    <p style="font-size: 15px">${s.user_answer eq null ?'Not Answered':'Answered'}</p>
                                    <p style="font-size: 15px">Marked out of 1.00</p>
                                </div>   
                            </div>
                            <div class="col-10 " >
                                <div class="p-3 fs-5 border rounded-4 bg-light" id="${s.id}">
                                    <p >${s.id}.${s.question}   </p>
                                    <hr style="    border-top: 2px solid rgba(0, 0, 0, .1);">
                                      <input type="radio" id="right${s.id}" name="answer${s.id}" value="${s.right_an}" disabled  ${s.user_answer eq s.right_an?'checked':''} >
                                      ${s.right_an}<br>
                                      <input type="radio" id="w1${s.id}" name="answer${s.id}" disabled ${s.user_answer eq s.f_wrong?'checked':''} >
                                      <label for="w1">${s.f_wrong}</label><br>
                                      <input type="radio" id="w2${s.id}" name="answer${s.id}" disabled ${s.user_answer eq s.s_wrong?'checked':''} >
                                      <label for="w2">${s.s_wrong}</label><br>
                                      <input type="radio" id="w3${s.id}" name="answer${s.id}" disabled ${s.user_answer eq s.t_wrong?'checked':''}>
                                      <label for="w3">${s.t_wrong}</label><br>
                                    <p style="background-color:${s.check=='Correct'?'#007bff':'red'} " class="p-3 fs-5 border rounded-4 ">${s.check}   </p>
                                    <c:if test="${s.check=='Incorrect'}">
                                        <p class="p-3 fs-5 border rounded-4 bg-primary">Correct answer:${s.right_an}</p>
                                    </c:if>
                                </div>   
                            </div>
                            <%question_number++;%>
                        </c:forEach>
                        
                    </div>
                    <a  class="btn btn-primary mb-2" href="Test?subject=${requestScope.subject}&test_id=${requestScope.id}" target="_self">Re-attempt</a><br>
                    <a  class="btn btn-primary mb-2" href="Linktest?subject=${requestScope.subject}&page=1" target="_self">Finish review</a>
                </div>
                     <div class="col-3  bg-primary  rounded-4"  style="position: fixed; right:10px" ><br>
                    <div class="row gy-2" >                    
                        <% for(int i=1;i<question_number;i++){%>  
                        <div class="col-2" class="p-3 fs-5 border rounded-4 bg-light" id="<%=i%>">                            
                            <a class="btn btn-light mb-2" href="#<%=i%>" target="_self"><%=i%></a>                  
                        </div>
                        <%}%>
                    </div>   
                    <%question_number=1;%>
                </div>
            </div>
        </div>   
        <%@include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
