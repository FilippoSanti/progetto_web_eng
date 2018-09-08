package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import model.Internship;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class internshipsCompanyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("internships_list_company", null);

        // URL Parameters
        String paramName    = "view";
        String paramId = "id";

        String paramValue = request.getParameter(paramName);
        String idValue = request.getParameter(paramId);

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
                action_view_internship_company(request, response);
                return;
            }

            // Delete an intership
            if (paramValue.equals("delete") && idValue.matches("[0-9]+")) {
                action_delete_internship(request, response, idValue);
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

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        companyDao compDao = new companyDaoImpl();

        String email_azie = homeServlet.loggedUserEmail;
         int az_id = compDao.getCompanyIdbyEmail(email_azie);

        internshipDao intDao = new internshipDaoImpl();
        ArrayList<Internship>internshipsArray = intDao.getInternshipListbyId(az_id);
        request.setAttribute("internships_list_company", internshipsArray);
        request.getRequestDispatcher("/WEB-INF/views/internships_list_company.ftl").forward(request, response);

    }

    protected void action_delete_internship(HttpServletRequest request, HttpServletResponse response, String internship_id) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        int int_id = Integer.parseInt(internship_id);
        internshipDao intDao = new internshipDaoImpl();

        intDao.deleteInternship(int_id);


        request.setAttribute("username", tempName);
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }


        protected void action_view_internship_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        request.setAttribute("username", tempName);
        request.getRequestDispatcher("/WEB-INF/views/internships_list_company.ftl").forward(request, response);

    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        request.setAttribute("username", tempName);
        request.getRequestDispatcher("/WEB-INF/views/internships_list_company.ftl").forward(request, response);
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