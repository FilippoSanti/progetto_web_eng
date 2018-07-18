package controller.servlets;

import controller.core.userController;
import controller.utilities.DataSource;
import controller.utilities.SecurityFilter;
import model.Security;

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

public class addInternshipsServlet extends HttpServlet {

    public static String addedMessage = "";

    /** Registration of a student**/
    protected boolean action_add_internships(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");

        // Initialize every variable to null to avoid problems with empty 'sumbit=true' requets
        String nome, descrizione, luogo, orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste;
        String companyMail = null; int companyId = 0;
        descrizione = nome = luogo = orari = ore = obiettivi = modalita = rimborsi_spese_facilitazioni_previste = null;

        // Get the parameter values
        companyMail =   homeServlet.loggedUserEmail;
        companyId =     controller.core.companyDAO.getCompanyIDbyEmail(companyMail);
        nome            = request.getParameter("nome");
        descrizione     = request.getParameter("descrizione");
        luogo           = request.getParameter("luogo");
        orari           = request.getParameter("orari");
        ore             = request.getParameter("ore");
        obiettivi       = request.getParameter("obiettivi");
        modalita        = request.getParameter("modalita");
        rimborsi_spese_facilitazioni_previste       = request.getParameter("rimborsi_spese_facilitazioni_previste");




        // If strings are not initalized, it means there was an empty request by the user
        // So we return false
        if (nome == null && luogo == null && orari == null && ore == null && obiettivi == null && modalita == null &&
               rimborsi_spese_facilitazioni_previste == null) {

            return false;
        }

        boolean regOk = userController.checkAddInternships(request, nome, descrizione, luogo,
                orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste);

        if (regOk) {


            try {

                // Connect to DB
                Connection dbConnection = DataSource.getInstance().getConnection();

                PreparedStatement ps = dbConnection.prepareStatement
                        ("insert into offerta_tirocinio values(?,?,?,?,?,?,?,?,?,?)");

                ps.setNull(1, Types.INTEGER);
                ps.setInt(2, companyId);
                ps.setString(3, nome);
                ps.setString(4, descrizione);
                ps.setString(5, luogo);
                ps.setString(6, orari);
                ps.setString(7, ore);
                ps.setString(8, obiettivi);
                ps.setString(9, modalita);
                ps.setString(10, rimborsi_spese_facilitazioni_previste);

                int i = ps.executeUpdate();

                // Registration ok
                if (i > 0) {
                    // Set two attributes to show in the login page
                    boolean added = true;
                    request.setAttribute("added", added);
                    request.setAttribute("addedString", "Tirocinio aggiunto correttamente");

                    RequestDispatcher dispatcher
                            = request.getServletContext().getRequestDispatcher("/home_company");

                    dispatcher.forward(request, response);
                }

            } catch (Exception se) {
                se.printStackTrace();
            }
        } else {
            action_default_company(request, response);

             //Clear the errors list
            userController.errorsList.clear();
        }
        return false;
    }

    // Loads the default page
    private void action_default(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/views/add_internship.ftl").forward(request, response);
    }

    // Loads the default student page
    private void action_default_student(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/home.ftl");

        dispatcher.forward(request, response);
    }

    // Loads the default company page
    private void action_default_company(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/add_internship.ftl");

        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {


        request.setAttribute("companiesList", null);

        request.setAttribute("header", "");
        request.setAttribute("sidemenu", "");
        response.setContentType("text/html;charset=UTF-8");

        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("student")) {
            response.sendRedirect("/home");;
            return;
        }

        if (securityModel.getUser().equals("azienda")) {
            request.setAttribute("header", "company");
            request.setAttribute("sidemenu", "company");

            RequestDispatcher dispatcher= this.getServletContext().getRequestDispatcher("/WEB-INF/views/add_internship.ftl");
            dispatcher.forward(request, response);
            return;
        }

        if (securityModel.getUser().equals("anonymous")) {
            response.sendRedirect("/home_visitor.ftl");
            return;
        }

        if (securityModel.getUser().equals("admin")) {
            response.sendRedirect("/home_admin.ftl");;
            return;
        }



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

            // Go to home
            if (paramValue.equals("student") && submit_string == null) {
                action_default_student(request, response);
                return;
            }

            // Open add Tirocinio
            if (paramValue.equals("company") && submit_string == null) {
                action_default_company(request, response);
                return;
            }



            // Add tirocinio
            if (paramValue.equals("company") && submit_string.equals("true")) {
                action_add_internships(request, response);
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
        if (userController.checkSession(request, "studente")) {
            response.sendRedirect("/home");
        } else
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}