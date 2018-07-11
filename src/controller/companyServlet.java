package controller;

import model.Company;
import model.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.core.companyDAO;

public class companyServlet  extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("companiesList", null);

        // URL Parameters
        String paramName    = "view";
        String paramValue = request.getParameter(paramName);

        try {
            // Check if the user has given the right parameters
            if (paramValue == null) {
                action_default(request, response);
                return;
            }

            // View the company list
            if (paramValue.equals("all")) {
                action_view_all(request, response);
                return;
            }

            // View a specific company
            if (paramValue.matches("[0-9]+")) {
                action_view_company(request, response);
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

        // Get the company list
        ArrayList<Company> companiesArray = controller.core.companyDAO.getCompaniesList();
        request.setAttribute("companiesList", companiesArray);
        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);

    }

    protected void action_view_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);

    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);
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