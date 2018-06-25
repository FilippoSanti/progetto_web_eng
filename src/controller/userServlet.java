package controller;

import controller.utilities.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class userServlet extends HttpServlet {


    // Aggiunta di un tirocinio
    protected void action_addTirocinio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, PropertyVetoException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String luogo = request.getParameter("luogo");
        String orari = request.getParameter("orari");
        String ore = request.getParameter("ore");
        String obiettivi = request.getParameter("obiettivi");
        String modalita = request.getParameter("modalita");
        String rimborsi_spese_facilitazioni_previste= request.getParameter("rimborsi_spese_facilitazioni_previste");

        try {

            // Conenct to the db pool
            Connection dbConnection = DataSource.getInstance().getConnection();

            PreparedStatement ps = dbConnection.prepareStatement
                    ("insert into offerta_tirocinio values(?,?,?,?,?,?,?)");

            // Prepare the query and execute it
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, luogo);
            ps.setString(3, orari);
            ps.setString(4, ore);
            ps.setString(5, obiettivi);
            ps.setString(6, modalita);
            ps.setString(7, rimborsi_spese_facilitazioni_previste);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.println("Tirocinio aggiunto dio merda finalmente");
            }

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, ClassNotFoundException, PropertyVetoException {



    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
            try {
                processRequest(request, response);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }

}