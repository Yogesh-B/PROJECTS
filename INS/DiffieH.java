import java.lang.Math;
public class DiffieH{
	public static void main(String args[]){
		long XA=8;
		long XB=9;
		long q=5;
		long a=2;
		
		
		System.out.println("XA : "+XA+"  XB : "+XB+"  q="+q+"  a="+a);
		
		//YA and YB generated
		long YA=(long)(Math.pow(a,XA)%q);
		System.out.println("YA generated : "+YA);
		long YB=(long)(Math.pow(a,XB)%q);
		System.out.println("YB generated : "+YB);
		
		
		//common KEY generated
		System.out.println("XA  generated KEY : "+Math.pow(YB,XA)%q);
		System.out.println("XB generated  KEY: "+Math.pow(YA,XB)%q);
	}
}