package ajax_notifications_test;

import com.google.gson.Gson;
import controller.utilities.SecurityFilter;
import model.Notification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import controller.dao.*;
import controller.servlets.homeServlet;
import model.Security;

public class notifyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        // URL Parameters
        String action = "action";
        String id = "id";
        String action_value = request.getParameter(action);
        String id_value = request.getParameter(id);

        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("anonymous")) {
            response.sendRedirect("/home");
            return;
        }

        // Notification delete
        if (action_value != null && id_value != null
                && action_value.equals("delete") && id_value.matches("[0-9]+")) {
            int real_value = Integer.parseInt(id_value);
            action_delete_notification(real_value);
        }

        // Notifications update
        if (action_value != null && id_value == null
                && action_value.equals("update")) {
            action_update_notifications(request, response);
        }

        // Notification count
        if (action_value != null && id_value == null
                && action_value.equals("getCount")) {
            action_get_notifications_count(request, response);
        }

    }

    /* Update notifications list */
    private void action_update_notifications (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserDao uDao = new UserDaoImpl();

        // Get the logged user ID and his notifications
        int userID = uDao.getIDbyEmail(homeServlet.loggedUserEmail);
        List<Notification> notifList = uDao.getNotificationList(userID);

        // Every time we update the notifications,
        // we also update the notification count


        String json = new Gson().toJson(notifList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /* Delete a notification */
    private void action_delete_notification (int notifID) throws PropertyVetoException, SQLException, IOException {
        UserDao uDao = new UserDaoImpl();
        uDao.deleteNotification(notifID);
    }

    /* Notification count */
    private void action_get_notifications_count (HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException {

        UserDao uDao = new UserDaoImpl();
        int userID = uDao.getIDbyEmail(homeServlet.loggedUserEmail);

        // Get the count
        int count = uDao.getNotificationsCount(userID);

        // Cast the int to a string and write the response to ajax
        String countStr = String.valueOf(count);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(countStr);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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