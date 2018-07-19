package controller.dao;

import controller.dao.config.DataSource;
import controller.utilities.Utils;
import model.Internship;
import model.InternshipRequest;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class internshipDaoImpl implements internshipDao {

    /**
     * User queries
     */
    private static final String GET_INTERN_LIST = "SELECT * FROM offerta_tirocinio ORDER BY offerta_tirocinio.offerta_tirocinio_id ASC";
    private static final String GET_INTERN_LIST_BY_ID = "SELECT * FROM offerta_tirocinio WHERE azienda_id = ? ORDER BY offerta_tirocinio.offerta_tirocinio_id ASC";
    private static final String GET_LISTA_CAND = "SELECT * FROM richieste_tirocinio WHERE offerta_tirocinio_id = ? && azienda_id = ? && accettata = 0 ";

    /**
     * Get the internship list
     */
    public ArrayList<Internship> getInternshipList() throws SQLException, IOException, PropertyVetoException {
        ArrayList<Internship> internshipsList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_INTERN_LIST);

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

    /**
     * Get internlist by id
     */
    public ArrayList<Internship> getInternshipListbyId(int az_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<Internship> internshipsList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_INTERN_LIST_BY_ID);
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

    public ArrayList<InternshipRequest> getListaCandidatibyTirocinioId(int tirocinio_id, int az_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<InternshipRequest> listaCandidati = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_LISTA_CAND);
        pst.setInt(1, tirocinio_id);
        pst.setInt(2, az_id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            InternshipRequest internship_request = new InternshipRequest(
                    rs.getInt("richiesta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("studente_id"),
                    rs.getBoolean("accettata")
            );

            listaCandidati.add(internship_request);

        }

        return listaCandidati;
    }

    /**
     * Add a tirocinio
     */
    public boolean addInternship(int companyId, String nome, String descrizione, String luogo,
                                        String orari, String ore, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        PreparedStatement ps = conn.prepareStatement
                    ("insert into offerta_tirocinio values(?,?,?,?,?,?,?,?,?,?)");

        ps.setNull(1, Types.INTEGER);
        ps.setInt(2, companyId);
        ps.setString(3, nome);
        ps.setString(4, descrizione);
        ps.setString(5, luogo);
        ps.setString(6, orari);
        ps.setString(7, ore);
        ps.setString(8, obiettivi);
        ps.setString(9, modalita);
        ps.setString(10, rimborsi_spese_facilitazioni_previste);

        int i = ps.executeUpdate();

        // Registration ok
        if (i > 0) {
            return true;
        } else return false;

    }
}