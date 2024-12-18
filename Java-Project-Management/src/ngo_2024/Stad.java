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
 * @author Andreas Galistel
 */
public class Stad {
    
    private InfDB idb;
    private int sid;
    private String namn;
    private String land;
    
    public Stad(String namn, String land)
    {
        this.namn = namn;
        this.land = land;
        try
        {
            String sqlfråga = "INSERT INTO stad (namn, land) values ('" + namn + "', '" + land + "')";
            idb.insert(sqlfråga);
        }   
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage()); 
        }
    }
    
    public String getNamn()
    {
        return namn;
    }
    
    public String getLand()
    {
        return land;
    }
    
    public int getSid()
    {
        return sid;
    }

    public void setNamn(String namn)
    {
        this.namn = namn;
        try
        {
        String sqlfråga = "UPDATE namn WHERE sid = " + sid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage());
        }
    }
    
    public void setLand(String land)
    {
        this.land = land;
        try
        {
            String sqlfråga = "UPDATE land WHERE sid = " + sid + " SET name = '" + land + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage());
        }

    }
    
    public ArrayList<HashMap<String, String>> getAllaStäder()
    {
        ArrayList<HashMap<String, String>> allaStäder = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM STAD";
            idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta städer.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta städer. \n" + e.getMessage());
            allaStäder = null;
        }
        return allaStäder;

    }
    
    public HashMap<String, String> getEnStad()
    {
        HashMap<String, String> enStad = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM STAD WHERE sid = '" + sid + "'";
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
}
