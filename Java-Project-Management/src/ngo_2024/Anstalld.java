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
 * Klass för entiteten Anstalld. Innehåller klassmetoder och SQL-anrop. 
 * @author andre
 */
public class Anstalld {
    
    private InfDB idb;
    private int aid;
    private String fornamn;
    private String efternamn;
    private String adress;
    private String epost;
    private String telefon;
    private String anstallningsdatum;
    private String losenord;
    private int avdelning;
    
    public Anstalld(InfDB idb, String fornamn, String efternamn, String adress, String epost, String telefon, String anstallningsdatum, String losenord, int avdelning)
    {
        this.idb = idb;
        this.fornamn = fornamn;
        this.efternamn = efternamn;
        this.adress = adress;
        this.epost = epost;
        this.telefon = telefon;
        this.anstallningsdatum = anstallningsdatum;
        this.losenord = losenord;
        this.avdelning = avdelning;
        
        try
        {
            String sqlfråga = "INSERT INTO anstalld (fornamn, efternamn, adress, epost, telefon, anstallningsdatum, losenord, avdelning) VALUES ('" + fornamn + "', '" + efternamn + "', '" + adress + "', '" + epost + "', '" + telefon + "', '" + anstallningsdatum + "', '" + losenord + "', '" + avdelning + "')";
            idb.insert(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Användaren har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Användaren har inte sparats i databasen. \n" + e.getMessage()); 

        }
    }
    /**
     * 
     * Nedan följer först get-metoder. 
     * 
     */
    
    /**
     * Metod för att hämta förnamn
     * @return 
     */
    public String getFornamn()
    {
        return fornamn;
    }

    /**
     * Metod för att hämta efternamn
     * @return
     */
    public String getEfternamn()
    {
        return efternamn;
    }
    /**
     * Metod för att hämta adress
     * @return 
     */
    public String getAdress()
    {
        return adress;
    }
    /**
     * Metod för att hämta epost för användaren
     * @return 
     */
    public String getEpost()
    {
        return epost;
    }
    /**
     * Metod för att hämta telefonnummer
     * @return 
     */
    public String getTelefon()
    {
        return telefon;
    }
    /**
     * Metod för att hämta anställningsdatum
     * @return 
     */
    public String getAnstallningsdatum()
    {
        return anstallningsdatum;
    }
    /**
     * Metod för att hämta lösenord
     * @return 
     */
    public String getLosenord()
    {
        return losenord;
    }
    /**
     * Metod för att hämta anställnings-id
     * @return 
     */
    public int getAid()
    {
        return aid;
    }
    /**
     * Metod för att hämta avdelning för den anställde
     * @return 
     */
    public int getAvdelning()
    {
        return avdelning;
    }
    
    public ArrayList<HashMap<String, String>> allaAnstallda()
    {
        ArrayList<HashMap<String, String>> allaAnstallda = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM anstalld";
            allaAnstallda = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta städer.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta städer. \n" + e.getMessage());
            allaAnstallda = null;
        }
        return allaAnstallda;
    }
    
    public HashMap<String, String> getEnAnstalld()
    {
        HashMap<String, String> enAnstalld = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM anstalld WHERE aid = '" + aid + "'";
            enAnstalld = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta stad.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta stad. \n" + e.getMessage());
            enAnstalld = null;
        }
        return enAnstalld;
    }
    
    /**
     * 
     * Nedan följer Set-metoder.
     * 
     */
    
    /**
     * Metod för att uppdatera förnamnet på en Anställd
     * @param fornamn 
     */
    public void setFornamn(String fornamn)
    {
        this.fornamn = fornamn;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET fornamn = '" + fornamn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param efternamn 
     */
    public void setEfternamn(String efternamn)
    {
        this.efternamn = efternamn;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET efternamn = '" + efternamn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param adress 
     */
    public void setAdress(String adress)
    {
        this.adress = adress;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET adress = '" + adress + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }

    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param epost 
     */
    public void setEpost(String epost)
    {
        this.epost = epost;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET epost = '" + epost + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }

    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param telefon 
     */
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET telefon = '" + telefon + "'";
            idb.update(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param anstallningsdatum 
     */
    public void setAnstallningsdatum(String anstallningsdatum)
    {
        this.anstallningsdatum = anstallningsdatum;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET anstallningsdatum = '" + anstallningsdatum + "'";
            idb.update(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param losenord
     */
    public void setLosenord(String losenord)
    {
        this.losenord = losenord;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET losenord = '" + losenord + "'";
            idb.update(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    /**
     * Metod för att uppdatera efternamnet på en anställd.
     * @param avdelning
     */
    public void setAvdelning(int avdelning)
    {
        this.avdelning = avdelning;
        try
        {
            String sqlfråga = "UPDATE anstalld WHERE aid = " + aid + " SET avdelning = '" + avdelning + "'";
            idb.update(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Anställd har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Anställd har inte uppdaterats. \n" + e.getMessage());
        }
    }
}
