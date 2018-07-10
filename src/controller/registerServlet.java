package controller;

import controller.core.userController;
import controller.utilities.DataSource;
import controller.utilities.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class registerServlet extends HttpServlet {

    public static String registeredMessage = "";

    /** Registration of a student**/
    protected boolean action_register_student(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");

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

        // If strings are not initalized, it means there was an empty request by the user
        // So we return false
        if (cap_string == null && nome == null && pass == null && ripeti_pass == null && dateString == null &&
                provincia == null && provincia_n == null && residenza == null && citta == null && telefono == null
                && corso == null && email == null && cognome == null && cod_fiscale == null && handicapString == null) {

            return false;
        }

        boolean regOk = userController.checkStudentRegistration(request, response, nome, cognome, pass, ripeti_pass, dateString, provincia, provincia_n,
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
                        ("insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setNull(1, Types.INTEGER);
                ps.setString(2, nome);
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
                ps.setString(16, "empty");

                int i = ps.executeUpdate();

                // Registration ok
                if (i > 0) {

                    registeredMessage = "Registered successfully";

                    RequestDispatcher dispatcher
                            = request.getServletContext().getRequestDispatcher("/login");

                    dispatcher.forward(request, response);
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
    protected boolean action_register_company(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");

        String ragione_sociale, indirizzo_sede_leg, cf_rappresentante, partita_iva_rap, nome_cognome_rap,
                nome_cognome_tir, telefono_tirocini, email_tirocini, foro_competente, provincia, email_login, password, ripeti_pass;

        ragione_sociale = indirizzo_sede_leg = cf_rappresentante = partita_iva_rap = nome_cognome_rap = nome_cognome_tir =
                telefono_tirocini = email_tirocini = foro_competente = provincia = email_login = password = ripeti_pass = null;

        ragione_sociale    = request.getParameter("ragione_sociale");
        indirizzo_sede_leg = request.getParameter("ind_legale");
        cf_rappresentante  = request.getParameter("cod_fiscale");
        partita_iva_rap    = request.getParameter("part_iva");
        nome_cognome_rap   = request.getParameter("nome_rappr_legale");
        nome_cognome_tir   = request.getParameter("nome_resp_tirocini");
        telefono_tirocini  = request.getParameter("telefono_resp");
        email_tirocini     = request.getParameter("email_resp");
        foro_competente    = request.getParameter("foro_comp");
        provincia          = request.getParameter("provincia");
        email_login        = request.getParameter("email_login");
        password           = request.getParameter("password");
        ripeti_pass        = request.getParameter("ripeti_pass");

        if (ragione_sociale == null && indirizzo_sede_leg == null && cf_rappresentante == null && partita_iva_rap == null &&
                nome_cognome_rap == null && nome_cognome_tir == null && telefono_tirocini == null && email_tirocini == null && foro_competente ==
                null && provincia == null && email_login == null && password == null && ripeti_pass == null) {
            return false;
        }

        boolean regOK = controller.core.userController.checkCompanyRegistration(request, ragione_sociale, indirizzo_sede_leg, cf_rappresentante, partita_iva_rap,
                nome_cognome_rap, nome_cognome_tir, telefono_tirocini, email_tirocini, foro_competente, provincia, email_login, password, ripeti_pass);

        if (regOK) {

            try {
                // Connect to the db pool
                Connection dbConnection = DataSource.getInstance().getConnection();
                PreparedStatement ps = dbConnection.prepareStatement
                        ("insert into azienda values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

                // Prepare the query and execute it
                ps.setNull(1, Types.INTEGER);
                ps.setString(2, email_login);
                ps.setString(3, Utils.hashPassword(password));
                ps.setString(4, ragione_sociale);
                ps.setString(5, indirizzo_sede_leg);
                ps.setString(6, cf_rappresentante);
                ps.setString(7, partita_iva_rap);
                ps.setString(8, nome_cognome_rap);
                ps.setString(9, nome_cognome_tir);
                ps.setString(10, telefono_tirocini);
                ps.setString(11, email_tirocini);
                ps.setString(12, foro_competente);
                ps.setString(13, provincia);

                int i = ps.executeUpdate();

                if (i > 0) {
                    // Set two attributes to show in the login page
                    boolean registered = true;
                    request.setAttribute("registered", registered);
                    request.setAttribute("registeredString", "Registration has been completed successfully");

                    RequestDispatcher dispatcher
                            = request.getServletContext().getRequestDispatcher("/login");

                    dispatcher.forward(request, response);
                }

            } catch (Exception se) {
                se.printStackTrace();
            }
        } else {
            action_default_company(request, response);

            // Clear the errors list
            userController.errorsList.clear();
        }
        return false;
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/scelta_registrazione.ftl").forward(request, response);
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
                return;
            }

            // View the user registration page
            if (paramValue.equals("student") && submit_string == null) {
                action_default_student(request, response);
                return;
            }

            // View the company registration page
            if (paramValue.equals("company") && submit_string == null) {
                action_default_company(request, response);
                return;
            }

            // User registration request
            if (paramValue.equals("student") && submit_string.equals("true")) {
                action_register_student(request, response);
                return;
            }

            // Company registration request
            if (paramValue.equals("company") && submit_string.equals("true")) {
                action_register_company(request, response);
                return;
            }

            // Default action if no parameter is set properly
            action_default(request, response);

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
        // If the student|company is already logged in, we redirect him to the home page
        if (controller.core.userController.checkSession(request, "studente") ||
                controller.core.userController.checkSession(request, "azienda")) {
            response.sendRedirect("/home");
        } else
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