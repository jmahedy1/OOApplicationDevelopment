import java.io.*;
import java.net.*;
import java.util.*;

public class SocketTestOO {
    
    public String myClient(String url, int port){
        String line = "";
        System.out.println("Client Starting...");
        
        try{
            Socket s = new Socket(url, port);   
            
            try{
                InputStream inStream = s.getInputStream();  
                Scanner in = new Scanner(inStream); 
                
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                out.println("From OO Client");
                               
                while(in.hasNextLine()){    
                    line = in.nextLine();   
                    System.out.println(line);  
                }
            }
            
            finally{   
                s.close();   
            }
        }
        
        catch(IOException ioexc){   
            ioexc.printStackTrace();   
        }
        
        return line;
    }
    
    public static void main(String [] args){
        SocketTestOO st = new SocketTestOO();
        String output = st.myClient("127.0.0.1", 8189);
        System.out.println("The output is: " + output);
    }
}
