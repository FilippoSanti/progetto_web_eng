package controller;

import controller.core.userController;
import model.Company;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class homeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Check if the user is logged
        if (userController.checkSession(request, "studente")) {

            // Get the user object
            User userModel = (User) session.getAttribute("loggedInUser");

            loadHomepage(request, response);
            System.out.println("Hello user");

        } else if (userController.checkSession(request, "azienda")) {
            Company companyModel = (Company) session.getAttribute("loggedInAZienda");

            loadHomepage(request, response);
            System.out.println("Hello azienda");
        }
    }

    public void loadHomepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_student.ftl");

        dispatcher.forward(request, response);
    }


}