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


public class SeaPort extends Thing{
    ArrayList<Dock> docks = new ArrayList<>();
    ArrayList<Ship> queue = new ArrayList<>();
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Person> person = new ArrayList<>();
    
    public SeaPort(Scanner scan){
        super(scan);
    }
    @Override
    public String toString(){
        String str1 = "SeaPort " + super.toString() + '\n';
        str1 = docks.stream().map((dock) -> "\n" + dock).reduce(str1, String::concat);
        str1 += "\n\n List of ships in queue.";
        str1 = queue.stream().map((ship) -> "\n > " + ship).reduce(str1, String::concat);
        str1 += "\n\nList of all ships: ";
        str1 = ships.stream().map((ship) -> "\n > " + ship).reduce(str1, String::concat);
        str1 += "\n\nList of all person: ";
        str1 = person.stream().map((pers) -> "\n > " + pers).reduce(str1, String::concat);
        return str1;
    }
    
}
