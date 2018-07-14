package controller.core;

import controller.utilities.DataSource;
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
            usr.setDate(rs.getDate("date"));
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

    public static void updateStudentField(String field, String field_text, String email_login) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();

        PreparedStatement preparedStmt = dbConnection.prepareStatement("UPDATE studente \n" +
                "SET nome = ?, password = ?, date = ?, provincia = ?, provincia_nascita = ?, residenza = ?, citta = ?, CAP = ?, telefono = ?, corso = ?, email = ?, handicap = ?, cognome = ?, cod_fiscale = ?, ruolo = ?, luogo_nascita = ?  \n" +
                "WHERE studente.email = 'mikesh07mail@gmail.com';");
        preparedStmt.setString(1, field);
        preparedStmt.setString(2, field_text);
        preparedStmt.setString(3,email_login);

        preparedStmt.executeUpdate();
        dbConnection.close();

    }
}