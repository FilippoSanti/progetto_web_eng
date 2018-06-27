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

    // Registration process
    protected void action_register_student(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Initialize every variable to null to avoid problems with empty 'sumbit=true' requets
        String cap_string, nome, pass, ripeti_pass, dateString, provincia, provincia_n, residenza, citta, telefono,
                corso, email, cognome, cod_fiscale, handicapString;

        cap_string = nome = ripeti_pass = dateString = provincia = provincia_n = residenza = citta =
                telefono = corso = email = cognome = cod_fiscale = handicapString = "";


        // Get the parameter values
        cap_string = request.getParameter("CAP");
        nome = request.getParameter("nome");
        pass = request.getParameter("password");
        ripeti_pass = request.getParameter("ripeti_password");
        dateString = request.getParameter("date");
        provincia = request.getParameter("provincia");
        provincia_n = request.getParameter("provincia_nascita");
        residenza = request.getParameter("residenza");
        citta = request.getParameter("citta");
        telefono = request.getParameter("telefono");
        corso = request.getParameter("corso_laurea");
        email = request.getParameter("email");
        cognome = request.getParameter("cognome");
        cod_fiscale = request.getParameter("cod_fiscale");
        handicapString = request.getParameter("handicap");

        // Variable used to check if the registration is ok
        boolean regOk;

        // If strings are not initalized, it means there was an empty request by the user
        // So we return false
        if (cap_string == null && nome == null && pass == null && ripeti_pass == null && dateString == null &&
                provincia == null && provincia_n == null && residenza == null && citta == null && telefono == null
                && corso == null && email == null && cognome == null && cod_fiscale == null && handicapString == null) {

            System.out.println("empty fields");

            regOk = false;
        }

        regOk = userController.checkRegistration(out, nome, cognome, pass, ripeti_pass, dateString, provincia, provincia_n,
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

        // TODO: Check empty /register requests and redirect them to the first page

        // URL Parameters
        String paramName    = "user";
        String submit       = "submit";

        String paramValue = request.getParameter(paramName);
        String sumbit = request.getParameter(submit);

        // Build the full string to check its validity
        String myURL = "?" + paramName + "=" + paramValue;

        try {

            // Check for invalid requests
            if (!controller.utilities.Utils.checkForValidURL(request, myURL)) {
                System.out.println("Invalid request");
            }

            // View the user registration page
            else if (paramValue.equals("student")) {
                action_default_student(request, response);
            }

            // View the company registration page
            else if (paramValue.equals("company")) {
                action_default_company(request, response);
            }

            // User registration request
            else if (paramValue.equals("student") && sumbit.equals("true")) {
                action_register_student(request, response);
            }

            // Company registration request
            else if (paramValue.equals("company") && sumbit.equals("true")) {
                action_registerAzienda(request, response);
            } else {
                System.out.println("request not valid");
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
