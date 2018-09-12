package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Internship;
import model.Security;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class internshipsListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        request.setAttribute("internships_list", null);

        // URL Parameters
        String paramName    = "view";
        String paramValue = request.getParameter(paramName);

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
                action_view_internship_azienda(request, response, paramValue);
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

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        request.setAttribute("username", tempName);
        companyDao comDao = new companyDaoImpl();
        internshipDao intDao = new internshipDaoImpl();

        // Get the internships list
        ArrayList<Internship>internshipsArray = intDao.getInternshipList();

        ArrayList<Company> companyList = new ArrayList<Company>();

        for (int i= 0; i< internshipsArray.size(); i++) {
            String com_name = comDao.getEmailByID(internshipsArray.get(i).getAzienda_id());
            companyList.add(comDao.getCompanyDataByEmail(com_name));
        }

        // Scan the internships list to find out if an internship is terminated or in progress
        // If so, we delete if from the list
        for (int i = 0; i < internshipsArray.size(); i++) {
            String result = getInternshipStatus(internshipsArray.get(i).getMeseInziale(), internshipsArray.get(i).getMeseInziale());
            if (result.equals("Completed") || result.equals("In progress")) {
                internshipsArray.remove(internshipsArray.get(i));
            }
        }

        request.setAttribute("company_list", companyList);
        request.setAttribute("internships_list", internshipsArray);
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);

    }

    protected void action_view_internship_azienda(HttpServletRequest request, HttpServletResponse response, String az_id) throws ServletException, IOException, PropertyVetoException, SQLException {
        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);

        request.setAttribute("username", tempName);

        companyDao comDao = new companyDaoImpl();
        internshipDao intDao = new internshipDaoImpl();
        ArrayList<Internship>internshipsArray = intDao.getInternshipListbyId(Integer.parseInt(az_id));

        ArrayList<Company> companyList = new ArrayList<Company>();

        for (int i= 0; i< internshipsArray.size(); i++) {
            String com_name = comDao.getEmailByID(Integer.parseInt(az_id));
            companyList.add(comDao.getCompanyDataByEmail(com_name));
        }


        request.setAttribute("internships_list", internshipsArray);
        request.setAttribute("company_list", companyList);

        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);

    }

    protected static void action_default (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/internships_list.ftl").forward(request, response);
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