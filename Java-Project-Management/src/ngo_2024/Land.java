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
 * @author Märta Sjöblom
 */
public class Land {
    
    private InfDB idb;
    private String namn;
    private String språk;
    private double valuta;
    private String tidszon;
    private String politiskStruktur;
    private String ekonomi;
    private int lid;
    
    public Land(InfDB idb, String namn, String språk, double valuta, String tidszon, String politiskStruktur, String ekonomi)
    {
        this.idb = idb;
        this.namn = namn;
        this.språk = språk;
        this.valuta = valuta;
        this.tidszon = tidszon;
        this.politiskStruktur = politiskStruktur;
        this.ekonomi = ekonomi;
        
        try {
            String sqlfråga = "INSERT INTO land (namn, språk, valuta, tidzon, politiskStruktur, ekonomi) values ('"
                    + namn + "', '" + språk + "', '" + valuta + "', '" + tidszon + "', '" + politiskStruktur + "', '" + ekonomi+ "')";

            idb.insert(sqlfråga);
            String sqlLid = "select lid from land where namn = '" + namn + "'";   //autoskapar lid, hämtar med namn
            String dbLid = idb.fetchSingle(sqlLid);
            this.lid = Integer.parseInt(dbLid);
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Returnerar information om id för ett land
     * @return lid
     */
    public int getLid()
    {
        return lid;
    }
    
    /**
     * Returnerar information om namn för ett land
     * @return namn
     */
    public String getNamn()
    {
        return namn;
    }
    
    /**
     * Returnerar information om språk för ett land
     * @return språk
     */
    public String getSpråk()
    {
        return språk;
    }
    
    /**
     * Returnerar information om "valuta" för ett land
     * @return valuta
     */
    public double getValuta()
    {
        return valuta;
    }
    
    /**
     * Returnerar information om tidszon för ett land
     * @return tidszon
     */
    public String getTidszon()
    {
        return tidszon;
    }
    
    /**
     * Returnerar information om politisk struktur för ett land
     * @return politiskStruktur
     */
    public String getPolitiskStruktur()
    {
        return politiskStruktur;
    }
    
    /**
     * Returnerar information om ekonomi för ett land
     * @return ekonomi
     */
    public String getEkonomi()
    {
        return ekonomi;
    }
    
    /**
     * Lägger till eller ändrar information om namn för ett land
     * @param namn (String)
     */
    public void setNamn(String namn)
    {
        this.namn = namn;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Lägger till eller ändrar information om språk för ett land
     * @param språk (String)
     */
    public void setSpråk(String språk)
    {
        this.språk = språk;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET sprak = '" + språk + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Lägger till eller ändrar information om "valuta" för ett land
     * @param valuta (double)
     */
    public void setValuta(double valuta)
        {
        this.valuta = valuta;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET valuta = '" + valuta + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Lägger till eller ändrar information om tidszon för ett land
     * @param tidszon (String)
     */
    public void setTidzon(String tidszon)
    {
        this.tidszon = tidszon;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET tidszon = '" + tidszon + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Lägger till eller ändrar information om politisk situation för ett land
     * @param politiskStruktur (String)
     */
    public void setPolitiskStruktur(String politiskStruktur)
    {
        this.politiskStruktur = politiskStruktur;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET politisk_struktur = '" + politiskStruktur + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Lägger till eller ändrar information om ekonomi för ett land
     * @param ekonomi (String)
     */
    public void setEkonomi(String ekonomi)
    {
        this.ekonomi = ekonomi;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET ekonomi = '" + ekonomi + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
}
