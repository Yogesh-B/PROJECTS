/*
113
 Write a program to demonstrate Reflection

Detail: Display list of constructors and methods along with their parameters of any 1 derived
class of Program 8.
*/
using System;
using System.Reflection;

public class Rectangle          //rectangle class from program 8
{
    double len,wid;
    public Rectangle(){}
    public Rectangle(double a, double b)
    {
        len=a; wid=b;
    }
    public double area()
    {
        return (len*wid);
    }
}   

public class Test
{
    public static void Main()
    {
        Rectangle r1=new Rectangle();
        Type t1=r1.GetType();
        ConstructorInfo[] ci=t1.GetConstructors();
        MethodInfo[] mi=t1.GetMethods();
                //type
        Console.WriteLine("Type="+t1+"\n\nConstructors=");
                //constructors
        foreach(ConstructorInfo c in ci)
            Console.WriteLine(c.ToString());
                //methods
        Console.WriteLine("\n\nMethods=");
        foreach(MethodInfo m in mi)
            Console.WriteLine(m.ToString());
    }
}



/*
D:\PROJECTS\dotNet>Pract113
Type=Rectangle

Constructors=
Void .ctor()
Void .ctor(Double, Double)


Methods=
Double area()
Boolean Equals(System.Object)
Int32 GetHashCode()
System.Type GetType()
System.String ToString()

D:\PROJECTS\dotNet>
*/