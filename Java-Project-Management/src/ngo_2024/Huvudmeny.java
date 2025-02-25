/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;
/**
 * Klass för själva huvudmenyn man når allt ifrån. 
 * @author Andreas Galistel
 */
public class Huvudmeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String admins;
    private String projl;
    private String anvandare;
    private String queryAid;
    private AnstalldMeny anstalld;
    private ArrayList<String> funFacts;
    private Random randomGenerator;
    

    /**
     * Creates new form Huvudmeny
     * @param idb
     * @param queryAid
     * @param admins
     * @param projl
     */
    public Huvudmeny(InfDB idb, String queryAid, String admins, String projl) {
        initComponents();
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen. 
        this.idb = idb;
        this.admins = admins;
        this.queryAid = queryAid;
        this.projl = projl;
        this.anvandare = queryAid;
        kontrolleraBehorigheter();
        this.anstalld = new AnstalldMeny(idb);
        visaAnvandaresNamnOchEpost(queryAid);
        this.setTitle("NGO-matic");
        randomGenerator = new Random();
        funFacts = new ArrayList<>();
        fyllFunFacts();
        lblFunFact.setText(genereraFunFact());
    }
    
    /**
     * Metod som kontrollerar behörighet för person som loggat in.
     */
    private void kontrolleraBehorigheter() {
        try {

            String projektledareQuery = "SELECT COUNT(*) FROM projekt WHERE projektchef = '" + queryAid + "'";
            int antalProjekt = Integer.parseInt(idb.fetchSingle(projektledareQuery));

            if (antalProjekt > 0) {

                mvprojAndraPartnersForProjekt.setVisible(true);
                mvprojStatistik.setVisible(true);

            } else {
                mvprojAndraPartnersForProjekt.setVisible(false);
                mvprojStatistik.setVisible(false);
            }

            String adminQuery = "SELECT behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
            String behorighetsniva = idb.fetchSingle(adminQuery);

            if (behorighetsniva != null && behorighetsniva.equals("1")) {
                menyAdministration.setVisible(true);
            } else {
                menyAdministration.setVisible(false);
            }

        } catch (InfException e) {
            System.out.println("Ett fel inträffade vid kontroll av behörigheter: " + e.getMessage());
        }
    }
    
    /**
     * Metod för att visa inloggad användares namn och epost i huvudmenyn
     * @param queryAid 
     */
    private void visaAnvandaresNamnOchEpost(String queryAid) {
        String roll = ((admins == null) ? "Handläggare" : "Administratör"); //Korthands-if
        HashMap<String, String> resultat = anstalld.getEnAnstalld(queryAid);
        lblNamn.setText(resultat.get("fornamn") + " " + resultat.get("efternamn"));
        lblEpost.setText(resultat.get("epost"));
        lblRoll.setText(roll);
    }
    
    /**
     * Metod för att fylla ArrayList med och för fun facts
     */
    private void fyllFunFacts() {
        funFacts.add("Det här projektet har hittills haft över 150 pull requests och 250 commits i GitHub.");
        funFacts.add("Den samlade åldern för oss fyra personer i grupp 3 är 138 år.");
        funFacts.add("Tre katter har varit involverade i utvecklingen, de heter Billy, Leif och Mad.");
        funFacts.add("Antal svordomar över Netbeans och/eller Github: 14327. Nej vänta, 14328.");
        funFacts.add("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Har du läst allt detta är jag väldigt imponerad. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</html>");
        funFacts.add("Det här projektet är skrivet på minst sex olika datorer och en telefon.");
        funFacts.add("Java är 28 år gammalt och körs på uppskattningsvis 100 miljarder enheter inom kort.");
        funFacts.add("<html>Oracle som äger Java, men som med mycket annat de har idag inte skapade det, står också bakom Millenium som just nu är det mest hatade programmet inom svensk, och troligen även internationell, hälsovård.</html>");
        funFacts.add("<html>Larry Ellison, Oracles gundare har en förmögenhet på 208 miljarder dollar och har skapat det genom att bygga en databasplattform som är väldigt stabil, men också är låst bakom ett licenssystem som ingen normal människa förstår sig på och oavsett hur bra pålitlighet den har känns den aldrig värt pengarna.</html>");
        funFacts.add("<html>Oracle äger även varumärket JavaScript, men det har inget med Java att göra utan det fick det på köpet när de köpte upp Sun Microsystems, som i sin tur köpte det av Netscape.</html>");
        funFacts.add("<html>Oracle fick rättigheterna till MySQL när de köpte Sun Microsystems 2010, men när det skedde valde utvecklaren att skapa en fork på MySQL som de sedan döpte till MariaDB.</html>");
        funFacts.add("<html>MySQL är uppkallat efter dottern till den svenska medgrundaren Michael Widenius, som heter My.</html>");
    }
    
    /**
     * Metod för att randomisera index och returnera ett fun fact
     * @return 
     */
    private String genereraFunFact() {
        int index = randomGenerator.nextInt(funFacts.size());
        return funFacts.get(index);
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
        lblNamn = new javax.swing.JLabel();
        lblEpost = new javax.swing.JLabel();
        lblRoll = new javax.swing.JLabel();
        lblValkommen = new javax.swing.JLabel();
        lblDagens = new javax.swing.JLabel();
        lblFunFact = new javax.swing.JLabel();
        btnSlumpaFakta = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menyMinaUppgifter = new javax.swing.JMenu();
        mvminMinaUppgifter = new javax.swing.JMenuItem();
        mvminPersonalPaMinAvdelning = new javax.swing.JMenuItem();
        mvminLoggaUt = new javax.swing.JMenuItem();
        menyProjekt = new javax.swing.JMenu();
        mvprojMinaProjekt = new javax.swing.JMenuItem();
        mvprojAllaProjekt = new javax.swing.JMenuItem();
        mvprojProjektPartners = new javax.swing.JMenuItem();
        mvprojAndraPartnersForProjekt = new javax.swing.JMenuItem();
        mvprojHallarbhetsmal = new javax.swing.JMenuItem();
        mvprojStatistik = new javax.swing.JMenuItem();
        menyAdministration = new javax.swing.JMenu();
        mvadnPersonal = new javax.swing.JMenuItem();
        mvadnAvdelningar = new javax.swing.JMenuItem();
        mvadnProjekt = new javax.swing.JMenuItem();
        mvadnPartners = new javax.swing.JMenuItem();
        mvadnHallbarhetsmal = new javax.swing.JMenuItem();
        mvadnLand = new javax.swing.JMenuItem();
        mvadnStad = new javax.swing.JMenuItem();
        menyHjalp = new javax.swing.JMenu();
        mvhjOm = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNamn.setText("Inloggad användare");

        lblEpost.setText("inloggadAnvändare");

        lblRoll.setText("Administratör");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNamn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(lblRoll))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEpost)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamn)
                    .addComponent(lblRoll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEpost)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblValkommen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblValkommen.setText("Välkommen!");

        lblDagens.setText("Dagens fun fact:");

        lblFunFact.setText("Om det inte står ett fun fact här så har något gått väldigt fel ¯\\_(ツ)_/¯");
        lblFunFact.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblFunFact.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        lblFunFact.setPreferredSize(new java.awt.Dimension(525, 100));

        btnSlumpaFakta.setText("Slumpa fakta");
        btnSlumpaFakta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlumpaFaktaActionPerformed(evt);
            }
        });

        menyMinaUppgifter.setText("Mina uppgifter");

        mvminMinaUppgifter.setText("Mina uppgifter");
        mvminMinaUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvminMinaUppgifterActionPerformed(evt);
            }
        });
        menyMinaUppgifter.add(mvminMinaUppgifter);

        mvminPersonalPaMinAvdelning.setText("Personal på min avdelning");
        mvminPersonalPaMinAvdelning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvminPersonalPaMinAvdelningActionPerformed(evt);
            }
        });
        menyMinaUppgifter.add(mvminPersonalPaMinAvdelning);

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

        mvprojAllaProjekt.setText("Avdelningens projekt");
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

        mvprojAndraPartnersForProjekt.setText("Ändra partners för projekt");
        mvprojAndraPartnersForProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojAndraPartnersForProjektActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojAndraPartnersForProjekt);

        mvprojHallarbhetsmal.setText("Hållbarhetsmål");
        mvprojHallarbhetsmal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojHallarbhetsmalActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojHallarbhetsmal);

        mvprojStatistik.setText("Statistik");
        mvprojStatistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvprojStatistikActionPerformed(evt);
            }
        });
        menyProjekt.add(mvprojStatistik);

        jMenuBar1.add(menyProjekt);

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

        mvadnStad.setText("Stad");
        mvadnStad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvadnStadActionPerformed(evt);
            }
        });
        menyAdministration.add(mvadnStad);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSlumpaFakta)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDagens)
                                .addComponent(lblValkommen)
                                .addComponent(lblFunFact, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblValkommen)
                .addGap(18, 18, 18)
                .addComponent(lblDagens)
                .addGap(18, 18, 18)
                .addComponent(lblFunFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSlumpaFakta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Knappar följer nedan
     */
    
    private void mvhjOmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvhjOmActionPerformed

        JFrame omRuta = new JFrame("Om NGO-matic");
        omRuta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        omRuta.setSize(500, 400);
        omRuta.setLayout(new BorderLayout());
        omRuta.setLocationRelativeTo(null);

        JLabel titelLabel = new JLabel("<html><h1 style='color:blue; text-align:center;'>NGO-matic</h1></html>", JLabel.CENTER);

        String infoText = "<html>"
                + "<p style='text-align:center;'>Ett program utvecklat för <b>SDG Sweden</b><br> som en del av kursen <i>IK100G Informatik 30hp</i> <br>delkursen <b>Systemutvecklingsprojekt</b>.</p>"
                + "<br>"
                + "<h3 style='text-align:center;'>Utvecklat av:</h3>"
                + "<ul>"
                + "<li style='text-align:left;'>Andreas Galistel</li>"
                + "<li style='text-align:left;'>Claudia Kourieh</li>"
                + "<li style='text-align:left;'>Fredrik Magnusson</li>"
                + "<li style='text-align:left;'>Märta Sjöblom</li>"
                + "</ul>"
                + "<br>"
                + "<p style='text-align:center;'>NGO-matic är designat för att hjälpa <b>SDG Sweden</b><br>som arbetar med tekniska lösningar för utvecklingsländer.</p>"
                + "</html>";

        JLabel infoLabel = new JLabel(infoText, JLabel.CENTER);
        JButton stangKnapp = new JButton("Stäng");
        stangKnapp.addActionListener(e -> omRuta.dispose());
        omRuta.add(titelLabel, BorderLayout.NORTH);
        omRuta.add(infoLabel, BorderLayout.CENTER);
        omRuta.add(stangKnapp, BorderLayout.SOUTH);
        omRuta.setVisible(true);
    }//GEN-LAST:event_mvhjOmActionPerformed

    private void mvadnLandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnLandActionPerformed
        new LandMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnLandActionPerformed

    private void mvadnHallbarhetsmalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnHallbarhetsmalActionPerformed
        new HallbarhetsmalMeny(idb, false).setVisible(true);
    }//GEN-LAST:event_mvadnHallbarhetsmalActionPerformed

    private void mvadnPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnPartnersActionPerformed
        new PartnerMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnPartnersActionPerformed

    private void mvadnProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnProjektActionPerformed
        new ProjektMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnProjektActionPerformed

    private void mvadnAvdelningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnAvdelningarActionPerformed
        new AvdelningMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnAvdelningarActionPerformed

    private void mvadnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnPersonalActionPerformed
        new AnstalldMeny(idb, admins, anvandare).setVisible(true);
    }//GEN-LAST:event_mvadnPersonalActionPerformed

    private void mvprojStatistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojStatistikActionPerformed
        new Statistik(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojStatistikActionPerformed

    private void mvprojAndraPartnersForProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojAndraPartnersForProjektActionPerformed
        new EditProjektPartner(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojAndraPartnersForProjektActionPerformed

    private void mvprojHallarbhetsmalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojHallarbhetsmalActionPerformed
        new HallbarhetsmalMeny(idb, true).setVisible(true);
    }//GEN-LAST:event_mvprojHallarbhetsmalActionPerformed

    private void mvprojProjektPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojProjektPartnersActionPerformed
        new PartnerMeny(idb, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojProjektPartnersActionPerformed

    private void mvprojAllaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojAllaProjektActionPerformed
        new ProjektMeny(idb, true, queryAid).setVisible(true);
    }//GEN-LAST:event_mvprojAllaProjektActionPerformed

    private void mvprojMinaProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvprojMinaProjektActionPerformed
        if (projl != null){
            new ProjektMeny(idb, queryAid, true).setVisible(true);
        }
        else {
            new ProjektMeny(idb, queryAid).setVisible(true);
        }
    }//GEN-LAST:event_mvprojMinaProjektActionPerformed
    
    private void mvminLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvminLoggaUtActionPerformed
        new InloggningMeny(idb).setVisible (true);
        this.setVisible(false);
    }//GEN-LAST:event_mvminLoggaUtActionPerformed

    private void mvminMinaUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvminMinaUppgifterActionPerformed
        new EditAnstalld(idb, queryAid, admins, anvandare).setVisible(true);
    }//GEN-LAST:event_mvminMinaUppgifterActionPerformed

    private void mvminPersonalPaMinAvdelningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvminPersonalPaMinAvdelningActionPerformed
        new AnstalldMeny(idb, anvandare).setVisible(true);
    }//GEN-LAST:event_mvminPersonalPaMinAvdelningActionPerformed

    private void mvadnStadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvadnStadActionPerformed
        new StadMeny(idb).setVisible(true);
    }//GEN-LAST:event_mvadnStadActionPerformed

    private void btnSlumpaFaktaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlumpaFaktaActionPerformed
        lblFunFact.setText(genereraFunFact());
    }//GEN-LAST:event_btnSlumpaFaktaActionPerformed
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSlumpaFakta;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDagens;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFunFact;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblRoll;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JMenu menyAdministration;
    private javax.swing.JMenu menyHjalp;
    private javax.swing.JMenu menyMinaUppgifter;
    private javax.swing.JMenu menyProjekt;
    private javax.swing.JMenuItem mvadnAvdelningar;
    private javax.swing.JMenuItem mvadnHallbarhetsmal;
    private javax.swing.JMenuItem mvadnLand;
    private javax.swing.JMenuItem mvadnPartners;
    private javax.swing.JMenuItem mvadnPersonal;
    private javax.swing.JMenuItem mvadnProjekt;
    private javax.swing.JMenuItem mvadnStad;
    private javax.swing.JMenuItem mvhjOm;
    private javax.swing.JMenuItem mvminLoggaUt;
    private javax.swing.JMenuItem mvminMinaUppgifter;
    private javax.swing.JMenuItem mvminPersonalPaMinAvdelning;
    private javax.swing.JMenuItem mvprojAllaProjekt;
    private javax.swing.JMenuItem mvprojAndraPartnersForProjekt;
    private javax.swing.JMenuItem mvprojHallarbhetsmal;
    private javax.swing.JMenuItem mvprojMinaProjekt;
    private javax.swing.JMenuItem mvprojProjektPartners;
    private javax.swing.JMenuItem mvprojStatistik;
    // End of variables declaration//GEN-END:variables
}
