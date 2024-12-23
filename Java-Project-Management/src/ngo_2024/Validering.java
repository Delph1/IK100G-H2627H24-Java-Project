/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
    
    public static boolean faltEjTomtKontroll(JTextField param) {
        boolean resultat = true;

        // Kontrollerar här om ett fält är tomt, och om den är det visas en textruta och if-satsen avslutas
        if (param.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fältet är tomt.\nVar vänlig fyll i fältet.");
            resultat = false;           
        }       return resultat;
    }
    
    /**
     * Kontrollerar fält för inmatning mot korrekt datumformatering enligt yyyy-MM-dd
     * @param param
     * @return 
     */
    public static boolean datumKontroll(JTextField param) 
    {
        boolean resultat = true;

        // Kontrolerar här om ett fält har korrekt datumformatering enligt yyyy-MM-dd
        try {
            LocalDate ld = LocalDate.parse(param.getText());
        }
        catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Felaktigt datumformat. \nVar vänlig fyll i enligt ÅÅÅÅ-MM-DD");
            resultat = false;           
        }
        return resultat;
    }
    
    /**
     * Tar ett datum att utgå från, ex genom SQL-query, för att jämföra så att
     * det nyinmatade datumet är samtidigt eller tidigare
     * 
     * Ingen kontroll av korrekt formatering sker, använd gärna i kombination med metoden .datumKontroll() för fält
     * 
     * @param slutDatum
     * @param param
     * @return resultat boolean
     */
    public static boolean datumFöreKontroll (String slutDatum, JTextField param)
    {
        boolean resultat = true;
        LocalDate slut = LocalDate.parse(slutDatum);
        LocalDate start = LocalDate.parse(param.getText());
        
        if(start.isAfter(slut)) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Startdatumet är senare än slutdatumet.\n" +
                    "Var vänlig fyll i ett startdatum som är samma dag eller tidigare än slutdatum");
        }
        return resultat;
    }
    /**
     * Tar ett datum att utgå från, ex genom SQL-query, för att jämföra så att
     * det nyinmatade datumet är samtidigt eller senare
     * 
     * Ingen kontroll av korrekt formatering sker, använd gärna i kombination med metoden .datumKontroll() för fält
     * 
     * @param startDatum
     * @param param
     * @return resultat boolean
     */
    public static boolean datumEfterKontroll(String startDatum, JTextField param)
    {
        boolean resultat = true;
        LocalDate start = LocalDate.parse(startDatum);
        LocalDate slut = LocalDate.parse(param.getText());
        
        if(slut.isBefore(start)) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Slutdatumet är före startdatumet. \n" +
                    "Var vänlig fyll i ett slutdatum som är samma dag eller senare än startdatum");
        }
        return resultat;
    }
            
            
}