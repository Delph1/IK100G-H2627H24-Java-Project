/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

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
    private int pid;
    private String projektNamn;
    private String beskrivning;
    private String startDatum;
    private String slutDatum;
    private double kostnad;
    private String status;
    private String prioritet;
    private int projektChef; //OBS se konstuktor och metoder där chef ska ändra typ från bara int till typ Anställd/Handläggare
    private int land;
    
    public Projekt(InfDB idb, String projektNamn, String beskrivning, String startDatum, String slutDatum, double kostnad, String status, String prioritet, int projektChef, Land land) 
    {
        //OBS projektChef ska ändra typ från bara int till typ Anställd/Handläggare 
        this.idb = idb;
        this.projektNamn = projektNamn;
        this.beskrivning = beskrivning;
        this.startDatum = startDatum;
        this.slutDatum = slutDatum;
        this.kostnad = kostnad;
        this.status = status;
        this.prioritet = prioritet;
        this.projektChef = projektChef; //OBS ska ändra typ från bara int till typ Anställd/Handläggare 
        this.land = land.getLid();
        
        try {
            String sqlfråga = "INSERT INTO projekt (projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) values ('"
                    + projektNamn + "', '" + beskrivning + "', '" + startDatum + "', '" + slutDatum + "', '" + kostnad + "', '" + status
                    + "', '" + prioritet+ "', '" + projektChef+ "', '" + land.getLid() + "')";
            idb.insert(sqlfråga);
            
            String sqlPid = "select pid from projekt where projektnamn = '" + projektNamn + "'";
            String dbPid = idb.fetchSingle(sqlPid);
            this.pid = Integer.parseInt(dbPid);
        } catch (InfException e) {
            System.out.println("Databasen har inte uppdaterats.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @return pid
     */
    public int getPid()
    {
        return pid;
    }
    
    /**
     * 
     * @return projektNamn
     */
    public String getProjektNamn()
    {
        return projektNamn;
    }
    
    /**
     * 
     * @return beskrivning
     */
    public String getBeskrivning()
    {
        return beskrivning;
    }
    
    /**
     * Returnerar datum i formatet YYYY-MM-DD
     * @return startDatum 
     */
    public String getStartDatum()
    {
        return startDatum;
    }
    
    /**
     * Returnerar datum i formatet YYYY-MM-DD
     * @return slutDatum
     */
    public String getSlutDatum()
    {
        return slutDatum;
    }
    
    /**
     * 
     * @return kostnad
     */
    public double getKostnad()
    {
        return kostnad;
    }
    
    /**
     * 
     * @return status
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * 
     * @return prioritet
     */
    public String getPrioritet()
    {
        return prioritet;
    }
    
    /**
     * 
     * @return projektChef
     */
    public int getProjektChef()
    {
        return projektChef;
    }
    
    /**
     * 
     * @return land id
     */
    public int getLand()
    {
        return land;
    }
    
    public HashMap<String,String> getEttProjekt(int pid)
    {
        HashMap<String, String> ettProjekt = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt WHERE pid = '" + pid + "'";
            ettProjekt = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta projekt. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt.");
            ettProjekt = null;
        }
        return ettProjekt;
    }
    
    /**
     * 
     * @param projektNamn 
     */
    public void setProjektNamn(String projektNamn)
    {
        this.projektNamn = projektNamn;
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET projektnamn = '" + projektNamn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }        
    }
    
    /**
     * 
     * @param beskrivning 
     */
    public void setBeskrivning(String beskrivning)
    {
        this.beskrivning = beskrivning;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET beskrivning = '" + beskrivning + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Datum i formatet YYYY-MM-DD, använd gärna med Validering.datumKontroll() för textfält
     * @param startDatum 
     */
    public void setStartDatum(String startDatum)
    {
        this.startDatum = startDatum;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET startdatum = '" + startDatum + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Datum i formatet YYYY-MM-DD, använd gärna med Validering.datumKontroll() för textfält
     * @param slutDatum 
     */
    public void setSlutDatum(String slutDatum)
    {
        this.slutDatum = slutDatum;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET slutdatum = '" + slutDatum + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @param kostnad 
     */
    public void setKostnad(double kostnad)
    {
        this.kostnad = kostnad;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET kostnad = '" + kostnad + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @param status 
     */
    public void setStatus(String status)
    {
        this.status = status;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET status = '" + status + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @param prioritet 
     */
    public void setPrioritet(String prioritet)
    {
        this.prioritet = prioritet;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET prioritet = '" + prioritet + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @param projektChef 
     */
    public void setProjektChef(int projektChef)
    {
        this.projektChef = projektChef;
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET projektchef = '" + projektChef + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * 
     * @param land 
     */
    public void setLand(Land land)
    {
        this.land = land.getLid();
        
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET land = '" + land.getLid() + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
}
