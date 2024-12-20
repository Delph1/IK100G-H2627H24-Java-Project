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
 * Klass som hanterar samarbetspartners (Partner)
 * @author Märta Sjöblom
 */
public class Partner {

    private InfDB idb;
    private int pid;
    private String namn;
    private String kontaktPerson;
    private String kontaktEpost;
    private String telefon;
    private String adress;
    private String branch;
    private int stad;

    public Partner(InfDB idb, String namn, String kontaktPerson, String kontaktEpost, String telefon, String adress, String branch, Stad stad) {
        
        //this.pid = löpnummer i sql? Se försök i try-catch nedanför
        this.idb = idb;
        this.namn = namn;
        this.kontaktPerson = kontaktPerson;
        this.kontaktEpost = kontaktEpost; //Validering epost?
        this.telefon = telefon; //Validering varchar20?
        this.adress = adress;
        this.branch = branch;
        this.stad = stad.getSid(); //Vettigt sätt att lösa detta på? eller ska ta in int sid direkt? känns inte användarvänligt?

        try {
            String sqlfråga = "INSERT INTO partner (namn, kontaktPerson, kontaktEpost, telefon, adress, branch, stad) values ('"
                    + namn + "', '" + kontaktPerson + "', '" + kontaktEpost + "', '" + telefon + "', '" + adress + "', '" + branch
                    + "', '" + stad.getSid() + "')";

            idb.insert(sqlfråga);
            String sqlPid = "select pid from partner where namn = '" + namn + "' and stad = '" + stad.getSid() + "'";   //autoskapar pid, hämtar med namn och stad, Ask nämnde en partner kan finnas i flera städer
            String dbPid = idb.fetchSingle(sqlPid);
            this.pid = Integer.parseInt(dbPid);
        } catch (InfException e) {
            System.out.println("Databasen har inte uppdaterats.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /* Alternativ konstruktor med mindre info. Behov eller bara bökigt?
    
    public Partner(InfDB idb, String namn, Stad stad)
    {
        this.idb = idb;
        this.namn = namn;
        this.stad = stad.getSid(); 
        
        try {
            String sqlfråga = "INSERT INTO partner (namn, stad) values ('"
                    + namn + "', '" + stad.getSid() + "')";
            idb.insert(sqlfråga);
            String sqlPid = "select pid from partner where namn = '" + namn + "' and stad = '" + stad.getSid() + "'";   //autoskapar pid, hämtar med namn och stad, Ask nämnde en partner kan finnas i flera städer
            String dbPid = idb.fetchSingle(sqlPid);
            this.pid = Integer.parseInt(dbPid);
        } catch (InfException e) {
            System.out.println("Databasen har inte uppdaterats.");
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats. \n" + e.getMessage());
        }
    }*/
    
    /**
     * 
     * @return pid på Partner
     */
    public int getPid()
    {
        return pid;
    }   
    /**
     * 
     * @return namn på Partner 
     */
    public String getNamn()
    {
        return namn;
    }
    
    /**
     * 
     * @return branch för Partner
     */
    public String getBranch()
    {
        return branch;
    }
    
    /**
     * 
     * @return kontaktpersonens namn hos Partner
     */
    public String getKontaktPerson()
    {
        return kontaktPerson;
    }
    
    /**
     * 
     * @return kontaktpersonens epost hos Partner
     */
    public String getKontaktEpost()
    {
        return kontaktEpost;
    }
    
    /**
     * 
     * @return telefonnummer till Partner
     */
    public String getTelefon()
    {
        return telefon;
    }
    
    /**
     * 
     * @return adress till Partner
     */
    public String getAdress()
    {
        return adress;
    }
    
    /**
     * 
     * @return sid till Stad när Partner huserar
     */
    public int getStad()
    {
        return stad;
    }
    
    /**
     * 
     * @return ArrayList med HashMap över alla partner
     */
    public ArrayList<HashMap<String, String>> getAllaPartner()
    {
        ArrayList<HashMap<String, String>> allaPartner = new ArrayList<>();
        try
        {
            String sqlfråga = "SELECT * FROM Partner";
            idb.fetchRows(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta partners. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta partners.");
            allaPartner = null;
        }
        return allaPartner;
    }
    
    /**
     * Ändrar eller lägger till namn på Partner
     * @param namn 
     */
    public void setNamn(String namn)
    {
        this.namn = namn;
        try
        {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET namn = '" + namn + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }        
    }
    
    /**
     * Ändrar eller lägger till kontaktperson hos Partner
     * @param kontaktPerson 
     */
    public void setKontaktPerson(String kontaktPerson)
    {
        this.kontaktPerson = kontaktPerson;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET kontaktPerson = '" + kontaktPerson + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }    
    }
    
    /**
     * Ändrar eller lägger till epost till kontakt hos Partner
     * @param kontaktEpost 
     */
    public void setKontaktEpost(String kontaktEpost)
    {
        this.kontaktEpost = kontaktEpost;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET kontaktEpost = '" + kontaktEpost + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }    
    }
    
    /**
     * Ändrar eller lägger till telefon till Partner
     * @param telefon 
     */
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET telefon = '" + telefon + "'";
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
     * @param adress till Partner
     */
    public void setAdress(String adress)
    {
        this.adress = adress;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET adress = '" + adress + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }    
    }
    
    public void setBranch(String branch)
    {
        this.branch = branch;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET branch = '" + branch + "'";
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
     * @param stad som Partner huserar i
     */
    public void setStad (Stad stad)
    {
        this.stad = stad.getSid();
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET stad = '" + stad + "'";
            idb.update(sqlfråga);
        }
        catch(InfException e)
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }    
    }
    
    /**
     * Tar bort all information om en partner.
     * @param pid på partner som ska tas bort
     */
    public void taBortPartner(int pid)
    {
        try {
            String sqlFråga = "delete from partner where pid = '" + pid + "'";
            idb.delete(sqlFråga);
        }
        catch (InfException e) 
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Partner har inte tagits bort.");
        }
    }
}
