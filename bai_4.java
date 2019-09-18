import javax.swing.*;
import java.awt.*;

public class bai_4 {

    JFrame frame = new JFrame("BorderLayout demo");
    JButton btn1 = new JButton("NORTH");
    JButton btn2 = new JButton("SOUTH");
    JButton btn3 = new JButton("CENTER");
    JButton btn4 = new JButton("WEST");
    JButton btn5 = new JButton("EAST");

    public bai_4() {
        frame.setLayout(new BorderLayout());
        frame.add(btn1, BorderLayout.NORTH);
        btn1.setBackground(Color.RED);
        frame.add(btn2, BorderLayout.SOUTH);
        btn2.setBackground(Color.RED);
        frame.add(btn3, BorderLayout.CENTER);
        btn3.setBackground(Color.YELLOW);
        frame.add(btn4, BorderLayout.WEST);
        btn4.setBackground(Color.BLUE);
        frame.add(btn5, BorderLayout.EAST);
        btn5.setBackground(Color.BLUE);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bai_4();
            }
        });
    }

}