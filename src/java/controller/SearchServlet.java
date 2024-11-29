/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.testNameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.account;
import model.testName;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet SearchServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }  int numberOftestPerpage = 4;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
        testNameDAO testNameDAO =new testNameDAO();
         String raw_page = request.getParameter("page");
            int page = 0;
            try {
                page = Integer.parseInt(raw_page);
            } catch (NumberFormatException e) {
            }
       String publication_time=request.getParameter("time");
       int time=0;
        try {
            time=Integer.parseInt(publication_time);
        } catch (NumberFormatException e) {
        }
       String level=request.getParameter("level");
       String levelSubmit=request.getParameter("levelSubmit");
       String yearSubmit=request.getParameter("yearSubmit");
        String raw_subject = request.getParameter("subject");
            String test_name = "";
            if (raw_subject != null) {
                if (raw_subject.equals("math")) {
                    test_name = "test_Mathname";
                }
                if (raw_subject.equals("lit")) {
                    test_name = "test_Litname";
                }
                if (raw_subject.equals("eng")) {
                    test_name = "test_Engname";
                }
            }
            int offset = (page - 1) * numberOftestPerpage;
            int amount =0;
       if(yearSubmit!=null){
           ArrayList<testName> search_list=testNameDAO.getTestByTime(test_name, offset, numberOftestPerpage, time);
           amount=testNameDAO.getTestAmountWithtime(test_name, time);
           int pageAmount = 0;
            if (amount % numberOftestPerpage == 0) {
                pageAmount = amount / numberOftestPerpage;
            } else {
                pageAmount = amount / numberOftestPerpage + 1;
            }
              request.setAttribute("test", search_list);
            request.setAttribute("pageAmount", pageAmount);
            request.setAttribute("subject", raw_subject);
            request.setAttribute("time",time );
                request.getRequestDispatcher("searchlist_fortime.jsp").forward(request, response);
       }
       if(levelSubmit!=null){
           ArrayList<testName> search_list=testNameDAO.getTestBylevel(test_name, offset, numberOftestPerpage, level);
           amount=testNameDAO.getTestAmountWithlevel(test_name, level);
               int pageAmount = 0;
            if (amount % numberOftestPerpage == 0) {
                pageAmount = amount / numberOftestPerpage;
            } else {
                pageAmount = amount / numberOftestPerpage + 1;
            }
              request.setAttribute("test", search_list);
            request.setAttribute("pageAmount", pageAmount);
            request.setAttribute("subject", raw_subject);
            request.setAttribute("level", level);
                request.getRequestDispatcher("searchlist_forlevel.jsp").forward(request, response);
       }
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
