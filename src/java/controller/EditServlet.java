/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.crudDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/Edit"})
public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_subject = request.getParameter("subject");
        String test_id = request.getParameter("testid");
        String raw_question_id = request.getParameter("id");
        int question_id = 0;
        try {
            question_id = Integer.parseInt(raw_question_id);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        String raw_questionnumber = request.getParameter("questionnumber");
        int questionnumber = 0;
        try {
            questionnumber = Integer.parseInt(raw_questionnumber);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        crudDAO math = new crudDAO();
        String data_answer = "";
        String data_question = "";
        if (raw_subject != null) {
            if (raw_subject.equals("math")) {
                data_answer = "Math_answer";
                data_question = "quiz_Mathquestions";
            }
            if (raw_subject.equals("lit")) {
                data_answer = "Lit_answer";
                data_question = "quiz_Litquestions";
            }
            if (raw_subject.equals("eng")) {
                data_answer = "Eng_answer";
                data_question = "quiz_Engquestions";
            }
        }
        String question = request.getParameter("question");
        String rightan = request.getParameter("right" + questionnumber);
        String fwrong = request.getParameter("fwrong" + questionnumber);
        String swrong = request.getParameter("swrong" + questionnumber);
        String twrong = request.getParameter("twrong" + questionnumber);
        String edited_question = request.getParameter("editedname" + questionnumber);
        if(edited_question==null){ 
            edited_question="question";
       }
        String edited_rightan = request.getParameter("editedright_an" + questionnumber);
        if(edited_rightan==null){
            edited_rightan=rightan;
        }
        String edited_fwrong = request.getParameter("editedf_wrong" + questionnumber);
        if(edited_fwrong==null){
            edited_fwrong=fwrong;
        }
        String edited_swrong = request.getParameter("editeds_wrong" + questionnumber);
        if(edited_swrong==null){
            edited_swrong=swrong;
        }
        String edited_twrong = request.getParameter("editedt_wrong" + questionnumber);
        if(edited_twrong==null){
            edited_twrong=twrong;
        }
            math.updateQuestion(data_question, edited_question, question_id);
        math.updateAnswer(data_answer, edited_rightan, edited_fwrong, edited_swrong, edited_twrong, question_id);

        request.setAttribute("test_id", test_id);
        request.setAttribute("subject", raw_subject);
        request.getRequestDispatcher("Test?test_id=" + test_id + "&subject=" + raw_subject + "").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
