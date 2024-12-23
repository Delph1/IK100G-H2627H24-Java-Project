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
    
    /**
     * konstuktor som endast instansierar med databaskoppling - för Selectfrågor
     * @param idb 
     */
    public Land(InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * Konstruktor som fyller alla fält med information
     * @param idb
     * @param namn
     * @param språk
     * @param valuta
     * @param tidszon
     * @param politiskStruktur
     * @param ekonomi 
     */
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
            String sqlfråga = "INSERT INTO land (namn, sprak, valuta, tidzon, politisk_struktur, ekonomi) values ('"
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
     * @param lid
     * @return namn
     */
    public String getNamn(int lid)
    {
        if (namn == null) {
            try {
                String sqlFråga = "SELECT namn FROM land WHERE lid = " + lid;
                String dbNamn = idb.fetchSingle(sqlFråga);
                return dbNamn;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return namn;
    }
    
    /**
     * Returnerar information om språk för ett land
     * @param lid
     * @return språk
     */
    public String getSpråk(int lid)
    {
        if (språk == null) {
            try {
                String sqlFråga = "SELECT sprak FROM land WHERE lid = " + lid;
                String dbSpråk = idb.fetchSingle(sqlFråga);
                return dbSpråk;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return språk;
    }
    
    /**
     * Returnerar information om "valuta" för ett land
     * @param lid
     * @return valuta
     */
    public double getValuta(int lid)
    {
        if (valuta == 0) {
            try {
                String sqlFråga = "SELECT valuta FROM land WHERE lid = " + lid;
                double dbValuta = Double.parseDouble(idb.fetchSingle(sqlFråga));
                return dbValuta;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return valuta;
    }
    
    /**
     * Returnerar information om tidszon för ett land
     * @param lid
     * @return tidszon
     */
    public String getTidszon(int lid)
    {
        if (tidszon == null) {
            try {
                String sqlFråga = "SELECT tidszon FROM land WHERE lid = " + lid;
                String dbTidszon = idb.fetchSingle(sqlFråga);
                return dbTidszon;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return tidszon;
    }
    
    /**
     * Returnerar information om politisk struktur för ett land
     * @param lid
     * @return politiskStruktur
     */
    public String getPolitiskStruktur(int lid)
    {
        if (politiskStruktur == null) {
            try {
                String sqlFråga = "SELECT politisk_struktur FROM land WHERE lid = " + lid;
                String dbPolitiskStruktur = idb.fetchSingle(sqlFråga);
                return dbPolitiskStruktur;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return politiskStruktur;
    }
    
    /**
     * Returnerar information om ekonomi för ett land
     * @param lid
     * @return ekonomi
     */
    public String getEkonomi(int lid)
    {
        if (ekonomi == null) {
            try {
                String sqlFråga = "SELECT ekonomi FROM land WHERE lid = " + lid;
                String dbEkonomi = idb.fetchSingle(sqlFråga);
                return dbEkonomi;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta land från databasen.");
            }
        }
        return ekonomi;
    }
    
    /**
     * Returnerar all information om ett land i en HashMap
     * @param lid
     * @return 
     */
    public HashMap<String,String> getEttLand(int lid)
    {
        HashMap<String, String> ettLand = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM land WHERE lid = " + lid;
            ettLand = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta land. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta land.");
            ettLand = null;
        }
        return ettLand;
    }
    
    /**
     * Alla länder genom en ArraList av HashMap av String, String 
     * @return 
     */
    public ArrayList<HashMap<String, String>> getAllaLänder()
    {
        ArrayList<HashMap<String, String>> allaLänder = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM land";
            allaLänder = idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta länder.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta länder.");
            allaLänder = null;
        }
        return allaLänder;
    }
            
    public void setNyttLand(String namn, String språk, double valuta, String tidszon, String politiskStruktur, String ekonomi)
    {
        try {
            String sqlfråga = "INSERT INTO land (namn, sprak, valuta, tidzon, politisk_struktur, ekonomi) values ('"
                    + namn + "', '" + språk + "', " + valuta + ", '" + tidszon + "', '" + politiskStruktur + "', '" + ekonomi+ "')";

            idb.insert(sqlfråga);
            JOptionPane.showMessageDialog(null, "Nytt land har lagts till!");
        } catch (InfException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }

    
    /**
     * Lägger till eller ändrar information om namn för ett land
     * @param lid
     * @param namn (String)
     */
    public void setNamn(int lid, String namn)
    {
        //this.namn = namn;
        
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
     * @param lid
     * @param språk (String)
     */
    public void setSpråk(int lid, String språk)
    {
        //this.språk = språk;
        
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
     * @param lid
     * @param valuta (double)
     */
    public void setValuta(int lid, double valuta)
        {
        //this.valuta = valuta;
        
        try
        {
        String sqlfråga = "UPDATE land WHERE lid = " + lid + " SET valuta = " + valuta;
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
     * @param lid
     * @param tidszon (String)
     */
    public void setTidzon(int lid, String tidszon)
    {
        //this.tidszon = tidszon;
        
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
     * @param lid
     * @param politiskStruktur (String)
     */
    public void setPolitiskStruktur(int lid, String politiskStruktur)
    {
        //this.politiskStruktur = politiskStruktur;
        
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
     * @param lid
     * @param ekonomi (String)
     */
    public void setEkonomi(int lid, String ekonomi)
    {
        //this.ekonomi = ekonomi;
        
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
