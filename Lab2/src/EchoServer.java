import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer{
    public static void main(String [] args){
        System.out.println("Server Starting...");
        
        try{
            ServerSocket s = new ServerSocket(8189); //the server socket at a port
            boolean over = false;   //initialize variable for loop
            
            while(!over){ //put in a loop that keeps running
                Socket incoming = s.accept(); //accept a connection from a client
                
                try{
                    InputStream inStream = incoming.getInputStream();    // INPUT handler
                    OutputStream outStream = incoming.getOutputStream(); // OUTPUT handler            
                    
                    Scanner in = new Scanner(inStream); //setup input
                    PrintWriter out = new PrintWriter(outStream, true);
             
                    boolean done = false;
                    while (!done && in.hasNextLine()){ //loop until no lines
                        String lineIn = in.nextLine();
                        System.out.println(lineIn.trim());
                        out.println(lineIn);
                        
                        
                        if (lineIn.trim().equals("BYE")){ //kill the server
                            done = true;
                        }
                    }
                }
                
                catch(Exception exc1){
                    exc1.printStackTrace();
                }
            }
        }
        
        catch(Exception exc2){
            exc2.printStackTrace();
        }
    }
}