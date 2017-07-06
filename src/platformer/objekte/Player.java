/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Diese Klasse dient dazu Variablen und Eigenschaften des Spielers zu
 * speichern.
 *
 * @author Julian Blazek
 * @version 1.4 03.07.2017
 */
public class Player extends Objekt {

    static final long serialVersionUID = 4;

    private double xSpeed = 0;
    private double ySpeed = 0;
    private int altX;
    private int altY;
    private double gravity = 6;
    private int sprungStaerke = -35;

    /**
     * Der Konstruktor dieser Klasse welcher sofort einige Werte speichert.
     *
     * @param x Anfänglicher x-Wert des Objekts
     * @param y Anfänglicher y-Wert des Objekts
     * @param width Breite
     * @param height Länge
     * @param sprite Sprite des Objekts
     */
    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        this.X = x;
        this.Y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        try {
            this.SPRITE = new ImageIcon(sprite);
        } catch (NullPointerException ex) {
            this.SPRITE = null;
        }

    }

    public double getxSpeed() {
        return xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public int getAltX() {
        return altX;
    }

    public int getAltY() {
        return altY;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setAltX(int altX) {
        this.altX = altX;
    }

    public void setAltY(int altY) {
        this.altY = altY;
    }

    /**
     * Führt die Physikberechnung des Spielers durch. Lässt einen Spieler auch
     * nur dann "kollidieren" falls das Objekt mit dem es Kollidiert "Solid"
     * ist.
     *
     * @param deltaTime
     */
    @Override
    public void update(double deltaTime) {
        int alty, y;
        alty = getY();
        ySpeed = getySpeed() + getGravity() * deltaTime;
        y = (int) (getY() + getySpeed() * deltaTime);
        setY(y);
        for (Objekt objekt : platformer.Platformer.level.getObjekte()) {
            if (kollisionsAbfrage(this, objekt)) {
                objekt.collide(this);
                if (objekt.isSolid) { // Prüft ob Objekt solid ist.
                    setySpeed(0);
                    setY(alty);

                }
            }
        }
    }

    /**
     * Prüft die Kollision zwischen zwei Objekten hier einem Spieler und einem
     * Objekt
     *
     * @param player Das Player Objekt
     * @param object Das Objekt Objekt
     * @return gibt zurück ob kollidiert oder nicht.
     */
    public static boolean kollisionsAbfrage(Player player, Objekt object) {
        boolean collision = false;

        Rectangle playerRect = player.getREKT();
        Rectangle objectRect = object.getREKT();
        if (playerRect.intersects(objectRect)) {
            collision = true;

        }
        return collision;
    }

    /**
     * Lässt den Player "springen" ( verändert die y-Geschwindigkeit des
     * Spielers )
     */
    public void springe() {
        setySpeed(getSprungStaerke());
    }

    /**
     * @return the gravity
     */
    public double getGravity() {
        return gravity;
    }

    /**
     * @param gravity the gravity to set
     */
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    /**
     * @return the sprungStaerke
     */
    public int getSprungStaerke() {
        return sprungStaerke;
    }

    /**
     * @param sprungStaerke the sprungStaerke to set
     */
    public void setSprungStaerke(int sprungStaerke) {
        this.sprungStaerke = sprungStaerke;
    }
}
