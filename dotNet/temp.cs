/*This is a testing file*/
using System;
public class temp
{	public static string Reverse(string s)
	{
		char[] str=s.ToCharArray();
		Array.Reverse(str);
		return new string(str);
	}
	public static void Main()
	{
		string str1="Enter Decimal No.:::";
		Console.WriteLine(Reverse(str1));
		Console.WriteLine("Enter string to append.....");
		string str2=Console.ReadLine();
		str1.Append(str2);
		Console.WriteLine(str1);
		
		
	}
}





// Console.WriteLine("Enter binary no.:::");
		// double n=double.Parse(Console.ReadLine());
		// int c1=-1,c2=0,r=2;double sum=0;
		// double y=n%1;
			
			// //integer part
		// while(n!=0)
		// {
			
			// c1++;
			// int x=(int)n%10; 	//last digit
			// n/=10;			//number changed
			// sum+=(x*Math.Pow(r,c1));
		
		// }
			// //decimal part
		// while(y!=0)
		// {
			// c2++;	//index
			// y*=10;
			// int x=(int)y/1;	//division
			// y%=1;		//update y
			// sum+=x*(int)Math.Pow(r,-c2);			
		// }
		// Console.Write(sum);