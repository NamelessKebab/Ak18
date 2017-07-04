/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Ziel.java Zweck: Ist als Zielblock zuständig.
 *
 * @author Julian Blazek & Florian Rost
 */
public class Ziel extends Bloecke {

    public Ziel(int p_x, int p_y, int p_width, int p_height, Color p_color) {
        super(p_x, p_y, p_width, p_height, false, false, p_color);
    }

    public Ziel(int p_x, int p_y, int p_width, int p_height, BufferedImage p_sprite) {
        super(p_x, p_y, p_width, p_height, false, false, p_sprite);
    }

    @Override
    public void collide(Objekt partner) {
        platformer.Platformer.won();
    }

}
