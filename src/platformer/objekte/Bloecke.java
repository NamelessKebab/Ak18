/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Bloecke.java Zweck: Eine Klasse die Objekt.java erweitert und alle Blöcke
 * repräsentiert..
 *
 * @author Florian Rost
 */
public class Bloecke extends Objekt {

    int h = 5;

    public Bloecke(int p_x, int p_y, int p_width, int p_height, Color p_color) {
        X = p_x;
        Y = p_y;
        WIDTH = p_width;
        HEIGHT = p_height;
        COLOR = p_color;
    }

    public Bloecke(int p_x, int p_y, int p_width, int p_height, BufferedImage p_sprite) {
        X = p_x;
        Y = p_y;
        WIDTH = p_width;
        HEIGHT = p_height;
        SPRITE = p_sprite;
    }
    
}
