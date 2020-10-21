//practical 11 Implement a digital signature algorithm. 
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class Pract11 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigital Signature Algorithm(DSA) ");
        System.out.print("\nEnter Plain Text : ");
        String msg = sc.nextLine();
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();
        sign.update(bytes);
        byte[] signature = sign.sign();
        String dot = new String(signature,"UTF-8");
        System.out.println("\nDigital signature for given text: "+dot);
    }
}