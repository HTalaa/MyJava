package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Bn extends JFrame {
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JTextField t1=new JTextField();
    JButton b1=new JButton("  1  ");
    JButton b2=new JButton("  2  ");
    JButton b3=new JButton("  3  ");
    JButton b4=new JButton("  4  ");
    JButton b5=new JButton("  5  ");
    JButton b6=new JButton("  6  ");
    JButton b7=new JButton("  7  ");
    JButton b8=new JButton("  8  ");
    JButton b9=new JButton("  9  ");
    JButton b10=new JButton("  0  ");
    JButton b11=new JButton("  +  ");
    JButton b12=new JButton("  =  ");

    public Bn(){
        this.setTitle("BN");
        this.setSize(300,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        p1.setBackground(Color.RED);
        p2.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(2,1));
        p1.setLayout(null);
        t1.setBounds(50,100,200,50);
        p1.add(t1);
        p2.setLayout(new GridLayout(3,4,2,2));
        this.add(p1);
        this.add(p2);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);
        p2.add(b11);
        p2.add(b12);
    }
}
