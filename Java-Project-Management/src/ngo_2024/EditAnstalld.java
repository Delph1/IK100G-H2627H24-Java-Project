/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
    private String anvandare;
    private SimpleDateFormat datumformat;
    private AvdelningMeny avdelning;
    
    /**
     * Enkel konstruktor som gör det möjligt att anropa metoderna i klassen
     * @param idb
     */
    public EditAnstalld(InfDB idb) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        this.idb = idb;
        this.avdelningMap = new HashMap<>();
        this.datumformat = new SimpleDateFormat("yyyy-MM-dd");
        this.avdelning = new AvdelningMeny(idb);
        fyllComboBox();
        txtLosen.setText(genereraLösenord(8));
        jDateAnstallningsdatum.setEnabled(false);
        Date idag = new Date();
        jDateAnstallningsdatum.setDate(idag);
    }
    
    /**
     * Konstruktor som även tar hänsyn till användares rättigheter
     * @param idb
     * @param queryAid
     * @param admins
     * @param anvandare 
     */
    public EditAnstalld(InfDB idb, String queryAid, String admins, String anvandare) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        this.idb = idb;
        this.queryAid = queryAid;
        this.anvandare = anvandare;
        this.avdelning = new AvdelningMeny(idb);
        this.avdelningMap = new HashMap<>();
        this.datumformat = new SimpleDateFormat("yyyy-MM-dd");
        comboAvdelning.setVisible(true);
        fyllComboBox();

        if (queryAid != null && !queryAid.isEmpty()) {
            try {
                String query = "SELECT fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning FROM anstalld WHERE aid = '" + queryAid + "'";
                HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap
                try {
                    Date datum = datumformat.parse(resultat.get("anstallningsdatum"));
                    txtFornamn.setText(resultat.get("fornamn"));
                    txtEfternamn.setText(resultat.get("efternamn"));
                    txtAdress.setText(resultat.get("adress"));
                    txtEpost.setText(resultat.get("epost"));
                    txtTelefonNr.setText(resultat.get("telefon"));
                    jDateAnstallningsdatum.setDate(datum);
                    txtLosen.setText(resultat.get("losenord"));
                    String avdelning = resultat.get("avdelning");
                    String avdelningsNamn = getAvdelningsNamnId(avdelning); // sätt motsvarande namn från avdelning
                    if (avdelningsNamn != null) {
                        comboAvdelning.setSelectedItem(avdelningsNamn); // om man valt en anställd som ska ändras, väljer rätt namn på avdelningen i comboboxen
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datum är felaktigt formaterat");
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Det gick inte att hämta information om den anställde från databasen. Kontrollera att databasen fungerar som den ska.");
            }
            // Kontrollera om admins är null
            if (admins != null) {
                jCheckBoxAdmin.setEnabled(true); // Gör checkboxen klickbar
            } else {
                jCheckBoxAdmin.setEnabled(false); // Gör checkboxen oklickbar
            }
            String adminst;
            try {
                // SQL-frågan för att hämta behörighetsnivån
                String sqlFrågaAdmin = "Select behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
                adminst = idb.fetchSingle(sqlFrågaAdmin); // Hämtar resultatet
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Det gick inte att hämta information om behörighetsnivå från databasen. Kontrollera att databasen fungerar som den ska.");
                adminst = null;
            }
            String handlaggare;
            try {
                String sqlFrågahandl = "Select aid FROM handlaggare WHERE aid = '" + queryAid + "'";
                handlaggare = idb.fetchSingle(sqlFrågahandl); // Hämtar resultatet
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "Det gick inte att hämta information om handläggare från databasen. Kontrollera att databasen fungerar som den ska.");
                handlaggare = null;
            }
                
            // Kontrollera om det är den inloggade användaren
            if (queryAid.equals(anvandare)) {
                jCheckBoxAdmin.setEnabled(false); // Gör checkboxen oklickbar
                jCheckBoxHandlaggare.setEnabled(false); // Gör checkboxen oklickbar
                jDateAnstallningsdatum.setEnabled(false);
                comboAvdelning.setEnabled(false);
                this.setTitle("Mina uppgifter");
            } else {
                // Kontrollera om admins är null
                if (admins != null) {
                    jCheckBoxAdmin.setEnabled(true); // Gör checkboxen klickbar
                    jCheckBoxHandlaggare.setEnabled(true); // Gör checkboxen klickbar
                } else {
                    jCheckBoxAdmin.setEnabled(false); // Gör checkboxen oklickbar
                    jCheckBoxHandlaggare.setEnabled(false); // Gör checkboxen oklickbar
                }
            }
            
            // Kontrollera om SQL-frågan returnerar ett resultat
            if (adminst != null) {
                jCheckBoxAdmin.setSelected(true); // Markera checkboxen
            } else {
                jCheckBoxAdmin.setSelected(false); // Avmarkera checkboxen
            }
            if (handlaggare != null) {
                jCheckBoxHandlaggare.setSelected(true); // Markera checkboxen
            } else {
                jCheckBoxHandlaggare.setSelected(false); // Avmarkera checkboxen
            }
        }
    }
    
    /**
     * Hämtar ut avdid och namn från databasen och fyller upp comboboxen. 
     */
    private void fyllComboBox() {
        ArrayList<HashMap<String, String>> avdelningar = avdelning.getAvdelningar();
        if (avdelningar != null)
        for (HashMap<String, String> enAvdelning : avdelningar) {
            String avdid = enAvdelning.get("avdid");
            String namn = enAvdelning.get("namn");

            avdelningMap.put(namn, avdid);
            comboAvdelning.addItem(namn); // Lägg till namnet i comboboxen
        } else {
            JOptionPane.showMessageDialog(this, "Inga avdelningar hittades i databasen.");
        }
    }
    
    /**
     * Metod som hämtar ut namn från avdid från HashMap som skapats upp.
     * @param avdid
     * @return 
     */
    private String getAvdelningsNamnId(String avdid) {
        String namn = null;
        for (Map.Entry<String, String> entry : avdelningMap.entrySet()) {
            if (entry.getValue().equals(avdid)) {
                namn = entry.getKey();
            }
        }
        return namn;
    }
    
    /**
     * Metod för att generera ett lösenord. 
     * @param langd
     * @return 
     */
    public static String genereraLösenord(int langd) {
        String tillatnaTecken = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder slumpatLosenord = new StringBuilder();

        // Generera lösenord
        for (int i = 0; i < langd; i++) {
            int index = random.nextInt(tillatnaTecken.length());
            slumpatLosenord.append(tillatnaTecken.charAt(index));
        }
        return slumpatLosenord.toString();
    }
    
    /**
     * Kontrollerar om en e-postadress finns i databasen. Används vid inloggning.
     * @param epost
     * @return 
     */
    public boolean finnsEpost(String epost) {
        boolean epostFinns = false;
        try {
            String query = "SELECT losenord FROM anstalld WHERE epost = '" + epost + "'";
            String resultat = idb.fetchSingle(query);
            if (resultat != null) {
                epostFinns = true;
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "E-postadressen finns inte i datrabasen.");
        }
        return epostFinns;
    }
    
    /**
     * Metod som uppdaterar lösenord för en användare
     * @param epost
     * @param nyttLosen 
     * @return
     */
    public boolean uppdateraLosenord(String epost, String nyttLosen) {
        boolean success = false;
        try {
            String query = "UPDATE anstalld SET losenord = '" + nyttLosen + "' WHERE epost = '" + epost + "'";
            idb.update(query);
            success = true;
        } catch (InfException e) {
            JOptionPane.showMessageDialog(this, "Det gick inte att uppdatera lösenordet.");
        }
        return success;
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
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jCheckBoxHandlaggare = new javax.swing.JCheckBox();
        SlumpLosen = new javax.swing.JButton();
        jDateAnstallningsdatum = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redigera anställd");

        txtFornamn.setActionCommand("<Not Set>");

        txtEfternamn.setActionCommand("<Not Set>");

        txtAdress.setActionCommand("<Not Set>");

        txtEpost.setActionCommand("<Not Set>");

        txtTelefonNr.setActionCommand("<Not Set>");

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

        jCheckBoxAdmin.setText("Administratör");

        jCheckBoxHandlaggare.setText("Handläggare");

        SlumpLosen.setText("Slumpa lösenord");
        SlumpLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SlumpLosenActionPerformed(evt);
            }
        });

        jDateAnstallningsdatum.setDateFormatString("yyyy-MM-dd");

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
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtAdress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEfternamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtFornamn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jDateAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTelefonNr))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBoxHandlaggare))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBoxAdmin)
                                .addComponent(SlumpLosen))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jDateAnstallningsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxHandlaggare)
                    .addComponent(jCheckBoxAdmin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sparaKnapp)
                    .addComponent(SlumpLosen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sparaKnappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparaKnappActionPerformed

        String fornamn = txtFornamn.getText();
        String efternamn = txtEfternamn.getText();
        String adress = txtAdress.getText();
        String epost = txtEpost.getText();
        String telefon = txtTelefonNr.getText();
        String ansdatum = datumformat.format(jDateAnstallningsdatum.getDate());
        String losen = txtLosen.getText();
        String avdelningsNamn = (String) comboAvdelning.getSelectedItem(); // Hämta valt namn från combobox
        String avdelningId = avdelningMap.get(avdelningsNamn);

        //validering av inmatad data
        if (Validering.faltEjTomtKontroll(txtFornamn)
                && Validering.faltEjTomtKontroll(txtEfternamn)
                && Validering.faltEjTomtKontroll(txtAdress)
                && Validering.faltEjTomtKontroll(txtEpost)
                && Validering.epostKontroll(txtEpost.getText())
                && Validering.faltEjTomtKontroll(txtTelefonNr)
                && Validering.datumKontroll(ansdatum)
                && Validering.faltEjTomtKontroll(txtLosen)) {

            try {
                if (queryAid == null || queryAid.isEmpty()) {
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
                    //System.out.println(query);
                    try {
                        idb.insert(query);
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Det gick inte att spara den nya personen i databasen.");
                    }
                    queryAid = String.valueOf(aid);
                } else {
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
                    //System.out.println(query);
                    try {
                        idb.update(query);
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Det gick inte att uppdatera personen i databasen.");
                    }

                }

                if (jCheckBoxAdmin.isEnabled()) {
                    try {
                        String sqlFrågaAdmin = "SELECT behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
                        String adminst = idb.fetchSingle(sqlFrågaAdmin);

                        if (jCheckBoxAdmin.isSelected()) {
                            // Om checkboxen är markerad och det inte redan finns en rad i admin
                            if (adminst == null) {
                                String insertAdmin = "INSERT INTO admin (aid, behorighetsniva) VALUES ('" + queryAid + "', 1)";
                                //System.out.println(insertAdmin);
                                try {
                                    idb.insert(insertAdmin);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att sätta användaren som en administratör i databasen.");                        
                                }
                            }
                        } else {

                            // Om checkboxen är avmarkerad och det finns en rad i handlaggare
                            if (adminst != null) {
                                String deleteAdmin = "DELETE FROM admin WHERE aid = '" + queryAid + "'";
                                //System.out.println(deleteAdmin);
                                try {
                                    idb.delete(deleteAdmin);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att ta bort användaren från administratörer databasen.");                        
                                }                                    
                            }
                        }
                    } catch(InfException e) {
                        JOptionPane.showMessageDialog(this, "Det gick inte att hämta behörighetsnivå från databasen.");                        
                    }
                }
                if (jCheckBoxHandlaggare.isEnabled()) {
                    try {
                        String sqlFragaHandl = "SELECT aid FROM handlaggare WHERE aid = '" + queryAid + "'";
                        String handlaggare = idb.fetchSingle(sqlFragaHandl);

                        if (jCheckBoxHandlaggare.isSelected()) {
                            // Om checkboxen är markerad och det inte redan finns en rad i handlaggare
                            if (handlaggare == null) {
                                String inserthandlaggare = "INSERT INTO handlaggare (aid, ansvarighetsomrade, mentor) VALUES ('" + queryAid + "', null, null)";
                                System.out.println(inserthandlaggare);
                                try {
                                    idb.insert(inserthandlaggare);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att göra personen till en handläggare. Databasen uppdaterades inte.");
                                }
                            }
                        } else {
                            // Om checkboxen är avmarkerad och det finns en rad i handlaggare
                            if (handlaggare != null) {
                                try {
                                    // Kolla om handläggaren är refererad i projekt
                                    String checkProjekt = "SELECT COUNT(*) AS count FROM projekt WHERE projektchef = '" + queryAid + "'";
                                    int antalProjekt = Integer.parseInt(idb.fetchSingle(checkProjekt));

                                    if (antalProjekt > 0) {
                                        // Uppdatera projektchef till NULL om det finns referenser
                                        String updateProjekt = "UPDATE projekt SET projektchef = NULL WHERE projektchef = '" + queryAid + "'";
                                        //System.out.println(updateProjekt);
                                        idb.update(updateProjekt);
                                    }
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att kolla om personen är projektchef för några projekt. ");                                    
                                }
                                
                                //Tar bort som chef för en avdelning ... om det finns
                                try {
                                    String updateavdelning = "UPDATE avdelning SET chef = NULL WHERE chef = '" + queryAid + "'";
                                    System.out.println(updateavdelning);
                                    idb.update(updateavdelning);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att uppdatera tabellen avdelning.");                                    
                                }
                                
                                //Tar bort eventuella mentorsroller.
                                try {
                                    String updatementor = "UPDATE handlaggare SET mentor = NULL WHERE mentor = '" + queryAid + "'";
                                    System.out.println(updatementor);
                                    idb.update(updatementor);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att uppdatera mentorsrollerna i handläggare.");                                    
                                }

                                // Ta bort handläggaren från handlaggare-tabellen
                                try {
                                    String deleteHandlaggare = "DELETE FROM handlaggare WHERE aid = '" + queryAid + "'";
                                    System.out.println(deleteHandlaggare);
                                    idb.delete(deleteHandlaggare);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att radera personen från handlaggare.");                                    
                                }

                                // Ta bort handläggaren från ans_proj-tabellen. Vi är lite osäkra på om detta ska göras, men vi har lagt in det för det verkar troligt att det ska vara så.
                                try {
                                    String deleteproj = "DELETE FROM ans_proj WHERE aid = '" + queryAid + "'";
                                    System.out.println(deleteproj);
                                    idb.delete(deleteproj);
                                } catch (InfException e) {
                                    JOptionPane.showMessageDialog(this, "Det gick inte att ta bort personens koppling till projekt.");                                    
                                }
                            }
                        }
                    } catch (InfException e) {
                        JOptionPane.showMessageDialog(this, "Det gick inte att hämta från tabellen \"handlaggare\".");                        
                    }
                }

                JOptionPane.showMessageDialog(null, "Anställd har sparats.");
                this.setVisible(false);

            } catch (InfException e) {
                System.out.println("Det gick inte att hämta nästa ID-nummer från databasen.");
            }

        }
    }//GEN-LAST:event_sparaKnappActionPerformed

    private void txtLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLosenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLosenActionPerformed

    private void SlumpLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SlumpLosenActionPerformed
       String newPassword = genereraLösenord(10); 
       txtLosen.setText(newPassword);
    }//GEN-LAST:event_SlumpLosenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SlumpLosen;
    private javax.swing.JComboBox<String> comboAvdelning;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JCheckBox jCheckBoxHandlaggare;
    private com.toedter.calendar.JDateChooser jDateAnstallningsdatum;
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
    // End of variables declaration//GEN-END:variables
}
