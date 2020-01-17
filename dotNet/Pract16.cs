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
			Console.WriteLine("\n");
			Console.WriteLine("#Decimal to :");
			Console.WriteLine("1.Binary:");
			Console.WriteLine("2.Octal:");
			Console.WriteLine("3.Hexadecimal:");
			Console.WriteLine("4.Exit:");			
			Console.WriteLine("Enter Destination Type:");	//get destination type
			int dst=int.Parse(Console.ReadLine());
			if(dst==4)
				break;
			
			Console.Write("Enter value:");
			int val=int.Parse(Console.ReadLine());
			num.convert(dst,val);
			
			
			
		}

	}
}

public class Numbers
{
	public void convert(int tmpDst,int tmpVal)
	{	
		int i=0,r=0;
		int[] arr={2,8,16};
		int[] temp=new int[16];
		
		r=arr[tmpDst-1];		//set radix point
		
		switch(tmpDst)
		{
			case 1:
			case 2:
			case 3:
				while(tmpVal>=1)
				{
   					temp[i]=tmpVal%r;
      				tmpVal=(int)(tmpVal/r);
      				i+=1;
    			}
				break;
			default:
				Console.WriteLine("Invalid Input...!!!");
				break;					
		}
			
		Console.Write("\nAnswer is = ");
		for (int j=temp.Length-1;j>=0;j--)
			Console.Write(temp[j]);
		
	}
}



/*OUTPUT:
D:\PROJECTS\dotNet>Pract16
                        !!!...This is a Number system converter...!!!



#Decimal to :
1.Binary:
2.Octal:
3.Hexadecimal:
4.Exit:
Enter Destination Type:
1
Enter value:21

Answer is = 0000000000010101

#Decimal to :
1.Binary:
2.Octal:
3.Hexadecimal:
4.Exit:
Enter Destination Type:
2
Enter value:9

Answer is = 0000000000000011

#Decimal to :
1.Binary:
2.Octal:
3.Hexadecimal:
4.Exit:
Enter Destination Type:
4

D:\PROJECTS\dotNet>_

*/
