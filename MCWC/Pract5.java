/*Practical 5  Write a program to find hamming distance. For example Hamming distance d(v1,v2)=3 if v1=011011,v2=110001.  */
public class Pract5 {

  static int HammingDistance(String str1, String str2) {
    int i = 0, count = 0;
    while (i < str1.length()) {
      if (str1.charAt(i) != str2.charAt(i)) count++;
      i++;
    }
    return count;
  }

  public static void main(String[] args) {
    String str1 = "011011";
    String str2 = "110001";
    System.out.println("A = "+str1);
    System.out.println("B = "+str2);
    System.out.println("Hamming distance = "+HammingDistance(str1, str2));
  }
}
