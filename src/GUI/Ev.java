package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ev extends JFrame implements ItemListener {
    int x=100,y=20;
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JPanel p1,p2,p3;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup g1=new ButtonGroup();
    JCheckBox c1,c2,c3;
    vn v=new vn();

    public Ev(){
        this.setSize(300,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(100,100);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        l1=new JLabel("full name");
        l2=new JLabel("password");
        l3=new JLabel();
        b1=new JButton("save");
        b2=new JButton("show");
        b3=new JButton("left");
        b4=new JButton("right");
        b5=new JButton("min");
        b6=new JButton("max");
        c1=new JCheckBox("bold");
        c2=new JCheckBox("serif");
        c3=new JCheckBox("plain");
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        r1=new JRadioButton("red");
        r2=new JRadioButton("blue");
        r3=new JRadioButton("yellow");
        r4=new JRadioButton("green");


        p1.setBackground(Color.RED);
        p2.setBackground(Color.YELLOW);
        p3.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(3,1));
        this.add(p1);
        this.add(p2);
        this.add(p3);
        p1.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);
        l1.setBounds(30,10,100,25);
        l2.setBounds(30,50,100,25);
        t1.setBounds(120,10,150,25);
        t2.setBounds(120,50,150,25);
        b1.setBounds(50,100,75,25);
        b2.setBounds(150,100,75,25);
        p1.add(l1);
        p1.add(l2);
        p1.add(t1);
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);
        t3.setBounds(30,30,220,25);
        r1.setBounds(5,70,50,25);
        r2.setBounds(60,70,50,25);
        r3.setBounds(115,70,60,25);
        r4.setBounds(180,70,60,25);
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);

        p2.add(t3);
        p2.add(r1);
        p2.add(r2);
        p2.add(r3);
        p2.add(r4);

        l3.setBounds(x,30,220,25);
        l3.setFont(new Font("italic",Font.BOLD,y));
        c1.setBounds(20,50,75,25);
        c2.setBounds(110,50,75,25);
        c3.setBounds(200,50,75,25);
        b3.setBounds(5,100,55,25);
        b4.setBounds(65,100,70,25);
        b5.setBounds(140,100,70,25);
        b6.setBounds(215,100,67,25);
        p3.add(l3);
        p3.add(c1);
        p3.add(c2);
        p3.add(c3);
        p3.add(b3);
        p3.add(b4);
        p3.add(b5);
        p3.add(b6);
        b1.addActionListener(v);

        b2.addActionListener(v);
        b3.addActionListener(v);
        b4.addActionListener(v);
        b5.addActionListener(v);
        b6.addActionListener(v);
        r1.addActionListener(v);
        r2.addActionListener(v);
        r3.addActionListener(v);
        r4.addActionListener(v);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(c1.isSelected()){
            l3.setFont(new Font("italic",Font.BOLD+Font.PLAIN,y));
        }
        else if(c2.isSelected()){
            l3.setFont(new Font("italic",Font.ROMAN_BASELINE,y));
        }
        else if(c3.isSelected()){
            l3.setFont(new Font("italic",Font.HANGING_BASELINE,y));
        }
    }

    private class vn implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String ss1="";
            String ss2="";
            if(e.getSource()==b1){
                ss1=t1.getText();
                ss2=t2.getText();
                System.out.println(ss1+"  "+ss2);
                t1.setText("");
                t2.setText("");
            }
            if(e.getSource()==b2){
                ss1=t1.getText();
                ss2=t2.getText();
                t3.setText(ss1+" "+ss2);
                l3.setText("welcome "+ss1);
                t1.setText("");
                t2.setText("");

            }
            if(e.getSource()==r1){
                p2.setBackground(Color.RED);
                t3.setForeground(Color.RED);
                l3.setForeground(Color.RED);
            }
            if(e.getSource()==r2){
                p2.setBackground(Color.blue);
                t3.setForeground(Color.blue);
                l3.setForeground(Color.blue);
            }
            if(e.getSource()==r3){
                p2.setBackground(Color.yellow);
                t3.setForeground(Color.yellow);
                l3.setForeground(Color.yellow);
            }
            if(e.getSource()==r4){
                p2.setBackground(Color.green);
                t3.setForeground(Color.green);
                l3.setForeground(Color.green);
            }
            if(e.getSource()==b3){
                x+=5;
                l3.setBounds(x,y,220,25);
            }
            if(e.getSource()==b4){
                x-=5;
                l3.setBounds(x,y,220,25);
            }
            if(e.getSource()==b5){
                y+=2;
                l3.setFont(new Font("italic",Font.BOLD,y));
            }
            if(e.getSource()==b6){
                y-=2;
                l3.setFont(new Font("italic",Font.BOLD,y));
            }
        }
    }
}

