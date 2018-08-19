package controller.dao;

import model.Internship;
import model.InternshipRequest;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface internshipDao {

    public ArrayList<Internship> getInternshipList() throws SQLException, IOException, PropertyVetoException;
    public ArrayList<Internship> getInternshipListbyId(int az_id) throws SQLException, IOException, PropertyVetoException;
    public boolean enableInternshipRequest(int studente_id) throws SQLException, IOException, PropertyVetoException;
    public ArrayList<InternshipRequest> getCandidates_listbyTirocinioId(int tirocinio_id, int az_id) throws SQLException, IOException, PropertyVetoException;
    public boolean addInternship(int companyId, String nome, String dettagli, String luogo, String mesi,
                                 String orari, String ore, String meseIniziale, String meseFinale, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste,
                                 boolean company_headquarters, boolean remote_connection, boolean refound_of_expenses, boolean company_refactory, boolean training_aid, boolean nothing) throws SQLException, IOException, PropertyVetoException;
    public ArrayList<InternshipRequest> getCandidates_list(int az_id) throws SQLException, IOException, PropertyVetoException;
    public boolean deleteInternshipRequest(int studente_id) throws SQLException, IOException, PropertyVetoException;

}
