import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServerOO {
    
    public void echoServer(int port){
        System.out.println("Server Starting...");
        
        try{
            ServerSocket s = new ServerSocket(port); 
            boolean over = false;   
            
            while(!over){ 
                Socket incoming = s.accept(); 
                
                try{
                    InputStream inStream = incoming.getInputStream();    
                    OutputStream outStream = incoming.getOutputStream();            
                    
                    Scanner in = new Scanner(inStream); 
                    PrintWriter out = new PrintWriter(outStream, true);

                    boolean done = false;
                    while (!done && in.hasNextLine()){ 
                        String lineIn = in.nextLine();
                        System.out.println(lineIn.trim());
                        out.println(lineIn);
                        
                        if (lineIn.trim().equals("BYE")){
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
    
    public static void main(String [] args){
        EchoServerOO es = new EchoServerOO();
        es.echoServer(8189);
    }
}
