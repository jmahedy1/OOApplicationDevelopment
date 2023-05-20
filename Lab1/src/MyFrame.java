import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    Person p = new Person();
    JPanel pnlContain;
    JTextField txtFirstName, txtLastName, txtPUID, txtEmail, txtPhoneNumber;
    JLabel lblFirstName, lblLastName, lblPUID, lblEmail, lblPhoneNumber, lblResult;
    JButton btnSave, btnClear, btnRecall;
    
    public MyFrame(){
        Container cp = getContentPane();
        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField(20);
        
        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField(20);

        lblPUID = new JLabel("PUID: ");
        txtPUID = new JTextField(20);

        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(20);

        lblPhoneNumber = new JLabel("Phone Number: ");
        txtPhoneNumber = new JTextField(20);
        
        lblResult = new JLabel("");

        btnSave = new JButton("Save");
        btnSave.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);

        btnRecall = new JButton("Recall");
        btnRecall.addActionListener(this);
        
        pnlContain = new JPanel();
        pnlContain.add(lblFirstName);
        pnlContain.add(txtFirstName);

        pnlContain.add(lblLastName);
        pnlContain.add(txtLastName);

        pnlContain.add(lblPUID);
        pnlContain.add(txtPUID);

        pnlContain.add(lblEmail);
        pnlContain.add(txtEmail);

        pnlContain.add(lblPhoneNumber);
        pnlContain.add(txtPhoneNumber);

        pnlContain.add(lblResult);
        pnlContain.add(btnSave);
        pnlContain.add(btnClear);
        pnlContain.add(btnRecall);
        cp.add(pnlContain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == btnSave){
            lblResult.setText("Pressed the Save button!");
            p.setFirstName(txtFirstName.getText());
            p.setLastName(txtLastName.getText());
            p.setPUID(txtPUID.getText());
            p.setEmail(txtEmail.getText());
            p.setPhoneNumber(txtPhoneNumber.getText());

        }

        if(evt.getSource() == btnClear){
            lblResult.setText("Pressed the Cancel button!");
            txtFirstName.setText("");
            txtLastName.setText("");
            txtPUID.setText("");
            txtEmail.setText("");
            txtPhoneNumber.setText("");
            txtFirstName.requestFocus();
        }

        if(evt.getSource() == btnRecall){
            lblResult.setText("Pressed the Recall button!");
            txtFirstName.setText(p.getFirstName());
            txtLastName.setText(p.getLastName());
            txtPUID.setText(p.getPUID());
            txtEmail.setText(p.getEmail());
            txtPhoneNumber.setText(p.getPhoneNumber());
        }
    }
    
    public static void main(String [] args){
        MyFrame my = new MyFrame();
        my.setSize(290, 400);
        my.setVisible(true);
    }
}