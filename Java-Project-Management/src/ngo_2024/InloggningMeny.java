/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.awt.event.KeyEvent;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author andre
 */
public class InloggningMeny extends javax.swing.JFrame {

    private InfDB idb;
    
    /**
     * Creates new form Inloggning
     */
    public InloggningMeny( InfDB idb) {
        this.idb = idb;
        initComponents();
        lblMeddelande.setVisible(false);
        String nivå;
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        txtLösenord.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnvändarnamn = new javax.swing.JLabel();
        lblLösenord = new javax.swing.JLabel();
        txtAnvändarnamn = new javax.swing.JTextField();
        lblMeddelande = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtLösenord = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inloggning");

        lblAnvändarnamn.setText("Användarnamn:");

        lblLösenord.setText("Lösenord:");

        txtAnvändarnamn.setToolTipText("");

        lblMeddelande.setForeground(new java.awt.Color(255, 51, 51));
        lblMeddelande.setText("Felaktigt användarnamn eller lösenord.");

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        jButton1.setText("Administratör");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Projektledare");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Vanlig användare");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtLösenord.setText("jPasswordField1");
        txtLösenord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLösenordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMeddelande)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnvändarnamn)
                                    .addComponent(lblLösenord))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAnvändarnamn, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtLösenord)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnLoggaIn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton2)
                                .addGap(33, 33, 33)
                                .addComponent(jButton3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnvändarnamn)
                    .addComponent(txtAnvändarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLösenord)
                    .addComponent(txtLösenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblMeddelande)
                .addGap(24, 24, 24)
                .addComponent(btnLoggaIn)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
        private void loggaIn(String användarnamn, String lösenord)
    {
        if (Validering.faltEjTomtKontroll(txtAnvändarnamn) && Validering.emailKontroll(txtAnvändarnamn) && (Validering.faltEjTomtKontroll(txtLösenord))) {

            try {
                String sqlfråga = "Select losenord FROM anstalld WHERE epost = '" + användarnamn + "'";
                String query = idb.fetchSingle(sqlfråga);
                

                if (lösenord.equals(query)) {

                    String sqlfrågaAid = "Select aid FROM anstalld WHERE epost = '" + användarnamn + "'";
                    String queryAid = idb.fetchSingle(sqlfrågaAid);
                    

                    String sqlFrågaAdmin = "Select behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
                    String admins = idb.fetchSingle(sqlFrågaAdmin);
                    
                    
                   String sqlFrågaHand = "Select projektchef FROM projekt WHERE pid = '" + queryAid + "'";
                    String projl = idb.fetchSingle(sqlFrågaHand);

                    new Huvudmeny(idb, queryAid, admins, projl).setVisible(true);

                    this.setVisible(false);
                } else {
                    lblMeddelande.setVisible(true);
                }
            } catch (InfException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        
    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        
        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = new String(txtLösenord.getPassword());
        
        loggaIn(användarnamn, lösenord);
        
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtAnvändarnamn.setText("maria.g@example.com");
        txtLösenord.setText("password123");
        
        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = new String(txtLösenord.getPassword());
        
        loggaIn(användarnamn, lösenord);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtAnvändarnamn.setText("ahmed.khan@example.com");
        txtLösenord.setText("password789");
        
        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = new String(txtLösenord.getPassword());
        
        loggaIn(användarnamn, lösenord);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtAnvändarnamn.setText("yuna.k@example.com");
        txtLösenord.setText("passwordxyz");

        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = new String(txtLösenord.getPassword());
        
        loggaIn(användarnamn, lösenord);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtLösenordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLösenordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String användarnamn = txtAnvändarnamn.getText();
            String lösenord = new String(txtLösenord.getPassword());
            loggaIn(användarnamn, lösenord);
        }
    }//GEN-LAST:event_txtLösenordKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblAnvändarnamn;
    private javax.swing.JLabel lblLösenord;
    private javax.swing.JLabel lblMeddelande;
    private javax.swing.JTextField txtAnvändarnamn;
    private javax.swing.JPasswordField txtLösenord;
    // End of variables declaration//GEN-END:variables
}