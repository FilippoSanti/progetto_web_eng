package controller;

import controller.core.userController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class profileServlet extends HttpServlet {


    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile.ftl");

        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // URL Parameters
        String paramName  = "userid";
        String paramValue = request.getParameter(paramName);

        // If the userid is set
        if (paramValue != null) {
            action_view_userid(request, response, paramValue);
            return;
        }

        // Default action if no parameter is set properly
        action_default(request, response);

    }

    // View the profile of a user
    private void action_view_userid(HttpServletRequest request, HttpServletResponse response, String id) throws IOException, ServletException {

        // Check if the string contains only numbers
        if (!id.matches("[0-9]+")) {
            action_default(request, response);
            return;
        }

        // If the parameter is empty, we return and
        // execute the default action
        if (id.isEmpty()) {
            action_default(request, response);
            return;
        }

        // Get the user
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!userController.checkSession(request, "studente") &&
                !userController.checkSession(request, "azienda")) {
            response.sendRedirect("/login");
        } else {
            processRequest(request, response);
        }


    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!userController.checkSession(request,"studente") &&
                !userController.checkSession(request,"azienda")) {
            response.sendRedirect("/login");
        } else {
            processRequest(request, response);
        }
    }

}
