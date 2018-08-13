package ajax_notifications_test;

import com.google.gson.Gson;
import model.Notification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import controller.dao.*;
import controller.servlets.homeServlet;

public class notifyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // URL Parameters
        String action = "action";
        String id = "id";
        String action_value = request.getParameter(action);
        String id_value = request.getParameter(id);

        // Notification delete
        if (action_value != null && id_value != null
                && action_value.equals("delete") && id_value.matches("[0-9]+")) {
            action_delete_notification(request, response);
        }

        // If no parameters are set, we are trying to update our notifications
        action_update_notifications(request, response);

    }

    /* Delete a seen notification */
    private void action_update_notifications (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserDao uDao = new UserDaoImpl();

        // Get the logged user ID and his notifications
        int userID = uDao.getIDbyEmail(homeServlet.loggedUserEmail);
        List<Notification> notifList = uDao.getNotificationList(userID);

        String json = new Gson().toJson(notifList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    /* Delete a seen notification */
    private void action_delete_notification (HttpServletRequest request, HttpServletResponse response) {
        // code
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
        processRequest(request, response);
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
        processRequest(request, response);

    }
}
