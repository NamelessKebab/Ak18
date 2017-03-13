/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

/**
 *
 * @author Florian Rost
 */
public class Erstesgame {
    final public static String version = "0.0.1";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        new Gui();         //Klassen werden durch 
        new Var();         // die main
        new KeyHandler();  // aufgerufen
        new Label();
        new NewGUI().setVisible(true);
        System.out.println("DÃ¶ner");

//
    }
    
    public static void print(String pOut){
        System.out.println(pOut);
    }
    
}
