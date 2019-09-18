import javax.swing.*;
import java.awt.*;


public class bai_2 {
    JFrame frame = new JFrame("FlowLayout demo");
    JPanel panel = new JPanel();
    JButton btn1 = new JButton("FlowLayout");
    JButton btn2 = new JButton("Add các control");
    JButton btn3 = new JButton("Trên 1 dòng");
    JButton btn4 = new JButton("Hết chỗ chứa");
    JButton btn5 = new JButton("Thì xuống dòng");

    public bai_2() {
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.PINK);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bai_2();
            }
        });
    }

}