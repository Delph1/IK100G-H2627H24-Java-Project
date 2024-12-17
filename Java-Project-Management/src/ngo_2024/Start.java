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
public class Start {
    
    private static InfDB idb;
    
    public static void main (String[] args){
        
        try{
            idb = new InfDB("ngo_2024", "3306", "dbAdmin2024", "dbAdmin2024PW");
            new Inloggning(idb).setVisible(true);
        }
        catch(InfException e){
            System.out.println("Databaskopplingen misslyckades");
            JOptionPane.showMessageDialog(null, "Databaskopplingen misslyckades. " + e.getMessage());
        }
        
    }
}
