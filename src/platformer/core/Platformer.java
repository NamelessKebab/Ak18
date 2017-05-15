/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import platformer.objects.Player;
import platformer.data.Var;
import platformer.gui.GamePanel;
import platformer.gui.Gui;
import platformer.gui.NewGUI;

/**
 * Platformer.java Zweck: Start Klasse. Initialisiert die Objekte aller Klassen.
 *
 * @author Florian Rost
 */
public class Platformer {

    final public static String VERSION = "v0.0.2.5-alpha";

    /**
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {

        Var.setJf1(new Gui());
        new Var();
        new TimerClass();
        new GamePanel();
        new NewGUI().setVisible(true);
        Var.setPlay(new Player(0, 0, 20, 20, Var.getSprite()));
        System.out.println("DÃ¶ner");

//
    }

    public static void print(String pOut) {
        System.out.println(pOut);
    }

}
