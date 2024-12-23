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
 * Klass för Handläggare, en subklass av Anställd.
 * @author Andreas Galistel
 */
public class Handlaggare {
    
    private InfDB idb;
    private String ansvarighetsomraden;
    private int mentor;
    private int aid;
    
    /**
     * Konstruktor för att skapa ett handläggarobjekt
     * @param idb
     * @param aid
     * @param ansvarighetsomraden 
     */
    public Handlaggare (InfDB idb, int aid, String ansvarighetsomraden)
    {
        this.idb = idb;
        this.aid = aid;
        this.ansvarighetsomraden = ansvarighetsomraden;
    }
    
    /**
     * Konstruktor för att starta en instans av Handläggare utan att det hanterar någon data i ett objekt
     * @param idb 
     */
    public Handlaggare (InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * 
     * Nedan följer get-metoder
     * 
     */
    
    
    /**
     * Metod som returnerar ansvarighetsområden för en handläggare.
     * @return 
     */
    public String getAnsvarighetsomraden()
    {
        return ansvarighetsomraden;
    }
    
    /**
     * Metod för att hämta ut alla projekt som en handläggare basar över.
     * @return 
     */
    public ArrayList<HashMap<String,String>> allaProjektForHandlaggare()
    {
        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt WHERE projektchef = " + aid;
            allaProjekt = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt för handläggare.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt för handläggare. \n" + e.getMessage());
            allaProjekt = null;
        }
        return allaProjekt;
    }
    
    /**
     * 
     * Nedan följer set-metoder för Handläggare.
     * 
     */
    
    /**
     * Tilldela en mentor till handläggare
     * @param mentor 
     */
    public void setMentor(int mentor)
    {
        this.mentor = mentor;
        
        try
        {
            String sqlfråga = "UPDATE handlaggare SET mentor = " + mentor + " WHERE aid = " + aid; 
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte tilldela mentor för handläggare.");
            JOptionPane.showMessageDialog(null, "Kunde inte tilldela mentor för handläggare. \n" + e.getMessage());
        }
    }
    
    /**
     * Spara Handläggare i databasen.
     * @param aid
     * @param ansvarighetsomraden 
     */
    public void sparaHandlaggare(int aid, String ansvarighetsomraden)
    {
        try
        {
            String sqlfråga = "INSERT INTO Handlaggare (aid, ansvarighetsomraden) values ('" + aid + "', '" + ansvarighetsomraden + "')";
            idb.insert(sqlfråga);
        }   
        catch(InfException e)
        {
            System.out.println("Handläggaren har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Handläggaren har inte sparats i databasen. \n" + e.getMessage()); 
        }
    }
}
