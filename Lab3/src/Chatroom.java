/*
Jack Mahedy

This is the Chatroom class. It contains the gui, send message, and receive message
methods. The send message method is a client which uses a outstream to send the messages. 
The receive message method is server which uses a instream to get messages. The GUI
includes a textfield to enter a message, a text area to conversationBox the messages, a button
to send the message, and a combo box to select the receiver.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Chatroom extends JFrame implements ActionListener{
    JPanel pnlContain;
    JTextField messageBox;
    JTextArea conversationBox;
    JButton sendButton;
    JComboBox receiverCombo, senderCombo;
    String[] pList1 = {"Select Sender", "Karty", "Ryan", "Jack1", "Jack2"};
    String[] pList2 = {"Select Receiver", "Karty", "Ryan", "Jack1", "Jack2"};
    
    Message m = new Message();
    
    Person sender;
    Person receiver;
    Person jack1 = new Person("jack1", "1", "127.0.0.1", 8189);
    Person jack2 = new Person("jack2", "2", "10.184.69.233", 8189);
    Person karty = new Person("karty", "3", "10.186.165.127", 8189);
    Person ryan = new Person("ryan", "4", "10.184.67.159", 8189);
    
    public Chatroom(){
        Container cp = getContentPane();
        messageBox = new JTextField(20);
        conversationBox = new JTextArea(20, 40);
        sendButton = new JButton("Send");
        
        senderCombo = new JComboBox(pList1);
        senderCombo.setSelectedIndex(0);
        senderCombo.addActionListener(this);
        
        receiverCombo = new JComboBox(pList2);
        receiverCombo.setSelectedIndex(0);
        receiverCombo.addActionListener(this);
        
        sendButton.addActionListener(this);
        
        pnlContain = new JPanel();
        pnlContain.add(messageBox);
        pnlContain.add(sendButton);
        pnlContain.add(conversationBox);
        pnlContain.add(senderCombo);
        pnlContain.add(receiverCombo);
        cp.add(pnlContain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == senderCombo){
            JComboBox cb = (JComboBox)evt.getSource();
            String contacts1 = (String)cb.getSelectedItem();
            
            if(contacts1.equals("Jack1")){
               sender = jack1;
            }
            
            if(contacts1.equals("Jack2")){
               sender = jack2;
            }
            
            if(contacts1.equals("Karty")){
               sender = karty;
            }
            
            if(contacts1.equals("Ryan")){
               sender = ryan;
            }
        }
            
        if(evt.getSource() == receiverCombo){
            JComboBox cb = (JComboBox)evt.getSource();
            String contacts2 = (String)cb.getSelectedItem();
            
            if(contacts2.equals("Jack1")){
               receiver = jack1;
            }
            
            if(contacts2.equals("Jack2")){
               receiver = jack2;
            }
            
            if(contacts2.equals("Karty")){
               receiver = karty;
            }
            
            if(contacts2.equals("Ryan")){
               receiver = ryan;
            } 
        }
        
        if(evt.getSource() == sendButton){
            m.setMessage(messageBox.getText());
            sendMessage(m.getMessage());
            messageBox.setText("");
            messageBox.requestFocus();
            conversationBox.append(sender.getUsername() + ": " + m.getMessage() + "\n"); 
        }
    }
    
    public void sendMessage(String message){    //client   
        System.out.println("Client Starting...");
        try{
            Socket s = new Socket(receiver.getIpAddress(), receiver.getPort());   
            
            try{
                OutputStream outStream = s.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);
                out.println(message);
            }
            
            finally{   
                s.close(); 
            }
        }
        
        catch(IOException ioexc){   
            ioexc.printStackTrace();   
        }
    }
    
    public void receiveMessage(int port){             //server 
        System.out.println("Server Starting...");
        
        try{
            ServerSocket s = new ServerSocket(port); 
            boolean over = false;   
            
            while(!over){ 
                Socket incoming = s.accept(); 
                
                try{
                    InputStream inStream = incoming.getInputStream();  
                    Scanner in = new Scanner(inStream); 

                    boolean done = false;
                    while (!done && in.hasNextLine()){ 
                        String lineIn = in.nextLine();
                        
                        if (lineIn.trim().equals("END")){
                            done = true;
                        }
                        
                        else{
                            m.setMessage(lineIn);
                            conversationBox.append(receiver.getUsername() + ": " + m.getMessage() + "\n"); 
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
        Chatroom cr1 = new Chatroom();  
        cr1.setSize(500, 500);
        cr1.setVisible(true);
        cr1.receiveMessage(8189);
    }
}