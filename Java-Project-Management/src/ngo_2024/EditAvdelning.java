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
        }
        else
            //Om det inte finns döljs fälten för ID, eftersom de är tomma värden och ska inte heller fyllas i.
        {
            lblId.setVisible(false);
            txtId.setVisible(false);
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
        ArrayList<HashMap<String, String>> allaAnstallda = anstalld.getAllaAnstallda();
        HashMap<String, String> enAnstalld;
        for (int i = 0; i < allaAnstallda.size(); i++) {
            enAnstalld = allaAnstallda.get(i);
            {
                chefLista.put(enAnstalld.get("aid"), enAnstalld.get("fornamn") + " " + enAnstalld.get("efternamn"));
            }
        }
        return chefLista;
    }

    /**
     * Metod för att skapa upp alla val i komboboxen med Chefen, med dens namn. 
     * @param chefLista 
     */
    private void populeraCbChefNamn(HashMap<String, String> chefLista) {
        //Lägger till nuvarande chefen först i listan
        cbChefNamn.addItem(chefLista.get(txtChefId.getText()));

        //lägger till alla andra efter det.
        for (String key : chefLista.keySet()) {
            if (!key.equals(txtChefId.getText())) {
                cbChefNamn.addItem(chefLista.get(key));
            }
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
        lblId = new javax.swing.JLabel();
        btnAvbryt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        lblId.setText("Id:");

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
                    .addComponent(lblChef))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAvbryt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBeskrivning)
                                    .addComponent(txtNamn)
                                    .addComponent(txtAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEpost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(txtTelefon))
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtChefId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbStadNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, 144, Short.MAX_VALUE)
                            .addComponent(cbChefNamn, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamn)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtChefId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStad)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(btnAvbryt))
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblChef)
                                .addContainerGap(60, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbStadNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbChefNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nedan följer knapparnas funktioner.
     */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //Validering nedan
        if (Validering.faltEjTomtKontroll(txtNamn)
                && Validering.faltEjTomtKontroll(txtBeskrivning)
                && Validering.faltEjTomtKontroll(txtAdress)
                && Validering.faltEjTomtKontroll(txtEpost)
                && Validering.faltEjTomtKontroll(txtTelefon)
                && Validering.faltEjTomtKontroll(txtStadId)
                && Validering.faltEjTomtKontroll(txtChefId)) {
            String namn = txtNamn.getText();
            String beskrivning = txtBeskrivning.getText();
            String adress = txtAdress.getText();
            String epost = txtEpost.getText();
            String telefon = txtTelefon.getText();
            int stad = Integer.parseInt(txtStadId.getText());
            int chef = Integer.parseInt(txtChefId.getText());

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
    private javax.swing.JLabel lblId;
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
