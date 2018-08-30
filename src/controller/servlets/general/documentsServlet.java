package controller.servlets.general;

import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.servlets.general.homeServlet;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class documentsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        Security securityModel = SecurityFilter.checkUsers(request);

        // URL Parameters
        String action = "action";
        String id = "id";

        // URL Parameters value
        String action_value = request.getParameter(action);
        String id_value = request.getParameter(id);

        // Check if the user is a logged company
        if (securityModel.getUser().equals("azienda")) {

            // Students list page
            if (action_value != null && action_value.equals("students")) {
                action_students_page(request, response);
                return;
            }

            action_choose_page(response, request);
        }

        // Check if the user is a logged student
        if (securityModel.getUser().equals("student")) {

            // Student internships
            if (action_value != null && action_value.equals("internships")) {
                action_students_internships(request, response);
                return;
            }
        }

        // Check if the user is admin
        if (securityModel.getUser().equals("student") &&
                securityModel.getRole().equals("admin")) {

            if (action_value != null && action_value.equals("companies")) {
                action_view_companies(request, response);
            }

            if (action_value != null && action_value.equals("")) {

            }
        }

    }

    /** Admin **/
    private void action_view_companies(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_admin.ftl");

        dispatcher.forward(request, response);
    }

    // Generate the documentation of a company by its id
    // This belongs to the admin's documents, so it's marked under 'admin'
    private void generateCompanyDocumentation(int company_id) throws PropertyVetoException, SQLException, IOException {

        // Get the company data
        companyDao cDao = new companyDaoImpl();
        String tempEmail = cDao.getEmailByID(company_id);

        Company companyModel = cDao.getCompanyDataByEmail(tempEmail);

        // Compile the corresponding document (document3)



    }

    /** Student **/
    private void action_students_internships(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/my_internship.ftl");

        dispatcher.forward(request, response);

    }

    /** Company **/
    private void action_students_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_company.ftl");

        dispatcher.forward(request, response);

    }

    private void action_choose_page(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/choose_documents_company.ftl");

        dispatcher.forward(request, response);
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}