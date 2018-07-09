package controller.core;

import controller.utilities.DataSource;
import model.Company;
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
        }
        return usr;
    }

    public static boolean checkProfileImageByEmail(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ? AND profile_image = 'empty'");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            return false;
        }

        return true;
    }

}