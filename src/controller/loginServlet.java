package controller;

import controller.core.userController;
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
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        boolean remember_me_is_checked = request.getParameter( "checkbox5") != null;

        // Check if the fields are empty
        if (email.isEmpty() && pass.isEmpty()) {
            out.println("You must enter some data lo login");
        }

        try {
            // Check if our login belongs to a company or a user
            boolean userLogged    = userController.userAuth(email, pass, "studente");
            boolean companyLogged = userController.userAuth(email, pass, "azienda" );
            HttpSession session   = null;

            // TODO: Utente e Azienda possono avere le stesse mail, dato che appartenono a tabelle separate
            // TODO: aggiungere un radiobutton che permette di scegliere tra azienda e utente quando si logga

            if (userLogged) {

                // Create a new user session
                session = request.getSession();
                User user = new User();

                // Set the user object parameters
                user.setEmail(email);

                // Set the session attribute to check if the user is logged in
                session.setAttribute("loggedInUser", user);

            } else if (companyLogged) {

                // Create a new company session
                session = request.getSession();
                Company comp = new Company();

                // Set the company parameters

                // Set the session attribute to check if a company is logged in
                session.setAttribute("loggedInCompany", comp);
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

                response.sendRedirect("/home");

            } else {
                out.println("Sorry, username or Password incorrect");
                action_default(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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

            // Set the necessary attributes
            request.setAttribute("email", staticEmail);
            request.setAttribute("registered", false);
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
        if (controller.core.userController.checkSession(request, "studente") ||
                controller.core.userController.checkSession(request, "azienda")) {
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