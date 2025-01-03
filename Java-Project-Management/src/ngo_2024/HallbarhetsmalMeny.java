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
 * @author andre
 */
public class HallbarhetsmalMeny extends javax.swing.JFrame {

    private InfDB idb;
    
    /**
     * Creates new form HallbarhetsmalMeny
     */
    public HallbarhetsmalMeny(InfDB idb) {
        this.idb = idb;
        initComponents();
        setLocationRelativeTo(null);
        getHallbarhetsmal();
    }

    private void getHallbarhetsmal()
    {
        try {
            String query = "SELECT * FROM hallbarhetsmal";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);
            
            if(resultat != null)
            {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);
                
                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Målnummer");
                tableModel.addColumn("Beskrivning");
                tableModel.addColumn("pioritet");
                
                for (HashMap<String, String> rad : resultat) {
                tableModel.addRow(new Object[]{
                    rad.get("hid"),
                    rad.get("namn"),
                    rad.get("malnummer"),
                    rad.get("beskrivning"),
                    rad.get("prioritet"),
                }
                );
                
            }
            jTable1.setModel(tableModel);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Inga hållbarhetsmål hittades.");
            }
        }
        catch (InfException e) 
        {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av hållbarhetsmål: " + e.getMessage());
        }
    }
    
    private void raderaHallbarhetsmal()
    {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1)
        {
            Object mal = jTable1.getValueAt(selectedRow, 0);
            String queryAid = mal.toString();

            //Först kollar vi om anställda finns vid den avdelning som ska raderas och tar bort dem från avdelningen.
            try {
                String query1 = "DELETE FROM proj_hallbarhet WHERE hid = '" + queryAid + "'";
                idb.delete(query1);
                
                //Sedan raderar vi kopplingen mellan avdelningen och hållbarhetsmålen.
                try
                {
                    String query2 = "DELETE FROM avd_hallbarhet WHERE hid = '" + queryAid + "'";
                    idb.delete(query2);

                    //Sist raderar vi själva avdelningen.
                    try
                    {
                        String query3 = "DELETE FROM hallbarhetsmal WHERE hid = '" + queryAid + "'";
                        idb.delete(query3);
                    }
                    catch (InfException e)
                    {
                        System.out.println(e.getMessage());
                    }

                }
                catch (InfException e)
                {
                    System.out.println(e.getMessage());
                }

            }
            catch (InfException e)
            {
                System.out.println(e.getMessage());
            }
        getHallbarhetsmal();
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }
    
        private void editHallbarhetsmal()
    {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1)
        {
            Object mal = jTable1.getValueAt(selectedRow, 0);
            String queryAid = mal.toString();
            new EditHallbarhetsmal(idb, queryAid).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad");
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
        jTable1 = new javax.swing.JTable();
        btnUppdatera = new javax.swing.JButton();
        btnÄndra = new javax.swing.JButton();
        btnTaBort = new javax.swing.JButton();
        btnNyttMal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Namn", "Målnummer", "Beskrivning", "Prioritet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        btnTaBort.setText("Ta bort");
        btnTaBort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortActionPerformed(evt);
            }
        });

        btnNyttMal.setText("Nytt Mål");
        btnNyttMal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyttMalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUppdatera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnÄndra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaBort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNyttMal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUppdatera)
                    .addComponent(btnÄndra)
                    .addComponent(btnTaBort)
                    .addComponent(btnNyttMal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        getHallbarhetsmal();
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        raderaHallbarhetsmal();
    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        editHallbarhetsmal();
    }//GEN-LAST:event_btnÄndraActionPerformed

    private void btnNyttMalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyttMalActionPerformed
        new EditHallbarhetsmal(idb, null).setVisible(true);
    }//GEN-LAST:event_btnNyttMalActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        getHallbarhetsmal();
    }//GEN-LAST:event_formWindowGainedFocus

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyttMal;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JButton btnUppdatera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
