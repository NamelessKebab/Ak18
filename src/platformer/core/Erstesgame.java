/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

/**
 *
 * @author Florian Rost
 */
public class Erstesgame {
    final public static String version = "0.0.1";
    /**
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        
        new Gui();         //Klassen werden durch 
        new Var();         // die main
        new TimerClass();  // aufgerufen
        new Label();
        new NewGUI().setVisible(true);
        Var.play = new Player(0,0,Var.sprite);
        System.out.println("DÃ¶ner");
        

//
    }
    
    public static void print(String pOut){
        System.out.println(pOut);
    }
    
}
