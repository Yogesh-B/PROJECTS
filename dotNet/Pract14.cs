/*
1.4 Write a menu driven program for currency conversion(Rupees, Dollar, Franc, Euro).
#1 United States Dollar equals
71.45 Indian Rupee
#1 Swiss Franc equals
73.38 Indian Rupee
#1 Euro equals
79.42 Indian Rupee
*/
using System;
class Pract14
{
	public static void Main()
	{
		Console.WriteLine("This is a currency converter for USD,INR,FRANC,EURO!!!\n");
		MoneyConvert m=new MoneyConvert();
		
		while(true)
		{
			Console.WriteLine("Enter type:");
			Console.WriteLine("Enter 1.INR:");
			Console.WriteLine("Enter 2.USD:");
			Console.WriteLine("Enter 3.FRANC:");
			Console.WriteLine("Enter 4.EURO:");
			Console.WriteLine("Enter 5.EXIT:");
			
			Console.WriteLine("Enter source currency:");
			int src=int.Parse(Console.ReadLine());
			if(src == 5){
				break;}
				
			Console.WriteLine("Enter destination currency:");
			int dst=int.Parse(Console.ReadLine());
			if(dst == 5){
				break;}
				
			Console.WriteLine("Enter Amount:");	
			double amt = double.Parse(Console.ReadLine());
			
			amt = m.change(src, dst, amt);
			Console.WriteLine(" Answer is = "+ amt);	
		}	
	}	
}

//convert all to Rupees then to any other
public class MoneyConvert
{
	public double change(int src,int dst,double amt)
	{
		double INR=0,DEST=0;
		
		//other to INR
		switch(src)
		{
			case 1:
				INR=amt*1;
				break;
			case 2:
				INR=amt*71.45;
				break;
			case 3:
				INR=amt*73.38;
				break;
			case 4:
				INR=amt*79.42;
				break;
			default:
				Console.WriteLine("\nInvalid Input...!!!\n");
				break;
			
		}
	
		//INR to other
		switch(dst)
		{
			case 1:
				DEST=INR/1;
				break;
			case 2:
				DEST=INR/71.45;
				break;
			case 3:
				DEST=INR/73.38;
				break;
			case 4:
				DEST=INR/79.42;
				break;			
			default:
				Console.WriteLine("\nInvalid Input...!!!\n");
				break;	
		}
		return DEST;	
	}
}


/*OUTPUT:
D:\PROJECTS\dotNet>Pract14
This is a currency converter for USD,INR,FRANC,EURO!!!

Enter type:
Enter 1.INR:
Enter 2.USD:
Enter 3.FRANC:
Enter 4.EURO:
Enter 5.EXIT:
Enter source currency:
3
Enter destination currency:
2
Enter Amount:
123
 Answer is = 126.322463261022
Enter type:
Enter 1.INR:
Enter 2.USD:
Enter 3.FRANC:
Enter 4.EURO:
Enter 5.EXIT:
Enter source currency:
1
Enter destination currency:
2
Enter Amount:
76
 Answer is = 1.06368089573128
Enter type:
Enter 1.INR:
Enter 2.USD:
Enter 3.FRANC:
Enter 4.EURO:
Enter 5.EXIT:
Enter source currency:
5

D:\PROJECTS\dotNet>_
*/
