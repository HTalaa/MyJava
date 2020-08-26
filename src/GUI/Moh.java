package GUI;

import javax.swing.*;
import java.awt.*;

public class Moh extends JFrame {
    JButton b1,b2;
    JTextField t1;
    public Moh(){
        b1=new JButton("save");
        b2=new JButton("Show");
        t1=new JTextField();
        this.setTitle("Hamid");
        this.setSize(500,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocation(500,300);
        this.setResizable(false);
        b1.setBounds(40,10,120,25);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.YELLOW);
        this.add(b1);
        b2.setBounds(340,10,120,25);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.YELLOW);
        this.add(b2);
        t1.setBounds(170,50,150,25);
        this.add(t1);
    }
}
