package controller.dao;

import model.Company;
import model.Notification;
import model.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    /** Insert, Update, Delete functions */
    public boolean updateUserInfo(String nome, String date, String provincia, String provincia_nascita, String residenza, String citta,
                                  String cap, String telefono, String corso, String cognome, String cod_fiscale, String luogo_nascita,
                                  String userEmail) throws IOException;
    public boolean updateUserData(String password, String email, String emailQuery);
    public boolean addUser(String nome, String pass, String dateString, String provincia, String provincia_n, String residenza,
                           String citta, int capInt, String telefono, String corso, String email, boolean handicapBool,
                           String cognome, String cod_fiscale, String luogo_nascita) throws ParseException;
    public boolean insertPasswordResetRequest(String email, String token, java.util.Date expirationDate);
    public void deleteResetRequest(String token) throws SQLException, IOException, PropertyVetoException;
    public boolean deleteUser(int userID) throws SQLException, IOException, PropertyVetoException;
    public boolean userAuth(String email, String password, String loginType) throws SQLException,PropertyVetoException, IOException;
    public boolean addNotification (int userID, int companyID, String text);
    public boolean deleteNotification(int notification_id) throws SQLException, IOException, PropertyVetoException;
    public boolean clearNotifications(int userID) throws SQLException, IOException, PropertyVetoException;
    public boolean deleteCompanyNotifications(int id_company) throws SQLException, IOException, PropertyVetoException;
    public boolean candidate(int azienda_id,int offerta_tirocinio_id , int studente_id, String cfu, String tutor_name, String tutor_surname, String tutor_email, String valutazione) throws ParseException;

    /** Get functions */
    public User getUser(String userEmail);
    public String getEmailbyToken(String token);
    public String getEmailByID(int id);
    public java.util.Date getExpirationDate(String token);
    public ArrayList<User> getUserList() throws SQLException, IOException, PropertyVetoException;
    public List<Notification> getNotificationList(int userID);
    public ArrayList<User> getAdminList();
    public int getIDbyEmail(String email);
    public int getNotificationsCount(int userID) throws IOException, PropertyVetoException;
    public int getIDbyInternship_id(int inter_id);

    /** Check functions */
    public boolean checkForToken(String token) throws PropertyVetoException, SQLException, IOException;
    public boolean checkUser(String email) throws IOException, PropertyVetoException;
    public boolean checkAdmin(String userEmail) throws SQLException, IOException, PropertyVetoException;
    public boolean checkEmailReset(String emailString) throws PropertyVetoException, SQLException, IOException;
    public boolean checkInternshipUser(int user_id, int internship_id) throws IOException, PropertyVetoException;
    public boolean checkInternshipAccepted(int student_id, int internship_id);
}