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
			int src=-1,dst=-1;
			Console.WriteLine("Enter type:");
			Console.WriteLine("Enter 1.INR:");
			Console.WriteLine("Enter 2.USD:");
			Console.WriteLine("Enter 3.FRANC:");
			Console.WriteLine("Enter 4.EURO:");
			Console.WriteLine("Enter 5.EXIT:");
			while(true) 
			{
				Console.WriteLine("Enter source currency:");
				src=int.Parse(Console.ReadLine());
				if(src >0 && src <6)
				{
					break;
				}
			}
			if(src == 5){
				break;}
			while(true)
			{
				Console.WriteLine("Enter destination currency:");
				dst=int.Parse(Console.ReadLine());
				if(dst >0 && dst <6 && dst != src)
				{
					break;
				}
			}
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
		double[] multi = {1, 71.45, 73.38, 79.42};   //improve only declaration if needed
		return (amt/multi[src - 1]) * multi[dst - 1];
	}
}

