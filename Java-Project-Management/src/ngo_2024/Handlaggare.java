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
 * @author andre
 */
public class Handlaggare extends Anstalld {
    
    private InfDB idb;
    private String ansvarighetsomraden;
    private int mentor;
    private int aid;
    
    public Handlaggare (InfDB idb, int aid, String ansvarighetsomraden)
    {
        this.idb = idb;
        this.aid = aid;
        this.ansvarighetsomraden = ansvarighetsomraden;
        
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
}