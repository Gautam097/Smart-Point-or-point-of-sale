
import javax.swing.JOptionPane;


public class productdesign extends javax.swing.JPanel {

    /**
     * Creates new form productdesign
     */
    public productdesign() {
        initComponents();
        setSize(300,350);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        bt = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("jLabel1");
        add(lb1);
        lb1.setBounds(57, 6, 180, 130);

        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("jLabel1");
        add(lb2);
        lb2.setBounds(50, 160, 170, 16);

        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText("jLabel2");
        add(lb3);
        lb3.setBounds(50, 190, 180, 20);

        lb4.setForeground(new java.awt.Color(255, 255, 255));
        lb4.setText("jLabel3");
        add(lb4);
        lb4.setBounds(50, 220, 180, 16);

        lb5.setForeground(new java.awt.Color(255, 255, 255));
        lb5.setText("jLabel4");
        add(lb5);
        lb5.setBounds(50, 250, 190, 16);

        lb6.setForeground(new java.awt.Color(255, 255, 255));
        lb6.setText("jLabel1");
        add(lb6);
        lb6.setBounds(50, 280, 200, 16);

        bt.setText("Add To Cart");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        add(bt);
        bt.setBounds(110, 300, 110, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
      
    }//GEN-LAST:event_btActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bt;
    public javax.swing.JLabel lb1;
    public javax.swing.JLabel lb2;
    public javax.swing.JLabel lb3;
    public javax.swing.JLabel lb4;
    public javax.swing.JLabel lb5;
    public javax.swing.JLabel lb6;
    // End of variables declaration//GEN-END:variables
}
