import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String pass = request.getParameter("pass");

        try {
            if (Utils.userAuth(username, pass)) {

                // Creating a session
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("Welcome");

            } else {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.html");
                rs.include(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}