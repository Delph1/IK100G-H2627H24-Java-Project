/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fredrik Magnusson
 */
public class Anstallda extends javax.swing.JFrame {
     private InfDB idb;

    /**
     * Creates new form Anstallda
     */
    public Anstallda(InfDB idb) {
         this.idb = idb;
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        hamtaAnstallda();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Hämta anställda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Förnamn", "Efternamn", "Adress", "Epost", "Telefon", "Anställningsdatum", "Lösenord", "Avdelning"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Ändra anställd");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ta bort anställd");

        jButton4.setText("Ny anställd");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(0, 412, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
hamtaAnstallda();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
getSelectedValue();       
    }//GEN-LAST:event_jButton2ActionPerformed

 private void hamtaAnstallda() {
    try {
        // SQL-frågan för att hämta data
        String query = "SELECT aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning FROM anstalld";
        System.out.println("SQL-fråga: " + query); // Logga frågan Markera bort
        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

        if (resultat != null) {
            // Skapa en tabellmodell
            
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setRowCount(0);
            
            // Lägg till kolumnnamn i modellen
            tableModel.addColumn("ID");
            tableModel.addColumn("Förnamn");
            tableModel.addColumn("Efternamn");
            tableModel.addColumn("Adress");
            tableModel.addColumn("Epost");
            tableModel.addColumn("Telefon");
            tableModel.addColumn("Anställningsdatum");
            tableModel.addColumn("Lösenord");
            tableModel.addColumn("Avdelning");

            // Fyller table med data från databasen
            for (HashMap<String, String> rad : resultat) {
                tableModel.addRow(new Object[]{
                    rad.get("aid"),
                    rad.get("fornamn"),
                    rad.get("efternamn"),
                    rad.get("adress"),
                    rad.get("epost"),
                    rad.get("telefon"),
                    rad.get("anstallningsdatum"),
                    rad.get("losenord"),
                    rad.get("avdelning")
                });
            }

            // Sätt modellen på JTable
            jTable1.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "Inga anställda hittades.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Fel vid hämtning av anställda: " + e.getMessage());
    }
}
    private void getSelectedValue() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object anstalld = jTable1.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            String anstalldString = anstalld.toString(); // Konvertera till String
            new EditAnstalld(idb, anstalldString).setVisible(true);
            // JOptionPane.showMessageDialog(this, "Valt ID: " + anstalld);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
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
            java.util.logging.Logger.getLogger(Anstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anstallda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           //     new Anstallda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
