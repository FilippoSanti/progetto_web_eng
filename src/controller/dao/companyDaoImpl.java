package controller.dao;

import controller.dao.config.DataSource;
import controller.utilities.Utils;
import model.Company;
import model.Internship;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class companyDaoImpl implements companyDao {
    /**
     * User queries
     */
    private static final String GET_COMPANY_DATA = "SELECT * FROM azienda WHERE email_login = ?";
    private static final String INSERT_INTERNSHIP = "insert into offerta_tirocinio values(?,?,?,?,?,?,?)";
    private static final String GET_COMPANY_INTERNSHIPS = "SELECT * FROM studente WHERE email = ?";
    private static final String CHECK_COMPANY_ENABLED = "SELECT * FROM azienda WHERE email_login = ? AND abilitata = 1";
    private static final String ENABLE_COMPANY = "UPDATE azienda SET abilitata = '1' WHERE azienda.email_login = ?";
    private static final String CHECK_EM_EXISTS = "SELECT * FROM azienda WHERE email_login = ?";
    private static final String COMPANY_LIST = "SELECT * FROM azienda WHERE abilitata = 1 ORDER BY azienda.azienda_id ASC";
    private static final String UPDATE_COMPANY_DATA = "UPDATE azienda SET email_login = ?, password = ? WHERE azienda.email_login = ?";
    private static final String UPDATE_COMPANY_INFO = "UPDATE azienda\n" +
            "      SET `email_login` = ?, `ragione_sociale` = ?, `indirizzo_sede_legale` = ?, \n" +
            "      `cf_rappresentante` = ?, `partita_iva_rappresentante` = ?, `nome_cognome_rappresentante`= ?,\n" +
            "      `nome_cognome_tirocini`= ?, `telefono_tirocini` = ?, `email_tirocini`= ?, `foro_competente`= ?,\n" +
            "      `provincia`= ?, `abilitata`= ?, `descrizione` = ?\n" +
            "WHERE `azienda`.`email_login` = ?";
    private static final String CHECK_COMPANY_EMAIL = "SELECT * FROM azienda WHERE email_login=?";
    private static final String GET_ID_MAIL = "SELECT azienda_id FROM azienda WHERE email_login = ?";
    private static final String INSERT_USER = "insert into azienda values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_EMAIL_BY_ID = "SELECT email_login FROM azienda WHERE azienda_id = ?";

    /**
     * Get a company object by its login_email
     */
    public Company getCompanyDataByEmail(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        dbConnection = DataSource.getInstance().getConnection();
        pst = dbConnection.prepareStatement(GET_COMPANY_DATA);

        Company companyModel = new Company();

        pst.setString(1, userEmail);
        rs = pst.executeQuery();

        if (rs.next()) {
            companyModel.setCompany_id(rs.getInt("azienda_id"));
            companyModel.setEmail_login(rs.getString("email_login"));
            companyModel.setRagione_sociale(rs.getString("ragione_sociale"));
            companyModel.setIndirizzo_sede_leg(rs.getString("indirizzo_sede_legale"));
            companyModel.setCf_rappresentante(rs.getString("cf_rappresentante"));
            companyModel.setPartita_iva_rap(rs.getString("partita_iva_rappresentante"));
            companyModel.setNome_cognome_rap(rs.getString("nome_cognome_rappresentante"));
            companyModel.setNome_cognome_tir(rs.getString("nome_cognome_tirocini"));
            companyModel.setTelefono_tirocini(rs.getString("telefono_tirocini"));
            companyModel.setEmail_tirocini(rs.getString("email_tirocini"));
            companyModel.setForo_competente(rs.getString("foro_competente"));
            companyModel.setProvincia(rs.getString("provincia"));
            companyModel.setDescrizione(rs.getString("descrizione"));
        }

        dbConnection.close();
        return companyModel;
    }

    /**
     * Add tirocinio
     */
    public int getCompanyIdbyEmail(String email) throws PropertyVetoException, SQLException, IOException {

        Connection dbConnection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        dbConnection = DataSource.getInstance().getConnection();
        pst = dbConnection.prepareStatement(GET_ID_MAIL);

        int az_id = 0;

        pst.setString(1, email);
        rs = pst.executeQuery();

        if (rs.next()) {
            az_id = rs.getInt("azienda_id");

        }
        dbConnection.close();
        return az_id;
    }

    public boolean insertInternship(Internship tirocinio) throws PropertyVetoException, SQLException, IOException {

        Connection dbConnection = null;
        PreparedStatement pst = null;
        boolean result = false;

        dbConnection = DataSource.getInstance().getConnection();
        pst = dbConnection.prepareStatement(INSERT_INTERNSHIP);

        pst.setNull(1, Types.INTEGER);
        pst.setString(2, tirocinio.getLuogo());
        pst.setString(3, tirocinio.getOrari());
        pst.setString(4, tirocinio.getOre());
        pst.setString(5, tirocinio.getObiettivi());
        pst.setString(6, tirocinio.getModalita());
        pst.setString(7, tirocinio.getRimborsi_spese_facilitazioni_previste());

        int i = pst.executeUpdate();

        // Registration ok
        if (i > 0) {
            result = true;
        }

        dbConnection.close();
        return result;
    }

    /**
     * Get tirocinio
     */
    public boolean getCompanyInternships(String company_login_email) throws PropertyVetoException, SQLException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(GET_COMPANY_INTERNSHIPS);
        boolean result = false;

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            result = true;
        }
        dbConnection.close();
        return result;
    }

    /**
     * Check if company enabled
     */
    public boolean checkCompanyEnabled(String company_login_email) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(CHECK_COMPANY_ENABLED);
        boolean result = false;

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            result = true;
        }
        dbConnection.close();
        return result;
    }

    /**
     * Set a company to enabled
     */
    public boolean enableCompany(String company_login_email) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(ENABLE_COMPANY);
        boolean result = false;

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            result = true;
        }
        dbConnection.close();
        return result;
    }

    /**
     * Check if a company email exists
     */
    public boolean checkCompanyEmailExists(String emailComp) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_EM_EXISTS);

            ps.setString(1, emailComp);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            // Exception handling stuff
        } finally {
            try {
                rs.close();
            } catch (Exception e) { /* ignored */ }
            try {
                ps.close();
            } catch (Exception e) { /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) { /* ignored */ }
        }
        return result;
    }

    /**
     * Get the company list
     */
    public ArrayList<Company> getCompaniesList() throws SQLException, IOException, PropertyVetoException {
        ArrayList<Company> companiesList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(COMPANY_LIST);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Company company = new Company(
                    rs.getString("nome_cognome_tirocini"),
                    rs.getString("ragione_sociale"),
                    rs.getString("indirizzo_sede_legale"),
                    rs.getString("cf_rappresentante"),
                    rs.getString("partita_iva_rappresentante"),
                    rs.getString("nome_cognome_rappresentante"),
                    rs.getString("telefono_tirocini"),
                    rs.getString("email_tirocini"),
                    rs.getString("foro_competente"),
                    rs.getString("provincia"),
                    rs.getString("email_login"),
                    rs.getInt("azienda_id"),
                    rs.getString("descrizione")
            );
            companiesList.add(company);
        }

        dbConnection.close();
        return companiesList;
    }

    /**
     * Update the company info
     */
    public boolean updateCompanyField(String e, String r_s, String i_s_l, String cf, String p_i_r,
                                      String n_c_rapp, String n_c_tir, String t_t, String e_t, String f_c, String pr,
                                      boolean ab, String de, String targetUpdate) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStmt = dbConnection.prepareStatement(UPDATE_COMPANY_INFO);
        boolean result = false;

        preparedStmt.setString(1, e);
        preparedStmt.setString(2, r_s);
        preparedStmt.setString(3, i_s_l);
        preparedStmt.setString(4, cf);
        preparedStmt.setString(5, p_i_r);
        preparedStmt.setString(6, n_c_rapp);
        preparedStmt.setString(7, n_c_tir);
        preparedStmt.setString(8, t_t);
        preparedStmt.setString(9, e_t);
        preparedStmt.setString(10, f_c);
        preparedStmt.setString(11, pr);
        preparedStmt.setBoolean(12, ab);
        preparedStmt.setString(13, de);
        preparedStmt.setString(14, targetUpdate);

        int i = preparedStmt.executeUpdate();

        if (i > 0) {
            result = true;
        }

        dbConnection.close();

        return result;
    }

    /**
     * Update the company data
     **/
    public void updateEmailAndPassword(String email, String password, String emailQuery) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStmt = dbConnection.prepareStatement(UPDATE_COMPANY_DATA);

        preparedStmt.setString(1, email);
        preparedStmt.setString(2, Utils.hashPassword(password));
        preparedStmt.setString(3, emailQuery);

        preparedStmt.executeUpdate();
        dbConnection.close();

    }

    public boolean checkCompany(String email) throws IOException, PropertyVetoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_COMPANY_EMAIL);

            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
            // Exception handling stuff
        } finally {
            try {
                rs.close();
            } catch (Exception e) { /* ignored */ }
            try {
                ps.close();
            } catch (Exception e) { /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) { /* ignored */ }
        }
        return result;
    }

    public boolean addUser(String email_login, String password, String ragione_sociale, String indirizzo_sede_leg,
                           String cf_rappresentante, String partita_iva_rap, String nome_cognome_rap, String nome_cognome_tir,
                           String telefono_tirocini, String email_tirocini, String foro_competente, String provincia) throws IOException, PropertyVetoException {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(INSERT_USER);

            ps.setNull(1, Types.INTEGER);
            ps.setString(2, email_login);
            ps.setString(3, Utils.hashPassword(password));
            ps.setString(4, ragione_sociale);
            ps.setString(5, indirizzo_sede_leg);
            ps.setString(6, cf_rappresentante);
            ps.setString(7, partita_iva_rap);
            ps.setString(8, nome_cognome_rap);
            ps.setString(9, nome_cognome_tir);
            ps.setString(10, telefono_tirocini);
            ps.setString(11, email_tirocini);
            ps.setString(12, foro_competente);
            ps.setString(13, provincia);
            ps.setBoolean(14, false);
            ps.setString(15, "Description Sample");

            int i = ps.executeUpdate();

            if (i > 0) {
                result = true;
            }
        } catch (SQLException ex) {
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return result;
    }

    public String getEmailByID(int id) {

        String result = "";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_EMAIL_BY_ID);

            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {

                result = rs.getString("email_login");
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
}