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
 * @author Andreas Galistel
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
   
    /**
     * Konstruktor som endast instantierar klass med en databasparameter. 
     * Gör det möjligt att använda sig av metoderna och prata med databasen utan att skapa något Anställd-objekt som innehåller någon data.
     * @param idb 
     */
        
    public Anstalld(InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * Konstruktor som skapar ett Anställd-objekt och sätter in det i databasen.
     * @param idb
     * @param fornamn
     * @param efternamn
     * @param adress
     * @param epost
     * @param telefon
     * @param anstallningsdatum
     * @param losenord
     * @param avdelning 
     */
    
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
    
    /**
     * Metod för att hämta ut alla Anställd(a).
     * @return 
     */
    
    public ArrayList<HashMap<String, String>> getAllaAnstallda()
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
    
    /**
     * Metod för att hämta ut en Anställd via namn.
     * @param namn
     * @return 
     */
    
    public HashMap<String, String> getEnAnstalldViaNamn(String namn)
    {
        HashMap<String, String> enAnstalld = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM anstalld WHERE namn = '" + namn + "'";
            enAnstalld = idb.fetchRow(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta användare.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta användare. \n" + e.getMessage());
            enAnstalld = null;
        }
        return enAnstalld;
    }
    
    /**
     * Metod för att hämta ut en Anställd via aid.
     * @param aid
     * @return 
     */
    
    public HashMap<String, String> getEnAnstalldViaAid(int aid)
    {
        HashMap<String, String> enAnstalld = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM anstalld WHERE aid = '" + aid + "'";
            enAnstalld = idb.fetchRow(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta användare.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta användare. \n" + e.getMessage());
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
     * Metod för att spara en hel användare i databasen. 
     * @param fornamn
     * @param efternamn
     * @param adress
     * @param epost
     * @param telefon
     * @param anstallningsdatum
     * @param losenord
     * @param avdelning 
     */
    public void sparaAnvandare(String fornamn, String efternamn, String adress, String epost, String telefon, String anstallningsdatum, String losenord, int avdelning)
    {        
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
     * Metod för att uppdatera förnamnet på en Anställd
     * @param fornamn 
     */
    public void setFornamn(int aid, String fornamn)
    {
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
    public void setEfternamn(int aid, String efternamn)
    {
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
    public void setAdress(int aid, String adress)
    {
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
    public void setEpost(int aid, String epost)
    {
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
    public void setTelefon(int aid, String telefon)
    {
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
    public void setAnstallningsdatum(int aid, String anstallningsdatum)
    {
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
    public void setLosenord(int aid, String losenord)
    {
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
    public void setAvdelning(int aid, int avdelning)
    {
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
