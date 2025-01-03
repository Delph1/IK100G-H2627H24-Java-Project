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
 * Klass för att spara och skapa ny Partner.
 * @author Andreas Galistel
 */
public class EditPartner extends javax.swing.JFrame {

    private InfDB idb;
    private String queryAid;
    private Stad stad;
    private ArrayList<HashMap<String, String>> allaStader;
    /**
     * Creates new form EditPartner
     */
    public EditPartner(InfDB idb, String queryAid) {
        this.idb = idb;
        this.queryAid = queryAid;
        this.stad = new Stad(idb);
        this.allaStader = new ArrayList<>();
        initComponents();
        setLocationRelativeTo(null);
        
        if (queryAid != null)
        {
            getPartnerdata(queryAid);
        }
        else
        {
            lblId.setVisible(false);
            txtId.setVisible(false);
        }
        txtStadId.setVisible(false);
        populeraCbStad();
    }
    
    /**
     * Metod för att skapa upp listan med städer i comboboxen.
     */
    
    private void populeraCbStad()
    {
        allaStader = stad.getAllaStader();
        //Lägger till nuvarande staden först i listan
        for(HashMap<String, String> enStad : allaStader)
        {
            if (enStad.get("sid").equals(txtStadId.getText()))
            {
                cbStadNamn.addItem(enStad.get("namn"));
            }
        }
        //och sedan resten.
        for(HashMap<String, String> enStad : allaStader)
        {
            if (!enStad.get("sid").equals(txtStadId.getText()))
            {
                cbStadNamn.addItem(enStad.get("namn"));
            }
        }
    }
        
        private void getPartnerdata(String queryAid)
    {
        try {
            String query = "SELECT * FROM partner WHERE pid = " + queryAid;
            System.out.println(query);

            HashMap<String, String> resultat = idb.fetchRow(query); // Hämta rad som en HashMap

                if (resultat != null) {
                    // Hämta och sätt värden i motsvarande textfält

                    txtNamn.setText(resultat.get("namn"));
                    txtKontaktperson.setText(resultat.get("kontaktperson"));
                    txtKontaktepost.setText(resultat.get("kontaktepost"));  
                    txtTelefon.setText(resultat.get("telefon"));
                    txtAdress.setText(resultat.get("adress"));       
                    txtBranch.setText(resultat.get("branch"));       
                    txtStadId.setText(resultat.get("stad")); 
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Ingen avdelning hittades med det angivna ID:t.");
                }
            } catch (InfException e) {
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
        lblKontaktperson = new javax.swing.JLabel();
        lblKontaktepost = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblAdress = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        txtKontaktepost = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();
        txtKontaktperson = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtBranch = new javax.swing.JTextField();
        cbStadNamn = new javax.swing.JComboBox<>();
        btnSpara = new javax.swing.JButton();
        txtStadId = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNamn.setText("Namn:");

        lblKontaktperson.setText("Kontaktperson:");

        lblKontaktepost.setText("Kontakt e-post:");

        lblTelefon.setText("Telefon:");

        lblAdress.setText("Adress:");

        lblBranch.setText("Branch:");

        lblStad.setText("Stad:");

        txtKontaktepost.setColumns(10);

        txtNamn.setColumns(10);

        txtKontaktperson.setColumns(10);

        txtTelefon.setColumns(10);

        txtAdress.setColumns(10);

        txtBranch.setColumns(10);

        cbStadNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStadNamnActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        txtStadId.setColumns(10);

        txtId.setEnabled(false);

        lblId.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblKontaktepost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKontaktperson)
                            .addComponent(lblNamn)
                            .addComponent(lblTelefon)
                            .addComponent(lblAdress)
                            .addComponent(lblBranch)
                            .addComponent(lblStad))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBranch)
                            .addComponent(txtTelefon)
                            .addComponent(txtNamn)
                            .addComponent(txtKontaktepost)
                            .addComponent(txtKontaktperson)
                            .addComponent(txtAdress)
                            .addComponent(cbStadNamn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSpara)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamn)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktperson)
                    .addComponent(txtKontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKontaktepost)
                    .addComponent(txtKontaktepost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefon)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranch)
                    .addComponent(txtBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStad)
                    .addComponent(cbStadNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSpara)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbStadNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStadNamnActionPerformed
        // Uppdaterar txtStadId med rätt Id när man väljer en ny stad i listan.
        String nyStad = cbStadNamn.getSelectedItem().toString();
        for(HashMap<String, String> enStad : allaStader)
        {
            if(enStad.get("namn").equals(nyStad))
            {
                txtStadId.setText(enStad.get("sid"));
            }
        }
    }//GEN-LAST:event_cbStadNamnActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        if (Validering.faltEjTomtKontroll(txtNamn) &&
            Validering.faltEjTomtKontroll(txtKontaktperson) &&
            Validering.faltEjTomtKontroll(txtKontaktepost) &&
            Validering.faltEjTomtKontroll(txtTelefon) &&
            Validering.faltEjTomtKontroll(txtAdress) &&
            Validering.faltEjTomtKontroll(txtBranch) &&
            Validering.faltEjTomtKontroll(txtStadId) &&
            Validering.comboBoxInteTom(cbStadNamn.getSelectedItem()) &&
            Validering.arHeltal(txtStadId) &&
            Validering.positivtVarde(txtStadId))
        {
            String namn = txtNamn.getText();
            String kontaktperson = txtKontaktperson.getText();
            String kontaktepost = txtKontaktepost.getText();
            String telefon = txtTelefon.getText();
            String adress = txtAdress.getText();
            String branch = txtBranch.getText();
            int stad = Integer.parseInt(txtStadId.getText());

            try
            {
                if(queryAid == null)
                {
                    int pid = Integer.parseInt(idb.getAutoIncrement("partner", "pid"));
                    String query = "INSERT INTO partner (pid, namn, kontaktperson, kontaktepost, telefon, adress, branch, stad)"
                    + " VALUES ("
                    + pid + ", '"
                    + namn + "', '"
                    + kontaktperson + "', '"
                    + kontaktepost + "', '"
                    + telefon + "', '"
                    + adress + "', '"
                    + branch + "', "
                    + stad + ")";
                    System.out.println(query);
                    idb.insert(query);

                }
                else
                {
                    String query = "UPDATE partner "
                    + "SET namn = '" + namn + "', "
                    + "kontaktperson = '" + kontaktperson + "', "
                    + "kontaktepost = '" + kontaktepost + "', "
                    + "adress = '" + adress + "', "
                    + "telefon = '" + telefon + "', "
                    + "stad = " + stad + ", "
                    + "branch = '" + branch
                    + "' WHERE pid = " + queryAid;
                    System.out.println(query);
                    idb.update(query);

                }

                JOptionPane.showMessageDialog(null, "Partnern har sparats.");
                this.setVisible(false);

            }
            catch(InfException e)
            {
                System.out.println("Ett fel inträffade: " + e.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Partnern har inte sparats.");
        }
    }//GEN-LAST:event_btnSparaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbStadNamn;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKontaktepost;
    private javax.swing.JLabel lblKontaktperson;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBranch;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKontaktepost;
    private javax.swing.JTextField txtKontaktperson;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtStadId;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
