package controller.utilities;

import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    // Validate the user email with a useless regex because why not
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    final static String DATE_FORMAT = "mm/dd/yyyy";
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
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

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

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

    // Returns a java.sql.Date type given a string
    public static java.sql.Date convertDate(String dateString) throws ParseException {

        java.util.Date utilDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    /**
     * Method to check empty strings
     */
    public static boolean checkEmpty(String value) {
        if (!(value == null))
            return value.isEmpty();

        return true;
    }

    public static boolean isValidEmailAddress(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    // Date check function
    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Signal the HTML page that one or more errors
    // has occurred during the registration
    public static void signalErrors(HttpServletRequest request) {
        boolean errors = true;
        request.setAttribute("errors", errors);
    }

    public static void scale_img(InputStream imageInput, String filestring) throws IOException {

        int           thumbWidth   = 128;
        int           thumbHeight  = 128;
        String        formatName   = "PNG";
        BufferedImage thumb        = null;
        File          file         = new File(filestring);

        try {
            BufferedImage image = ImageIO.read(imageInput);

            int height = ((BufferedImage) image).getHeight();
            int width = ((BufferedImage) image).getHeight();

            if (height != 128 && width != 128) {

                // Now scale the image using Java 2D API to the desired thumb size.
                thumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = thumb.createGraphics();
                graphics2D.setBackground(Color.WHITE);
                graphics2D.setPaint(Color.WHITE);
                graphics2D.fillRect(0, 0, thumbWidth, thumbHeight);
                graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
                ImageIO.write(thumb, formatName, file);

            } else {
                ImageIO.write(image, "png", file);
            }
        } catch (Exception e) {
            // not an image
        }
    }

    // Check if a string is numeric
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */
    public static void sendMail(String targetEmail, String messageBody) {
        final String fromEmail = "unnamedgroup.official@gmail.com"; //requires valid gmail id
        final String password = "unnamedpass123"; // correct password for gmail id

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, targetEmail,"Unnamed Website Reset password", messageBody);
    }

    // Generate a a random UUID (Universally unique identifier)
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


}