/*1.3
Write a program to convert digits to words
*/
using System;

public class Pract13
{
	public static void Main()
	{	
		Console.WriteLine("Enter a integer number:");
		string a=Console.ReadLine();
		Console.WriteLine("\nOutput:\n");
		
		for(int i=0;i<a.Length;i++)
		{
			Pract13.show(a[i]);
		}
		
		Console.WriteLine();
	
	}
	
	public  static void show(char c)
	{
		switch(c)
		{
			case '1':
				Console.Write("one	");
				break;
			case '2':
				Console.Write("two	");
				break;
			case '3':
				Console.Write("three	");
				break;
			case '4':
				Console.Write("four	");
				break;
			case '5':
				Console.Write("five	");
				break;	
			case '6':
				Console.Write("six	");
				break;	
			case '7':
				Console.Write("seven	");
				break;
			case '8':
				Console.Write("eight	");
				break;
			case '9':
				Console.Write("nine	");
				break;	
			case '0':
				Console.Write("zero	");
				break;	
			default:
				Console.Write("Error!!!    ");
				break;
		}
		
	}
}




/*OUTPUT:
D:\PROJECTS\dotNet>Pract13
Enter a integer number:
12321

Output:

one     two     three   two     one

D:\PROJECTS\dotNet>_
*/