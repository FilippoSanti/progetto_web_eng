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
import model.Company;
import model.User;

public class profileServlet extends HttpServlet {


    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, PropertyVetoException, SQLException {

        display_user_image(request);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/profile.ftl");

        dispatcher.forward(request, response);
    }

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

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
    private void action_view_userid(HttpServletRequest request, HttpServletResponse response, String id) throws IOException, ServletException, PropertyVetoException, SQLException {

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
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
