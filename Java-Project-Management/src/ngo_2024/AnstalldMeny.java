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
public class AnstalldMeny extends javax.swing.JFrame {
     private InfDB idb;
     private String admins;
     private String anvandare;

    /**
     * Creates new form Anstallda
     */
    public AnstalldMeny(InfDB idb, String admins, String anvandare) {
        this.idb = idb;
        this.admins = admins;
        this.anvandare = anvandare;
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        hamtaAnstallda();

    }
    public AnstalldMeny(InfDB idb, String anvandare) {
        this.idb = idb;
        this.anvandare = anvandare;
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        hamtaAnstalldaForAvdelning(anvandare);
//döljer knappar om man öppnar via "personal på min avdelning"
        editAnstalld.setVisible(false);
        remAnstalld.setVisible(false);
        newAnstalld.setVisible(false);
    }
    
    /**
     * Förenklad konstruktor som kan används för att anropa klassen från andra klasser. 
     * @param idb 
     */
    
    public AnstalldMeny(InfDB idb)
    {
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fetchanstallda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editAnstalld = new javax.swing.JButton();
        remAnstalld = new javax.swing.JButton();
        newAnstalld = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fetchanstallda.setText("Hämta anställda");
        fetchanstallda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchanstalldaActionPerformed(evt);
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

        editAnstalld.setText("Ändra anställd");
        editAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAnstalldActionPerformed(evt);
            }
        });

        remAnstalld.setText("Ta bort anställd");
        remAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remAnstalldActionPerformed(evt);
            }
        });

        newAnstalld.setText("Ny anställd");
        newAnstalld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAnstalldActionPerformed(evt);
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
                        .addComponent(fetchanstallda)
                        .addGap(18, 18, 18)
                        .addComponent(editAnstalld)
                        .addGap(18, 18, 18)
                        .addComponent(remAnstalld)
                        .addGap(18, 18, 18)
                        .addComponent(newAnstalld)
                        .addGap(0, 412, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fetchanstallda)
                    .addComponent(editAnstalld)
                    .addComponent(remAnstalld)
                    .addComponent(newAnstalld))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metod som hämtar ut alla anställda för en viss avdelning och stoppar in det i tabellen. Denna skulle kunna skrivas om till en SQL-sats med sub-queries.
     * @param queryAid 
     */
    private void hamtaAnstalldaForAvdelning(String queryAid) {
        try {
            // Hämta användarens avdelning
            String sqlFragaAvdelning = "SELECT avdelning FROM anstalld WHERE aid = '" + queryAid + "'";
            String avdelning = idb.fetchSingle(sqlFragaAvdelning);

            if (avdelning != null && !avdelning.isEmpty()) {
                // SQL-frågan för att hämta data från samma avdelning
                String query = "SELECT aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning "
                        + "FROM anstalld WHERE avdelning = '" + avdelning + "'";
                System.out.println("SQL-fråga: " + query); // Logga frågan Markera bort
                ArrayList<HashMap<String, String>> resultat = idb.fetchRows(query);

                if (resultat != null) {
                    // Skapa en tabellmodell
                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.setRowCount(0);

                    // Lägg till kolumnnamnen
                    tableModel.addColumn("ID");
                    tableModel.addColumn("Förnamn");
                    tableModel.addColumn("Efternamn");
                    tableModel.addColumn("Adress");
                    tableModel.addColumn("Epost");
                    tableModel.addColumn("Telefon");
                    tableModel.addColumn("Anställningsdatum");
                    tableModel.addColumn("Lösenord");
                    tableModel.addColumn("Avdelning");

                    // Fyll tabellen med data från databasen
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
                    JOptionPane.showMessageDialog(this, "Inga anställda hittades för avdelning: " + avdelning);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Din avdelning kunde inte identifieras.");
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel vid hämtning av anställda för avdelning: " + e.getMessage());
        }
    }

    /**
     * Hämtar ut alla anstallda och sätter in dem i tabellen som visas. 
     */
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
  
    /**
     * Raderar en i tabellen vald anställd.
     */
    private void taBortAnstalld() {

        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object anstalld = jTable1.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            String queryAid = anstalld.toString(); // Konvertera till String
            try {

                String sqlfråga1 = "UPDATE projekt SET projektchef = NULL Where projektchef = '" + queryAid + "'";
                idb.update(sqlfråga1);
                String sqlfråga6 = "UPDATE avdelning SET chef = NULL Where chef = '" + queryAid + "'";
                idb.update(sqlfråga6);
                String sqlfråga4 = "DELETE FROM ans_proj WHERE aid = '" + queryAid + "'";
                idb.delete(sqlfråga4);
                String sqlfråga3 = "UPDATE handlaggare SET mentor = NULL Where mentor = '" + queryAid + "'";
                idb.update(sqlfråga3);
                String sqlfråga5 = "DELETE FROM admin WHERE aid = '" + queryAid + "'";
                idb.delete(sqlfråga5);
                String sqlfråga = "DELETE FROM handlaggare WHERE aid = '" + queryAid + "'";
                idb.delete(sqlfråga);
                String sqlfråga2 = "DELETE FROM anstalld WHERE aid = '" + queryAid + "'";
                idb.delete(sqlfråga2);

                hamtaAnstallda();

            } catch (InfException e) {
                System.out.println(e.getMessage());

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }

    }

    /**
     * Öppnar upp ett fönster för att redigera en i tabellen markerad anställd.
     */
    private void editAnstalld() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Object anstalld = jTable1.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            String queryAid = anstalld.toString(); // Konvertera till String
            new EditAnstalld(idb, queryAid, admins, anvandare).setVisible(true); //öppnar nytt fönster, skickar med den anställde via AID från databasen

        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }
    /**
     * Funktion som hämtar ut en anstallds data ur databasen.
     * @param aid
     * @return 
     */
    public HashMap<String, String> hamtaAnstalldsData(String aid)
    {
        HashMap<String, String> resultat;
        String query = "SELECT * FROM anstalld WHERE aid = '" + aid + "'";
        try 
        {
            resultat = idb.fetchRow(query);
        }
        catch(InfException idb)
        {
            JOptionPane.showMessageDialog(this, "Något fick fel när information om användaren skulle hämtas från databasen.");
            resultat = null;
        }
        
        return resultat;
    }
    
    /**
     * Knappar nedan.
     */
    private void fetchanstalldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchanstalldaActionPerformed
        if (!newAnstalld.isVisible()) { // Kontrollera om knappen är dold
            hamtaAnstalldaForAvdelning(anvandare); // Kör denna metod om newAnstalld är dold
        } else {
            hamtaAnstallda(); // Annars kör den vanliga metoden
        }
    }//GEN-LAST:event_fetchanstalldaActionPerformed

    private void newAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAnstalldActionPerformed
        new EditAnstalld(idb).setVisible(true);
    }//GEN-LAST:event_newAnstalldActionPerformed

    private void editAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAnstalldActionPerformed
        editAnstalld();
    }//GEN-LAST:event_editAnstalldActionPerformed

    private void remAnstalldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remAnstalldActionPerformed
        taBortAnstalld();        // TODO add your handling code here:
    }//GEN-LAST:event_remAnstalldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editAnstalld;
    private javax.swing.JButton fetchanstallda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newAnstalld;
    private javax.swing.JButton remAnstalld;
    // End of variables declaration//GEN-END:variables
}
