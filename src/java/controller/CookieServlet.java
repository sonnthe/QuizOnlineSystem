/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CookieServlet", urlPatterns = {"/cook"})
public class CookieServlet extends HttpServlet {

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
        Cookie[] a = request.getCookies();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CookieServlet at " + a[0].getAttribute("math") + "</h1>");
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
PrintWriter out=response.getWriter();
        Cookie[] cookies = request.getCookies();

// Tìm cookie có tên "math_accuracy"
Cookie mathAccuracyCookie = null;
for (Cookie cookie : cookies) {
    if (cookie.getName().equals("math_accuracy")) {
        mathAccuracyCookie = cookie;
        break;
    }
}

// Nếu cookie "math_accuracy" tồn tại, lấy giá trị của thuộc tính "math"
if (mathAccuracyCookie != null) {
    String mathAttribute = mathAccuracyCookie.getAttribute("math");
    //if (mathAttribute != null) {
        // Sử dụng giá trị mathAttribute ở đây
        out.println("Math attribute value: " + mathAccuracyCookie.getValue());
   // } else {
     //   out.println("Cookie \"math_accuracy\" does not have a \"math\" attribute.");
   // }
//} else {
    out.println("Cookie \"math_accuracy\" not found in the request.");
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
        PrintWriter out=response.getWriter();
        Cookie[] cookies = request.getCookies();

// Tìm cookie có tên "math_accuracy"
Cookie mathAccuracyCookie = null;
for (Cookie cookie : cookies) {
    if (cookie.getName().equals("math_accuracy")) {
        mathAccuracyCookie = cookie;
        break;
    }
}

// Nếu cookie "math_accuracy" tồn tại, lấy giá trị của thuộc tính "math"
if (mathAccuracyCookie != null) {
    String mathAttribute = mathAccuracyCookie.getAttribute("math");
    //if (mathAttribute != null) {
        // Sử dụng giá trị mathAttribute ở đây
        out.println("Math attribute value: " + mathAccuracyCookie.getValue());
   // } else {
     //   out.println("Cookie \"math_accuracy\" does not have a \"math\" attribute.");
   // }
//} else {
    out.println("Cookie \"math_accuracy\" not found in the request.");
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
