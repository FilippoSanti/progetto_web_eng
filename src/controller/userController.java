package controller;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.dao.config.DataSource;
import controller.utilities.Utils;
import model.Company;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class userController {

    // Declare a list of strings to save the errors
    public static List<String> errorsList = new ArrayList<String>();
    public static String newLine = System.getProperty("line.separator");

    /**
     * Various checks for the registration process
     */
    // TODO: make the code more readable
    public static boolean checkStudentRegistration(HttpServletRequest request, HttpServletResponse response, String n, String c, String p, String rp, String d, String pr, String pn, String r,
                                                   String ci, String cap, String t, String co, String em, String cod_fiscale, String luogo_n) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException, ServletException {
        UserDao userDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        boolean result = true;

        // We check if the user already exists in the db
        if (userDao.checkUser(em)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The user already exists");
        }

        // Check name
        if (Utils.checkEmpty(n)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Please insert a name");
        }
        if (n.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The name is too long (15 characters max.)");
        }

        // Check surname
        if (Utils.checkEmpty(c)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Please enter a surname");
        }
        if (c.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The surname is too long");
        }

        // Check password
        if (Utils.checkEmpty(p)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Please enter a password");
        }
        if (!p.equals(rp)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The passwords you entered are not equal");
        }
        if (p.length() < 8) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The password must be at lest 8 characters long ");
        }
        if (p.length() > 45) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The password is too long");
        }

        //Check date
        if (!Utils.isDateValid(d)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Invalid date");
        }
        if (d.length() != 10) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Enter a valid number of characters for the date");
        }

        // Check email
        if (!Utils.isValidEmailAddress(em)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The email address is not valid");
            //Utils.showMessage(request, response, "The email address is not valid");
        }

        // Check residenza
        if (Utils.checkEmpty(r)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Inserisci la residenza");
        }
        if (pr.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("La provincia è troppo lunga");
        }

        // Check citta
        if (Utils.checkEmpty(ci)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Inserisci la citta");
        }
        if (ci.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Citta' too long");
        }

        // Check telefono
        if (Utils.checkEmpty(t)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Inserisci il telefono");
        }
        if (t.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Telefono too long");
        }
        if (!t.matches("[0-9]+")) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The telephone must contain only numbers");
        }

        // Check corso
        if (Utils.checkEmpty(co)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Inserisci il corso");
        }
        if (co.length() > 20) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Corso too long");
        }

        // Check email
        if (Utils.checkEmpty(em)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Inserisci la mail");
        }
        if (em.length() > 60) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Email too long");
        }

        // Check the cap string
        if (Utils.checkEmpty(cap)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Invalid CAP");
        }
        if (!cap.matches("[0-9]+")) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The CAP must contains only numbers");
        }
        if (cap.length() > 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The cap can't be more then 5 numbers");
        }

        if (Utils.checkEmpty(cod_fiscale)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The codice fiscale(non so come cazzo si dice) cannot be empty");
        }
        if (cod_fiscale.length() < 3) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The cod fiscale must be at least x characters");
        }

        if (luogo_n.length() < 3) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The luogo_nascita must be at least 3 characters");
        }

        // If we have found at least an error, we send the list to the HTML page
        if (errorsList.size() > 0) {
            request.setAttribute("errorsList", errorsList);
        }

        return result;

    }

    public static boolean checkCompanyRegistration(HttpServletRequest request, String r, String ind, String cf, String part, String nc_rap,
                                                   String nc_tir, String tel_tir, String em_tir, String foro, String prov, String em_log, String pass, String ripeti) throws ClassNotFoundException, SQLException, PropertyVetoException, IOException {
        boolean result = true;
        UserDao userDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        if (compDao.checkCompanyEmailExists(em_log)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("The login email already exists");
        }

        // Name check
        if (r.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Ragione sociale too short");
        }

        //Part
        if (part.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("part too short");
        }

        // Indirizzo
        if (ind.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Indirizzo too short");
        }

        // CF
        if (cf.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Codice fiscale too short");
        }

        // NC_rap
        if (nc_rap.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Nome Rappresentante too short");
        }

        // NC_tir
        if (nc_tir.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Nome Tirocinio too short");
        }

        // tel_tir
        if (tel_tir.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Tel tirocinio too short");
        }

        // Email_tir
        if (em_tir.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Email tirocinio too short");
        }

        // foro_comp
        if (foro.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Foro too short");
        }

        // prov
        if (prov.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Provincia too short");
        }

        // NC_rap
        if (em_tir.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Nome Rappresentante too short");
        }

        // Password
        if (pass.length() < 8) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Password too short");
        }
        if (!pass.equals(ripeti)) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Passwords are not the same");
        }

        // If we have found at least an error, we send the list to the HTML page
        if (errorsList.size() > 0) {
            request.setAttribute("errorsList", errorsList);
        }

        return result;

    }

    // Check if the user is logged
    public static boolean checkSession(HttpServletRequest request, String target) {

        String sessionAttribute = null;
        if (target.equals("studente")) {
            sessionAttribute = "loggedInUser";
        } else if (target.equals("azienda")) {
            sessionAttribute = "loggedInCompany";
        } else return false;

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(sessionAttribute) == null) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkAddInternships(HttpServletRequest request, String nome, String descrizione, String luogo,
                                              String orari, String ore, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste)
            throws ClassNotFoundException, SQLException, PropertyVetoException, IOException {
        boolean result = true;


        if (nome.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("nome too short");
        }


        if (descrizione.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("descrizione too short");
        }


        if (luogo.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Indirizzo too short");
        }


        if (orari.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Orari too short");
        }


        if (ore.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Ore too short");
        }


        if (obiettivi.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Nome Tirocinio too short");
        }


        if (modalita.length() < 5) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("Tel tirocinio too short");
        }


        if (rimborsi_spese_facilitazioni_previste.length() < 2) {
            result = false;
            Utils.signalErrors(request);
            errorsList.add("compilare il campo");
        }



        // If we have found at least an error, we send the list to the HTML page
        if (errorsList.size() > 0) {
            request.setAttribute("errorsList", errorsList);
        }

        return result;
    }

         /** Get the username of a logges user,
         * this is done to display the name of the user in a sidebar **/

        public static String getUsername(String userEmail) throws IOException, PropertyVetoException, SQLException {

            // Test if the logged user is a company or a student
            companyDao cDao   = new companyDaoImpl();
            UserDao    uDao   = new UserDaoImpl();
            String     result = null;

            boolean isStudent = uDao.checkUser(userEmail);
            boolean isAdmin   = uDao.checkAdmin(userEmail);
            boolean isCompany = cDao.checkCompany(userEmail);

            if (isStudent || isAdmin) {
                User usr = uDao.getUser(userEmail);
                result = usr.getNome();

            } else if (isCompany){
                Company comp = cDao.getCompanyDataByEmail(userEmail);
                result = comp.getRagione_sociale();
            }
        return result;
    }
}