/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaportprogram;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Devon
 */
public class SeaPortProgram extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    HashMap<Integer, Ship> ships = new HashMap<>();
    HashMap<Integer, Dock> docks = new HashMap<>();
    HashMap<Integer, SeaPort> ports = new HashMap<>();
    JTextArea sortedData = new JTextArea();
    String[] sortBy = {"weight", "length", "width", "draft"};
    Scanner scan;
    World world;
    JTextField textField;
    
    
    public SeaPortProgram(){
        
        setTitle("Sea Port Program");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JButton readFile = new JButton("Read File");
        JButton searchButton = new JButton("Search");
        JButton sortButton = new JButton("Sort");
        JLabel searchLabel = new JLabel("Search Here");
        
        JComboBox<String> sortComboBox = new JComboBox<>(sortBy);
        JComboBox<String> cBox = new JComboBox<>();
        cBox.addItem("Index");
        cBox.addItem("Skill");
        cBox.addItem("Name");
        JScrollPane pane = new JScrollPane(sortedData);
        add(pane, BorderLayout.CENTER);
        JTextField jField = new JTextField(10);
        
        JPanel panel = new JPanel();
        panel.add(readFile);
        panel.add(searchLabel);
        panel.add(jField);
        panel.add(cBox);
        panel.add(searchButton);
        panel.add(sortComboBox);
        panel.add(sortButton);
        
        
        add(panel, BorderLayout.PAGE_START);
        
        readFile();
        validate();
        
        sortButton.addActionListener((ActionEvent ae) -> {
            String sortInput = sortComboBox.getSelectedItem().toString();
            String resultText = sortElement(sortInput);
            sortedData.append(resultText);
        });
        
        readFile.addActionListener((ActionEvent ae) -> {
            readFile();
        });
        
        searchButton.addActionListener((ActionEvent ae) -> {
            search((String) cBox.getSelectedItem(),jField.getText());
        });
        
        
    }
    
    private String sortElement(String input){
        String result = "";
        ArrayList<Ship> mShips = new ArrayList<>();
        
        world.ports.forEach((seaport) -> {
            seaport.ships.forEach((ship1) -> {
                mShips.add(ship1);
            });
        });
        
        
        switch (input) {
            case "weight":
                Collections.sort(mShips, Collections.reverseOrder());
                break;
            case "width":
                Collections.sort(mShips, Collections.reverseOrder());
                break;
            case "length":
                Collections.sort(mShips, Collections.reverseOrder());
                break;
            case "draft":
                Collections.sort(mShips, Collections.reverseOrder());
                break;
            default:
                break;
        }
        
        result = mShips.stream().map((ship) -> ship.toString() + "\n").reduce(result, String::concat);
        return result;
    }
    
    public void readFile(){
        JFileChooser jfc = new JFileChooser(".");
        int result = jfc.showOpenDialog(new JFrame());
        
        if(result == JFileChooser.APPROVE_OPTION){
            try{
                scan = new Scanner(new FileReader(jfc.getSelectedFile()));
                world = new World(scan);
            } catch (FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "File Not Found.");
            }
        }
        
        
        
        
        world.ports.forEach((seaport) -> {
            
            ports.put(seaport.index, seaport);
        });
        
        world.ports.forEach((seaport) -> {
            seaport.ships.forEach((ship1) -> {
                ships.put(ship1.index, ship1);
            });
        });
        
        world.ports.forEach((seaport) -> {
            seaport.docks.forEach((dock) -> {
                docks.put(dock.index, dock);
            });
        });
        
        sortedData.setText(world.toString());
    }
    
    
    public void search(String type, String target){
        sortedData.append("Search for " + type + " " + target + ": \n");
        sortedData.append("\t" + world.search(type, target));
    }
    
    
        
    
    public static void main(String[] args) {
        // TODO code application logic here
        SeaPortProgram sp = new SeaPortProgram();
    }
    
}
