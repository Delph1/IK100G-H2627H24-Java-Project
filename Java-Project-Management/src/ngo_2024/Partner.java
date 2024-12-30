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
    
    /**
     * Konstruktor endast med databaskoppling
     * @param idb 
     */
    public Partner(InfDB idb)
    {
        this.idb = idb;
    }

    public Partner(InfDB idb, String namn, String kontaktPerson, String kontaktEpost, String telefon, String adress, String branch, int stad) {
        
        
        this.idb = idb;
        this.namn = namn;
        this.kontaktPerson = kontaktPerson;
        this.kontaktEpost = kontaktEpost; 
        this.telefon = telefon; 
        this.adress = adress;
        this.branch = branch;
        this.stad = stad; 

        try {
            String sqlfråga = "INSERT INTO partner (namn, kontaktperson, kontaktepost, telefon, adress, branch, stad) values ('"
                    + namn + "', '" + kontaktPerson + "', '" + kontaktEpost + "', '" + telefon + "', '" + adress + "', '" + branch
                    + "', " + stad + ")";

            idb.insert(sqlfråga);
            String sqlPid = "select pid from partner where namn = '" + namn + "' and stad = " + stad;   //autoskapar pid, hämtar med namn och stad, Ask nämnde en partner kan finnas i flera städer
            String dbPid = idb.fetchSingle(sqlPid);
            this.pid = Integer.parseInt(dbPid);
        } catch (InfException e) {
            System.out.println("Databasen har inte uppdaterats.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /*
    public int getPid()
    {
        return pid;
    }   */
    
    /**
     * 
     * @param pid
     * @return namn på Partner 
     */
    public String getNamn(int pid)
    {
        if (namn == null) {
            try {
                String sqlFråga = "SELECT namn FROM partner WHERE pid = " + pid;
                String dbNamn = idb.fetchSingle(sqlFråga);
                return dbNamn;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return namn;
    }
    
    /**
     * 
     * @param pid
     * @return branch för Partner
     */
    public String getBranch(int pid)
    {
        if (branch == null) {
            try {
                String sqlFråga = "SELECT branch FROM partner WHERE pid = " + pid;
                String dbBranch = idb.fetchSingle(sqlFråga);
                return dbBranch;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return branch;
    }
    
    /**
     * 
     * @param pid
     * @return kontaktpersonens namn hos Partner
     */
    public String getKontaktPerson(int pid)
    {
        if (kontaktPerson == null) {
            try {
                String sqlFråga = "SELECT kontaktperson FROM partner WHERE pid = " + pid;
                String dbKontaktPerson = idb.fetchSingle(sqlFråga);
                return dbKontaktPerson;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return kontaktPerson;
    }
    
    /**
     * 
     * @param pid
     * @return kontaktpersonens epost hos Partner
     */
    public String getKontaktEpost(int pid)
    {
        if (kontaktEpost == null) {
            try {
                String sqlFråga = "SELECT kontaktepost FROM partner WHERE pid = " + pid;
                String dbKontaktEpost = idb.fetchSingle(sqlFråga);
                return dbKontaktEpost;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return kontaktEpost;
    }
    
    /**
     * 
     * @param pid
     * @return telefonnummer till Partner
     */
    public String getTelefon(int pid)
    {
        if (telefon == null) {
            try {
                String sqlFråga = "SELECT telefon FROM partner WHERE pid = " + pid;
                String dbKontaktPerson = idb.fetchSingle(sqlFråga);
                return dbKontaktPerson;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return telefon;
    }
    
    /**
     * 
     * @param pid
     * @return adress till Partner
     */
    public String getAdress(int pid)
    {
        if (adress == null) {
            try {
                String sqlFråga = "SELECT adress FROM partner WHERE pid = " + pid;
                String dbAdress = idb.fetchSingle(sqlFråga);
                return dbAdress;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return adress;
    }
    
    /**
     * 
     * @param pid
     * @return sid till Stad när Partner huserar
     */
    public int getStad(int pid)
    {
        if (stad == 0) {
            try {
                String sqlFråga = "SELECT stad FROM partner WHERE pid = " + pid;
                int dbStad = Integer.parseInt(idb.fetchSingle(sqlFråga));
                return dbStad;
            }
            catch (InfException e) {
                System.out.println("Kunde inte hämta partner från databasen" + e);
                JOptionPane.showMessageDialog(null, "Kunde inte hämta partner från databasen.");
            }
        }
        return stad;
    }
    
    
    public HashMap<String,String> getEnPartner(int pid)
    {
        HashMap<String, String> enPartner = new HashMap<>();
        try
        {
            String sqlfråga = "SELECT * FROM partner WHERE pid = " + pid;
            enPartner = idb.fetchRow(sqlfråga); 
        }
        catch(InfException e)
        {
            System.out.println("Kunde inte hämta partner. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte hämta partner.");
            enPartner = null;
        }
        return enPartner;
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
     * Lägger till ny partner i databasen
     * @param namn
     * @param kontaktPerson
     * @param kontaktEpost
     * @param telefon
     * @param adress
     * @param branch
     * @param stad 
     */
    public void setNyPartner(String namn, String kontaktPerson, String kontaktEpost, String telefon, String adress, String branch, int stad) 
    {
        try {
            String sqlfråga = "INSERT INTO partner (namn, kontaktperson, kontaktepost, telefon, adress, branch, stad) values ('"
                    + namn + "', '" + kontaktPerson + "', '" + kontaktEpost + "', '" + telefon + "', '" + adress + "', '" + branch
                    + "', " + stad + ")";

            idb.insert(sqlfråga);
            JOptionPane.showMessageDialog(null, "Ny partner har lagts till");
        } catch (InfException e) {
            System.out.println("Databasen har inte uppdaterats.\n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Databasen har inte uppdaterats.");
        }
    }
    
    /**
     * Ändrar eller lägger till namn på Partner
     * @param namn 
     */
    public void setNamn(String namn)
    {
        //this.namn = namn;
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
        //this.kontaktPerson = kontaktPerson;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET kontaktperson = '" + kontaktPerson + "'";
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
        //this.kontaktEpost = kontaktEpost;
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET kontaktepost = '" + kontaktEpost + "'";
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
        //this.telefon = telefon;
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
        //this.adress = adress;
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
        //this.branch = branch;
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
    public void setStad (int stad)
    {
        //this.stad = stad.getSid();
        try {
        String sqlfråga = "UPDATE partner WHERE pid = " + pid + " SET stad = " + stad;
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
            String sqlFråga = "delete from partner where pid = " + pid;
            idb.delete(sqlFråga);
            JOptionPane.showMessageDialog(null, "Partner har tagits bort.");
        }
        catch (InfException e) 
        {
            System.out.println("Databasen har inte uppdaterats. \n" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Partner har inte tagits bort.");
        }
    }
}
