/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Märta Sjöblom
 */
public class EditProjekt extends javax.swing.JFrame {
    
    private InfDB idb;
    private boolean nyttProjekt;
    
    /**
     * Creates new form EditProjekt
     */
    public EditProjekt(InfDB idb) {
        this.idb = idb;
        nyttProjekt = true;
        initComponents();
        fyllCmbStatus();
        fyllCmbPrioritet();
        fyllCmbProjektChef();
        fyllCmbLand();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProjektNamn = new javax.swing.JTextField();
        lblProjektNamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        txtBeskrivning = new javax.swing.JTextField();
        lblStartDatum = new javax.swing.JLabel();
        txtStartDatum = new javax.swing.JTextField();
        lblSlutDatum = new javax.swing.JLabel();
        txtSlutDatum = new javax.swing.JTextField();
        lblKostnad = new javax.swing.JLabel();
        txtKostnad = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        lblPrioritet = new javax.swing.JLabel();
        cmbPrioritet = new javax.swing.JComboBox<>();
        lblProjektChef = new javax.swing.JLabel();
        cmbProjektChef = new javax.swing.JComboBox<>();
        cmbStatus = new javax.swing.JComboBox<>();
        lblLand = new javax.swing.JLabel();
        cmbLand = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();
        lblProjektID = new javax.swing.JLabel();
        txtProjektID = new javax.swing.JTextField();
        btnSökPID = new javax.swing.JButton();
        lblTommaFalt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblProjektNamn.setText("Projektnamn");

        lblBeskrivning.setText("Beskrivning");

        txtBeskrivning.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblStartDatum.setText("Startdatum");

        lblSlutDatum.setText("Slutdatum");

        lblKostnad.setText("Kostnad");

        lblStatus.setText("Status");

        lblPrioritet.setText("Prioritet");

        cmbPrioritet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPrioritet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPrioritetActionPerformed(evt);
            }
        });

        lblProjektChef.setText("Projektchef");

        cmbProjektChef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProjektChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProjektChefActionPerformed(evt);
            }
        });

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lblLand.setText("Land");

        cmbLand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLandActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        lblProjektID.setText("ProjektID");

        btnSökPID.setText("Sök projekt");
        btnSökPID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSökPIDActionPerformed(evt);
            }
        });

        lblTommaFalt.setForeground(new java.awt.Color(255, 0, 0));
        lblTommaFalt.setText("Ett eller flera fält är tomma och projektet kunde därför inte sparas");
        lblTommaFalt.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTommaFalt)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(lblPrioritet)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblBeskrivning)
                            .addGap(18, 18, 18)
                            .addComponent(txtBeskrivning))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblProjektChef)
                                .addComponent(lblLand))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbProjektChef, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbLand, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblStartDatum)
                                    .addGap(20, 20, 20)
                                    .addComponent(txtStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblSlutDatum)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblKostnad)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblStatus)
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSpara))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblProjektNamn)
                                        .addComponent(lblProjektID))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtProjektID, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSökPID))
                                        .addComponent(txtProjektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(26, 26, 26))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjektID)
                    .addComponent(txtProjektID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSökPID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjektNamn)
                    .addComponent(txtProjektNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBeskrivning)
                    .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDatum)
                    .addComponent(txtStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSlutDatum)
                    .addComponent(txtSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKostnad)
                    .addComponent(txtKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrioritet)
                    .addComponent(cmbPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjektChef)
                    .addComponent(cmbProjektChef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLand)
                    .addComponent(cmbLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSpara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTommaFalt)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblProjektNamn.getAccessibleContext().setAccessibleName("lblProjektNamn");
        lblBeskrivning.getAccessibleContext().setAccessibleName("lblBeskrivning");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void fyllCmbStatus() {
        String sqlfråga = "select distinct status from projekt;";
        ArrayList<String> allaStatus;
        try {
            allaStatus = idb.fetchColumn(sqlfråga);
            for (String status : allaStatus)
                cmbStatus.addItem(status);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    private void fyllCmbPrioritet() {
        String sqlfråga = "select distinct prioritet from projekt;";
        ArrayList<String> allaPrioritet;
        try {
            allaPrioritet = idb.fetchColumn(sqlfråga);
            for (String prioritet : allaPrioritet)
                cmbPrioritet.addItem(prioritet);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    private void fyllCmbProjektChef() {
        String sqlFörnamn = "select fornamn from anstalld, handlaggare where anstalld.aid = handlaggare.aid;";
        String sqlEfternamn = "select efternamn from anstalld, handlaggare where anstalld.aid = handlaggare.aid;";
        ArrayList<String> allaFörnamn;
        ArrayList<String> allaEfternamn;
        
        try {
            allaFörnamn = idb.fetchColumn(sqlFörnamn);
            allaEfternamn = idb.fetchColumn(sqlEfternamn);
            for (int i = 0; i < allaFörnamn.size(); i++) {
                String fulltNamn = allaFörnamn.get(i) + allaEfternamn.get(i);
                cmbProjektChef.addItem(fulltNamn);
            }
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    private void fyllCmbLand() {
        String sqlfråga = "select distinct namn from land;";
        ArrayList<String> allaLänder;
        
        try {
            allaLänder = idb.fetchColumn(sqlfråga);
            for (String land : allaLänder)
                cmbLand.addItem(land);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    public void editProjekt(JTextField projektID) {
            int pid = Integer.parseInt(projektID.getText());
            try {
                String query = "SELECT projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land FROM projekt WHERE pid = " + pid;
                HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap

                if (resultat != null) {
                    // Hämta och sätt värden i motsvarande textfält
                    nyttProjekt = false;
                    txtProjektNamn.setText(resultat.get("projektnamn"));          // Projektnamn
                    txtBeskrivning.setText(resultat.get("beskrivning"));        // Beskrivning
                    txtStartDatum.setText(resultat.get("startdatum"));           // Startdatum
                    txtSlutDatum.setText(resultat.get("slutdatum"));            // Slutdatum
                    txtKostnad.setText(resultat.get("kostnad"));            // kostnad
                    
                    //Sätta nedan comboboxar till det alternativ från databasen hur? För ProjektChef och Land även omvandla från id till namn?
//                    cmbStatus. ;
//                    cmbPrioritet. ; // Anställningsdatum
//                    cmbProjektChef. );         // Lösenord
//                    cmbLand. );        // Avdelning
                } else {
                    JOptionPane.showMessageDialog(null, "Inget projekt hittades med det angivna ID:t.");
                    txtProjektID.requestFocus();
                }
            } catch (InfException e) {
                System.out.println("Ett fel inträffade: " + e.getMessage());
            }
    }
    
    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        //Ersätt med vad som händer när de väljer
        String status = cmbStatus.getSelectedItem().toString();
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void cmbPrioritetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPrioritetActionPerformed
        //Ersätt med vad som händer när de väljer
        String prioritet = cmbPrioritet.getSelectedItem().toString();
    }//GEN-LAST:event_cmbPrioritetActionPerformed

    private void cmbLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLandActionPerformed
        // Ersätt med vad som händer när de väljer
        String land = cmbPrioritet.getSelectedItem().toString();
    }//GEN-LAST:event_cmbLandActionPerformed

    private void cmbProjektChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProjektChefActionPerformed
        // Ersätt med vad som händer vid val här
        String projektChef = cmbProjektChef.getSelectedItem().toString();
    }//GEN-LAST:event_cmbProjektChefActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        // Lägg till korrekt input från fälten som kan läggas till databasen
        if (Validering.faltEjTomtKontroll(txtProjektNamn) && Validering.faltEjTomtKontroll(txtBeskrivning) &&
            Validering.faltEjTomtKontroll(txtStartDatum) && Validering.faltEjTomtKontroll(txtSlutDatum) && Validering.faltEjTomtKontroll(txtKostnad)) {
            lblTommaFalt.setVisible(true);
        }
        //Hur felmeddela och popupa alla nedan valideringar vid ett spara-knapptryck?
//        Validering.datumKontroll(txtStartDatum);
//        Validering.datumKontroll(txtSlutDatum);
//        Validering.datumEfterKontroll(txtStartDatum.getText(), txtSlutDatum);
//        Validering.datumFöreKontroll(txtSlutDatum.getText(), txtStartDatum);
//        Validering.arHeltal(txtKostnad);
//        Validering.positivtVarde(txtKostnad);
        if (nyttProjekt) {
            String sqlFråga = "insert into projekt (projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) values ()";
        }
        else {
            String sqlFråga = "update projekt set (projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) values () where pid = '"+txtProjektID.getText()+"'";
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void btnSökPIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSökPIDActionPerformed
        // TODO add your handling code here:
        boolean validering = Validering.faltEjTomtKontroll(txtProjektID);
        if (!validering) {
            txtProjektID.requestFocus();
        }
        editProjekt(txtProjektID);
    }//GEN-LAST:event_btnSökPIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnSökPID;
    private javax.swing.JComboBox<String> cmbLand;
    private javax.swing.JComboBox<String> cmbPrioritet;
    private javax.swing.JComboBox<String> cmbProjektChef;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblKostnad;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblPrioritet;
    private javax.swing.JLabel lblProjektChef;
    private javax.swing.JLabel lblProjektID;
    private javax.swing.JLabel lblProjektNamn;
    private javax.swing.JLabel lblSlutDatum;
    private javax.swing.JLabel lblStartDatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTommaFalt;
    private javax.swing.JTextField txtBeskrivning;
    private javax.swing.JTextField txtKostnad;
    private javax.swing.JTextField txtProjektID;
    private javax.swing.JTextField txtProjektNamn;
    private javax.swing.JTextField txtSlutDatum;
    private javax.swing.JTextField txtStartDatum;
    // End of variables declaration//GEN-END:variables
}
