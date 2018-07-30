package controller.servlets;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.userController;

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
import java.util.ArrayList;

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

        if (paramValue == null) {

            // Start user profile visualization
            Security securityModel = SecurityFilter.checkUsers(request);

            if (securityModel.getUser().equals("student")) {
                action_student(request, response, homeServlet.loggedUserEmail);
            } else if (securityModel.getUser().equals("azienda")) {
                action_company(request, response, homeServlet.loggedUserEmail);
            } else action_load_login(request, response);

        }

        else if (paramValue.equals("all")) {
            // List every user profiles
            // This is only available to the administrator
            action_show_all(request, response);
        } else {

            // It means we are loading a userID
            action_view_userid(request, response, paramValue);
        }
    }

    /** List the user profiles */
    private void action_show_all(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException, ServletException {

        UserDao uDao = new UserDaoImpl();

        // Get the user list
        ArrayList<User> userArray = uDao.getUserList();
        request.setAttribute("userList", userArray);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/students_list_admin.ftl");
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

    private void action_default_user(HttpServletRequest request, HttpServletResponse response, String email) throws IOException, ServletException, PropertyVetoException, SQLException {

        ServletContext context = getServletContext();
        String result = Utils.display_user_image(context, request, email);
        request.setAttribute("image_path", result);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile_user.ftl");

        dispatcher.forward(request, response);
    }

    private void action_default_company(HttpServletRequest request, HttpServletResponse response, String email) throws IOException, ServletException, PropertyVetoException, SQLException {

        ServletContext context = getServletContext();
        String result = Utils.display_user_image(context, request, email);
        request.setAttribute("image_path", result);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile_company.ftl");

        dispatcher.forward(request, response);
    }

    /**
     * User specific methods
     **/


    // View the profile of a user
    private void action_view_userid(HttpServletRequest request, HttpServletResponse response, String id) throws IOException, ServletException, PropertyVetoException, SQLException {
        Security securityModel = SecurityFilter.checkUsers(request);

        // Check if the string contains only numbers
        if (!Utils.isNumeric(id)) {
            if (securityModel.getUser().equals("student")) {
                action_student(request, response, homeServlet.loggedUserEmail);
            } else if (securityModel.getUser().equals("azienda")) {
                action_company(request, response, homeServlet.loggedUserEmail);
            }
            return;
        }

        // If the parameter is empty, we return and
        // execute the default action
        if (id.isEmpty()) {
            if (securityModel.getUser().equals("student")) {
                action_student(request, response, homeServlet.loggedUserEmail);
            } else if (securityModel.getUser().equals("azienda")) {
                action_company(request, response, homeServlet.loggedUserEmail);
            }
            return;
        }

        if (securityModel.getUser().equals("student")) {

            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Only companies can access user profiles");
            action_student(request, response, homeServlet.loggedUserEmail);
            return;

        } else if (securityModel.getUser().equals("anonymous")) {
            RequestDispatcher dispatcher
                    = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.ftl");

            dispatcher.forward(request, response);
        }

        // Get the user object from the DB
        UserDao uDao = new UserDaoImpl();

        int newID = Integer.parseInt(id);
        String email = uDao.getEmailByID(newID);

        // If the email is an empty string, the user id doesn't exist
        if (email != null && !email.isEmpty()) {
            User u = uDao.getUser(email);

            // Load the default user page with the right info
            request.setAttribute("userData", u);
            action_default_user(request, response, email);

        } else {

            if (securityModel.getUser().equals("student")) {
                action_student(request, response, homeServlet.loggedUserEmail);

            } else if (securityModel.getUser().equals("azienda")) {
                action_company(request, response, homeServlet.loggedUserEmail);
            }

        }
    }

    // I'm a logged student and i want to see my own profile
    protected void action_student(HttpServletRequest request, HttpServletResponse response, String email) throws ServletException, IOException, PropertyVetoException, SQLException {

        UserDao userDao = new UserDaoImpl();

        User user = userDao.getUser(homeServlet.loggedUserEmail);

        // Set the user attributes to display on screen
        request.setAttribute("userData", user);
        action_default_user(request, response, email);

    }

    // I'm a logged company and i want to see my own profile
    protected void action_company(HttpServletRequest request, HttpServletResponse response, String email) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao compDao = new companyDaoImpl();

        Company company = compDao.getCompanyDataByEmail(homeServlet.loggedUserEmail);
        // Set the user attributes to display on screen
        request.setAttribute("companyData", company);

        action_default_company(request, response, email);
    }

    protected void action_load_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/login");

        dispatcher.forward(request, response);
    }
}