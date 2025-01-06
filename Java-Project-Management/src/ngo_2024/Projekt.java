
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Märta Sjöblom
 */
public class Projekt {
    
    private InfDB idb;

    
    /**
     * Konstruktor som endast instansierar objekt med databasparameter
     * för användning med select-frågor
     * @param idb 
     */
    public Projekt(InfDB idb)
    {
        this.idb = idb;
    }
    /**
     * Hämtar alla projekt i databasen
     * @return allaProjekt
     */
    public ArrayList<HashMap<String, String>> getAllaProjektFranAid(String aid)
    {
        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt where pid in (select pid from ans_proj where aid =" + aid + ");";
            allaProjekt = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }
        return allaProjekt;
    }
    /**
     * Hämtar alla projekt i databasen
     * @return allaProjekt
     */
    public ArrayList<HashMap<String, String>> getAllaProjektSomProjektChef(String aid)
    {
        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt where projektchef =" + aid;
            allaProjekt = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }
        return allaProjekt;
    }
    /**
     * Hämtar alla projekt i databasen
     * @return allaProjekt
     */
    public ArrayList<HashMap<String, String>> getAllaProjekt()
    {
        ArrayList<HashMap<String, String>> allaProjekt = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt";
            allaProjekt = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
        }
        return allaProjekt;
    }
    
    public void taBortProjekt(int pid)
    {
        try {
            String sqlFråga = "delete from projekt where pid = " + pid;
            idb.delete(sqlFråga);
            JOptionPane.showMessageDialog(null, "Projekt har tagits bort.");
        }
        catch (InfException e) 
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Projekt har inte tagits bort.");
        }
    }
}