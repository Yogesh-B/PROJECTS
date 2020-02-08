/*This is a testing file*/
using System;
public class temp
{	
	public static void Main()
	{
		string str1="Hello World";
		string str2="";
		string res="";
		if(str2=="")
			Console.WriteLine("str2 empty");
		for(int i=str1.Length-1;i>=0;i--)
			res+=str1[i];
		Console.WriteLine("result :: "+res);
		
	}
}











// public static string Reverse(string s)
	// {
		// char[] str=s.ToCharArray();
		// Array.Reverse(str);
		// return new string(str);
	// }
	// public static void Main()
	// {
		// string str1="Enter Decimal No.:::";
		// Console.WriteLine(Reverse(str1));
		// Console.WriteLine("Enter string to append.....");
		// string str2=Console.ReadLine();
		// str1.Append(str2);
		// Console.WriteLine(str1);
		
		
	// }
