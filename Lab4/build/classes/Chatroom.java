
//import java.io.InputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;

/*
Jack Mahedy

This is the 
*/

public class Chatroom{
    private Person sender;
    private Person receiver; 
    Person p1 = new Person("Karty", "1", "127.0.0.1", 8189);
    Person p2 = new Person("Ryan", "2", "127.0.0.1", 8189);
    Person p3 = new Person("Jack1", "3", "192.168.1.57", 8189);
    Person p4 = new Person("Jack2", "4", "192.168.1.59", 8189);
    
    public void setSender(Person sender){
        this.sender = sender;
    }
    
    public Person getSender(){
        return sender;
    }
    
    public void setReceiver(Person receiver){
        this.receiver = receiver;
    }
    
    public Person getReceiver(){
        return receiver;
    }
    
    public void sendMessage(Person p, String message){    //client   
        Client c = new Client();
        c.Client(getReceiver(), message);
    }
    
//    public void receiveMessage(int port){                //server 
//        Server s = new Server();
//        s.server(port);
//        
//    }
}