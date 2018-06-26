package controller;

import controller.core.userController;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {

    // Login process
    protected void action_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        boolean remember_me_is_checked = request.getParameter( "checkbox5" ) != null;

        // Check if the fields are empty
        if (email.isEmpty() && pass.isEmpty()) {
            out.println("You must enter some data lo login");
        }

        try {
            //Check if the login was successful
            if (userController.userAuth(email, pass)) {

                // Creating a session
                HttpSession session = request.getSession();

                User user = new User();

                if(remember_me_is_checked)
                {
                    Cookie c = new Cookie("email", email);
                    c.setMaxAge(24*60*60);
                    response.addCookie(c);  // response is an instance of type HttpServletReponse
                }

                // Set the user object parameters
                user.setEmail(email);
                user.setUserType("student");

                // Set the session attribute to check if the user is logged in
                session.setAttribute("loggedInUser", user);
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

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(request, response);

        Cookie[] cookies  = request.getCookies();
        String   email    = null;

        /* Cookies are stored on the client side and are sent to the server with each request.
        It is not good practice to add passwords in cookies because they are easily intercepted
        and in many cases stick around in the users browser even after they leave the site. */

        for(int i = 0; i < cookies.length; i++)
        {
            Cookie c = cookies[i];
            if (c.getName().equals("email"))
            {
                email = c.getValue();
            }
        }
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

        // If the user is already logged in, we redirect him to the home page
        if (controller.core.userController.checkSession(request)) {
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