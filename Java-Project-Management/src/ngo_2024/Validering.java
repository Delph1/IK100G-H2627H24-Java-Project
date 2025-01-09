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
 Denna klass jobbar med att validera data inputs utifrån vissa kriterier
 Används med Validering. och sedan valen nedan
 epostKontroll = kontrollerar att en epost är korrekt formaterad.
 faltKontroll = kontrollerar att ett fält inte är tom.
 */
public class Validering {

    public static boolean epostKontroll(String param) {
        boolean resultat = true;

        // Fält kontrolleras här med Regex om det är en epost, dvs innehåller ett @ och efter det en punkt, och om den följer hur en mail ska se ut.
        if (!param.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$")) {

            JOptionPane.showMessageDialog(null, "Ogiltig Epost.\nVar vänlig kontrollera stavningen.");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean faltEjTomtKontroll(JTextField param) {
        boolean resultat = true;

        // Kontrollerar här om ett fält är tomt, och om den är det visas en textruta och if-satsen avslutas
        if (param.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fältet är tomt.\nVar vänlig fyll i fältet.");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean arHeltal(JTextField param) {
        boolean resultat = true;
        try {
            int värde = Integer.parseInt(param.getText());
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Fältet innehåller värde som inte är heltal");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean arDecimal(JTextField param) {
        boolean resultat = true;
        try {
            double värde = Double.parseDouble(param.getText());
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Fältet innehåller värde som inte är decimalt");
            resultat = false;
        }
        return resultat;
    }
    
    public static boolean positivtVarde(JTextField param) {
        boolean resultat = true;
        double värde = Double.parseDouble(param.getText());
        if (värde < 0 ) {
            JOptionPane.showMessageDialog(null, "Fältet innehåller negativt tal. \nVar vänlig välj värde 0 eller högre.");
            resultat = false;
        }
        return resultat;
    }
    
    /**
     * Kontrollerar fält för inmatning mot korrekt datumformatering enligt yyyy-MM-dd
     * @param param
     * @return 
     */
    public static boolean datumKontroll(String param) 
    {
        boolean resultat = true;

        // Kontrolerar här om ett fält har korrekt datumformatering enligt yyyy-MM-dd
        try {
            LocalDate ld = LocalDate.parse(param);
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
     * @param startDatum
     * @return resultat boolean
     */
    public static boolean datumFöreKontroll (String slutDatum, String startDatum)
    {
        boolean resultat = true;
        LocalDate slut = LocalDate.parse(slutDatum);
        LocalDate start = LocalDate.parse(startDatum);
        
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
     * @param slutDatum
     * @return resultat boolean
     */
    public static boolean datumEfterKontroll(String startDatum, String slutDatum)
    {
        boolean resultat = true;
        LocalDate start = LocalDate.parse(startDatum);
        LocalDate slut = LocalDate.parse(slutDatum);
        
        if(slut.isBefore(start)) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Slutdatumet är före startdatumet. \n" +
                    "Var vänlig fyll i ett slutdatum som är samma dag eller senare än startdatum");
        }
        return resultat;
    }
            
    public static boolean comboBoxInteTom(Object param)
    {
        boolean resultat = true;
        if (param.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fältet är tomt.\nVar vänlig fyll i fältet.");
            resultat = false;           
        }       return resultat;
    }
}