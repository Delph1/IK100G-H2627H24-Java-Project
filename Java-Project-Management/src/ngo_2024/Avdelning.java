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
 * @author Märta Sjöblom
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
    private int chef;
    
    /**
     * Konstruktor som endast instansierar objekt med databasparameter
     * 
     * @param idb 
     */
    public Avdelning (InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * Konstruktor för instansiering av komplett fältfylld objekt
     * @param idb
     * @param namn
     * @param beskrivning
     * @param adress
     * @param epost
     * @param telefon
     * @param stad
     * @param chef 
     */
    public Avdelning(InfDB idb, String namn, String beskrivning, String adress, String epost, String telefon, int stad, int chef) 
    {
        this.idb = idb;
        this.namn = namn;
        this.beskrivning = beskrivning;
        this.adress = adress;
        this.epost = epost;
        this.telefon = telefon;
        this.stad = stad;
        this.chef = chef;

        try {
            String sqlfråga = "INSERT INTO Avdelning (namn, beskrivning, adress, epost, telefon, stad, chef) values ('"
                    + namn + "', '" + beskrivning + "', '" + adress + "', '" + epost + "', '" + telefon + "', " + stad + ", " + chef + ")";

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
     * @param avdid
     * @return namn på Avdelning
     */
    public String getNamn(int avdid) {
        if (namn == null) {
            try {
                String sqlFråga = "SELECT namn FROM avdelning WHERE avdid = " + avdid;
                String dbNamn = idb.fetchSingle(sqlFråga);
                return dbNamn;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return namn;
    }
    
    /**
     * 
     * @param avdid
     * @return beskrivning på Avdelning
     */
    public String getBeskrivning(int avdid) {
        if (beskrivning == null) {
            try {
                String sqlFråga = "SELECT beskrivning FROM avdelning WHERE avdid = " + avdid;
                String dbBeskrivning = idb.fetchSingle(sqlFråga);
                return dbBeskrivning;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return beskrivning;
    }
    
    /**
     * 
     * @param avdid
     * @return adress till Avdelning
     */
    public String getAdress(int avdid) {
        if (adress == null) {
            try {
                String sqlFråga = "SELECT adress FROM avdelning WHERE avdid = " + avdid;
                String dbAdress = idb.fetchSingle(sqlFråga);
                return dbAdress;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return adress;
    }
    
    /**
     * 
     * @param avdid
     * @return epost till Avdelning
     */
    public String getEpost(int avdid) {
        if (epost == null) {
            try {
                String sqlFråga = "SELECT epost FROM avdelning WHERE avdid = " + avdid;
                String dbEpost = idb.fetchSingle(sqlFråga);
                return dbEpost;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return epost;
    }
    
    /**
     * 
     * @param avdid
     * @return telefon till Avdelning
     */
    public String getTelefon(int avdid) {
        if (telefon == null) {
            try {
                String sqlFråga = "SELECT telefon FROM avdelning WHERE avdid = " + avdid;
                String dbTelefon = idb.fetchSingle(sqlFråga);
                return dbTelefon;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return telefon;
    }
    
    /**
     * 
     * @param avdid
     * @return stad där Avdelning ligger
     */
    public int getStad(int avdid) {
        if (stad == 0) {
            try {
                String sqlFråga = "SELECT stad FROM avdelning WHERE avdid = " + avdid;
                int dbStad = Integer.parseInt(idb.fetchSingle(sqlFråga));
                return dbStad;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return stad;
    }
    
    /**
     * 
     * @param avdid
     * @return chef över Avdelning
     */
    public int getChef(int avdid) {
        if (chef == 0) {
            try {
                String sqlFråga = "SELECT chef FROM avdelning WHERE avdid = " + avdid;
                int dbChef = Integer.parseInt(idb.fetchSingle(sqlFråga));
                return dbChef;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return chef;
    }
    
    /**
     * Returnerar en HashMap över en avdelning
     * @param avdid
     * @return enAvdelning
     */
    public HashMap<String, String> getEnAvdelning(int avdid)
    {
        HashMap<String, String> enAvdelning = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM avdelning WHERE pid = " + avdid;
            enAvdelning = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta avdelningen. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta avdelningen.");
            enAvdelning = null;
        }
        return enAvdelning;
    }
    
    /**
     * Returnerar arraylist bestående av HashMaps för alla avdelningar
     * @return 
     */
    public ArrayList<HashMap<String, String>> getAllaAvdelningar()
    {
        ArrayList<HashMap<String, String>> allaAvdelningar = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM avdelning";
            allaAvdelningar = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
            allaAvdelningar = null;
        }
        return allaAvdelningar;
    }
    
        public void setNyAvdelning(String namn, String beskrivning, String adress, String epost, String telefon, int stad, int chef) 
    {
        try {
            String sqlfråga = "INSERT INTO Avdelning (namn, beskrivning, adress, epost, telefon, stad, chef) values ('"
                    + namn + "', '" + beskrivning + "', '" + adress + "', '" + epost + "', '" + telefon + "', " + stad + ", " + chef + ")";

            idb.insert(sqlfråga);
            JOptionPane.showMessageDialog(null, "Ny avdelning lades till korrekt");
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
        
        
    /**
     * Uppdaterar en avdelnings namn
     * @param avdid
     * @param namn (String)
     */
    public void setNamn(int avdid, String namn) 
    {
        //this.namn = namn;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings beskrivning
     * @param avdid
     * @param beskrivning (String)
     */
    public void setBeskrivning(int avdid, String beskrivning) 
    {
        //this.beskrivning = beskrivning;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET beskrivning = '" + beskrivning + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings adress
     * @param avdid
     * @param adress (String)
     */
    public void setAdress(int avdid, String adress) 
    {
        //this.adress = adress;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET adress = '" + adress + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings epost
     * @param avdid
     * @param epost (String)
     */
    public void setEpost(int avdid, String epost) 
    {
        //this.epost = epost;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET epost = '" + epost + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings telefon
     * @param avdid
     * @param telefon (String)
     */
    public void setTelefon(int avdid, String telefon) 
    {
        //this.telefon = telefon;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET telefon = '" + telefon + "'";
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings stad-nyckel
     * @param avdid
     * @param stad 
     */
    public void setStad(int avdid, int stad) 
    {
        //this.stad = stad;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET stad = " + stad;
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Uppdaterar en avdelnings chef-nyckel
     * @param avdid
     * @param chef 
     */
    public void setChef(int avdid, int chef)
    {
        //this.chef = chef;

        try {
            String sqlfråga = "UPDATE Avdelning WHERE avdid = " + avdid + " SET chef = " + chef;
            idb.update(sqlfråga);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
}
