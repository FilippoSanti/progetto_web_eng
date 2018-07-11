package controller;

import controller.core.companyDAO;
import controller.core.userController;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import controller.core.userDAO;
import controller.homeServlet;
import model.Company;
import model.User;

@WebServlet("/upload")
@MultipartConfig(location="", fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class uploadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/upload.ftl");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        ServletContext context = getServletContext();

        String userID = null;

        // Check if we are generating the image as a user or a company
        String userType = null;
        if (userController.checkSession(request,"studente")) {
            userType = "student";
        } else if (userController.checkSession(request, "azienda")) {
            userType = "azienda";
        }

        String pathname = null;

        if (userType.equals("student")) {

            try {
                User user = userDAO.getUserDataByEmail(homeServlet.loggedUserEmail);
                userID = String.valueOf(user.getId());

            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String filename = "/assets/images/users/"+ "user_"+userID+".png";
            pathname = context.getRealPath(filename);

        } else {

            try {
                Company company = companyDAO.getCompanyDataByEmail(homeServlet.loggedUserEmail);
                userID = String.valueOf(company.getCompany_id());

            } catch (PropertyVetoException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String filename = "/assets/images/users/"+ "company_"+userID+".png";
            pathname = context.getRealPath(filename);

        }

        // TODO: check if we have to resize the image
        controller.utilities.Utils.scale_img(fileContent, pathname);

    }

}