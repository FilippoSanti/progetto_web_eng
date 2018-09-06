package controller;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.Utils;
import model.Company;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class userController {

    // Retrurns a list of size 1 if everything is ok
    public static List<String> checkErrorListStudent(String n, String c, String p, String rp, String d, String pr, String pn, String r,
                                                     String ci, String cap, String t, String co, String em, String cod_fiscale, String luogo_n) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException, ServletException {
        List<String> errorsList = new ArrayList<>();
        UserDao userDao = new UserDaoImpl();

        // We add an element to the list to check it
        // If the size is > 1, then something happened
        errorsList.add("Errors found:");

        if (n == null || c == null || p == null || rp == null || d == null || pr == null ||
                pn == null || r == null || ci == null || cap == null || t == null || co == null ||
                em == null || cod_fiscale == null || luogo_n == null) {
            errorsList.add("Missing fields");
            return errorsList;
        }

        // We check if the user already exists in the db
        if (userDao.checkUser(em)) {
            errorsList.add("The user already exists");
        }

        // Check name
        if (Utils.checkEmpty(n)) {
            errorsList.add("Please insert a name");
        }
        if (n.length() > 20) {
            errorsList.add("The name is too long (15 characters max.)");
        }

        // Check surname
        if (Utils.checkEmpty(c)) {
            errorsList.add("Please enter a surname");
        }
        if (c.length() > 20) {
            errorsList.add("The surname is too long");
        }

        // Check password
        if (Utils.checkEmpty(p)) {
            errorsList.add("Please enter a password");
        }
        if (!p.equals(rp)) {
            errorsList.add("The passwords you entered are not equal");
        }

        if (p.length() < 8) {
            errorsList.add("The password must be at lest 8 characters long ");
        }
        if (p.length() > 45) {
            errorsList.add("The password is too long");
        }

        //Check date
        if (!Utils.isDateValid(d)) {
            errorsList.add("Invalid date");
        }
        if (d.length() != 10) {
            errorsList.add("Enter a valid number of characters for the date");
        }

        // Check email
        if (!Utils.isValidEmailAddress(em)) {
            errorsList.add("The email address is not valid");
        }

        // Check residenza
        if (Utils.checkEmpty(r)) {
            errorsList.add("Inserisci la residenza");
        }

        // provincia
        if(!Pattern.matches("[a-zA-Z]+", pr)) {
            errorsList.add("Provincia invalid characters");
        }

        if(pr.isEmpty()) {
            errorsList.add("Add a provincia");
        }

        if (pr.length() > 20) {
            errorsList.add("La provincia è troppo lunga");
        }

        // provincia nascita
        if(!Pattern.matches("[a-zA-Z]+", pn)) {
            errorsList.add("Provincia_n invalid characters");
        }

        if(pn.isEmpty()) {
            errorsList.add("Add a provincia");
        }

        // Check citta
        if (Utils.checkEmpty(ci)) {
            errorsList.add("Inserisci la citta");
        }
        if (ci.length() > 20) {
            errorsList.add("Citta' too long");
        }

        // Check telefono
        if (Utils.checkEmpty(t)) {
            errorsList.add("Inserisci il telefono");
        }
        if (t.length() > 20) {
            errorsList.add("Telefono too long");
        }
        if (!t.matches("[0-9]+")) {
            errorsList.add("The telephone must contain only numbers");
        }

        // Check corso
        if (Utils.checkEmpty(co)) {
            errorsList.add("Inserisci il corso");
        }
        if (co.length() > 20) {
            errorsList.add("Corso too long");
        }

        // Check email
        if (Utils.checkEmpty(em)) {
            errorsList.add("Inserisci la mail");
        }
        if (em.length() > 60) {
            errorsList.add("Email too long");
        }

        // Check the cap string
        if (Utils.checkEmpty(cap)) {
            errorsList.add("Invalid CAP");
        }
        if (!cap.matches("[0-9]+")) {
            errorsList.add("The CAP must contains only numbers");
        }
        if (cap.length() > 5) {
            errorsList.add("The cap can't be more then 5 numbers");
        }

        if (Utils.checkEmpty(cod_fiscale)) {
            errorsList.add("The codice fiscale(non so come cazzo si dice) cannot be empty");
        }
        if (cod_fiscale.length() < 3) {
            errorsList.add("The cod fiscale must be at least x characters");
        }

        if (luogo_n.length() < 3) {
            errorsList.add("The luogo_nascita must be at least 3 characters");
        }
        return errorsList;
    }

    public static List<String> checkErrorListCompany(String r, String ind, String cf_iva, String nc_rap,
                                                     String nc_tir, String tel_tir, String em_tir, String foro, String prov, String em_log, String pass, String ripeti) throws ClassNotFoundException, SQLException, PropertyVetoException, IOException {
        List<String> errorsList = new ArrayList<>();
        companyDao compDao = new companyDaoImpl();
        errorsList.add("Errors found:");

        if (r == null || ind == null || cf_iva == null || nc_rap == null || nc_tir == null || tel_tir == null ||
                em_tir == null || foro == null || prov == null || em_log == null || pass == null ||
                ripeti == null) {
            errorsList.add("Missing fields");
            return errorsList;
        }

        if (compDao.checkCompanyEmailExists(em_log)) {
            errorsList.add("The login email already exists");
        }

        // Name check
        if (r.length() < 2) {
            errorsList.add("Ragione sociale too short");
        }

        //cf_iva
        if (cf_iva.length() < 5) {

            errorsList.add("part too short");
        }

        // Indirizzo
        if (ind.length() < 5) {
            errorsList.add("Indirizzo too short");
        }

        // NC_rap
        if (nc_rap.length() < 5) {
            errorsList.add("Nome Rappresentante too short");
        }

        // NC_tir
        if (nc_tir.length() < 5) {
            errorsList.add("Nome Tirocinio too short");
        }

        // tel_tir
        if (tel_tir.length() < 5) {
            errorsList.add("Tel tirocinio too short");
        }

        // Email_tir
        if (em_tir.length() < 5) {
            errorsList.add("Email tirocinio too short");
        }

        // foro_comp
        if (foro.length() < 5) {
            errorsList.add("Foro too short");
        }

        // prov
        if (prov.length() < 2) {
            errorsList.add("Provincia too short");
        }

        // NC_rap
        if (em_tir.length() < 5) {
            errorsList.add("Nome Rappresentante too short");
        }

        // Password
        if (pass.length() < 8) {
            errorsList.add("Password too short");
        }
        if (!pass.equals(ripeti)) {
            errorsList.add("Passwords are not the same");
        }

        return errorsList;
    }

    public static List<String> checkErrorListInternship(HttpServletRequest request, String nome, String descrizione, String luogo,
                                                        String orari, String ore, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste) throws ClassNotFoundException, SQLException, PropertyVetoException, IOException {
        List<String> errorsList = null;

        if (nome.length() < 2) {
            errorsList.add("nome too short");
        }

        if (descrizione.length() < 5) {
            errorsList.add("descrizione too short");
        }

        if (luogo.length() < 5) {
            errorsList.add("Indirizzo too short");
        }

        if (orari.length() < 2) {
            errorsList.add("Orari too short");
        }

        if (ore.length() < 2) {
            errorsList.add("Ore too short");
        }

        if (obiettivi.length() < 5) {
            errorsList.add("Nome Tirocinio too short");
        }

        if (modalita.length() < 5) {
            errorsList.add("Tel tirocinio too short");
        }

        if (rimborsi_spese_facilitazioni_previste.length() < 2) {
            errorsList.add("compilare il campo");
        }

        return errorsList;
    }

    // Gets the username of a logged user
    public static String getUsername(String userEmail) throws IOException, PropertyVetoException, SQLException {

        // Test if the logged user is a company or a student
        companyDao cDao = new companyDaoImpl();
        UserDao uDao = new UserDaoImpl();
        String result = null;

        boolean isStudent = uDao.checkUser(userEmail);
        boolean isAdmin = uDao.checkAdmin(userEmail);
        boolean isCompany = cDao.checkCompany(userEmail);

        if (isStudent || isAdmin) {
            User usr = uDao.getUser(userEmail);
            result = usr.getNome();

        } else if (isCompany) {
            Company comp = cDao.getCompanyDataByEmail(userEmail);
            result = comp.getRagione_sociale();
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
}