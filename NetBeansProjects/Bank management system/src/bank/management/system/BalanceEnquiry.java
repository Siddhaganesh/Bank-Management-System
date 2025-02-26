package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1, l3;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        
        this.pinnumber = pinnumber;
        setLayout(null);

        // Load Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        l3 = new JLabel(i3); // Corrected: Using the global l3 variable
        l3.setBounds(0, 0, 900, 900);
        add(l3);

        // Balance Label
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170, 300, 400, 30);
        l3.add(l1);

        // Back Button
        b1 = new JButton("BACK");
        b1.setBounds(355, 520, 150, 30);
        l3.add(b1);
        b1.addActionListener(this);

        // Fetch Balance from Database
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);  // Corrected: Printing the exception for debugging
        }

        // Set Balance Text
        l1.setText("Your Current Account Balance is Rs " + balance);

        // Frame Properties
        setSize(900, 900);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
