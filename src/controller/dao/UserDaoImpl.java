
package controller.dao;

import controller.dao.config.DataSource;
import controller.utilities.Utils;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;

public class UserDaoImpl implements UserDao {

    /**
     * User queries
     */
    private static final String ADD_USER         = "insert into studente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_USER_INFO    = "SELECT * FROM studente WHERE email = ?";
    private static final String UPDATE_USER_INFO = "UPDATE studente SET nome = ?, date = ?, provincia = ?, provincia_nascita = ?, residenza = ?, citta = ?, CAP = ?, " +
            "telefono = ?, corso = ?, cognome = ?, cod_fiscale = ?, luogo_nascita = ? " +
            "WHERE studente.email = ?";
    private static final String UPDATE_USER_DATA = "UPDATE studente SET email = ?, password = ? WHERE studente.email = ?";

    /**
     * Get a user object by an email
     */
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                                  String userEmail) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(UPDATE_USER_INFO);

            pst.setString(1, userEmail);
            rs = pst.executeQuery();

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

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

        return false;
    }

    /**
     * Update email and password of a user
     */
    public boolean updateUserData(String password, String email, String emailQuery) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(UPDATE_USER_DATA);

            pst.setString(1, email);
            pst.setString(2, Utils.hashPassword(password));
            pst.setString(3, emailQuery);

            pst.executeUpdate();

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

        return false;
    }

    /**
     * Check if the user is admin
     */
    public boolean checkAdmin(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ? AND ruolo = 'admin'");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return false;
        }
        dbConnection.close();

        return true;
    }

    /**
     * Query to check if the email already is in the db
     */
    public boolean checkStudentEmailExists(String emailString) {

        Connection dbConnection = null;
        try {
            dbConnection = DataSource.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM studente WHERE email = ?";
        try (PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, emailString);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    /** Query to register a user */
    public boolean addUser(String nome, String pass, String dateString, String provincia, String provincia_n, String residenza,
                           String citta, int capInt, String telefono, String corso, String email, boolean handicapBool,
                           String cognome, String cod_fiscale, String luogo_nascita) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DataSource.getInstance().getConnection();
            pst = conn.prepareStatement(ADD_USER);

            pst.setNull(1, Types.INTEGER);
            pst.setString(2, nome);
            pst.setString(3, Utils.hashPassword(pass));
            pst.setDate(4, Utils.convertDate(dateString));
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
                return true;
            } else return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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
        return false;
    }
}