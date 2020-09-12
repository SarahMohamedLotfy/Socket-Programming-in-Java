 

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Server {

  public static int clientNumber = 0; // to keep track of the number of clients connecting to the server.

  public static void main(String[] args) throws IOException, Exception , ClassNotFoundException {
    System.out.println("The server is running");

    new Thread() {
      public void run() {
        try {
          ServerSocket ss = new ServerSocket(6666);
          while (true) {
            new triangleType(ss.accept(), clientNumber++).start();
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }.start();
  }

  private static class triangleType extends Thread  {
    Socket socket;
    int clientNo;

    public triangleType(Socket s, int clientNo) {
      this.socket = s;
      this.clientNo = clientNo;
      //System.out.println("Connection with Client #" + clientNo + "at socket " + socket);
    }

    public void run() 
    {
      boolean check=true;
     
      try {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        ObjectInputStream tri=new ObjectInputStream(this.socket.getInputStream());
        while (check) {
        try{
        try 
        {
        Triangle t ;
        while ((t = (Triangle)tri.readObject()) != null) {
         String triangletype = null;
         triangletype = t.triangleType();
         out.println(triangletype);
        
        } 
        }
        catch (ClassNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        }  
       }
       catch (EOFException ex) 
        { 
            check=false; 
        }
    }
        out.close();
        socket.close();
        //System.out.println("Connection with Client #" + this.clientNo + " finished..");
      } catch (IOException e) {
        e.printStackTrace();
      }
    
  }
}
}


