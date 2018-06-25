package controller;

import controller.core.userController;
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
        boolean sessionOK = userController.checkSession(request);

        // Check if the user is logged
        if (!sessionOK) {
            out.println("you can't access this page");

        } else {

            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();

            // Get the user object
            User userModel = (User) session.getAttribute("loggedInUser");

            // Now we check the userType
            if (userModel.getUserType().equals("studente")) {

                // Student functions

            } else if (userModel.getUserType().equals("azienda")) {

                // Company functions

            }

            out.println("Hello " + userModel.getEmail());

            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home_student.jsp");

            dispatcher.forward(request, response);
        }
    }


}