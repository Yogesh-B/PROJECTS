using System;

public class CC2 {         
        static void Main(string[] args)
        {
			int key = -5;
			//string output = "";
			
			Console.Write("Enter string:");
			string input = Console.ReadLine();
			Console.Write("Output : ");
			for (int i = 0; i < input.Length ; i++)
			{
				Console.Write((char)(input[i]+key));
			}
			Console.WriteLine();
        }
}