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
 * Klass för att ändra eller skapa en ny avdelning.
 * @author Andreas Galistel
 */
public class EditAvdelning extends javax.swing.JFrame {
    
    private InfDB idb;
    private String queryAid;
    private AnstalldMeny anstalld;
    private StadMeny stad;
    private HashMap<String, String> chefLista;
    private ArrayList<HashMap<String, String>> allaStader;
    private AvdelningMeny avdelning;


    /**
     * Konstruktor för EditAvdelning
     * @param idb
     * @param queryAid 
     */    
    public EditAvdelning(InfDB idb, String queryAid) {
        this.idb = idb;
        this.queryAid = queryAid;
        this.anstalld = new AnstalldMeny(idb);
        this.stad = new StadMeny(idb);
        this.chefLista = new HashMap<>();
        this.allaStader = new ArrayList<>();
        this.avdelning = new AvdelningMeny(idb);
        skapaChefHashMap();
        initComponents();
        setLocationRelativeTo(null);
        
        //Kollar här om det finns en parameter satt för queryAid och i så fall hämtar den ut data för den avdelningen. 
        if (queryAid != null)
        {
            getAvdelningsdata(queryAid);
            txtId.setVisible(false);
        }
        else
            //Om det inte finns döljs fälten för ID, eftersom de är tomma värden och ska inte heller fyllas i.
        {
            txtId.setVisible(false);
            this.setTitle("Ny avdelning");
        }
        //Döljer ID-fälten för Chef och Stad. Istället visar vi de utskrivna fälten som har de faktiska nämnen på chefen och staden. 
        txtStadId.setVisible(false);
        txtChefId.setVisible(false);
        populeraCbChefNamn(chefLista);
        populeraCbStad();
    }
    
    /**
     * Metod som hämtar ut en HashMap på alla anställda. Detta användes sedan vid val av Chef för en avdelning. 
     * Första String är aid, det andra är en konkatenering av Förnamn och Efternamn.
     * @return HashMap<String, String>
     */
    private HashMap<String, String> skapaChefHashMap() {
        String sqlHandlaggare = "select * from anstalld where aid in (select aid from handlaggare)";
        ArrayList<HashMap<String,String>> allaHandlaggare = new ArrayList<>();
        try {
             allaHandlaggare = idb.fetchRows(sqlHandlaggare);
        }
        catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta handläggare");
        }
        HashMap<String, String> enHandlaggare;
        for (int i = 0; i < allaHandlaggare.size(); i++) {
            enHandlaggare = allaHandlaggare.get(i);
            {
                chefLista.put(enHandlaggare.get("aid"), enHandlaggare.get("fornamn") + " " + enHandlaggare.get("efternamn"));
            }
        }
        return chefLista;
    }

    /**
     * Metod för att skapa upp alla val i komboboxen med Chefen, med dens namn. 
     * @param chefLista 
     */
    private void populeraCbChefNamn(HashMap<String, String> chefLista) {
        String nuvarandeChefId = txtChefId.getText();
        boolean chefFunnen = false;

        for (String key : chefLista.keySet()) {
            String chefNamn = chefLista.get(key);
            cbChefNamn.addItem(chefNamn);

            // Välj nuvarande chef om det är en redigering
            if (key.equals(nuvarandeChefId)) {
                cbChefNamn.setSelectedItem(chefNamn);
                txtChefId.setText(key);
                chefFunnen = true;
            }
        }

        // Om ingen chef är förvald, välj den första personen
        if (!chefFunnen && !chefLista.isEmpty()) {
            String förstaKey = chefLista.keySet().iterator().next();
            cbChefNamn.setSelectedItem(chefLista.get(förstaKey));
            txtChefId.setText(förstaKey);
        }
    }

    
    /**
     * Metod som hämtar ut alla städer och sedan skapar upp en vallista i komboboxen för Stad. 
     */
    private void populeraCbStad() {
        allaStader = stad.getAllaStader();
        //Lägger till nuvarande staden först i listan
        for (HashMap<String, String> enStad : allaStader) {
            if (enStad.get("sid").equals(txtStadId.getText())) {
                cbStadNamn.addItem(enStad.get("namn"));
            }
        }
        //och sedan resten.
        for (HashMap<String, String> enStad : allaStader) {
            if (!enStad.get("sid").equals(txtStadId.getText())) {
                cbStadNamn.addItem(enStad.get("namn"));
            }
        }
    }

    /**
     * Metod som hämtar ut avdelningsdata för en vald avdelning
     * @param queryAid 
     */
    private void getAvdelningsdata(String queryAid) {
        HashMap<String, String> resultat = avdelning.getEnAvdelning(queryAid); // Hämta rad som en HashMap

        if (resultat != null) {
            // Hämta och sätt värden i motsvarande textfält
            txtNamn.setText(resultat.get("namn"));
            txtBeskrivning.setText(resultat.get("beskrivning"));
            txtAdress.setText(resultat.get("adress"));
            txtEpost.setText(resultat.get("epost"));
            txtTelefon.setText(resultat.get("telefon"));
            txtStadId.setText(resultat.get("stad"));
            txtChefId.setText(resultat.get("chef"));

        } else {
            JOptionPane.showMessageDialog(null, "Ingen avdelning hittades med det angivna ID:t.");
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

        txtNamn = new javax.swing.JTextField();
        lblNamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        txtBeskrivning = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblEpost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        lblChef = new javax.swing.JLabel();
        txtEpost = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtStadId = new javax.swing.JTextField();
        txtChefId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbStadNamn = new javax.swing.JComboBox<>();
        cbChefNamn = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        btnAvbryt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redigera avdelning");

        txtNamn.setColumns(10);
        txtNamn.setToolTipText("");

        lblNamn.setText("Namn:");

        lblBeskrivning.setText("Beskrivning:");

        txtBeskrivning.setColumns(10);

        lblAdress.setText("Adress:");

        txtAdress.setColumns(10);

        lblEpost.setText("E-post:");

        lblTelefon.setText("Telefon:");

        lblStad.setText("Stad:");

        lblChef.setText("Chef:");

        txtEpost.setColumns(10);

        txtTelefon.setColumns(10);

        txtStadId.setColumns(10);

        txtChefId.setColumns(10);

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbStadNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStadNamnActionPerformed(evt);
            }
        });

        cbChefNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChefNamnActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        btnAvbryt.setText("Avbryt");
        btnAvbryt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvbrytActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamn)
                    .addComponent(lblBeskrivning)
                    .addComponent(lblAdress)
                    .addComponent(lblEpost)
                    .addComponent(lblTelefon)
                    .addComponent(lblStad)
                    .addComponent(lblChef)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtChefId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBeskrivning)
                    .addComponent(txtAdress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEpost, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefon)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAvbryt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(cbChefNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbStadNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamn))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeskrivning)
                    .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEpost)
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefon)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStad)
                        .addGap(24, 24, 24)
                        .addComponent(lblChef)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChefId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbStadNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbChefNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAvbryt)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nedan följer knapparnas funktioner.
     */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String namn = txtNamn.getText();
        String beskrivning = txtBeskrivning.getText();
        String adress = txtAdress.getText();
        String epost = txtEpost.getText();
        String telefon = txtTelefon.getText();
        int stad = Integer.parseInt(txtStadId.getText());
        int chef = Integer.parseInt(txtChefId.getText());

        //Valideringen
        if (Validering.faltEjTomtKontroll(txtNamn)
                && Validering.faltEjTomtKontroll(txtBeskrivning)
                && Validering.faltEjTomtKontroll(txtAdress)
                && Validering.faltEjTomtKontroll(txtEpost)
                && Validering.epostKontroll(epost)
                && Validering.faltEjTomtKontroll(txtTelefon)
                && Validering.telefonKontroll(telefon)
                && Validering.faltEjTomtKontroll(txtStadId)
                && Validering.faltEjTomtKontroll(txtChefId)) {

            if (queryAid == null) {
                try {
                    int avdid = Integer.parseInt(idb.getAutoIncrement("avdelning", "avdid"));
                    String query = "INSERT INTO avdelning (avdid, namn, beskrivning, adress, epost, telefon, stad, chef)"
                            + " VALUES ("
                            + avdid + ", '"
                            + namn + "', '"
                            + beskrivning + "', '"
                            + adress + "', '"
                            + epost + "', '"
                            + telefon + "', "
                            + stad + ", "
                            + chef + ")";
                    System.out.println(query);
                    idb.insert(query);
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Avdelningen gick inte att skapa. Kontrollera att databasen fungerar som den ska.");
                }
            } else {
                try {
                    String query = "UPDATE avdelning "
                            + "SET namn = '" + namn + "', "
                            + "beskrivning = '" + beskrivning + "', "
                            + "adress = '" + adress + "', "
                            + "epost = '" + epost + "', "
                            + "telefon = '" + telefon + "', "
                            + "stad = " + stad + ", "
                            + "chef = " + chef
                            + " WHERE avdid = " + queryAid;
                    System.out.println(query);
                    idb.update(query);
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Avdelningen gick inte att uppdatera. Kontrollera att databasen fungerar som den ska.");
                }
            }
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * När man klickar och väljer en chef i listan sätts rätt id in i ID-rutan.
     * @param evt 
     */
    private void cbChefNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChefNamnActionPerformed
       String nyChef = cbChefNamn.getSelectedItem().toString();
        for (String chef : chefLista.keySet())
        {
            if (chefLista.get(chef).equals(nyChef))
            {
                txtChefId.setText(chef);
            }
        }
    }//GEN-LAST:event_cbChefNamnActionPerformed

    /**
     * Uppdaterar txtStadId med rätt Id när man väljer en ny stad i listan.
     * @param evt 
     */
    private void cbStadNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStadNamnActionPerformed
        String nyStad = cbStadNamn.getSelectedItem().toString();
        for(HashMap<String, String> enStad : allaStader)
        {
            if(enStad.get("namn").equals(nyStad))
            {
                txtStadId.setText(enStad.get("sid"));
            }
        }
    }//GEN-LAST:event_cbStadNamnActionPerformed

    private void btnAvbrytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvbrytActionPerformed
        dispose();
    }//GEN-LAST:event_btnAvbrytActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvbryt;
    private javax.swing.JComboBox<String> cbChefNamn;
    private javax.swing.JComboBox<String> cbStadNamn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblChef;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBeskrivning;
    private javax.swing.JTextField txtChefId;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtStadId;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
