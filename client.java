import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;  
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.net.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
 import java.util.Random;
import java.util.Random;
import java.lang.*;
public class client
{
    
   public static void main(String[] args) throws UnknownHostException, IOException
   {
    File file = new File("input.txt");
    int numberTriangle =0;
    double arrPoints[]=new double[100];
    try{
    BufferedReader br = new BufferedReader(new FileReader(file));
    String strLine = null;
    int i=0;
     strLine = br.readLine();
      numberTriangle = Integer.parseInt(strLine);
    while ((strLine = br.readLine()) != null)   {
      
      String[] strs = strLine.trim().split(" ");

      for (int j=0;j<strs.length;j++) {
        arrPoints[i] = Double.parseDouble(strs[j]);
        i++;
       } 
    }
    }catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }
    int k=0;
    List<Triangle> triangleslist = new ArrayList<Triangle>();
    for (int i =0;i<numberTriangle;i++)
    {
      double x1 = arrPoints[k]; k++;
      double y1 = arrPoints[k]; k++;
      double x2 = arrPoints[k]; k++;
      double y2 = arrPoints[k]; k++;
      double x3 = arrPoints[k]; k++;
      double y3 = arrPoints[k]; k++;
      Point v1 = new Point(x1, y1);
      Point v2 = new Point(x2, y2);
      Point v3 = new Point(x3, y3);
      Triangle t = new Triangle(v1, v2, v3);
      triangleslist.add(t);
    }
    
    Socket s = new Socket("localhost", 6666);
    BufferedReader socketReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
    int i = 0;
    int j=0;
    j=i+1;
    os.writeObject(triangleslist.get(i));
    System.out.println("Sending Triangle number   " + j);
    String triangleType = socketReader.readLine();
    System.out.println("The type of triangle #  " + j +" is " + triangleType);
     i++;
    
    while (i < numberTriangle) {
      j =i+1;
      Scanner sc = new Scanner(System.in);
      System.out.println("Press Enter to continue");
      sc.nextLine();
      os.writeObject(triangleslist.get(i));
      System.out.println("Sending Triangle number   " + j);
      triangleType = socketReader.readLine();
      System.out.println("The type of triangle #  " + j +" is " + triangleType);
      i++;
    }
    os.close();
    s.close();
   }
      

}
