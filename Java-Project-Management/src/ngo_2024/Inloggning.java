/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author andre
 */
public class Inloggning extends javax.swing.JFrame {

    private InfDB idb;
    
    /**
     * Creates new form Inloggning
     */
    public Inloggning( InfDB idb) {
        this.idb = idb;
        initComponents();
        lblMeddelande.setVisible(false);
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
        txtLösenord = new javax.swing.JTextField();
        lblMeddelande = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAnvändarnamn.setText("Användarnamn:");

        lblLösenord.setText("Lösenord:");

        lblMeddelande.setForeground(new java.awt.Color(255, 51, 51));
        lblMeddelande.setText("Felaktigt användarnamn eller lösenord.");

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMeddelande)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnvändarnamn)
                        .addGap(18, 18, 18)
                        .addComponent(txtAnvändarnamn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnLoggaIn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLösenord)
                        .addGap(51, 51, 51)
                        .addComponent(txtLösenord, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnvändarnamn)
                    .addComponent(txtAnvändarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLösenord)
                    .addComponent(txtLösenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMeddelande)
                .addGap(18, 18, 18)
                .addComponent(btnLoggaIn)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        
        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = txtLösenord.getText();
        
        try{
            String sqlfråga = "Select losenord FROM anstalld WHERE epost = '" + användarnamn + "'";
            String query = idb.fetchSingle(sqlfråga);
            if(lösenord.equals(query))
            {
                new Huvudmeny(idb, användarnamn).setVisible(true);
                this.setVisible(false);
            }
            else
            {
                lblMeddelande.setVisible(true);
            }
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnLoggaInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel lblAnvändarnamn;
    private javax.swing.JLabel lblLösenord;
    private javax.swing.JLabel lblMeddelande;
    private javax.swing.JTextField txtAnvändarnamn;
    private javax.swing.JTextField txtLösenord;
    // End of variables declaration//GEN-END:variables
}
