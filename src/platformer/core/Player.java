/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import java.awt.image.BufferedImage;

/**
 * Diese Klasse dient dazu Variablen und Eigenschaften des Spielers zu
 * speichern.
 *
 * @author Julian Blazek
 * @version 1.0 13.03.2017
 */
public class Player {

    private int x;
    private int y;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private int altX;
    private int altY;
    private BufferedImage sprite;

    /**
     * Der Konstruktor dieser Klasse welcher sofort einige Werte speichert.
     *
     * @param x Anfänglicher x-Wert des Objekts
     * @param y Anfänglicher y-Wert des Objekts
     * @param sprite Sprite des Objekts
     */
    public Player(int x, int y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
        return sprite;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

}
