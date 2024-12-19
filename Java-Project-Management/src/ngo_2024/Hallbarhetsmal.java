/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Claudia Kourieh
 */
public class Hallbarhetsmal {
    private InfDB idb;
    private String namn;
    private int malnummer;
    private String beskrivning;
    private String prioritet;
    private int hid;

    public Hallbarhetsmal(InfDB idb, String namn, int malnummer, String beskrivning, String prioritet, int hid) {
        this.idb = idb;
        this.namn = namn;
        this.malnummer = malnummer;
        this.beskrivning = beskrivning;
        this.prioritet = prioritet;
        this.hid = hid;
    }

    public String getNamn() {
        return namn;
    }

    public int getMalnummer() {
        return malnummer;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getPrioritet() {
        return prioritet;
    }

    public int getHid() {
        return hid;
    }

    public ArrayList<HashMap<String, String>> allaHallbarhetsmal() {
        ArrayList<HashMap<String, String>> allaHallbarhetsmal = new ArrayList<>();
        try {
            String sqlfråga = "SELECT * FROM hallbarhetsmal";
            allaHallbarhetsmal = idb.fetchRows(sqlfråga);
        } catch (InfException e) {
            System.out.println("Kunde inte hämta hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta hållbarhetsmål. \n" + e.getMessage());
        }
        return allaHallbarhetsmal;
    }

    public HashMap<String, String> getEttHallbarhetsmal() {
        HashMap<String, String> ettHallbarhetsmal = new HashMap<>();
        try {
            String sqlfråga = "SELECT * FROM hallbarhetsmal WHERE hid = " + hid;
            ettHallbarhetsmal = idb.fetchRow(sqlfråga);
        } catch (InfException e) {
            System.out.println("Kunde inte hämta hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta hållbarhetsmål. \n" + e.getMessage());
        }
        return ettHallbarhetsmal;
    }
    
    public void sparaHallbarhetsmal() {
        try {
            String sqlfråga = "INSERT INTO hallbarhetsmal (namn, malnummer, beskrivning, prioritet, hid) VALUES ('" 
                              + namn + "', " + malnummer + ", '" + beskrivning + "', '" + prioritet + "', " + hid + ")";
            idb.insert(sqlfråga);
        } catch (InfException e) {
            System.out.println("Hållbarhetsmål har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Hållbarhetsmål har inte sparats i databasen. \n" + e.getMessage());
        }
    }
    
    public void andraHallbarhetsmal(int hid, String nyttNamn, int nyttMalnummer, String nyBeskrivning, String nyPrioritet) {
    try {
        String sqlfråga = "UPDATE hallbarhetsmal SET namn = '" + nyttNamn + 
                          "', malnummer = " + nyttMalnummer + 
                          ", beskrivning = '" + nyBeskrivning + 
                          "', prioritet = '" + nyPrioritet + 
                          "' WHERE hid = " + hid;
        idb.update(sqlfråga);
        System.out.println("Hållbarhetsmål uppdaterat!");
    } catch (InfException e) {
        System.out.println("Kunde inte uppdatera hållbarhetsmål.");
        JOptionPane.showMessageDialog(null, "Kunde inte uppdatera hållbarhetsmål. \n" + e.getMessage());
    }
}

    public void taBortHallbarhetsmal(int hid) {
    try {
        String sqlfråga = "DELETE FROM hallbarhetsmal WHERE hid = " + hid;
        idb.delete(sqlfråga);
        System.out.println("Hållbarhetsmål raderat!");
    } catch (InfException e) {
        System.out.println("Kunde inte radera hållbarhetsmål.");
        JOptionPane.showMessageDialog(null, "Kunde inte radera hållbarhetsmål. \n" + e.getMessage());
    }
  }
}