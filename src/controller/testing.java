package controller;

import controller.dao.UserDaoImpl;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import controller.dao.UserDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class testing {

    public static void main(String[] args) throws PropertyVetoException, IOException, SQLException {

        UserDao usrDao = new UserDaoImpl();

        if (!usrDao.checkEmailReset("asf")) {

        }

    }

    public static void insertDate(java.util.Date jutil) {

        UserDao usrDao = new UserDaoImpl();

        usrDao.insertPasswordResetRequest("asf", "lol", jutil);

    }

    /** Check if the date is already expired */
    public static boolean checkDateValid(java.util.Date sqlDate) {

        // Date stored in the db
        DateTime dt = new DateTime(sqlDate);

        // Get the current date and check it
        // against the one that's in the db
        java.util.Date new_date = new Date();
        DateTime dt_2 = new DateTime(sqlDate);

        // If there are more than 5 minutes between the two dates, we return false
        return Minutes.minutesBetween(new DateTime(dt), new DateTime(dt_2))
                .isGreaterThan(Minutes.minutes(5));
    }
}
