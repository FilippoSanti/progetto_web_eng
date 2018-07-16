package controller.core;

import controller.utilities.DataSource;
import controller.utilities.Utils;
import model.Company;
import model.Internship;

import javax.servlet.http.HttpServletRequest;
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
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM azienda WHERE email_login = ?");

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

        dbConnection.close();
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
        dbConnection.close();
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
        dbConnection.close();
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
        dbConnection.close();
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

    public static ArrayList<Company> getCompaniesList() throws SQLException, IOException, PropertyVetoException {
        ArrayList<Company> companiesList = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM azienda WHERE abilitata = 0 ORDER BY azienda.azienda_id ASC ");

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

    public static boolean updateCompanyField(String e, String r_s, String i_s_l, String cf, String p_i_r,
                                          String n_c_rapp, String n_c_tir, String t_t, String e_t, String f_c, String pr,
                                          boolean ab, String de, String targetUpdate) throws SQLException, IOException, PropertyVetoException {

        String updateQuery = "UPDATE azienda\n" +
                    "      SET `email_login` = ?, `ragione_sociale` = ?, `indirizzo_sede_legale` = ?, \n" +
                    "      `cf_rappresentante` = ?, `partita_iva_rappresentante` = ?, `nome_cognome_rappresentante`= ?,\n" +
                    "      `nome_cognome_tirocini`= ?, `telefono_tirocini` = ?, `email_tirocini`= ?, `foro_competente`= ?,\n" +
                    "      `provincia`= ?, `abilitata`= ?, `descrizione` = ?\n" +
                    "WHERE `azienda`.`email_login` = ?";

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStmt = dbConnection.prepareStatement(updateQuery);

        preparedStmt.setString(1, e);
        preparedStmt.setString(2, r_s);
        preparedStmt.setString(3, i_s_l);
        preparedStmt.setString(4, cf);
        preparedStmt.setString(5,p_i_r);
        preparedStmt.setString(6, n_c_rapp);
        preparedStmt.setString(7, n_c_tir);
        preparedStmt.setString(8, t_t);
        preparedStmt.setString(9, e_t);
        preparedStmt.setString(10, f_c);
        preparedStmt.setString(11,pr);
        preparedStmt.setBoolean(12, ab);
        preparedStmt.setString(13, de);
        preparedStmt.setString(14, targetUpdate);

        preparedStmt.executeUpdate();
        dbConnection.close();

        return true;
    }


    public static void updateEmailAndPassword(String email, String password, String emailQuery) throws SQLException, IOException, PropertyVetoException {

        String updateQuery = "UPDATE azienda SET email_login = ?, password = ? WHERE azienda.email_login = ?";

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement preparedStmt = dbConnection.prepareStatement(updateQuery);

        preparedStmt.setString(1, email);
        preparedStmt.setString(2, Utils.hashPassword(password));
        preparedStmt.setString(3, emailQuery);

        preparedStmt.executeUpdate();

    }

    public static int getCompanyIDbyEmail(String emailString) throws SQLException, IOException, PropertyVetoException {

        int aziendaID = 0;

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM azienda WHERE email_login = ?");

        pst.setString(1, emailString);
        ResultSet rs = pst.executeQuery();

        if(rs.next()) {
            aziendaID= rs.getInt("azienda_id");
        }

        return aziendaID;
    }
}

