package controller.servlets.general;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.dao.config.DataSource;
import controller.userController;
import controller.utilities.Utils;
import model.Company;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class registerServlet extends HttpServlet {

    /** Registration of a student**/
    protected boolean action_register_student(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException, ParseException {

        response.setContentType("text/html;charset=UTF-8");

        // Get the parameter values
        String cap_string      = request.getParameter("CAP");
        String nome            = request.getParameter("nome");
        String pass            = request.getParameter("password");
        String ripeti_pass     = request.getParameter("ripeti_password");
        String dateString      = request.getParameter("date");
        String provincia       = request.getParameter("provincia");
        String provincia_n     = request.getParameter("provincia_nascita");
        String residenza       = request.getParameter("residenza");
        String citta           = request.getParameter("citta");
        String telefono        = request.getParameter("telefono");
        String corso           = request.getParameter("corso_laurea");
        String email           = request.getParameter("email");
        String cognome         = request.getParameter("cognome");
        String cod_fiscale     = request.getParameter("cod_fiscale");
        String handicapString  = request.getParameter("handicap");
        String luogo_nascita   = request.getParameter("luogo_nascita");

        List<String> errorsList = userController.checkErrorListStudent(nome, cognome, pass, ripeti_pass, dateString, provincia, provincia_n,
                    residenza, citta, cap_string, telefono, corso, email, cod_fiscale, luogo_nascita);

        // If errorsList is > 1 it means we had some errors, so
        // in this case, we can register our user correctly
        // instead of passing an empty list, we just add 1 element to it and return the results
        if (errorsList.size() == 1) {

            // See if the handicap checkbox has been set and assign a value to a boolean variable
            boolean handicapBool = false;
            if (handicapString != null && !handicapString.isEmpty()) {
                handicapBool = true;
            }

            // If the registration check has been completed without errors
            // We parse the necessary String variables to int and Boolean
            // And insert them in the DB
            int capInt = Integer.parseInt(request.getParameter("CAP"));

            // Add the user to DB
            UserDao userDAO = new UserDaoImpl();
            boolean regOK = userDAO.addUser(nome, pass,dateString, provincia, provincia_n, residenza, citta, capInt,
                    telefono, corso, email, handicapBool, cognome, cod_fiscale, luogo_nascita);

            if (regOK) {
                request.getSession().setAttribute("registeredMessage", "Successfully registered");
                response.sendRedirect("/login");
            } else {
                action_default_student(request, response);
            }
        } else {

            // If we have errors, add every field to a list so it will be saved the next time we reload the page
            String[] strs = {nome, cognome, pass, ripeti_pass, dateString, provincia, provincia_n,
                    residenza, citta, cap_string, telefono, corso, email, cod_fiscale, luogo_nascita};

            List<String> tempList = new ArrayList<>();
            tempList.addAll(Arrays.asList(strs));

            request.getSession().setAttribute("fieldsList", tempList);
            request.getSession().setAttribute("errorsList", errorsList);
            response.sendRedirect("/register?user=student");
        }

        return false;
    }

    /** Registration of a company**/
    protected boolean action_register_company(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");

        String ragione_sociale = request.getParameter("ragione_sociale");
        String indirizzo_sede_leg = request.getParameter("ind_legale");
        String cf_iva = request.getParameter("cf_iva");
        String nome_cognome_rap = request.getParameter("nome_rappr_legale");
        String nome_cognome_tir = request.getParameter("nome_resp_tirocini");
        String telefono_tirocini = request.getParameter("telefono_resp");
        String email_tirocini = request.getParameter("email_resp");
        String foro_competente = request.getParameter("foro_comp");
        String provincia = request.getParameter("provincia");
        String email_login = request.getParameter("email_login");
        String password = request.getParameter("password");
        String ripeti_pass = request.getParameter("ripeti_pass");

        List<String> errorsList = userController.checkErrorListCompany(ragione_sociale, indirizzo_sede_leg, cf_iva,
                nome_cognome_rap, nome_cognome_tir, telefono_tirocini, email_tirocini, foro_competente, provincia, email_login, password, ripeti_pass);

        if (errorsList.size() == 1){

            companyDao cDao = new companyDaoImpl();
            boolean regOK = cDao.addUser(email_login, password, ragione_sociale, indirizzo_sede_leg, cf_iva,
                    nome_cognome_rap, nome_cognome_tir, telefono_tirocini, email_tirocini, foro_competente,
                    provincia);

            if (regOK){
                notifyAdmins(email_login);

                request.getSession().setAttribute("registeredMessage", "Request waiting to be approved by the administrator");
                response.sendRedirect("/login");

            } else {
                action_default_company(request, response);
            }

        } else {

            // If we have errors, add every field to a list so it will be saved the next time we reload the page
            String[] strs = {ragione_sociale, indirizzo_sede_leg, cf_iva,
                    nome_cognome_rap, nome_cognome_tir, telefono_tirocini, email_tirocini, foro_competente, provincia, email_login, password, ripeti_pass};

            List<String> tempList = new ArrayList<>();
            tempList.addAll(Arrays.asList(strs));

            request.getSession().setAttribute("fieldsList", tempList);
            request.getSession().setAttribute("errorsList", errorsList);
            response.sendRedirect("/register?user=company");
        }

        return false;
    }

    // send notifications to all the admins
    private boolean notifyAdmins(String email) throws PropertyVetoException, SQLException, IOException {

        boolean notified = false;
        // Get the admins list and add an entry for arch user
        UserDao uDao = new UserDaoImpl();
        ArrayList<User> adminList = uDao.getAdminList();

        // Get to company id to associate with the user id
        // This is done to make the deletion process easier
        // when we have to clear multiple entries

        companyDao cDao = new companyDaoImpl();
        Company comp = cDao.getCompanyDataByEmail(email);

        // send a notification for every administrator in the system
        for (int i = 0; i < adminList.size(); i++) {
            notified = uDao.addNotification(adminList.get(i).getId(), comp.getCompany_id(),
                            ""+comp.getRagione_sociale()+ " wants to join");
        }
        return notified;
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

        // Chrome browser fix
        if (request.getSession().getAttribute("errorsList") != null) {
            request.getSession().removeAttribute("errorsList");
        }

        // Chrome browser fix
        if (request.getSession().getAttribute("fieldsList") != null) {
            request.getSession().removeAttribute("fieldsList");
        }
    }

    // Loads the default company page
    private void action_default_company(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/registration_company.ftl");

        dispatcher.forward(request, response);

        // Chrome browser fix
        if (request.getSession().getAttribute("errorsList") != null) {
            request.getSession().removeAttribute("errorsList");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, ParseException {

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
        if (userController.checkSession(request, "studente") ||
                userController.checkSession(request, "azienda")) {
            response.sendRedirect("/home");
        } else
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
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
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}