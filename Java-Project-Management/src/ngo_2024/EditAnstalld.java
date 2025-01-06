/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Fredrik Magnusson
 */
public class EditAnstalld extends javax.swing.JFrame {

    private InfDB idb;
    private String queryAid;
    private HashMap<String, String> avdelningMap;
    private final String anvandare;
    
    /**
     * Creates new form EditAnstalld
     */

    public EditAnstalld(InfDB idb, String queryAid, String admins, String anvandare) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        this.idb = idb;
        this.queryAid = queryAid;
        this.anvandare = anvandare;
        this.avdelningMap = new HashMap<>();

        comboAvdelning.setVisible(true);
        fyllComboBox();
      
         if (queryAid != null && !queryAid.isEmpty()) {
try {          
    String query = "SELECT fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning FROM anstalld WHERE aid = '" + queryAid + "'";

    HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap
    
    if (resultat != null) {
        // Hämta och sätt värden i motsvarande textfält

        txtFornamn.setText(resultat.get("fornamn"));
        txtEfternamn.setText(resultat.get("efternamn"));
        txtAdress.setText(resultat.get("adress"));       
        txtEpost.setText(resultat.get("epost"));         
        txtTelefonNr.setText(resultat.get("telefon"));
        txtanstallningsDatum.setText(resultat.get("anstallningsdatum"));
        txtLosen.setText(resultat.get("losenord"));
        String avdelning = resultat.get("avdelning");
        String avdelningsNamn = getAvdelningsNamnId(avdelning); // sätt motsvarande namn från avdelning
        if (avdelningsNamn != null) {
            comboAvdelning.setSelectedItem(avdelningsNamn); // om man valt en anställd som ska ändras, väljer rätt namn på avdelningen i comboboxen
        }
    } else {
        JOptionPane.showMessageDialog(null, "Ingen anställd hittades med det angivna ID:t.");
    }
} catch (InfException e) {
    System.out.println("Ett fel inträffade: " + e.getMessage());
}
             try {
                 // Kontrollera om admins är null
                 if (admins != null) {
                     jCheckBox1.setEnabled(true); // Gör checkboxen klickbar
                 } else {
                     jCheckBox1.setEnabled(false); // Gör checkboxen oklickbar
                 }

                 // SQL-frågan för att hämta behörighetsnivån
                 String sqlFrågaAdmin = "Select behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
                 String adminst = idb.fetchSingle(sqlFrågaAdmin); // Hämtar resultatet
                 System.out.println(adminst);

                 // Kontrollera om det är den inloggade användaren
                 if (queryAid.equals(anvandare)) {
                     jCheckBox1.setEnabled(false); // Gör checkboxen oklickbar
                 } else {
                     // Kontrollera om admins är null
                     if (admins != null) {
                         jCheckBox1.setEnabled(true); // Gör checkboxen klickbar
                     } else {
                         jCheckBox1.setEnabled(false); // Gör checkboxen oklickbar
                     }
                 }

                 // Kontrollera om SQL-frågan returnerar ett resultat
                 if (adminst != null) {
                     jCheckBox1.setSelected(true); // Markera checkboxen
                 } else {
                     jCheckBox1.setSelected(false); // Avmarkera checkboxen
                 }

             } catch (InfException e) {
                 System.out.println("Ett fel inträffade: " + e.getMessage());
             }
 

    }
        } 
    private void fyllComboBox() {
        try {
            String query = "SELECT avdid, namn FROM avdelning";
            ArrayList<HashMap<String, String>> avdelningar = idb.fetchRows(query);

            if (avdelningar != null) {
                for (HashMap<String, String> avdelning : avdelningar) {
                    String avdid = avdelning.get("avdid");
                    String namn = avdelning.get("namn");

                    avdelningMap.put(namn, avdid);
                    comboAvdelning.addItem(namn); // Lägg till namnet i comboboxen
                }
            }
        } catch (InfException e) {
            System.out.println("Ett fel inträffade vid hämtning av avdelningar: " + e.getMessage());
        }
    }

    private String getAvdelningsNamnId(String avdid) {
        for (Map.Entry<String, String> entry : avdelningMap.entrySet()) {
            if (entry.getValue().equals(avdid)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFornamn = new javax.swing.JTextField();
        txtEfternamn = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtEpost = new javax.swing.JTextField();
        txtTelefonNr = new javax.swing.JTextField();
        txtanstallningsDatum = new javax.swing.JTextField();
        txtLosen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sparaKnapp = new javax.swing.JButton();
        comboAvdelning = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtFornamn.setActionCommand("<Not Set>");

        txtEfternamn.setActionCommand("<Not Set>");

        txtAdress.setActionCommand("<Not Set>");

        txtEpost.setActionCommand("<Not Set>");

        txtTelefonNr.setActionCommand("<Not Set>");

        txtanstallningsDatum.setActionCommand("<Not Set>");

        txtLosen.setActionCommand("<Not Set>");
        txtLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLosenActionPerformed(evt);
            }
        });

        jLabel1.setText("Förnamn:");

        jLabel2.setText("Efternamn:");

        jLabel3.setText("Adress:");

        jLabel4.setText("Telefonnr:");

        jLabel5.setText("Epost:");

        jLabel6.setText("Anstallningsdatum:");

        jLabel7.setText("Lösenord:");

        jLabel8.setText("Avdelning:");

        sparaKnapp.setText("Spara");
        sparaKnapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparaKnappActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Administratör");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtanstallningsDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEfternamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtFornamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelefonNr))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addComponent(comboAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(sparaKnapp))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefonNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtanstallningsDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(14, 14, 14)
                .addComponent(sparaKnapp)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sparaKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaKnappActionPerformed

        String fornamn = txtFornamn.getText();
        String efternamn = txtEfternamn.getText();
        String adress = txtAdress.getText();
        String epost = txtEpost.getText();
        String telefon = txtTelefonNr.getText();
        String ansdatum = txtanstallningsDatum.getText();
        String losen = txtLosen.getText();
        String avdelningsNamn = (String) comboAvdelning.getSelectedItem(); // Hämta valt namn från combobox
        String avdelningId = avdelningMap.get(avdelningsNamn);

        //validering av inmatad data
        if (Validering.faltEjTomtKontroll(txtFornamn)
                && Validering.faltEjTomtKontroll(txtEfternamn)
                && Validering.faltEjTomtKontroll(txtAdress)
                && Validering.faltEjTomtKontroll(txtEpost)
                && Validering.emailKontroll(txtEpost)
                && Validering.faltEjTomtKontroll(txtTelefonNr)
                && Validering.faltEjTomtKontroll(txtanstallningsDatum)
                && Validering.datumKontroll(txtanstallningsDatum)
                && Validering.faltEjTomtKontroll(txtLosen)) {
            
        try
        {
            if (queryAid == null || queryAid.isEmpty())
            {
            int aid = Integer.parseInt(idb.getAutoIncrement("anstalld", "aid"));
            String query = "INSERT INTO anstalld (aid, fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning)"
                    + " VALUES ("
                    + aid + ", '"
                    + fornamn + "', '"
                    + efternamn + "', '"
                    + adress + "', '"
                    + epost + "', '"
                    + telefon + "', '" 
                    + ansdatum + "', '"
                    + losen + "', "
                    + avdelningId + ")";
            System.out.println(query);
            idb.insert(query);
            queryAid = String.valueOf(aid);    
            }
            else
            {
                String query = "UPDATE anstalld "
                        + "SET fornamn = '" + fornamn + "', "
                        + "efternamn = '" + efternamn + "', "
                        + "adress = '" + adress + "', "
                        + "epost = '" + epost + "', "
                        + "telefon = '" + telefon + "', "
                        + "anstallningsdatum = '" + ansdatum + "', "
                        + "losenord = '" + losen + "', "
                        + "avdelning = '" + avdelningId + "' "
                        + "WHERE aid = " + queryAid;
                System.out.println(query);
                idb.update(query);

            }

                    if (jCheckBox1.isEnabled()) {
            String sqlFrågaAdmin = "SELECT behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
            String adminst = idb.fetchSingle(sqlFrågaAdmin);

            if (jCheckBox1.isSelected()) {
                // Om checkboxen är markerad och det inte redan finns en rad i admin
                if (adminst == null) {
                    String insertAdmin = "INSERT INTO admin (aid, behorighetsniva) VALUES ('" + queryAid + "', 1)";
                    System.out.println(insertAdmin);
                    idb.insert(insertAdmin);
                }
            } else {
                // Om checkboxen är avmarkerad och det finns en rad i admin
                if (adminst != null) {
                    String deleteAdmin = "DELETE FROM admin WHERE aid = '" + queryAid + "'";
                    System.out.println(deleteAdmin);
                    idb.delete(deleteAdmin);
                }
            }
        }
            
        JOptionPane.showMessageDialog(null, "Anställd har sparats.");
        this.setVisible(false);
        

        }
        catch(InfException e)
        {
            System.out.println("Ett fel inträffade: " + e.getMessage());
        }
        
           }  
    }//GEN-LAST:event_sparaKnappActionPerformed

    private void txtLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLosenActionPerformed

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
            java.util.logging.Logger.getLogger(EditAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAnstalld.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new EditAnstalld().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAvdelning;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton sparaKnapp;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtEfternamn;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtFornamn;
    private javax.swing.JTextField txtLosen;
    private javax.swing.JTextField txtTelefonNr;
    private javax.swing.JTextField txtanstallningsDatum;
    // End of variables declaration//GEN-END:variables
}
