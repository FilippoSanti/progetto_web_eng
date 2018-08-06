package controller.dao;

import model.Company;
import model.Internship;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * L'interfaccia DAO per le diverse implementazioni di CustomerDAO. Definisce le operazioni CRUD.
 */
public interface companyDao {

    public Company getCompanyDataByEmail(String userEmail) throws SQLException, IOException, PropertyVetoException;
    public boolean enableCompany(String company_login_email) throws SQLException, IOException, PropertyVetoException;
    public boolean insertInternship(Internship tirocinio) throws PropertyVetoException, SQLException, IOException;
    public boolean getCompanyInternships(String company_login_email) throws PropertyVetoException, SQLException, IOException;
    public boolean checkCompanyEnabled(String company_login_email) throws SQLException, IOException, PropertyVetoException;
    public boolean checkCompanyEmailExists(String emailComp) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException;
    public ArrayList<Company> getCompaniesList() throws SQLException, IOException, PropertyVetoException;
    public boolean updateCompanyField(String e, String r_s, String i_s_l, String cf, String p_i_r,
                                      String n_c_rapp, String n_c_tir, String t_t, String e_t, String f_c, String pr,
                                      boolean ab, String de, String targetUpdate) throws SQLException, IOException, PropertyVetoException;
    public void updateEmailAndPassword(String email, String password, String emailQuery) throws SQLException, IOException, PropertyVetoException;
    public boolean checkCompany(String email) throws IOException, PropertyVetoException;
    public int getCompanyIdbyEmail(String email) throws PropertyVetoException, SQLException, IOException;
    public boolean addUser(String email_login, String password, String ragione_sociale, String indirizzo_sede_leg,
                           String cf_rappresentante, String partita_iva_rap, String nome_cognome_rap, String nome_cognome_tir,
                           String telefono_tirocini, String email_tirocini, String foro_competente, String provincia) throws IOException, PropertyVetoException;

    public ArrayList<Company> getCompaniesToBeApproved() throws SQLException, IOException, PropertyVetoException;
    public String getEmailByID(int id);
    public boolean deleteCompany(int userID) throws SQLException, IOException, PropertyVetoException;
}