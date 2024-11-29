/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.subjectDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.account;
import model.subject;

/**
 *
 * @author ADMIN
 */
public class MainServlet extends HttpServlet {

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
            out.println("<title>Servlet MainServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet at " + request.getContextPath() + "</h1>");
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

          HttpSession session=request.getSession(false);
            account user=(account)session.getAttribute("user");
            subjectDAO subjectDAO = new subjectDAO();
            ArrayList<subject> subject_list = subjectDAO.getSubject();
            request.setAttribute("subject_list", subject_list);
            if(user.getRole()==0){
            request.getRequestDispatcher("customer/main.jsp").forward(request, response);}
            if(user.getRole()==1){
            request.getRequestDispatcher("expert/main.jsp").forward(request, response);}
            if(user.getRole()==2){
            request.getRequestDispatcher("admin/main.jsp").forward(request, response);}
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
            HttpSession session=request.getSession(false);
            account user=(account)session.getAttribute("user");
            subjectDAO subjectDAO = new subjectDAO();
            ArrayList<subject> subject_list = subjectDAO.getSubject();
            request.setAttribute("subject_list", subject_list);
            if(user.getRole()==0){
            request.getRequestDispatcher("customer/main.jsp").forward(request, response);}
            if(user.getRole()==1){
            request.getRequestDispatcher("expert/main.jsp").forward(request, response);}
            if(user.getRole()==2){
            request.getRequestDispatcher("admin/main.jsp").forward(request, response);}
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
