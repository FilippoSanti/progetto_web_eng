package controller;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        // Check if the user is logged
        if (!controller.utilities.Utils.checkSession(request)) {
            out.println("you can't access this page");

        } else {

            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();

            // Get the user object to display informations
            User userModel = (User) session.getAttribute("loggedInUser");
            out.println("Hello " + userModel.getEmail());
        }
    }

}