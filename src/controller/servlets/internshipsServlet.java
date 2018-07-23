package controller.servlets;

import controller.dao.*;
import controller.userController;
import model.Internship;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class internshipsServlet extends HttpServlet {

    public static String addedMessage = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("internships", null);
        request.setAttribute("errors", false);
        // URL Parameters


        String paramName    = "view";
        String submit   = "submit";


        String paramValue = request.getParameter(paramName);
        String submit_string = request.getParameter(submit);


        try {
            // Check if the user has given the right parameters
            if (paramValue == null) {
                action_default(request, response);
                return;
            }

            // View the internships list
            if (paramValue.equals("all")) {
                action_view_all(request, response);
                return;
            }

            // View a specific internship
            if (paramValue.matches("[0-9]+")) {
                action_view_internship(request, response);
                return;
            }

            // View add internships

            if (paramValue.equals("add") && submit_string == null) {
                action_default_add_internships(request, response);
                return;
            }


            // add internships

            if (paramValue.equals("add") && submit_string.equals("true")) {
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

    protected void action_view_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        internshipDao intDao = new internshipDaoImpl();

        // Get the internships list

        ArrayList<Internship>internshipsArray = intDao.getInternshipList();
        request.setAttribute("internships", internshipsArray);
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);

    }

    protected void action_view_internship(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);

    }

    protected void action_default_add_internships(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/add_internship.ftl");

        dispatcher.forward(request, response);
    }

    protected boolean action_add_internships(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {


        response.setContentType("text/html;charset=UTF-8");

        // Initialize every variable to null to avoid problems with empty 'sumbit=true' requets
        String nome, descrizione, luogo, orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste;
        String companyMail = null; int companyId = 0;
        descrizione = nome = luogo = orari = ore = obiettivi = modalita = rimborsi_spese_facilitazioni_previste = null;

        // Get the parameter values
        companyDao cDao = new companyDaoImpl();
        companyMail =   homeServlet.loggedUserEmail;
        companyId =     cDao.getCompanyIdbyEmail(companyMail);
        nome            = request.getParameter("nome");
        descrizione     = request.getParameter("descrizione");
        luogo           = request.getParameter("luogo");
        orari           = request.getParameter("orari");
        ore             = request.getParameter("ore");
        obiettivi       = request.getParameter("obiettivi");
        modalita        = request.getParameter("modalita");
        rimborsi_spese_facilitazioni_previste       = request.getParameter("rimborsi_spese_facilitazioni_previste");

        System.out.println(companyId);

        // If strings are not initalized, it means there was an empty request by the user
        // So we return false
        if (nome == null && luogo == null && orari == null && ore == null && obiettivi == null && modalita == null &&
                rimborsi_spese_facilitazioni_previste == null) {

            return false;
        }

        boolean checkOk = userController.checkAddInternships(request, nome, descrizione, luogo,
                orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste);

        if (checkOk) {

            internshipDao internshipDao = new internshipDaoImpl();
            boolean addOK = internshipDao.addInternship(companyId, nome, descrizione, luogo, orari, ore, obiettivi,
                    modalita, rimborsi_spese_facilitazioni_previste);

            if (addOK) {
                addedMessage = "Registered successfully";
                boolean added = true;
                request.setAttribute("added", added);
                request.setAttribute("addedString", "Tirocinio aggiunto correttamente");

                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home");


                dispatcher.forward(request, response);
            } else {

                action_default(request, response);

                //Clear the errors list
                userController.errorsList.clear();
            }

        }


        return false;
    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);
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