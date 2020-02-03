/*1.2  Write a program which accepts number of rows, number of columns and character to print following pattern,If rows=2, columns=5 and char='*' , it should print 
*****
*****

*/
using System;
public class P2
{
	public static void Main()
	{	
		int rows,cols;
		char c;
		Console.WriteLine("Enter number of raws:");
		rows=int.Parse(Console.ReadLine());
		Console.WriteLine("Enter number of cols:");
		cols=int.Parse(Console.ReadLine());
		Console.WriteLine("Enter character:");
		c=char.Parse(Console.ReadLine());

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				Console.Write(c+" ");
			}
			Console.WriteLine();
		}			
	}
}

/*OUTPUT:
D:\PROJECTS\dotNet>Pract12
Enter number of raws:
3
Enter number of cols:
4
Enter character:
#
####
####
####

D:\PROJECTS\dotNet>_
*/