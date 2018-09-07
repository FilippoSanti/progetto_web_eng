package controller.servlets.general;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class documentsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        Security securityModel = SecurityFilter.checkUsers(request);

        // URL Parameters

        String action = "action";
        String type   = "type";
        String id     = "id";
        String student_id = "student_id";
        String internship_id = "internship_id";

        String action_value = request.getParameter(action);
        String type_value = request.getParameter(type);
        String id_value = request.getParameter(id);
        String student_id_value = request.getParameter(student_id);
        String internship_id_value = request.getParameter(internship_id);

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

        // Check if the user is a logged company
        if (securityModel.getUser().equals("azienda")) {

            // Students list page
            if (action_value != null && action_value.equals("students")) {
                action_students_page(request, response);
                return;
            }

            // Students list page
            if (action_value != null && action_value.matches("[0-9]+")) {
                try {
                    action_students_manage_int(request, response, action_value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return;
            }

            if (action_value != null && internship_id_value != null && action_value.equals("document1") && student_id_value != null && student_id_value.matches("[0-9]+") && internship_id_value.matches("[0-9]+"))
            {
                generateDocument1(request, response, student_id_value, internship_id_value);
                 return;
            }

            if (action_value != null && id_value != null && type_value != null && type_value.matches("[0-9]+") && action_value.equals("document1_2") && id_value.matches("[0-9]+")){
                action_compile_document1_2(request, response, id_value, type_value);
                return;
            }

                action_choose_page(response, request);
        }

        // check admin boolean
        boolean isAdmin = securityModel.getUser().equals("student") && securityModel.getRole().equals("admin");

        // Check if the user is a logged student
        if (securityModel.getUser().equals("student") && ! isAdmin) {

            // Student internships
            if (action_value != null && action_value.equals("internships")) {
                action_students_internships(request, response);
                return;
            }
        }

        // Check if the user is admin
        if (isAdmin) {

            if (action_value != null && action_value.equals("companies")) {
                action_view_companies(request, response);
                return;
            }

            // View a specific company document
            if (action_value == null && type_value != null && id_value != null &&
                    type_value.equals("company") && id_value.matches("[0-9]+")) {
                int real_int = Integer.parseInt(id_value);
                generateAgreementDocument(real_int, request, response);
                return;
            }
        }

    }

    /** Admin **/
    private void action_view_companies(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        // Approved companies have signed documents associated, so it's easier to manage them
        companyDao cDao = new companyDaoImpl();
        List<Company> cList = cDao.getApprovedCompaniesList();

        request.setAttribute("cData", cList);

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_admin.ftl");

        dispatcher.forward(request, response);
    }

    // Generate the documentation of a company by its id
    // This belongs to the admin's documents, so it's marked under 'admin'
    private void generateAgreementDocument(int company_id, HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException, ServletException {

        // Get the company data
        companyDao cDao = new companyDaoImpl();
        String tempEmail = cDao.getEmailByID(company_id);
        String resultString = null;

        Company companyModel = cDao.getCompanyDataByEmail(tempEmail);

        // Compile the corresponding document (document3)
        AgreementDocument aD = new AgreementDocument();

        // Set the necessary fields
        aD.setNome_azienda(companyModel.getRagione_sociale());
        aD.setNome_rapp(companyModel.getNome_cognome_rap());
        aD.setSede_legale(companyModel.getIndirizzo_sede_leg());
        aD.setProv_sede(companyModel.getProvincia());
        aD.setCf_piva_azienda(companyModel.get_cf_iva());
        aD.setForo_comp(companyModel.getForo_competente());

        request.setAttribute("doc", aD);

        if (Utils.checkFFUG(request)) {
            System.out.println("firefox");
            resultString = "/WEB-INF/views/document_3_alt.ftl";
        } else resultString = "/WEB-INF/views/document_3.ftl";

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher(resultString);

        dispatcher.forward(request, response);

    }

    private void generateDocument1(HttpServletRequest request, HttpServletResponse response, String student_id, String internship_id) throws PropertyVetoException, SQLException, IOException, ServletException {

        String resultString = "";
        String companyMail = homeServlet.loggedUserEmail;

        int stud_id = Integer.parseInt(student_id);
        int inter_id = Integer.parseInt(internship_id);
        // Get the internship and student data
        UserDao uDao = new UserDaoImpl();
        internshipDao iDao = new internshipDaoImpl();
        companyDao comDao = new companyDaoImpl();

        Internship internshipData = iDao.getInternshipDataById(inter_id);
        User userData = uDao.getUser(uDao.getEmailByID(stud_id));
        Company companyData = comDao.getCompanyDataByEmail(companyMail);
        InternshipRequest interReq = iDao.getInternshipRequestByIDs(inter_id, stud_id);

        String com_head = null;
        String rem_conn = null;
        String ref_exp = null;
        String com_ref = null;
        String train_aid = null;



        // Compile the corresponding document (document3)
        ArrayList<String> document1 = new ArrayList<>();

        document1.add(userData.getNome());
        document1.add(userData.getCognome());
        document1.add(userData.getLuogo_nascita());
        document1.add(userData.getProvincia_n());
        document1.add(userData.getDate());
        document1.add(userData.getResidenza());
        document1.add(userData.getProvincia());
        document1.add(userData.getCod_fiscale());
        document1.add(userData.getTel());
        document1.add(userData.getCorso());
        document1.add(String.valueOf(userData.getHandicap()));
        document1.add(companyData.getRagione_sociale());
        document1.add(internshipData.getLuogo());
        document1.add(internshipData.getSettore());
        document1.add(internshipData.getOrari());
        document1.add(internshipData.getMesi());
        document1.add(internshipData.getMeseInziale());
        document1.add(internshipData.getMeseFinale());
        document1.add(internshipData.getOre());
        document1.add(interReq.getCfu());
        document1.add(interReq.getTutor_name());
        document1.add(interReq.getTutor_surname());
        document1.add(interReq.getTutor_email());
        document1.add(companyData.getNome_cognome_tir());
        document1.add(companyData.getTelefono_tirocini());
        document1.add(internshipData.getObiettivi());
        if (internshipData.isCompany_headquarters())  com_head = "ok";
        if (internshipData.isRemote_connection())  rem_conn = "ok";
        if (internshipData.isRefound_of_expenses())  ref_exp = "ok";
        if (internshipData.isCompany_refactory())  com_ref  = "ok";
        if (internshipData.isTraining_aid())   train_aid = "ok";
        document1.add(com_head);
        document1.add(rem_conn);
        document1.add(internshipData.getModalita());
        document1.add(ref_exp);
        document1.add(com_ref);
        document1.add(train_aid);
        document1.add(internshipData.getRimborsi_spese_facilitazioni_previste());

        request.setAttribute("doc", document1);

        if (Utils.checkFFUG(request)) {
            System.out.println("firefox");
            resultString = "/WEB-INF/views/document_1_alt.ftl";
        } else resultString = "/WEB-INF/views/document_1.ftl";

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher(resultString);

        dispatcher.forward(request, response);

    }

    /** Student **/
    private void action_students_internships(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/my_internship.ftl");

        dispatcher.forward(request, response);

    }

    /** Company **/

    private void action_students_page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        String azz =  "";
        String azz2 = "";
        UserDao uDao = new UserDaoImpl();
        internshipDao intDao = new internshipDaoImpl();
        companyDao comDao = new companyDaoImpl();

        int az_id = ((companyDaoImpl) comDao).getCompanyIdbyName(tempName);

        ArrayList<InternshipRequest> internshipsArray = intDao.getInternshipsStudents(az_id);

        ArrayList<Internship> internArray = new ArrayList<>();
        ArrayList<User> userArray  = new ArrayList<User>();

        for (int i = 0; i < internshipsArray.size(); i++) {

            azz = uDao.getEmailByID(internshipsArray.get(i).getStudent_id());
            internArray.add(intDao.getInternshipByID(internshipsArray.get(i).getInternship_id()));
            userArray.add(uDao.getUser(azz));
        }


        request.setAttribute("userList", userArray);
        request.setAttribute("internshipsList", internArray);
        request.setAttribute("username", tempName);



        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_company.ftl");

        dispatcher.forward(request, response);

    }


    private void action_compile_document1_2(HttpServletRequest request, HttpServletResponse response, String student_id, String internship_id) throws ServletException, IOException, PropertyVetoException, SQLException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_iter_student.ftl");

        dispatcher.forward(request, response);
    }

    private void action_students_manage_int(HttpServletRequest request, HttpServletResponse response, String int_id) throws ServletException, IOException, PropertyVetoException, SQLException, ParseException {

        String tirocinio = "";
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        UserDao uDao = new UserDaoImpl();
        internshipDao intDao = new internshipDaoImpl();
        Internship int1 = intDao.getInternshipDataById(Integer.parseInt(int_id));

        int user_id = uDao.getIDbyInternship_id(Integer.parseInt(int_id));
        String startDate = int1.getMeseInziale();
        String endDate = int1.getMeseFinale();

        tirocinio = getInternshipStatus(startDate, endDate);

        request.setAttribute("username", tempName);
        request.setAttribute("tirocinio", tirocinio);
        request.setAttribute("dataFinale", int1.getMeseFinale());
        request.setAttribute("user_id", user_id);
        request.setAttribute("internship_id", int_id);

        // Vedo il documento 1 quando il tirocinio INIZIA
        boolean internship_accepted = uDao.checkInternshipAccepted(user_id,Integer.parseInt(int_id));

        if (internship_accepted) {

            request.setAttribute("intAccepted", "true");
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/manage_internship.ftl");

            dispatcher.forward(request, response);

        } else {
            request.getSession().setAttribute("errorMessage", "There aren't documents yet");
            response.sendRedirect("/documents?action="+int1.getIternship_id());
        }
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



    private void action_choose_page(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/choose_documents_company.ftl");

        dispatcher.forward(request, response);
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