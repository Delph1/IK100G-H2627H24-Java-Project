
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
    private int pid;
    private String projektNamn;
    private String beskrivning;
    private String startDatum;
    private String slutDatum;
    private double kostnad;
    private String status;
    private String prioritet;
    private int projektChef;
    private int land;
    
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
     * Konstruktor för instansiering med alla fält ifyllda
     * 
     * @param idb
     * @param projektNamn
     * @param beskrivning
     * @param startDatum
     * @param slutDatum
     * @param kostnad
     * @param status
     * @param prioritet
     * @param projektChef
     * @param land 
     */
    public Projekt(InfDB idb, String projektNamn, String beskrivning, String startDatum, String slutDatum, double kostnad, String status, String prioritet, int projektChef, int land) 
    { 
        this.idb = idb;
        this.projektNamn = projektNamn;
        this.beskrivning = beskrivning;
        this.startDatum = startDatum;
        this.slutDatum = slutDatum;
        this.kostnad = kostnad;
        this.status = status;
        this.prioritet = prioritet;
        this.projektChef = projektChef; //Just nu ingen kontroll/validering om projektChef är handläggare
        this.land = land;
        
        try {
            String sqlfråga = "INSERT INTO projekt (projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) values ('"
                    + projektNamn + "', '" + beskrivning + "', '" + startDatum + "', '" + slutDatum + "', '" + kostnad + "', '" + status
                    + "', '" + prioritet+ "', " + projektChef + ", " + land + ")";
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
     * Returnmetod för instansierat objekt, ej kopplat mot databasen
     * @return pid
     */
    public int getPid()
    {
        return pid;
    }
    
    /**
     * 
     * @param pid
     * @return projektNamn
     */
    public String getProjektNamn(int pid)
    {
        if (projektNamn == null) {
            try {
                String sqlFråga = "SELECT projektnamn FROM projekt WHERE pid = " + pid;
                String dbProjektNamn = idb.fetchSingle(sqlFråga);
                return dbProjektNamn;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return projektNamn;
    }
    
    /**
     * 
     * @param pid
     * @return beskrivning
     */
    public String getBeskrivning(int pid)
    {
        if (beskrivning == null) {
            try {
                String sqlFråga = "SELECT beskrivning FROM projekt WHERE pid = " + pid;
                String dbBeskrivning = idb.fetchSingle(sqlFråga);
                return dbBeskrivning;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return beskrivning;
    }
    
    /**
     * Returnerar datum i formatet YYYY-MM-DD
     * @param pid
     * @return startDatum 
     */
    public String getStartDatum(int pid)
    {
        if (startDatum == null) {
            try {
                String sqlFråga = "SELECT startdatum FROM projekt WHERE pid = " + pid;
                String dbStartDatum = idb.fetchSingle(sqlFråga);
                return dbStartDatum;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return startDatum;
    }
    
    /**
     * Returnerar datum i formatet YYYY-MM-DD
     * @return slutDatum
     */
    public String getSlutDatum()
    {
        if (slutDatum == null) {
            try {
                String sqlFråga = "SELECT slutdatum FROM projekt WHERE pid = " + pid;
                String dbSlutDatum = idb.fetchSingle(sqlFråga);
                return dbSlutDatum;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return slutDatum;
    }
    
    /**
     * 
     * @param pid
     * @return kostnad
     */
    public double getKostnad(int pid)
    {
        if (kostnad == 0) {
            try {
                String sqlFråga = "SELECT kostnad FROM projekt WHERE pid = " + pid;
                double dbkostnad = Double.parseDouble(idb.fetchSingle(sqlFråga));
                return dbkostnad;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return kostnad;
    }
    public double getKostnadPerson(int aid){
        ArrayList<HashMap<String,String>> allaProjekt = getAllaProjektFranAid(aid);
        ArrayList<String> pidList = new ArrayList<>();
        double summa = 0;
        for (HashMap<String, String> rad : allaProjekt) {
            pidList.add(rad.get("pid"));
        }
        for (String ettProjekt : pidList) {
            summa += getKostnad(Integer.parseInt(ettProjekt));
        }
        return summa;
    }
            
    /**
     * 
     * @param pid
     * @return status
     */
    public String getStatus(int pid)
    {
        if (status == null) {
            try {
                String sqlFråga = "SELECT status FROM projekt WHERE pid = " + pid;
                String dbStatus = idb.fetchSingle(sqlFråga);
                return dbStatus;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return status;
    }
    
    /**
     * 
     * @param pid
     * @return prioritet
     */
    public String getPrioritet(int pid)
    {
        if (prioritet == null) {
            try {
                String sqlFråga = "SELECT prioritet FROM projekt WHERE pid = " + pid;
                String dbPrioritet = idb.fetchSingle(sqlFråga);
                return dbPrioritet;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return prioritet;
    }
    
    /**
     * 
     * @param pid
     * @return projektChef
     */
    public int getProjektChef(int pid)
    {
        if (projektChef == 0) {
            try {
                String sqlFråga = "SELECT projektchef FROM projekt WHERE pid = " + pid;
                int dbProjektChef = Integer.parseInt(idb.fetchSingle(sqlFråga));
                return dbProjektChef;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return projektChef;
    }
    
    /**
     * 
     * @return land id
     */
    public int getLand()
    {
        if (land == 0) {
            try {
                String sqlFråga = "SELECT land FROM projekt WHERE pid = " + pid;
                int dbLand = Integer.parseInt(idb.fetchSingle(sqlFråga));
                return dbLand;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta projekt från databasen.");
            }
        }
        return land;
    }
    
    /**
     * returnerar ett projekt
     * @param pid
     * @return ettProjekt
     */
    public HashMap<String,String> getEttProjekt(int pid)
    {
        HashMap<String, String> ettProjekt = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM projekt WHERE pid = " + pid;
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
     * Hämtar alla projekt i databasen
     * @return allaProjekt
     */
    public ArrayList<HashMap<String, String>> getAllaProjektFranAid(int aid)
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
    public ArrayList<HashMap<String, String>> getAllaProjektSomProjektChef(int aid)
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
    
    /**
     * Lägger till nytt projekt till databasen
     * @param projektNamn
     * @param beskrivning
     * @param startDatum
     * @param slutDatum
     * @param kostnad
     * @param status
     * @param prioritet
     * @param projektChef
     * @param land 
     */
    public void setNyttProjekt(String projektNamn, String beskrivning, String startDatum, String slutDatum, double kostnad, String status, String prioritet, int projektChef, int land)
    {
        try{
            String sqlfråga = "INSERT INTO projekt (projektnamn, beskrivning, startdatum, slutdatum, kostnad, status, prioritet, projektchef, land) values ('"
                    + projektNamn + "', '" + beskrivning + "', '" + startDatum + "', '" + slutDatum + "', '" + kostnad + "', '" + status
                    + "', '" + prioritet+ "', " + projektChef + ", " + land + ")";
            idb.insert(sqlfråga);
            JOptionPane.showMessageDialog(null, "Nytt projekt tillagt");
        }
        catch (InfException e) {
            System.out.println("Kunde inte lägga till nytt projekt. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte lägga till nytt projekt. Kontrollera att all information är korrekt");
        }
    }
    
    /**
     * 
     * @param pid
     * @param projektNamn 
     */
    public void setProjektNamn(int pid, String projektNamn)
    {
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
     * @param pid
     * @param beskrivning 
     */
    public void setBeskrivning(int pid, String beskrivning)
    {
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
     * @param pid
     * @param startDatum 
     */
    public void setStartDatum(int pid, String startDatum)
    {
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
     * @param pid
     * @param slutDatum 
     */
    public void setSlutDatum(int pid, String slutDatum)
    {
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
     * @param pid
     * @param kostnad 
     */
    public void setKostnad(int pid, double kostnad)
    {
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET kostnad = " + kostnad;
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
     * @param pid
     * @param status 
     */
    public void setStatus(int pid, String status)
    {
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
     * @param pid
     * @param prioritet 
     */
    public void setPrioritet(int pid, String prioritet)
    {
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
     * @param pid
     * @param projektChef 
     */
    public void setProjektChef(int pid, int projektChef)
    {
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET projektchef = " + projektChef;
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
     * @param pid
     * @param land 
     */
    public void setLand(int pid, int land)
    {
        try
        {
            String sqlfråga = "UPDATE projekt WHERE pid = " + pid + " SET land = " + land;
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
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