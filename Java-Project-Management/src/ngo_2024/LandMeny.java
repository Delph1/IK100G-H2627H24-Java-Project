/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Claudia Kourieh
 */
public class LandMeny extends javax.swing.JFrame {

    private InfDB idb; 
    /**
     * Creates new form LandMeny
     */
    public LandMeny(InfDB idb) {
        this.idb = idb;
        initComponents();
        setLocationRelativeTo(null);
        getLand();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUppdatera = new javax.swing.JButton();
        btnÄndra = new javax.swing.JButton();
        btnRadera = new javax.swing.JButton();
        btnNyttLand = new javax.swing.JButton();
        spTabell = new javax.swing.JScrollPane();
        jtTabell = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUppdatera.setText("Uppdatera");
        btnUppdatera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUppdateraActionPerformed(evt);
            }
        });

        btnÄndra.setText("Ändra");
        btnÄndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraActionPerformed(evt);
            }
        });

        btnRadera.setText("Radera");

        btnNyttLand.setText("Nytt Land");

        jtTabell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Namn", "Språk", "Valuta", "Tidszon", "Politisk struktur", "Ekonomi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        spTabell.setViewportView(jtTabell);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTabell, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUppdatera)
                        .addGap(18, 18, 18)
                        .addComponent(btnÄndra)
                        .addGap(18, 18, 18)
                        .addComponent(btnRadera)
                        .addGap(18, 18, 18)
                        .addComponent(btnNyttLand)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUppdatera)
                    .addComponent(btnÄndra)
                    .addComponent(btnRadera)
                    .addComponent(btnNyttLand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTabell, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnÄndraActionPerformed
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        getLand();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       //new EditLand(idb, null).setVisible(true);
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        raderaLand();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //new NyLand(idb).setVisible(true);
    }                                        

    private void getLand()
    {
        try {
            String query = "SELECT * FROM land";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);
            
            if(resultat != null)
            {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);
                
                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Språk");
                tableModel.addColumn("Valuta");
                tableModel.addColumn("Tidszon");
                tableModel.addColumn("Politisk Struktur");
                tableModel.addColumn("Ekonomi");
                
                for (HashMap<String, String> rad : resultat) {
                    tableModel.addRow(new Object[]{
                        rad.get("lid"),
                        rad.get("namn"),
                        rad.get("sprak"),
                        rad.get("valuta"),
                        rad.get("tidszon"),
                        rad.get("politisk_struktur"),
                        rad.get("ekonomi")
                    });
                }
                jtTabell.setModel(tableModel);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Inga länder hittades.");
            }
        }
        catch (InfException e) 
        {
        JOptionPane.showMessageDialog(null, "Fel vid hämtning av länder: " + e.getMessage());
        }
    }
    
    private void raderaLand()
    {
        int selectedRow = jtTabell.getSelectedRow();
        if (selectedRow != -1)
        {
            Object land = jtTabell.getValueAt(selectedRow, 0);
            int queryLid = (int) land;

            // Först kollar vi om det finns några beroenden innan vi tar bort landet.
            try {
                String query1 = "UPDATE anstalld SET land = null WHERE land = " + queryLid;
                idb.update(query1);
                
                // Radera landet
                String query2 = "DELETE FROM land WHERE id = " + queryLid;
                idb.delete(query2);
            }
            catch (InfException e)
            {
                JOptionPane.showMessageDialog(null, "Fel vid borttagning av land: " + e.getMessage());
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }
    
    private void EditLand()
    {
        int selectedRow = jtTabell.getSelectedRow();
        if (selectedRow != -1)
        {
            Object land = jtTabell.getValueAt(selectedRow, 0);
            int queryLid = (int) land;
            //new EditLand(idb, queryLid).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyttLand;
    private javax.swing.JButton btnRadera;
    private javax.swing.JButton btnUppdatera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JTable jtTabell;
    private javax.swing.JScrollPane spTabell;
    // End of variables declaration//GEN-END:variables
}
