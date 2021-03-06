package controller.servlets.general;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.userController;
import model.Company;
import model.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {

    String staticEmail = "";

    // Login process
    protected void action_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        boolean remember_me_is_checked = request.getParameter( "checkbox5") != null;

        // Check if our login belongs to a company or a user
        UserDao uDao = new UserDaoImpl();

        boolean userLogged    = uDao.userAuth(email, pass, "studente");
        boolean companyLogged = uDao.userAuth(email, pass, "azienda");
        HttpSession session   = null;

        if (userLogged) {

            // Create a new user session
            session = request.getSession();
            User user = new User();

            // Set the user object parameters
            user.setEmail(email);

            // Set the session attribute to check if the user is logged in
            session.setAttribute("loggedInUser", user);

        } else if (companyLogged) {

            // Check if the company is approved
            companyDao cDao = new companyDaoImpl();

            if (!cDao.checkCompanyEnabled(email)) {
                request.getSession().setAttribute("Message", "The administrator is reviewing your account, try again later");
                response.sendRedirect("/login");
                return;
            }

            // Create a new company session
            session = request.getSession();
            Company comp = new Company();

            // Set the company parameters
            comp.setEmail_login(email);

            // Set the session attribute to check if a company is logged in
            session.setAttribute("loggedInCompany", comp);
        } else {
            request.getSession().setAttribute("errorMessage", "Wrong email or password");
            response.sendRedirect("/login");
        }

        if (userLogged || companyLogged) {

            // Check if we have to remember the username
            if(remember_me_is_checked)
            {
                Cookie c = new Cookie("email", email);
                c.setMaxAge(24*60*60);
                response.addCookie(c);  // response is an instance of type HttpServletReponse
            } else {

                // If the remember me button is not checked
                // We delete the user cookie
                Cookie killMyCookie = new Cookie("email", null);
                killMyCookie.setMaxAge(0);
                response.addCookie(killMyCookie);
                staticEmail = "";
            }

            // Redirect to the home page
            response.sendRedirect("/home");

        }
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Chrome hack pt.1 : Get the attributes into a string
        // session attributes will be removed and set again (locally)
        // this is done to avoid problems with chrome, pt. 1

        String reg_mes = (String) request.getSession().getAttribute("registeredMessage");
        String mes = (String) request.getSession().getAttribute("Message");
        String err_mes = (String) request.getSession().getAttribute("errorMessage");

        Cookie[] cookies  = null;
        cookies = request.getCookies();

        /* Cookies are stored on the client side and are sent to the server with each request.
        It is not good practice to add passwords in cookies because they are easily intercepted
        and in many cases stick around in the users browser even after they leave the site. */

        // Check if the user has cookies to display on screen
        if (cookies != null) {
            for(int i = 0; i < cookies.length; i++)
            {
                Cookie c = cookies[i];
                if (c.getName().equals("email"))
                {
                    staticEmail = c.getValue();
                }
            }
        }
        request.setAttribute("email", staticEmail);
        request.getSession().removeAttribute("registeredMessage");
        request.getSession().removeAttribute("Message");
        request.getSession().removeAttribute("errorMessage");

        // Set the string attributes (again)
        // pt. 2 of the chrome hack
        if (reg_mes != null) {
            request.setAttribute("registeredMessage", reg_mes);
        }

        if (mes != null) {
            request.setAttribute("Message", mes);
        }

        if (err_mes != null) {
            request.setAttribute("errorMessage", err_mes);
        }

        request.getRequestDispatcher("/WEB-INF/views/login.ftl").forward(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("login") != null) {
                action_login(request, response);
            } else {
                action_default(request, response);
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // If the student|company is already logged in, we redirect him to the home page
        if (userController.checkSession(request, "studente") ||
                userController.checkSession(request, "azienda")) {
            response.sendRedirect("/home");
        } else { processRequest(request, response); }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}