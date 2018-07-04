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
    public User getUserDataByID (int userID) throws PropertyVetoException, SQLException, IOException {

        User usr = new User();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE id = ?");

        pst.setInt(1, userID);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            usr.setNome(rs.getString("nome"));
            usr.setCognome(rs.getString("cognome"));
            usr.setDate(rs.getDate("date"));
            usr.setProvincia(rs.getString("provincia"));
            usr.setProvincia_n(rs.getString("provincia_n"));
            usr.setResidenza(rs.getString("residenza"));
            usr.setCitta(rs.getString("citta"));
            usr.setCorso(rs.getString("corso"));
            usr.setEmail(rs.getString("email"));
            usr.setHandicap(rs.getBoolean("handicap"));
            usr.setTel(rs.getString("tel"));
            usr.setNome(rs.getString("nome"));
            usr.setCap(rs.getInt("cap"));

        }
        return usr;
    }

}
