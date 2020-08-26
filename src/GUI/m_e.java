package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class m_e extends JFrame {
    JPanel p1,p2;
    JLabel l1,l2;

    public m_e(){
        this.setSize(300,500);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setResizable(false);
        this.setLocation(100,50);
        this.setVisible(true);
        p1=new JPanel();
        p2=new JPanel();
        l1=new JLabel("welcome1 ");
        l2=new JLabel("welcome2 ");
        p1.setBackground(Color.RED);
        p2.setBackground(Color.blue);
        this.add(p1);
        this.add(p2);
        l1.setBounds(100,50,100,25);
        l2.setBounds(100,50,100,25);
        l1.setForeground(Color.YELLOW);
        l2.setForeground(Color.YELLOW);
        p1.setLayout(null);
        p1.add(l1);
        p2.setLayout(null);
        p2.add(l2);
        //p1.addMouseListener(m);
        //p2.addMouseListener(m);
        p1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }


}
