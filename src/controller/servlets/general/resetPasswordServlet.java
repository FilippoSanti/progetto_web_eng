package controller.servlets.general;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.Utils;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class resetPasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        boolean isPost = "POST".equals(request.getMethod());

        request.setAttribute("errorMessage", "");
        request.setAttribute("Message", "");

        // URL Parameters
        String submit = "submit";
        String token = "token";
        String changepassword = "changePassword";

        String submit_value = "";
        String chng_value = "";

        submit_value = request.getParameter(submit);
        chng_value = request.getParameter(changepassword);
        String token_value = request.getParameter(token);

        if (token_value != null) {
            System.out.println("enters");
            action_validate_token(request, response, token_value);
            return;
        }

        // Check if the user has given the right parameters
        if (submit_value == null && chng_value == null) {
            System.out.println("enters_2");
            action_default(request, response);
            return;
        }
        // Reset password action
        if (submit_value != null && submit_value.equals("true")) {
            System.out.println("enters_3");
            action_reset(request, response);
            return;
        }

        // Reset password action
        if (chng_value.equals("true")) {
            System.out.println("lol");
            action_update_values(request, response);
        }

        action_default(request, response);
    }

    private void action_update_values(HttpServletRequest request, HttpServletResponse response) throws SQLException, PropertyVetoException, ServletException, IOException {

        // We get the token from the page and check it (again)
        String token = request.getParameter("token_2");
        UserDao usrDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        if (usrDao.checkForToken(token)) {

            // now we get the expiration date
            // and check if it is still valid (5 minutes)
            java.util.Date uDate = usrDao.getExpirationDate(token);
            DateTime dt_2 = new DateTime(uDate);

            if (!token_has_expired(dt_2)) {

                String password = request.getParameter("password");
                String repeat_password = request.getParameter("repeat_password");

                if (password.equals(repeat_password)) {

                    String email = usrDao.getEmailbyToken(token);
                    boolean isUser = usrDao.checkUser(email);
                    boolean isCompany = compDao.checkCompany(email);

                    if (isUser) {
                        usrDao.updateUserData(password, email, email);
                        request.setAttribute("Message", "Password Updated");
                    } else if (isCompany) {
                        compDao.updateEmailAndPassword(email, password, email);
                        request.setAttribute("Message", "Password Updated");
                    }

                } else {
                    request.setAttribute("errorMessage", "Passwords are not equal");
                    action_show_reset_form(request, response);
                }

            } else {
                // Since the token is expired, we can delete it from the database
                usrDao.deleteResetRequest(token);
                request.setAttribute("errorMessage", "Token has expired, please request a new one");
                action_default(request, response);
            }

        } else {
            // Signal that an error has occurred
            request.setAttribute("errorMessage", "A request with the same email address already exists, check your email");
            action_default(request, response);
        }
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/forget_password.ftl").forward(request, response);
    }

    /**
     * Insert the reset request in the DB
     */
    private void action_reset(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        // Get the user email parameter
        String email = request.getParameter("email");
        UserDao usrDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        // Check if the email is registered
        if (!usrDao.checkUser(email) && !compDao.checkCompany(email)) {
            request.setAttribute("errorMessage", "The email does not exist");
            action_default(request, response);
            return;
        }

        // Check if there is another request in the DB with the same email
        if (!usrDao.checkEmailReset(email)) {

            // Generate the UUID corresponding to the user
            String UUID = Utils.generateUUID();

            // Get the current date
            java.util.Date juDate = new Date();

            // Convert it to DateTime and add 5 minutes to it
            DateTime dateTime = new DateTime(juDate);

            // Insert the request into the DB
            if (usrDao.insertPasswordResetRequest(email, UUID, juDate)) {
                Utils.sendMail(email, "You can reset your password by clicking on this link: " + "http://localhost:8080/resetPassword?token=" + UUID);
                request.setAttribute("Message", "An email has been sent to your address with the instructions to reset your password");
                action_default(request, response);
            }
        } else {
            // Signal that an error has occurred
            request.setAttribute("errorMessage", "A request with the same email address already exists, check your email");
            action_default(request, response);
        }
    }

    /**
     * Check if a token provided by the user is valid
     */
    protected void action_validate_token(HttpServletRequest request, HttpServletResponse response, String token) throws PropertyVetoException, IOException, SQLException, ServletException {

        // Check if the token is a valid
        UserDao usrDao = new UserDaoImpl();
        if (usrDao.checkForToken(token)) {
            // now we get the expiration date
            // and check if it is still valid (5 minutes)
            java.util.Date uDate = usrDao.getExpirationDate(token);
            DateTime dt_2 = new DateTime(uDate);

            if (!token_has_expired(dt_2)) {

                request.setAttribute("token", token);
                action_show_reset_form(request, response);

            } else {
                // Since the token is expired, we can delete it from the database
                usrDao.deleteResetRequest(token);
                request.setAttribute("errorMessage", "Token has expired, please request a new one");
                action_default(request, response);
            }

        } else {
            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Invalid token");
            action_default(request, response);
        }
    }

    protected void action_show_reset_form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/update_password.ftl").forward(request, response);
    }

    /**
     * Check if a token is expired by its date
     */
    protected boolean token_has_expired(DateTime sqlDate) {
        DateTime now = new DateTime();

        Interval interval = new Interval(sqlDate, now);
        if (interval.toDuration().getStandardMinutes() > 4) {
            return true;
        }
        return false;
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