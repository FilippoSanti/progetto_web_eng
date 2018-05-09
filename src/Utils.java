import java.sql.*;

public class Utils {

    // Connect to the DB
    public static Connection dbConnect() throws SQLException, ClassNotFoundException {

        // DB Connection
        // Loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //creating connection with the database
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost/login", "root", "pass");

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


    /* User authentication */
    public static boolean userAuth(String username, String password) throws SQLException, ClassNotFoundException {

        Connection conn = dbConnect();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT password FROM user WHERE username = ?");
            pst.setString(1, username);
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

    public static void registerUser() {



    }


}