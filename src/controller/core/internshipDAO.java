package controller.core;

import controller.utilities.DataSource;
import model.Company;
import model.Internship;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class internshipDAO {

    public static ArrayList<Internship> getInternshipList() throws SQLException, IOException, PropertyVetoException {
        ArrayList<Internship> internshipsList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM offerta_tirocinio ORDER BY offerta_tirocinio.offerta_tirocinio_id ASC ");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Internship internship = new Internship(
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getString("nome"),
                    rs.getString("descrizione"),
                    rs.getString("luogo"),
                    rs.getString("orari"),
                    rs.getString("ore"),
                    rs.getString("obiettivi"),
                    rs.getString("modalita"),
                    rs.getString("rimborsi_spese_facilitazioni_previste")
            );

            internshipsList.add(internship);

        }

        return internshipsList;


    }

    public static ArrayList<Internship> getInternshipListbyId(int az_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<Internship> internshipsList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM offerta_tirocinio WHERE azienda_id = ? ORDER BY offerta_tirocinio.offerta_tirocinio_id ASC ");
        pst.setInt(1, az_id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Internship internship = new Internship(
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getString("nome"),
                    rs.getString("descrizione"),
                    rs.getString("luogo"),
                    rs.getString("orari"),
                    rs.getString("ore"),
                    rs.getString("obiettivi"),
                    rs.getString("modalita"),
                    rs.getString("rimborsi_spese_facilitazioni_previste")
            );

            internshipsList.add(internship);

        }

        return internshipsList;
    }
}

