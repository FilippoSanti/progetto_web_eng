package controller.servlets.general;

import controller.dao.*;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Internship;
import model.Security;
import model.User;

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

        if (term_value != null && place_value != null && duration_min_value != null &&
                duration_max_value != null) {
            action_search(request, response);
        }

    }

    private void action_search(HttpServletRequest request, HttpServletResponse response) {



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