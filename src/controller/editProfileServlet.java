package controller;

import controller.core.companyDAO;
import controller.core.userController;
import controller.core.userDAO;
import controller.utilities.SecurityFilter;
import model.Company;
import model.Security;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class editProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("errorMessage", "");

        String paramValue = "";

        // URL Parameters
        String paramName    = "sumbit";
        paramValue = request.getParameter(paramName);

        Security securityModel = SecurityFilter.checkUsers(request);

        // Security model checks
        if (securityModel.getUser().equals("student")) {
            action_student(request, response);
            return;
        }

        if (securityModel.getUser().equals("azienda")) {

            // Check if we are trying to edit company login data or informations

            if (paramValue == null) {
                action_company(request, response);
                return;
            }

            if (paramValue.equals("login")) {
                action_update_login_values_company(request, response);
            }

            if (paramValue.equals("info")) {
                action_update_profile_values_company(request, response);
                return;
            }

            return;
        }

        if (securityModel.getUser().equals("anonymous")) {
            action_anonymous(request, response);
            return;
        }

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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public void action_default(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.ftl");

        dispatcher.forward(request, response);
    }

    /** User */
    protected void action_student(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        display_user_image(request);

        // Get the user object and set the attribute
        User user = userDAO.getUserDataByEmail(homeServlet.loggedUserEmail);
        request.setAttribute("userData", user);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit_student_infos.ftl");

        dispatcher.forward(request, response);

    }

    /** Company */
    protected void action_company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PropertyVetoException, SQLException {

        display_user_image(request);

        Company company = companyDAO.getCompanyDataByEmail(homeServlet.loggedUserEmail);

        // Set the user attributes to display on screen
        request.setAttribute("companyData", company);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit_company_infos.ftl");

        dispatcher.forward(request, response);

    }

    /** Anon */
    protected void action_anonymous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action_default(request, response);
    }

    public void display_user_image(HttpServletRequest request) throws PropertyVetoException, SQLException, IOException {

        // Find out if the session belongs to a user or a company
        String userType = null;
        if (userController.checkSession(request,"studente")) {
            userType = "student";
        } else if (userController.checkSession(request, "azienda")) {
            userType = "azienda";
        }

        if (userType.equals("student")) {

            // Check if a user image has been uploaded by the user
            // Other wise we include the default image
            User user = userDAO.getUserDataByEmail(homeServlet.loggedUserEmail);
            String userID = String.valueOf(user.getId());

            ServletContext context = getServletContext();
            String filename = "/assets/images/users/"+ "user_"+userID+".png";
            String pathname = context.getRealPath(filename);

            File f = new File(pathname);
            if(f.exists() && !f.isDirectory()) {
                // Set the page attribute
                request.setAttribute("image_path", "../../assets/images/users/"+ "user_"+userID+".png");
            } else {
                request.setAttribute("image_path", "../../assets/images/users/default_user.png");
            }

        } else {

            // Same thing but for the companies
            Company company = companyDAO.getCompanyDataByEmail(homeServlet.loggedUserEmail);
            String userID = String.valueOf(company.getCompany_id());

            ServletContext context = getServletContext();
            String filename = "/assets/images/users/"+ "company_"+userID+".png";
            String pathname = context.getRealPath(filename);

            File f = new File(pathname);
            if(f.exists() && !f.isDirectory()) {
                // Set the page attribute
                request.setAttribute("image_path", "../../assets/images/users/"+ "company_"+userID+".png");
            } else {
                request.setAttribute("image_path", "../../assets/images/users/default_company.png");
            }
        }
    }

    protected void action_update_profile_values_company (HttpServletRequest request, HttpServletResponse response) throws SQLException, PropertyVetoException, ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String email_login = homeServlet.loggedUserEmail;

        String ragione_sociale, indirizzo_legle, nome_cognome_rapp, nome_cognome_tir, foro_comp,
                cf_rapp, partita_iva, provincia, email_tirocini, descrizione, telefono;

        ragione_sociale = indirizzo_legle = nome_cognome_rapp = nome_cognome_tir = foro_comp = cf_rapp = partita_iva =
                provincia = email_tirocini = descrizione = telefono = "";

        ragione_sociale   = request.getParameter("ragione_sociale");
        indirizzo_legle   = request.getParameter("indirizzo_legale");
        nome_cognome_rapp = request.getParameter("nome_cognome_rap");
        nome_cognome_tir  = request.getParameter("nome_cognome_tir");
        foro_comp         = request.getParameter("foro_comp");
        cf_rapp           = request.getParameter("cf_rapp");
        partita_iva       = request.getParameter("partita_iva_rapp");
        provincia         = request.getParameter("provincia");
        email_tirocini    = request.getParameter("email_tirocini");
        descrizione       = request.getParameter("descrizione");
        telefono          = request.getParameter("telefono");

        if (ragione_sociale.isEmpty() || indirizzo_legle.isEmpty() || nome_cognome_rapp.isEmpty() || nome_cognome_tir.isEmpty() || foro_comp.isEmpty() ||
                cf_rapp.isEmpty() || partita_iva.isEmpty() || provincia.isEmpty() || email_tirocini.isEmpty() || descrizione.isEmpty()) {

            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Fields cannot be empty");

            action_company(request, response);

        } else {

            // Update the fields in the DB
            companyDAO.updateCompanyField(email_login, ragione_sociale, indirizzo_legle, cf_rapp, partita_iva,
                    nome_cognome_rapp, nome_cognome_tir, telefono, email_tirocini, foro_comp, provincia, true, descrizione, email_login);

            response.sendRedirect("/editProfile");
        }
    }

    protected void action_update_login_values_company (HttpServletRequest request, HttpServletResponse response) throws SQLException, PropertyVetoException, ServletException, IOException {

        String email_login   = request.getParameter("email_login");
        String password      = request.getParameter("password_company");
        String ripeti_pass   = request.getParameter("ripeti_password_company");

        if (password.isEmpty() || email_login.isEmpty()) {
            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Fields cannot be empty");
            action_company(request, response);
        }

        if (!password.equals(ripeti_pass)) {
            // Signal that an error has occurred
            request.setAttribute("errorMessage", "Passwords don't match");
            action_company(request, response);
        } else {
            companyDAO.updateEmailAndPassword(email_login, password, email_login);
            response.sendRedirect("/logout");
        }
    }
}