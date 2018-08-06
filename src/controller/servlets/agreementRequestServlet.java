package controller.servlets;

import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class agreementRequestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException, ClassNotFoundException {

        response.setContentType("text/html;charset=UTF-8");

        // URL Parameters
        String action = "action";
        String id = "id";

        String action_value = request.getParameter(action);
        String id_value = request.getParameter(id);


        Security securityModel = SecurityFilter.checkUsers(request);

        // Check that the user has the right permissions
        if (securityModel.getUser().equals("student") && securityModel.getRole().equals("admin")) {

            if (action_value != null && id_value != null
                    && action_value.equals("approve") && id_value.matches("[0-9]+")) {

                int id_real = Integer.parseInt(id_value);
                action_approve_company(request, response, id_real);

            }

            if (action_value != null && id_value != null &&
                    action_value.equals("delete") && id_value.matches("[0-9]+")) {

                int id_real = Integer.parseInt(id_value);
                action_refuse_company(request, response, id_real);
            }

            else action_default(request, response);

        } else {
            // Redirect to the home page
            response.sendRedirect("/home");
        }
    }

    protected void action_approve_company(HttpServletRequest request, HttpServletResponse response, int id) throws PropertyVetoException, SQLException, IOException, ClassNotFoundException {

        // Check that the userID exists
        companyDao cDao = new companyDaoImpl();

        String email = cDao.getEmailByID(id);

        if (cDao.checkCompanyEmailExists(email)) {

            // Enable the company
            if (cDao.enableCompany(email)) {
                request.getSession().setAttribute("Message", "The company has been approved");
                response.sendRedirect("/agreementRequests");
            }

        } else {
            request.getSession().setAttribute("errorMessage", "The userID doesn't exist");
            response.sendRedirect("/agreementRequests");
        }

    }

    protected void action_refuse_company(HttpServletRequest request, HttpServletResponse response, int id) throws ClassNotFoundException, SQLException, PropertyVetoException, IOException {

        // Check that the userID exists
        companyDao cDao = new companyDaoImpl();

        String email = cDao.getEmailByID(id);

        if (cDao.checkCompanyEmailExists(email)) {

            // Delete the company
            if (cDao.deleteCompany(id)) {
                request.getSession().setAttribute("Message", "Deleted successfully");
                response.sendRedirect("/agreementRequests");
            }

        } else {
            request.getSession().setAttribute("errorMessage", "The userID doesn't exist");
            response.sendRedirect("/agreementRequests");
        }

    }

    protected void action_default(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao cDao = new companyDaoImpl();

        ArrayList<Company> companyArray = cDao.getCompaniesToBeApproved();
        request.setAttribute("companiesList", companyArray);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/agreements_requests.ftl");
        dispatcher.forward(request, response);

        request.getSession().removeAttribute("Message");
        request.getSession().removeAttribute("errorMessage");
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}