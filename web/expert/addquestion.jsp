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
        <%String raw_question_number=request.getParameter("num");
           int question_number = 0;
        try {
            question_number = Integer.parseInt(raw_question_number);
        } catch (NumberFormatException e) {
        }
           String raw_testid=request.getParameter("testid");
              int testid = 0;
        try {
           testid = Integer.parseInt(raw_testid);
        } catch (NumberFormatException e) {
        }
           String subject=request.getParameter("subject");
        %> 
        <div class="container-fluid" style="margin-top: 50px">
            <div class="row">
                <div class="col-9 ">
                    <form action="Add " method="post">
                        <div class="row gy-2">
                            <%for(int i=1;i<=question_number;i++){%>   
                            <div class="col-2 "  >
                                <div class="p-3 fs-5 border rounded-4 bg-light" >
                                    <p>Question <%=i%> </p>
                                    <p style="font-size: 15px">Answered</p>
                                    <p style="font-size: 15px">Marked out of 1.00</p>
                                </div>   
                            </div>
                            <div class="col-10 " >
                                <div class="p-3 fs-5 border rounded-4 bg-light">
                                    <span><p>Question:</p></span>
                                    <input type="text" name="subject" value="<%=subject%>" hidden>
                                    <input type="text" name="testid" value="<%=testid%>" hidden>
                                    <input type="text"  name="addedquestion<%=i%>"  >
                                    <hr style="border-top: 2px solid rgba(0, 0, 0, .1);">
                                    <input type="text"  name="addedright_an<%=i%>"  ><br>
                                    <input type="text"  name="addedf_wrong<%=i%>"  ><br>
                                    <input type="text"   name="addeds_wrong<%=i%>"  ><br>
                                    <input type="text"   name="addedt_wrong<%=i%>"  ><br>
                                   
                                </div>   
                            </div>
                            <%}%>
                             <input class="btn btn-primary mb-2" type="submit" name="submit" value="Add"> <br>
                        </div>
                    </form>
                </div>
            </div>
        </div>   
        <%@include file="footer.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
