
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class admin_login extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form admin_login
     */
    public admin_login() {
        initComponents();
        getContentPane().setBackground(Color.black);
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        setLocationRelativeTo(null);
        setTitle("Login");
        setSize(1500, 800);
        setVisible(true);
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
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        userpass = new javax.swing.JPasswordField();
        loginbt = new javax.swing.JButton();
        heading1 = new javax.swing.JLabel();
        USER = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JLabel();
        bg_admin_login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(null);

        heading.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setText("WELCOME TO POINT OF SALE");
        getContentPane().add(heading);
        heading.setBounds(240, 40, 740, 90);

        username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        getContentPane().add(username);
        username.setBounds(410, 290, 120, 60);

        password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password");
        getContentPane().add(password);
        password.setBounds(410, 430, 120, 60);

        usertext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });
        getContentPane().add(usertext);
        usertext.setBounds(590, 290, 220, 50);

        userpass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        userpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userpassActionPerformed(evt);
            }
        });
        getContentPane().add(userpass);
        userpass.setBounds(590, 440, 220, 50);

        loginbt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginbt.setText("LOGIN");
        loginbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtActionPerformed(evt);
            }
        });
        getContentPane().add(loginbt);
        loginbt.setBounds(470, 580, 150, 50);

        heading1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        heading1.setForeground(new java.awt.Color(255, 255, 255));
        heading1.setText("LOGIN HERE!");
        getContentPane().add(heading1);
        heading1.setBounds(410, 140, 260, 90);

        USER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.jpg"))); // NOI18N
        getContentPane().add(USER);
        USER.setBounds(260, 260, 120, 120);

        PASSWORD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pswrd.jpg"))); // NOI18N
        getContentPane().add(PASSWORD);
        PASSWORD.setBounds(260, 420, 140, 130);

        bg_admin_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4.jpg"))); // NOI18N
        getContentPane().add(bg_admin_login);
        bg_admin_login.setBounds(0, 0, 1500, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userpassActionPerformed

    }//GEN-LAST:event_userpassActionPerformed

    private void loginbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtActionPerformed
        String username = usertext.getText();
        String password = userpass.getText();
        
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "All the fields are requied!!");
        } else {
            try {
                ResultSet rs = DBLoader.exexuteSQL("Select * from admin where username='" + username + "' AND password='" + password + "'");
                if (rs.next()) {
//               JOptionPane.showMessageDialog(this, "Login successful");
                    global.admin_name = username;
                    dispose();
                    admin_home obj = new admin_home();
                    obj.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Enter valid username or password combination");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_loginbtActionPerformed

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertextActionPerformed

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
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PASSWORD;
    private javax.swing.JLabel USER;
    private javax.swing.JLabel bg_admin_login;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel heading1;
    private javax.swing.JButton loginbt;
    private javax.swing.JLabel password;
    private javax.swing.JLabel username;
    private javax.swing.JPasswordField userpass;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
