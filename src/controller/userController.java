package controller;

import controller.utilities.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userController {

    public static  String  newLine = System.getProperty("line.separator");

    /** Various checks for the registration process */
    public static Boolean checkRegistration(PrintWriter out, String n, String c, String p, String rp, String d, String pr, String pn, String r,
                                            String ci, String cap, String t, String co, String em, String cod_fiscale) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {
        boolean result = true;

        // If every field is empty, we only tell the user to insert the requested values
        if (n.isEmpty() && c.isEmpty() && p.isEmpty() && d.isEmpty() && r.isEmpty()
                && ci.isEmpty() && cap.isEmpty() && t.isEmpty() && co.isEmpty() &&
                em.isEmpty()) {
            result = false;
            out.println("You must insert some data");
            return result;
        }

        // Then we check if the user already exists in the db
        if (checkEmailExists(em))       { result = false; out.println("A user with this email alreday exists"); return result;};

        // Check name
        if(Utils.checkEmpty(n))               { result = false; out.println(newLine + "Please insert a name"); }
        if (n.length() > 20)            { result = false; out.println(newLine +"The name is too long (15 characters max.)"); }

        // Check surname
        if(Utils.checkEmpty(c))               { result = false; out.println(newLine +"Please enter a surname");  }
        if(c.length() > 20)             { result = false; out.println(newLine +"The surname is too long"); }

        // Check password
        if(Utils.checkEmpty(p))               { result = false; out.println(newLine +"Please enter a password"); }
        if(!p.equals(rp))               {result = false; out.println("The passwords you entered are not equal"); }
        if(p.length() < 8)              { result = false; out.println(newLine +"The password must be at lest 8 characters long"); }
        if(p.length() > 35)             { result = false; out.println(newLine +"The password is too long"); }

        //Check date
        if (!Utils.isDateValid(d))            { result = false; out.println(newLine +"Invalid date"); }
        if (d.length() != 10)           { result = false; out.println(newLine +"Enter a valid number of characters for the date"); }

        // Check email
        if (!Utils.isValidEmailAddress(em))   { result = false; out.println(newLine +"The email address is not valid"); }

        // Check residenza
        if(Utils.checkEmpty(r))               { result = false; out.println(newLine +"Inserisci la residenza"); }
        if (pr.length() > 20)           { result = false; out.println(newLine +"La provincia è troppo lunga"); }

        // Check citta
        if(Utils.checkEmpty(ci))              { result = false; out.println(newLine +"Inserisci la citta"); }
        if (ci.length() > 20)           { result = false; out.println(newLine +"Citta' too long"); }

        // Check telefono
        if(Utils.checkEmpty(t))               { result = false; out.println(newLine +"Inserisci il telefono"); }
        if (t.length() > 20)            { result = false; out.println(newLine +"Telefono too long");}
        if (!t.matches("[0-9]+")) { result = false; out.println(newLine + "The telephone must contain only numbers"); }

        // Check corso
        if(Utils.checkEmpty(co))              { result = false; out.println(newLine +"Inserisci il corso"); }
        if (co.length() > 20)           { result = false; out.println(newLine +"Corso too long"); }

        // Check email
        if (Utils.checkEmpty(em))               { result = false; out.println("Inserisci la mail");}
        if (em.length() > 60)             { result = false; out.println("Email too long");}

        // Check the cap string
        if (Utils.checkEmpty(cap))           { result = false; out.println(newLine +"Invalid CAP");}
        if (!cap.matches("[0-9]+"))    { result = false; out.println(newLine +"The CAP must contains only numbers"); }
        if (cap.length() > 5)                { result = false; out.println("The cap can't be more then 5 numbers");}

        if (Utils.checkEmpty(cod_fiscale)) { result = false; out.println("The codice fiscale(non so come cazzo si dice) cannot be empty"); }
        if (cod_fiscale.length() < 3) {result = false; out.println("The cod fiscale must be at least x characters");}

        return result;

    }

    /* User authentication */
    public static boolean userAuth(String email, String password) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();

        try {
            PreparedStatement pst = dbConnection.prepareStatement("SELECT password FROM studente WHERE email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                //Check if the provided password and the hashed one are equal
                if (Utils.checkPassword(password, rs.getString("password")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    // Query to check if the email already is in the db
    public static boolean checkEmailExists(String emailString) throws SQLException, ClassNotFoundException, PropertyVetoException, IOException {

        Connection dbConnection = DataSource.getInstance().getConnection();

        String query = "SELECT * FROM studente WHERE email = ?";
        try (PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, emailString);
            try( ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch(SQLException se) {
            se.printStackTrace();
            return false;
        }
    }

    // Check if the user is logged
    public static boolean checkSession (HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            return false;
        } else {
            return true;
        }
    }
}
