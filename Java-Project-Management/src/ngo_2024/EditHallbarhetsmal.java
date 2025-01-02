/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo_2024;

import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author andre
 */
public class EditHallbarhetsmal extends javax.swing.JFrame {

    private InfDB idb;
    private String queryAid; 
    /**
     * Creates new form EditHallbarhetsmal
     */
    public EditHallbarhetsmal(InfDB idb, String queryAid) {
        this.idb = idb;
        this.queryAid = queryAid;
        initComponents();
        setLocationRelativeTo(null);
        
        if (queryAid != null)
        {
            getMaldata(queryAid);
        }
        else
        {
            lblId.setVisible(false);
            txtId.setVisible(false);
        }
    }

    private void getMaldata(String queryAid)
    {
        try 
        {
            String query = "SELECT * FROM hallbarhetsmal WHERE hid = " + queryAid;
            System.out.println(query);

            HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap

            if (resultat != null) {
                // Hämta och sätt värden i motsvarande textfält

                txtNamn.setText(resultat.get("namn"));
                txtMalnummer.setText(resultat.get("malnummer"));       
                txtBeskrivning.setText(resultat.get("beskrivning"));
                String prioritet = resultat.get("prioritet");
                int prio = 0;
                prio = switch (prioritet) {
                    case "Låg" -> 0;
                    case "Medel" -> 1;
                    default -> 2;
                };
                cbPrioritet.setSelectedIndex(prio);

            } else {
                JOptionPane.showMessageDialog(null, "Ingen avdelning hittades med det angivna ID:t.");
            }
        } 
        catch (InfException e) 
        {
            System.out.println("Ett fel inträffade: " + e.getMessage());
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

        lblNamn = new javax.swing.JLabel();
        lblBeskrivning = new javax.swing.JLabel();
        lblMalnummer = new javax.swing.JLabel();
        lblPrioritet = new javax.swing.JLabel();
        txtNamn = new javax.swing.JTextField();
        txtMalnummer = new javax.swing.JTextField();
        txtBeskrivning = new javax.swing.JTextField();
        cbPrioritet = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNamn.setText("Namn:");

        lblBeskrivning.setText("Beskrivning:");

        lblMalnummer.setText("Målnummer:");

        lblPrioritet.setText("Prioritet:");

        txtNamn.setColumns(10);
        txtNamn.setToolTipText("");

        txtMalnummer.setColumns(10);

        txtBeskrivning.setColumns(10);

        cbPrioritet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Låg", "Mellan", "Hög" }));

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblId.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblNamn)
                                .addGap(65, 65, 65)
                                .addComponent(txtNamn, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblMalnummer)
                                .addGap(37, 37, 37)
                                .addComponent(txtMalnummer))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(lblBeskrivning)
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblPrioritet)
                                        .addGap(66, 66, 66)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBeskrivning)
                                    .addComponent(cbPrioritet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(41, 41, 41)
                        .addComponent(lblId)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamn)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMalnummer)
                    .addComponent(txtMalnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeskrivning)
                    .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrioritet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("Namn: " + txtNamn.getText());
        System.out.println("Beskrivning: " + txtBeskrivning.getText());

        String namn = txtNamn.getText();
        String malnummer = txtMalnummer.getText();
        String beskrivning = txtBeskrivning.getText();
        int prio = cbPrioritet.getSelectedIndex();
        String prioritet;
        prioritet = switch (prio) {
            case 0 -> "Låg";
            case 1 -> "Medel";
            default -> "Hög";
        };
        try
        {
            if(queryAid == null)
            {
                int hid = Integer.parseInt(idb.getAutoIncrement("hallbarhetsmal", "hid"));
                String query = "INSERT INTO hallbarhetsmal (hid, namn, malnummer, beskrivning, prioritet)"
                + " VALUES ("
                + hid + ", '"
                + namn + "', '"
                + malnummer + "', '"
                + beskrivning + "', '"
                + prioritet + "')";
                System.out.println(query);
                idb.insert(query);

            }
            else
            {
                String query = "UPDATE hallbarhetsmal "
                + "SET namn = '" + namn + "', "
                + "malnummer = '" + malnummer + "', "
                + "beskrivning = '" + beskrivning + "', "
                + "prioritet = '" + prioritet 
                + "' WHERE hid = " + queryAid;
                System.out.println(query);
                idb.update(query);

            }

            JOptionPane.showMessageDialog(null, "Hållbarhetsmålet har sparats.");
            this.setVisible(false);

        }
        catch(InfException e)
        {
            System.out.println("Ett fel inträffade: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPrioritet;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBeskrivning;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMalnummer;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPrioritet;
    private javax.swing.JTextField txtBeskrivning;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMalnummer;
    private javax.swing.JTextField txtNamn;
    // End of variables declaration//GEN-END:variables
}
