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
public class Thing implements Comparable<Thing>{
    
    int index;
    String name;
    int parent;
    
    public Thing(){
        index = 0;
        name = "";
        parent = 0;
    }
    
    public Thing(Scanner scan){
        if(scan.hasNext()){
            name = scan.next();
        }
        if(scan.hasNextInt()){
            index = scan.nextInt();
        }
        if(scan.hasNextInt()){
            parent = scan.nextInt();
        }
    }
    
    @Override
    public String toString(){
        return name + " " + index;
        
    }
    @Override
    public int compareTo(Thing t){
        return 0;
    }
    
    
    
}
