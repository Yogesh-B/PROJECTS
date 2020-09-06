import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class Sha512
{
	
	public static void main (String str[]) throws Exception
	{
		String name1="sameer";
		String name2="samir";
		System.out.println("\n\nMessage 1 = " + name1+"\n");
		byte plaindata1[]=name1.getBytes(); // Message1 in byte 
		 
		
		MessageDigest md;
		byte hashdata[];
		String hashstring;
		
		md = MessageDigest.getInstance("SHA-512"); //to get instance of MessageDigest
		
		
		hashdata = md.digest(plaindata1);	//to generate hash value1
		hashstring = new String(hashdata);
		System.out.println("hash value : " + hashstring); //hash value in string1
		System.out.println("hex value : "+ (DatatypeConverter.printHexBinary(hashdata))+"\n"); //hash value in hex
		System.out.print("hex value : "+ (DatatypeConverter.printHexBinary(hashdata)).length() + "\n"); //length of hash value1
		System.out.print("\n\n\n\n");



		System.out.println("Message 2 = " + name2+"\n");
		byte plaindata2[]=name2.getBytes(); // Message2 in byte
		hashdata = md.digest(plaindata2);	//to generate hash value1
		hashstring = new String(hashdata);
		System.out.println("hash value : " + hashstring); //hash value in string1
		System.out.println("hex value : "+ (DatatypeConverter.printHexBinary(hashdata))+"\n"); //hash value in hex
		System.out.print("hex value : "+  (DatatypeConverter.printHexBinary(hashdata)).length() + "\n"); //length of hash value1
		System.out.print("\n\n\n\n");		
		
		
	}
}