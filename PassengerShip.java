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
public class PassengerShip extends Ship{
    int numberOfOccupiedRooms;
    int numberOfPassengers;
    int numberOfRooms;
    
    public PassengerShip(Scanner scan){
        super(scan);
        if(scan.hasNextInt()){
            numberOfPassengers = scan.nextInt();
        }
        if(scan.hasNextInt()){
            numberOfRooms = scan.nextInt();
        }
        if(scan.hasNextInt()){
            numberOfOccupiedRooms = scan.nextInt();
        }
    }
    
    @Override
    public String toString(){
        String str1 = "Passenger Ship: " + super.toString();
        return str1;
    }
    
}
