/*
1.9
Write a program to demonstrate exception handling.

Detail: Write a program which implements banking system. Provide functionalities for
account management. Implement following exceptions.
Account Creation:
InvalidOpeningBalance (Must be atleast 1000/-)
Credit:
InvalidCreditAmount (Must be in multiple of 100/- and Maximum 100000/-)
Debit:
InvalidDebitAmount (Must be in multiple of 100/- and Maximum 10000/-)
LowBalance (Must be able to maintain 1000/- balance after debit)
*/
using System;

class InvalidOpeningBalance : ApplicationException
{
	public InvalidOpeningBalance(String msg):base(msg)
	{
	}
}

class InvalidCreditAmount : ApplicationException
{
	public InvalidCreditAmount(String msg):base(msg)
	{
	}
}

class InvalidDebitAmount : ApplicationException
{
	public InvalidDebitAmount(String msg):base(msg)
	{
	}
}


class LowBalance : ApplicationException
{
	public LowBalance(String msg):base(msg)
	{
	}
}	


class Account 
{
	int bal;
	public Account(int amnt)         //open account
	{
		try {
			if(amnt<1000)
				throw new InvalidOpeningBalance("Opening amount must be 1000 or greater...");
			else	
				bal=amnt;
		}
		catch(InvalidOpeningBalance e){
			Console.WriteLine(e.Message);
						
		}
	}
	
	public void display()			//view balance
	{
		Console.WriteLine("Balance ="+bal);
	}
	
	public void debit(int amnt)      //debit money
	{
		try{
			if(amnt>bal || (amnt%100)!=0 || amnt>10000)
				throw new InvalidDebitAmount("Not enough balance - Not in multiple of 100 - Amount >10000 ...Error!!!");
			else{
				bal-=amnt;
			}
		}
		catch(InvalidDebitAmount e){
			Console.WriteLine(e.Message);
		}
	}
	
	public void credit(int amnt)
	{
		try{
			if((amnt%100)!=0 || amnt>100000)
				throw new InvalidCreditAmount("Not in multiple of 100 - Amount >100000 ...Error!!!");
			else{
				bal+=amnt;
			}
		}
		catch(InvalidCreditAmount e){
			Console.WriteLine(e.Message);
		}
	}
}


public class Test
{
	public static void Main()
	{
		Console.WriteLine("Enter amount for an account creation(>1000):");
		int amount=int.Parse(Console.ReadLine());
		// Console.WriteLine("\n............."+amount+"\n.............");
		Account ac1=new Account(amount);
		
		
		Console.WriteLine("Enter amount to Credit:");
		amount=int.Parse(Console.ReadLine());
		ac1.credit(amount);
		ac1.display();
		
		Console.WriteLine("Enter amount to Debit:");
		amount=int.Parse(Console.ReadLine());
		ac1.debit(amount);
		ac1.display();
	}
}