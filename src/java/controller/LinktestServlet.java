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
@WebServlet(name = "LinktestServlet", urlPatterns = {"/Linktest"})
public class LinktestServlet extends HttpServlet {

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
            out.println("<title>Servlet LinktestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LinktestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    int numberOftestPerpage = 4;

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
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //xacc dinh xem nguoi dung se vaof trang so may trong danh sach cac bai test(do co phan trang)
            String raw_page = request.getParameter("page");
            int page = 0;
            try {
                page = Integer.parseInt(raw_page);
            } catch (NumberFormatException e) {
            }
            //xac dinh mon hoc
            String raw_subject = request.getParameter("subject");
            testNameDAO testDAO = new testNameDAO();
            //so bai test cua mon hoc
            int amount = testDAO.getTestAmount(raw_subject);
            int pageAmount = 0;
            if (amount % numberOftestPerpage == 0) {
                pageAmount = amount / numberOftestPerpage;
            } else {
                pageAmount = amount / numberOftestPerpage + 1;
            }
            int offset = (page - 1) * numberOftestPerpage;
            account account = (account) session.getAttribute("user");
            //lay danh sach test theo mon hoc cho 1 page
            ArrayList<testName> testlist = testDAO.getTest(raw_subject, offset, numberOftestPerpage);
            switch (account.getRole()) {
                //expert
                case 1:
                    request.setAttribute("test", testlist);
                    request.setAttribute("pageAmount", pageAmount);
                    request.setAttribute("subject", raw_subject);
                    request.getRequestDispatcher("expert/testlist.jsp").forward(request, response);
                    break;
                //customer
                case 0:
                    request.setAttribute("test", testlist);
                    request.setAttribute("pageAmount", pageAmount);
                    request.setAttribute("subject", raw_subject);
                    request.getRequestDispatcher("customer/testlist.jsp").forward(request, response);
                    break;
                    //admin
                case 2:
                    //so bai test cho duoc phe duyet
                    int waitting_amount = testDAO.getWaittingTestAmount(raw_subject);
                    int waitting_page_amount = 0;
                    if (waitting_amount % numberOftestPerpage == 0) {
                        waitting_page_amount = waitting_amount / numberOftestPerpage;
                    } else {
                        waitting_page_amount = waitting_amount / numberOftestPerpage + 1;
                    }
                    int waitting_offset = (page - 1) * numberOftestPerpage;
                    //lay danh sach test dang cho admin phe duyet
                    ArrayList<testName> waitting_testlist = testDAO.getWaittingTest(raw_subject, waitting_offset, numberOftestPerpage);
                    request.setAttribute("waitting_test", waitting_testlist);
                    request.setAttribute("test", testlist);
                    request.setAttribute("pageAmount", waitting_page_amount);
                    request.setAttribute("subject", raw_subject);
                    request.getRequestDispatcher("admin/testlist.jsp").forward(request, response);
                    break;
                    //sale
                case 3:
                    request.getRequestDispatcher("customer/testlist.jsp").forward(request, response);
                    break;
                default:
                    break;
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
        HttpSession session = request.getSession(false);
        if (session == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //xacc dinh xem nguoi dung se vaof trang so may trong danh sach cac bai test(do co phan trang)
            String raw_page = request.getParameter("page");
            int page = 0;
            try {
                page = Integer.parseInt(raw_page);
            } catch (NumberFormatException e) {
            }
            //xac dinh mon hoc
            String raw_subject = request.getParameter("subject");
            testNameDAO testDAO = new testNameDAO();
            //so bai test cua mon hoc
            int amount = testDAO.getTestAmount(raw_subject);
            int pageAmount = 0;
            if (amount % numberOftestPerpage == 0) {
                pageAmount = amount / numberOftestPerpage;
            } else {
                pageAmount = amount / numberOftestPerpage + 1;
            }
            int offset = (page - 1) * numberOftestPerpage;
            //lay danh sach test theo mon hoc cho 1 page
            ArrayList<testName> list = testDAO.getTest(raw_subject, offset, numberOftestPerpage);
            account account = (account) session.getAttribute("user");
            request.setAttribute("test", list);
            request.setAttribute("pageAmount", pageAmount);
            request.setAttribute("subject", raw_subject);
            if (account.getRole() == 1) {
                request.getRequestDispatcher("expert/testlist.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("customer/testlist.jsp").forward(request, response);
            }
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
