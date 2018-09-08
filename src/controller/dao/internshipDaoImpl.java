package controller.dao;

import controller.dao.config.DataSource;
import model.Internship;
import model.InternshipRequest;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class internshipDaoImpl implements internshipDao {

    /**
     * User queries
     */
    private static final String GET_INTERN_LIST = "SELECT * FROM `offerta_tirocinio` ORDER BY `offerta_tirocinio`.`offerta_tirocinio_id` DESC";
    private static final String GET_INTERN_LIST_BY_ID = "SELECT * FROM offerta_tirocinio WHERE azienda_id = ? ORDER BY offerta_tirocinio.offerta_tirocinio_id ASC";
    private static final String GET_LISTA_CAND = "SELECT * FROM richieste_tirocinio WHERE offerta_tirocinio_id = ? && accettata = 0 ";
    private static final String GET_INTERNSHIP_DATA = "SELECT * FROM offerta_tirocinio WHERE offerta_tirocinio_id = ?";
    private static final String GET_LISTA_CAND2 = "SELECT * FROM richieste_tirocinio WHERE azienda_id = ? && accettata = 0 ";
    private static final String ENABLE_USER_INTERNSHIP_REQ = "UPDATE richieste_tirocinio SET accettata = '1' WHERE richieste_tirocinio.studente_id = ?";
    private static final String DELETE_USER_INTERNSHIP_REQ = "DELETE FROM richieste_tirocinio WHERE richieste_tirocinio.studente_id = ?";
    private static final String DELETE_INTERNSHIP = "DELETE FROM offerta_tirocinio WHERE offerta_tirocinio_id = ?";
    private static final String GET_MY_INTERNSHIPS = "SELECT * FROM richieste_tirocinio WHERE studente_id = ? && accettata = 1";
    private static final String GET_LISTA_CAND_APPR = "SELECT * FROM richieste_tirocinio WHERE azienda_id = ? && accettata = 1";
    private static final String GET_INTERNSHIP_REQUEST_DATA = "SELECT * FROM richieste_tirocinio WHERE offerta_tirocinio_id = ? && studente_id = ?";

    public boolean deleteInternship (int internship_id) throws PropertyVetoException, SQLException, IOException {
        boolean result = false;

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(DELETE_INTERNSHIP);

        pst.setInt(1, internship_id);
        int i = pst.executeUpdate();

        if(i > 0) {
            result = true;
        }

        dbConnection.close();
        return result;
    }


    public InternshipRequest getInternshipRequestByIDs(int internship_id, int student_id) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        dbConnection = DataSource.getInstance().getConnection();
        pst = dbConnection.prepareStatement(GET_INTERNSHIP_REQUEST_DATA);

        InternshipRequest internshipModel = new InternshipRequest();

        pst.setInt(1, internship_id);
        pst.setInt(2, student_id);
        rs = pst.executeQuery();

        if (rs.next()) {
            internshipModel.setInternship_request_id(rs.getInt("richiesta_tirocinio_id"));
            internshipModel.setAzienda_id(rs.getInt("azienda_id"));
            internshipModel.setInternship_id(rs.getInt("offerta_tirocinio_id"));
            internshipModel.setStudent_id(rs.getInt("studente_id"));
            internshipModel.setAccettata(rs.getBoolean("accettata"));
            internshipModel.setCfu(rs.getString("cfu"));
            internshipModel.setTutor_name(rs.getString("tutor_name"));
            internshipModel.setTutor_surname(rs.getString("tutor_surname"));
            internshipModel.setTutor_email(rs.getString("tutor_email"));


            dbConnection.close();


        }
        return internshipModel;
    }


    public Internship getInternshipDataById(int int_id) throws SQLException, IOException, PropertyVetoException{

            Connection dbConnection = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            dbConnection = DataSource.getInstance().getConnection();
            pst = dbConnection.prepareStatement(GET_INTERNSHIP_DATA);

            Internship internshipModel = new Internship();

            pst.setInt(1, int_id);
            rs = pst.executeQuery();

            if (rs.next()) {
                internshipModel.setIternship_id(rs.getInt("offerta_tirocinio_id"));
                internshipModel.setAzienda_id(rs.getInt("azienda_id"));
                internshipModel.setNome(rs.getString("nome"));
                internshipModel.setDettagli(rs.getString("dettagli"));
                internshipModel.setLuogo(rs.getString("luogo"));
                internshipModel.setMesi(rs.getString("mesi"));
                internshipModel.setOre(rs.getString("ore"));
                internshipModel.setOrari(rs.getString("orari"));
                internshipModel.setMeseInziale(rs.getString("mese_iniziale"));
                internshipModel.setMeseFinale(rs.getString("mese_finale"));
                internshipModel.setObiettivi(rs.getString("obiettivi"));
                internshipModel.setModalita(rs.getString("modalita"));
                internshipModel.setRimborsi_spese_facilitazioni_previste(rs.getString("rimborsi_spese_facilitazioni_previste"));
                internshipModel.setCompany_headquarters(rs.getBoolean("company_headquarters"));
                internshipModel.setRemote_connection(rs.getBoolean("remote_connection"));
                internshipModel.setRefound_of_expenses(rs.getBoolean("refound_of_expenses"));
                internshipModel.setCompany_refactory(rs.getBoolean("company_refactory"));
                internshipModel.setTraining_aid(rs.getBoolean("training_aid"));
                internshipModel.setNothing(rs.getBoolean("nothing"));
                internshipModel.setSettore(rs.getString("settore"));
            }

            dbConnection.close();
            return internshipModel;

    }

    public boolean enableInternshipRequest(int studente_id) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(ENABLE_USER_INTERNSHIP_REQ);

        pst.setInt(1, studente_id);
        pst.executeUpdate();

        dbConnection.close();
        return true;
    }

    public boolean deleteInternshipRequest(int studente_id) throws SQLException, IOException, PropertyVetoException {

        boolean result = false;

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(DELETE_USER_INTERNSHIP_REQ);

        pst.setInt(1, studente_id);
        int i = pst.executeUpdate();

        if(i > 0) {
            result = true;
        }

        dbConnection.close();
        return result;

    }

    public ArrayList<Internship> getInternshipList() throws SQLException, IOException, PropertyVetoException {
        ArrayList<Internship> internshipsList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_INTERN_LIST);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Internship internshipModel = new Internship();

            internshipModel.setIternship_id(rs.getInt("offerta_tirocinio_id"));
            internshipModel.setAzienda_id(rs.getInt("azienda_id"));
            internshipModel.setNome(rs.getString("nome"));
            internshipModel.setDettagli(rs.getString("dettagli"));
            internshipModel.setLuogo(rs.getString("luogo"));
            internshipModel.setMesi(rs.getString("mesi"));
            internshipModel.setOre(rs.getString("ore"));
            internshipModel.setOrari(rs.getString("orari"));
            internshipModel.setMeseInziale(rs.getString("mese_iniziale"));
            internshipModel.setMeseFinale(rs.getString("mese_finale"));
            internshipModel.setObiettivi(rs.getString("obiettivi"));
            internshipModel.setModalita(rs.getString("modalita"));
            internshipModel.setRimborsi_spese_facilitazioni_previste(rs.getString("rimborsi_spese_facilitazioni_previste"));
            internshipModel.setCompany_headquarters(rs.getBoolean("company_headquarters"));
            internshipModel.setRemote_connection(rs.getBoolean("remote_connection"));

            internshipsList.add(internshipModel);

        }
        dbConnection.close();
        return internshipsList;
    }

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
        dbConnection.close();
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
                        rs.getBoolean("accettata"),
                        rs.getString("cfu"),
                        rs.getString("tutor_name"),
                        rs.getString("tutor_surname"),
                        rs.getString("tutor_email")
                );

                candidates_list.add(internship_request);

            }

            dbConnection.close();
            return candidates_list;
        }

    public ArrayList<InternshipRequest> getCandidates_listbyTirocinioId(int tirocinio_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<InternshipRequest> candidates_list = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_LISTA_CAND);
        pst.setInt(1, tirocinio_id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            InternshipRequest internship_request = new InternshipRequest(
                    rs.getInt("richiesta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("studente_id"),
                    rs.getBoolean("accettata"),
                    rs.getString("cfu"),
                    rs.getString("tutor_name"),
                    rs.getString("tutor_surname"),
                    rs.getString("tutor_email")
            );

            candidates_list.add(internship_request);

        }

        dbConnection.close();
        return candidates_list;
    }

    public boolean addInternship(int companyId, String nome, String dettagli, String luogo, String mesi,
                                 String orari, String ore, String start_date, String end_date, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste,
                                 boolean company_headquarters, boolean remote_connection, boolean refound_of_expenses, boolean company_refactory, boolean training_aid, boolean nothing, String settore) throws SQLException, IOException, PropertyVetoException {
        boolean result = false;

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement ps = dbConnection.prepareStatement("insert into offerta_tirocinio values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


        ps.setNull(1, Types.INTEGER);
        ps.setInt(2, companyId);
        ps.setString(3, nome);
        ps.setString(4, dettagli);
        ps.setString(5, luogo);
        ps.setString(6, mesi);
        ps.setString(7, orari);
        ps.setString(8, ore);
        ps.setString(9, start_date);
        ps.setString(10, end_date);
        ps.setString(11, obiettivi);
        ps.setString(12, modalita);
        ps.setString(13, rimborsi_spese_facilitazioni_previste);
        ps.setBoolean(14, company_headquarters);
        ps.setBoolean(15, remote_connection);
        ps.setBoolean(16, refound_of_expenses);
        ps.setBoolean(17, company_refactory);
        ps.setBoolean(18, training_aid);
        ps.setBoolean(19, nothing);
        ps.setString(20, settore);

        int i = ps.executeUpdate();

        // Registration ok
        if (i > 0) {
            result = true;
        } else result = false;

        dbConnection.close();

        return result;
    }

    // Get the internships of a user
    public ArrayList<InternshipRequest> getMyInternships(int userID){

        ArrayList<InternshipRequest> result = new ArrayList<InternshipRequest>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_MY_INTERNSHIPS);
            pst.setInt(1, userID);
            rs = pst.executeQuery();

            while (rs.next()) {
                InternshipRequest intReq = new InternshipRequest();

                intReq.setInternship_request_id(rs.getInt("richiesta_tirocinio_id"));
                intReq.setAzienda_id(rs.getInt("azienda_id"));
                intReq.setStudent_id(rs.getInt("studente_id"));
                intReq.setAccettata(rs.getBoolean("accettata"));
                intReq.setInternship_id(rs.getInt("offerta_tirocinio_id"));

                result.add(intReq);
            }
        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                pst.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return result;
    }

    // Get a single internship from its id
    public Internship getInternshipByID(int internship_id) throws SQLException, IOException, PropertyVetoException {
        Connection dbConnection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        dbConnection = DataSource.getInstance().getConnection();
        pst = dbConnection.prepareStatement(GET_INTERNSHIP_DATA);

        Internship internshipModel = new Internship();

        pst.setInt(1, internship_id);
        rs = pst.executeQuery();

        if (rs.next()) {
            internshipModel.setIternship_id(rs.getInt("offerta_tirocinio_id"));
            internshipModel.setAzienda_id(rs.getInt("azienda_id"));
            internshipModel.setNome(rs.getString("nome"));
            internshipModel.setDettagli(rs.getString("dettagli"));
            internshipModel.setLuogo(rs.getString("luogo"));
            internshipModel.setMesi(rs.getString("mesi"));
            internshipModel.setOre(rs.getString("ore"));
            internshipModel.setOrari(rs.getString("orari"));
            internshipModel.setMeseInziale(rs.getString("mese_iniziale"));
            internshipModel.setMeseFinale(rs.getString("mese_finale"));
            internshipModel.setObiettivi(rs.getString("obiettivi"));
            internshipModel.setModalita(rs.getString("modalita"));
            internshipModel.setRimborsi_spese_facilitazioni_previste(rs.getString("rimborsi_spese_facilitazioni_previste"));
            internshipModel.setCompany_headquarters(rs.getBoolean("company_headquarters"));
            internshipModel.setRemote_connection(rs.getBoolean("remote_connection"));
            internshipModel.setRefound_of_expenses(rs.getBoolean("refound_of_expenses"));
            internshipModel.setCompany_refactory(rs.getBoolean("company_refactory"));
            internshipModel.setTraining_aid(rs.getBoolean("training_aid"));
            internshipModel.setNothing(rs.getBoolean("nothing"));
        }

        dbConnection.close();
        return internshipModel;
    }

    public ArrayList<InternshipRequest> getInternshipsStudents(int az_id) throws SQLException, IOException, PropertyVetoException{
        ArrayList<InternshipRequest> candidates_list = new ArrayList<>();
        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_LISTA_CAND_APPR);
        pst.setInt(1, az_id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            InternshipRequest internship_request = new InternshipRequest(
                    rs.getInt("richiesta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("studente_id"),
                    rs.getBoolean("accettata"),
                    rs.getString("cfu"),
                    rs.getString("tutor_name"),
                    rs.getString("tutor_surname"),
                    rs.getString("tutor_email")
            );
            candidates_list.add(internship_request);
        }
        dbConnection.close();
        return candidates_list;
    }

}