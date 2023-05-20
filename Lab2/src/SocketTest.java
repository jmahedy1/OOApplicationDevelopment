import java.io.*;
import java.net.*;
import java.util.*;

public class SocketTest {
    public static void main(String [] args){
        System.out.println("Client Starting...");
        String line = "";
        
        try{
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);   //create a connection
            
            try{
                InputStream inStream = s.getInputStream();  //get input
                Scanner in = new Scanner(inStream); //put input into scanner, format we understand
                
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                out.println("Hello from the client");
                               
                while(in.hasNextLine()){    //true if there is another line in the input
                    line = in.nextLine();    //convert line to String
                    System.out.println(line);   //print String
                }
            }
            
            finally{   
                s.close();     //close connection
            }
        }
        
        catch(IOException ioexc){   
            ioexc.printStackTrace();    //exception
        }
    }
}