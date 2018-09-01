package controller.servlets.general;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
import model.Company;
import model.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.beans.PropertyVetoException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * This servlet handles the document visualization
 * of a specific user, company or administrator
 **/

@MultipartConfig(location="", fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)

public class viewDocumentationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        Security securityModel = SecurityFilter.checkUsers(request);

        // URL paramaters
        String action = "action";
        String type = "type";
        String id = "id";

        String type_value = request.getParameter(type);
        String id_value = request.getParameter(id);
        String action_value = request.getParameter(action);

        // Administator requests
        if (securityModel.getUser().equals("student") &&
                securityModel.getRole().equals("admin")) {

            // View the documentation of a company
            // This is different from documentsServlet!
            if (action_value == null && type_value != null && id_value != null &&
                    type_value.equals("company") && id_value.matches("[0-9]+")) {
                int real_id = Integer.valueOf(id_value);
                action_show_company_documentation(real_id, request, response);
                return;
            }

            // Signed document upload
            if (action_value != null && type_value != null && id_value != null &&
                    action_value.equals("upload") && type_value.equals("company") &&
                    id_value.matches("[0-9]+")) {
                int real_id = Integer.valueOf(id_value);
                action_upload_admin_document(real_id, request, response);
            }
        }
    }

    // Show the documentation iter of a specific company
    private void action_show_company_documentation(int company_id, HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException, ServletException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        // Get the company info
        companyDao cDao = new companyDaoImpl();
        Company companyModel = cDao.getCompanyDataByEmail(cDao.getEmailByID(company_id));

        request.setAttribute("id", companyModel.getCompany_id());
        request.setAttribute("type", "company");

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documents_iter_admin.ftl");

        dispatcher.forward(request, response);

        // Chrome browser fix
        if (request.getSession().getAttribute("errorMessage") != null) {
            request.getSession().removeAttribute("errorMessage");
        }
    }

    // PDF Upload function
    private void action_upload_admin_document(int company_id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {

        UserDao userDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String filename = "/assets/documents/" + "company_" + company_id + ".pdf";

        // Get the servlet context and build a pathname for the file
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filename);

        String MIME_TYPE = Utils.checkPDF(fileContent);
        if (MIME_TYPE.equals("application/pdf")) {
            OutputStream out = new FileOutputStream(pathname);
            Utils.copy(fileContent, out);
        } else {
            request.getSession().setAttribute("errorMessage", "Please upload a valid pdf file");
            response.sendRedirect("/viewDocumentation?type=company&id=" + company_id);
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
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}