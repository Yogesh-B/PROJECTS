import java.util.Scanner;

public class HammingDistance{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter first binary : ");
        String str1 = sc.nextLine();
        System.out.println("Enter second binary : ");
        String str2 = sc.nextLine();
        int count = 0;
        
        
        for (int i=0; i<str1.length(); i++){
            if( str1.charAt(i) != str2.charAt(i) ){
                count++;
            }
        }
        
        System.out.println("Hamming distance is = "+ count);
    }
}
