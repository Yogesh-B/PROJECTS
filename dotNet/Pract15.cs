/*
1.5 Write a menu driven program for temperature conversion (Fahrenheit, Celsius).
*/
using System;
public class Pract15
{
	public static void Main()
	{
		Console.WriteLine("\n!!!...This is a Temprature converter program...!!!\n");
		
		
		while(true)	
		{
			Console.WriteLine("Enter 1.Celsius to Fahrenheit:");
			Console.WriteLine("Enter 2.Fahrenheit to Celsius:");
			Console.WriteLine("Enter 3.Exit:");
			int c=int.Parse(Console.ReadLine());
			if(c==3)
			{
				break;
			}
			
			Console.WriteLine("Enter Value:");
			double val=double.Parse(Console.ReadLine());
			double temp=0;	
			switch(c)
			{
				case 1:
					temp=((9.0/5.0)*val)+32;
					Console.WriteLine("Result = "+temp+"\n");					
					break;
				case 2:
					temp=(val-32)*5.0/9.0;
					Console.WriteLine("Result = "+temp+"\n");					
					break;
				default:
					Console.WriteLine("Invalid Input...!!!");
					break;
			}
			
		}
	}
}


/*OUTPUT:
D:\PROJECTS\dotNet>Pract15

!!!...This is a Temprature converter program...!!!

Enter 1.Celsius to Fahrenheit:
Enter 2.Fahrenheit to Celsius:
Enter 3.Exit:
1
Enter Value:
37
Result = 98.6

Enter 1.Celsius to Fahrenheit:
Enter 2.Fahrenheit to Celsius:
Enter 3.Exit:
2
Enter Value:
97
Result = 36.1111111111111

Enter 1.Celsius to Fahrenheit:
Enter 2.Fahrenheit to Celsius:
Enter 3.Exit:
3

D:\PROJECTS\dotNet>_
*/