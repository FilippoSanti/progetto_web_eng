package controller.servlets;

import model.InternshipRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class listaCandidatiServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("listaCandidati", null);

        // URL Parameters
        String paramName    = "view";
        String paramValue = request.getParameter(paramName);

        try {
            // Check if the user has given the right parameters
            if (paramValue == null) {
                action_default(request, response);
                return;
            }

            // View the internships list
            if (paramValue.equals("all")) {
                action_view_all(request, response);
                return;
            }

            // View a specific internship
            if (paramValue.matches("[0-9]+")) {
                action_view_listaCandidati(request, response);
                return;
            }

            // Default action if no parameter is set properly
            action_default(request, response);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void action_view_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

      //  String email_azie = homeServlet.loggedUserEmail;
        //int az_id = controller.core.companyDAO.getCompanyIDbyEmail(email_azie);

       //int tir_id = 13;
       // ArrayList<InternshipRequest> internshipsArray = internship_requestDAO.getListaCandidatibyTirocinioId(tir_id, az_id);
       // request.setAttribute("listaCandidati", internshipsArray);
       // request.getRequestDispatcher("/WEB-INF/views/listaCandidati.ftl").forward(request, response);

    }

    protected void action_view_listaCandidati(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        request.getRequestDispatcher("/WEB-INF/views/listaCandidati.ftl").forward(request, response);

    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/listaCandidati.ftl").forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}