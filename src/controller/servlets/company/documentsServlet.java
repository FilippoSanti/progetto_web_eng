package controller.servlets.company;

import controller.dao.*;
import controller.servlets.general.homeServlet;
import controller.utilities.SecurityFilter;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static java.time.LocalDate.now;

public class documentsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        Security securityModel = SecurityFilter.checkUsers(request);

        // URL Parameters

        String action = "action";
        String action_value = request.getParameter(action);

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

        // Check if the user is a logged student
        if (securityModel.getUser().equals("student")) {

            // Student internships
            if (action_value != null && action_value.equals("internships")) {
                action_students_internships(request, response);
                return;
            }
        }

        // Check if the user is admin
        if (securityModel.getUser().equals("student") &&
                securityModel.getRole().equals("admin")) {

            if (action_value != null && action_value.equals("companies")) {
                action_view_companies(request, response);
            }
        }

    }

    /** Admin **/
    private void action_view_companies(HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documentation_admin.ftl");

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

        System.out.println(iniziale);
        System.out.println(finale);
        System.out.println( System.currentTimeMillis());

        if (iniziale > System.currentTimeMillis())  tirocinio = "not started";
        else if (finale < System.currentTimeMillis())  tirocinio = "completed";
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