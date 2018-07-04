package controller;

import controller.core.userController;
import model.Company;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class homeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Check if the user is logged
        if (userController.checkSession(request, "studente")) {

            // Get the user object
            User userModel = (User) session.getAttribute("loggedInUser");

            loadHomepage(request, response);
            // Load user functions

        } else if (userController.checkSession(request, "azienda")) {
            Company companyModel = (Company) session.getAttribute("loggedInAZienda");

            loadHomepage(request, response);
            // Load company functions

        } else {
            response.sendRedirect("/login");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void loadHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.ftl");

        dispatcher.forward(request, response);
    }


}