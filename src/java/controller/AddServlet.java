/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.crudDAO;
import dal.testContentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/Add"})
public class AddServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter out =response.getWriter();
        crudDAO math = new crudDAO();
        testContentDAO testContentDAO =new testContentDAO();
        String raw_id = request.getParameter("testid");
        int id = 0;
        try {
            id = Integer.parseInt(raw_id);
        } catch (NumberFormatException e) {
        }
        String raw_subject = request.getParameter("subject");
        String a="a";
        out.print(raw_id);
        out.print(raw_subject);
        out.print(a);
        String subject = "";
        String data_answer = "";
        if (raw_subject != null) {
            if (raw_subject.equals("math")) {
                subject = "quiz_Mathquestions";
                data_answer = "Math_answer";
            }
            if (raw_subject.equals("lit")) {
                subject = "quiz_Litquestions";
                data_answer = "Lit_answer";
            }
            if (raw_subject.equals("eng")) {
                subject = "quiz_Engquestions";
                data_answer = "Eng_answer";
            }
        }
        ArrayList data_answerId = testContentDAO.getTestid( id);
        for (int i = 1; i <= data_answerId.size(); i++) {
            String question = request.getParameter("addedquestion" + i);
            math.updateQuestion(subject, question, (int) data_answerId.get(i - 1));
            math.addAnswer(data_answer, (int) data_answerId.get(i - 1));
            String right_an = request.getParameter("addedright_an" + i);
            String f_wrong = request.getParameter("addedf_wrong" + i);
            String s_wrong = request.getParameter("addeds_wrong" + i);
            String t_wrong = request.getParameter("addedt_wrong" + i);
            math.updateAnswer(data_answer, right_an, f_wrong, s_wrong, t_wrong, (int) data_answerId.get(i - 1));
        }
        request.setAttribute("id", id);
        request.setAttribute("sub", subject);
        request.setAttribute("list", data_answerId);
        int current_page=(int) Math.floor(id/4)+1;
        request.getRequestDispatcher("Linktest?page="+current_page+"&subject="+raw_subject+"").forward(request, response);
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
