package controller.servlets.general;

import controller.dao.*;
import controller.utilities.SecurityFilter;
import controller.utilities.Utils;
import model.*;

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
import java.util.ArrayList;
import java.util.List;

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
            if (internship_id_value != null &&student_id_value != null && action_value != null && type_value != null &&
                    action_value.equals("requestDocument1") && type_value.equals("student") &&
                    student_id_value.matches("[0-9]+") && internship_id_value.matches("[0-9]+")) {

                int real_student_id = Integer.valueOf(student_id_value);
                int real_internship_id = Integer.valueOf(internship_id_value);

                action_get_user_document(real_student_id, real_internship_id, response);
                return;
            }

            // Signed document upload
            if (action_value != null && type_value != null && internship_id_value != null &&
                    action_value.equals("upload") && type_value.equals("student") &&
                    internship_id_value.matches("[0-9]+")) {

                int internship_real = Integer.valueOf(internship_id_value);

                action_upload_student_document1(internship_real, request, response);
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

            // View the document1 signed by the user
            if (internship_id_value != null &&student_id_value != null && action_value != null && type_value != null &&
                    action_value.equals("requestDocument1") && type_value.equals("company") &&
                    student_id_value.matches("[0-9]+") && internship_id_value.matches("[0-9]+")) {

                int real_student_id = Integer.valueOf(student_id_value);
                int real_internship_id = Integer.valueOf(internship_id_value);
                action_company_get_document1_signedbystudent(real_student_id, real_internship_id, response);
                return;
            }
        }

        // View the document1 signed by the user
        if (internship_id_value != null &&student_id_value != null && action_value != null &&
                action_value.equals("requestDocument2") && student_id_value.matches("[0-9]+")
                && internship_id_value.matches("[0-9]+")) {

            int real_student_id = Integer.valueOf(student_id_value);
            int real_internship_id = Integer.valueOf(internship_id_value);

            action_view_document2(request, real_student_id, real_internship_id, response);
            return;
        }
    }

    private void action_view_document2(HttpServletRequest request, int real_student_id, int real_internship_id, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        Security securityModel = SecurityFilter.checkUsers(request);
        String resultString = null;

        if (securityModel.getUser().equals("anonymous")) {
            response.sendRedirect("/home");
            return;
        } else if (securityModel.getUser().equals("student") && securityModel.getRole().equals("user")) {
            securityCheckStudent(real_student_id, real_internship_id);
        } else if (securityModel.getUser().equals("azienda")) {
            companysecurityCheck(real_internship_id);
        }

        List<String> dataList = action_generate_document2(real_student_id, real_internship_id);
        request.setAttribute("dataList", dataList);

        if (Utils.checkFFUG(request)) {
            resultString = "/WEB-INF/views/document_2_alt.ftl";
        } else resultString = "/WEB-INF/views/document_2.ftl";

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher(resultString);

        dispatcher.forward(request, response);

    }

    private List<String> action_generate_document2(int real_student_id, int real_internship_id) throws PropertyVetoException, SQLException, IOException {

        UserDao uDao = new UserDaoImpl();
        internshipDao iDao = new internshipDaoImpl();
        companyDao cDao = new companyDaoImpl();

        String email = uDao.getEmailByID(real_student_id);
        User uModel = uDao.getUser(email);

        Internship iModel = iDao.getInternshipByID(real_internship_id);

        String company_email = cDao.getEmailByID(real_internship_id);
        Company cModel = cDao.getCompanyDataByEmail(company_email);

        InternshipRequest irModel = iDao.getInternshipRequestByIDs(real_internship_id, real_student_id);

        List<String> tempList = new ArrayList<>();

        tempList.add(cModel.getRagione_sociale());
        tempList.add(cModel.get_cf_iva());
        tempList.add(uModel.getCognome());
        tempList.add(uModel.getNome());
        tempList.add(iModel.getNome());
        tempList.add(uModel.getCorso());
        tempList.add(iModel.getMeseInziale());
        tempList.add(iModel.getMeseFinale());
        tempList.add(iModel.getOre());
        tempList.add(iModel.getLuogo());
        tempList.add(irModel.getAttivita_svolta());
        tempList.add(uModel.getNome());
        tempList.add(uModel.getCognome());
        tempList.add(irModel.getValutazione());

        return tempList;

    }

    /** Company functions below **/

    // Get the signed document from the student
    private void action_company_get_document1_signedbystudent(int student_id, int internship_id, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException {

        if (!companysecurityCheck(internship_id)){
            response.sendRedirect("documents?action=students");
            return;
        }

        String real_filename = "document1_" + student_id + "_" + internship_id + ".pdf";
        String filePathString = "/assets/documents/student/" + real_filename;
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

    // Check if a company can see the documents of an internship
    private boolean companysecurityCheck(int internship_id) throws PropertyVetoException, IOException, SQLException {

        boolean result = false;

        // Get the internship and check if our id is in the internship object
        internshipDao iDao = new internshipDaoImpl();
        companyDao cDao = new companyDaoImpl();

        int company_id = cDao.getCompanyIdbyEmail(homeServlet.loggedUserEmail);
        ArrayList<Internship> tempList = iDao.getInternshipListbyId(company_id);

        // Scan the list of internships of the company
        // And find out if the one we are trying to view is present
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getIternship_id() == internship_id) {
                result = true;
            }
        }
        return result;
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
            for (Part part : request.getParts()) {
                part.write(pathname);
                request.getSession().setAttribute("Message", "File uploaded successfully");
                response.sendRedirect("/documents?action=iter&student_id="+student_id+"&internship_id="+internship_id);
            }
        }
    }

    /** Student functions below **/

    // Download the company signed document
    private void action_get_user_document(int student_id, int internship_id, HttpServletResponse response) throws PropertyVetoException, IOException, SQLException, ServletException {

        // Check if the user is accessing his documents
        if (!securityCheckStudent(student_id, internship_id)) {
            response.sendRedirect("documents?action=iter&student_id="+ student_id + "&internship_id="+ internship_id);
            return;
        }

        String real_filename = "document1_" + student_id + "_" + internship_id + ".pdf";
        String filePathString = "/assets/documents/company/" + real_filename;
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

    // Check if a student can download an internship document
    private boolean securityCheckStudent(int student_id, int internship_id) {
        boolean result = false;

        // get every internship of a student
        internshipDao iDao = new internshipDaoImpl();
        List<InternshipRequest> iList = iDao.getMyInternships(student_id);

        // If the target internship is contained in the list
        // We can access the document download/visualization
        for (int i = 0; i < iList.size(); i++) {
            if (internship_id == iList.get(i).getInternship_id()) {
                result = true;
            }
        }
        return result;
    }

    // Upload the user's signed document
    private void action_upload_student_document1(int internship_id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserDao userDao = new UserDaoImpl();
        int current_user_id = userDao.getIDbyEmail(homeServlet.loggedUserEmail);

        // Check if the user is accessing his documents
        if (!securityCheckStudent(current_user_id, internship_id)) {
            response.sendRedirect("/documents?action=iter&student_id="+current_user_id +"&internship_id="+internship_id);
            return;
        }

        companyDao compDao = new companyDaoImpl();

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String filename = "/assets/documents/student/" + "document1_" +current_user_id + "_" +internship_id + ".pdf";

        // Get the servlet context and build a pathname for the file
        ServletContext context = getServletContext();
        String pathname = context.getRealPath(filename);

        String MIME_TYPE = Utils.checkPDF(fileContent);

        // Check for the file type and upload the pdf
        if (MIME_TYPE == null || MIME_TYPE.isEmpty() || !MIME_TYPE.equals("pdf")) {
            request.getSession().setAttribute("errorMessage", "Please upload a valid pdf file");
            response.sendRedirect("/documents?action=iter&student_id="+current_user_id +"&internship_id="+internship_id);
        } else {

            for (Part part : request.getParts()) {
                part.write(pathname);
                request.getSession().setAttribute("Message", "File uploaded successfully");
                response.sendRedirect("/documents?action=iter&student_id="+current_user_id +"&internship_id="+internship_id);
            }
        }
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
            response.sendRedirect("/viewDocumentation?type=company&id=" + company_id);
        } else {
            for (Part part : request.getParts()) {
                part.write(pathname);
                request.getSession().setAttribute("Message", "File uploaded successfully");
                response.sendRedirect("/viewDocumentation?type=company&id=" + company_id);
            }
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