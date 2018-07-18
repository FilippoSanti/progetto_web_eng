package controller.core;

import controller.utilities.DataSource;
import model.Internship;
import model.InternshipRequest;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class internship_requestDAO {

    public static ArrayList<InternshipRequest> getListaCandidatibyTirocinioId(int tirocinio_id, int az_id) throws SQLException, IOException, PropertyVetoException {
        ArrayList<InternshipRequest> listaCandidati = new ArrayList<>();

        Connection dbConnection = DataSource.getInstance().getConnection();
        PreparedStatement pst = dbConnection.prepareStatement("SELECT * FROM richieste_tirocinio WHERE offerta_tirocinio_id = ? && azienda_id = ? && accettata = 0 ");
        pst.setInt(1, tirocinio_id);
        pst.setInt(2, az_id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            InternshipRequest internship_request = new InternshipRequest(
                    rs.getInt("richiesta_tirocinio_id"),
                    rs.getInt("azienda_id"),
                    rs.getInt("offerta_tirocinio_id"),
                    rs.getInt("studente_id"),
                    rs.getBoolean("accettata")
            );

            listaCandidati.add(internship_request);

        }

        return listaCandidati;
    }
}

