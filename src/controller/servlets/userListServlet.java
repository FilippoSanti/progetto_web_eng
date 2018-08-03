package controller.servlets;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.utilities.SecurityFilter;
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

public class userListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        Security securityModel = SecurityFilter.checkUsers(request);

        String action = "action";
        String delete_id = "id";
        String action_value = request.getParameter(action);
        String delete_id_value = request.getParameter(delete_id);


        // Check if the user is an admin
        if (securityModel.getUser().equals("student") &&
                securityModel.getRole().equals("admin")) {

            if (action_value != null && delete_id_value != null &&
                    action_value.equals("delete") && delete_id_value.matches("[0-9]+")) {
                action_delete_user(request, response, delete_id_value);
            } else action_show_all(request, response);

        } else {
            response.sendRedirect("/home");
        }
    }

    private void action_show_all(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException, ServletException {

        UserDao uDao = new UserDaoImpl();

        // Get the user list
        ArrayList<User> userArray = uDao.getUserList();
        request.setAttribute("userList", userArray);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/students_list_admin.ftl");
        dispatcher.forward(request, response);

        // Remove the session attributes
        request.getSession().removeAttribute("errorMessage");
        request.getSession().removeAttribute("Message");
    }

    private void action_delete_user (HttpServletRequest request, HttpServletResponse response, String strID) throws IOException, PropertyVetoException, SQLException, ServletException {

        // First we check if the userID is valid
        UserDao uDao = new UserDaoImpl();

        int id = Integer.parseInt(strID);
        String email = uDao.getEmailByID(id);

        if (uDao.checkUser(email)) {
            if (uDao.deleteUser(id)) {
                request.getSession().setAttribute("Message", "User deleted correctly");
                response.sendRedirect("/userList");
            } else {

                // Query execution error
                request.getSession().setAttribute("errorMessage", "Error executing query");
                response.sendRedirect("/userList");
            }

        } else {
            // Invalid ID error
            request.getSession().setAttribute("errorMessage", "Invalid user ID");
            response.sendRedirect("/userList");
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
}