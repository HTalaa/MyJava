package Java8;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoublePredicate;
import java.util.function.IntConsumer;


public class Beeper {
    public static void main(String[] args) {
        Timer t = new Timer(1000, k -> Toolkit.getDefaultToolkit().beep());
        t.start();
        JOptionPane.showConfirmDialog(null,null);
        t.stop();
        IntConsumer c=(i-> System.out.println(i*10));
        c.accept(15);

        doSomeThing(10.2,v->(v>12)&&(v<20));

    }
    static void doSomeThing(double a, DoublePredicate p){
        System.out.println(p.test(a));

    }
}
