/*
111
Write a program to demonstrate indexers. 
Detail: Create a class to process results (CPI Range 0.0 to 10.0) of n students. 
#The purpose is to count number of students per range.
Range 1 is 0.0 to 0.99, Range 2 is 1.0 to 1.99 and so on. 
So total 11 counts are possible. Use indexer to accept a double number (CPI value) and
update respective counter. Implement a method to display range counts too.
*/
using System;

public class Result
{
    int[] rangeCount;
    double[] cpi; 
    
    public Result(int n)
    {
        rangeCount=new int[10];
        for(int i=0;i<10;i++)
            rangeCount[i]=0;
        cpi=new double[n];
    }
    
    public double this[int index]
    {
        get{return rangeCount[index];}   //get count of range
        set{
            cpi[index]=value;               //set cpi and increase count
            if(cpi[index]>=0.0 && cpi[index]<1.0)
                rangeCount[0]++;
            else if(cpi[index]>=1.0 && cpi[index]<2.0)
                rangeCount[1]++;
            else if(cpi[index]>=2.0 && cpi[index]<3.0)
                rangeCount[2]++;
            else if(cpi[index]>=3.0 && cpi[index]<4.0)
                rangeCount[3]++;
            else if(cpi[index]>=4.0 && cpi[index]<5.0)
                rangeCount[4]++;
            else if(cpi[index]>=5.0 && cpi[index]<6.0)
                rangeCount[5]++;
            else if(cpi[index]>=6.0 && cpi[index]<7.0)
                rangeCount[6]++;
            else if(cpi[index]>=7.0 && cpi[index]<8.0)
                rangeCount[7]++;
            else if(cpi[index]>=8.0 && cpi[index]<9.0)
                rangeCount[8]++;
            else if(cpi[index]>=9.0 && cpi[index]<=10.0)
                rangeCount[9]++;
            }
    }
    
}

public class Test
{
    public static void Main()
    {
        Console.WriteLine("Enter no of students:");
        int n=int.Parse(Console.ReadLine());
        Result rs1=new Result(n);
        
        Console.WriteLine("Enter cpi:");
        for(int i=0;i<n;i++)
        {
           Console.WriteLine("Student 1:");
           rs1[i]=double.Parse(Console.ReadLine());
        }
        
        for(int i=0;i<10;i++)
            Console.WriteLine("\nNo of students in range "+(i+1)+"="+rs1[i]);
    }
}



/*

D:\PROJECTS\dotNet>Pract111
Enter no of students:
5
Enter cpi:
Student 1:
1.2
Student 1:
0.0
Student 1:
0.2
Student 1:
0.9
Student 1:
0.5

No of students in range 1=4

No of students in range 2=1

No of students in range 3=0

No of students in range 4=0

No of students in range 5=0

No of students in range 6=0

No of students in range 7=0

No of students in range 8=0

No of students in range 9=0

No of students in range 10=0

D:\PROJECTS\dotNet>    
*/

