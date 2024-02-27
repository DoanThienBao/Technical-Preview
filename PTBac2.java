package teamhomework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PTBac2 extends JFrame {

    private JPanel pnA, pnB, pnC, pnD ; 
    private JTextField txtA, txtB, txtC, txtKQ;

    public PTBac2(String title) throws HeadlessException {
        super(title);
        initUI();
    }

    private void initUI() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        

        //giao diện trên
        JPanel pnBorder = new JPanel(new BorderLayout(2, 2));
        JPanel pnNorth = new JPanel();
        pnNorth.setBackground(Color.RED);
        JLabel lblTittle = new JLabel("Giải Phương Trinh Bậc 2");
        Font fTittle = new Font("Tahoma", Font.BOLD, 24);
        pnNorth.add(lblTittle);

        //giao diện dưới
        JPanel pnSouth = new JPanel();
        Border bdSouth = BorderFactory.createLineBorder(Color.PINK, 3);
        pnSouth.setBorder(bdSouth);
        JButton btnGiai = new JButton("Giải");
        JButton btnXoa = new JButton("Xóa Hét");
        JButton btnThoat = new JButton("Thoát");
        pnSouth.add(btnGiai);
        pnSouth.add(btnXoa);
        pnSouth.add(btnThoat);

        //giao diện ở giữa
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        Border bdCenter = BorderFactory.createLineBorder(Color.RED, 3);
        TitledBorder titleCenter = new TitledBorder(bdCenter, "Nhập b,c,a:");
        pnCenter.setBorder(titleCenter);
        // Tạo biến pnA, pnB, pnC và thêm chúng vào pnCenter
        pnA = new JPanel();
        pnA.add(new JLabel("a:"));
        txtA = new JTextField(10);
        pnA.add(txtA);

        pnB = new JPanel();
        pnB.add(new JLabel(": b"));
        txtB = new JTextField(16);
        pnB.add(txtB);

        pnC = new JPanel();
        pnC.add(new JLabel("c    :"));
        txtC = new JTextField(13);
        pnC.add(txtC);

        pnCenter.add(pnA);
        pnCenter.add(pnB);
        pnCenter.add(pnC);

        //giao diện kết quả
        JLabel lblKetQua = new JLabel("Kết quả:");
        JPanel pnKQ = new JPanel();
        pnKQ.add(lblKetQua);
        pnCenter.add(pnKQ);
        txtKQ = new JTextField(0);
        txtKQ.setEditable(false);
        pnCenter.add(txtKQ);
        //...
        pnBorder.add(pnNorth, BorderLayout.NORTH);
        pnBorder.add(pnSouth, BorderLayout.SOUTH);
        pnBorder.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBorder);

        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaiPhuongTrinhBac2();
            }
        });
    }

    private void giaiPhuongTrinhBac2() {
        try {
            // Lấy giá trị a, b, c từ các JTextField
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            // Gọi phương thức giải phương trình bậc 2
            double[] ketQua = giaiPhuongTrinh(a, b, c);

            // Hiển thị kết quả trên JTextField txtKQ
            if (ketQua != null) {
                txtKQ.setText("x1 = " + ketQua[0] + ", x2 = " + ketQua[1]);
            } else {
                txtKQ.setText("Phuong trinh vo nghiem");
            }
        } catch (NumberFormatException ex) {
            txtKQ.setText("Nhap sai dinh dang");
        }
    }

    private double[] giaiPhuongTrinh(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return null; // Phương trình vô nghiệm
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return new double[]{x, x}; // Phương trình có nghiệm kép
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{x1, x2}; // Phương trình có 2 nghiệm phân biệt
        }
    }

    public static void main(String[] args) {
        new PTBac2("Giai Phuong Trinh Bac 2").setVisible(true);
    }
}
