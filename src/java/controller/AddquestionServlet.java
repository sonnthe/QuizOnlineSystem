    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.crudDAO;
import dal.subjectDAO;
import dal.testNameDAO;
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
@WebServlet(name = "AddquestionServlet", urlPatterns = {"/Addquestion"})
public class AddquestionServlet extends HttpServlet {

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
            out.println("<title>Servlet AddquestionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddquestionServlet at " + request.getContextPath() + "</h1>");
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
        String raw_num = request.getParameter("num");
        int num = 0;
        try {
            num = Integer.parseInt(raw_num);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        String test_name = request.getParameter("testname");
        String raw_test = request.getParameter("subject");
        String subject = "";
        String test="";
        if (raw_test != null) {
            if (raw_test.equals("math")) {
                test = "test_Mathname";
                subject = "quiz_Mathquestions";
            }
            if (raw_test.equals("lit")) {
                test = "test_Litname";
                subject = "quiz_Litquestions";
            }
            if (raw_test.equals("eng")) {
                test = "test_Engname";
                subject = "quiz_Engquestions";
            }
        }
        subjectDAO mySubjectDAO=new subjectDAO();
        int subject_id=mySubjectDAO.getSidByScode(raw_test);
        crudDAO mathDAO = new crudDAO();
        testNameDAO testNameDAO =new testNameDAO();
        mathDAO.addTest(test_name,2,subject_id);
        for(int i=0;i<num;i++){
            mathDAO.addQuestion(test, testNameDAO.getMaxTestid());
        }
        
       // request.getRequestDispatcher("addtest_admin.jsp").f
        request.getRequestDispatcher("expert/addquestion.jsp?num="+num+"&subject="+raw_test+"&testid="+testNameDAO.getMaxTestid()+"").forward(request, response);
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
