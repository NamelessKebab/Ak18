/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.physics;

import platformer.core.Player;

/**
 * PlayerPhysics.java Zweck: Steuert die Physik eines Player Objekts
 *
 * @author Julian Blazek
 * @version 1.0 17.03.2017
 */
public class PlayerPhysics {

    /**
     * Diese Methode berechnet die Physik für den gegebenen Zeitraum. ySpeed
     * basiert auf v=g*dt wobei v = ySpeed; g = gravity, t = deltaTime. y
     * basiert auf s=v*t wobei s = y0+y1; v = ySpeed; t = deltaTime.
     *
     * Wäre der Player nun nach dem berechnen der Physik unterhalb des
     * Bildschirm Randes, wird er wieder auf die vorherige y-Position
     * zurückgesetzt und die Berechnung wird erneut ausgeführt.
     *
     * @param player Player Objekt
     * @param gravity Die Stärke der Gravität mit der gerechnet werden soll.
     * (default ~100)
     * @param deltaTime Die Zeit für die die Physik berechnet werden soll
     */
    public static void update(platformer.core.Player player, double gravity, double deltaTime) {
        int alty, y;
        double ySpeed;
        alty = player.getY();
        ySpeed = player.getySpeed() + gravity * deltaTime;
        player.setySpeed(ySpeed);
        y = (int) (player.getY() + player.getySpeed() * deltaTime);
        player.setY(y);
        if (y > 550) {
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

}
