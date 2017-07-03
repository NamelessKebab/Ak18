/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Objekt.java Zweck: Eine Abstrakte Klasse die die Eigenschaften beinhaltet die
 * ein Objekt in diesem Spiel haben sollte. Implementiert Serialisierbarkeit
 *
 * @author Julian Blazek
 */
public abstract class Objekt implements Serializable {

    static final long serialVersionUID = 3;

    double X = 0;
    double Y = 0;
    int HEIGHT = 0;
    int WIDTH = 0;
    BufferedImage SPRITE = null;
    Color COLOR = Color.DARK_GRAY;

    public Color getCOLOR() {
        return COLOR;
    }

    public int getX() {
        return (int) X;
    }

    public int getY() {
        return (int) Y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public Rectangle getREKT() {
        Rectangle rekt = new Rectangle((int) X, (int) Y, WIDTH, HEIGHT);
        return rekt;
    }

    public BufferedImage getSPRITE() {
        return SPRITE;
    }

    public void update(double deltaTime) {
    }

}
