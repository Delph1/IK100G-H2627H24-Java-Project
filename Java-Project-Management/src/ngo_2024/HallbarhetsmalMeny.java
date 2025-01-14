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
 * Klass för HallbarhetsmalMeny
 * @author Andreas Galistel
 */
public class HallbarhetsmalMeny extends javax.swing.JFrame {

    private InfDB idb;
    private boolean endastVisa;
    
    /**
     * Konstruktor för HallbarhetsmalMeny
     * @param idb
     * @param endastVisa
     */
    public HallbarhetsmalMeny(InfDB idb, boolean endastVisa) {
        this.idb = idb;
        this.endastVisa = endastVisa;
        initComponents();
        setLocationRelativeTo(null);
        getHallbarhetsmal();
        
        //Parametern endastVisa används för att dölja knapparna om den sätts till true. Eftersom åtkomst till denna meny styrs av vilken meny de kan se.
        if(this.endastVisa)
        {
            btnÄndra.setVisible(false);
            btnNyttMal.setVisible(false);
            btnUppdatera.setVisible(false);
            btnTaBort.setVisible(false);
        }
    }    

    /**
     * Hämtar ut alla Hållbarhetsmål och populerar tabellen som visas. 
     */
    private void getHallbarhetsmal() {
        try {
            String query = "SELECT * FROM hallbarhetsmal";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

            if (resultat != null) {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);

                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Målnummer");
                tableModel.addColumn("Beskrivning");
                tableModel.addColumn("Prioritet");

                for (HashMap<String, String> rad : resultat) {
                    tableModel.addRow(new Object[]{
                        rad.get("hid"),
                        rad.get("namn"),
                        rad.get("malnummer"),
                        rad.get("beskrivning"),
                        rad.get("prioritet"),}
                    );
                }
                jTable1.setModel(tableModel);
                addRowSelectionListener();
                if (jTable1.getRowCount() > 0) {
                    jTable1.setRowSelectionInterval(0, 0);
}
            } else {
                JOptionPane.showMessageDialog(this, "Inga hållbarhetsmål hittades.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Fel vid hämtning av hållbarhetsmål. Kontrollera att databasen fungerar som den ska.");
        }
    }
    
    /**
     * Raderar valt mål.
     */
    private void raderaHallbarhetsmal() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object mal = jTable1.getValueAt(selectedRow, 0);
            String queryAid = mal.toString();

            //Först kollar vi om anställda finns vid den avdelning som ska raderas och tar bort dem från avdelningen.
            try {
                String query1 = "DELETE FROM proj_hallbarhet WHERE hid = '" + queryAid + "'";
                idb.delete(query1);

                //Sedan raderar vi kopplingen mellan avdelningen och hållbarhetsmålen.
                try {
                    String query2 = "DELETE FROM avd_hallbarhet WHERE hid = '" + queryAid + "'";
                    idb.delete(query2);

                    //Sist raderar vi själva avdelningen.
                    try {
                        String query3 = "DELETE FROM hallbarhetsmal WHERE hid = '" + queryAid + "'";
                        idb.delete(query3);
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Något gick fel när hållbarhetsmålet skulle raderas. Kontrollera att databasen fungerar som den ska.");
                    }

                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Något gick fel när hållbarhetsmålet för avdelning skulle raderas. Kontrollera att databasen fungerar som den ska.");
                }

            } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Något gick fel när hållbarhetsmålet för projekt skulle raderas. Kontrollera att databasen fungerar som den ska.");
            }
            getHallbarhetsmal();
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }

    /**
     * Metod för att redigera valt hållbarhetsmål.
     */
    private void editHallbarhetsmal() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object mal = jTable1.getValueAt(selectedRow, 0);
            String queryAid = mal.toString();
            new EditHallbarhetsmal(idb, queryAid).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad");
        }
    }
    
    private void addRowSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {
                // Hämta den valda radens index
                int selectedRow = jTable1.getSelectedRow();

                String id = jTable1.getValueAt(selectedRow, 0).toString();
                String namn = jTable1.getValueAt(selectedRow, 1).toString();
                String malnummer = jTable1.getValueAt(selectedRow, 2).toString();
                String beskrivning = jTable1.getValueAt(selectedRow, 3).toString();
                String prioritet = jTable1.getValueAt(selectedRow, 4).toString();

                uppdateraInfo(id, namn, malnummer, beskrivning, prioritet);
            }
        });
    }
    
    private void uppdateraInfo(String id, String namn, String malnummer, String beskrivning, String prioritet) {
    lblId.setText("ID: " + id);
    lblNamn.setText("Namn: " + namn);
    lblMalnummer.setText("Målnummer: " + malnummer);
    lblBeskrivning.setText("<html>Beskrivning: " + beskrivning + "</html>"); // HTML för används för att byta rad, om det behövs
    lblPrioritet.setText("Prioritet: " + prioritet);
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
        lblId = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblMalnummer = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        lblPrioritet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hållbarhetsmål");
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

        lblId.setText("jLabel6");

        lblNamn.setText("jLabel7");

        lblMalnummer.setText("jLabel8");

        lblBeskrivning.setText("jLabel9");

        lblPrioritet.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBeskrivning)
                            .addComponent(lblMalnummer)
                            .addComponent(lblNamn)
                            .addComponent(lblId)
                            .addComponent(lblPrioritet))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnÄndra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaBort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNyttMal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUppdatera)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblId)
                .addGap(18, 18, 18)
                .addComponent(lblPrioritet)
                .addGap(18, 18, 18)
                .addComponent(lblNamn)
                .addGap(18, 18, 18)
                .addComponent(lblMalnummer)
                .addGap(18, 18, 18)
                .addComponent(lblBeskrivning)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Knappar följer nedan.
     */
    
    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        getHallbarhetsmal();
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnTaBortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortActionPerformed
        raderaHallbarhetsmal();
        getHallbarhetsmal();
    }//GEN-LAST:event_btnTaBortActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        editHallbarhetsmal();
    }//GEN-LAST:event_btnÄndraActionPerformed

    private void btnNyttMalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyttMalActionPerformed
        new EditHallbarhetsmal(idb, null).setVisible(true);
    }//GEN-LAST:event_btnNyttMalActionPerformed

    //Funktion som uppdaterar fönstret om det får fokus igen. Användbart framförallt för när man redigerat eller skapat ett nytt mål. 
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
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMalnummer;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPrioritet;
    // End of variables declaration//GEN-END:variables
}
