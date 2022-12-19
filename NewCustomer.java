
package electricty.billing.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class NewCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,taddress,tstate,tcity, tfemail,tfphone;
    JButton next,cancel;
    JLabel lblmeter;
    
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Times New Roman",Font.BOLD, 24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        heading.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100,120,100,20);
        heading.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblmeterno);
        
        lblmeter = new JLabel("");
        lblmeter.setBounds(240,120,100,20);
        p.add(lblmeter);
         
        Random ran= new Random();
        long number = ran.nextLong()% 1000000;
        lblmeter.setText("" + Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100,160,100,20);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lbladdress);
        
        taddress = new JTextField();
        taddress.setBounds(240,160,200,20);
        p.add(taddress);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100,200,100,20);
        lblcity.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblcity);
        
        tcity = new JTextField();
        tcity.setBounds(240,200,200,20);
        p.add(tcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100,240,100,20);
        lblstate.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblstate);
        
        tstate = new JTextField();
        tstate.setBounds(240,240,200,20);
        p.add(tstate);
        
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(100,280,100,20);
        lblemail.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(100,320,100,20);
        lblphone.setFont(new Font("Tahoma",Font.BOLD, 12));
        p.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);
        
        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground( Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel = new JButton("Back");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground( Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(215,330,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
         
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
        
           public void actionPerformed(ActionEvent ae)
           {
            if  (ae.getSource()== next){
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address = taddress.getText();
            String city = tcity.getText();
            String state = tstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";
            
                
             try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
                // new frame
                new MeterInfo(meter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[]args){
        new NewCustomer();
    }
    
}
