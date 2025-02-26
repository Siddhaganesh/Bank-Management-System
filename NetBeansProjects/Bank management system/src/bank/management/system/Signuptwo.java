
package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class Signuptwo extends JFrame implements ActionListener {
    
    long random;
    JTextField pan,adhaar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    Signuptwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - PAGE : 2");
        
        
        JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
        AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AdditionalDetails.setBounds(290, 80, 400, 40);
        add(AdditionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"OC","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);

        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"Null","<150000","<250000","<500000","upto 1000000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.white);
        add(income);
       
        
        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String eduvalues[] = {"Non-grad","UG","PG","Doctorate","10/12","Other"};
        education = new JComboBox(eduvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);
 
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occvals[] = {"Salaried","Self","Business","Student","Retired","Other"};
        occupation = new JComboBox(occvals);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);        
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel ad = new JLabel("Adhaar:");
        ad.setFont(new Font("Raleway", Font.BOLD, 22));
        ad.setBounds(100, 490, 200, 30);
        add(ad);
        
        adhaar = new JTextField();
        adhaar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhaar.setBounds(300, 490, 400, 30);
        add(adhaar);
        
        JLabel state = new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        JLabel pincode = new JLabel("Existing account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
 
            String sreligion = (String)religion.getSelectedItem();
            String scategory = (String)category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String seniorcitizen = null;

        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        String span = (pan.getText().isEmpty()) ? null : pan.getText();
        String sadhaar = (adhaar.getText().isEmpty()) ? null : adhaar.getText();

 
        try{
          
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"','"+span+"', '"+sadhaar+"','"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                //signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    public static void main(String args[]){
        new Signuptwo("");
    }
}
