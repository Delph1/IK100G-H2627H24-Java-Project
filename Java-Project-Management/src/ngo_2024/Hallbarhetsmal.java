package ngo_2024;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Klass för att hantera hållbarhetsmål.
 * Innehåller metoder för att spara, uppdatera, ta bort och hämta hållbarhetsmål från databasen.
 * @author Claudia Kourieh
 */
public class Hallbarhetsmal {
    private InfDB idb; // Databasreferens för att kommunicera med databasen
    private String namn; // Hållbarhetsmålets namn
    private int malnummer; // Hållbarhetsmålets nummer
    private String beskrivning; // Hållbarhetsmålets beskrivning
    private String prioritet; // Hållbarhetsmålets prioritet
    private int hid; // Hållbarhetsmålets unika ID i databasen

    /**
     * Konstruktor för att instantiera klassen
     * @param idb
     */
    public Hallbarhetsmal(InfDB idb)
    {
        this.idb = idb;
    }
    
    /**
     * Konstruktor för att skapa ett hållbarhetsmål och spara det i databasen.
     * @param idb
     * @param namn
     * @param malnummer
     * @param beskrivning
     * @param prioritet
     * @param hid
     */
    public Hallbarhetsmal(InfDB idb, String namn, int malnummer, String beskrivning, String prioritet, int hid) {
        this.idb = idb;
        this.namn = namn;
        this.malnummer = malnummer;
        this.beskrivning = beskrivning;
        this.prioritet = prioritet;
        this.hid = hid;
        
        try {
            // SQL-fråga för att spara hållbarhetsmålet i databasen
            String sqlfråga = "INSERT INTO hallbarhetsmal (namn, malnummer, beskrivning, prioritet, hid) VALUES ('" 
                              + namn + "', " + malnummer + ", '" + beskrivning + "', '" + prioritet + "', " + hid + ")";
            idb.insert(sqlfråga); // Utför INSERT-åtgärden i databasen
        } catch (InfException e) {
            // Felhantering om något går fel vid sparande
            System.out.println("Hållbarhetsmål har inte sparats i databasen.");
            JOptionPane.showMessageDialog(null, "Hållbarhetsmål har inte sparats i databasen. \n" + e.getMessage());
        }
    }

    // Getter-metoder för att hämta värden på de privata variablerna
    public String getNamn() {
        return namn;
    }

    public int getMalnummer() {
        return malnummer;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getPrioritet() {
        return prioritet;
    }

    public int getHid() {
        return hid;
    }
    
    /**
     * Hämtar alla hållbarhetsmål från databasen.
     * Retunerar lista av alla hållbarhetsmål.
     * @return 
     */
    public ArrayList<HashMap<String, String>> allaHallbarhetsmal() {
        ArrayList<HashMap<String, String>> allaHallbarhetsmal = new ArrayList<>();
        try {
            // SQL-fråga för att hämta alla hållbarhetsmål
            String sqlfråga = "SELECT * FROM hallbarhetsmal";
            allaHallbarhetsmal = idb.fetchRows(sqlfråga); // Hämtar alla rader från databasen
        } catch (InfException e) {
            // Felhantering om något går fel vid hämtning
            System.out.println("Kunde inte hämta hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta hållbarhetsmål. \n" + e.getMessage());
        }
        return allaHallbarhetsmal;
    }

    /**
     * Hämtar ett specifikt hållbarhetsmål från databasen baserat på ID.
     * Retunerar hållbarhetsmålet som en HashMap
     * @return 
     */
    public HashMap<String, String> getEttHallbarhetsmal() {
        HashMap<String, String> ettHallbarhetsmal = new HashMap<>();
        try {
            // SQL-fråga för att hämta ett hållbarhetsmål baserat på hid
            String sqlfråga = "SELECT * FROM hallbarhetsmal WHERE hid = " + hid;
            ettHallbarhetsmal = idb.fetchRow(sqlfråga); // Hämtar en rad från databasen
        } catch (InfException e) {
            // Felhantering om något går fel vid hämtning
            System.out.println("Kunde inte hämta hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte hämta hållbarhetsmål. \n" + e.getMessage());
        }
        return ettHallbarhetsmal;
    }
    
    /**
     * Uppdaterar ett hållbarhetsmål i databasen baserat på dess ID.
     * @param hid
     * @param nyttNamn
     * @param nyttMalnummer
     * @param nyBeskrivning
     * @param nyPrioritet
     */
    public void andraHallbarhetsmal(int hid, String nyttNamn, int nyttMalnummer, String nyBeskrivning, String nyPrioritet) {
        try {
            // SQL-fråga för att uppdatera hållbarhetsmålet i databasen
            String sqlfråga = "UPDATE hallbarhetsmal SET namn = '" + nyttNamn + "', malnummer = " + nyttMalnummer + 
                              ", beskrivning = '" + nyBeskrivning + "', prioritet = '" + nyPrioritet + 
                              "' WHERE hid = " + hid;
            idb.update(sqlfråga); // Utför UPDATE-åtgärden i databasen
            System.out.println("Hållbarhetsmål uppdaterat!");
        } catch (InfException e) {
            // Felhantering om något går fel vid uppdatering
            System.out.println("Kunde inte uppdatera hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte uppdatera hållbarhetsmål. \n" + e.getMessage());
        }
    }

    /**
     * Tar bort ett hållbarhetsmål från databasen baserat på dess ID.
     * Retunerar hållbarhetsmålets ID (hid)
     * @param hid
     */
    public void taBortHallbarhetsmal(int hid) {
        try {
            // SQL-fråga för att ta bort hållbarhetsmålet från databasen
            String sqlfråga = "DELETE FROM hallbarhetsmal WHERE hid = " + hid;
            idb.delete(sqlfråga); // Utför DELETE-åtgärden i databasen
            System.out.println("Hållbarhetsmål raderat!");
        } catch (InfException e) {
            // Felhantering om något går fel vid radering
            System.out.println("Kunde inte radera hållbarhetsmål.");
            JOptionPane.showMessageDialog(null, "Kunde inte radera hållbarhetsmål. \n" + e.getMessage());
        }
    }
}
