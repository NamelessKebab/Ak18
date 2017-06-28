/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer;

import platformer.gui.NewGUIPause;

/**
 * KeyActions.java Zweck: Beinhaltet Methoden die bei dem Druck von Tasten
 * ausgeführt werden sollen.
 *
 * @author Julian Blazek
 */
public class KeyActions {

    /**
     * Lässt den Spieler falls er längs der y-Achse still steht mittels der
     * springe() Funktion springen.
     */
    static void w_pressed() {
        if (Platformer.level.getPlayer().getySpeed() == 0) {
            Platformer.level.getPlayer().springe();
        }
    }

    /**
     * Bewegt den Spieler nach unten.
     * (nicht benutzt)
     */
    static void s_pressed() {
        Platformer.level.getPlayer().setY(Platformer.level.getPlayer().getY() + 3);
    }

    /**
     * Bewegt den Spieler nach links.
     */
    static void a_pressed() {
        Platformer.level.getPlayer().setX(Platformer.level.getPlayer().getX() - 3);
    }

    /**
     * Bewegt den Spieler nach rechts.
     */
    static void d_pressed() {
        Platformer.level.getPlayer().setX(Platformer.level.getPlayer().getX() + 3);
    }

    /**
     * Ruft das Pause Menü auf.
     */
    static void p_pressed() {
        new NewGUIPause().setVisible(true);

    }

}
