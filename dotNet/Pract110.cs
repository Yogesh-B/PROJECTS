/*
110
Write a program to demonstrate delegates.

Detail: Create a class to implement string manipulation methods (uppercase, lowercase and
reverse).
 Create a class to use these methods with the use of multicast delegates.
 Use a menu driven user input for the selection of string manipulation operations.
 For example, 
 User needs to 
 enter 1 for uppercase conversion,
 2 for lowercase conversion, 
 3 for reverse, 
 4 for uppercase and lowercase, 
 5 for uppercase and reverse, 
 6 for lowercase and  reverse and 
7 for all operations.
*/
using System;

delegate void StrOp(string s);
class Method
{
    public static void strUpper(string str)    //uppercase
    {
        if(str=="")
        {
            Console.WriteLine("Empty string...!!!");
            return ;
        }
        Console.WriteLine(str.ToUpper());
        
    }
    
    public static void strLower(string str)    //lowercase
    {
        if(str=="")
        {
            Console.WriteLine("Empty string...!!!");
            return ;
        }
        Console.WriteLine(str.ToLower());
    }
    
    public static void strReverse(string str)		//reverse
    {
         if(str=="")
        {
            Console.WriteLine("Empty string...!!!");
            return ;
        }
        for(int i=str.Length-1;i>=0;i--)
        {
            Console.Write(str[i]);
        }
        Console.WriteLine();
    }
}

public class Test
{
    public static void Main()
    {
        StrOp operation;
		
		    Console.WriteLine("Enter 1 to convert to Upper case.");
			Console.WriteLine("Enter 2 to convert to Lower case.");
			Console.WriteLine("Enter 3 to convert to Reverse.");
			Console.WriteLine("Enter 4 to convert to Upper case and Lowercase.");
			Console.WriteLine("Enter 5 to convert to Upper case and Reverse.");
			Console.WriteLine("Enter 6 to convert to Lower case and Reverse.");
			Console.WriteLine("Enter 7 to convert to All.");
			Console.WriteLine("Enter 8 to Exit.");
		
        while(true)
		{
			Console.WriteLine("Enter a String:");
			string str=Console.ReadLine();
			
			
			Console.WriteLine("Enter your choice:");
			int n=int.Parse(Console.ReadLine());
            if(n==8)
                break;
			
			switch(n)
			{
				case 1:
				operation=Method.strUpper;
				operation(str);
				break;
			case 2:
				operation=Method.strLower;
				operation(str);
				break;
			case 3:
				operation=Method.strReverse;
				operation(str);
				break;
			case 4:
				operation=Method.strUpper;
				operation+=Method.strLower;
				operation(str);
				break;
			case 5:
				operation=Method.strUpper;
				operation+=Method.strReverse;
				operation(str);
				break;
			case 6:
				operation=Method.strLower;
				operation+=Method.strReverse;
				operation(str);
				break;
			case 7:
				operation=Method.strUpper;
				operation+=Method.strLower;
				operation+=Method.strReverse;
				operation(str);
				break;
			default:
				Console.WriteLine("Invalid Input...!!!");
				break;
			}
		}
    }
}

/*


D:\PROJECTS\dotNet>Pract110
Enter 1 to convert to Upper case.
Enter 2 to convert to Lower case.
Enter 3 to convert to Reverse.
Enter 4 to convert to Upper case and Lowercase.
Enter 5 to convert to Upper case and Reverse.
Enter 6 to convert to Lower case and Reverse.
Enter 7 to convert to All.
Enter 8 to Exit.
Enter a String:
Yogesh
Enter your choice:
1
YOGESH
Enter a String:
Yogesh
Enter your choice:
2
yogesh
Enter a String:
Yogesh
Enter your choice:
3
hsegoY
Enter a String:
Yogesh
Enter your choice:
4
YOGESH
yogesh
Enter a String:
Yogesh
Enter your choice:
5
YOGESH
hsegoY
Enter a String:
Yogesh
Enter your choice:
6
yogesh
hsegoY
Enter a String:
Yogesh
Enter your choice:
7
YOGESH
yogesh
hsegoY
Enter a String:
Yogesh
Enter your choice:
8

D:\PROJECTS\dotNet>_
*/

