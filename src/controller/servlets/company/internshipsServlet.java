package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
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
import java.text.ParseException;
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
                action_view_internship(request, response, paramValue);
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

            //candidate

            if (paramValue.equals("candidate") && submit_string == null) {
                action_default(request, response);
                return;
            }

            if (paramValue.equals("candidate") && submit_string.matches("[0-9]+")) {

                action_candidate(request, response, submit_string);
                return;
            }



            // Default action if no parameter is set properly
            action_default(request, response);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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

    protected void action_view_internship(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException, PropertyVetoException, SQLException {

          internshipDao iDao = new internshipDaoImpl();

           int newID = Integer.parseInt(id);




            Internship i = iDao.getInternshipDataById(newID);

            // Load the default user page with the right info
            request.setAttribute("internshipData", i);

            request.getRequestDispatcher("/WEB-INF/views/internship_details_student.ftl").forward(request, response);

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
        String nome, mesi, dettagli, luogo, orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste, meseIniziale, meseFinale;
        String companyMail = null; int companyId = 0;
        boolean company_headquarters,remote_connection,refound_of_expenses,  company_refactory, training_aid,  nothing;
        company_headquarters = remote_connection = refound_of_expenses = company_refactory = training_aid=  nothing = false;
        dettagli = nome = mesi = luogo = orari = ore = meseIniziale = meseFinale = obiettivi = modalita = rimborsi_spese_facilitazioni_previste = null;

        // Get the parameter values
        companyDao cDao = new companyDaoImpl();
        companyMail =   homeServlet.loggedUserEmail;
        companyId =     cDao.getCompanyIdbyEmail(companyMail);
        nome            = request.getParameter("nome");
        dettagli        = request.getParameter("dettagli");
        luogo           = request.getParameter("luogo");
        mesi            = request.getParameter("mesi");
        orari           = request.getParameter("orari");
        ore             = request.getParameter("ore");
        meseIniziale    = request.getParameter("mese_iniziale");
        meseFinale      = request.getParameter("mese_finale");
        obiettivi       = request.getParameter("obiettivi");
        modalita        = request.getParameter("modalita");
        rimborsi_spese_facilitazioni_previste       = request.getParameter("rimborsi_spese_facilitazioni_previste");
        company_headquarters = Boolean.parseBoolean(request.getParameter("company_headquarters"));
        remote_connection = Boolean.parseBoolean(request.getParameter("remote_connection"));
        refound_of_expenses = Boolean.parseBoolean(request.getParameter("refound_of_expenses"));
        company_refactory = Boolean.parseBoolean(request.getParameter("company_refactory"));
        training_aid = Boolean.parseBoolean(request.getParameter("training_aid"));
        nothing = Boolean.parseBoolean(request.getParameter("nothing"));
        System.out.println(request.getParameter("company_headquarters"));
        System.out.println(request.getParameter("remote_connection"));
        System.out.println(request.getParameter("refound_of_expenses"));
        System.out.println(request.getParameter("company_refactory"));
        System.out.println(request.getParameter("training_aid"));
        System.out.println(request.getParameter("nothing"));



        System.out.println(companyId);

        // If strings are not initalized, it means there was an empty request by the user
        //So we return false
        if (nome == null && luogo == null && orari == null && ore == null && obiettivi == null && modalita == null &&
               rimborsi_spese_facilitazioni_previste == null && meseIniziale == null && meseFinale == null) {

            return false;
        }

     // boolean checkOk = userController.checkAddInternships(request, nome, dettagli, luogo,
          //     orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste);
      //  System.out.println(checkOk);

     //  if (checkOk) {

            internshipDao internshipDao = new internshipDaoImpl();

            boolean addOK = internshipDao.addInternship(companyId, nome, dettagli, luogo, mesi, orari, ore, meseIniziale, meseFinale, obiettivi,
                    modalita, rimborsi_spese_facilitazioni_previste, company_headquarters, remote_connection, refound_of_expenses, company_refactory, training_aid, nothing);

            if (addOK) {
                addedMessage = "Registered successfully";
                boolean added = true;
                request.setAttribute("added", added);
                request.setAttribute("addedString", "Tirocinio aggiunto correttamente");

                System.out.println(addOK);
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home");

                dispatcher.forward(request, response);
            } else {

                action_default(request, response);

                //Clear the errors list
                userController.errorsList.clear();
            }

     //   }


        return false;
    }


    protected boolean action_candidate(HttpServletRequest request, HttpServletResponse response, String int_id)
            throws ServletException, IOException, SQLException, PropertyVetoException, ParseException {


        String userMail =   homeServlet.loggedUserEmail;


        UserDao UserDao = new UserDaoImpl();
        int userId = UserDao.getIDbyEmail(userMail);
        int int_id1 = Integer.parseInt(int_id);
        boolean candidateOK = UserDao.candidate(2, int_id1, userId);

        if (candidateOK) {

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home");

        dispatcher.forward(request, response);

        return true;}

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