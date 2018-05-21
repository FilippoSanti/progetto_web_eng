package controller;

import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

    public static  String  newLine     = System.getProperty("line.separator");
    final  static  String  DATE_FORMAT = "dd/MM/yyyy";

    /** DB Connection */
    public static Connection dbConnect() throws SQLException, ClassNotFoundException {

        // DB Connection
        // Loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //creating connection with the database
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost/login", "root", "eden777");

        return conn;
    }

    // Define the BCrypt workload to use when generating password hashes. 10-31 is a valid value.
    private static int workload = 12;

    /**
     * This method can be used to generate a string representing an account password
     * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
     * hash string of length=60
     * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
     * A workload of 12 is a very reasonable safe default as of 2013.
     * This automatically handles secure 128-bit salt generation and storage within the hash.
     *
     * @param password_plaintext The account's plaintext password as provided during account creation,
     *                           or when changing an account's password.
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */
    public static String hashPassword(String password_plaintext) {
        String salt = org.mindrot.jbcrypt.BCrypt.gensalt(workload);
        String hashed_password = org.mindrot.jbcrypt.BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    /**
     * This method can be used to verify a computed hash from a plaintext (e.g. during a login
     * request) with that of a stored hash from a database. The password hash from the database
     * must be passed as the second variable.
     *
     * @param password_plaintext The account's plaintext password, as provided during a login request
     * @param stored_hash        The account's stored password hash, retrieved from the authorization database
     * @return boolean - true if the password matches the password of the stored hash, false otherwise
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = org.mindrot.jbcrypt.BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

    /** Various checks for the registration process */
    public static Boolean checkRegistration(PrintWriter out, String n, String c, String p, String d, String pr, String pn, String r,
                                            String ci, String cap, String t, String co, String em, String mtt) throws SQLException, ClassNotFoundException {
        boolean result = true;

        // If every field is empty, we only tell the user to insert the requested values
        if (n.isEmpty() && c.isEmpty() && p.isEmpty() && d.isEmpty() && pr.isEmpty() &&
                r.isEmpty() && ci.isEmpty() && cap.isEmpty() && t.isEmpty() && co.isEmpty() &&
                em.isEmpty() && mtt.isEmpty() && pr.isEmpty()) {
            result = false;
            out.println("You must insert some data");
            return result;
        }

        // Then we check if the user already exists in the db
        if (checkEmailExists(em))       { result = false; out.println("A user with this email alreday exists"); return result;};

        // Check name
        if(checkEmpty(n))               { result = false; out.println(newLine + "Please insert a name"); }
        if (n.length() > 20)            { result = false; out.println(newLine +"The name is too long (15 characters max.)"); }

        // Check surname
        if(checkEmpty(c))               { result = false; out.println(newLine +"Please enter a surname");  }
        if(c.length() > 20)             { result = false; out.println(newLine +"The surname is too long"); }

        // Check password
        if(checkEmpty(p))               { result = false; out.println(newLine +"Please enter a password"); }
        if(p.length() < 8)              { result = false; out.println(newLine +"The password must be at lest 8 characters long"); }
        if(p.length() > 35)             { result = false; out.println(newLine +"The password is too long"); }

        //Check date
        if (!isDateValid(d))            { result = false; out.println(newLine +"Invalid date"); }
        if (d.length() != 10)           { result = false; out.println(newLine +"Enter a valid number of characters for the date"); }

        // Check email
        if (!isValidEmailAddress(em))   { result = false; out.println(newLine +"The email address is not valid"); }

        // Check provincia
        if(checkEmpty(pr))              { result = false; out.println(newLine +"Inserisci la provincia"); }
        if (pr.length() > 20)           { result = false; out.println(newLine +"La provincia è troppo lunga"); }

        // Check provincia_nascita
        if(checkEmpty(pn))              { result = false; out.println(newLine +"Inserisci la provincia di nascita"); }
        if (pn.length() > 20)           { result = false; out.println(newLine +"La provincia_nascita è troppo lunga"); }

        // Check residenza
        if(checkEmpty(r))               { result = false; out.println(newLine +"Inserisci la residenza"); }
        if (pr.length() > 20)           { result = false; out.println(newLine +"La provincia è troppo lunga"); }

        // Check citta
        if(checkEmpty(ci))              { result = false; out.println(newLine +"Inserisci la citta"); }
        if (ci.length() > 20)           { result = false; out.println(newLine +"Citta' too long"); }

        // Check telefono
        if(checkEmpty(t))               { result = false; out.println(newLine +"Inserisci il telefono"); }
        if (t.length() > 20)            { result = false; out.println(newLine +"Telefono too long");}
        if (!t.matches("[0-9]+")) { result = false; out.println(newLine + "The telephone must contain only numbers"); }

        // Check corso
        if(checkEmpty(co))              { result = false; out.println(newLine +"Inserisci il corso"); }
        if (co.length() > 20)           { result = false; out.println(newLine +"Corso too long"); }

        // Check email
        if (checkEmpty(em))               { result = false; out.println("Inserisci la mail");}
        if (em.length() > 60)             { result = false; out.println("Email too long");}

        // Check the cap string
        if (Utils.checkEmpty(cap))           { result = false; out.println(newLine +"Invalid CAP");}
        if (!cap.matches("[0-9]+"))    { result = false; out.println(newLine +"The CAP must contains only numbers"); }
        if (cap.length() > 5)                { result = false; out.println("The cap can't be more then 5 numbers");}

        // Check if the handicap string is empty
        if (!mtt.equals("si") && !mtt.equals("no") ) {result=false; out.println("The handicap must be si/no");}

        return result;

    }


    /* User authentication */
    public static boolean userAuth(String email, String password) throws SQLException, ClassNotFoundException {

        Connection conn = dbConnect();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT password FROM studente WHERE email = ?");
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                //Check if the provided password and the hashed one are equal
                if (checkPassword(password, rs.getString("password")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    // Returns a java.sql.Date type given a string
    public static java.sql.Date convertDate(String dateString) throws ParseException {

        java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    /** Method to check empty strings */
    public static boolean checkEmpty(String value){
        if(!(value==null))
            return value.isEmpty();

        return true;
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    // Date check function
    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Query to check if the email already is in the db
    public static boolean checkEmailExists(String emailString) throws SQLException, ClassNotFoundException {

        Connection dbConnection = dbConnect();

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
}