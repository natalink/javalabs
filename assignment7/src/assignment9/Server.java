package assignment9;


import java.net.*;
//import java.util.Scanner;
import java.io.*;

class ServeConnection extends Thread {
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  public ServeConnection(Socket s) throws IOException {
    socket = s;
    in = new BufferedReader (new InputStreamReader( socket.getInputStream()));
    out = new PrintWriter( new OutputStreamWriter( socket.getOutputStream()), true);
  }
  @Override
  public void run() {
    try {
      System.out.println("Obsluhuji spojeni");
      String str;
      while ((str = in.readLine()) != null) { 
          System.out.println("str:" + str);
          if (str.equals("END")) {
        	System.out.println("Konec obsluhy spojeni");
            break;
          } else if (str.startsWith("-d ")) {
        	  System.out.println("Entered -d");
        	  
          } else if (str.startsWith("-a ")) {
          }
          out.println(str);
       }
                  
      
    } catch(IOException e) {
      System.err.println("IO Exception");
    } finally {
      try {
        socket.close();
      } catch(IOException e) {
        System.err.println("Socket se neuzavrel");
      }
    }
   }
}


public class Server { 
  public static void main(String[] args) throws IOException {
    int cnt = 0;
    
    try (ServerSocket s = new ServerSocket(6666)) {
      System.out.println("Server pripraven");
      while(true) {
        Socket socket = s.accept();
        try {
          ServeConnection sc = new ServeConnection(socket);
          sc.start();
        } catch(IOException e) {
          System.err.println("IO Exception");
        }
        if (cnt++ > 4) {
          break;
        }
      }
    }
  }
}





