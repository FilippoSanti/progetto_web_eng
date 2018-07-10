package controller;

import controller.core.companyDAO;
import model.Internship;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) {
        Internship tirocinio = new Internship(1, "dio", "cane", "maldetto", "lol", "basta", "troppi");

        try {
            companyDAO.insertInternship(tirocinio);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
