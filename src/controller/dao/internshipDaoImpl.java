package controller.dao;

import controller.dao.config.DataSource;
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
    private static final String REQUEST_INTERN = "UPDATE richieste_tirocinio SET accettata = '1' WHERE offerta_tirocinio_id = ?";
    private static final String GET_LISTA_CAND2 = "SELECT * FROM richieste_tirocinio WHERE azienda_id = ? && accettata = 0 ";
    /**
     * Get the internship list
     */
    public boolean request_internship(int internship_id) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(REQUEST_INTERN);

        pst.setInt(1, internship_id);
        pst.executeUpdate();

        dbConnection.close();
            return true;



    }


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
                    rs.getString("dettagli"),
                    rs.getString("luogo"),
                    rs.getString("mesi"),
                    rs.getString("orari"),
                    rs.getString("ore"),
                    rs.getString("mese_iniziale"),
                    rs.getString("mese_finale"),
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
                    rs.getString("dettagli"),
                    rs.getString("luogo"),
                    rs.getString("mesi"),
                    rs.getString("orari"),
                    rs.getString("ore"),
                    rs.getString("mese_iniziale"),
                    rs.getString("mese_finale"),
                    rs.getString("obiettivi"),
                    rs.getString("modalita"),
                    rs.getString("rimborsi_spese_facilitazioni_previste")
            );

            internshipsList.add(internship);

        }

        return internshipsList;
    }

    public ArrayList<InternshipRequest> getCandidates_list(int az_id) throws SQLException, IOException, PropertyVetoException{

            ArrayList<InternshipRequest> candidates_list = new ArrayList<>();

            Connection dbConnection = DataSource.getInstance().getConnection();
            PreparedStatement pst = dbConnection.prepareStatement(GET_LISTA_CAND2);
            pst.setInt(1, az_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                InternshipRequest internship_request = new InternshipRequest(
                        rs.getInt("richiesta_tirocinio_id"),
                        rs.getInt("azienda_id"),
                        rs.getInt("offerta_tirocinio_id"),
                        rs.getInt("studente_id"),
                        rs.getBoolean("accettata")
                );

                candidates_list.add(internship_request);

            }

            return candidates_list;
        }



    public ArrayList<InternshipRequest> getCandidates_listbyTirocinioId(int tirocinio_id, int az_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<InternshipRequest> candidates_list = new ArrayList<>();

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

            candidates_list.add(internship_request);

        }

        return candidates_list;
    }

    /**
     * Add a tirocinio
     */
    public boolean addInternship(int companyId, String nome, String dettagli, String luogo, String mesi,
                                 String orari, String ore, String meseIniziale, String meseFinale, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste,
                                 boolean company_headquarters, boolean remote_connection, boolean refound_of_expenses, boolean company_refactory, boolean training_aid, boolean nothing) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement ps = dbConnection.prepareStatement("insert into offerta_tirocinio values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");



        ps.setNull(1, Types.INTEGER);
        ps.setInt(2, companyId);
        ps.setString(3, nome);
        ps.setString(4, dettagli);
        ps.setString(5, luogo);
        ps.setString(6, mesi);
        ps.setString(7, orari);
        ps.setString(8, ore);
        ps.setString(9, meseIniziale);
        ps.setString(10, meseFinale);
        ps.setString(11, obiettivi);
        ps.setString(12, modalita);
        ps.setString(13, rimborsi_spese_facilitazioni_previste);
        ps.setBoolean(14, company_headquarters);
        ps.setBoolean(15, remote_connection);
        ps.setBoolean(16, refound_of_expenses);
        ps.setBoolean(17, company_refactory);
        ps.setBoolean(18, training_aid);
        ps.setBoolean(19, nothing);

        int i = ps.executeUpdate();

        // Registration ok
        if (i > 0) {
            return true;
        } else return false;

    }
}