/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * Objekt.java Zweck: Eine Abstrakte Klasse die die Eigenschaften beinhaltet die
 * ein Objekt in diesem Spiel haben sollte. Implementiert Serialisierbarkeit
 *
 * @author Julian Blazek
 */
public abstract class Objekt implements Serializable {

    /**
     * @param X the X to set
     */
    public void setX(double X) {
        this.X = X;
    }

    /**
     * @param Y the Y to set
     */
    public void setY(double Y) {
        this.Y = Y;
    }

    /**
     * @param HEIGHT the HEIGHT to set
     */
    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    /**
     * @param WIDTH the WIDTH to set
     */
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    /**
     * @param COLOR the COLOR to set
     */
    public void setCOLOR(Color COLOR) {
        this.COLOR = COLOR;
    }

    /**
     * @param isSolid the isSolid to set
     */
    public void setIsSolid(boolean isSolid) {
        this.isSolid = isSolid;
    }

    static final long serialVersionUID = 4;

    protected double X = 0;
    protected double Y = 0;
    protected int HEIGHT = 0;
    protected int WIDTH = 0;
    protected ImageIcon SPRITE = null;
    protected Color COLOR = Color.DARK_GRAY;
    protected boolean isSolid = false;
    protected boolean isHurt = false;

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

    /*
     * Da BufferedImage nicht 'serializable' implementiert muss man hier zu
     * einem Workaround greifen. Das BufferedImage wird in ein ImageIcon und
     * später auch aus diesem zu einem BufferedImage zurück konvertiert.
     */
    /**
     * Gibt die Sprite des Objektes (falls vorhanden) zurück.
     *
     * @return BufferedImage
     */
    public BufferedImage getSPRITE() {
        if (SPRITE != null) {
            return convertToBufferedImage(SPRITE.getImage());
        } else {
            return null;
        }
    }

    /**
     * Setzt die Sprite des Objektes
     *
     * @param sprite
     */
    public void setSPRITE(BufferedImage sprite) {
        try {
            SPRITE = new ImageIcon(sprite);
        } catch (NullPointerException ex) {
            SPRITE = null;
        }
    }

    /**
     * Die überschreibbare "update" Methode die jedes mal wenn die Loop
     * durchläuft augerufen wird.
     *
     * @param deltaTime
     */
    public void update(double deltaTime) {
    }

    /**
     * Die überschreibbare "collide" Methode die jedes mal aufgerufen wird falls
     * eine Kollision erkannt wird.
     *
     * @param partner Das Partner Objekt
     */
    public void collide(Objekt partner) {
    }

    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
