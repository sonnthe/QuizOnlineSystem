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
        <br>
        <%!int question_number=1;%> 
        <div class="container-fluid" style="margin-top: 50px">

            <div class="row">
                <div class="col-9 ">
                    <div class="p-3 fs-5 border rounded-4 bg-light">${requestScope.testname}</div><br>
                    <form id="myForm" action="Check?subject=${requestScope.subject}&testid=${requestScope.testid}" method="post" >
                        <div class="row gy-2">
                            <c:forEach items="${requestScope.exam}" var="s">
                                <div class="col-2 " id="div<%=question_number%>" >
                                    <div class="p-3 fs-5 border rounded-4 bg-light">
                                        <p >Question <%=question_number%> </p>
                                        <p id="checkedAnswer<%=question_number%>" style="font-size: 15px">Not Answered</p>
                                        <p style="font-size: 15px">Marked out of 1.00</p>
                                    </div>   
                                </div>
                                <div class="col-10 " >
                                    <div class="p-3 fs-5 border rounded-4 bg-light">
                                        <p>${s.question}</p>
                                        <hr style="    border-top: 2px solid rgba(0, 0, 0, .1);">
                                        <input onclick="checkAnswer('<%=question_number%>')"  class="<%=question_number%>" type="radio" id="right${s.id}" name="answer<%=question_number%>" value="${s.right_an}" >
                                        ${s.right_an}<br>
                                        <input onclick="checkAnswer('<%=question_number%>')"  class="<%=question_number%>"   type="radio" id="w1${s.id}" name="answer<%=question_number%>" value="${s.f_wrong}" >
                                        ${s.f_wrong}<br>
                                        <input onclick="checkAnswer('<%=question_number%>')"  class="<%=question_number%>"  type="radio" id="w2${s.id}" name="answer<%=question_number%>" value="${s.s_wrong}">
                                        ${s.s_wrong}<br>
                                        <input onclick="checkAnswer('<%=question_number%>')"  class="<%=question_number%>"  type="radio" id="w3${s.id}" name="answer<%=question_number%>" value="${s.t_wrong}" >
                                        ${s.t_wrong}<br> 
                                        <input onclick="resets('<%=question_number%>')"  class="btn btn-primary mb-2" value="Reset">
                                    </div>   
                                </div>
                                <%question_number++;%>

                            </c:forEach>
                        </div>
                        <input class="btn btn-primary mb-2" type="submit"  value="Submit"> 
                    </form>
                </div>
                <div class="col-3  bg-primary  rounded-4"  style="position: fixed; right:10px" ><br>
                    <div class="row gy-2" >                    
                        <% for(int i=1;i<question_number;i++){%>  
                        <div class="col-2" class="p-3 fs-5 border rounded-4 bg-light"  >                            
                            <a id="<%=i%>" style="background-color: "  class="btn btn-light mb-2" href="#div<%=i%>" target="_self"><%=i%></a>                  
                        </div>
                        <%}%>
                    </div>   
                    <div class="row p-3 fs-5 border rounded-4 bg-light" id="timer">
                        Time left: 01:00
                    </div>
                </div>
            </div>
                     <%question_number=1;%>
        </div>   
        <%@include file="footer.jsp" %>
        <script>

            var timerElement = document.getElementById("timer");
            var totalSeconds = 1 * 60; // Thời gian thi là 60 phút

            function updateTimer() {
                var minutes = Math.floor(totalSeconds / 60);
                var seconds = totalSeconds % 60;

                timerElement.textContent = "Time left: " + minutes.toString().padStart(2, "0") + ":" + seconds.toString().padStart(2, "0");

                if (totalSeconds <= 0) {
                    clearInterval(timerInterval);
                    const myForm = document.getElementById('myForm');
                alert("Out of time");
                myForm.submit();
                } else {
                    totalSeconds--;
                }
            }

            var timerInterval = setInterval(updateTimer, 1000);

            function checkAnswer(b) {    
                var count = 0;                
                var elements = document.getElementsByClassName(b);
                for (let i = 0; i < elements.length; i++) {
                    if (elements[i].checked === true) {
                        count++;
                    }
                }
                if (count >= 0) {
                    document.getElementById('checkedAnswer'+b).innerHTML = "Answered";
                    link=document.getElementById(b);
                    link.style.background='burlywood';
                }
            }
            function resets(b){
                var elements = document.getElementsByClassName(b);
                for (let i = 0; i < elements.length; i++) {
                    elements[i].checked=false;                                           
                }
                document.getElementById('checkedAnswer'+b).innerHTML = "Not Answered";
                link=document.getElementById(b);
                    link.style.background='#f8f9fa';
            }

        </script>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
