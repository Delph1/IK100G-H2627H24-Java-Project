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
 * Klass för att hantera Avdelning
 * 
 * @author Andreas Galistel
 */
public class AvdelningMeny extends javax.swing.JFrame {

    private InfDB idb;
    private StadMeny stad; 
    private AnstalldMeny anstalld;
    
    /**
     * Konstruktor för AvdelningMeny
     * @param idb
     */
    public AvdelningMeny(InfDB idb) {
        this.idb = idb;
        this.stad = new StadMeny(idb);
        this.anstalld = new AnstalldMeny(idb);
        initComponents();
        setLocationRelativeTo(null);
        getAvdelningar();
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
        btnRadera = new javax.swing.JButton();
        btnNyAvdelning = new javax.swing.JButton();
        btnSok = new javax.swing.JButton();
        tfSok = new javax.swing.JTextField();

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
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Namn", "Beskrivning", "Adress", "E-post", "Telefon", "Stad Id", "Chef Id", "Stad", "Chef"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        }

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

        btnRadera.setText("Ta bort");
        btnRadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaActionPerformed(evt);
            }
        });

        btnNyAvdelning.setText("Ny Avdelning");
        btnNyAvdelning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyAvdelningActionPerformed(evt);
            }
        });

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        tfSok.setText("Ange handläggarens namn eller e-post");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUppdatera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnÄndra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRadera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNyAvdelning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSok)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUppdatera)
                    .addComponent(btnÄndra)
                    .addComponent(btnRadera)
                    .addComponent(btnNyAvdelning)
                    .addComponent(btnSok)
                    .addComponent(tfSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Knappar följer nedan.
     */
    
    private void btnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUppdateraActionPerformed
        getAvdelningar();
    }//GEN-LAST:event_btnUppdateraActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        editAvdelning();        
    }//GEN-LAST:event_btnÄndraActionPerformed

    private void btnRaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaActionPerformed
        raderaAvdelning();
    }//GEN-LAST:event_btnRaderaActionPerformed

    private void btnNyAvdelningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyAvdelningActionPerformed
        new EditAvdelning(idb, null).setVisible(true);
    }//GEN-LAST:event_btnNyAvdelningActionPerformed

    /**
     * Funktionalitet för att när fönstret får fokus uppdateras det. Bra när man kommer från EditAvdelning och gjort ändringar som ska visas automagiskt.
     */
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        getAvdelningar();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        String sokterm = tfSok.getText().trim();

    if (sokterm.isEmpty() || sokterm.equals("Sök efter namn eller e-post")) {
        JOptionPane.showMessageDialog(this, "Ange ett namn eller en e-post för att söka.");
        return;
    }

    try {
        String query = "SELECT * FROM anstalld WHERE LOWER(fornamn) LIKE LOWER('%" + sokterm + "%') "
                + "OR LOWER(efternamn) LIKE LOWER('%" + sokterm + "%') "
                + "OR LOWER(epost) LIKE LOWER('%" + sokterm + "%')";

        ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

        if (resultat != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setRowCount(0);

            tableModel.addColumn("ID");
            tableModel.addColumn("Förnamn");
            tableModel.addColumn("Efternamn");
            tableModel.addColumn("E-post");
            tableModel.addColumn("Telefon");

            for (HashMap<String, String> rad : resultat) {
                tableModel.addRow(new Object[]{
                    rad.get("aid"),
                    rad.get("fornamn"),
                    rad.get("efternamn"),
                    rad.get("epost"),
                    rad.get("telefon")
                });
            }

            jTable1.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "Inga handläggare hittades med den angivna söktermen.");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Fel vid sökning: " + e.getMessage());
    }
    }//GEN-LAST:event_btnSokActionPerformed

    /**
     * Metod som hämtar ut alla avdelningar och matar in dem i tabellen i fönstret. 
     */
    
    private void getAvdelningar()
    {
        try {
            String query = "SELECT * FROM avdelning";
            ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);
            
            if(resultat != null)
            {
                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.setRowCount(0);
                
                tableModel.addColumn("ID");
                tableModel.addColumn("Namn");
                tableModel.addColumn("Beskrivning");
                tableModel.addColumn("Adress");
                tableModel.addColumn("Epost");
                tableModel.addColumn("Telefon");
                tableModel.addColumn("Stad Id");
                tableModel.addColumn("Chef Id");
                tableModel.addColumn("Stad");
                tableModel.addColumn("Chef");
                
                for (HashMap<String, String> rad : resultat) {
                tableModel.addRow(new Object[]{
                    rad.get("avdid"),
                    rad.get("namn"),
                    rad.get("beskrivning"),
                    rad.get("adress"),
                    rad.get("epost"),
                    rad.get("telefon"),
                    rad.get("stad"),
                    rad.get("chef")
                }
                );
                
                for (int i = 0; i < tableModel.getRowCount() ; i++)
                {
                    String stadId = tableModel.getValueAt(i, 6).toString();
                    Object stadNamn = stad.getNamn(Integer.parseInt(stadId));
                    tableModel.setValueAt(stadNamn, i, 8);
                    
                    String chefId = tableModel.getValueAt(i, 7).toString();
                    Object chefNamn = anstalld.getChefNamn(chefId); 
                    tableModel.setValueAt(chefNamn, i, 9);
                }
            }
            jTable1.setModel(tableModel);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);            
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Inga avdelningar hittades.");
            }
        }
        catch (InfException e) 
        {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av avdelningar: " + e.getMessage());
        }
    }
    
    /**
     * Metod för att radera en vald avdelning. Utgår från den rad som är markerad i tabellen. 
     */
    private void raderaAvdelning()
    {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1)
        {
            Object avdelning = jTable1.getValueAt(selectedRow, 0);
            String queryAid = avdelning.toString();

            //Först kollar vi om anställda finns vid den avdelning som ska raderas och tar bort dem från avdelningen.
            try {
                String query1 = "UPDATE anstalld SET avdelning = null WHERE avdelning = '" + queryAid + "'";
                idb.update(query1);
                
                //Sedan raderar vi kopplingen mellan avdelningen och hållbarhetsmålen.
                try
                {
                    String query2 = "DELETE FROM avd_hallbarhet WHERE avdid = '" + queryAid + "'";
                    idb.delete(query2);

                    //Sist raderar vi själva avdelningen.
                    try
                    {
                        String query3 = "DELETE FROM avdelning WHERE avdid = '" + queryAid + "'";
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
        //Uppdaterar tabellen efter att raden blivit raderad.
        getAvdelningar();
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }

    /**
     * Metod för att redigera en avdelning. Utgår från den rad i tabellen som är markerad.
     */
    private void editAvdelning()
    {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1)
        {
            Object avdelning = jTable1.getValueAt(selectedRow, 0);
            String queryAid = avdelning.toString();
            new EditAvdelning(idb, queryAid).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyAvdelning;
    private javax.swing.JButton btnRadera;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnUppdatera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tfSok;
    // End of variables declaration//GEN-END:variables
}
