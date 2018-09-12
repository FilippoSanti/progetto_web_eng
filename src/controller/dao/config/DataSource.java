package controller.dao.config;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import controller.dao.UserDao;

public class DataSource extends DAOFactory {

    private static DataSource      datasource;
    private ComboPooledDataSource  cpds;

    public DataSource() throws IOException, SQLException, PropertyVetoException {

        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost/login");
        cpds.setUser("root");
        cpds.setPassword("eden777");

        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

    @Override
    public UserDao getCustomerDAO() {
        return null;
    }
}