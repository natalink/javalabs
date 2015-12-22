package assignment9;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
  public static void main(String[] args) {
    InetAddress addr;
    try {
      addr = InetAddress.getByName(null);
    } catch (UnknownHostException ex) {
      System.out.println("Unknown host");
      return;
    }
    try (Socket socket = new Socket(addr, 6666)){
      BufferedReader in = new BufferedReader (new InputStreamReader( socket.getInputStream()));
      PrintWriter out = new PrintWriter( new OutputStreamWriter( socket.getOutputStream()), true);
      BufferedReader inline = new BufferedReader ( new InputStreamReader(System.in));
      
      System.out.println("Please, specify the parameters: ");
      System.out.println("-d will print the list of priorities increasingly");
      System.out.println("Your choice:");
      String str = inline.readLine();
      System.out.println("str:" + str);
      
      out.println(str);
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
