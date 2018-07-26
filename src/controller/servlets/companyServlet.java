package controller.servlets;

import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class companyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("companiesList", null);

        request.setAttribute("header", "");
        request.setAttribute("sidemenu", "");

        // URL Parameters
        String paramName = "view";
        String paramValue = request.getParameter(paramName);

        Security securityModel = SecurityFilter.checkUsers(request);

        if (securityModel.getUser().equals("student")) {
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

        if (securityModel.getUser().equals("admin")) {
            request.setAttribute("header", "admin");
            request.setAttribute("sidemenu", "admin");
        }

        try {
            // Check if the user has given the right parameters
            if (paramValue == null) {
                action_default(request, response);
                return;
            }

            // View the company list
            if (paramValue.equals("all")) {
                action_view_all(request, response);
                return;
            }

            // View a specific company
            if (paramValue.matches("[0-9]+")) {
                action_view_company(request, response);
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

        companyDao compDao = new companyDaoImpl();

        // Get the company list
        ArrayList<Company> companiesArray = compDao.getCompaniesList();

        System.out.println(companiesArray.get(0).getRagione_sociale());

        request.setAttribute("companiesList", companiesArray);
        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);
    }

    protected void action_view_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {
        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);
    }

    protected static void action_default(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/companies_list.ftl").forward(request, response);
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