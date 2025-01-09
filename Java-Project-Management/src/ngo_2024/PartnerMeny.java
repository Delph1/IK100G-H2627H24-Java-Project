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
 * @author Andreas Galistel
 */
public class PartnerMeny extends javax.swing.JFrame {

    private InfDB idb;
    private StadMeny stad;
    private String aid;
    /**
     * Creates new form PartnerMeny
     */
    public PartnerMeny(InfDB idb) {
        this.idb = idb;
        this.stad = new StadMeny(idb);
        aid = "";   //Undvika att aid är null
        initComponents();
        setLocationRelativeTo(null);
        getPartners();
    }
    
    public PartnerMeny(InfDB idb, String aid) {
        this.idb = idb;
        this.stad = new StadMeny(idb);
        this.aid = aid;
        initComponents();
        setLocationRelativeTo(null);
        getPartnersVidMinaProjekt();
        btnÄndra.setVisible(false);
        btnTaBort.setVisible(false);
        btnUppdatera.setVisible(false);
        btnNyPartner.setVisible(false);
    }

    private void getPartnersVidMinaProjekt() {
        try {
            String query = "SELECT * FROM partner WHERE pid IN (SELECT partner_pid FROM projekt_partner WHERE pid IN (SELECT pid FROM ans_proj WHERE aid = '" + aid + "'))";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            if (resultat != null) {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);

                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Kontaktperson");
                tableModel.addColumn("Kontakt epost");
                tableModel.addColumn("Telefon");
                tableModel.addColumn("Adress");
                tableModel.addColumn("Branch");
                tableModel.addColumn("Stad Id");
                tableModel.addColumn("Stad");

                for (HashMap<String, String> rad : resultat) {
                    tableModel.addRow(new Object[]{
                        rad.get("pid"),
                        rad.get("namn"),
                        rad.get("kontaktperson"),
                        rad.get("kontaktepost"),
                        rad.get("telefon"),
                        rad.get("adress"),
                        rad.get("branch"),
                        rad.get("stad")
                    }
                    );

                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        String stadId = tableModel.getValueAt(i, 7).toString();
                        Object stadNamn = stad.getNamn(Integer.parseInt(stadId));
                        tableModel.setValueAt(stadNamn, i, 8);
                    }
                }
                jTable1.setModel(tableModel);
                jTable1.getColumnModel().getColumn(7).setMinWidth(0);
                jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            } else {
                JOptionPane.showMessageDialog(this, "Inga partners hittades.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av partners: " + e.getMessage());
        }
    }
    
    private void getPartners() {
        try {
            String query = "SELECT * FROM partner";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            if (resultat != null) {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);

                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Kontaktperson");
                tableModel.addColumn("Kontakt epost");
                tableModel.addColumn("Telefon");
                tableModel.addColumn("Adress");
                tableModel.addColumn("Branch");
                tableModel.addColumn("Stad Id");
                tableModel.addColumn("Stad");

                for (HashMap<String, String> rad : resultat) {
                    tableModel.addRow(new Object[]{
                        rad.get("pid"),
                        rad.get("namn"),
                        rad.get("kontaktperson"),
                        rad.get("kontaktepost"),
                        rad.get("telefon"),
                        rad.get("adress"),
                        rad.get("branch"),
                        rad.get("stad")
                    }
                    );

                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        String stadId = tableModel.getValueAt(i, 7).toString();
                        Object stadNamn = stad.getNamn(Integer.parseInt(stadId));
                        tableModel.setValueAt(stadNamn, i, 8);
                    }
                }
                jTable1.setModel(tableModel);
                jTable1.getColumnModel().getColumn(7).setMinWidth(0);
                jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            } else {
                JOptionPane.showMessageDialog(this, "Inga partners hittades.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av partners: " + e.getMessage());
        }
    }
    
    public HashMap<String, String> getEnPartner(String pid) {
        HashMap<String, String> enPartner;
        try {
            String query = "SELECT * FROM partner WHERE pid = " + pid;
            enPartner = idb.fetchRow(query); // Hämta rad som en HashMap
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Något gick fel när partnerdata skulle hämtas. Kontrollera att databasen fugnerar som den ska.");
            enPartner = null;
        }
        return enPartner;
    }
    
    private void raderaPartner() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object partner = jTable1.getValueAt(selectedRow, 0);
            String queryAid = partner.toString();

            //Först kollar vi om en partner är knuten till ett projekt och raderar den relationen.
            try {
                String query1 = "DELETE FROM projekt_partner WHERE partner_pid = '" + partner + "'";
                idb.delete(query1);
                try {
                    String query2 = "DELETE FROM partner WHERE pid = '" + partner + "'";
                    idb.delete(query2);
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                }
            } catch (InfException e) {
                System.out.println(e.getMessage());
            }
            getPartners();
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }
    
    private void editPartner() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object partner = jTable1.getValueAt(selectedRow, 0);
            String queryAid = partner.toString();
            new EditPartner(idb, queryAid).setVisible(true);
        } else {
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

        btnUppdatera = new javax.swing.JButton();
        btnÄndra = new javax.swing.JButton();
        btnTaBort = new javax.swing.JButton();
        btnNyPartner = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Partner");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        btnNyPartner.setText("Ny Partner");
        btnNyPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyPartnerActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Namn", "Kontaktperson", "Kontakt epost", "Telefon", "Adress", "Branch", "Stad Id", "Stad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUppdatera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnÄndra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaBort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNyPartner)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUppdatera)
                    .addComponent(btnÄndra)
                    .addComponent(btnTaBort)
                    .addComponent(btnNyPartner))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Knappar nedan.
     */

    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        getPartners();
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        raderaPartner();
    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        editPartner();
    }//GEN-LAST:event_btnÄndraActionPerformed

    private void btnNyPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyPartnerActionPerformed
        new EditPartner(idb, null).setVisible(true);
    }//GEN-LAST:event_btnNyPartnerActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        //Uppdaterar fönstret om det får fokus och aid inte är satt. Om aid är satt ska det bara visa partners som är relevanta för den användaren och behöver således inte uppdateras automatiskt.
        if(this.aid.isEmpty())
        {
            getPartners();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyPartner;
    private javax.swing.JButton btnTaBort;
    private javax.swing.JButton btnUppdatera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
