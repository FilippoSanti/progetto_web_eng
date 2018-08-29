package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import model.InternshipRequest;
import model.User;

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
        String paramName1    = "delete";
        String paramValue1 = request.getParameter(paramName1);
        String paramName2    = "approve";
        String paramValue2 = request.getParameter(paramName2);


        try {
            // Check if the user has given the right parameters
            if (paramValue == null && paramValue1 == null && paramName2 == null) {
                action_default(request, response);
                return;
            }
            if (paramValue != null) {
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
            }

            if (paramValue1 != null) {
                if (paramValue1.matches("[0-9]+")) {
                    action_delete(request, response, paramValue1);
                    return;
                }
            }

            if (paramValue2 != null) {
                if (paramValue2.matches("[0-9]+")) {
                    action_approve(request, response, paramValue2);
                    return;
                }
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

        String azz= "";
        companyDao comDao = new companyDaoImpl();
        String email_azie = homeServlet.loggedUserEmail;
        int az_id = comDao.getCompanyIdbyEmail(email_azie);

        UserDao uDao = new UserDaoImpl();
        internshipDao intDao = new internshipDaoImpl();
        int tir_id1 = Integer.parseInt(tir_id);

        ArrayList<InternshipRequest> internshipsArray = intDao.getCandidates_listbyTirocinioId(tir_id1);

        ArrayList<User> userArray  = new ArrayList<User>();

        for (int i = 0; i < internshipsArray.size(); i++) {

           azz = uDao.getEmailByID(internshipsArray.get(i).getStudent_id());
            userArray.add(uDao.getUser(azz));
        }



        request.setAttribute("userList", userArray);


        request.getRequestDispatcher("/WEB-INF/views/candidates_list.ftl").forward(request, response);

    }

    protected void action_approve(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException, PropertyVetoException, SQLException {
        internshipDao intDao = new internshipDaoImpl();
        int user_id1 = Integer.parseInt(user_id);
        intDao.enableInternshipRequest(user_id1);
        System.out.println(user_id1);
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

    }

    protected void action_delete(HttpServletRequest request, HttpServletResponse response, String user_id) throws ServletException, IOException, PropertyVetoException, SQLException {
        internshipDao intDao = new internshipDaoImpl();
        int user_id2 = Integer.parseInt(user_id);
        intDao.deleteInternshipRequest(user_id2);

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
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