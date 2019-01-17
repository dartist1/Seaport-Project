/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaportprogram;
import java.util.*;
/**
 *
 * @author Devon
 */
public class Dock extends Thing{
    Ship ship;
    
    public Dock(Scanner scan){
        super();
    }
    
    @Override
    public String toString(){
        String str1 = "Dock: " + super.toString();
        if(ship == null){
            return str1;
        }
        
        str1 += "\n " + ship;
        return str1;
    }
    
}
