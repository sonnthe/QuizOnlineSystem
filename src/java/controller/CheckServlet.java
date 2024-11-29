/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accuracyDAO;
import dal.crudDAO;
import dal.testContentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.account;
import model.user_answer;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "mathCheckServlet", urlPatterns = {"/Check"})
public class CheckServlet extends HttpServlet {

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
            out.println("<title>Servlet mathCheckServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mathCheckServlet at " + request.getContextPath() + "</h1>");
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
        crudDAO math = new crudDAO();
        testContentDAO testContentDAO = new testContentDAO();
        ArrayList<user_answer> user_answer = new ArrayList<>();
        String raw_id = (String) request.getParameter("testid");
        int id = 0;
        try {
            id = Integer.parseInt(raw_id);
        } catch (NumberFormatException e) {
        }
        String raw_subject = request.getParameter("subject");
        //thong tin cau hoi trong database dua tren testid
        ArrayList data_answer = testContentDAO.getTestid( id);
        //so cau lam dung
        int correctAmount = 0;
        float grade = 0;
        for (int i = 1; i <= testContentDAO.getTestlength( id); i++) {
            String answer = request.getParameter("answer" + i);
            String question = math.getQuestion((int) data_answer.get(i - 1));
            String right_an = math.getCorrectAnswer((int) data_answer.get(i - 1));
            String f_wrong = math.getF_wrong((int) data_answer.get(i - 1));
            String s_wrong = math.getS_wrong((int) data_answer.get(i - 1));
            String t_wrong = math.getT_wrong((int) data_answer.get(i - 1));
            //neu customer co tra loi cau hoi
            if (answer != null) {

                if (answer.equalsIgnoreCase(right_an)) {
                    correctAmount += 1;
                    user_answer u = new user_answer(i, question, right_an, f_wrong, s_wrong, t_wrong, "Correct", answer);
                    user_answer.add(u);

                } else {
                    user_answer u = new user_answer(i, question, right_an, f_wrong, s_wrong, t_wrong, "Incorrect", answer);
                    user_answer.add(u);
                }
            } else {
                user_answer u = new user_answer(i, question, right_an, f_wrong, s_wrong, t_wrong, "Incorrect", answer);
                user_answer.add(u);
            }
            float index = (10 / testContentDAO.getTestlength( id));
            grade = (float) correctAmount * index;
            request.setAttribute("subject", raw_subject);
            request.setAttribute("mark", correctAmount);
            request.setAttribute("grade", grade);
            request.setAttribute("id", id);
            request.setAttribute("user_answer", user_answer);
        }
        accuracyDAO accuracyDAO = new accuracyDAO();
        HttpSession session = request.getSession(false);
        account user = (account) session.getAttribute("user");
        int user_id = user.getId();
        if (raw_subject != null && raw_subject.equalsIgnoreCase("math")) {
            int testNumber = accuracyDAO.getTestnum(user_id, "math_number");
            int accuracy = accuracyDAO.getAccuracy(user_id, "math_accuracy");
            accuracyDAO.updateAccuracy(user_id, "math_accuracy", 1 + accuracy);
            accuracyDAO.updateTestnum(user_id, "math_number", testNumber + 1);
        }
        if (raw_subject != null && raw_subject.equalsIgnoreCase("lit")) {
            int testNumber = accuracyDAO.getAccuracy(user_id, "lit_number");
            int accuracy = accuracyDAO.getAccuracy(user_id, "lit_accuracy");
            accuracyDAO.updateAccuracy(user_id, "lit_accuracy", (int) grade / 10 + accuracy);
            accuracyDAO.updateTestnum(user_id, "lit_number", testNumber + 1);
        }
        if (raw_subject != null && raw_subject.equalsIgnoreCase("eng")) {
            int testNumber = accuracyDAO.getAccuracy(user_id, "eng_number");
            int accuracy = accuracyDAO.getAccuracy(user_id, "eng_accuracy");
            accuracyDAO.updateAccuracy(user_id, "eng_accuracy", (int) grade / 10 + accuracy);
            accuracyDAO.updateTestnum(user_id, "eng_number", testNumber + 1);
        }
        request.setAttribute("userid", user_id);
        try {
            request.getRequestDispatcher("customer/review.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(CheckServlet.class.getName()).log(Level.SEVERE, null, ex);
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
