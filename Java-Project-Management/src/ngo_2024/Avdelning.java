/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author SuperPC
 */
public class Avdelning {

    private InfDB idb;
    private int avdid;
    private String namn;
    private String beskrivning;
    private String adress;
    private String epost;
    private String telefon;
    private int stad;
    private int chef; //Chef just nu bara int vid input i konstruktorn, ska ändras till hämtas. Även set-metod längre ner

    public Avdelning(InfDB idb, String namn, String beskrivning, String adress, String epost, String telefon, Stad stad, int chef) //Ska ändras till Handläggare chef när klassen är klar
    {
        this.idb = idb;
        this.namn = namn;
        this.beskrivning = beskrivning;
        this.adress = adress;
        this.epost = epost;
        this.telefon = telefon;
        this.stad = stad.getSid();
        this.chef = chef; //ska ändras til chef.getID

        try {
            String sqlfråga = "INSERT INTO Avdelning (namn, beskrivning, adress, epost, telefon, stad, chef) values ('"
                    + namn + "', '" + beskrivning + "', '" + adress + "', '" + epost + "', '" + telefon + "', '" + stad + "', '" + chef + "')";

            idb.insert(sqlfråga);
            String sqlAvdid = "select lid from land where namn = '" + namn + "'";   //autoskapar avdID, hämtar med namn
            String dbAvdid = idb.fetchSingle(sqlAvdid);
            this.avdid = Integer.parseInt(dbAvdid);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @return avdid
     */
    public int getAvdid() {
        return avdid;
    }
    /**
     * 
     * @return namn på Avdelning
     */
    public String getNamn() {
        return namn;
    }
    
    /**
     * 
     * @return beskrivning på Avdelning
     */
    public String getBeskrivning() {
        return beskrivning;
    }
    
    /**
     * 
     * @return adress till Avdelning
     */
    public String getAdress() {
        return adress;
    }
    
    /**
     * 
     * @return epost till Avdelning
     */
    public String getEpost() {
        return epost;
    }
    
    /**
     * 
     * @return telefon till Avdelning
     */
    public String getTelefon() {
        return telefon;
    }
    
    /**
     * 
     * @return stad där Avdelning ligger
     */
    public int getStad() {
        return stad;
    }
    
    /**
     * 
     * @return chef över Avdelning
     */
    public int getChef() {
        return chef;
    }
    
    /**
     * Sätter namn på Avdelning och uppdaterar databasen
     * @param namn (String)
     */
    public void setNamn(String namn) 
    {
        this.namn = namn;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter beskrivning på Avdelning och uppdaterar databasen
     * @param beskrivning (String)
     */
    public void setBeskrivning(String beskrivning) 
    {
        this.beskrivning = beskrivning;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET beskrivning = '" + beskrivning + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter adress på Avdelning och uppdaterar databasen
     * @param adress (String)
     */
    public void setAdress(String adress) 
    {
        this.adress = adress;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET adress = '" + adress + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter epost till Avdelning och uppdaterar databasen
     * @param epost (String)
     */
    public void setEpost(String epost) 
    {
        this.epost = epost;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET epost = '" + epost + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter telefon till på Avdelning och uppdaterar databasen
     * @param telefon (String)
     */
    public void setTelefon(String telefon) 
    {
        this.telefon = telefon;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET telefon = '" + telefon + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter stad-id på Avdelning och uppdaterar databasen
     * @param stad 
     */
    public void setStad(Stad stad) 
    {
        this.stad = stad.getSid();

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET stad = '" + stad + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Sätter avdelningschef till Avdelning och uppdaterar databasen
     * @param chef 
     */
    public void setChef(int chef) //Uppdatera när vi kan koppla mot Anställd/Handläggare
    {
        this.chef = chef;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET chef = '" + chef + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
}
