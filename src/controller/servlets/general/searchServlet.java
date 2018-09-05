package controller.servlets.general;

import controller.dao.*;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Internship;
import model.Security;
import model.User;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class searchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");

        // URL Parameters
        String term = "term";
        String place = "place";
        String duration_min = "duration_min";
        String duration_max = "duration_max";

        String term_value = request.getParameter(term);
        String place_value = request.getParameter(place);
        String duration_min_value = request.getParameter(duration_min);
        String duration_max_value = request.getParameter(duration_max);

        action_search(request, response, term_value, Integer.valueOf(place_value), Integer.valueOf(duration_min_value), Integer.valueOf(duration_max_value));
    }

    private void action_search(HttpServletRequest request, HttpServletResponse response, String term,
                               int place, int duration_min, int duration_max) throws IOException, PropertyVetoException, SQLException, ServletException {

        if (term == null || term.isEmpty()) {
            response.sendRedirect("/home");
            return;
        }

        // Every parameter is ok, so we send the data to another function to parse it
        ArrayList<Internship> resultList = action_compile_list(request, response, term, place, duration_min, duration_max);
        show_results(request, response, resultList);

    }

    // This functions loads internship list with the generated results
    private void show_results(HttpServletRequest request, HttpServletResponse response, ArrayList<Internship> resultList) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao cDao = new companyDaoImpl();
        ArrayList<Company> companyList = new ArrayList<Company>();

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        for (int i= 0; i< resultList.size(); i++) {
            String com_name = cDao.getEmailByID(resultList.get(i).getAzienda_id());
            companyList.add(cDao.getCompanyDataByEmail(com_name));
        }

        request.setAttribute("company_list", companyList);
        request.setAttribute("internships_list", resultList);
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/internships_list.ftl");

        dispatcher.forward(request, response);
    }

    // Create a list with the search results
    private ArrayList<Internship> action_compile_list(HttpServletRequest request, HttpServletResponse response, String term, int place,
                                     int duration_min, int duration_max) throws PropertyVetoException, SQLException, IOException {

        ArrayList<Internship> result = new ArrayList<>();
        boolean hasResults = false;
        boolean locationOk = false;

        // Get the internships into a list and find the results
        internshipDao iDao = new internshipDaoImpl();
        ArrayList<Internship> tempList = iDao.getInternshipList();

        // Scan the list and select the result
        for (int i = 0; i < tempList.size(); i++) {

            hasResults = false;
            locationOk = false;

            // See if the term matches anything
            if (tempList.get(i).getNome().toLowerCase().contains(term.toLowerCase()) ||
                    tempList.get(i).getLuogo().toLowerCase().contains(term.toLowerCase()) ||
                    tempList.get(i).getDettagli().toLowerCase().contains(term.toLowerCase())) {
                hasResults = true;
            }

            // If we find anything, we have to check the location
            if (hasResults) {

                // Check the internship location
                if (place == 0) {
                    if (tempList.get(i).isCompany_headquarters()) {
                        locationOk = true;
                    }

                } else if (place == 1) {
                    if (tempList.get(i).isRemote_connection()) {
                        locationOk = true;
                    }
                } else if (place == 2) {
                    locationOk = true;
                }
            }

            // Check if the dates are valid
            if (locationOk) {
                // Execute the date operations
                DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

                DateTime date_min = formatter.parseDateTime(tempList.get(i).getMeseInziale());
                DateTime date_max = formatter.parseDateTime(tempList.get(i).getMeseFinale());

                // We get the months between the two dates to check it against out query
                int months = Months.monthsBetween(date_min, date_max).getMonths();

                if (duration_min <= months && duration_max >= months) {
                    result.add(tempList.get(i));
                }
            }
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