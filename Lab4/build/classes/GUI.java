/*
Jack Mahedy

This is the Message 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener, KeyListener, MouseListener{
    JPanel pnlContain;
    JTextField messageBox;
    JTextArea conversationBox;
    JButton sendButton, sendButtonTool, clearButtonTool;
    JComboBox receiverCombo, senderCombo, receiverComboTool, senderComboTool;
    String[] pList1 = {"Select Sender", "Karty", "Ryan", "Jack1", "Jack2"};
    String[] pList2 = {"Select Receiver", "Karty", "Ryan", "Jack1", "Jack2"};
    JMenuBar menuBar;
    JMenu fileMenu, receiverMenu, senderMenu;
    JMenuItem sendMessageMenuItem, clearMessageMenuItem;
    JToolBar toolBar;
    JRadioButtonMenuItem p1ReceiverRadioButtonMenuItem, p2ReceiverRadioButtonMenuItem, 
                         p3ReceiverRadioButtonMenuItem, p4ReceiverRadioButtonMenuItem,
                         p1SenderRadioButtonMenuItem, p2SenderRadioButtonMenuItem, 
                         p3SenderRadioButtonMenuItem, p4SenderRadioButtonMenuItem;
    ButtonGroup bg1, bg2;
    
    Chatroom c = new Chatroom();
    Message m = new Message();
    Time t = new Time();
    
    public GUI(){
        Container cp = getContentPane();
        
        //Menu Bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        fileMenu = new JMenu("File");
        sendMessageMenuItem = new JMenuItem("Send Message");
        sendMessageMenuItem.addActionListener(this);
        sendMessageMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        
        clearMessageMenuItem = new JMenuItem("Clear Text Box");
        clearMessageMenuItem.addActionListener(this);
        clearMessageMenuItem.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        senderMenu = new JMenu("Change Sender");
        bg1 = new ButtonGroup();
        p1SenderRadioButtonMenuItem = new JRadioButtonMenuItem("Karty");
        p1SenderRadioButtonMenuItem.addActionListener(this);
        p1SenderRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('1', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));   
        
        p2SenderRadioButtonMenuItem = new JRadioButtonMenuItem("Ryan");
        p2SenderRadioButtonMenuItem.addActionListener(this);
        p2SenderRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('2', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        p3SenderRadioButtonMenuItem = new JRadioButtonMenuItem("Jack1");
        p3SenderRadioButtonMenuItem.addActionListener(this);
        p3SenderRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('3', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        p4SenderRadioButtonMenuItem = new JRadioButtonMenuItem("Jack2");
        p4SenderRadioButtonMenuItem.addActionListener(this);
        p4SenderRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('4', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        receiverMenu = new JMenu("Change Receiver");
        bg2 = new ButtonGroup();
        p1ReceiverRadioButtonMenuItem = new JRadioButtonMenuItem("Karty");
        p1ReceiverRadioButtonMenuItem.addActionListener(this);
        p1ReceiverRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('5', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));   
        
        p2ReceiverRadioButtonMenuItem = new JRadioButtonMenuItem("Ryan");
        p2ReceiverRadioButtonMenuItem.addActionListener(this);
        p2ReceiverRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('6', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        p3ReceiverRadioButtonMenuItem = new JRadioButtonMenuItem("Jack1");
        p3ReceiverRadioButtonMenuItem.addActionListener(this);
        p3ReceiverRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('7', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        p4ReceiverRadioButtonMenuItem = new JRadioButtonMenuItem("Jack2");
        p4ReceiverRadioButtonMenuItem.addActionListener(this);
        p4ReceiverRadioButtonMenuItem.setAccelerator(KeyStroke.getKeyStroke('8', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx())); 
        
        //Tool Bar
        toolBar = new JToolBar();
        sendButtonTool = new JButton("Send");  //Tool Bar Send button
        sendButtonTool.addActionListener(this);
        
        clearButtonTool = new JButton("Clear");
        clearButtonTool.addActionListener(this);
        
        senderComboTool = new JComboBox(pList1);
        senderComboTool.addActionListener(this);
        
        receiverComboTool = new JComboBox(pList2);
        receiverComboTool.addActionListener(this);
        
        //Panel Contents
        messageBox = new JTextField(20);    //input text field
        messageBox.addKeyListener(this);
        messageBox.addMouseListener(this);
        
        conversationBox = new JTextArea(20, 40);    //display box
        conversationBox.setEditable(false);
        conversationBox.addMouseListener(this);
        
        sendButton = new JButton("Send");      //Send button
        sendButton.addActionListener(this);
        sendButton.addMouseListener(this);
        
        senderCombo = new JComboBox(pList1);
        senderCombo.addActionListener(this);
        
        receiverCombo = new JComboBox(pList2);
        receiverCombo.addActionListener(this);
        
        addMouseListener(this);
        
        //add to panel
        pnlContain = new JPanel();
        menuBar.add(fileMenu);
        fileMenu.add(sendMessageMenuItem);
        fileMenu.add(clearMessageMenuItem);
        fileMenu.add(senderMenu);
        fileMenu.add(receiverMenu);
        senderMenu.add(p1SenderRadioButtonMenuItem);
        senderMenu.add(p2SenderRadioButtonMenuItem);
        senderMenu.add(p3SenderRadioButtonMenuItem);
        senderMenu.add(p4SenderRadioButtonMenuItem);
        receiverMenu.add(p1ReceiverRadioButtonMenuItem);
        receiverMenu.add(p2ReceiverRadioButtonMenuItem);
        receiverMenu.add(p3ReceiverRadioButtonMenuItem);
        receiverMenu.add(p4ReceiverRadioButtonMenuItem);
        bg1.add(p1SenderRadioButtonMenuItem);
        bg1.add(p2SenderRadioButtonMenuItem);
        bg1.add(p3SenderRadioButtonMenuItem);
        bg1.add(p4SenderRadioButtonMenuItem);
        bg2.add(p1ReceiverRadioButtonMenuItem);
        bg2.add(p2ReceiverRadioButtonMenuItem);
        bg2.add(p3ReceiverRadioButtonMenuItem);
        bg2.add(p4ReceiverRadioButtonMenuItem);
        
        toolBar.add(sendButtonTool);
        toolBar.add(clearButtonTool);
        toolBar.add(senderComboTool);
        toolBar.add(receiverComboTool);
        
        pnlContain.add(toolBar);
        pnlContain.add(messageBox);
        pnlContain.add(sendButton);
        pnlContain.add(conversationBox);
        pnlContain.add(senderCombo);
        pnlContain.add(receiverCombo);
        cp.add(pnlContain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent evt){
        
        //Sender Combo box panel and tool
        if(evt.getSource() == senderCombo || evt.getSource() == senderComboTool){
            JComboBox cb = (JComboBox)evt.getSource();
            String contacts2 = (String)cb.getSelectedItem();
            
            if(contacts2.equals("Karty")){
               c.setSender(c.p1);
               senderCombo.setSelectedIndex(1);
               senderComboTool.setSelectedIndex(1);
               p1SenderRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Ryan")){
               c.setSender(c.p2);
               senderCombo.setSelectedIndex(2);
               senderComboTool.setSelectedIndex(2);
               p2SenderRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Jack1")){
               c.setSender(c.p3);
               senderCombo.setSelectedIndex(3);
               senderComboTool.setSelectedIndex(3);
               p3SenderRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Jack2")){
               c.setSender(c.p4);
               senderCombo.setSelectedIndex(4);
               senderComboTool.setSelectedIndex(4);
               p4SenderRadioButtonMenuItem.setSelected(true);
            }
        }
        
        //Receiver ComboCox panel and tool
        if(evt.getSource() == receiverCombo || evt.getSource() == receiverComboTool){
            JComboBox cb = (JComboBox)evt.getSource();
            String contacts2 = (String)cb.getSelectedItem();
            
            if(contacts2.equals("Karty")){
               c.setReceiver(c.p1);
               receiverCombo.setSelectedIndex(1);
               receiverComboTool.setSelectedIndex(1);
               p1ReceiverRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Ryan")){
               c.setReceiver(c.p2);
               receiverCombo.setSelectedIndex(2);
               receiverComboTool.setSelectedIndex(2);
               p2ReceiverRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Jack1")){
               c.setReceiver(c.p3);
               receiverCombo.setSelectedIndex(3);
               receiverComboTool.setSelectedIndex(3);
               p3ReceiverRadioButtonMenuItem.setSelected(true);
            }
            
            if(contacts2.equals("Jack2")){
               c.setReceiver(c.p4);
               receiverCombo.setSelectedIndex(4);
               receiverComboTool.setSelectedIndex(4);
               p4ReceiverRadioButtonMenuItem.setSelected(true);
            }
        }
        
        //Menu sender radio buttons
        if(evt.getSource() == p1SenderRadioButtonMenuItem){
            c.setSender(c.p1);
            senderCombo.setSelectedIndex(1);
            senderComboTool.setSelectedIndex(1);
        }
        
        if(evt.getSource() == p2SenderRadioButtonMenuItem){
            c.setSender(c.p2);
            senderCombo.setSelectedIndex(2);
            senderComboTool.setSelectedIndex(2);
        }
        
        if(evt.getSource() == p3SenderRadioButtonMenuItem){
            c.setSender(c.p3);
            senderCombo.setSelectedIndex(3);
            senderComboTool.setSelectedIndex(3);
        }
        
        if(evt.getSource() == p4SenderRadioButtonMenuItem){
            c.setSender(c.p4);
            senderCombo.setSelectedIndex(4);
            senderComboTool.setSelectedIndex(4);
        }
        
        //Menu receiver Menu buttons
        if(evt.getSource() == p1ReceiverRadioButtonMenuItem){
            c.setReceiver(c.p1);
            receiverCombo.setSelectedIndex(1);
            receiverComboTool.setSelectedIndex(1);
        }
        
        if(evt.getSource() == p2ReceiverRadioButtonMenuItem){
            c.setReceiver(c.p2);
            receiverCombo.setSelectedIndex(2);
            receiverComboTool.setSelectedIndex(2);
        }
        
        if(evt.getSource() == p3ReceiverRadioButtonMenuItem){
            c.setReceiver(c.p3);
            receiverCombo.setSelectedIndex(3);
            receiverComboTool.setSelectedIndex(3);
        }
        
        if(evt.getSource() == p4ReceiverRadioButtonMenuItem){
            c.setReceiver(c.p4);
            receiverCombo.setSelectedIndex(4);
            receiverComboTool.setSelectedIndex(4);
        }
        
        //send button menu, tool, and panel
        if(evt.getSource() == sendButton || evt.getSource() == sendButtonTool || evt.getSource() == sendMessageMenuItem){
            m.setMessage(messageBox.getText());
            c.sendMessage(c.getReceiver(), m.getMessage());
            messageBox.setText("");
            messageBox.requestFocus();
            conversationBox.append(t.getTime() + " | " + c.getSender().getUsername() + ": " + m.getMessage() + "\n"); 
        }
        
        if(evt.getSource() == clearMessageMenuItem || evt.getSource() == clearButtonTool){
            messageBox.setText("");
        }
    }
    
    //Key listeners
    public void keyPressed(KeyEvent e){
        char keyChar = e.getKeyChar();
        if(keyChar == '"' || keyChar == '\'' || keyChar == ';'){
            sendButton.requestFocus();
        }
    }
    
    public void keyTyped(KeyEvent e){
        char c = e.getKeyChar();
        if(!Character.isLetter(c) && !Character.isDigit(c) && c != ' '){
            e.consume();
        }   
    }
    
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode >= 65 && keyCode <= 90){
            int pos = messageBox.getCaretPosition();
            messageBox.setText(messageBox.getText().toLowerCase());
            messageBox.setCaretPosition(pos);
        }
    }
    
    //Mouse Listeners
    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == sendButton) {
            messageBox.requestFocus();
        } 
        
        if(e.getSource() == messageBox){
            messageBox.setBackground(Color.lightGray);
        }
        
        if(e.getSource() == conversationBox){
            conversationBox.setBackground(Color.lightGray);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() == sendButton) {
            pnlContain.requestFocus();
        } 
        
        if(e.getSource() == messageBox){
            messageBox.setBackground(Color.white);
        }
        
        if(e.getSource() == conversationBox){
            conversationBox.setBackground(Color.white);
        }
    }

    public void mouseClicked(MouseEvent e) {
       
    }
    
    public void receiveMessage(int port){                //server 
        System.out.println("Server Starting...");
        String lineIn;
        
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
                        lineIn = in.nextLine();

                        if (lineIn.trim().equals("END")){
                            done = true;
                        }
                        
                        else{
                            m.setMessage(lineIn);
                            conversationBox.append(t.getTime() + " | " + c.getReceiver().getUsername() + ": " + m.getMessage() + "\n");
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
     
    //Main method
    public static void main(String [] args){
        GUI g = new GUI();
//        Chatroom c = new Chatroom();
        g.setSize(500, 500);
        g.setVisible(true);
        g.receiveMessage(8189); 
    }
}