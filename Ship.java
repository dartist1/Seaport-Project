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
public class Ship extends Thing{
    PortTime arrivalTime = new PortTime();
    private PortTime dockTime = new PortTime();
    private double draft;
    private double length;
    private double weight;
    private double width;
    //Object name;
    
    
    public Ship(Scanner scan){
        super();
        if(scan.hasNextDouble()){
            setWeight(scan.nextDouble());
        }
        if(scan.hasNextDouble()){
            setLength(scan.nextDouble());
        }
        if(scan.hasNextDouble()){
            setWidth(scan.nextDouble());
        }
        if(scan.hasNextDouble()){
            setDraft(scan.nextDouble());
        }
    }
    
    @Override
    public String toString(){
        String str1 = "Ship: " + super.toString();
        return str1;
    }
    
    public double getDraft(){
        return draft;
    }
    
    private void setDraft(double draft){
        this.draft = draft;
    }
    
    public double getLength(){
        return length;
    }
    
    private void setLength(double length){
        this.length = length;
    }
    
    public PortTime getDockTime(){
        return dockTime;
    }
    
    public void setDockTime(PortTime dockTime){
        this.dockTime = dockTime;
    }
    
    public double getWeight(){
        return weight;
    }
    
    private void setWeight(double weight){
        this.weight= weight;
    }
    
    public double getWidth(){
        return width;
    }
    
    private void setWidth(double width){
        this.width = width;
    }
}
