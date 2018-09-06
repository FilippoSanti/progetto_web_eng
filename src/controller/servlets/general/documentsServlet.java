package controller.servlets.general;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
import model.*;

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

        String action_value = request.getParameter(action);
        String type_value = request.getParameter(type);
        String id_value = request.getParameter(id);

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

    private void action_students_manage_int(HttpServletRequest request, HttpServletResponse response, String int_id) throws ServletException, IOException, PropertyVetoException, SQLException, ParseException {

        String tirocinio = "";
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        internshipDao intDao = new internshipDaoImpl();
        Internship int1 = intDao.getInternshipDataById(Integer.parseInt(int_id));
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        Date a = formatter.parse(int1.getMeseInziale());
        Date b = formatter.parse(int1.getMeseFinale());

        long iniziale = a.getTime();
        long finale = b.getTime();

        if (iniziale > System.currentTimeMillis())  tirocinio = "not started";
        else if (finale > System.currentTimeMillis())  tirocinio = "completed";
        else  tirocinio = "in progress";

        request.setAttribute("username", tempName);
        request.setAttribute("tirocinio", tirocinio);
        request.setAttribute("dataFinale", int1.getMeseFinale());

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/manage_internship.ftl");

        dispatcher.forward(request, response);
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