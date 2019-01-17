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
public class Person extends Thing{
    String skill;
    
    public Person(Scanner scan){
        super(scan);
        if(scan.hasNext()){
            skill = scan.next();
        }
    }
    
    @Override
    public String toString(){
        String str1 = "Person: " + super.toString() + " " + skill;
        return str1;
    }
    
}
