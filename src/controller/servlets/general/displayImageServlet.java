package controller.servlets.general;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.dao.companyDao;
import controller.dao.companyDaoImpl;
import controller.utilities.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.*;
import java.sql.SQLException;

public class displayImageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PropertyVetoException, SQLException {

        // URL Parameters
        String id = "id";
        String type = "type";

        String idValue = request.getParameter(id);
        String typevalue = request.getParameter(type);

        // View the profile picture of a user
        if (typevalue != null && idValue != null && idValue.matches("[0-9]+")) {

            int real_id = Integer.parseInt(idValue);
            displayImageByID(request, response, typevalue, real_id);
            return;
        }

        displayImage(request, response);
    }

    // Display the image of the current user
    private void displayImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        String filename = null;
        try {
            filename = Utils.display_user_image(context, request, homeServlet.loggedUserEmail);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("image/jpeg"); //as far as I know, this works for PNG as well. You might want to change the mapping to /images/*.jpg if it's giving problems

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(filename);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch = 0;

        while ((ch = bin.read()) != -1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();
    }

    // Display the image of a target user
    private void displayImageByID(HttpServletRequest request, HttpServletResponse response, String userType, int userID) throws IOException {

        // Email of the target user
        String email = null;

        if (userType.equals("company")) {
            companyDao cDao = new companyDaoImpl();
            email = cDao.getEmailByID(userID);

        } else if (userType.equals("student")) {
            UserDao uDao = new UserDaoImpl();
            email = uDao.getEmailByID(userID);
        } else return;

        ServletContext context = getServletContext();
        String filename = null;
        try {
            filename = Utils.display_user_image(context, request, email);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        response.setContentType("image/jpeg"); //as far as I know, this works for PNG as well. You might want to change the mapping to /images/*.jpg if it's giving problems

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(filename);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch = 0;

        while ((ch = bin.read()) != -1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();

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
}