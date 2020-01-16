/*1.1  Write a program which accepts name and country name to print following message 
Hello Ram from country India!
*/
using System;
public class F1
{
	public static void Main()
	{	
		//reading data
		String name,country;
		
		Console.WriteLine("Enter your name:");
		name=Console.ReadLine();
		Console.WriteLine("Enter country name:");
		country=Console.ReadLine();
				
		Console.WriteLine("Hello "+name+" from coutry "+country+"!");	
	}
}
/*OUTPUT:
D:\PROJECTS\dotNet>Pract11
Enter your name:
Yogesh
Enter country name:
India
Hello Yogesh from coutry India!

D:\PROJECTS\dotNet>_
*/