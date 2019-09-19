import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class bai_5 extends JFrame {
    public bai_5(String title)
    {
        setTitle(title);
    }
    public void doShow()
    {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addControl();
        setResizable(false);
        setVisible(true);
    }
    public void addControl()
    {
        JPanel pnBorder=new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth=new JPanel();
        JLabel lblTitle=new JLabel("Giải Phương trình bậc 2");
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth,BorderLayout.NORTH);
        lblTitle.setForeground(Color.BLUE);
        Font ft=new Font("arial", Font.BOLD, 25);
        lblTitle.setFont(ft);

        JPanel pnWest=new JPanel();
        pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
        JButton btnGiai=new JButton("Giải   ");
        JButton btnXoa=new JButton("Xóa   ");
        JButton btnThoat=new JButton("Thoát");
        pnWest.add(btnGiai);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnXoa);
        pnWest.add(Box.createVerticalStrut(10));
        pnWest.add(btnThoat);
        pnBorder.add(pnWest,BorderLayout.WEST);
        pnWest.setBackground(Color.LIGHT_GRAY);

        Border  southborder
                =BorderFactory.createLineBorder(Color.RED);
        TitledBorder southTitleBorder=
                new TitledBorder(southborder, "Chọn thao tác");
        pnWest.setBorder(southTitleBorder);


        JPanel pnCenter=new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnBorder.add(pnCenter,BorderLayout.CENTER);

        Border  centerborder
                =BorderFactory.createLineBorder(Color.RED);
        TitledBorder centerTitleBorder=
                new TitledBorder(centerborder, "nhập 3 số a, b, c:");
        pnCenter.setBorder(centerTitleBorder);

        JPanel pna=new JPanel();
        JLabel lbla=new JLabel("nhập a:");
        final JTextField txta=new  JTextField(15);
        pna.add(lbla);
        pna.add(txta);
        pnCenter.add(pna);

        JPanel pnb=new JPanel();
        JLabel lblb=new JLabel("nhập b:");
        final JTextField txtb=new  JTextField(15);
        pnb.add(lblb);
        pnb.add(txtb);
        pnCenter.add(pnb);

        JPanel pnc=new JPanel();
        JLabel lblc=new JLabel("nhập c:");
        final JTextField txtc=new  JTextField(15);
        pnc.add(lblc);
        pnc.add(txtc);
        pnCenter.add(pnc);





        JPanel pnkq=new JPanel();
        JLabel lblkq=new JLabel("Kết quả:");
        final JTextField txtkq=new  JTextField(15);
        pnkq.add(lblkq);
        pnkq.add(txtkq);
        pnCenter.add(pnkq);

        lbla.setPreferredSize(lblkq.getPreferredSize());
        lblb.setPreferredSize(lblkq.getPreferredSize());
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int ret = JOptionPane.showConfirmDialog(null,"Không thoát được đâu con trai! To be continue","Thoát",JOptionPane.YES_NO_OPTION);
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
                double kq1 = 0;
                if(a == 0){
                    kq = -c/b;
                }else{
                    double delta = b*b - 4*a*c;
                    if(delta < 0){
                        JOptionPane.showConfirmDialog(null,"Phương trình vô nghiệm");

                    }else if(delta == 0){
                        JOptionPane.showConfirmDialog(null,"Phương trình có nghiệm kép");
                         kq = -b/(2*a);
                        txtkq.setText("x" +kq);
                    } else{
                         kq = (-b - Math.sqrt(delta))/(2*a);
                         kq1 = (-b + Math.sqrt(delta))/(2*a);
                        JOptionPane.showConfirmDialog(null,"Phương trình có hai nghiệm là:");
                        txtkq.setText("x1:" + kq+ " "+ "x2:" + kq1);
                    }
                }


            }
        });

        Container con=getContentPane();
        con.add(pnBorder);
    }
    public static void main(String[] args) {
        bai_5 ui=new bai_5("Giải Phương trình bậc 2");
        ui.doShow();
    }
}
