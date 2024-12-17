/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo_2024;

import java.util.HashMap;

/**
 *
 * @author Andreas Galistel
 */
public class Stad {
    
    private int sid;
    private String namn;
    private String land;
    
    public Stad(String namn, String land)
    {
        this.namn = namn;
        this.land = land;
        //anrop till metod i SQL-klass som sparar. Frågan ska flyttas till nya metoden.
        String sqlfråga = "INSERT INTO stad (namn, land) values ('" + namn + "', '" + land + "')";
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
        String sqlfråga = "UPDATE namn WHERE sid = " + sid + " SET name = '" + namn "'";
        //anrop till metod i SQL-klass som sparar. Frågan ska flyttas till nya metoden.
    }
   
    public void setLand(String land)
    {
        this.land = land;
        String sqlfråga = "UPDATE land WHERE sid = " + sid + " SET name = '" + land "'";
        //anrop till metod i SQL-klass som sparar. Frågan ska flyttas till nya metoden.
    }
    
    public HashMap getAllaStäder()
    {
        String sqlfråga = "SELECT * FROM STAD";
        HashMap allaStäder = null; //anrop till SQL-metod som hämtar alla städer. Frågan ska flyttas till nya metoden.
        return allaStäder;
    }
    
    public HashMap getEnStad()
    {
        String sqlfråga = "SELECT * FROM STAD WHERE sid = '" + sid + "'";
        HashMap enStad = null; //anrop till SQL-metod som hämtar en stad. Frågan ska flyttas till nya metoden.
        return enStad;
    }
}
