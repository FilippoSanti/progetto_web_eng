import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        try {

            Connection conn = Utils.dbConnect();

            PreparedStatement ps=conn.prepareStatement
                    ("insert into user values(?,?)");

            ps.setString(1, name);

            // Insert the hashed password into the DB
            ps.setString(2, Utils.hashPassword(pass));
            int i = ps.executeUpdate();

            if(i > 0)
            {
                out.println("You are sucessfully registered");
            }

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

    }
}