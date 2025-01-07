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
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author SuperPC
 */
public class ProjektMeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String aid;
    private boolean projCh;
    private boolean admin;
    
    /**
     * Allmän konstruktor, ingen personanpassning, inga egna projekt. Admin?
     */
    public ProjektMeny(InfDB idb) {
        this.idb = idb;
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        hamtaProjekt();
        admin = true;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    }
    
    /**
     * Konstruktor för främst handläggare, 
     * @param idb
     * @param aid 
     */
    public ProjektMeny(InfDB idb, String aid) {
        this.idb = idb;
        this.aid = aid;
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
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
    public ProjektMeny(InfDB idb, boolean avdelning, String aid)
    {
        this.idb = idb;
        this.aid = aid;
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        setLocationRelativeTo(null);
        btnTaBortProjekt.setVisible(false);
        btnMinaProjekt.setVisible(false); 
        btnÄndraProjekt.setVisible(false);
        btnLäggTillProjekt.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
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
        initComponents();
        fyllCmbAvdelningar();
        fyllCmbStatus();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        hamtaProjektSomProjektChef(aid);
        this.setTitle("Projektledare");
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

        btnÄndraProjekt = new javax.swing.JButton();
        btnTaBortProjekt = new javax.swing.JButton();
        btnLäggTillProjekt = new javax.swing.JButton();
        cmbAvdelningsVal = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjekt = new javax.swing.JTable();
        btnDatumSök = new javax.swing.JButton();
        lblSokDatum = new javax.swing.JLabel();
        lblBindeStreck = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        btnAllaProjekt = new javax.swing.JButton();
        lblAvdelning = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnMinaProjekt = new javax.swing.JButton();
        jDateStartdatumSök = new com.toedter.calendar.JDateChooser();
        jDateSlutdatumSök = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projekt");
        setPreferredSize(new java.awt.Dimension(900, 480));

        btnÄndraProjekt.setText("Redigera projekt");
        btnÄndraProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraProjektActionPerformed(evt);
            }
        });

        btnTaBortProjekt.setText("Ta bort projekt");
        btnTaBortProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortProjektActionPerformed(evt);
            }
        });

        btnLäggTillProjekt.setText("Nytt Projekt");
        btnLäggTillProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLäggTillProjektActionPerformed(evt);
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

        btnDatumSök.setText("Sök datumintervall");
        btnDatumSök.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatumSökActionPerformed(evt);
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

        jDateStartdatumSök.setDateFormatString("yyyy-MM-dd");

        jDateSlutdatumSök.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnÄndraProjekt)
                                .addGap(18, 18, 18)
                                .addComponent(btnLäggTillProjekt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMinaProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAllaProjekt)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaBortProjekt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(lblSokDatum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateStartdatumSök, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBindeStreck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateSlutdatumSök, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDatumSök))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblAvdelning)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAvdelningsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnÄndraProjekt)
                        .addComponent(btnTaBortProjekt)
                        .addComponent(btnLäggTillProjekt)
                        .addComponent(btnDatumSök)
                        .addComponent(lblSokDatum))
                    .addComponent(lblBindeStreck)
                    .addComponent(jDateStartdatumSök, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateSlutdatumSök, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAvdelningsVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllaProjekt)
                    .addComponent(lblAvdelning)
                    .addComponent(lblStatus)
                    .addComponent(btnMinaProjekt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnÄndraProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraProjektActionPerformed
        if (admin) {
            editProjekt(admin);
        }
        else {
            editProjekt();
        }
    }//GEN-LAST:event_btnÄndraProjektActionPerformed

    private void btnLäggTillProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLäggTillProjektActionPerformed
        new EditProjekt(idb, true).setVisible(true);
    }//GEN-LAST:event_btnLäggTillProjektActionPerformed

    private void btnTaBortProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortProjektActionPerformed
        int selectedRow = tblProjekt.getSelectedRow();
        if (selectedRow != -1) {
            int input = JOptionPane.showConfirmDialog(rootPane, "Är du säker på att du vill ta bort projektet?", "Ta bort projekt", JOptionPane.YES_NO_OPTION);
            if (input == 0) {
                Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta pid-värde från kolumn 0
                int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till int
                try {
                    String sqlFråga = "delete from projekt where pid = " + queryPid;
                    idb.delete(sqlFråga);
                    JOptionPane.showMessageDialog(null, "Projekt har tagits bort.");
                    
                } catch (InfException e) {
                    System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Projekt har inte tagits bort.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }//GEN-LAST:event_btnTaBortProjektActionPerformed

    private void cmbAvdelningsValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAvdelningsValActionPerformed
        if (cmbAvdelningsVal.getSelectedIndex() == 0){  
            hamtaProjekt();
            cmbStatus.setSelectedItem("Välj status");
        } else {
            cmbStatus.setSelectedIndex(0);
            ArrayList<HashMap<String, String>> soktaProjekt;
            try {
                String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
                String fraga = "Select * from projekt where pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning in (select avdid from avdelning where avdelning.namn = '" + valdAvdelning + "')))";
                soktaProjekt = idb.fetchRows(fraga);
                formateraTabell(soktaProjekt);

            } catch (InfException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Databasfel");
            }
        }
    }//GEN-LAST:event_cmbAvdelningsValActionPerformed

    private void btnDatumSökActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatumSökActionPerformed
//        String startDatum = "1000-01-01";
//        String slutDatum = "3000-12-31";
        SimpleDateFormat datumformat = new SimpleDateFormat("yyyy-MM-dd");
        String startDatum = datumformat.format(jDateStartdatumSök.getDate());
        String slutDatum = datumformat.format(jDateSlutdatumSök.getDate());

        
        if (!startDatum.isBlank() && Validering.datumKontroll(startDatum) && !slutDatum.isBlank() && Validering.datumKontroll(slutDatum) && jDateStartdatumSök.getDate().before(jDateSlutdatumSök.getDate()))
        {
            try 
            {
                String fraga = "Select * from projekt where startdatum >= '" + startDatum + "' AND slutdatum <= '" + slutDatum + "';";
                ArrayList<HashMap<String, String>> soktaProjekt = idb.fetchRows(fraga);
                ingaProjekt();
                if(soktaProjekt.isEmpty()) {
                    ingaProjekt();
                    JOptionPane.showMessageDialog(null, "Inga projekt hittades.");
                }
                else {
                    formateraTabell(soktaProjekt);
                }
            }
            catch (InfException e)
            {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Databasfel");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Se över dina sökparametrar en gång till. Du måste ange ett datum i båda fälten och Startdatum måste komma före Slutdatum.");
        }
    }//GEN-LAST:event_btnDatumSökActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
       
        if (cmbStatus.getSelectedIndex() == 0) {
            hamtaProjekt();
        } else {
            ArrayList<HashMap<String, String>> soktaProjekt;
            String valdStatus = cmbStatus.getSelectedItem().toString();
            String valdAvdelning = cmbAvdelningsVal.getSelectedItem().toString();
            if (cmbAvdelningsVal.getSelectedIndex() == 0) {
                try {
                    String fraga = "Select * from projekt where status = '" + valdStatus + "';";
                    soktaProjekt = idb.fetchRows(fraga);
                    formateraTabell(soktaProjekt);

                } catch (InfException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Databasfel");
                }
            } else {
                try {
                    String fraga = "Select * from projekt where status = '" + valdStatus + "' and pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning in (select avdid from avdelning where avdelning.namn = '" + valdAvdelning + "')));";
                    soktaProjekt = idb.fetchRows(fraga);
                    if (soktaProjekt.isEmpty()) {
                        ingaProjekt();
                        JOptionPane.showMessageDialog(null, "Inga projekt hittades.");
                    } else {
                        formateraTabell(soktaProjekt);
                    }
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Databasfel");
                }
            }
        }
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void btnAllaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllaProjektActionPerformed
        hamtaProjekt();
        cmbAvdelningsVal.setSelectedIndex(0);
        cmbStatus.setSelectedIndex(0);
    }//GEN-LAST:event_btnAllaProjektActionPerformed

    private void btnMinaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinaProjektActionPerformed
        if (aid != null) {
            hamtaProjekt(aid);
            cmbAvdelningsVal.setSelectedIndex(0);
            cmbStatus.setSelectedIndex(0);
        }
        else {
            ingaProjekt();
            JOptionPane.showMessageDialog(null, "Du har inga projekt.");
        }
        
    }//GEN-LAST:event_btnMinaProjektActionPerformed

    private void fyllCmbAvdelningar()
    {
        String sqlfråga = "select namn from avdelning";
        ArrayList<String> allaAvdelningar;
        cmbAvdelningsVal.addItem("Alla avdelningar");
        try {
            allaAvdelningar = idb.fetchColumn(sqlfråga);
            for (String avdelning : allaAvdelningar)
                cmbAvdelningsVal.addItem(avdelning);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    private void fyllCmbStatus() {
        String sqlfråga = "select distinct status from projekt;";
        ArrayList<String> allaStatus;
        cmbStatus.addItem("Välj status");
        try {
            allaStatus = idb.fetchColumn(sqlfråga);
            for (String status : allaStatus)
                cmbStatus.addItem(status);
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    private void formateraTabell(ArrayList<HashMap<String, String>> param) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);

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
                rad.get("projektchef"),
                rad.get("land")
            });
            // Sätt modellen på JTable
            tblProjekt.setModel(tableModel);
        }
    }
    private void hamtaProjekt() {
        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try {
            String sqlfråga = "SELECT * FROM projekt";
            allaProjekt = idb.fetchRows(sqlfråga);
            formateraTabell(allaProjekt);
        } catch (InfException e) {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }

    }
    /**
     * Hämtar alla projekt för en viss anställd, tar bort alla funktioner att söka, lägga till, ta bort och redigera projekt
     * @param aid 
     */
    private void hamtaProjekt(String aid) {
        btnLäggTillProjekt.setVisible(false);
        btnÄndraProjekt.setVisible(false);
        btnTaBortProjekt.setVisible(false);
        lblSokDatum.setVisible(false);
        jDateStartdatumSök.setVisible(false);
        lblBindeStreck.setVisible(false);
        jDateSlutdatumSök.setVisible(false);
        btnDatumSök.setVisible(false);

        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try {
            String sqlfråga = "SELECT * FROM projekt where pid in (select pid from ans_proj where aid =" + aid + ");";
            allaProjekt = idb.fetchRows(sqlfråga);
        } catch (InfException e) {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }
        if (allaProjekt.isEmpty()) {
            ingaProjekt();
            JOptionPane.showMessageDialog(null, "Du har inga projekt");
        } else {
            this.setTitle("Mina projekt");
            formateraTabell(allaProjekt);
        }

    }
    
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
            formateraTabell(soktaProjekt);

        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    private void hamtaProjektSomProjektChef(String aid) {
        btnLäggTillProjekt.setVisible(false);
        btnTaBortProjekt.setVisible(false);
        lblSokDatum.setVisible(false);
        jDateStartdatumSök.setVisible(false);
        lblBindeStreck.setVisible(false);
        jDateSlutdatumSök.setVisible(false);
        btnDatumSök.setVisible(false);
        cmbAvdelningsVal.setVisible(false);
        cmbStatus.setVisible(false);
        lblAvdelning.setVisible(false);
        lblStatus.setVisible(false);
        String PCAid = aid;

        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try {
            String sqlfråga = "SELECT * FROM projekt where projektchef =" + PCAid;
            allaProjekt = idb.fetchRows(sqlfråga);
        } catch (InfException e) {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }
        if (allaProjekt.isEmpty()) {
            ingaProjekt();
            JOptionPane.showMessageDialog(null, "Du är inte projektchef för några projekt");
        } else {
            this.setTitle("Mina projekt");
            formateraTabell(allaProjekt);
        }

    }

    private void editProjekt() {
        int selectedRow = tblProjekt.getSelectedRow();
        if (selectedRow != -1) {
            Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till String
            new EditProjekt(idb, queryPid).setVisible(true); //öppnar nytt fönster, skickar med den projektets PID från databasen

            // JOptionPane.showMessageDialog(this, "Valt ID: " + projekt);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }

    private void editProjekt(boolean admin) {
        int selectedRow = tblProjekt.getSelectedRow();
        if (selectedRow != -1) {
            Object projekt = tblProjekt.getValueAt(selectedRow, 0); // Hämta värde från kolumn 0
            int queryPid = Integer.parseInt(projekt.toString()); // Konvertera till String
            new EditProjekt(idb, queryPid, admin).setVisible(true); //öppnar nytt fönster, skickar med den projektets PID från databasen

            // JOptionPane.showMessageDialog(this, "Valt ID: " + projekt);
        } else {
            JOptionPane.showMessageDialog(null, "Ingen rad är markerad!");
        }
    }
    
    private void ingaProjekt() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);

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
    private javax.swing.JButton btnDatumSök;
    private javax.swing.JButton btnLäggTillProjekt;
    private javax.swing.JButton btnMinaProjekt;
    private javax.swing.JButton btnTaBortProjekt;
    private javax.swing.JButton btnÄndraProjekt;
    private javax.swing.JComboBox<String> cmbAvdelningsVal;
    private javax.swing.JComboBox<String> cmbStatus;
    private com.toedter.calendar.JDateChooser jDateSlutdatumSök;
    private com.toedter.calendar.JDateChooser jDateStartdatumSök;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblBindeStreck;
    private javax.swing.JLabel lblSokDatum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblProjekt;
    // End of variables declaration//GEN-END:variables
}
