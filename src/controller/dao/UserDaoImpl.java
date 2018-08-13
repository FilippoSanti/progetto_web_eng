
package controller.dao;

import controller.dao.config.DataSource;
import controller.utilities.Utils;
import model.Company;
import model.Notification;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * User queries
     */
    private static final String ADD_USER = "insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_NOTIFICATION = "insert into notifica values(?,?,?,?)";

    private static final String GET_USER_INFO = "SELECT * FROM studente WHERE email = ?";
    private static final String UPDATE_USER_INFO = "UPDATE studente SET nome = ?, date = ?, provincia = ?, provincia_nascita = ?, residenza = ?, citta = ?, CAP = ?, " +
            "telefono = ?, corso = ?, cognome = ?, cod_fiscale = ?, luogo_nascita = ? " +
            "WHERE studente.email = ?";
    private static final String UPDATE_USER_DATA = "UPDATE studente SET email = ?, password = ? WHERE studente.email = ?";
    private static final String RESET_PASSWORD_REQ = "INSERT INTO password_reset VALUES (?,?,?)";
    private static final String CHECK_EMAIl_RESET = "SELECT * FROM password_reset WHERE email = ?";
    private static final String GET_EXPIRATION_DATE = "SELECT expiration_date FROM password_reset WHERE token = ?";
    private static final String DELETE_RESET_REQUEST = "DELETE FROM password_reset WHERE token = ? ";
    private static final String CHECK_FOR_TOKEN = "SELECT * FROM password_reset WHERE token = ?";
    private static final String CHECK_EMAIL_USER = "SELECT * FROM studente WHERE email=?";
    private static final String GET_EMAIL_BY_TOKEN = "SELECT email FROM password_reset WHERE token = ?";
    private static final String GET_ID_BY_EMAIL = "SELECT email FROM studente WHERE studente_id = ?";
    private static final String GET_USER_LIST = "SELECT * FROM studente ORDER BY studente.studente_id DESC";
    private static final String CHECK_ADMIN = "SELECT * FROM studente WHERE email = ? AND ruolo = 'admin'";
    private static final String UPDATE_USER_EMAIL = "UPDATE studente SET email = ? WHERE studente.email = ?";
    private static final String DELETE_USER = "DELETE FROM studente WHERE studente.studente_id = ?";
    private static final String CANDIDATE = "insert into richieste_tirocinio values(?,?,?,?,?)";
    private static final String GET_EMAIL_BY_ID = "SELECT studente_id FROM studente WHERE email = ?";
    private static final String GET_ADMIN_LIST = "SELECT * FROM studente WHERE ruolo = 'admin'";
    private static final String GET_NOTIFICATIONS_LIST = "SELECT * FROM notifica WHERE id_utente = ?";

    /**
     * Get a user object by an email
     */
    public boolean candidate(int azienda_id,int offerta_tirocinio_id , int studente_id) throws ParseException {

        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(CANDIDATE);

            pst.setNull(1, Types.INTEGER);
            pst.setInt(2, azienda_id);
            pst.setInt(3, offerta_tirocinio_id);
            pst.setInt(4, studente_id);
            pst.setInt(5,0);


            int i = pst.executeUpdate();

            // Registration ok
            if (i > 0) {
                result = true;
            }

        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
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



    public User getUser(String userEmail) {

        User usr = new User();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_USER_INFO);

            pst.setString(1, userEmail);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {

                usr.setNome(rs.getString("nome"));
                usr.setCognome(rs.getString("cognome"));
                usr.setDate(rs.getString("date"));
                usr.setProvincia(rs.getString("provincia"));
                usr.setProvincia_n(rs.getString("provincia_nascita"));
                usr.setResidenza(rs.getString("residenza"));
                usr.setCitta(rs.getString("citta"));
                usr.setCorso(rs.getString("corso"));
                usr.setEmail(rs.getString("email"));
                usr.setHandicap(rs.getBoolean("handicap"));
                usr.setTel(rs.getString("telefono"));
                usr.setNome(rs.getString("nome"));
                usr.setCap(rs.getInt("cap"));
                usr.setCod_fiscale(rs.getString("cod_fiscale"));
                usr.setLuogo_nascita(rs.getString("luogo_nascita"));
                usr.setId(rs.getInt("studente_id"));
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

        return usr;
    }

    /**
     * Update the user informations
     */
    public boolean updateUserInfo(String nome, String date, String provincia, String provincia_nascita, String residenza, String citta,
                                  String cap, String telefono, String corso, String cognome, String cod_fiscale, String luogo_nascita,
                                  String userEmail) throws IOException {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(UPDATE_USER_INFO);

            pst.setString(1, userEmail);
            pst.setString(1, nome);
            pst.setString(2, date);
            pst.setString(3, provincia);
            pst.setString(4, provincia_nascita);
            pst.setString(5, residenza);
            pst.setString(6, citta);
            pst.setString(7, cap);
            pst.setString(8, telefono);
            pst.setString(9, corso);
            pst.setString(10, cognome);
            pst.setString(11, cod_fiscale);
            pst.setString(12, luogo_nascita);
            pst.setString(13, userEmail);
            int i = pst.executeUpdate();

            if (i > 0) {
                result = true;
            }

        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        } finally {
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

    /**
     * Update email and password of a user
     */
    public boolean updateUserData(String password, String email, String emailQuery) {

        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            // Check if we have the update only the email
            if (password.isEmpty()) {

                conn = DataSource.getInstance().getConnection();
                pst = conn.prepareStatement(UPDATE_USER_EMAIL);

                pst.setString(1, email);
                pst.setString(2, emailQuery);

                int i = pst.executeUpdate();

                if (i > 0) {
                    result = true;
                }
            } else {

                conn = DataSource.getInstance().getConnection();
                pst = conn.prepareStatement(UPDATE_USER_DATA);

                pst.setString(1, email);
                pst.setString(2, Utils.hashPassword(password));
                pst.setString(3, emailQuery);

                int i = pst.executeUpdate();

                if (i > 0) {
                    result = true;
                }
            }

        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
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

    /**
     * Check if the user is admin
     */
    public boolean checkAdmin(String userEmail) throws IOException, PropertyVetoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_ADMIN);

            ps.setString(1, userEmail);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
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
     * Query to register a user
     */
    public boolean addUser(String nome, String pass, String dateString, String provincia, String provincia_n, String residenza,
                           String citta, int capInt, String telefono, String corso, String email, boolean handicapBool,
                           String cognome, String cod_fiscale, String luogo_nascita) throws ParseException {

        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(ADD_USER);

            pst.setNull(1, Types.INTEGER);
            pst.setString(2, nome);
            pst.setString(3, Utils.hashPassword(pass));
            pst.setString(4, dateString);
            pst.setString(5, provincia);
            pst.setString(6, provincia_n);
            pst.setString(7, residenza);
            pst.setString(8, citta);
            pst.setInt(9, capInt);
            pst.setString(10, telefono);
            pst.setString(11, corso);
            pst.setString(12, email);
            pst.setBoolean(13, handicapBool);
            pst.setString(14, cognome);
            pst.setString(15, cod_fiscale);
            pst.setString(16, "user");
            pst.setString(17, luogo_nascita);

            int i = pst.executeUpdate();

            // Registration ok
            if (i > 0) {
                result = true;
            }

        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
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

    /**
     * Insert a password reset request in the database
     */
    public boolean insertPasswordResetRequest(String email, String token, java.util.Date expirationDate) {

        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(RESET_PASSWORD_REQ);

            pst.setString(1, email);
            pst.setString(2, token);
            pst.setTimestamp(3, new java.sql.Timestamp(expirationDate.getTime()));

            int i = pst.executeUpdate();

            // Registration ok
            if (i > 0) {
                result = true;
            }

        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
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

    /**
     * Check if the email in the reset table is unique
     */
    public boolean checkEmailReset(String emailString) throws PropertyVetoException, SQLException, IOException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_EMAIl_RESET);

            ps.setString(1, emailString);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
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
     * Get the expiration date
     */
    public java.util.Date getExpirationDate(String token) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        java.util.Date expiration_date = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_EXPIRATION_DATE);

            pst.setString(1, token);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {
                expiration_date = (rs.getTimestamp("expiration_date"));
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
        return expiration_date;
    }

    /**
     * Delete a reset request
     */
    public void deleteResetRequest(String token) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(DELETE_RESET_REQUEST);

        pst.setString(1, token);
        pst.executeUpdate();
        dbConnection.close();
    }

    /**
     * Find a user provided toke in the DB
     */
    public boolean checkForToken(String token) throws PropertyVetoException, SQLException, IOException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_FOR_TOKEN);

            ps.setString(1, token);
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

    /** Check if a user exists */
    public boolean checkUser(String email) throws IOException, PropertyVetoException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            ps = conn.prepareStatement(CHECK_EMAIL_USER);

            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (SQLException ex) {
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

    public String getEmailbyToken(String token) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String email = "";

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_EMAIL_BY_TOKEN);

            pst.setString(1, token);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {
                email = (rs.getString("email"));
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
        return email;
    }

    public String getEmailByID(int id) {

        String result = "";
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_ID_BY_EMAIL);

            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {

                result = rs.getString("email");
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

    public int getIDbyEmail(String email) {

        int result = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_EMAIL_BY_ID);

            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next() && rs != null) {

                result = rs.getInt("studente_id");
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

    public ArrayList<User> getUserList() {

        ArrayList<User> result = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_USER_LIST);
            rs = pst.executeQuery();

            while (rs.next()) {
                User usr = new User();

                usr.setNome(rs.getString("nome"));
                usr.setCognome(rs.getString("cognome"));
                usr.setDate(rs.getString("date"));
                usr.setProvincia(rs.getString("provincia"));
                usr.setProvincia_n(rs.getString("provincia_nascita"));
                usr.setResidenza(rs.getString("residenza"));
                usr.setCitta(rs.getString("citta"));
                usr.setCorso(rs.getString("corso"));
                usr.setEmail(rs.getString("email"));
                usr.setHandicap(rs.getBoolean("handicap"));
                usr.setTel(rs.getString("telefono"));
                usr.setNome(rs.getString("nome"));
                usr.setCap(rs.getInt("cap"));
                usr.setCod_fiscale(rs.getString("cod_fiscale"));
                usr.setLuogo_nascita(rs.getString("luogo_nascita"));
                usr.setId(rs.getInt("studente_id"));

                result.add(usr);
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

    public boolean deleteUser(int userID) throws SQLException, IOException, PropertyVetoException {

        boolean result = false;
        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement(DELETE_USER);

        pst.setInt(1, userID);
        int rows = pst.executeUpdate();

        if (rows > 0) {
            result = true;
        }
        dbConnection.close();
        return result;
    }

    /* User authentication */
    public boolean userAuth(String email, String password, String loginType) throws SQLException,PropertyVetoException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        companyDao cDao = new companyDaoImpl();
        PreparedStatement pst = null;
        boolean result = false;

        try {
            // Login as a student
            if (loginType.equals("studente")) {
                pst = dbConnection.prepareStatement("SELECT password FROM studente WHERE email = ?");
            }

            if (loginType.equals("azienda")) {
                pst = dbConnection.prepareStatement("SELECT password FROM azienda WHERE email_login = ?");
            }

            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                //Check if the provided password and the hashed one are equal
                if (Utils.checkPassword(password, rs.getString("password")))
                    result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dbConnection.close();
        return result;
    }

    public ArrayList<User> getAdminList() {

        ArrayList<User> result = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_ADMIN_LIST);
            rs = pst.executeQuery();

            while (rs.next()) {
                User usr = new User();

                usr.setNome(rs.getString("nome"));
                usr.setCognome(rs.getString("cognome"));
                usr.setDate(rs.getString("date"));
                usr.setProvincia(rs.getString("provincia"));
                usr.setProvincia_n(rs.getString("provincia_nascita"));
                usr.setResidenza(rs.getString("residenza"));
                usr.setCitta(rs.getString("citta"));
                usr.setCorso(rs.getString("corso"));
                usr.setEmail(rs.getString("email"));
                usr.setHandicap(rs.getBoolean("handicap"));
                usr.setTel(rs.getString("telefono"));
                usr.setNome(rs.getString("nome"));
                usr.setCap(rs.getInt("cap"));
                usr.setCod_fiscale(rs.getString("cod_fiscale"));
                usr.setLuogo_nascita(rs.getString("luogo_nascita"));
                usr.setId(rs.getInt("studente_id"));

                result.add(usr);
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

    public boolean addNotification (int userID, int companyID, String text) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean result = false;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(ADD_NOTIFICATION);

            pst.setNull(1, Types.INTEGER);
            pst.setInt(2, userID);
            pst.setInt(3, companyID);
            pst.setString(4, text);

            int i = pst.executeUpdate();

            // Registration ok
            if (i > 0) {
                result = true;
            }

        } catch (SQLException | PropertyVetoException | IOException e) {
            e.printStackTrace();
        } finally {
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

    public List<Notification> getNotificationList(int userID) {

        List<Notification> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(GET_NOTIFICATIONS_LIST);

            pst.setInt(1, userID);
            rs = pst.executeQuery();

            while (rs.next()) {
                Notification notif = new Notification();

                notif.setId_notifica(rs.getInt("id_notifica"));
                notif.setId_utente(rs.getInt("id_utente"));
                notif.setId_azienda(rs.getInt("id_azienda"));
                notif.setTesto(rs.getString("testo"));

                list.add(notif);
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
        return list;
    }

}