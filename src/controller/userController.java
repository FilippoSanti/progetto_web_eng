package controller;

import controller.utilities.Utils;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userController extends HttpServlet {

    // Login process
    protected void action_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        // Create a new user instance
        User user = new User();

        try {

            //Check if the login was successful
            if (Utils.userAuth(email, pass)) {

                // Creating a session
                HttpSession session = request.getSession();

                // Set the user object parameters
                user.setEmail(email);

                // Set the session attribute to check if the user is logegd in
                session.setAttribute("loggedInUser", user);
                response.sendRedirect("Welcome");

            } else {
                out.println("Sorry, username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.html");
                rs.include(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Registration process
    protected void action_register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String cap_string = request.getParameter("CAP");
        String handicap_string = request.getParameter("handicap");
        String nome = request.getParameter("nome");
        String pass = request.getParameter("password");
        String dateString = request.getParameter("date");
        String provincia = request.getParameter("provincia");
        String provincia_n = request.getParameter("provincia_nascita");
        String residenza = request.getParameter("residenza");
        String citta = request.getParameter("citta");
        String telefono = request.getParameter("telefono");
        String corso = request.getParameter("corso_laurea");
        String email = request.getParameter("email");
        String cognome = request.getParameter("cognome");

        boolean regOk = Utils.checkRegistration(out, nome, cognome, pass, dateString, provincia, provincia_n,
                residenza, citta, cap_string, telefono, corso, email, handicap_string);

        if (regOk) {

            // If the registration check has been completed without errors
            // We parse the necessary String variables to int and Boolean
            // And insert them in the DB
            int capInt = Integer.parseInt(request.getParameter("CAP"));

            try {

                // Conenct to the db pool
                Connection dbConnection = DataSource.getInstance().getConnection();

                PreparedStatement ps = dbConnection.prepareStatement
                        ("insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setString(1, nome);

                // Prepare the query and execute it
                ps.setString(2, Utils.hashPassword(pass));
                ps.setDate(3, Utils.convertDate(dateString));
                ps.setString(4, provincia);
                ps.setString(5, provincia_n);
                ps.setString(6, residenza);
                ps.setString(7, citta);
                ps.setInt(8, capInt);
                ps.setString(9, telefono);
                ps.setString(10, corso);
                ps.setString(11, email);
                ps.setString(12, handicap_string);
                ps.setString(13, cognome);

                int i = ps.executeUpdate();

                if (i > 0) {
                    out.println("You are sucessfully registered");
                }

            } catch (Exception se) {
                se.printStackTrace();
            }
        } else {
            out.println("Registration failed");
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, ClassNotFoundException, PropertyVetoException {
        try {

            if (request.getParameter("login") != null) {
                action_login(request, response);
            }


            if (request.getParameter("register") != null) {
                action_register(request, response);
            }

        } catch (IOException ex) {
            request.setAttribute("exception", ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }

}