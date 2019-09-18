import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai_5 extends JFrame{
    public bai_5(String title){
        setTitle(title);
    }
    public void doShow(){
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();
        setResizable(false);
        setVisible(true);
    }
    public void addControl(){
        JPanel pnBorder = new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lbTitle = new JLabel("Giải phương trình bậc 2");
        pnNorth.add(lbTitle);
        lbTitle.setForeground(Color.BLUE);
        Font ft = new Font("arial", Font.BOLD, 25);
        lbTitle.setFont(ft);
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
        JButton btnGiai = new JButton("Giải ");
        JButton btnXoa = new JButton("Xóa ");
        JButton btnThoat = new JButton("Thoát");
        pnSouth.add(btnGiai);
        pnSouth.add(Box.createVerticalStrut(10));
        pnSouth.add(btnXoa);
        pnSouth.add(Box.createVerticalStrut(10));
        pnSouth.add(btnThoat);
        pnBorder.add(pnSouth,BorderLayout.SOUTH);
        Border southborder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder southTitleBorder = new TitledBorder(southborder,"Chọn tác vụ");
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnBorder.add(pnCenter,BorderLayout.CENTER);
        Border centerborder = BorderFactory.createLineBorder(Color.RED);
        TitledBorder centerTileBorder = new TitledBorder(centerborder, "Nhập a,b,c");
        pnCenter.setBorder(centerTileBorder);
        JPanel pna = new JPanel();
        JLabel lbla = new JLabel("Nhập a:");
        final JTextField txta = new JTextField(15);
        pna.add(lbla);
        pna.add(txta);
        pnCenter.add(pna);
        JPanel pnb = new JPanel();
        JLabel lblb = new JLabel("Nhập b:");
        final JTextField txtb = new JTextField(15);
        pnb.add(lblb);
        pnb.add(txtb);
        pnCenter.add(pnb);
        JPanel pnc = new JPanel();
        JLabel lblc = new JLabel("Nhập c:");
        final JTextField txtc = new JTextField(15);
        pnc.add(lblc);
        pnc.add(txtc);
        pnCenter.add(pnc);
        JPanel pnkq = new JPanel();
        JLabel lblkq = new JLabel("Kết Quả");
        final JTextField txtkq = new JTextField(15);
        pnkq.add(lblkq);
        pnkq.add(txtkq);
        pnCenter.add(pnkq);
        lbla.setPreferredSize(lblkq.getPreferredSize());
        lblb.setPreferredSize(lblkq.getPreferredSize());
        lblc.setPreferredSize(lblkq.getPreferredSize());
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int ret = JOptionPane.showConfirmDialog(null,"Muốn thoát à con trai?","Thoát",JOptionPane.YES_NO_OPTION);
                if (ret == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txta.setText("");
                txtb.setText("");
                txtc.setText("");
                txtkq.setText("");
                txta.requestFocus();
            }
        });
        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sa = txta.getText();
                int a=0,b=0,c=0;
                try {
                    a = Integer.parseInt(sa);
                }
                catch (Exception ex){
                    JOptionPane.showConfirmDialog(null,"Nhập liệu không hợp lệ!");
                    txta.selectAll();
                    txta.requestFocus();
                    return;
                }
                String sb = txtb.getText();
                try{
                    b = Integer.parseInt(sb);
                }
                catch(Exception ex){
                    JOptionPane.showConfirmDialog(null,"Nhập liệu không hợp lệ!");
                    txtb.selectAll();
                    txtc.requestFocus();
                    return;
                }
                String sc = txtc.getText();
                try{
                    c = Integer.parseInt(sc);
                }
                catch(Exception ex)
                {
                    JOptionPane.showConfirmDialog(null,"Nhập liệu không hợp lệ!");
                    txtc.selectAll();
                    txtc.requestFocus();
                    return;
                }
                double kq = 0;
                if(a == 0){
                    kq = -c/b;
                }else{
                    double delta = b*b - 4*a*c;
                    if(delta<0){
                        JOptionPane.showConfirmDialog(null,"Phương trình vô nghiệm");

                    }else if(delta==0){
                        double x = -b/(2*a);
                        JOptionPane.showConfirmDialog(null,"Phương trình có nghiệm kép");
                        double x1 = (-b - Math.sqrt(delta))/(2*a);
                        double x2 = (-b + Math.sqrt(delta))/(2*a);
                        JOptionPane.showConfirmDialog(null,"Phương trình có hai nghiệm là:");
                        kq = x1;kq = x2;
                    }
                }
            }
        });
    }
    public static void main(String[] args){
        bai_5  ui = new bai_5("Giải phương trình bậc 2");
        ui.doShow();
    }

}