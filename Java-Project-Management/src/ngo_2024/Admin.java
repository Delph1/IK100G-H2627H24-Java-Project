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
 * @author andre
 */
public class Admin {
    
    private InfDB idb;
    private int aid;
    private int behorighetsniva;
    
    public Admin(InfDB idb)
    {
        this.idb = idb;
    }
    
    
    public Admin(InfDB idb, int aid)
    {
        this.idb = idb;
        this.aid = aid;
        this.behorighetsniva = 1;
        
    }
    
    /**
     * 
     * Nedan följer get-metoder för Admin
     * 
     */
    
    /**
     * Metod för att hämta ut behorighetsnivå för Admin.
     * @return 
     */
    public int getBehorighetsniva(int aid)
    {
        try
        {
            String sqlfråga = "SELECT behorighetsniva from admin WHERE  aid = " + aid;
            behorighetsniva = Integer.parseInt(idb.fetchSingle(sqlfråga));
        }   
        catch(InfException e)
        {
            System.out.println("Admin har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Admin har inte sparats i databasen. \n" + e.getMessage()); 
        }
        return behorighetsniva;
    }
    
    /**
     * Spara en admin i databasen.
     * @param aid
     * @param behorighhtsniva 
     */
    public void setAdmin(int aid, int behorighhtsniva)
    {
        try
        {
            String sqlfråga = "INSERT INTO admin (aid, behorighetsniva) values ('" + aid + "', '" + behorighetsniva + "')";
            idb.insert(sqlfråga);
        }   
        catch(InfException e)
        {
            System.out.println("Admin har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Admin har inte sparats i databasen. \n" + e.getMessage()); 
        }
    }
    
}
