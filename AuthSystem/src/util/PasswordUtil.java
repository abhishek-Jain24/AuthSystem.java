package util;
import java.security.MessageDigest;   //Message digest class can be used to generate a secure one way  cryptographic hash of data such as passwords

public class PasswordUtil {
    /*SHA-256 hashing --> 1) Secure Hash Algo. ,256-bit output
                         2) Type: Cryptographic hash function
                         3) Output : 256-bit(64 hex chars)
                         4) input : any size
                         5)Deterministic :Same input --> Same hash
                         6) One way : Can't reverse
                         7) Collision resistant : Hard to find two inputs with same hash
                         8)Avalanche effect : Small input change --> totally different hash
      9) Used in :- Bitcoin, TLS,digital signatures, password storage

     */

    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException("Hashing failed");
        }
    }

    // Password validate
    public static boolean validate(String password) {

        // Local class
        class Validator {
            boolean check() {
                return password != null && password.length() >= 6;
            }
        }

        return new Validator().check();
    }
}
