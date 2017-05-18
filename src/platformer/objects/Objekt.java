/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objects;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

/**
 *
 * @author Julian Blazek
 */
public abstract class Objekt {

    int X = 0;
    int Y = 0;
    int HEIGHT = 0;
    int WIDTH = 0;
    BufferedImage SPRITE = null;
    Color COLOR = Color.DARK_GRAY;

    public Color getCOLOR() {
        return COLOR;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public Rectangle getREKT() {
        Rectangle rekt = new Rectangle(X, Y, WIDTH, HEIGHT);
        return rekt;
    }

    public BufferedImage getSPRITE() {
        return SPRITE;
    }

}
