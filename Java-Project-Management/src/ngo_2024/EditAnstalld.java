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
    private String avdId;
    private String admins;
    private String anvandare;
    private HashMap<String, String> avdelningMap;
    
    /**
     * Creates new form EditAnstalld
     */

    public EditAnstalld(InfDB idb, String queryAid, String admins, String anvandare) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        this.idb = idb;
        this.admins = admins;
        this.queryAid = queryAid;
        this.anvandare = anvandare;
        this.avdelningMap = new HashMap<>();

        jComboBox2.setVisible(true);
        fyllComboBox();
      
         if (queryAid != null && !queryAid.isEmpty()) {
try {          
    String query = "SELECT fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning FROM anstalld WHERE aid = '" + queryAid + "'";

    HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap
    
    if (resultat != null) {
        // Hämta och sätt värden i motsvarande textfält

        jTextField1.setText(resultat.get("fornamn"));
        jTextField2.setText(resultat.get("efternamn"));
        jTextField3.setText(resultat.get("adress"));       
        jTextField4.setText(resultat.get("epost"));         
        jTextField5.setText(resultat.get("telefon"));
        jTextField6.setText(resultat.get("anstallningsdatum"));
        jTextField7.setText(resultat.get("losenord"));
        String avdelning = resultat.get("avdelning");
        String avdelningsNamn = getAvdelningsNamnId(avdelning); // sätt motsvarande namn från avdelning
        if (avdelningsNamn != null) {
            jComboBox2.setSelectedItem(avdelningsNamn); // om man valt en anställd som ska ändras, väljer rätt namn på avdelningen i comboboxen
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
                    jComboBox2.addItem(namn); // Lägg till namnet i comboboxen
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.setActionCommand("<Not Set>");

        jTextField2.setActionCommand("<Not Set>");

        jTextField3.setActionCommand("<Not Set>");

        jTextField4.setActionCommand("<Not Set>");

        jTextField5.setActionCommand("<Not Set>");

        jTextField6.setActionCommand("<Not Set>");

        jTextField7.setActionCommand("<Not Set>");

        jLabel1.setText("Förnamn:");

        jLabel2.setText("Efternamn:");

        jLabel3.setText("Adress:");

        jLabel4.setText("Telefonnr:");

        jLabel5.setText("Epost:");

        jLabel6.setText("Anstallningsdatum:");

        jLabel7.setText("Lösenord:");

        jLabel8.setText("Avdelning:");

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox1)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fornamn = jTextField1.getText();
        String efternamn = jTextField2.getText();
        String adress = jTextField3.getText();
        String epost = jTextField4.getText();
        String telefon = jTextField5.getText();
        String ansdatum = jTextField6.getText();
        String losen = jTextField7.getText();
        //String avdelning = jTextField8.getText();
        String avdelningsNamn = (String) jComboBox2.getSelectedItem(); // Hämta valt namn från combobox
        String avdelningId = avdelningMap.get(avdelningsNamn);

        
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
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
