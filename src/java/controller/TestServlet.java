/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.testContentDAO;
import dal.testNameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.account;
import model.testContent;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "mathTestServlet", urlPatterns = {"/Test"})
public class TestServlet extends HttpServlet {

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
            out.println("<title>Servlet mathTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mathTestServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        if (session == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            account account = (account) session.getAttribute("user");
            String id = request.getParameter("test_id");
            int test_id = 0;
            try {
                test_id = Integer.parseInt(id);
            } catch (NumberFormatException e) {
            }
            String raw_subject = request.getParameter("subject");
            testContentDAO testContentDAO = new testContentDAO();
            testNameDAO testNameDAO = new testNameDAO();
            //lay de test dua tren test id
            ArrayList<testContent> list = testContentDAO.getTest(test_id);
            request.setAttribute("exam", list);
            request.setAttribute("testname", testNameDAO.getTestname( test_id));
            request.setAttribute("subject", raw_subject);
            request.setAttribute("testid", id);
            if (account.getRole() == 1) {
                request.getRequestDispatcher("expert/test.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("customer/test.jsp").forward(request, response);
            }
        }

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
        String raw_id = request.getParameter("test_id");
        int test_id = Integer.parseInt(raw_id);
        String raw_subject = request.getParameter("subject");
        String subject = "";
        String answer = "";
        if (raw_subject.equalsIgnoreCase("math")) {
            subject = "quiz_Mathquestions";
            answer = "Math_answer";
        }
        if (raw_subject.equalsIgnoreCase("lit")) {
            subject = "quiz_Litquestions";
            answer = "Lit_answer";
        }
        if (raw_subject.equalsIgnoreCase("eng")) {
            subject = "quiz_Engquestions";
            answer = "Eng_answer";
        }
        testContentDAO examDAO = new testContentDAO();
        ArrayList<testContent> list = examDAO.getTest(test_id);
        request.setAttribute("exam", list);
        request.setAttribute("subject", raw_subject);
        request.setAttribute("testid", test_id);
        try {
            request.getRequestDispatcher("expert/test.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
