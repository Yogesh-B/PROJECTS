   /*
   1.8
   Write a program to demonstrate inheritance and polymorphism.
   Detail: Write a program which implements an abstract base class called Shape. 
   Derive three derived classes - Rectangle, Circle and Triangle. 
   Implement necessary functionalities to calculate area of a shape. 
 
   */
using System;
       
public abstract class Shape                //base class
{
    public Shape(){}
    public abstract double area();
}

public class Circle : Shape           //circle derived 
{
    double rad;
    
    public Circle(double rd)
    {
        rad=rd;
    }
    public override double area()
    {
       return (Math.PI*rad*rad);
    }
}

public class Rectangle : Shape          //rectangle derived
{
    double len,wid;
    
    public Rectangle(double a, double b)
    {
        len=a; wid=b;
    }
    public override double area()
    {
        return (len*wid);
    }
}   

public class Triangle : Shape           //triangle derived
{
    double side1,side2,side3;
    
    public Triangle(double a, double b, double c)
    {
        side1=a; side2=b; side3=c; 
    }
    public override double area()
    {
        double res,s=(side1+side2+side3)/2;
        res=Math.Sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return res;
    }
}      


                                                 //main class test
public class Test
{
    public static void Main()
    {
        Circle c1=new Circle(2);
        Rectangle r1=new Rectangle(2,3);
        Triangle t1=new Triangle(3,4,5);
        
        Console.WriteLine("Area of Circle="+c1.area());
        Console.WriteLine("Area of Rectangle="+r1.area());
        Console.WriteLine("Area of Triangle="+t1.area());
    }
    
}
   
   
   
/*
D:\PROJECTS\dotNet>Pract18
Area of Circle=12.5663706143592
Area of Rectangle=6
Area of Triangle=6

D:\PROJECTS\dotNet>_  
*/