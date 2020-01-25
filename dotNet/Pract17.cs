/*1.7
Write a program to convert infix notation to postfix notation. 
*/
using System; 
using System.Collections.Generic; 
      
public class Program 
{ 
 public static void Main() 
 { 
   string infix; 
   Console.WriteLine("Enter an Infix expression:"); 
   infix=Console.ReadLine(); 
         String postfix = InfixToPostfix(infix); 
                System.Console.WriteLine("InFix   :\t" + infix); 
                System.Console.WriteLine("PostFix :\t" + postfix); 
 } 
  
 public static string InfixToPostfix(string exp) 
    { 
   // initializing empty String for result 
        String result = String.Empty; 
          
        // initializing empty stack 
        Stack<char> stack = new Stack<char>(); 
		     for (int i = 0; i<exp.Length; i++) 
        { 
            char c = exp[i]; 
              
             // If the scanned character is an operand, add it to output. 
            if (Char.IsLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.Push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (stack.Count!=0 && stack.Peek() != '(') 
                    result += stack.Pop(); 
                  
                if (stack.Count!=0 && stack.Peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else 
                    stack.Pop(); 
            } 
            else // an operator is encountered 
            { 
			   while (stack.Count!=0  && Prec(c) <= Prec(stack.Peek())) 
                    result += stack.Pop(); 
                stack.Push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (stack.Count!=0 ) 
            result += stack.Pop(); 
       
        return result; 
    } 
  
 // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    public static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
		case '^': 
            return 3; 
        } 
        return -1; 
    } 
} 

/*OUTPUT:

*/