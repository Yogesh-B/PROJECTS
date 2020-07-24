import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class TDMA1
{
 public static void main (String[]args)
 {
 int n = 12, Total = 0, Time_Slice = 10, i, Data_sent = 0;
 int[] Station_Time = new int[]{ 10, 20, 10, 10, 20, 20, 30, 30, 10, 10, 20, 40 };
 Scanner input = new Scanner (System.in);
 for (i = 0; i < n; i++)
 {
 Total = Total + Station_Time[i];
 }
 System.out.println ("Total data of all the chnnels: " + Total + " Units");
 while (Data_sent < Total)
 {
 for (i = 0; i < n; i++)
 {
 if (Station_Time[i] > 0)
 {
 System.out.println ("Channel " + i + " Sending Data");
 if (Station_Time[i] > Time_Slice)
 {
 Data_sent = Data_sent + Time_Slice;
 Station_Time[i] = Station_Time[i] - Time_Slice;
 }
 else
 {
 Data_sent = Data_sent + Station_Time[i];
 Station_Time[i] = 0;
 }
 try
 {
 Thread.sleep(1000);
 }
 catch (InterruptedException e)
 {
	  e.printStackTrace();
 }
 }
 }
 }
 System.out.println("Total data sent : " +Data_sent + " Units");
 }
}