package controller.utilities;

import controller.core.userController;
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

        // We first check if he sessions are valid
        if (userController.checkSession(request, "studente")) {

            // We add the user type in the securityModel
            securityModel.setUser("student");

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