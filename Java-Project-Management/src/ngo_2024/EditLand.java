package ngo_2024;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Klass för redigering av Land
 * @author Claudia Kourieh
 */

public class EditLand extends javax.swing.JFrame {
    private InfDB idb;
    private String lid;

    public EditLand(InfDB idb, String lid) {
        this.idb = idb;
        this.lid = lid;
        initComponents();
        setLocationRelativeTo(null); // Centrerar fönstret
        laddaLandData();
    }

    /**
     * Hämtar och visar landets data i fälten
     */ 
    private void laddaLandData() {

        if (lid != null) {
            try {
                String query = "SELECT namn, sprak, valuta, tidszon, politisk_struktur, ekonomi FROM land WHERE lid = '" + lid + "'";
                HashMap<String, String> resultat = idb.fetchRow(query);

                if (resultat != null) {
                    txtNamn.setText(resultat.get("namn"));
                    txtSprak.setText(resultat.get("sprak"));
                    txtValuta.setText(resultat.get("valuta"));
                    txtTidszon.setText(resultat.get("tidszon"));
                    txtPolitiskstruktur.setText(resultat.get("politisk_struktur"));
                    txtEkonomi.setText(resultat.get("ekonomi"));
                } else {
                    JOptionPane.showMessageDialog(this, "Inget land hittades med ID: " + lid);
                    dispose(); // Stäng fönstret om inget land hittas
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Fel vid hämtning av landdata från databasen. Kontrollera att databasen fungerar som den ska.");
            }
        }
    }

    /**
     * Uppdaterar landets data i databasen
     */
    private void sparaLandData() {
        if (Validering.faltEjTomtKontroll(txtNamn)
                && Validering.faltEjTomtKontroll(txtSprak)
                && Validering.faltEjTomtKontroll(txtValuta)
                && Validering.faltEjTomtKontroll(txtTidszon)
                && Validering.faltEjTomtKontroll(txtPolitiskstruktur)
                && Validering.faltEjTomtKontroll(txtEkonomi)
                && Validering.arDecimal(txtValuta)) {
            if (lid == null) {
                try {
                    String nyttLandId = idb.getAutoIncrement("land", "lid");
                    try {
                        // Hämta värden från textfälten
                        String namn = txtNamn.getText();
                        String sprak = txtSprak.getText();
                        String valuta = txtValuta.getText();
                        String tidszon = txtTidszon.getText();
                        String politiskStruktur = txtPolitiskstruktur.getText();
                        String ekonomi = txtEkonomi.getText();

                        // Uppdatera landets data i databasen
                        String query = "INSERT INTO land (lid, namn, sprak, valuta, tidszon, politisk_struktur, ekonomi ) VALUES ('"
                                + nyttLandId + "', '"
                                + namn + "', '"
                                + sprak + "', '"
                                + valuta + "', '"
                                + tidszon + "', '"
                                + politiskStruktur + "', '"
                                + ekonomi + "')";
                        System.out.println(query);
                        idb.insert(query);
                        JOptionPane.showMessageDialog(this, "Landdata har uppdaterats!");
                        dispose(); // Stänger fönstret efter uppdatering
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Landet kunde inte uppdateras. Kontrollera att databasen fungerar som den ska.");
                    }
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Fel vid hämtning av nästa ID-nummer från databasen. Kontrollera att databasen fugnerar som den ska.");
                }
            } else {
                try {
                    // Hämta värden från textfälten
                    String namn = txtNamn.getText();
                    String sprak = txtSprak.getText();
                    String valuta = txtValuta.getText();
                    String tidszon = txtTidszon.getText();
                    String politiskStruktur = txtPolitiskstruktur.getText();
                    String ekonomi = txtEkonomi.getText();

                    // Uppdatera landets data i databasen
                    String query = "UPDATE land SET "
                            + "namn = '" + namn + "', "
                            + "sprak = '" + sprak + "', "
                            + "valuta = '" + valuta + "', "
                            + "tidszon = '" + tidszon + "', "
                            + "politisk_struktur = '" + politiskStruktur + "', "
                            + "ekonomi = '" + ekonomi + "' "
                            + "WHERE lid = '" + lid + "'";

                    idb.update(query);
                    JOptionPane.showMessageDialog(this, "Landdata har uppdaterats!");
                    dispose(); // Stänger fönstret efter uppdatering
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Fel vid uppdatering: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Landdata har inte uppdaterats!");
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

        lbNamn = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        lbSprak = new javax.swing.JLabel();
        txtSprak = new javax.swing.JTextField();
        lbValuta = new javax.swing.JLabel();
        txtValuta = new javax.swing.JTextField();
        lbTidszon = new javax.swing.JLabel();
        txtTidszon = new javax.swing.JTextField();
        lbPolitiskStruktur = new javax.swing.JLabel();
        txtPolitiskstruktur = new javax.swing.JTextField();
        lbEkonomi = new javax.swing.JLabel();
        txtEkonomi = new javax.swing.JTextField();
        btSpara = new javax.swing.JButton();
        btAvbryt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redigera land");

        lbNamn.setText("Namn");

        lbSprak.setText("Språk");

        lbValuta.setText("Valuta");

        lbTidszon.setText("Tidszon");

        lbPolitiskStruktur.setText("Politisk Struktur");

        lbEkonomi.setText("Ekonomi");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAvbryt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSpara))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValuta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSprak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPolitiskStruktur, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTidszon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPolitiskstruktur, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEkonomi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNamn)
                            .addComponent(txtSprak)
                            .addComponent(txtValuta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamn)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSprak)
                    .addComponent(txtSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValuta)
                    .addComponent(txtValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTidszon)
                    .addComponent(txtTidszon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPolitiskStruktur)
                    .addComponent(txtPolitiskstruktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEkonomi)
                    .addComponent(txtEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSpara)
                    .addComponent(btAvbryt))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Knappar följer nedan
     */
    
    private void btAvbrytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvbrytActionPerformed
        dispose();
    }//GEN-LAST:event_btAvbrytActionPerformed

    private void btSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSparaActionPerformed
        sparaLandData();
    }//GEN-LAST:event_btSparaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAvbryt;
    private javax.swing.JButton btSpara;
    private javax.swing.JLabel lbEkonomi;
    private javax.swing.JLabel lbNamn;
    private javax.swing.JLabel lbPolitiskStruktur;
    private javax.swing.JLabel lbSprak;
    private javax.swing.JLabel lbTidszon;
    private javax.swing.JLabel lbValuta;
    private javax.swing.JTextField txtEkonomi;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtPolitiskstruktur;
    private javax.swing.JTextField txtSprak;
    private javax.swing.JTextField txtTidszon;
    private javax.swing.JTextField txtValuta;
    // End of variables declaration//GEN-END:variables
}
