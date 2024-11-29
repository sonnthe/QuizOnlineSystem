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
@WebServlet(name = "DeletequestionServlet", urlPatterns = {"/Deletequestion"})
public class DeletequestionServlet extends HttpServlet {

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
            out.println("<title>Servlet DeletequestionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeletequestionServlet at " + request.getContextPath() + "</h1>");
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
        String raw_subject = request.getParameter("subject");
        String question = "";
        if (raw_subject != null) {
            if (raw_subject.equals("math")) {
                question = "quiz_Mathquestions";
            }
            if (raw_subject.equals("lit")) {
                question = "quiz_Litquestions";
            }
            if (raw_subject.equals("eng")) {
                question = "quiz_Engquestions";
            }
        }
        String raw_id = request.getParameter("id");
        int id = 0;
        if (raw_id != null) {
            try {
                id = Integer.parseInt(raw_id);
            } catch (NumberFormatException e) {
                System.out.println("");
            }
        }

        String raw_testid = request.getParameter("testid");
        int testid = 0;
        if (raw_testid != null) {
            try {
                testid = Integer.parseInt(raw_testid);
            } catch (NumberFormatException e) {
                System.out.println("");
            }
        }
        crudDAO mathDAO = new crudDAO();
        mathDAO.deleteQuestion(question, id);
        request.getRequestDispatcher("Test?test_id=" + testid + "&subject=" + raw_subject + "").forward(request, response);
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
