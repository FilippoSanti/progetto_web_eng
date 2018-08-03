package controller.utilities;

import controller.dao.UserDao;
import controller.dao.UserDaoImpl;
import controller.servlets.homeServlet;
import controller.userController;
import model.Security;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class SecurityFilter {

    /** Checks for user session and permissions
     * to see if they are valid
     */
    public static model.Security checkUsers(HttpServletRequest request) throws PropertyVetoException, SQLException, IOException {

        model.Security securityModel = new Security("", "");
        UserDao uDao = new UserDaoImpl();

        // We first check if he sessions are valid
        if (userController.checkSession(request, "studente")) {

            // We add the user type in the securityModel
            securityModel.setUser("student");

            // Now we check if the student is also an admin
            if (uDao.checkAdmin(homeServlet.loggedUserEmail)) {
                securityModel.setRole("admin");
            } else {securityModel.setRole("user");}

        } else if (userController.checkSession(request, "azienda")) {

            securityModel.setUser("azienda");
            securityModel.setRole(null);

        } else {
            securityModel.setUser("anonymous");
            securityModel.setRole(null);
        }
        return securityModel;
    }
}