import javax.swing.*;

public class bai_1 extends JFrame {
    public bai_1(){
        super("Demo Windows");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public static void main(String[] args){
        bai_1 ui = new bai_1();
        ui.setSize(400,300);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }
}
