package controller.servlets;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class homeServlet extends HttpServlet {

    public static String loggedUserEmail = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");

        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("student")){
            action_student(request, response);
        }


        if (securityModel.getUser().equals("azienda")) {
            action_company(request, response);
        }

        if (securityModel.getUser().equals("anonymous")) {
            action_default_anonymous(request, response);
        }
    }

    protected void action_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        HttpSession session = request.getSession();
        UserDao userDao = new UserDaoImpl();

        // Get the user object attribute containing the user email
        User userModel = (User) session.getAttribute("loggedInUser");
        loggedUserEmail = userModel.getEmail();

        // The security model uses loggedUserEmail, so we must declare it later
        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getRole().equals("admin")) {
            action_default_admin(request, response);
        } else {
            action_default_student(request, response);
        }
    }

    protected void action_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get the user object attribute containing the user email
        Company companyModel = (Company) session.getAttribute("loggedInCompany");
        loggedUserEmail = companyModel.getEmail_login();
        action_default_company(request, response);
    }

    protected void action_admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        action_default_admin(request, response);

    }

    /** Default actions **/

    public void action_default_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_student.ftl");

        dispatcher.forward(request, response);
    }

    public void action_default_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_company.ftl");

        dispatcher.forward(request, response);
    }

    public void action_default_admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_admin.ftl");

        dispatcher.forward(request, response);
    }

    protected void action_default_anonymous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // home_visitor.ftl
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_visitor.ftl");

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
}