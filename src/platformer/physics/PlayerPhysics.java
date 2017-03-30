/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.physics;

import platformer.objects.Player;
import platformer.data.Var;
import platformer.objects.Objekt;

/**
 * PlayerPhysics.java Zweck: Steuert die Physik eines Player Objekts
 *
 * @author Julian Blazek
 * @version 1.3 17.03.2017
 */
public class PlayerPhysics {

    /**
     * Diese Methode berechnet die Physik für den gegebenen Zeitraum. ySpeed
     * basiert auf v=g*dt wobei v = ySpeed; g = gravity, t = deltaTime. y
     * basiert auf s=v*t wobei s = y0+y1; v = ySpeed; t = deltaTime.
     *
     * Durch die Kollisionsabfrage wird jeder Block geprüft ob er mit dem
     * Spieler kollidiert. Kollidiert nun ein Block, so wird der Spieler auf die
     * Position vor dem berechnen der Physik zurückgesetzt und die
     * y-Geschwindigkeit auf 0 gesetzt.
     *
     * @param player Player Objekt
     * @param gravity Die Stärke der Gravität mit der gerechnet werden soll.
     * (gut ist ~100)
     * @param deltaTime Die Zeit für die die Physik berechnet werden soll
     */
    public static void update(platformer.objects.Player player, double gravity, double deltaTime) {
        int alty, y;
        double ySpeed;
        alty = player.getY();
        ySpeed = player.getySpeed() + gravity * deltaTime;
        player.setySpeed(ySpeed);
        y = (int) (player.getY() + player.getySpeed() * deltaTime);
        player.setY(y);
        if (kollisionsAbfrage(player, Var.getBlock())) {
            player.setySpeed(0);
            player.setY(alty);
        }
        System.out.println("Y: " + y + " ySpeed: " + ySpeed);
    }

    /**
     * Setzt die y-Geschwindigkeit auf einen negativen Wert. Oben links im
     * Koordinaten- system ist 0. Nach rechts steigt x an, nach links y. Daher
     * ist die y-Geschwindigkeit negativ.
     *
     * @param player Player Objekt
     */
    public static void springe(Player player) {
        player.setySpeed(-100);
    }

    /**
     * Berechnet, ob der Spieler mit einem Objekt kollidiert. Erst wird geprüft
     * ob in y-Richtung und dann ob auch noch in x-Richtung eine Kollision mit
     * dem anderen Objekt stattfindet.
     *
     * @param player Ein Objekt der Klasse Spieler
     * @param object Ein Objekt der Klasse Objekt oder einer Subklasse
     * @return Kollidiert, boolean
     */
    public static boolean kollisionsAbfrage(Player player, Objekt object) {
        boolean collision = false;
        int pX = player.getX();
        int pY = player.getY();
        int oX = object.getX();
        int oY = object.getY();
        int pH = player.getHEIGHT();
        int pW = player.getWIDTH();
        int oH = object.getHEIGHT();
        int oW = object.getWIDTH();
        if ((pY + pH >= oY && pY <= oY + oH) && (pX + pW >= oX && pX + pW <= oX + oW)) {
            collision = true;
            System.out.println("Collide!");
        }
        return collision;
    }

}
