/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author Claudia Kourieh
 */

public class EditStad extends javax.swing.JFrame {

    private InfDB idb;
    private String stadId;
    private LandMeny land;

    public EditStad(InfDB idb, String stadId) {
        this.idb = idb;
        this.stadId = stadId;
        this.land = new LandMeny(idb);
        initComponents();
        setLocationRelativeTo(null); // Centrera fönstret
        fyllComboBoxMedLand(); // Fyller ComboBox med länder
        fyllStadsInfo(); // Hämtar stadens nuvarande information
    }

    /**
     * Metod som fyller i fälten med aktuell stad.
     */
    private void fyllStadsInfo() {
        if(stadId != null) {
            try {
                String query = "SELECT namn, land FROM stad WHERE sid = " + stadId;
                HashMap<String, String> stad = idb.fetchRow(query);

                if (stad != null) {
                    tfNamn.setText(stad.get("namn")); // Fyller i stadens namn
                    String landId = stad.get("land");
                    String landNamn = land.getLandNamnFranId(landId);
                    cbLand.setSelectedItem(landId + " - " + landNamn); // väljer rätt land i ComboBox
                } else {
                    JOptionPane.showMessageDialog(this, "Staden kunde inte hittas.");
                    dispose(); // Stänger fönstret om staden inte hittas
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av stadens information från databasen.");
            }
        }
    }

    private void fyllComboBoxMedLand() {
        ArrayList<HashMap<String, String>> landLista = land.getLander();
        if (landLista != null) {
            for (HashMap<String, String> ettLand : landLista) {
                cbLand.addItem(ettLand.get("lid") + " - " + ettLand.get("namn"));
            }
        }
    }

    private void sparaStad() {
        if (Validering.faltEjTomtKontroll(tfNamn)
                && Validering.comboBoxInteTom(cbLand.getSelectedItem())) {
                String nyttNamn = tfNamn.getText().trim();
                String valtLand = cbLand.getSelectedItem().toString();
                String landId = valtLand.split(" - ")[0]; // Extraherar landets ID
            if (stadId != null) {
                try {
                    String query = "UPDATE stad SET namn = '" + nyttNamn + "', land = " + landId + " WHERE sid = " + stadId;
                    idb.update(query);
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Staden kunde inte sparas i databasen");
                }
            } else {
                try {
                    int sid = Integer.parseInt(idb.getAutoIncrement("stad", "sid"));
                    try {
                        String query = "INSERT INTO stad (sid, namn, land) VALUES (" + sid + ", '" + nyttNamn + "', " + landId + ")";
                        idb.insert(query);
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Det gick inte att spara den nya staden.");
                    }
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Det gick inte att hämta nästa ID-nummer för en ny stad.");
                }
            }
                JOptionPane.showMessageDialog(this, "Staden har sparats!");
                dispose(); // Stänger fönstret efter uppdatering
            
        } else {
            JOptionPane.showMessageDialog(this, "Du måste fylla i alla fält för att kunna skapa en stad.");
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

        btSpara = new javax.swing.JButton();
        btAvbryt = new javax.swing.JButton();
        lbNamn = new javax.swing.JLabel();
        tfNamn = new javax.swing.JTextField();
        lbLand = new javax.swing.JLabel();
        cbLand = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redigera städer");

        btSpara.setText("Spara");
        btSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSparaActionPerformed(evt);
            }
        });

        btAvbryt.setText("Avbryt");
        btAvbryt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvbrytActionPerformed(evt);
            }
        });

        lbNamn.setText("Namn");

        lbLand.setText("Land");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLand, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNamn)
                            .addComponent(cbLand, 0, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSpara)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addComponent(btAvbryt)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamn)
                    .addComponent(tfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLand)
                    .addComponent(cbLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSpara)
                    .addComponent(btAvbryt))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSparaActionPerformed
        sparaStad(); // Uppdaterar stadens information
    }//GEN-LAST:event_btSparaActionPerformed

    private void btAvbrytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvbrytActionPerformed
        dispose(); // Stänger fönstret
    }//GEN-LAST:event_btAvbrytActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAvbryt;
    private javax.swing.JButton btSpara;
    private javax.swing.JComboBox<String> cbLand;
    private javax.swing.JLabel lbLand;
    private javax.swing.JLabel lbNamn;
    private javax.swing.JTextField tfNamn;
    // End of variables declaration//GEN-END:variables
}
