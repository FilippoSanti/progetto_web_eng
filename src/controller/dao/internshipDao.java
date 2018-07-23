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

    public ArrayList<InternshipRequest> getListaCandidatibyTirocinioId(int tirocinio_id, int az_id) throws SQLException, IOException, PropertyVetoException;
    public boolean addInternship(int companyId, String nome, String descrizione, String luogo,
                                 String orari, String ore, String obiettivi, String modalita, String rimborsi_spese_facilitazioni_previste) throws SQLException, IOException, PropertyVetoException;

}
