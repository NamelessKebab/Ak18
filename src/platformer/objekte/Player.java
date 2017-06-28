/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient dazu Variablen und Eigenschaften des Spielers zu
 * speichern.
 *
 * @author Julian Blazek
 * @version 1.3 13.03.2017
 */
public class Player extends Objekt{

    static final long serialVersionUID = 3;
    
    private double xSpeed = 0;
    private double ySpeed = 0;
    private int altX;
    private int altY;
    private double gravity = 5;

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
        this.SPRITE = sprite;
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

    /**
     * @return Gibt die gespeicherte sprite des Objekts zurück.
     */
    public BufferedImage getSprite() {
        return SPRITE;
    }

    public void setX(int x) {
        this.X= x;
    }

    public void setY(int y) {
        this.Y = y;
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
    
    @Override
    public void update(double deltaTime){
        int alty, y;
        alty = getY();
        ySpeed = getySpeed() + gravity * deltaTime;
        y = (int) (getY() + getySpeed() * deltaTime);
        setY(y);
        for (Objekt objekt : platformer.Platformer.level.getObjekte()) {
            if (kollisionsAbfrage(this, objekt)) {
                setySpeed(0);
                setY(alty);
                
            }
        }
    }
    
    public static boolean kollisionsAbfrage(Player player, Objekt object) {
        boolean collision = false;
        
        Rectangle playerRect = player.getREKT();
        Rectangle objectRect = object.getREKT();
        if (playerRect.intersects(objectRect)) {
            collision = true;
            
        }
        return collision;
    }
    
    public void springe() {
        setySpeed(-50);
    }
}
