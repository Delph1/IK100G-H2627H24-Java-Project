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
    
    public Admin(InfDB idb, int aid, int behorighetsniva)
    {
        this.idb = idb;
        this.aid = aid;
        this.behorighetsniva = behorighetsniva;
        
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
    
    /**
     * 
     * Nedan följer get-metoder för Admin
     * 
     */
    
    /**
     * Metod för att hämta ut behorighetsnivå för Admin.
     * @return 
     */
    public int getBehorighetsniva()
    {
        return behorighetsniva;
    }
}
