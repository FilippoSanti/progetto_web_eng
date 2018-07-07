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

    // Get a company object by its login_email
    public static Company getCompanyDataByEmail(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Company companyModel = new Company();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ?");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            companyModel.setCompany_id(rs.getInt("azienda_id"));
            companyModel.setEmail_login(rs.getString("email_login"));
            companyModel.setRagione_sociale(rs.getString("ragione_sociale"));
            companyModel.setIndirizzo_sede_leg(rs.getString("indirizzo_sede_legale"));
            companyModel.setCf_rappresentante(rs.getString("cf_rappresentante"));
            companyModel.setPartita_iva_rap(rs.getString("partita_iva_rappresentante"));
            companyModel.setNome_cognome_rap(rs.getString("nome_cognome_rappresentante"));
            companyModel.setNome_cognome_tir(rs.getString(rs.getString("nome_cognome_tir")));
            companyModel.setTelefono_tirocini(rs.getString("telefono_tirocini"));
            companyModel.setEmail_tirocini(rs.getString("email_tirocini"));
            companyModel.setForo_competente("foro_competente");
            companyModel.setProvincia("provincia");
        }
        return companyModel;
    }

}