package controller.dao.config;

import controller.dao.UserDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public abstract class DAOFactory {

    public static final int MYSQL = 0;

    public abstract UserDao getCustomerDAO();

    /**
     * Metodo Factory
     *
     * @param database il database da scegliere
     * @return la factory corrispondente
     */
    public static DAOFactory getDAOFactory(int database) throws PropertyVetoException, SQLException, IOException {
        switch (database) {
            case MYSQL:
                return new DataSource();
            default:
                return null;
        }
    }
}