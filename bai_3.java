import javax.swing.*;
import java.awt.*;


public class bai_3 {
    JFrame frame = new JFrame("BoxLayout");
    JPanel panel = new JPanel();
    JButton buttonFirst = new JButton("BoxLayout");
    JButton buttonSecond = new JButton("X_AXIS");
    JButton buttonThird = new JButton("Y_AXIS");

    public bai_3() {
        panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));
        buttonFirst.setBackground(Color.RED);
        panel.add(buttonFirst);
        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonSecond.setBackground(Color.BLUE);
        panel.add(buttonSecond);
        panel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonThird.setBackground(Color.YELLOW);
        panel.add(buttonThird);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bai_3();
            }
        });
    }

}