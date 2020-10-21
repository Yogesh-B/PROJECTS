//Write a program to generate SHA-1 hash.
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Pract10 {

  public static String encryptThisString(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-1");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger no = new BigInteger(1, messageDigest);
      String hashtext = no.toString(16);
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String args[]) throws NoSuchAlgorithmException {
    String str;
    Scanner input = new Scanner(System.in);
    System.out.println("\nSHA-1 Algorithm ");
    System.out.print("\nEnter Plain Text : ");
    str = input.nextLine();
    System.out.println("\n" + str + " : " + encryptThisString(str));
  }
}
