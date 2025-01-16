/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author andre
 */
public class InloggningMeny extends javax.swing.JFrame {

    private InfDB idb;
    private EditAnstalld anstalld;
    
    /**
     * Creates new form Inloggning
     * @param idb
     */
    public InloggningMeny( InfDB idb) {
        this.idb = idb;
        this.anstalld = new EditAnstalld(idb);
        initComponents();
        lblMeddelande.setVisible(false);
        setLocationRelativeTo(null); //Den här koden sätter fönstret i mitten av skärmen.
        txtLösenord.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAnvändarnamn = new javax.swing.JLabel();
        lblLösenord = new javax.swing.JLabel();
        txtAnvändarnamn = new javax.swing.JTextField();
        lblMeddelande = new javax.swing.JLabel();
        btnLoggaIn = new javax.swing.JButton();
        txtLösenord = new javax.swing.JPasswordField();
        btnAterställLösenord = new javax.swing.JButton();
        lblLoggaIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inloggning");

        lblAnvändarnamn.setText("Användarnamn:");

        lblLösenord.setText("Lösenord:");

        txtAnvändarnamn.setToolTipText("");

        lblMeddelande.setForeground(new java.awt.Color(255, 51, 51));
        lblMeddelande.setText("Felaktigt användarnamn eller lösenord.");

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        txtLösenord.setText("jPasswordField1");
        txtLösenord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLösenordKeyPressed(evt);
            }
        });

        btnAterställLösenord.setText("Glömt lösenord");
        btnAterställLösenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAterställLösenordActionPerformed(evt);
            }
        });

        lblLoggaIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLoggaIn.setText("Logga in");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMeddelande)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnvändarnamn)
                                    .addComponent(lblLösenord))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblLoggaIn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
                                    .addComponent(txtAnvändarnamn)
                                    .addComponent(txtLösenord)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 169, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAterställLösenord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoggaIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblLoggaIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnvändarnamn)
                    .addComponent(txtAnvändarnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLösenord)
                    .addComponent(txtLösenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMeddelande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoggaIn)
                .addGap(5, 5, 5)
                .addComponent(btnAterställLösenord)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void loggaIn(String användarnamn, String lösenord)
    {
        if (Validering.faltEjTomtKontroll(txtAnvändarnamn) && Validering.epostKontroll(txtAnvändarnamn.getText()) && (Validering.faltEjTomtKontroll(txtLösenord))) {

            try {
                String sqlfråga = "Select losenord FROM anstalld WHERE epost = '" + användarnamn + "'";
                String query = idb.fetchSingle(sqlfråga);
                

                if (lösenord.equals(query)) {

                    String sqlfrågaAid = "Select aid FROM anstalld WHERE epost = '" + användarnamn + "'";
                    String queryAid = idb.fetchSingle(sqlfrågaAid);
                    

                    String sqlFrågaAdmin = "Select behorighetsniva FROM admin WHERE aid = '" + queryAid + "'";
                    String admins = idb.fetchSingle(sqlFrågaAdmin);
                    
                    
                   String sqlFrågaHand = "Select projektchef FROM projekt WHERE projektchef = '" + queryAid + "'";
                    String projl = idb.fetchSingle(sqlFrågaHand);

                    new Huvudmeny(idb, queryAid, admins, projl).setVisible(true);

                    this.setVisible(false);
                } else {
                    lblMeddelande.setVisible(true);
                }
            } catch (InfException e) {
                System.out.println(e.getMessage());
            }
        }
    }
        
    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        
        String användarnamn = txtAnvändarnamn.getText();
        String lösenord = new String(txtLösenord.getPassword());
        
        loggaIn(användarnamn, lösenord);
        
    }//GEN-LAST:event_btnLoggaInActionPerformed

    private void txtLösenordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLösenordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String användarnamn = txtAnvändarnamn.getText();
            String lösenord = new String(txtLösenord.getPassword());
            loggaIn(användarnamn, lösenord);
        }
    }//GEN-LAST:event_txtLösenordKeyPressed

    private void btnAterställLösenordActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        String dialog = "Ange din e-postadress i rutan nedan,";
        boolean pågår = true; //Fortsätta visa dialogruta tills anv får lösenord eller trycker cancel/kryss
        while (pågår) {  
            String svar = JOptionPane.showInputDialog(this, dialog);
            if (svar == null) {
                pågår = false;
            } else {
                if (!svar.isBlank()) {
                    pågår = false;
                    if (Validering.epostKontroll(svar)) {
                        boolean finns = anstalld.finnsEpost(svar);
                        if (finns) { 
                            String nyttLosen = anstalld.genereraLösenord(10);
                            boolean uppdateraLosen = anstalld.uppdateraLosenord(svar, nyttLosen);
                            if (uppdateraLosen) {
                                // Skapar en knapp för att kopiera lösenordet till urklippet
                                JButton kopieraKnapp = new JButton("Kopiera lösenord");
                                JPanel panel = new JPanel();
                                panel.setLayout(new BorderLayout(10, 10));
                                JLabel message = new JLabel("Ditt nya lösenord är: " + nyttLosen);
                                panel.add(message, BorderLayout.CENTER);
                                panel.add(kopieraKnapp, BorderLayout.SOUTH);

                                // "lyssnar" på knappen för att kopiera det nya lösenordet.
                                kopieraKnapp.addActionListener(e -> {
                                    StringSelection selection = new StringSelection(nyttLosen);
                                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
                                    JOptionPane.showMessageDialog(this, "Lösenordet har kopierats till urklipp!");
                                });
                                // Visar dialogruta med kopieringsknapp
                                JOptionPane.showMessageDialog(this, panel, "Nytt lösenord", JOptionPane.PLAIN_MESSAGE);
                            }
                        } else {
                                JOptionPane.showMessageDialog(this, "Epostadressen hittades inte i systemet.");                            
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Epostadressen är inte korrekt formaterad.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vänligen skriv in en epostadress ");
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAterställLösenord;
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel lblAnvändarnamn;
    private javax.swing.JLabel lblLoggaIn;
    private javax.swing.JLabel lblLösenord;
    private javax.swing.JLabel lblMeddelande;
    private javax.swing.JTextField txtAnvändarnamn;
    private javax.swing.JPasswordField txtLösenord;
    // End of variables declaration//GEN-END:variables
}
