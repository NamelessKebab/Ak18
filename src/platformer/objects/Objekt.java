/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objects;

/**
 *
 * @author Julian Blazek
 */
public abstract class Objekt {

    int X = 0;
    int Y = 0;
    int HEIGHT = 0;
    int WIDTH = 0;

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

}
