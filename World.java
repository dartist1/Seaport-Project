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
public class World extends Thing{
    ArrayList<SeaPort> ports = new ArrayList<>();
    PortTime time = new PortTime();
    
    
    public World(Scanner scan){
        super();
        while(scan.hasNextLine()){
            process(scan.nextLine());
        }
    }
    @Override
    public String toString(){
        String str1 = "";
        
        if(ports.isEmpty()){
            return str1;
        }
        
        for(SeaPort port : ports){
            
            str1 += port;
        }
        return str1;
    }
    
    private void process(String str1){
        Scanner scan = new Scanner(str1);
        
        if(!scan.hasNext()){
            return;
        }
        
        switch(scan.next()){
            case "port":
                addPort(scan);
                break;
            case "dock":
                addDock(scan);
                break;
            case "pship":
                addPShip(scan);
                break;
            case "cship":
                addCShip(scan);
                break;
            case "person":
                addPerson(scan);
                break;
            
            default:
                break;
        }
        
    }
    
    public void addPort(Scanner scan){
        ports.add(new SeaPort(scan));
    }
    
    public void addDock(Scanner scan){
        Dock tDock = new Dock(scan);
        ports.stream().filter((port) -> (port.index == tDock.parent)).forEachOrdered((port) -> {
            port.docks.add(tDock);
        });
    }
    
    public void addPShip(Scanner scan){
        PassengerShip tpShip = new PassengerShip(scan);
        assignShip(tpShip);
    }
    
    public void addCShip(Scanner scan){
        CargoShip tcShip = new CargoShip(scan);
        assignShip(tcShip);
    }
    
    public void addPerson(Scanner scan){
        Person tPerson = new Person(scan);
        ports.stream().filter((port) -> (port.index == tPerson.parent)).forEachOrdered((port) -> {
            port.person.add(tPerson);
        });
    }
    
    public SeaPort getPortByIndex(int num1){
        for(SeaPort port : ports){
            if(port.index == num1){
                return port;
            }
        }
        return null;
    }
    
    public Dock getDockByIndex(int num1){
        for(SeaPort port : ports){
            for(Dock dock : port.docks){
                if(dock.index == num1){
                    return dock;
                }
            }
        }
        return null;
    }
    
    public Ship getShipByIndex(int num1, HashMap<Integer, Ship> hmShip){
        return hmShip.get(num1);
    }
    
    public Person getPersonByIndex(int num1){
        for(SeaPort port : ports){
            for(Person person : port.person){
                if(person.index == num1){
                    return person;
                }
            }
        }
        return null;
    }
    
    public void assignShip(Ship ship){
        Dock dock = getDockByIndex(ship.parent);
        if(dock == null){
            getPortByIndex(ship.parent).ships.add(ship);
            getPortByIndex(ship.parent).queue.add(ship);
        } else {
            dock.ship = ship;
            getPortByIndex(dock.parent).ships.add(ship);
        }
    }
    
//    public String search(String type, String target){
//        String str1 = "";
//        
//        switch(type){
//            case "Name":
//                str1 += searchName(target);
//                break;
//            case "Index":
//                try{
//                    str1 += searchIndex(Integer.parseInt(target));
//                } catch (NumberFormatException n){
//                    str1 += "Not vaild";
//                }
//                break;
//            case "Skill":
//                str1 += searchType(target);
//                break;
//            default:
//                break;
//        }
//        return str1;
//    }
    
    public String searchName(String target){
        for(SeaPort port : ports){
            if(port.name.equals(target)){
                return port.toString();
            }
            for(Dock dock : port.docks){
                if(dock.name.equals(target)){
                    return dock.toString();
                }
            }
            for(Ship ship : port.ships){
                if(ship.name.equals(target)){
                    return ship.toString();
                }
            }
            for(Person person : port.person){
                if(person.name.equals(target)){
                    return person.toString();
                }
            }
        }
        return "Not found!";
    }
    
    public String searchIndex(int target){
        for(SeaPort port : ports){
            if (port.index == target){
                return port.toString();
            }
            for(Dock dock : port.docks){
                if(dock.index == target){
                    return dock.toString();
                }
            }
            for(Ship ship : port.ships){
                if(ship.index == target){
                    return ship.toString();
                }
            }
            for(Person person : port.person){
                if(person.index == target){
                    return person.toString();
                }
            }
        }
        return "Target not found.";
    }
    
    public String searchType(String target){
        String str1 = "";
        for(SeaPort port : ports){
            for(Person person : port.person){
                if(person.skill.equals(target)){
                    str1 += person.toString();
                }
            }
        }
        if("".equals(str1)){
            return "Not found!";
        }
        return str1;
    }

    public String search(String type, String target) {
        String str1 = "";
        
        switch(type){
            case "Name":
                str1 += searchName(target);
                break;
            case "Index":
                try{
                    str1 += searchIndex(Integer.parseInt(target));
                } catch (NumberFormatException n){
                    str1 += "Not vaild";
                }
                break;
            case "Skill":
                str1 += searchType(target);
                break;
            default:
                break;
        }
        return str1;
    }
    
}
