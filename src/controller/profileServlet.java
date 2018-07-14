package controller;

import controller.core.companyDAO;
import controller.core.userController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import controller.core.userDAO;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
import model.Company;
import model.Security;
import model.User;

public class profileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        request.setAttribute("errorMessage", "");

        // URL Parameters
        String paramName  = "view";
        String paramValue = request.getParameter(paramName);

        // If the userid is set
        if (paramValue == null) {

            // Start user profile visualization
            Security securityModel = SecurityFilter.checkUsers(request);

            if (securityModel.getUser().equals("student")) {
                action_student(request, response);
            } else if (securityModel.getUser().equals("azienda")) {
                action_company(request, response);
            } else action_load_login(request, response);

        } else {
            action_view_userid(request, response, paramValue);
        }
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
        }
    }

    private void action_default_user(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PropertyVetoException, SQLException {

        display_user_image(request);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile_user.ftl");

        dispatcher.forward(request, response);
    }

    private void action_default_company(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PropertyVetoException, SQLException {

        display_user_image(request);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile_company.ftl");

        dispatcher.forward(request, response);
    }

    /**
     * User specific methods
     **/
    public void display_user_image(HttpServletRequest request) throws PropertyVetoException, SQLException, IOException {

        // Find out if the session belongs to a user or a company
        String userType = null;
        if (userController.checkSession(request,"studente")) {
            userType = "student";
        } else if (userController.checkSession(request, "azienda")) {
            userType = "azienda";
        }

        if (userType.equals("student")) {

            // Check if a user image has been uploaded by the user
            // Other wise we include the default image
            User user = userDAO.getUserDataByEmail(homeServlet.loggedUserEmail);
            String userID = String.valueOf(user.getId());

            ServletContext context = getServletContext();
            String filename = "/assets/images/users/"+ "user_"+userID+".png";
            String pathname = context.getRealPath(filename);

            File f = new File(pathname);
            if(f.exists() && !f.isDirectory()) {
                // Set the page attribute
                request.setAttribute("image_path", "../../assets/images/users/"+ "user_"+userID+".png");
            } else {
                request.setAttribute("image_path", "../../assets/images/users/default_user.png");
            }

        } else {

            // Same thing but for the companies
            Company company = companyDAO.getCompanyDataByEmail(homeServlet.loggedUserEmail);
            String userID = String.valueOf(company.getCompany_id());

            ServletContext context = getServletContext();
            String filename = "/assets/images/users/"+ "company_"+userID+".png";
            String pathname = context.getRealPath(filename);

            File f = new File(pathname);
            if(f.exists() && !f.isDirectory()) {
                // Set the page attribute
                request.setAttribute("image_path", "../../assets/images/users/"+ "company_"+userID+".png");
            } else {
                request.setAttribute("image_path", "../../assets/images/users/default_company.png");
            }
        }
    }

    // View the profile of a user
    private void action_view_userid(HttpServletRequest request, HttpServletResponse response, String id) throws IOException, ServletException, PropertyVetoException, SQLException {

        System.out.println(id);
        Security securityModel = SecurityFilter.checkUsers(request);

        // Check if the string contains only numbers
        if (!Utils.isNumeric(id)) {

            if (securityModel.equals("azienda")) {
                action_default_company(request, response);
            } else if (securityModel.equals("student")) {
                action_default_user(request, response);
            }
            return;
        }

        // If the parameter is empty, we return and
        // execute the default action
        if (id.isEmpty()) {
            if (securityModel.equals("azienda")) {
                action_default_company(request, response);
            } else if (securityModel.equals("student")) {
                action_default_user(request, response);
            }

            return;
        }

        if (securityModel.getUser().equals("student")) {

            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Only companies can access user profiles");
            action_default_user(request, response);

            return;
        } else if (securityModel.getUser().equals("anonymous")) {
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.ftl");

            dispatcher.forward(request, response);
        }

        // Get the user object from the DB


    }

    // I'm a logged student and i want to see my own profile
    protected void action_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        User user = userDAO.getUserDataByEmail(homeServlet.loggedUserEmail);

        // Set the user attributes to display on screen
        request.setAttribute("userData", user);
        action_default_user(request, response);

    }

    // I'm a logged company and i want to see my own profile
    protected void action_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        Company company = companyDAO.getCompanyDataByEmail(homeServlet.loggedUserEmail);
        // Set the user attributes to display on screen
        request.setAttribute("companyData", company);

        action_default_company(request, response);
    }

    protected void action_load_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/login");

        dispatcher.forward(request, response);
    }

}
