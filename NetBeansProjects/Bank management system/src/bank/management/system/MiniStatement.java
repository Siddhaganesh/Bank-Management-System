package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1;
    JLabel l1;
    
    MiniStatement(String pinnumber){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);  // Set layout before adding components
        
        l1 = new JLabel();
        l1.setBounds(20, 140, 360, 250);
        add(l1);

        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE pin = '"+pinnumber+"'");
            if(rs.next()) {
                String cardnumber = rs.getString("cardnumber");
                l3.setText("Card Number: " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));
            }
        } catch (Exception e) {
            System.out.println("e");
        }

        // Fetch transactions
        StringBuilder transactions = new StringBuilder("<html>");
        int bal = 0;
        
        try {
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");

            while(rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                transactions.append(date).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(type).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(amount).append("<br>");

                if(rs.getString("type").equals("Deposit")){
                       bal += Integer.parseInt(rs.getString("amount"));
                   }else{
                       bal -= Integer.parseInt(rs.getString("amount"));                   
                   }
            }
            transactions.append("</html>");
            l1.setText(transactions.toString());

            l4.setText("Your total Balance is Rs " + bal);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exit button
        b1 = new JButton("Exit");
        b1.setBounds(150, 500, 100, 25);
        add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
}
