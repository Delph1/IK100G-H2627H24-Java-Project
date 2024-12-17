/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Fredrik Magnusson
 */
public class Validering {

    public static boolean emailKontroll(JTextField email) {
        
        boolean resultat = true;

        // Kontrolerar här om email är tom, och är den det startas en textruta och ifsatsen avslutas.
        if (email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fältet är tomt");
            resultat = false;

        } // Om mailen inte är tom kontrolleras den här med Regex om det är en epost, dvs innehåller ett @ och efter det en punkt.
        else if (!email.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$")) {

            JOptionPane.showMessageDialog(null, "Ogiltig e-postadress");
            resultat = false;
        }

        return resultat;

    }
}
