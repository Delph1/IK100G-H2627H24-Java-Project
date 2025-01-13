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

/**
 *
 * @author Märta Sjöblom
 */
public class Statistik extends javax.swing.JFrame {
    
    private InfDB idb;
    private String aid;
    /**
     * Creates new form Statistik
     * @param idb
     * @param aid
     */
    public Statistik(InfDB idb, String aid) {
        this.idb = idb;
        this.aid = aid;
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        setMinaKostnader();
        setAvdelningsKostnader();
        setTotalaKostnader();
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
        jSeparator1 = new javax.swing.JSeparator();
        lblTotalKostnadMina = new javax.swing.JLabel();
        lblPagaende = new javax.swing.JLabel();
        lblAvslutade = new javax.swing.JLabel();
        sprMina = new javax.swing.JSeparator();
        lblTotalKostnadAlla = new javax.swing.JLabel();
        lblStatistikRubrik = new javax.swing.JLabel();
        lblTotalKostnadAvd = new javax.swing.JLabel();
        lblRubrik2 = new javax.swing.JLabel();
        lblTotKost = new javax.swing.JLabel();
        lblPag = new javax.swing.JLabel();
        lblAvs = new javax.swing.JLabel();
        lblAvd = new javax.swing.JLabel();
        lblAlla = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStatistik = new javax.swing.JTable();
        btnLander = new javax.swing.JButton();
        btnLanderKost = new javax.swing.JButton();
        btnPartners = new javax.swing.JButton();
        sprSok = new javax.swing.JSeparator();
        lblKostnad = new javax.swing.JLabel();
        lblPlanerade = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTotalKostnadMina.setText("Total kostnad");

        lblPagaende.setText("- varav pågående");

        lblAvslutade.setText("- varav avslutade");

        lblTotalKostnadAlla.setText("Alla projekt");

        lblStatistikRubrik.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatistikRubrik.setText("Statistik");

        lblTotalKostnadAvd.setText("Min avdelning");

        lblRubrik2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRubrik2.setText("Mina ledda projekt:");

        lblTotKost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTotKost.setText("0");

        lblPag.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPag.setText("0");

        lblAvs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAvs.setText("0");

        lblAvd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAvd.setText("0");

        lblAlla.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAlla.setText("0");

        tblStatistik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblStatistik);

        btnLander.setText("Länder");
        btnLander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanderActionPerformed(evt);
            }
        });

        btnLanderKost.setText("Kostnad länder");
        btnLanderKost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanderKostActionPerformed(evt);
            }
        });

        btnPartners.setText("Partners");
        btnPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartnersActionPerformed(evt);
            }
        });

        lblKostnad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKostnad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKostnad.setText("Kostnad");

        lblPlanerade.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPlanerade.setText("(inkl. ev. planerade projekt)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalKostnadAvd)
                            .addComponent(lblTotalKostnadAlla))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlla)
                            .addComponent(lblAvd))
                        .addGap(352, 352, 352))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLander)
                                .addGap(27, 27, 27)
                                .addComponent(btnLanderKost)
                                .addGap(35, 35, 35)
                                .addComponent(btnPartners))
                            .addComponent(lblStatistikRubrik))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRubrik2)
                                    .addComponent(lblAvslutade)
                                    .addComponent(lblTotalKostnadMina)
                                    .addComponent(lblPagaende))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblPag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblTotKost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAvs, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPlanerade))
                                    .addComponent(lblKostnad)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(sprMina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(sprSok, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatistikRubrik)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRubrik2)
                    .addComponent(lblKostnad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalKostnadMina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPagaende)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAvslutade))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotKost)
                            .addComponent(lblPlanerade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAvs)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sprMina, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalKostnadAvd)
                    .addComponent(lblAvd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalKostnadAlla)
                    .addComponent(lblAlla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sprSok, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLander)
                    .addComponent(btnLanderKost)
                    .addComponent(btnPartners))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanderActionPerformed
        setLander();
    }//GEN-LAST:event_btnLanderActionPerformed

    private void btnLanderKostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanderKostActionPerformed
        setLanderKostnad();
    }//GEN-LAST:event_btnLanderKostActionPerformed

    private void btnPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartnersActionPerformed
        setPartners();
    }//GEN-LAST:event_btnPartnersActionPerformed
    
    /**
     * Räknar ut kostnaden för inloggad användare, och delar upp på pågående och
     * avslutade projekt
     */
    private void setMinaKostnader() {
        double minKostnad = 0;
        double pagaendeSumma = 0;
        double avslutadeSumma = 0;
        try {
            ArrayList<HashMap<String, String>> minaProjekt = new ArrayList<>(); //Hämtar lista på projekt som inloggad är projektchef för
            try {
                String sqlfraga = "SELECT * FROM projekt where projektchef =" + aid;
                minaProjekt = idb.fetchRows(sqlfraga);
            } catch (InfException e) {
                System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
            }
            for (HashMap<String, String> ettProjekt : minaProjekt) {
                minKostnad += Double.parseDouble(ettProjekt.get("kostnad"));    //Lägger till kostnaden för projektet till totalen, inkl planerade
                String status = ettProjekt.get("status");
                if (status.equals("Pågående")) {    //Lägger dessutom till kostnaden på pågående om pågående
                    pagaendeSumma += Double.parseDouble(ettProjekt.get("kostnad"));
                } else if (status.equals("Avslutat")) { //Lägger dessutom till kostnaden på avslutat om avslutat
                    avslutadeSumma += Double.parseDouble(ettProjekt.get("kostnad"));
                }
            }
        } catch (Exception ex) {
            System.out.println("Inga projekt på denna person" + ex.getMessage());
        }
        lblTotKost.setText("" + minKostnad);
        lblPag.setText("" + pagaendeSumma);
        lblAvs.setText("" + avslutadeSumma);
    }
    
    /**
     * Räknar ut kostnader för avdelningen som inloggad person jobbar vid
     */
    private void setAvdelningsKostnader(){
        double avdSumma = 0;
        String sqlAvdKost = "select kostnad from projekt where pid in (select pid from ans_proj where aid in (select aid from anstalld where avdelning = (select avdelning from anstalld where aid = "+aid+")));";
        ArrayList<String> avdKostnader = new ArrayList<>();
        try {
            avdKostnader = idb.fetchColumn(sqlAvdKost); //Hämtar alla kostnader för avdelningen till inloggad person
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
        }
        for (String enKostnad : avdKostnader) { //Summerar kostnaden för alla projekt vid avdelningen
            avdSumma += Double.parseDouble(enKostnad);
        }
        lblAvd.setText(""+avdSumma);
    }
    
    /**
     * Räknar ut kostnaden för alla projekt i systemet
     */
    private void setTotalaKostnader(){
        double totSumma = 0;
        String sqlTotKost = "select kostnad from projekt;";
        ArrayList<String> totKostnader = new ArrayList<>();
        try {
            totKostnader = idb.fetchColumn(sqlTotKost); //Hämtar kostnader för alla projekt
        }
        catch (InfException e) {
            System.out.println(e.getMessage());
        }
        for (String enKostnad : totKostnader) { //Summerar kostnaderna från ovan till en totalsiffra
            totSumma += Double.parseDouble(enKostnad);
        }
        lblAlla.setText(""+totSumma);
    }
    
    /**
     * Får ut statistik över vilka länder de projekt jag är, eller har varit, projektansvarig för genomfördes i
     */
    private void setLander() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);

        // Lägg till kolumnnamn i modellen
        tableModel.addColumn("Land");
        tableModel.addColumn("Projektstatus");
        ArrayList<HashMap<String, String>> allaLander = null;
        String sqlLander = "select land.namn, status from land, projekt where land.lid = projekt.land and projektchef = " + aid+" order by land.namn;";
        try {
            allaLander = idb.fetchRows(sqlLander);
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
        if (allaLander != null) {

            // Fyller table med data från databasen
            for (HashMap<String, String> rad : allaLander) {
                tableModel.addRow(new Object[]{
                    rad.get("namn"),
                    rad.get("status"),});
                // Sätt modellen på JTable
                tblStatistik.setModel(tableModel);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    
    /**
     * För statistik för de egna projektens land-placering, och den totala kostnaden
     * för projekt i de olika länderna
     */
    private void setLanderKostnad(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);
        HashMap<String,String> summaKostnad = new HashMap<>();  //Till för att räkna ut summan av kostnader för länder

        // Lägg till kolumnnamn i modellen
        tableModel.addColumn("Land");
        tableModel.addColumn("Totalkostnad");
        ArrayList<HashMap<String, String>> allaLander = null;
        String sqlLander = "select land.namn, kostnad from land, projekt where land.lid = projekt.land and projektchef = " + aid + " order by land.namn desc";
        try {
            allaLander = idb.fetchRows(sqlLander);  //Hämtar landets namn och kostnaden för alla projekt som inloggad person är projektchef för
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
        if (allaLander != null) {
            for(HashMap<String,String> rad : allaLander) {
                String land = rad.get("namn");
                double kostnad = Double.parseDouble(rad.get("kostnad"));
                double utgangsKostnad;
                if (summaKostnad.containsKey(land)) {   //Om Land redan finns i summa-listan, lägg till nya värdet
                    utgangsKostnad = Double.parseDouble(summaKostnad.get(land));
                    utgangsKostnad += kostnad;
                    summaKostnad.put(land, "" + utgangsKostnad);
                } else {    //Om land inte redan finns, lägg till nytt
                    summaKostnad.put(land, "" + kostnad);
                }
            }
            // Fyller table med data från databasen
            for (String rad : summaKostnad.keySet()) {
                tableModel.addRow(new Object[]{
                    rad,
                    summaKostnad.get(rad),});
                // Sätt modellen på JTable
                tblStatistik.setModel(tableModel);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
    /**
     * För statistik om de egna partnersammarbetena, och status på de projekten
     */
    private void setPartners() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setRowCount(0);

        // Lägg till kolumnnamn i modellen
        tableModel.addColumn("Partner");
        tableModel.addColumn("Projektstatus");
        ArrayList<HashMap<String, String>> allaLander = null;
        String sqlLander = "select partner.namn, status from projekt join projekt_partner on projekt.pid = projekt_partner.pid join partner on  projekt_partner.partner_pid = partner.pid where projektchef = "+aid;
        try {
            allaLander = idb.fetchRows(sqlLander); //Hämtar partners namn och status för alla projekt som inloggad person är projektchef för
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
        if (allaLander != null) {

            // Fyller table med data från databasen
            for (HashMap<String, String> rad : allaLander) {
                tableModel.addRow(new Object[]{
                    rad.get("namn"),
                    rad.get("status"),});
                // Sätt modellen på JTable
                tblStatistik.setModel(tableModel);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Databasfel");
        }
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLander;
    private javax.swing.JButton btnLanderKost;
    private javax.swing.JButton btnPartners;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAlla;
    private javax.swing.JLabel lblAvd;
    private javax.swing.JLabel lblAvs;
    private javax.swing.JLabel lblAvslutade;
    private javax.swing.JLabel lblKostnad;
    private javax.swing.JLabel lblPag;
    private javax.swing.JLabel lblPagaende;
    private javax.swing.JLabel lblPlanerade;
    private javax.swing.JLabel lblRubrik2;
    private javax.swing.JLabel lblStatistikRubrik;
    private javax.swing.JLabel lblTotKost;
    private javax.swing.JLabel lblTotalKostnadAlla;
    private javax.swing.JLabel lblTotalKostnadAvd;
    private javax.swing.JLabel lblTotalKostnadMina;
    private javax.swing.JSeparator sprMina;
    private javax.swing.JSeparator sprSok;
    private javax.swing.JTable tblStatistik;
    // End of variables declaration//GEN-END:variables
}
