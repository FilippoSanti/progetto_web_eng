package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import controller.userController;
import controller.utilities.SecurityFilter;
import model.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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

    protected static void action_default(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        request.setAttribute("internships", null);
        request.setAttribute("errors", false);

        // URL Parameters
        String paramName = "view";
        String submit = "submit";

        String paramValue = request.getParameter(paramName);
        String submit_string = request.getParameter(submit);


        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("student") && securityModel.getRole().equals("user")) {
            request.setAttribute("header", "student");
            request.setAttribute("sidemenu", "student");
        }

        if (securityModel.getUser().equals("azienda")) {
            request.setAttribute("header", "company");
            request.setAttribute("sidemenu", "company");
        }

        if (securityModel.getUser().equals("anonymous")) {
            request.setAttribute("header", "anonymous");
            request.setAttribute("sidemenu", "anonymous");
        }

        if (securityModel.getUser().equals("student") && securityModel.getRole().equals("admin")) {
            request.setAttribute("header", "admin");
            request.setAttribute("sidemenu", "admin");
        }


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

            // candidate
            if (paramValue.equals("candidate") && submit_string == null) {
                action_default(request, response);
                return;
            }

            if (paramValue.equals("candidatePage") && submit_string.matches("[0-9]+")) {
                action_candidatePage(request, response, submit_string);
                return;
            }

            if (paramValue.equals("candidate") && submit_string.matches("[0-9]+")) {
                action_candidate(request, response, submit_string);
                return;
            }

            if (paramValue != null && paramValue.equals("myInternships")) {
                action_show_my_internships(request, response);
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

    private void action_show_my_internships(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        ArrayList<MyInternships> myShip = processInternshipsData();


        request.setAttribute("userList", myShip);

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/my_internship.ftl");

        dispatcher.forward(request, response);

    }



    protected void action_view_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        internshipDao intDao = new internshipDaoImpl();

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        // Get the internships list
        ArrayList<Internship> internshipsArray = intDao.getInternshipList();
        request.setAttribute("internships", internshipsArray);
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);

    }

    protected void action_view_internship(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException, PropertyVetoException, SQLException {

        internshipDao iDao = new internshipDaoImpl();

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        int newID = Integer.parseInt(id);
        Internship i = iDao.getInternshipDataById(newID);

        // Load the default user page with the right info
        request.setAttribute("internshipData", i);
        request.getRequestDispatcher("/WEB-INF/views/internship_details_student.ftl").forward(request, response);

    }

    protected void action_default_add_internships(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/add_internship.ftl");

        dispatcher.forward(request, response);
    }

    protected boolean action_add_internships(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {


        response.setContentType("text/html;charset=UTF-8");

        // Initialize every variable to null to avoid problems with empty 'sumbit=true' requets
        String nome, mesi, dettagli, luogo, orari, ore, obiettivi, modalita, rimborsi_spese_facilitazioni_previste, start_date, end_date;
        String companyMail = null;
        int companyId = 0;
        boolean company_headquarters, remote_connection, refound_of_expenses, company_refactory, training_aid, nothing;
        company_headquarters = remote_connection = refound_of_expenses = company_refactory = training_aid = nothing = false;
        dettagli = nome = mesi = luogo = orari = ore = start_date = end_date = obiettivi = modalita = rimborsi_spese_facilitazioni_previste = null;

        // Get the parameter values
        companyDao cDao = new companyDaoImpl();
        companyMail = homeServlet.loggedUserEmail;
        companyId = cDao.getCompanyIdbyEmail(companyMail);
        nome = request.getParameter("nome");
        dettagli = request.getParameter("dettagli");
        luogo = request.getParameter("luogo");
        mesi = request.getParameter("mesi");
        orari = request.getParameter("orari");
        ore = request.getParameter("ore");
        start_date = request.getParameter("start_date");
        end_date = request.getParameter("end_date");
        obiettivi = request.getParameter("obiettivi");
        modalita = request.getParameter("modalita");
        rimborsi_spese_facilitazioni_previste = request.getParameter("rimborsi_spese_facilitazioni_previste");
        company_headquarters = Boolean.parseBoolean(request.getParameter("company_headquarters"));
        remote_connection = Boolean.parseBoolean(request.getParameter("remote_connection"));
        refound_of_expenses = Boolean.parseBoolean(request.getParameter("refound_of_expenses"));
        company_refactory = Boolean.parseBoolean(request.getParameter("company_refactory"));
        training_aid = Boolean.parseBoolean(request.getParameter("training_aid"));
        nothing = Boolean.parseBoolean(request.getParameter("nothing"));

        // If strings are not initalized, it means there was an empty request by the user
        //So we return false
        if (nome == null && luogo == null && orari == null && ore == null && obiettivi == null && modalita == null &&
                rimborsi_spese_facilitazioni_previste == null && start_date == null && end_date == null) {

            return false;
        }

        internshipDao internshipDao = new internshipDaoImpl();

        boolean addOK = internshipDao.addInternship(companyId, nome, dettagli, luogo, mesi, orari, ore, start_date, end_date, obiettivi,
                modalita, rimborsi_spese_facilitazioni_previste, company_headquarters, remote_connection, refound_of_expenses, company_refactory, training_aid, nothing);

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

        return false;
    }

    protected boolean action_candidatePage(HttpServletRequest request, HttpServletResponse response, String int_id)
            throws ServletException, IOException, SQLException, PropertyVetoException, ParseException {

        String userMail = homeServlet.loggedUserEmail;
        UserDao UserDao = new UserDaoImpl();
        int userId = UserDao.getIDbyEmail(userMail);
        int int_id1 = Integer.parseInt(int_id);

        System.out.println(userId);
        System.out.println(int_id1);
        boolean checkOk = UserDao.checkInternshipUser(userId, int_id1);
        if (!checkOk) {
            request.setAttribute("userId", int_id1);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accept_internship.ftl");
            dispatcher.forward(request, response);

            return true;
        } else {
            request.getSession().setAttribute("registeredMessage", "You are already registered to this Internship");
            response.sendRedirect("/home");
            return false;
        }
    }


    protected boolean action_candidate(HttpServletRequest request, HttpServletResponse response, String int_id)
            throws ServletException, IOException, SQLException, PropertyVetoException, ParseException {

        response.setContentType("text/html;charset=UTF-8");

        String cfu, tutor_name, tutor_surname, tutor_email = "";
        cfu = request.getParameter("cfu");
        tutor_name = request.getParameter("tutor_name");
        tutor_surname = request.getParameter("tutor_surname");
        tutor_email = request.getParameter("tutor_email");

        String userMail = homeServlet.loggedUserEmail;
        UserDao UserDao = new UserDaoImpl();
        int userId = UserDao.getIDbyEmail(userMail);

        int int_id1 = Integer.parseInt(int_id);

        companyDao comDao = new companyDaoImpl();
        int az_id = comDao.getIdCompanyByIdInternship(int_id1);

        boolean candidateOK = UserDao.candidate(az_id, int_id1, userId, cfu, tutor_name, tutor_surname, tutor_email );

        if (candidateOK) {

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home");
            dispatcher.forward(request, response);

            return true;
        }

        return false;
    }

    // Elaborate the internships of a user
    private ArrayList<MyInternships> processInternshipsData() throws PropertyVetoException, SQLException, IOException {

        UserDao uDao = new UserDaoImpl();
        int UID = uDao.getIDbyEmail(homeServlet.loggedUserEmail);

        internshipDao iDao = new internshipDaoImpl();
        ArrayList<InternshipRequest> myInt = iDao.getMyInternships(UID);

        ArrayList<MyInternships> result = new ArrayList<>();

        // Get the company informations to retrieve the name
        companyDao cDao = new companyDaoImpl();

        // Scan the user internships list and create the new data structure
        for (int i = 0; i < myInt.size(); i++) {

            MyInternships myIts = new MyInternships();
            Internship iship = iDao.getInternshipByID(myInt.get(i).getInternship_id());

            String comp_mail = cDao.getEmailByID(myInt.get(i).getAzienda_id());
            Company company_temp = cDao.getCompanyDataByEmail(comp_mail);

            String status = getInternshipStatus(iship.getMeseInziale(), iship.getMeseFinale());

            if (status.equals("Not started")) { myIts.setHtmlcolor("interstatus1"); }
            if (status.equals("In progress")) { myIts.setHtmlcolor("interstatus2"); }
            if (status.equals("Completed"))  { myIts.setHtmlcolor("interstatus3"); }

            myIts.setCompany_name(company_temp.getRagione_sociale());
            myIts.setInternship_id(myInt.get(i).getInternship_request_id());
            myIts.setInternship_status(status);
            myIts.setInternship_name(iship.getNome());

            result.add(myIts);
        }

        return result;
    }

    // Elaborate the status of an internship
    private String getInternshipStatus(String start_date, String end_date) {
        String result = null;

        // Execute the date operations
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

        DateTime date_now = new DateTime();
        DateTime dt_start = formatter.parseDateTime(start_date);
        DateTime dt_end   = formatter.parseDateTime(end_date);

        boolean not_started = date_now.isBefore(dt_start);
        boolean in_progress = date_now.isAfter(dt_start) && date_now.isBefore(dt_end);
        boolean terminated  = date_now.isAfter(dt_end);

        if (not_started) {
            result = "Not started";
        } else if (in_progress) {
            result = "In progress";
        } else if (terminated) {
            result = "Completed";
        }

        return result;
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