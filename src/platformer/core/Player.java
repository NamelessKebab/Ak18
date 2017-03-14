/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import java.awt.image.BufferedImage;

/**
 *
 * @author Julian Blazek
 */
public class Player {
    private int x;
    private int y;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private int altX;
    private int altY;
    private BufferedImage sprite;

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

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
