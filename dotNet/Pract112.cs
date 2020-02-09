/*
112
 Write a program to demonstrate properties. 
 
 Detail: Write a program which implements banking system. Provide functionalities for loan
management. Implement methods for loan payment. Provide read only properties for interest
rate and current loan amount.
*/

using System;
class Bank
{
    private double amount;
    private double interest;
    private double year;
    
    public Bank(double amnt,double intr,double yr)
    {
        amount=amnt; interest=intr; year=yr;
    }
    
    public double a_amount{             //get by properties
        get{return this.amount;}
    }
    
    public double a_interest{
        get{return this.interest;}
    }
    
    public double a_year{
        get{return this.year; }
         set{this.year=value;}
    }
    
    public double totalLoan()           //total amount to be paid
    {
        double result=amount+(amount*interest*year)/100;
        return result;
    }
}

public class Test
{
    public static void Main()
    {
        Bank b1=new Bank(250000,2.6,1);
        Console.WriteLine("Get {0} Rs. at {1} interest...\nEnter no of years:",b1.a_amount,b1.a_interest);
        b1.a_year=double.Parse(Console.ReadLine());
        
        Console.WriteLine("After {0} year/s you have to pay {1} Rs. ",b1.a_year,b1.totalLoan());
    }
}



/*
D:\PROJECTS\dotNet>Pract112
Get 250000 Rs. at 2.6 interest...
Enter no of years:
2
After 2 year/s you have to pay 263000 Rs.

D:\PROJECTS\dotNet>

*/