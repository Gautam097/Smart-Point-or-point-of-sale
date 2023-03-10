
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class manage_product extends javax.swing.JFrame {

    ArrayList<product> al = new ArrayList<>();
    mytablemodel tm = new mytablemodel();

    JFileChooser jfc;
    String Path;

    public manage_product() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadCategory();
        getContentPane().setBackground(Color.black);
        setSize(1500, 1000);
        setTitle("Manage Products");
        setVisible(true);
        jTable1.setModel(tm);
        jTable1.setRowHeight(90);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
        viewProduct();
    }
    
    
    
    public class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 8;
        }

        @Override
        public String getColumnName(int j) {
            String p[] = {"product id", "product name", "brand", "description", "category name", "price", "offerprice", "photo"};
            return p[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            product pt = al.get(i);
            if (j == 0) {
                return pt.product_id;
            } else if (j == 1) {
                return pt.product_name;
            } else if (j == 2) {
                return pt.brand;
            } else if (j == 3) {
                return pt.description;
            } else if (j == 4) {
                return pt.category_name;
            } else if (j == 5) {
                return pt.price;
            } else if (j == 6) {
                return pt.offerprice;
            } else {
                return pt.photo;
            }
        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lb = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                ImageIcon img = new ImageIcon(al.get(row).photo);
                Image im = img.getImage();
                Image newimg = im.getScaledInstance(60, 80, Image.SCALE_SMOOTH);
                lb.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return lb;

        }

    }
    
    void viewProduct() {
        try {
            al.clear();
            ResultSet rs = DBLoader.exexuteSQL("select * from products");
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String brand = rs.getString("brand");
                String description = rs.getString("description");
                String category_name = rs.getString("category_name");
                int price = rs.getInt("price");
                int offerprice = rs.getInt("offerprice");
                String photo = rs.getString("photo");
                al.add(new product(product_id, product_name, brand, description, category_name, price, offerprice, photo));
            }
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void loadCategory() {
        try {
            ResultSet rs = DBLoader.exexuteSQL("select * from category");
            while (rs.next()) {
                afield1.addItem(rs.getString("category_name"));
                cb2.addItem(rs.getString("category_name"));
            }
        } catch (Exception e) {
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

        heading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        afield1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        afield2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        afield7 = new javax.swing.JButton();
        afield3 = new javax.swing.JTextField();
        afield4 = new javax.swing.JTextField();
        afield5 = new javax.swing.JTextField();
        afield6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        photolb = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb2 = new javax.swing.JComboBox<>();
        bg_manage_product = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        heading.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("ADD PRODUCTS");
        heading.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                headingAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(heading);
        heading.setBounds(10, 0, 420, 50);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIEW PRODUCTS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(630, 0, 440, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category_name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 160, 50);

        afield1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        afield1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select" }));
        afield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afield1ActionPerformed(evt);
            }
        });
        getContentPane().add(afield1);
        afield1.setBounds(220, 70, 140, 31);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product_name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 120, 140, 40);

        afield2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        afield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afield2ActionPerformed(evt);
            }
        });
        getContentPane().add(afield2);
        afield2.setBounds(190, 120, 230, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Brand Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 180, 120, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 230, 130, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 290, 130, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Offer Price");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 360, 140, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Photo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 430, 140, 40);

        afield7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        afield7.setText("Browse...");
        afield7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afield7ActionPerformed(evt);
            }
        });
        getContentPane().add(afield7);
        afield7.setBounds(190, 430, 200, 40);

        afield3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(afield3);
        afield3.setBounds(190, 180, 230, 40);

        afield4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(afield4);
        afield4.setBounds(190, 230, 230, 40);

        afield5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(afield5);
        afield5.setBounds(190, 290, 230, 40);

        afield6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        afield6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afield6ActionPerformed(evt);
            }
        });
        getContentPane().add(afield6);
        afield6.setBounds(190, 360, 230, 40);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(530, 170, 700, 400);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(90, 600, 130, 40);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(770, 592, 140, 40);

        photolb.setText("photo");
        getContentPane().add(photolb);
        photolb.setBounds(90, 490, 140, 90);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select Category");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(620, 110, 180, 40);

        cb2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb2ItemStateChanged(evt);
            }
        });
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2);
        cb2.setBounds(840, 110, 130, 30);

        bg_manage_product.setBackground(new java.awt.Color(255, 255, 255));
        bg_manage_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/product.jpg"))); // NOI18N
        getContentPane().add(bg_manage_product);
        bg_manage_product.setBounds(0, 0, 1500, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afield2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afield2ActionPerformed

    private void afield7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afield7ActionPerformed
        jfc = new JFileChooser("D://");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
        jfc.setFileFilter(filter);
        int ans = jfc.showOpenDialog(this);

        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            Path = f.getPath();
            ImageIcon ic = new ImageIcon(f.getPath());
            Image img = ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            photolb.setIcon(ic1);
        } else {
            JOptionPane.showMessageDialog(this, "Cancelled!!");
        }
    }//GEN-LAST:event_afield7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addProduct();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteProduct();
        viewProduct();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed

    }//GEN-LAST:event_cb2ActionPerformed

    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
        String getItem = (String) cb2.getSelectedItem();
        System.out.println(getItem);
        viewFilteredProducts(getItem);
    }//GEN-LAST:event_cb2ItemStateChanged

    private void afield6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afield6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afield6ActionPerformed

    private void afield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afield1ActionPerformed

    private void headingAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_headingAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_headingAncestorAdded

    void viewFilteredProducts(String Item) {
        if (Item != "Select") {
            try {
                al.clear();
                ResultSet rs = DBLoader.exexuteSQL("select * from products where category_name ='" + Item + "' ");
                while (rs.next()) {
                    int product_id = rs.getInt("product_id");
                    String product_name = rs.getString("product_name");
                    String brand = rs.getString("brand");
                    String description = rs.getString("description");
                    String category_name = rs.getString("category_name");
                    int price = rs.getInt("price");
                    int offerprice = rs.getInt("offerprice");
                    String photo = rs.getString("photo");
                    al.add(new product(product_id, product_name, brand, description, category_name, price, offerprice, photo));
                }
                tm.fireTableDataChanged();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            viewProduct();
        }
    }

    void deleteProduct() {
        int i = jTable1.getSelectedRow();;
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {
            i = jTable1.getSelectedRow();
            int product_id = al.get(i).product_id;
            try {
                ResultSet rs = DBLoader.exexuteSQL("select * from products where product_id='" + product_id + "'");
                while (rs.next()) {
                    rs.deleteRow();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void addProduct() {
        String category_name = (String) afield1.getSelectedItem();
        String product_name = afield2.getText();
        String brand = afield3.getText();
        String descripton = afield4.getText();
        String price = afield5.getText();
        String offerprice = afield6.getText();

        if (category_name.equals("") || product_name.equals("") || brand.equals("") || descripton.equals("") || price.equals("") || offerprice.equals("") || Path.equals("")) {
            JOptionPane.showMessageDialog(this, "All the fields are required!!");
        } else {
            try {
                String pic = savefile.savefile(Path);
                int mrp = Integer.parseInt(price);
                int finalprice = Integer.parseInt(offerprice);
                ResultSet rs = DBLoader.exexuteSQL("select * from products");
                rs.moveToInsertRow();
                rs.updateString("product_name", product_name);
                rs.updateString("brand", brand);
                rs.updateString("description", descripton);
                rs.updateString("category_name", category_name);
                rs.updateInt("price", mrp);
                rs.updateInt("offerprice", finalprice);
                rs.updateString("photo", pic);
                rs.insertRow();
                JOptionPane.showMessageDialog(this, "Added Successfully");
                viewProduct();
                afield1.setSelectedItem("select");
                afield2.setText("");
                afield3.setText("");
                afield3.setText("");
                afield4.setText("");
                afield5.setText("");
                afield6.setText("");
//                afield7.setText("");
                photolb.setIcon(null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

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
            java.util.logging.Logger.getLogger(manage_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> afield1;
    private javax.swing.JTextField afield2;
    private javax.swing.JTextField afield3;
    private javax.swing.JTextField afield4;
    private javax.swing.JTextField afield5;
    private javax.swing.JTextField afield6;
    private javax.swing.JButton afield7;
    private javax.swing.JLabel bg_manage_product;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JLabel heading;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photolb;
    // End of variables declaration//GEN-END:variables
}
