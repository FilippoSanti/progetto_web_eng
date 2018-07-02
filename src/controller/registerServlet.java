package controller;

import controller.core.userController;
import controller.utilities.DataSource;
import controller.utilities.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class registerServlet extends HttpServlet {

    /** Registration of a student**/
    protected boolean action_register_student(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Initialize every variable to null to avoid problems with empty 'sumbit=true' requets
        String cap_string, nome, pass, ripeti_pass, dateString, provincia, provincia_n, residenza, citta, telefono,
                corso, email, cognome, cod_fiscale, handicapString;

        cap_string = nome = ripeti_pass = dateString = provincia = provincia_n = residenza = citta =
                telefono = corso = email = cognome = cod_fiscale = handicapString = null;

        // Get the parameter values
        cap_string      = request.getParameter("CAP");
        nome            = request.getParameter("nome");
        pass            = request.getParameter("password");
        ripeti_pass     = request.getParameter("ripeti_password");
        dateString      = request.getParameter("date");
        provincia       = request.getParameter("provincia");
        provincia_n     = request.getParameter("provincia_nascita");
        residenza       = request.getParameter("residenza");
        citta           = request.getParameter("citta");
        telefono        = request.getParameter("telefono");
        corso           = request.getParameter("corso_laurea");
        email           = request.getParameter("email");
        cognome         = request.getParameter("cognome");
        cod_fiscale     = request.getParameter("cod_fiscale");
        handicapString  = request.getParameter("handicap");

        System.out.println(cap_string);

        // If strings are not initalized, it means there was an empty request by the user
        // So we return false
        if (cap_string == null && nome == null && pass == null && ripeti_pass == null && dateString == null &&
                provincia == null && provincia_n == null && residenza == null && citta == null && telefono == null
                && corso == null && email == null && cognome == null && cod_fiscale == null && handicapString == null) {

            return false;
        }

        boolean regOk = userController.checkRegistration(request, response, out, nome, cognome, pass, ripeti_pass, dateString, provincia, provincia_n,
                    residenza, citta, cap_string, telefono, corso, email, cod_fiscale);

        if (regOk) {

            // See if the handicap checkbox has been set and assign a value to a boolean variable
            boolean handicapBool = false;
            if (handicapString != null && !handicapString.isEmpty()) {
                handicapBool = true;
            }

            // If the registration check has been completed without errors
            // We parse the necessary String variables to int and Boolean
            // And insert them in the DB
            int capInt = Integer.parseInt(request.getParameter("CAP"));

            try {

                // Connect to DB
                Connection dbConnection = DataSource.getInstance().getConnection();

                PreparedStatement ps = dbConnection.prepareStatement
                        ("insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setNull(1, Types.INTEGER);
                ps.setString(2, nome);

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
                ps.setBoolean(13, handicapBool);
                ps.setString(14, cognome);
                ps.setString(15, cod_fiscale);

                int i = ps.executeUpdate();

                if (i > 0) {
                    out.println("You are sucessfully registered");
                }

            } catch (Exception se) {
                se.printStackTrace();
            }
        } else {
            action_default_student(request, response);

            // Clear the errors list
            userController.errorsList.clear();
        }
        return false;
    }

    /** Registration of a company **/
    protected void action_register_company(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username           = request.getParameter("username");
        String nome               = request.getParameter("nome");
        String ragione_sociale    = request.getParameter("ragione_sociale");
        String indirizzo_sede_leg = request.getParameter("indirizzo_sede_legale");
        String cf_rappresentante  = request.getParameter("cf_rappresentante");
        String partita_iva_rap    = request.getParameter("partita_iva_rappresentante");
        String nome_cognome_rap   = request.getParameter("nome_cognome_rappresentante");
        String nome_cognome_tir   = request.getParameter("nome_cognome_Rtirocini");
        String telefono_tirocini  = request.getParameter("telefono_RTirocini");
        String email_tirocini     = request.getParameter("email_RTirocini");
        String foro_competente    = request.getParameter("foro_competente");

        try {

            // Connect to the db pool
            Connection dbConnection = DataSource.getInstance().getConnection();

            PreparedStatement ps = dbConnection.prepareStatement
                    ("insert into azienda values(?,?,?,?,?,?,?,?,?,?,?,?)");

            // Prepare the query and execute it
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, username);
            ps.setString(3, nome);
            ps.setString(4, ragione_sociale);
            ps.setString(5, indirizzo_sede_leg);
            ps.setString(6, cf_rappresentante);
            ps.setString(7, partita_iva_rap);
            ps.setString(8, nome_cognome_rap);
            ps.setString(9, nome_cognome_tir);
            ps.setString(10, telefono_tirocini);
            ps.setString(11, email_tirocini);
            ps.setString(12, foro_competente);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("You are sucessfully registered");
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/scelta_registrazione.ftl");

        dispatcher.forward(request, response);
    }

    // Loads the default student page
    private void action_default_student(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/registration_student.ftl");

        dispatcher.forward(request, response);
    }

    // Loads the default company page
    private void action_default_company(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/registration_company.ftl");

        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        // We need to initialize the boolean variable 'errors' to false
        // This is used to signal that an error has occurred during the registration
        boolean errors = false;
        request.setAttribute("errors", errors);

        // URL Parameters
        String paramName    = "user";
        String submit       = "submit";

        String paramValue = request.getParameter(paramName);
        String submit_string = request.getParameter(submit);

        try {

            // Check if the user has given the right parameters
            if (paramValue == null && submit_string == null) {
                action_default(request, response);
            }

            // View the user registration page
            if (paramValue.equals("student") && submit_string == null) {
                action_default_student(request, response);
            }

            // View the company registration page
            if (paramValue.equals("company") && submit_string == null) {
                action_default_company(request, response);
            }

            // User registration request
            if (paramValue.equals("student") && submit_string.equals("true")) {
                action_register_student(request, response);
            }

            // Company registration request
            if (paramValue.equals("company") && submit_string.equals("true")) {
                action_register_company(request, response);
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
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
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
            processRequest(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}