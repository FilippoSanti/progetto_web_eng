package controller.servlets;

import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.dao.internshipDao;
import controller.dao.internshipDaoImpl;
import model.InternshipRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class candidates_listServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("candidates_list", null);

        // URL Parameters
        String paramName    = "view";
        String paramValue = request.getParameter(paramName);

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
                action_view_candidates_list(request, response, paramValue);
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

    protected void action_view_candidates_list(HttpServletRequest request, HttpServletResponse response, String tir_id) throws ServletException, IOException, PropertyVetoException, SQLException {


        companyDao comDao = new companyDaoImpl();
        String email_azie = homeServlet.loggedUserEmail;
        int az_id = comDao.getCompanyIdbyEmail(email_azie);


        internshipDao intDao = new internshipDaoImpl();
        int tir_id1 = Integer.parseInt(tir_id);
        System.out.println(tir_id);
        System.out.println(tir_id1);
        ArrayList<InternshipRequest> internshipsArray = intDao.getCandidates_listbyTirocinioId(tir_id1, az_id);
        request.setAttribute("candidates_list", internshipsArray);
        request.getRequestDispatcher("/WEB-INF/views/candidates_list.ftl").forward(request, response);

    }

    protected void action_view_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao comDao = new companyDaoImpl();
        String email_azie = homeServlet.loggedUserEmail;
        int az_id = comDao.getCompanyIdbyEmail(email_azie);


        internshipDao intDao = new internshipDaoImpl();


        ArrayList<InternshipRequest> internshipsArray = intDao.getCandidates_list(az_id);
        request.setAttribute("candidates_list", internshipsArray);


        request.getRequestDispatcher("/WEB-INF/views/candidates_list.ftl").forward(request, response);

    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/candidates_list.ftl").forward(request, response);
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