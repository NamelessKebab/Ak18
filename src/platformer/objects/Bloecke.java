/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objects;

import java.awt.Color;

/**
 *
 * @author Florian Rost
 */
public class Bloecke {

    final int x, y;              //Block  x und y
    final int width, height;     // Block Höhe und weite
    boolean coin = false;
    final Color COLOR;
    int h = 5;

    public Bloecke(int p_x, int p_y, int p_width, int p_height, Color p_color) {
        x = p_x;
        y = p_y;
        width = p_width;
        height = p_height;
        COLOR = p_color;

    }

    public boolean Kollisionsabfrage(int x_block, int y_block, int x_char, int y_char) {
        if (x_char >= x_block && y_char >= y_block && y_char <= y_block + height) { //Kolisionsabfrage: abfragen ob charakter gleiche x koordinate wie block hat
            if (x_char >= x_block + width) {
                coin = true;
                return true;
            } else {
                if (x_char - 40 <= x_block + width) {
                    coin = true;
                    return true;
                }

            }
        } else {
            return false;
        }
        return false;
    }

    public int getX_Block() {
        return x;
    }

    public int getY_Block() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getFarbe() {
        return COLOR;
    }

    public boolean Coin() {
        return coin;
    }
}
