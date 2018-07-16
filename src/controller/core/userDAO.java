package controller.core;

import controller.utilities.DataSource;
import controller.utilities.Utils;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {

    // Get the user data from DB
    public static User getUserDataByEmail (String userEmail) throws PropertyVetoException, SQLException, IOException {

        User usr = new User();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ?");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
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

        dbConnection.close();
        return usr;
    }

    public static boolean checkProfileImage(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ? AND profile_image = 'empty'");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            return false;
        }
        dbConnection.close();

        return true;
    }

    // Check if a user is admin
    public static boolean checkAdmin(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ? AND ruolo = 'admin'");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            return false;
        }
        dbConnection.close();

        return true;
    }

    // Query to check if the email already is in the db
    public static boolean checkStudentEmailExists(String emailString) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();

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

    public static int getIDbyEmail(String emailString) throws SQLException, IOException, PropertyVetoException {

        int userID = 0;

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ?");

        pst.setString(1, emailString);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            userID= rs.getInt("studente_id");
        }
        dbConnection.close();

        return userID;
    }


    public static void updateUserFields(String nome, String date, String provincia, String provincia_nascita, String residenza, String citta,
                                        String cap, String telefono, String corso, String cognome, String cod_fiscale, String luogo_nascita,
                                        String emailQuery) throws PropertyVetoException, SQLException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();

        String qualcosa = "UPDATE studente SET nome = ?, date = ?, provincia = ?, provincia_nascita = ?, residenza = ?, citta = ?, CAP = ?, " +
                "telefono = ?, corso = ?, cognome = ?, cod_fiscale = ?, luogo_nascita = ? " +
                "WHERE studente.email = ?";

        PreparedStatement preparedStmt = dbConnection.prepareStatement(qualcosa);

        preparedStmt.setString(1, nome);
        preparedStmt.setString(2, date);
        preparedStmt.setString(3, provincia);
        preparedStmt.setString(4, provincia_nascita);
        preparedStmt.setString(5, residenza);
        preparedStmt.setString(6, citta);
        preparedStmt.setString(7, cap);
        preparedStmt.setString(8, telefono);
        preparedStmt.setString(9, corso);
        preparedStmt.setString(10, cognome);
        preparedStmt.setString(11, cod_fiscale);
        preparedStmt.setString(12, luogo_nascita);
        preparedStmt.setString(13, emailQuery);

        preparedStmt.executeUpdate();
        dbConnection.close();

    }

    // Update the user email and password
    public static void updateEmailAndPassword(String password, String email, String emailQuery) throws SQLException, IOException, PropertyVetoException {

        String updateQuery = "UPDATE studente SET email = ?, password = ? WHERE studente.email = ?";

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStmt = dbConnection.prepareStatement(updateQuery);

        preparedStmt.setString(1, email);
        preparedStmt.setString(2, Utils.hashPassword(password));
        preparedStmt.setString(3, emailQuery);

        preparedStmt.executeUpdate();
        dbConnection.close();

    }
}