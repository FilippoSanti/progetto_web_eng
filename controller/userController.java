package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userController extends HttpServlet {

    // Login process
    protected void action_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {

            if (Utils.userAuth(email, pass)) {

                // Creating a session
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                response.sendRedirect("Welcome");

            } else {
                out.println("Sorry, username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.html");
                rs.include(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Registration process
    protected void action_register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String cap_string      = request.getParameter("CAP");
        String handicap_string = request.getParameter("handicap");
        String nome            = request.getParameter("nome");
        String pass            = request.getParameter("password");
        String dateString      = request.getParameter("date");
        String provincia       = request.getParameter("provincia");
        String provincia_n     = request.getParameter("provincia_nascita");
        String residenza       = request.getParameter("residenza");
        String citta           = request.getParameter("citta");
        String telefono        = request.getParameter("telefono");
        String corso           = request.getParameter("corso_laurea");
        String email           = request.getParameter("email");
        String cognome         = request.getParameter("cognome");

        boolean regPassed = Utils.checkRegistration(out, nome, cognome, pass, dateString, provincia, provincia_n,
                residenza, citta, cap_string, telefono, corso, email, handicap_string);

        if (regPassed) {

            // If the registration check has been completed without errors
            // We parse the necessary String variables to int and Boolean
            // And insert them in the DB
            int capInt = Integer.parseInt(request.getParameter("CAP"));

            try {

                Connection conn = Utils.dbConnect();
                PreparedStatement ps = conn.prepareStatement
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
            throws ServletException {
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }

}