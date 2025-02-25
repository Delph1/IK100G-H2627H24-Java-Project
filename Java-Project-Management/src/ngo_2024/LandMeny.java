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
 * Klass för att hantera Land
 * @author Claudia Kourieh
 */
public class LandMeny extends javax.swing.JFrame {

    private InfDB idb; 
    /**
     * Konstruktur för LandMeny
     * @param idb
     */
    public LandMeny(InfDB idb) {
        this.idb = idb;
        initComponents();
        setLocationRelativeTo(null);
        populeraLandTabell(getLander());
    }

    /**
     * Hämtar ut alla länder från databasen
     * @return
     */
    public ArrayList<HashMap<String, String>> getLander() {
        ArrayList<HashMap<String, String>> resultat;
        try {
            String query = "SELECT * FROM land";
            resultat = idb.fetchRows(query);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av länder: " + e.getMessage());
            resultat = null;
        }
        return resultat;
    }
    
    public ArrayList<String> getAllaLandNamn() {
        String sqlfråga = "select distinct namn from land;";
        ArrayList<String> allaLandNamn;
        try {
            allaLandNamn = idb.fetchColumn(sqlfråga);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Något gick fel när länderna skulle hämtas från databasen. Kontrollera att databasen fungerar som den ska.");
            allaLandNamn = null;
        }
        return allaLandNamn;
    }
    
    /**
     * Metod som skapar upp tabellen med länder.
     * @param resultat 
     */
    private void populeraLandTabell(ArrayList<HashMap<String, String>> resultat) {
        if (resultat != null) {
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
        } else {
            JOptionPane.showMessageDialog(this, "Inga länder hittades.");
        }
    }
    
    /**
     * Hämta namn baserat på namn. 
     * @param lid
     * @return 
     */
    public String getLandNamnFranId(String lid) {
        String sqlLand = "select namn from land where lid = '" + lid + "'";
        String land = "";
        try {
            land = idb.fetchSingle(sqlLand);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Något gick fel när landdata skulle hämtas ur databasen. Kontrollera att databasen fungerar som den ska.");
        }
        return land;
    }
    
    /**
     * Hämta lid för land utifrån namnet 
     * @param namn
     * @return 
     */
    public int getLidFranNamn(String namn) {
        int lid = 0;
        try {
            String sqlLand = "select lid from land where namn = '" + namn + "'";
            lid = Integer.parseInt(idb.fetchSingle(sqlLand));
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Något gick fel när landdaata skulle hämtas ur databasen.");
        }
        return lid;
    }
    
    /**
     * Raderar markerat land från databasen
     */
    private void raderaLand() {
        int selectedRow = jtTabell.getSelectedRow();
        if (selectedRow != -1) {
            String land = jtTabell.getValueAt(selectedRow, 0).toString();
            int queryLid = Integer.parseInt(land);

            // Först kollar vi om det finns några beroenden innan vi tar bort landet.
            try {
                String query1 = "UPDATE stad SET land = null WHERE land = " + queryLid;
                idb.update(query1);

                // Radera landet
                try {
                    String query2 = "DELETE FROM land WHERE lid = " + queryLid;
                    idb.delete(query2);
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Landet gick inte att radera. Kontrollera att databasen fungerar som den ska.");
                }
                populeraLandTabell(getLander());
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Landet gick inte att ta bort från Stad. Kontrollera att databasen fungerar som den ska.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingen rad är markerad!");
        }
    }
    
    /**
     * Öppnar upp EditLand för markerat land.
     */
    private void editLand() {
        int selectedRow = jtTabell.getSelectedRow();
        if (selectedRow != -1) {
            String land = jtTabell.getValueAt(selectedRow, 0).toString();
            new EditLand(idb, land).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Ingen rad är markerad");
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
        btnRadera = new javax.swing.JButton();
        btnNyttLand = new javax.swing.JButton();
        spTabell = new javax.swing.JScrollPane();
        jtTabell = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Land");
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

        btnRadera.setText("Radera");
        btnRadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaActionPerformed(evt);
            }
        });

        btnNyttLand.setText("Nytt Land");
        btnNyttLand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyttLandActionPerformed(evt);
            }
        });

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
                        .addComponent(btnÄndra)
                        .addGap(18, 18, 18)
                        .addComponent(btnRadera)
                        .addGap(18, 18, 18)
                        .addComponent(btnNyttLand)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUppdatera)))
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

    /**
     * Knappar nedan.
     */
    
    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        populeraLandTabell(getLander()); // Uppdatera tabellen med den nya datan
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        editLand();
    }//GEN-LAST:event_btnÄndraActionPerformed

    private void btnRaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaActionPerformed
        raderaLand();
    }//GEN-LAST:event_btnRaderaActionPerformed

    private void btnNyttLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyttLandActionPerformed
        new EditLand(idb, null).setVisible(true);
    }//GEN-LAST:event_btnNyttLandActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        populeraLandTabell(getLander());
    }//GEN-LAST:event_formWindowGainedFocus

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyttLand;
    private javax.swing.JButton btnRadera;
    private javax.swing.JButton btnUppdatera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JTable jtTabell;
    private javax.swing.JScrollPane spTabell;
    // End of variables declaration//GEN-END:variables
}