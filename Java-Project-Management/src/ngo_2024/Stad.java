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
 * Klass för entiteten Stad. Innehåller såväl klassmetoder som SQL-frågor. 
 * 
 * @author Andreas Galistel
 */
public class Stad {
    
    private InfDB idb;
    private int sid;
    private String namn;
    private int land;
    
    /**
     * Konstruktor för att skapa ett Stad-objekt
     * @param idb
     * @param namn
     * @param land 
     */
    public Stad(InfDB idb, String namn, int land)
    {
        this.namn = namn;
        this.land = land;
    }
    
    /**
     * Konstruktor för att instantiera endast klasssen. 
     * @param idb 
     */
    
    public Stad(InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * 
     * Nedan följer get-metoder
     * 
     */
    
    /**
     * Metod för att hämta namn på Stad
     * @return 
     */
    public String getNamn(int sid)
    {
        try
        {
            String query = "SELECT namn FROM stad WHERE sid = " + sid;
            namn = idb.fetchSingle(query);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return namn;
    }
    
    /**
     * Metod för att hämta land för en stad.
     * @return 
     */
    public int getLand(int sid)
    {
        try
        {
            String query = "SELECT land FROM stad WHERE sid = " + sid;
            land = Integer.parseInt(idb.fetchSingle(query));
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
        }
        return land;
    }
    
    /**
     * Metod för att hämta sid för en stad
     * @return 
     */
    public int getSid()
    {
        return sid;
    }
    
    /**
     * Metod för att hämta ut alla städer.
     * @return 
     */
    public ArrayList<HashMap<String, String>> getAllaStader()
    {
        ArrayList<HashMap<String, String>> allaStäder = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM stad";
            allaStäder = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta städer.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta städer. \n" + e.getMessage());
            allaStäder = null;
        }
        return allaStäder;

    }
    /**
     * Metod för att hämta ut en stad från databasen.
     * @return 
     */
    public HashMap<String, String> getEnStad()
    {
        HashMap<String, String> enStad = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM stad WHERE sid = '" + sid + "'";
            enStad = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta stad.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta stad. \n" + e.getMessage());
            enStad = null;
        }
        return enStad;
    }
    
    /**
     * 
     * Nedan följer set-metoder
     * 
     */
    
    /**
     * Metod för att uppdatera namn på en Stad. 
     * @param namn 
     */
    public void setNamn(int sid, String namn)
    {
        try
        {
            String sqlfråga = "UPDATE stad WHERE sid = " + sid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera land för en Stad
     * @param sid
     * @param lid 
     */
    public void setLand(int sid, int lid)
    {
        try
        {
            String sqlfråga = "UPDATE stad WHERE sid = " + sid + " SET land = " + lid;
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage());
        }

    }
    
    /**
     * Metod för att spara en stad i databasen.
     * @param namn
     * @param lid 
     */
    public void sparaStad(String namn, int lid)
    {
        try
        {
            String sqlfråga = "INSERT INTO stad (namn, land) values ('" + namn + "', " + lid + ")";
            idb.insert(sqlfråga);
        }   
        catch(InfException e)
        {
            System.out.println("Staden har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Staden har inte sparats i databasen. \n" + e.getMessage()); 
        }
    }
    
}
