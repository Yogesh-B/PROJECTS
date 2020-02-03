   /*
   1.8
   Write a program to demonstrate inheritance and polymorphism.
   */
using System;
       
   public class Demo
   {
       protected int a;
       
       public Demo(){}//if this not included then will give error
       public Demo(int temp)
       {
           a=temp;
       }
       public void display_a()
       {
           Console.WriteLine("In base class...a="+a);
       }
       
   }
   
   public class Demo2:Demo  //inheritance
   {
       // int a;
       int b;
       // public Demo2(){}
       public Demo2(int var1,int var2)
       {
           a=var1;
           b=var2;
       }
       
       public void display_b()
       {
           Console.WriteLine("In drived class...b="+b);
       }
       
       public void display_a(int c) //method overloading(polymorphism)
       {
           Console.WriteLine("a,b added with {0} = {1} in derived class ",c,a+b+c);
       }
   }
   
   public class Test
   {
       public static void Main()
       {
           Demo d1=new Demo(10);
           Demo2 d2=new Demo2(20,30);
           
           d1.display_a();
           d2.display_a();//derived method
           d2.display_b();
           d2.display_a(12);//overloaded method
       }
   }
   