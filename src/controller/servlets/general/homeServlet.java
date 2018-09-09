package controller.servlets.general;

import controller.dao.*;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class homeServlet extends HttpServlet {

    public static String loggedUserEmail = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");

        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("student")){
            action_student(request, response);
        }

        if (securityModel.getUser().equals("azienda")) {
            action_company(request, response);
        }

        if (securityModel.getUser().equals("anonymous")) {
            action_default_anonymous(request, response);
        }
    }

    protected void action_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        HttpSession session = request.getSession();

        // Get the user object attribute containing the user email
        User userModel = (User) session.getAttribute("loggedInUser");
        loggedUserEmail = userModel.getEmail();

        // The security model uses loggedUserEmail, so we must declare it later
        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getRole().equals("admin")) {
            action_default_admin(request, response);
        } else {
            action_default_student(request, response);
        }
    }

    protected void action_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        HttpSession session = request.getSession();

        // Get the user object attribute containing the user email
        Company companyModel = (Company) session.getAttribute("loggedInCompany");
        loggedUserEmail = companyModel.getEmail_login();

        companyDao compDao = new companyDaoImpl();

        String email_azie = homeServlet.loggedUserEmail;
        int az_id = compDao.getCompanyIdbyEmail(email_azie);

        internshipDao intDao = new internshipDaoImpl();
        ArrayList<Internship> internshipsArray = intDao.getInternshipListbyId(az_id);

        int k = internshipsArray.size();
        if (k>12)
            internshipsArray.subList(12, k).clear();

        request.setAttribute("internships_list_company", internshipsArray);


        action_default_company(request, response);
    }

    /** Default actions **/

    public void action_default_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        companyDao compDao = new companyDaoImpl();

        // Get the company list
        ArrayList<Company> companiesArray = compDao.getCompaniesList();

        int k = companiesArray.size();
        if (k>12)
            companiesArray.subList(12, k).clear();


        request.setAttribute("companiesList", companiesArray);
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_student.ftl");

        dispatcher.forward(request, response);
    }

    public void action_default_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_company.ftl");

        dispatcher.forward(request, response);
    }

    public void action_default_admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        //load statistics
        int nInternships = 0;
        int nStudents = 0;
        int nCompanies = 0;
        int nMostCandidates = 0;
        String nameMostCandidates = "";

        UserDao uDao = new UserDaoImpl();
        internshipDao iDao = new internshipDaoImpl();
        companyDao cDao = new companyDaoImpl();

        ArrayList<Internship> internshipList = iDao.getInternshipList();
        ArrayList<User> userList = uDao.getUserList();
        ArrayList<Company> companyList = cDao.getCompaniesList();
        int[] mostCandidatesCompany = cDao.mostCandidatesCompany();
        Company mostCand = cDao.getCompanyDataByEmail(cDao.getEmailByID(mostCandidatesCompany[0]));
        String[] mostRequestedTutor = iDao.mostRequestedTutor();

        String nameMostReqTutor = mostRequestedTutor[0];
        String surnameMostReqTutor = mostRequestedTutor[1];
        String nTutorRequest = mostRequestedTutor[2];
        nameMostCandidates = mostCand.getRagione_sociale();
        nMostCandidates = mostCandidatesCompany[1];
        nInternships = internshipList.size();
        nStudents = userList.size();
        nCompanies = companyList.size();


        request.setAttribute("tutorName", nameMostReqTutor);
        request.setAttribute("tutorSurname",surnameMostReqTutor);
        request.setAttribute("nTutor", nTutorRequest);
        request.setAttribute("nStudents", nStudents);
        request.setAttribute("nInternships", nInternships);
        request.setAttribute("nCompanies", nCompanies);
        request.setAttribute("nameMostCandidates", nameMostCandidates);
        request.setAttribute("nMostCandidates", nMostCandidates);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_admin.ftl");

        dispatcher.forward(request, response);
    }

    protected void action_default_anonymous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao compDao = new companyDaoImpl();

        // Get the company list

        ArrayList<Company> companiesArray = compDao.getCompaniesList();

        int k = companiesArray.size();
        if (k>12)
            companiesArray.subList(12, k).clear();

        request.setAttribute("companiesList", companiesArray);

        // home_visitor.ftl
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_visitor.ftl");

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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}