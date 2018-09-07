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
import java.io.*;
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
        String student_id = "student_id";
        String internship_id = "internship_id";

        String type_value = request.getParameter(type);
        String id_value = request.getParameter(id);
        String action_value = request.getParameter(action);
        String student_id_value = request.getParameter(student_id);
        String internship_id_value = request.getParameter(internship_id);

        /** Administrator requests */
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
                return;
            }

            // View a signed pdf document
            if (action_value != null && type_value != null && id_value != null &&
                    action_value.equals("requestDocument") && type_value.equals("company") &&
                    id_value.matches("[0-9]+")) {
                int real_id = Integer.valueOf(id_value);
                action_view_signed_document(real_id, request, response);
                return;
            }
        }

        /** Student requests */
        if (securityModel.getUser().equals("student") &&
                securityModel.getRole().equals("user")) {

            // View the document_1 of a user
            if (action_value != null && type_value != null && id_value != null &&
                    action_value.equals("requestDocument1") && type_value.equals("student") &&
                    id_value.matches("[0-9]+")) {
                int real_id = Integer.valueOf(id_value);
                action_view_user_document(real_id, request, response);
                return;
            }
        }


        /** Company requests */
        if (securityModel.getUser().equals("azienda")) {

            if (action_value != null && student_id_value != null && internship_id_value != null &&
                    action_value.equals("upload") && student_id_value.matches("[0-9]+") &&
                    internship_id_value.matches("[0-9]+")) {

                int real_id = Integer.valueOf(student_id_value);
                int real_id2 = Integer.valueOf(internship_id_value);

                action_upload_company_document(request, response, real_id, real_id2);

                return;
            }

            if (action_value != null && student_id_value != null && internship_id_value != null &&
                    action_value.equals("student") && student_id_value.matches("[0-9]+") &&
                    internship_id_value.matches("[0-9]+")) {

                int real_id = Integer.valueOf(student_id_value);
                int real_id2 = Integer.valueOf(internship_id_value);

                action_show_student_documentation(real_id, real_id2, request, response);

                return;
            }
        }
    }

    /** Student functions below **/
    private void action_view_user_document(int real_id, HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documents_iter_student.ftl");

        dispatcher.forward(request, response);
    }

    /** Administrator functions below **/
    // Show the documentation iter of a specific company
    private void action_show_company_documentation(int company_id, HttpServletRequest request, HttpServletResponse response) throws PropertyVetoException, SQLException, IOException, ServletException {
        companyDao cDao = new companyDaoImpl();

        // If the company has already been enabled, we print a message to inform the user
        if (cDao.checkCompanyEnabled(cDao.getEmailByID(company_id))) {
            request.setAttribute("companyApproved", "Be careful, this company has already been approved");
        }

        // Check if we can enable the approve button
        // We do that only if the signed document exists in a directory
        if (checkForDocumentation(company_id)) {
            request.setAttribute("approveButton", "enabled");
        }

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        // Get the company info
        Company companyModel = cDao.getCompanyDataByEmail(cDao.getEmailByID(company_id));

        request.setAttribute("id", companyModel.getCompany_id());
        request.setAttribute("type", "company");

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documents_iter_admin.ftl");

        dispatcher.forward(request, response);

        // Delete old messages and error messages every time we load the page
        // Chrome browser fix included
        if (request.getSession().getAttribute("errorMessage") != null) {
            request.getSession().removeAttribute("errorMessage");
        }

        if (request.getSession().getAttribute("Message") != null) {
            request.getSession().removeAttribute("Message");
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
        String filename = "/assets/documents/admin/" + "company_" + company_id + ".pdf";

        // Get the servlet context and build a pathname for the file
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filename);

        String MIME_TYPE = Utils.checkPDF(fileContent);

        // Check for the file type and upload the pdf
        if (MIME_TYPE == null || !MIME_TYPE.equals("pdf")) {
            request.getSession().setAttribute("errorMessage", "Please upload a valid pdf file");
            response.sendRedirect("/viewDocumentation?type=student&student_id=" + company_id);
        } else {
            OutputStream out = new FileOutputStream(pathname);
            Utils.copy(fileContent, out);

            // File uploaded correctly
            request.getSession().setAttribute("Message", "File uploaded successfully");
            response.sendRedirect("/viewDocumentation?type=company&id=" + company_id);
        }
    }

    private void action_show_student_documentation(int student_id, int internship_id, HttpServletRequest request,HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {
        companyDao cDao = new companyDaoImpl();

        // Check if we can enable the approve button
        // We do that only if the signed document exists in a directory
        if (checkForDocumentation(student_id)) {
            request.setAttribute("approveButton", "enabled");
        }

        // Set the logged user name
        String tempName = controller.userController.getUsername(homeServlet.loggedUserEmail);
        request.setAttribute("username", tempName);

        request.setAttribute("student_id", student_id);
        request.setAttribute("internship_id", internship_id);


        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/documents_iter_company.ftl");

        dispatcher.forward(request, response);

        // Delete old messages and error messages every time we load the page
        // Chrome browser fix included
        if (request.getSession().getAttribute("errorMessage") != null) {
            request.getSession().removeAttribute("errorMessage");
        }

        if (request.getSession().getAttribute("Message") != null) {
            request.getSession().removeAttribute("Message");
        }
    }

    // Upload the signed document1 of a company
    private void action_upload_company_document(HttpServletRequest request, HttpServletResponse response, int student_id, int internship_id) throws ServletException, IOException, IOException, ServletException {

        UserDao userDao = new UserDaoImpl();
        companyDao compDao = new companyDaoImpl();

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String filename = "/assets/documents/company/" + "document1_" + student_id + "_" + internship_id + ".pdf";

        // Get the servlet context and build a pathname for the file
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filename);

        String MIME_TYPE = Utils.checkPDF(fileContent);

        // Check for the file type and upload the pdf
        if (MIME_TYPE == null || !MIME_TYPE.equals("pdf")) {
            request.getSession().setAttribute("errorMessage", "Please upload a valid pdf file");
            response.sendRedirect("/documents?action=iter&student_id="+student_id+"&internship_id="+internship_id);
        } else {
            OutputStream out = new FileOutputStream(pathname);
            Utils.copy(fileContent, out);

            // File uploaded correctly
            request.getSession().setAttribute("Message", "File uploaded successfully");
            response.sendRedirect("/documents?action=iter&student_id="+student_id+"&internship_id="+internship_id);
        }
    }

    // This method checks for the signed document uploaded by the administrator
    // If so, we enable the approve button on the page
    private boolean checkForDocumentation(int company_id) {

        boolean result = false;
        // Get the servlet context and build a pathname for the file
        String filePathString = "/assets/documents/admin/" + "company_" + company_id + ".pdf";
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filePathString);

        File f = new File(pathname);
        if(f.exists() && !f.isDirectory()) {
            result = true;
        }
        return result;
    }

    // Serve a signed document to the user
    private void action_view_signed_document(int real_id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (!checkForDocumentation(real_id)) {
            response.sendRedirect("/documents?action=companies");
            return;
        }
        String real_filename = "company_" + real_id + ".pdf";
        String filePathString = "/assets/documents/admin/" + real_filename;
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filePathString);

        File pdfFile = new File(pathname);

        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=" + real_filename);
        response.setContentLength((int) pdfFile.length());

        FileInputStream fileInputStream = new FileInputStream(pdfFile);
        OutputStream responseOutputStream = response.getOutputStream();
        int bytes;
        while ((bytes = fileInputStream.read()) != -1) {
            responseOutputStream.write(bytes);
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