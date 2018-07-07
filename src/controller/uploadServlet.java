package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class uploadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getServletContext().getRequestDispatcher("/WEB-INF/views/upload.ftl");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {

        // Retrieves <input type="text" name="description">
        String description = request.getParameter("description");

        // Retrieves <input type="file" name="file">
        Part filePart = request.getPart("file");

        // MSIE fix.
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        ServletContext context = getServletContext();

        String filename = "/WEB-INF/user_images/2.png";
        String pathname = context.getRealPath(filename);

        controller.utilities.Utils.scale_img(fileContent, pathname);

    }

}