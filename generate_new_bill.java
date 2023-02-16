import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import escpos.EscPos;
import escpos.EscPos.CharacterCodeTable;
import escpos.EscPosConst;
import escpos.Style;
import escpos.barcode.BarCode;
import escpos.barcode.BarCodeWrapperInterface;
import escpos.barcode.QRCode;
import escpos.image.BitImageWrapper;
import escpos.image.BitonalOrderedDither;
import escpos.image.BitonalThreshold;
import escpos.image.EscPosImage;
import escpos.image.GraphicsImageWrapper;
import escpos.image.ImageWrapperInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.print.PrintService;
import output.PrinterOutputStream;


public class generate_new_bill extends javax.swing.JFrame implements ActionListener {

    ArrayList<cart> al = new ArrayList<>();
    mytablemodel tm = new mytablemodel();
    int total = 0;

    public generate_new_bill() {

        initComponents();
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setModel(tm);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        setTitle("Generate New Bill");
        setVisible(true);
        arrayloader();
    }

    void arrayloader() {
        try {
            int y = 10, i = 0;
            pan.removeAll();
            ResultSet rs = DBLoader.exexuteSQL("select * from category");
            while (rs.next()) {
                i++;
                String category_name = rs.getString("category_name");
                String photo = rs.getString("photo");
                categorydesign obj = new categorydesign();
                ImageIcon i1 = new ImageIcon(photo);
                Image img = i1.getImage().getScaledInstance(obj.lb1.getWidth(), obj.lb1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i2 = new ImageIcon(img);
                obj.lb1.setIcon(i2);
                obj.lb2.setText(category_name);
                obj.setBounds(10, y, 200, 200);
                obj.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        loadProduct(category_name);
                    }

                });
                pan.add(obj);
                y = y + 250;
                pan.repaint();
                obj.repaint();
            }
            int nn = 250 * i;
            pan.setPreferredSize(new Dimension(220, nn));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void loadProduct(String category_name) {
        try {
            pan1.removeAll();
            int y = 10, j = 0;
            ResultSet rs = DBLoader.exexuteSQL("select * from products where category_name='" + category_name + "'");
            while (rs.next()) {
                j++;
                int product_id = rs.getInt("product_id");
                String photo = rs.getString("photo");
                String product_name = rs.getString("product_name");
                String brand = rs.getString("brand");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int offerprice = rs.getInt("offerprice");
                productdesign obj = new productdesign();
                ImageIcon i = new ImageIcon(photo);
                Image img = i.getImage().getScaledInstance(obj.lb1.getWidth(), obj.lb1.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon i2 = new ImageIcon(img);
                obj.lb1.setIcon(i2);
                obj.lb2.setText(product_name);
                obj.lb3.setText("Description: " + description);
                obj.lb4.setText("Brand: " + brand);
                obj.lb5.setText("price: " + price + "");
                obj.lb6.setText("Offer Price: " + offerprice + "");
//                obj.bt.addActionListener(this);
                obj.bt.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        add_to_cart(product_id);
                    }

                });
                obj.setBounds(10, y, 300, 350);
                y = y + 370;
                pan1.add(obj);
                pan1.repaint();
                obj.repaint();
            }
            int ss = 370 * j;
            pan1.setPreferredSize(new Dimension(300, ss));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void add_to_cart(int id) {

        String ans = JOptionPane.showInputDialog(this, "Enter Quantity");
        System.out.println(ans);
        int quantity = Integer.parseInt(ans);
        try {
            ResultSet rs = DBLoader.exexuteSQL("Select * from products where product_id='" + id + "' ");
            if (rs.next()) {
                String product_name = rs.getString("product_name");
                String brand = rs.getString("brand");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                int offerprice = rs.getInt("offerprice");
                al.add(new cart(product_name, brand, description, price, offerprice, quantity));

                total += (offerprice * quantity);
                global.total_amount = total;
//                    String total_amount = String.valueOf(total);
                amountlb.setText(total + "");

            }
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public String getColumnName(int j) {
            String c[] = {"Product_name", "Brand", "Description", "Price", "Offer Price", "Quantity"};
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            cart ct = al.get(i);
            if (j == 0) {
                return ct.product_name;
            } else if (j == 1) {
                return ct.brand;
            } else if (j == 2) {
                return ct.description;
            } else if (j == 3) {
                return ct.price;
            } else if (j == 4) {
                return ct.offerprice;
            } else {
                return ct.quantity;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pan1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        amountlb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bg_generate_new_bill = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pan.setBackground(new java.awt.Color(0, 0, 0));
        pan.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panLayout = new javax.swing.GroupLayout(pan);
        pan.setLayout(panLayout);
        panLayout.setHorizontalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        panLayout.setVerticalGroup(
            panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 300, 740);

        pan1.setBackground(new java.awt.Color(0, 0, 0));
        pan1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pan1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(330, 50, 330, 740);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(680, 60, 800, 650);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ITEMS IN CART");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(790, 0, 380, 50);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Print Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(750, 730, 180, 50);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Settle Bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1050, 730, 160, 50);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL PAYABLE AMOUNT");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(890, 490, 150, 16);

        amountlb.setForeground(new java.awt.Color(255, 255, 255));
        amountlb.setText("0");
        getContentPane().add(amountlb);
        amountlb.setBounds(1080, 490, 110, 16);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CATEGORY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 0, 250, 50);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRODUCTS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(340, 0, 260, 50);

        bg_generate_new_bill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3.jpg"))); // NOI18N
        getContentPane().add(bg_generate_new_bill);
        bg_generate_new_bill.setBounds(0, 0, 1500, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (al.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No item added in cart");
        } else {
            settleBill obj = new settleBill(al);
            obj.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        printBill();
        setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(generate_new_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generate_new_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generate_new_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generate_new_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generate_new_bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountlb;
    private javax.swing.JLabel bg_generate_new_bill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pan;
    private javax.swing.JPanel pan1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
//        printBill();
    }
    
    void printBill() {
        try {
            
            PrintService printService = PrinterOutputStream.getPrintServiceByName("THERMAL Receipt Printer");
            PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
            EscPos escpos = new EscPos(printerOutputStream);
            Style header = new Style()
                    .setFontSize(Style.FontSize._2, Style.FontSize._2)
                    .setJustification(EscPosConst.Justification.Center)
                    .setBold(true)
                    .setColorMode(Style.ColorMode.WhiteOnBlack);

            Style address = new Style()
                    .setFontName(Style.FontName.Font_A_Default)
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);
            escpos.writeLF(header, " Point Of Sale ");
            escpos.writeLF(address, "SCO-108, Ranjeet Avenue");
            escpos.writeLF(address, "+918725983606");
//            escpos.writeLF(address, "GSTIN : 23AADGS334SDZDT");
//            escpos.writeLF(address, "Vat No : 94832848349");
            escpos.writeLF(address, "29-06-2022");
            escpos.writeLF(address, "Counter No. 120");
            escpos.writeLF(address, "    ");
            escpos.writeLF(address, "    ");

//            QRCode qrCode = new QRCode()
//                    .setSize(5)
//                    .setModel(QRCode.QRModel._2)
//                    .setJustification(EscPosConst.Justification.Center);
//
//            escpos.write(qrCode, "QR Code");
//
//            escpos.writeLF(address, "    ");
//            BarCode barcode = new BarCode();
//            barcode.setJustification(EscPosConst.Justification.Center);
//            barcode.setHRIPosition(BarCode.BarCodeHRIPosition.BelowBarCode);
//            escpos.write(barcode, "7239409840");
//            escpos.writeLF(address, "    ");
//            GraphicsImageWrapper imageWrapper = new GraphicsImageWrapper();
//            imageWrapper.setJustification(EscPosConst.Justification.Center);
//            
//            BitonalThreshold bod = new BitonalThreshold();
//            BufferedImage bimg = ImageIO.read(new File("src/images/goku.png"));
//            EscPosImage escPos = new EscPosImage(bimg, bod);
//            escpos.write(imageWrapper, escPos);
//
////            BitonalThreshold bt = new BitonalThreshold();
            Style lineStyle = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

            escpos.writeLF(lineStyle, "----------------------------------------");

            Style rightText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Right);

            Style leftText = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Left_Default);

//            escpos.writeLF(rightText, "Bill No : " + 1);

            escpos.write(leftText, "Cashier: cashier1      ");
            escpos.write(rightText, "TYPE : TAKE AWAY    ");
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF(lineStyle, "----------------------------------------");

            escpos.writeLF(leftText, "Items");
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.write(leftText, "Item        Rate     Qty        Price     ");
            escpos.writeLF(lineStyle, "----------------------------------------");
            System.out.println("Details");
            for (cart c : al) {
                escpos.write(leftText, c.product_name + "        " + c.offerprice + "     " + c.quantity + "           " + total+"       ");
//                System.out.println(c.product_name + "       " + c.price + " " + c.quantity + "  " + c.totalprice);

            }
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF(leftText, "        Total Amount    " + global.total_amount);
            escpos.writeLF(lineStyle, "----------------------------------------");
            escpos.writeLF(lineStyle, "----------------------------------------");

            escpos.feed(5);
            escpos.cut(EscPos.CutMode.PART);
            escpos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
