/*
1.9
Write a program to demonstrate exception handling
*/
using System;

class InsufficientBalance : ApplicationException
{
	public InsufficientBalance(String msg):base(msg)
	{
		
	}
}	


class Account 
{
	int bal;
	public Account(int b)
	{
		bal=b;
	}
	
	public void display()
	{
		Console.WriteLine("Balance ="+bal);
	}
	
	public void debit(int amnt)
	{
		try{
			if(amnt>bal)
				throw new InsufficientBalance("Not enough balance...!");
			else{
				bal-=amnt;
			}
		}
		catch(InsufficientBalance e)
		{
			Console.WriteLine(e.Message);
		}
	}
}


public class Test
{
	public static void Main()
	{
		Account a=new Account(2000);
		a.debit(5000);
		a.display();
		
		a.debit(1500);
		a.display();
	}
}