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
 * Denna klass jobbar med att validera data inputs utifrån vissa kriterier
 * Används med Validering. och sedan valen nedan
 * emailKontroll = kontrollerar att en epost är korrekt formaterad.
 * faltKontroll = kontrollerar att ett fält inte är tom.
 */
public class Validering {

    public static boolean emailKontroll(JTextField param) {
        boolean resultat = true;

        // Fält kontrolleras här med Regex om det är en epost, dvs innehåller ett @ och efter det en punkt, och om den följer hur en mail ska se ut.
        if (!param.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$")) {

            JOptionPane.showMessageDialog(null, "Ogiltig Epost.\nVar vänlig kontrollera stavningen.");
            resultat = false;
        }       return resultat;
    }
    
    public static boolean faltkontroll(JTextField param) {
        boolean resultat = true;

        // Kontrolerar här om ett fält är tom, och är den det startas en textruta och ifsatsen avslutas
        if (param.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fältet är tomt.\nVar vänlig fyll i fältet.");
            resultat = false;           
        }       return resultat;
                    
}
}