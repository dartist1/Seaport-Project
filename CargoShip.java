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
public class CargoShip extends Ship{
    double cargoValue;
    double cargoVolume;
    double cargoWeight;
    
    public CargoShip(Scanner scan){
        super(scan);
        
        if(scan.hasNextDouble()){
            cargoWeight = scan.nextDouble();
        }
        if(scan.hasNextDouble()){
            cargoVolume = scan.nextDouble();
        }
        if(scan.hasNextDouble()){
            cargoValue = scan.nextDouble();
        }
    }
    @Override
    public String toString(){
        String str1 = "Cargo Ship: " + super.toString();
        return str1;
    }
}
