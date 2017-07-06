/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 * Bloecke.java Zweck: Eine Klasse die Objekt.java erweitert und alle Blöcke
 * repräsentiert..
 *
 * @author Florian Rost
 */
public class Bloecke extends Objekt {

    int h = 5;

    public Bloecke(int p_x, int p_y, int p_width, int p_height, boolean solid, boolean hurts, Color p_color) {
        X = p_x;
        Y = p_y;
        WIDTH = p_width;
        HEIGHT = p_height;
        COLOR = p_color;
        isSolid = solid;
        isHurt = hurts;
    }

    public Bloecke(int p_x, int p_y, int p_width, int p_height, boolean solid, boolean hurts, BufferedImage p_sprite) {
        X = p_x;
        Y = p_y;
        WIDTH = p_width;
        HEIGHT = p_height;
        SPRITE = new ImageIcon(p_sprite);
        isSolid = solid;
        isHurt = hurts;
    }

}
