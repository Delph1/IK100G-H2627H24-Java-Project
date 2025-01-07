/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Sixblade
 */
public class EditProjektPartner extends javax.swing.JFrame {

    private InfDB idb;
    private String queryAid;

    private HashMap<String, String> projektMap;
    private HashMap<String, String> partnerMap;
    private HashMap<Integer, String> pidMap;

    /**
     * Creates new form Editprojpartner
     */

    public EditProjektPartner(InfDB idb, String queryAid) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.idb = idb;
        this.queryAid = queryAid;
        this.projektMap = new HashMap<>();
        this.partnerMap = new HashMap<>();
        this.pidMap = new HashMap<>();
        fyllComboprojekt();
        fyllCombopartners();

    }
public EditProjektPartner(InfDB idb) {
    initComponents();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.idb = idb;
    this.projektMap = new HashMap<>();
    this.partnerMap = new HashMap<>();
    this.pidMap = new HashMap<>();
    fyllAllaProjekt();
    fyllCombopartners(); 
}
    private void fyllComboprojekt() {
        try {
            String query = "SELECT pid, projektnamn FROM projekt WHERE projektchef = '" + queryAid + "'";
            ArrayList<HashMap<String, String>> projekten = idb.fetchRows(query);

            if (projekten != null) {
                for (HashMap<String, String> projekt : projekten) {
                    String projid = projekt.get("pid");
                    String namn = projekt.get("projektnamn");

                    projektMap.put(namn, projid);
                    minaProjektcmb.addItem(namn); // Lägg till namnet i comboboxen
                }
            }
        } catch (InfException e) {
            System.out.println("Ett fel inträffade vid hämtning av avdelningar: " + e.getMessage());
        }
    }
private void fyllAllaProjekt() {
    try {
        String query = "SELECT pid, projektnamn FROM projekt"; // Hämtar alla projekt
        ArrayList<HashMap<String, String>> projekten = idb.fetchRows(query);

        if (projekten != null) {
            for (HashMap<String, String> projekt : projekten) {
                String projid = projekt.get("pid");
                String namn = projekt.get("projektnamn");

                projektMap.put(namn, projid);
                minaProjektcmb.addItem(namn); // Lägg till projektets namn i comboboxen
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inga projekt hittades i databasen.");
        }
    } catch (InfException e) {
        System.out.println("Ett fel inträffade vid hämtning av projekt: " + e.getMessage());
    }
}

    private void fyllCombopartners() {
        try {
            String query = "SELECT pid, namn FROM partner";
            ArrayList<HashMap<String, String>> partners = idb.fetchRows(query);

            if (partners != null) {
                for (HashMap<String, String> partner : partners) {
                    String partnerid = partner.get("pid");
                    String namn = partner.get("namn");

                    partnerMap.put(namn, partnerid);
                    allaPartnersCmb.addItem(namn); // Lägg till namnet i comboboxen
                }
            }
        } catch (InfException e) {
            System.out.println("Ett fel inträffade vid hämtning av avdelningar: " + e.getMessage());
        }
    }

    private void fyllTablePartners(String projektId) {
        try {

            String queryProjektPartners = "SELECT partner_pid FROM projekt_partner WHERE pid = '" + projektId + "'";
            ArrayList<HashMap<String, String>> projektPartners = idb.fetchRows(queryProjektPartners);

            if (projektPartners == null || projektPartners.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inga partners hittades för det valda projektet.");
                jTable1.setModel(new javax.swing.table.DefaultTableModel()); // Töm tabellen
                pidMap.clear();
                return;
            }

            // Skapa en ny tabellmodell
            javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel();
            tableModel.addColumn("Namn");
            tableModel.addColumn("Kontaktperson");
            tableModel.addColumn("Branch");

            pidMap.clear();

            int rowIndex = 0;

            // Hämta detaljer för varje partner_pid
            for (HashMap<String, String> projektPartner : projektPartners) {
                String partnerPid = projektPartner.get("partner_pid");

                String queryPartner = "SELECT namn, kontaktperson, branch FROM partner WHERE pid = '" + partnerPid + "'";
                HashMap<String, String> partnerDetails = idb.fetchRow(queryPartner);

                if (partnerDetails != null) {
                    String namn = partnerDetails.get("namn");
                    String kontaktperson = partnerDetails.get("kontaktperson");
                    String branch = partnerDetails.get("branch");

                    tableModel.addRow(new Object[]{namn, kontaktperson, branch});

                    pidMap.put(rowIndex, partnerPid);
                    rowIndex++; // Öka indexet för nästa rad
                }
            }

            jTable1.setModel(tableModel);

        } catch (InfException e) {
            System.out.println("Ett fel inträffade: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Ett fel inträffade vid hämtning av partners.");
        }
    }

    private void laggTillPartnerIProjekt() {
        try {
            // Hämta valt projektnamn och partnernamn från comboboxarna
            String valtProjekt = (String) minaProjektcmb.getSelectedItem();
            String valdPartner = (String) allaPartnersCmb.getSelectedItem();

            if (valtProjekt == null || valdPartner == null || valtProjekt.isEmpty() || valdPartner.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Du måste välja både ett projekt och en partner.");
                return;
            }

            // Hämta projekt-ID och partner-ID från mapparna
            String projektId = projektMap.get(valtProjekt);
            String partnerId = partnerMap.get(valdPartner);

            // Kontrollera att ID:n inte är null
            if (projektId == null || partnerId == null) {
                JOptionPane.showMessageDialog(this, "Ogiltigt projekt eller partner.");
                return;
            }

            // Kontrollera om partnern redan är kopplad till projektet
            String checkQuery = "SELECT COUNT(*) AS count FROM projekt_partner WHERE pid = '" + projektId + "' AND partner_pid = '" + partnerId + "'";
            int count = Integer.parseInt(idb.fetchSingle(checkQuery));

            if (count > 0) {
                JOptionPane.showMessageDialog(this, "Denna partner är redan kopplad till projektet.");
                return;
            }

            // Lägg till partnern i projektet
            String insertQuery = "INSERT INTO projekt_partner (pid, partner_pid) VALUES ('" + projektId + "', '" + partnerId + "')";
            idb.insert(insertQuery);
            JOptionPane.showMessageDialog(this, "Partnern har lagts till i projektet.");

            // Uppdatera JTable med den nya datan
            fyllTablePartners(projektId);

        } catch (InfException e) {
            System.out.println("Ett fel inträffade: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Ett fel inträffade vid tillägg av partner till projekt.");
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

        minaProjektcmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        allaPartnersCmb = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        delPartnerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        minaProjektcmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minaProjektcmbActionPerformed(evt);
            }
        });

        jLabel1.setText("Mina projekt:");

        jLabel2.setText("Alla partners:");

        allaPartnersCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj partner att lägga till" }));
        allaPartnersCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allaPartnersCmbActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Namn", "Kontaktperson", "Branch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Lägg till partner");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        closeBtn.setText("Stäng");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        delPartnerBtn.setText("Ta bort partner");
        delPartnerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delPartnerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(delPartnerBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(allaPartnersCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minaProjektcmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minaProjektcmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(allaPartnersCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeBtn)
                    .addComponent(delPartnerBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minaProjektcmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minaProjektcmbActionPerformed
        String valtProjekt = (String) minaProjektcmb.getSelectedItem();
        if (valtProjekt != null && projektMap.containsKey(valtProjekt)) {
            String projektId = projektMap.get(valtProjekt);
            fyllTablePartners(projektId); // Uppdatera JTable baserat på det valda projektet
        }
    }//GEN-LAST:event_minaProjektcmbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        laggTillPartnerIProjekt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void allaPartnersCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allaPartnersCmbActionPerformed
        // Hämta valt partnernamn från comboboxen
        String valdPartner = (String) allaPartnersCmb.getSelectedItem();

        // Kontrollera att något faktiskt är valt
        if (valdPartner != null && !valdPartner.equals("Välj partner att lägga till")) {
            // Hämta partner-ID från partnerMap
            String partnerId = partnerMap.get(valdPartner);

            // Kontrollera att partner-ID inte är null
            if (partnerId != null) {
                System.out.println("Vald partner: " + valdPartner + ", ID: " + partnerId);
            } else {
                System.out.println("Partner-ID saknas för: " + valdPartner);
            }
        } else {
            System.out.println("Inget giltigt partnernamn valt.");
        }
    }//GEN-LAST:event_allaPartnersCmbActionPerformed

    private void delPartnerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delPartnerBtnActionPerformed
        try {
            // Kontrollera om en rad är vald
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Välj en partner att ta bort.");
                return;
            }

            // Hämta partner_pid från pidMap
            String partnerPid = pidMap.get(selectedRow);
            if (partnerPid == null) {
                JOptionPane.showMessageDialog(this, "Kunde inte hämta partner_pid för vald rad.");
                return;
            }

            // Hämta valt projekt från minaProjektcmb
            String valtProjekt = (String) minaProjektcmb.getSelectedItem();
            if (valtProjekt == null || valtProjekt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inget projekt valt.");
                return;
            }

            // Hämta projektId från projektMap
            String projektId = projektMap.get(valtProjekt);
            if (projektId == null) {
                JOptionPane.showMessageDialog(this, "Kunde inte hämta projektId.");
                return;
            }

            // Ta bort kopplingen från projekt_partner
            String deleteQuery = "DELETE FROM projekt_partner WHERE pid = '" + projektId + "' AND partner_pid = '" + partnerPid + "'";
            idb.delete(deleteQuery);

            JOptionPane.showMessageDialog(this, "Partnern har tagits bort.");

            // Uppdatera JTable
            fyllTablePartners(projektId);

        } catch (InfException e) {
            System.out.println("Ett fel inträffade: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Ett fel inträffade vid borttagning.");
        }
    }//GEN-LAST:event_delPartnerBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditProjektPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProjektPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProjektPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProjektPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> allaPartnersCmb;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton delPartnerBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> minaProjektcmb;
    // End of variables declaration//GEN-END:variables
}
