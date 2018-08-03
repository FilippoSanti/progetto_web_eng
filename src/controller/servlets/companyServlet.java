package controller.servlets;

import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;

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

        // Execute the default action
        action_view_all(request, response);

    }

    protected void action_view_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        companyDao compDao = new companyDaoImpl();

        // Get the company list
        ArrayList<Company> companiesArray = compDao.getCompaniesList();

        request.setAttribute("companiesList", companiesArray);
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