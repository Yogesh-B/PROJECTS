/*1.6
Write a menu driven program for number system conversion (Decimal to Binary, Octal and Hexadecimal). 

*/
using System;
public class Pract16
{
	public static void Main()
	{
		Console.WriteLine("\t\t\t!!!...This is a Number system converter...!!!\n");
		Numbers num=new Numbers();
		while(true)
		{
			Console.WriteLine("1.Decimal:");
			Console.WriteLine("2.Binary:");
			Console.WriteLine("3.Octal:");
			Console.WriteLine("4.Hexadecimal:");
			Console.WriteLine("5.Exit:");
			Console.WriteLine("Enter Source Type:"); 	//get source type
			int src=int.Parse(Console.ReadLine());
			if(src==5)
				break;
			
			Console.WriteLine("Enter Destination Type:");	//get destination type
			int dst=int.Parse(Console.ReadLine());
			if(dst==5)
				break;
			
			Console.WriteLine("Enter value:");
			double val=double.Parse(Console.ReadLine());
			double result=num.convert(src,dst,val);
			Console.WriteLine("Answer is = "+result+"\n");
			
			
		}

	}
}

public class Numbers
{
	public double convert(int tmpSrc,int tmpDst,double tmpVal)
	{	enum{A=10,B=11,C=12,D=13,E=14,F=15;}
		int c1=-1,c2=0,r=0;
		int[] arr={10,2,8,16};
		double y,sum=0,temp=0;
		//To Decimal
		r=arr[tmpSrc-1];     //set radix point
		switch(tmpSrc)
		{
			case 1:
			case 2:
			case 3:
			case 4:
				y=tmpVal%1;//extract decimal part
			
						//integer part
				while(tmpVal!=0)
				{
					c1++;
					int x=(int)tmpVal%10; 	//last digit
					tmpVal/=10;			//number changed
					sum+=(x*Math.Pow(r,c1));
				}
						//decimal part
				while(y!=0)
				{
					c2++;	//index
					y*=10;
					int x=(int)y/1;	//division
					y%=1;		//update y
					sum+=x*Math.Pow(r,-c2);			
				}
				
				
				break;
			default:
				Console.WriteLine("Invalid Input...!!!");
				break;
		}
		
		
		
		
		return sum;
	}
}



/*OUTPUT:


*/
