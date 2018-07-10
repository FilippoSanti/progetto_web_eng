package controller.core;

import controller.utilities.DataSource;
import model.Company;
import model.Internship;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class companyDAO {

    // Get a company object by its login_email
    public static Company getCompanyDataByEmail(String userEmail) throws SQLException, IOException, PropertyVetoException {

        Company companyModel = new Company();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ?");

        pst.setString(1, userEmail);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
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

    // Add tirocinio
    public static boolean insertInternship(Internship tirocinio) throws PropertyVetoException, SQLException, IOException {

        // Connect to DB
        Connection dbConnection = DataSource.getInstance().getConnection();

        PreparedStatement ps = dbConnection.prepareStatement
                ("insert into offerta_tirocinio values(?,?,?,?,?,?,?)");

        ps.setNull(1, Types.INTEGER);
        ps.setString(2, tirocinio.getLuogo());
        ps.setString(3, tirocinio.getOrari());
        ps.setString(4, tirocinio.getOre());
        ps.setString(5, tirocinio.getObiettivi());
        ps.setString(6, tirocinio.getModalita());
        ps.setString(7, tirocinio.getRimborsi_spese_facilitazioni_previste());

        int i = ps.executeUpdate();

        // Registration ok
        if (i > 0) {
            return true;
        }

        return false;
    }

    // Add tirocinio
    public static boolean getCompanyInternships(String company_login_email) throws PropertyVetoException, SQLException, IOException {

        List<String> supplierNames1 = new ArrayList<String>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM studente WHERE email = ?");

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

        }
        return false;
    }

    // Controlla che un azienda sia abilitata a pubblicare tirocini
    public static boolean checkCompanyEnabled(String company_login_email) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM azienda WHERE email_login = ? AND abilitata = 1 ");

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }

    // Setta azienda ad approvata
    public static boolean enableCompany(String company_login_email) throws SQLException, IOException, PropertyVetoException {

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("UPDATE azienda SET abilitata = '1' WHERE azienda.email_login = ? ");

        pst.setString(1, company_login_email);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }

    // Query to check if the email already is in the db
    public static boolean checkCompanyEmailExists(String emailComp) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();

        String query = "SELECT * FROM azienda WHERE email_login = ?";
        try (PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, emailComp);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
}