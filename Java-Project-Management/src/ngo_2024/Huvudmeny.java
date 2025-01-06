/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author andre
 */
public class Huvudmeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String admins;
    private String projl;
    private String anvandare;
    private String queryAid;

    /**
     * Creates new form Huvudmeny
     */
    public Huvudmeny(InfDB idb, String queryAid, String admins, String projl) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen. 
        this.idb = idb;
        this.admins = admins;
        this.queryAid = queryAid;
        this.projl = projl;
        this.anvandare = queryAid;
        lblInloggadAnvändare.setText(queryAid);
        jLabel1.setText(admins);
        jLabel2.setText(projl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblInloggadAnvändare = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menyMinaUppgifter = new javax.swing.JMenu();
        mvminMinaUppgifter = new javax.swing.JMenuItem();
        mvminLoggaUt = new javax.swing.JMenuItem();
        menyProjekt = new javax.swing.JMenu();
        mvprojMinaProjekt = new javax.swing.JMenuItem();
        mvprojAllaProjekt = new javax.swing.JMenuItem();
        mvprojProjektPartners = new javax.swing.JMenuItem();
        mvprojHallarbhetsmal = new javax.swing.JMenuItem();
        menyPersonal = new javax.swing.JMenu();
        mvpersPersonalPaMinAvdelning = new javax.swing.JMenuItem();
        mvpersHandlaggare = new javax.swing.JMenuItem();
        menyProjektledning = new javax.swing.JMenu();
        mvproledMinaProjekt = new javax.swing.JMenuItem();
        mvproledAndraPartnersForProjekt = new javax.swing.JMenuItem();
        mvproledAndrahandlaggare = new javax.swing.JMenuItem();
        mvproledStatistik = new javax.swing.JMenuItem();
        menyAdministration = new javax.swing.JMenu();
        mvadnPersonal = new javax.swing.JMenuItem();
        mvadnAvdelningar = new javax.swing.JMenuItem();
        mvadnProjekt = new javax.swing.JMenuItem();
        mvadnPartners = new javax.swing.JMenuItem();
        mvadnHallbarhetsmal = new javax.swing.JMenuItem();
        mvadnLand = new javax.swing.JMenuItem();
        menyHjalp = new javax.swing.JMenu();
        mvhjOm = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Inloggad användare");

        lblInloggadAnvändare.setText("inloggadAnvändare");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInloggadAnvändare)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInloggadAnvändare)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menyMinaUppgifter.setText("Mina uppgifter");

        mvminMinaUppgifter.setText("Mina uppgifter");
        mvminMinaUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvminMinaUppgifterActionPerformed(evt);
            }
        });
        menyMinaUppgifter.add(mvminMinaUppgifter);

        mvminLoggaUt.setText("Logga ut");
        mvminLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvminLoggaUtActionPerformed(evt);
            }
        });
        menyMinaUppgifter.add(mvminLoggaUt);

        jMenuBar1.add(menyMinaUppgifter);

        menyProjekt.setText("Projekt");

        mvprojMinaProjekt.setText("Mina projekt");
        mvprojMinaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojMinaProjektActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojMinaProjekt);

        mvprojAllaProjekt.setText("Alla projekt");
        mvprojAllaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojAllaProjektActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojAllaProjekt);

        mvprojProjektPartners.setText("Projektpartners");
        mvprojProjektPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojProjektPartnersActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojProjektPartners);

        mvprojHallarbhetsmal.setText("Hållbarhetsmål");
        mvprojHallarbhetsmal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojHallarbhetsmalActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojHallarbhetsmal);

        jMenuBar1.add(menyProjekt);

        menyPersonal.setText("Personal");

        mvpersPersonalPaMinAvdelning.setText("Personal på min avdelning");
        mvpersPersonalPaMinAvdelning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvpersPersonalPaMinAvdelningActionPerformed(evt);
            }
        });
        menyPersonal.add(mvpersPersonalPaMinAvdelning);

        mvpersHandlaggare.setText("Handläggare");
        menyPersonal.add(mvpersHandlaggare);

        jMenuBar1.add(menyPersonal);

        menyProjektledning.setText("Projektledning");

        mvproledMinaProjekt.setText("Mina projekt");
        mvproledMinaProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvproledMinaProjektActionPerformed(evt);
            }
        });
        menyProjektledning.add(mvproledMinaProjekt);

        mvproledAndraPartnersForProjekt.setText("Ändra partners för projekt");
        menyProjektledning.add(mvproledAndraPartnersForProjekt);

        mvproledAndrahandlaggare.setText("Ändra handläggare");
        menyProjektledning.add(mvproledAndrahandlaggare);

        mvproledStatistik.setText("Statistik");
        mvproledStatistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvproledStatistikActionPerformed(evt);
            }
        });
        menyProjektledning.add(mvproledStatistik);

        jMenuBar1.add(menyProjektledning);

        menyAdministration.setText("Administration");
        menyAdministration.setToolTipText("");

        mvadnPersonal.setText("Personal");
        mvadnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnPersonalActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnPersonal);

        mvadnAvdelningar.setText("Avdelningar");
        mvadnAvdelningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnAvdelningarActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnAvdelningar);

        mvadnProjekt.setText("Projekt");
        mvadnProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnProjektActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnProjekt);

        mvadnPartners.setText("Partners");
        mvadnPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnPartnersActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnPartners);

        mvadnHallbarhetsmal.setText("Hållbarhetsmål");
        mvadnHallbarhetsmal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnHallbarhetsmalActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnHallbarhetsmal);

        mvadnLand.setText("Land");
        mvadnLand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnLandActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnLand);

        jMenuBar1.add(menyAdministration);

        menyHjalp.setText("Hjälp");
        menyHjalp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        mvhjOm.setText("Om");
        mvhjOm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvhjOmActionPerformed(evt);
            }
        });
        menyHjalp.add(mvhjOm);

        jMenuBar1.add(menyHjalp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mvminLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvminLoggaUtActionPerformed
        new InloggningMeny(idb).setVisible (true);
        this.setVisible(false);
    }//GEN-LAST:event_mvminLoggaUtActionPerformed

    private void mvadnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnPersonalActionPerformed
        new AnstalldMeny(idb, admins, anvandare).setVisible(true);
    }//GEN-LAST:event_mvadnPersonalActionPerformed

    private void mvhjOmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvhjOmActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_mvhjOmActionPerformed

    private void mvminMinaUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvminMinaUppgifterActionPerformed
        new EditAnstalld(idb, queryAid, admins, anvandare).setVisible(true);
    }//GEN-LAST:event_mvminMinaUppgifterActionPerformed

    private void mvadnAvdelningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnAvdelningarActionPerformed
        new AvdelningMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnAvdelningarActionPerformed

    private void mvadnProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnProjektActionPerformed
        new ProjektMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnProjektActionPerformed

    private void mvprojMinaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojMinaProjektActionPerformed
        new ProjektMeny(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojMinaProjektActionPerformed

    private void mvproledMinaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvproledMinaProjektActionPerformed
        if (projl != null) {
            new ProjektMeny(idb, queryAid, true).setVisible(true);
        }
        else {
            new ProjektMeny(idb, queryAid).setVisible(true);
        }
        //Tror den kollar om chef? Oklar hur variablerna fungerar.
    }//GEN-LAST:event_mvproledMinaProjektActionPerformed

    private void mvprojAllaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojAllaProjektActionPerformed
        new ProjektMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvprojAllaProjektActionPerformed

    private void mvadnHallbarhetsmalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnHallbarhetsmalActionPerformed
        new HallbarhetsmalMeny(idb, false).setVisible(true);
    }//GEN-LAST:event_mvadnHallbarhetsmalActionPerformed

    private void mvadnLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnLandActionPerformed
        new LandMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnLandActionPerformed

    private void mvpersPersonalPaMinAvdelningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvpersPersonalPaMinAvdelningActionPerformed
      new AnstalldMeny(idb, anvandare).setVisible(true);
    }//GEN-LAST:event_mvpersPersonalPaMinAvdelningActionPerformed

    private void mvadnPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnPartnersActionPerformed
        new PartnerMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnPartnersActionPerformed

    private void mvproledStatistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvproledStatistikActionPerformed
        new Statistik(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvproledStatistikActionPerformed

    private void mvprojHallarbhetsmalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojHallarbhetsmalActionPerformed
        new HallbarhetsmalMeny(idb, true).setVisible(true);
    }//GEN-LAST:event_mvprojHallarbhetsmalActionPerformed

    private void mvprojProjektPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojProjektPartnersActionPerformed
        new PartnerMeny(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojProjektPartnersActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInloggadAnvändare;
    private javax.swing.JMenu menyAdministration;
    private javax.swing.JMenu menyHjalp;
    private javax.swing.JMenu menyMinaUppgifter;
    private javax.swing.JMenu menyPersonal;
    private javax.swing.JMenu menyProjekt;
    private javax.swing.JMenu menyProjektledning;
    private javax.swing.JMenuItem mvadnAvdelningar;
    private javax.swing.JMenuItem mvadnHallbarhetsmal;
    private javax.swing.JMenuItem mvadnLand;
    private javax.swing.JMenuItem mvadnPartners;
    private javax.swing.JMenuItem mvadnPersonal;
    private javax.swing.JMenuItem mvadnProjekt;
    private javax.swing.JMenuItem mvhjOm;
    private javax.swing.JMenuItem mvminLoggaUt;
    private javax.swing.JMenuItem mvminMinaUppgifter;
    private javax.swing.JMenuItem mvpersHandlaggare;
    private javax.swing.JMenuItem mvpersPersonalPaMinAvdelning;
    private javax.swing.JMenuItem mvprojAllaProjekt;
    private javax.swing.JMenuItem mvprojHallarbhetsmal;
    private javax.swing.JMenuItem mvprojMinaProjekt;
    private javax.swing.JMenuItem mvprojProjektPartners;
    private javax.swing.JMenuItem mvproledAndraPartnersForProjekt;
    private javax.swing.JMenuItem mvproledAndrahandlaggare;
    private javax.swing.JMenuItem mvproledMinaProjekt;
    private javax.swing.JMenuItem mvproledStatistik;
    // End of variables declaration//GEN-END:variables
}
