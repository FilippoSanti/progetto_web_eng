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
import java.sql.Types;

public class userServlet extends HttpServlet {

    // Login process
    protected void action_login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        // Check if the fields are empty
        if (email.isEmpty() && pass.isEmpty()) {
            out.println("You must enter some data lo login");
        }

        // Create a new user instance
        User user = new User();

        try {

            //Check if the login was successful
            if (userController.userAuth(email, pass)) {

                // Creating a session
                HttpSession session = request.getSession();

                // Set the user object parameters
                user.setEmail(email);

                // Set the session attribute to check if the user is logged in
                session.setAttribute("loggedInUser", user);
                response.sendRedirect("Welcome");

            } else {
                out.println("Sorry, username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Registration process
    protected void action_register_student(HttpServletRequest request, HttpServletResponse response)
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
        String cod_fiscale = request.getParameter("cod_fiscale");

        boolean regOk = userController.checkRegistration(out, nome, cognome, pass, dateString, provincia, provincia_n,
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
                        ("insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setNull(1, Types.INTEGER);
                ps.setString(2, nome);


                System.out.println(nome);

                // Prepare the query and execute it
                ps.setString(3, Utils.hashPassword(pass));
                ps.setDate(4, Utils.convertDate(dateString));
                ps.setString(5, provincia);
                ps.setString(6, provincia_n);
                ps.setString(7, residenza);
                ps.setString(8, citta);
                ps.setInt(9, capInt);
                ps.setString(10, telefono);
                ps.setString(11, corso);
                ps.setString(12, email);
                ps.setString(13, handicap_string);
                ps.setString(14, cognome);
                ps.setString(14, cod_fiscale);

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

    // Registration process of an Azienda
    protected void action_registerAzienda(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String nome = request.getParameter("nome");
        String ragione_sociale = request.getParameter("ragione_sociale");
        String indirizzo_sede_legale = request.getParameter("indirizzo_sede_legale");
        String cf_rappresentante = request.getParameter("cf_rappresentante");
        String partita_iva_rappresentante = request.getParameter("partita_iva_rappresentante");
        String nome_cognome_rappresentante = request.getParameter("nome_cognome_rappresentante");
        String nome_cognome_Rtirocini = request.getParameter("nome_cognome_Rtirocini");
        String telefono_RTirocini = request.getParameter("telefono_RTirocini");
        String email_RTirocini = request.getParameter("email_RTirocini");
        String foro_competente = request.getParameter("foro_competente");

        try {

            // Conenct to the db pool
            Connection dbConnection = DataSource.getInstance().getConnection();

            PreparedStatement ps = dbConnection.prepareStatement
                    ("insert into azienda values(?,?,?,?,?,?,?,?,?,?,?,?)");

            // Prepare the query and execute it
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, username);
            ps.setString(3, nome);
            ps.setString(4, ragione_sociale);
            ps.setString(5, indirizzo_sede_legale);
            ps.setString(6, cf_rappresentante);
            ps.setString(7, partita_iva_rappresentante);
            ps.setString(8, nome_cognome_rappresentante);
            ps.setString(9, nome_cognome_Rtirocini);
            ps.setString(10, telefono_RTirocini);
            ps.setString(11, email_RTirocini);
            ps.setString(12, foro_competente);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("You are sucessfully registered");
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    // Aggiunta di un tirocinio
    protected void action_addTirocinio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String luogo = request.getParameter("luogo");
        String orari = request.getParameter("orari");
        String ore = request.getParameter("ore");
        String obiettivi = request.getParameter("obiettivi");
        String modalita = request.getParameter("modalita");
        String rimborsi_spese_facilitazioni_previste= request.getParameter("rimborsi_spese_facilitazioni_previste");

        try {

            // Conenct to the db pool
            Connection dbConnection = DataSource.getInstance().getConnection();

            PreparedStatement ps = dbConnection.prepareStatement
                    ("insert into offerta_tirocinio values(?,?,?,?,?,?,?)");

            // Prepare the query and execute it
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, luogo);
            ps.setString(3, orari);
            ps.setString(4, ore);
            ps.setString(5, obiettivi);
            ps.setString(6, modalita);
            ps.setString(7, rimborsi_spese_facilitazioni_previste);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Tirocinio aggiunto dio merda finalmente");
            }

        } catch (Exception se) {
            se.printStackTrace();
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

            if (request.getParameter("registration_student") != null) {
                System.out.println("entra");
                action_register_student(request, response);
            }

            if (request.getParameter("add_tirocinio") != null) {
                action_addTirocinio(request, response);
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