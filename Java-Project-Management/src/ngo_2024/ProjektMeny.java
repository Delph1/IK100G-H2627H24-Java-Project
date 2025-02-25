/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Märta Sjöblom
 */
public class ProjektMeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String aid;
    private boolean projCh;
    private boolean admin;
    private AvdelningMeny avdelning;
    private AnstalldMeny anstalld;
    private int index; //För uppdatera projekttabell efter ändringar
    DefaultTableModel tableModel = new DefaultTableModel();
    
    /**
     * Admin-vy
     * @param idb
     */
    public ProjektMeny(InfDB idb) {
        this.idb = idb;
        this.avdelning = new AvdelningMeny(idb);
        this.anstalld = new AnstalldMeny(idb);
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        hamtaProjekt();
        admin = true;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    }
    
    /**
     * Konstruktor för Mina projekt
     * @param idb
     * @param aid 
     */
    public ProjektMeny(InfDB idb, String aid) {
        this.idb = idb;
        this.aid = aid;
        this.anstalld = new AnstalldMeny(idb);
        initComponents();
        btnMinaProjekt.setVisible(false);
        btnAllaProjekt.setVisible(false);   //Behöver inte kunna se dessa
        lblAvdelning.setVisible(false);
        cmbAvdelningsVal.setVisible(false);
        lblStatus.setVisible(false);
        cmbStatus.setVisible(false);
        btnPartners.setVisible(false);
        btnAndraProjekt.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        hamtaProjekt(aid);
    }
    
   /**
    * Konstruktor för att visa avdelningsvy
    * @param idb
    * @param avdelning
    * @param aid 
    */
    public ProjektMeny(InfDB idb, boolean avdelning, String aid) {
        this.idb = idb;
        this.aid = aid;
        this.avdelning = new AvdelningMeny(idb);
        this.anstalld = new AnstalldMeny(idb);
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        setLocationRelativeTo(null);
        btnTaBortProjekt.setVisible(false);
        btnMinaProjekt.setVisible(false);
        btnAndraProjekt.setVisible(false);
        btnLaggTillProjekt.setVisible(false);
        btnPartners.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hamtaProjektAvdelning(aid);
    }
    
    /**
     * Konstruktor för Projektledare, tar bort och lägger till saker i menyn därefter
     * @param idb
     * @param aid
     * @param projCh 
     */
    public ProjektMeny(InfDB idb, String aid, boolean projCh) {
        this.idb = idb;
        this.aid = aid;
        this.projCh = projCh;
        this.avdelning = new AvdelningMeny(idb);
        this.anstalld = new AnstalldMeny(idb);
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        hamtaProjekt(aid);
        this.setTitle("Projektledare");
        lblAvdelning.setVisible(false); //Behöver inte kunna se dessa
        cmbAvdelningsVal.setVisible(false); //Behöver inte kunna se dessa
        lblStatus.setVisible(false);    //Behöver inte kunna se dessa   
        cmbStatus.setVisible(false);    //Behöver inte kunna se dessa
        btnPartners.setVisible(false);  //Behöver inte kunna se dessa
        btnTaBortProjekt.setVisible(false);     //Tolkar det som att ProjektChef inte ska kunna ta bort projekt
        btnAllaProjekt.setVisible(false);   //Behöver inte kunna se dessa
        btnMinaProjekt.setVisible(false); //Behöver inte se projekt de deltar på i denna vy
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAndraProjekt = new javax.swing.JButton();
        btnTaBortProjekt = new javax.swing.JButton();
        btnLaggTillProjekt = new javax.swing.JButton();
        cmbAvdelningsVal = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjekt = new javax.swing.JTable();
        btnDatumSok = new javax.swing.JButton();
        lblSokDatum = new javax.swing.JLabel();
        lblBindeStreck = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnAllaProjekt = new javax.swing.JButton();
        lblAvdelning = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnMinaProjekt = new javax.swing.JButton();
        jDateStartdatumSok = new com.toedter.calendar.JDateChooser();
        jDateSlutdatumSok = new com.toedter.calendar.JDateChooser();
        btnPartners = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projekt");

        btnAndraProjekt.setText("Redigera projekt");
        btnAndraProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraProjektActionPerformed(evt);
            }
        });

        btnTaBortProjekt.setText("Ta bort projekt");
        btnTaBortProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortProjektActionPerformed(evt);
            }
        });

        btnLaggTillProjekt.setText("Nytt Projekt");
        btnLaggTillProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillProjektActionPerformed(evt);
            }
        });

        cmbAvdelningsVal.setToolTipText("");
        cmbAvdelningsVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAvdelningsValActionPerformed(evt);
            }
        });

        tblProjekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjektID", "Projektnamn", "Beskrivning", "Startdatum", "Slutdatum", "Kostnad", "Status", "Prioritet", "Projektchef", "Land"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProjekt);

        btnDatumSok.setText("Sök datum");
        btnDatumSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatumSokActionPerformed(evt);
            }
        });

        lblSokDatum.setText("Filtrera på datum");

        lblBindeStreck.setText("-");

        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        btnAllaProjekt.setText("Visa alla projekt");
        btnAllaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllaProjektActionPerformed(evt);
            }
        });

        lblAvdelning.setText("Filtrera på avdelning");

        lblStatus.setText("på status");

        btnMinaProjekt.setText("Visa mina projekt");
        btnMinaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinaProjektActionPerformed(evt);
            }
        });

        jDateStartdatumSok.setDateFormatString("yyyy-MM-dd");

        jDateSlutdatumSok.setDateFormatString("yyyy-MM-dd");

        btnPartners.setText("Hantera partners");
        btnPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartnersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAndraProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLaggTillProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaBortProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPartners))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMinaProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAllaProjekt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSokDatum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateStartdatumSok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBindeStreck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateSlutdatumSok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDatumSok))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAvdelning)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAvdelningsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAndraProjekt)
                            .addComponent(btnTaBortProjekt)
                            .addComponent(btnLaggTillProjekt)
                            .addComponent(cmbAvdelningsVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAvdelning)
                            .addComponent(btnPartners))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAllaProjekt)
                        .addComponent(btnMinaProjekt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDatumSok)
                            .addComponent(lblSokDatum))
                        .addComponent(lblBindeStreck)
                        .addComponent(jDateStartdatumSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateSlutdatumSok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndraProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraProjektActionPerformed
        if (admin) {
            editProjekt(admin);
        } else {
            editProjekt();
        }
    }//GEN-LAST:event_btnAndraProjektActionPerformed

    private void btnLaggTillProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillProjektActionPerformed
        new EditProjekt(idb, this, true).setVisible(true);
    }//GEN-LAST:event_btnLaggTillProjektActionPerformed

    private void btnTaBortProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortProjektActionPerformed
        int selectedRow = tblProjekt.getSelectedRow();
        if (selectedRow != -1) {
            index = selectedRow;
            int input = JOptionPane.showConfirmDialog(rootPane, "Är du säker på att du vill ta bort projektet?", "Ta bort projekt", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta pid-värde från kolumn 0
                int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till int
                try {
                    String sqlFraga = "delete from projekt where pid = " + queryPid;
                    idb.delete(sqlFraga);
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Projekt har tagits bort.");

                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Projekt har inte tagits bort.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }//GEN-LAST:event_btnTaBortProjektActionPerformed

    private void cmbAvdelningsValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAvdelningsValActionPerformed
        jDateStartdatumSok.setDate(null);   //nollställer datumväljarna
        jDateSlutdatumSok.setDate(null);    //nollställer datumväljarna
        cmbStatus.setSelectedItem("Välj status");
        if (cmbAvdelningsVal.getSelectedIndex() == 0) {
            cmbStatus.setSelectedItem("Välj status");
        } else {
            ingaProjekt();
            ArrayList<HashMap<String, String>> soktaProjekt;
            try {
                String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
                String fraga = "Select * from projekt where pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning in (select avdid from avdelning where avdelning.namn = '" + valdAvdelning + "')))";
                soktaProjekt = idb.fetchRows(fraga);
                if (soktaProjekt.isEmpty()) {
                    ingaProjekt();
                    JOptionPane.showMessageDialog(this, "Det fanns inga projekt inom din avgränsning.");
                }
                else {
                    formateraTabell(soktaProjekt);
                }
            } catch (InfException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Det gick inte att hämta information om projekt som hör till din avdelning från databasen.");
            }
        }
    }//GEN-LAST:event_cmbAvdelningsValActionPerformed

    private void btnDatumSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatumSokActionPerformed
        String startDatum = "1000-01-01";   //Datum att utgå från 
        String slutDatum = "3000-12-31";    //"Öppet" slutdatum
        
        SimpleDateFormat datumformat = new SimpleDateFormat("yyyy-MM-dd");  //Det format vi vill hämta datumet i från databasen
        if (jDateStartdatumSok.getDate() != null) { //Om startdatum har angivits i sökningen, uppdatera variabeln
            startDatum = datumformat.format(jDateStartdatumSok.getDate());
        }
        if (jDateSlutdatumSok.getDate() != null) {  //Om slutdatum har angivits i sökningen, uppdatera variabeln
            slutDatum = datumformat.format(jDateSlutdatumSok.getDate());
        }
        
        //Kontrollerar att startdatum inte är efter slutdatum och vice versa
        if (Validering.datumEfterKontroll(startDatum, slutDatum) && Validering.datumForeKontroll(slutDatum, startDatum)) {  //Kontrollerar att startdatum inte är efter
            if (cmbAvdelningsVal.getSelectedIndex() == 0 && cmbStatus.getSelectedIndex() == 0) {    //ingen filtrering på avdelning och status, bara datum
                String datumFraga = "Select * from projekt where startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "';";
                try {
                    ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(datumFraga);
                    ingaProjekt();
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Något gick fel med databasen när projekt skulle hämtas ut med de valda datumen.");
                }
            } else if (cmbAvdelningsVal.getSelectedIndex() != 0 && cmbStatus.getSelectedIndex() == 0) { //Filtrera på avdelningn med inte status, plus datum
                String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
                String avdDatumFraga = "Select * from projekt where startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum
                        + "' and pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning =(select avdid from avdelning where namn = '" + valdAvdelning + "')));";
                try {
                    ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(avdDatumFraga);
                    ingaProjekt();
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Något gick fel när projekt skulle hämtas ur databasen för valda sökparametrar.");
                }
            } else if (cmbAvdelningsVal.getSelectedIndex() == 0 && cmbStatus.getSelectedIndex() != 0) { //filtrera på status men inte avdelning, plus datum
                String valdStatus = cmbStatus.getSelectedItem().toString();
                String statDatumFraga = "Select * from projekt where startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "' and status = '" + valdStatus + "';";
                try {
                    ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(statDatumFraga);
                    ingaProjekt();
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Något gick fel när projekt skulle hämtas ur databasen för valda sökparametrar.");
                }
            } else {    //Filtrering på avdelning, status och datum
                String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
                String valdStatus = cmbStatus.getSelectedItem().toString();
                String avdStatusDatumFraga = "Select * from projekt where startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum
                        + "' and status = '" + valdStatus + "' and pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning =(select avdid from avdelning where namn = '" + valdAvdelning + "')));";
                try {
                    ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(avdStatusDatumFraga);
                    ingaProjekt();
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Något gick fel när projekt skulle hämtas ur databasen för valda sökparametrar");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se över dina sökparametrar en gång till. Startdatum måste komma före Slutdatum.");
        }
    }//GEN-LAST:event_btnDatumSokActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        jDateStartdatumSok.setDate(null);   //nollställer datumväljarna
        jDateSlutdatumSok.setDate(null);    //nollställer datumväljarna
        
        if (cmbStatus.getSelectedIndex() == 0 && cmbAvdelningsVal.getSelectedIndex() == 0) {    //Om ingen avdelning eller status, visa alla projekt
            hamtaProjekt();
        } else if (cmbStatus.getSelectedIndex() == 0 && cmbAvdelningsVal.getSelectedIndex() != 0) { //Filtrerar på avdelningen men inte status
            String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
            String avdFraga = "Select * from projekt where pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning =(select avdid from avdelning where namn = '" + valdAvdelning + "')));";
            try {
                ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(avdFraga);
                ingaProjekt();
                if (soktaProjekt.isEmpty()) {
                    ingaProjekt();
                    JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                } else {
                    formateraTabell(soktaProjekt);
                }
            } catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Något gick fel när projekt skulle hämtas ur databasen för valda sökparametrar.");
            }
        } else {    //Filtrerar på avdelning och status
            ArrayList<HashMap<String, String>> soktaProjekt;
            String valdStatus = cmbStatus.getSelectedItem().toString();
            String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
            if (cmbAvdelningsVal.getSelectedIndex() == 0) {
                try {
                    String fraga = "Select * from projekt where status = '" + valdStatus + "';";
                    soktaProjekt = idb.fetchRows(fraga);
                    formateraTabell(soktaProjekt);

                } catch (InfException e) {
                    JOptionPane.showMessageDialog(this, "Något gick fel när valda projekt skulle hämtas ur databasen.");
                }
            } else {
                try {
                    String fraga = "Select * from projekt where status = '" + valdStatus + "' and pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning in (select avdid from avdelning where avdelning.namn = '" + valdAvdelning + "')));";
                    soktaProjekt = idb.fetchRows(fraga);
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(this, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Något gick fel när valda projekt skulle hämtas ur databasen.");
                }
            }
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void btnAllaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaProjektActionPerformed
        hamtaProjekt();
        
        //Nollställer alla filtreringar
        cmbAvdelningsVal.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
        jDateStartdatumSok.setDate(null);
        jDateSlutdatumSok.setDate(null);
    }//GEN-LAST:event_btnAllaProjektActionPerformed

    private void btnMinaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinaProjektActionPerformed
        ingaProjekt();
        if (aid != null) {
            hamtaProjekt(aid);
            cmbAvdelningsVal.setSelectedIndex(0);
            cmbStatus.setSelectedIndex(0);
        } else {
            ingaProjekt();
            JOptionPane.showMessageDialog(null, "Du har inga projekt.");
        }
    }//GEN-LAST:event_btnMinaProjektActionPerformed

    private void btnPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartnersActionPerformed
        new EditProjektPartner(idb).setVisible(true);
    }//GEN-LAST:event_btnPartnersActionPerformed
    
    /**
     * Fyller Avdelnings-comboboxen med alla avdelningsnamn
     */
    private void fyllCmbAvdelningar() {
        ArrayList<String> allaAvdelningar = avdelning.getAllaAvdelningsnamn();
        cmbAvdelningsVal.addItem("Välj avdelning");
        if (allaAvdelningar != null) {
            for (String enAvdelning : allaAvdelningar) {
                cmbAvdelningsVal.addItem(enAvdelning);
            }
        }
    }
    
    /**
     * Fyller Status-comboboxen med alla status från databasen
     */
    private void fyllCmbStatus() {
        String sqlfraga = "select distinct status from projekt;";
        ArrayList<String> allaStatus;
        cmbStatus.addItem("Välj status");
        try {
            allaStatus = idb.fetchColumn(sqlfraga);
            for (String status : allaStatus) {
                cmbStatus.addItem(status);
            }
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Något gick fel när status skulle hämtas ur databasen.");
        }
    }
    
    private void formateraTabell(ArrayList<HashMap<String, String>> param) {
        
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        // Lägg till kolumnnamn i modellen
        tableModel.addColumn("ID");
        tableModel.addColumn("Projektnamn");
        tableModel.addColumn("Beskrivning");
        tableModel.addColumn("Startdatum");
        tableModel.addColumn("Slutdatum");
        tableModel.addColumn("Kostnad");
        tableModel.addColumn("Status");
        tableModel.addColumn("Prioritet");
        tableModel.addColumn("Projektchef");
        tableModel.addColumn("Land");

        // Fyller table med data från databasen
        for (HashMap<String, String> rad : param) {
            tableModel.addRow(new Object[]{
                rad.get("pid"),
                rad.get("projektnamn"),
                rad.get("beskrivning"),
                rad.get("startdatum"),
                rad.get("slutdatum"),
                rad.get("kostnad"),
                rad.get("status"),
                rad.get("prioritet"),
                anstalld.getChefNamn(rad.get("projektchef")),
                hamtaLandNamn(rad.get("land"))
            });
            // Sätt modellen på JTable
            tblProjekt.setModel(tableModel);
        }
    }
    
    private void hamtaProjekt() {
        ArrayList<HashMap<String, String>> allaProjekt;
        try {
            String sqlfraga = "SELECT * FROM projekt";
            allaProjekt = idb.fetchRows(sqlfraga);
            if (allaProjekt.isEmpty()) {
                ingaProjekt();
            } else {
                formateraTabell(allaProjekt);
            }
        } catch (InfException e) {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(this, "Kunde inte hämta projekt.");
        }
    }
    
    /**
     * Hämtar alla projekt för en viss anställd, tar bort alla funktioner att söka, lägga till, ta bort och redigera projekt
     * @param aid 
     */
    private void hamtaProjekt(String aid) {
        btnLaggTillProjekt.setVisible(false);
        btnTaBortProjekt.setVisible(false);
        lblSokDatum.setVisible(false);
        jDateStartdatumSok.setVisible(false);
        lblBindeStreck.setVisible(false);
        jDateSlutdatumSok.setVisible(false);
        btnDatumSok.setVisible(false);

        ArrayList<HashMap<String, String>> allaProjekt;
        try {
            String sqlfraga = "SELECT * FROM projekt WHERE pid IN (SELECT pid FROM ans_proj WHERE aid = "+ aid + ") UNION SELECT * FROM projekt WHERE projektchef = " + aid + ";";
            allaProjekt = idb.fetchRows(sqlfraga);
            if (allaProjekt.isEmpty()) {
                ingaProjekt();
                JOptionPane.showMessageDialog(this, "Du har inga projekt");
            } else {
                this.setTitle("Mina projekt");
                formateraTabell(allaProjekt);
            }
        } catch (InfException e) {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(this, "Kunde inte hämta projekt.");
        }
    }
    
    /**
     * Laddar in projekt för anställd med ingående parameter-aid
     * @param aid 
     */
    private void hamtaProjektAvdelning(String aid) {
        String valdAvdelning = "Välj avdelning";
        try {
            String query = "Select namn from avdelning where avdid = (select avdelning from anstalld where aid = " + aid + ");";
            valdAvdelning = idb.fetchSingle(query);
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
        cmbAvdelningsVal.setSelectedItem(valdAvdelning);
        ArrayList<HashMap<String, String>> soktaProjekt;
        try {
            String fraga = "Select * from projekt where pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning in (select avdid from avdelning where avdelning.namn = '" + valdAvdelning + "')))";
            soktaProjekt = idb.fetchRows(fraga);
            if (soktaProjekt.isEmpty()) {
                ingaProjekt();
                JOptionPane.showMessageDialog(this, "Det finns inga projekt på den här avdelningen");
            } else {
                this.setTitle("Projekt på min avdelning");
                formateraTabell(soktaProjekt);
            }
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Något gick fel när projekt för denna avdelning skulle hämtas ur databasen.");
        }
    }

    private void editProjekt() {
        int selectedRow = tblProjekt.getSelectedRow();
        if (selectedRow != -1) {
            index = selectedRow;    //För att kunna uppdatera tabell efter ändring
            Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till String
            String sqlArPL = "select projektchef from projekt where pid ="+queryPid;
            try {
                String dbPL = idb.fetchSingle(sqlArPL);
                if (aid.equals(dbPL)) {
                    new EditProjekt(idb, this, queryPid).setVisible(true); //öppnar nytt fönster, skickar med den projektets PID från databasen
                }
                else {
                    JOptionPane.showMessageDialog(this, "Du är inte projektchef för det här projektet\noch kan därför inte redigera det.");
                }
            }
            catch (InfException e) {
                JOptionPane.showMessageDialog(this, "Databasfel");
            }
            
            // JOptionPane.showMessageDialog(this, "Valt ID: " + projekt);
        } else {
            JOptionPane.showMessageDialog(this, "Ingen rad är markerad!");
        }
    }

    private void editProjekt(boolean admin) {
        int selectedRow = tblProjekt.getSelectedRow();  //För att kunna uppdatera tabellen efter ändring
        if (selectedRow != -1) {
            index = selectedRow;
            Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till String
            new EditProjekt(idb, this, queryPid, admin).setVisible(true); //öppnar nytt fönster, skickar med den projektets PID från databasen

            // JOptionPane.showMessageDialog(this, "Valt ID: " + projekt);
        } else {
            JOptionPane.showMessageDialog(this, "Ingen rad är markerad!");
        }
    }
    
    /**
     * Hämtar namnet på ett Land utifrån LID, för att kunna visas i projekt
     * @param landID
     * @return landNamn
     */
    private String hamtaLandNamn(String landID) {
        String landNamn = landID;
        String sqlLandNamn = "Select namn from land where lid = "+landID;
        try {
            landNamn = idb.fetchSingle(sqlLandNamn);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
        return landNamn;
    }
    
    /**
     * Lägga till ny rad i tabellen när nytt projekt lagts till
     * @param nyInfo 
     */
    public void nyRad(String[] nyInfo) {
        tableModel.addRow(nyInfo);
    }

    /**
     * Uppdatera rad i tabellen när ett projekt blivit redigerat
     *
     * @param nyInfo
     */
    public void uppdateraRad(String[] nyInfo) {
        for (int i = 0; i < nyInfo.length; i++) {
            tableModel.setValueAt(nyInfo[i], index, i);
        }
    }

    /**
     * För att sätta blank tabell vid sökning utan resultat
     */
    private void ingaProjekt() {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        // Lägg till kolumnnamn i modellen
        tableModel.addColumn("ID");
        tableModel.addColumn("Projektnamn");
        tableModel.addColumn("Beskrivning");
        tableModel.addColumn("Startdatum");
        tableModel.addColumn("Slutdatum");
        tableModel.addColumn("Kostnad");
        tableModel.addColumn("Status");
        tableModel.addColumn("Prioritet");
        tableModel.addColumn("Projektchef");
        tableModel.addColumn("Land");

        tblProjekt.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllaProjekt;
    private javax.swing.JButton btnAndraProjekt;
    private javax.swing.JButton btnDatumSok;
    private javax.swing.JButton btnLaggTillProjekt;
    private javax.swing.JButton btnMinaProjekt;
    private javax.swing.JButton btnPartners;
    private javax.swing.JButton btnTaBortProjekt;
    private javax.swing.JComboBox<String> cmbAvdelningsVal;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.toedter.calendar.JDateChooser jDateSlutdatumSok;
    private com.toedter.calendar.JDateChooser jDateStartdatumSok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblBindeStreck;
    private javax.swing.JLabel lblSokDatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblProjekt;
    // End of variables declaration//GEN-END:variables
}
