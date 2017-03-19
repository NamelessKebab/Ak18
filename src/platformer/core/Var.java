/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import platformer.util.Image;

/**
 *
 * @author Florian Rost & Julian Blazek
 */
public class Var {
    // sollen wir objekte für die GUIs machen oder sie einfach immer neu ablaufen lassen?
    // sollten wir ein Package für die ganzen GUI dateien machen?

    static int screenwidth = 800;
    static int screenheight = 600;
    static boolean moveup = false;
    static boolean movedown = false;
    static boolean moveleft = false;
    static boolean moveright = false;
    static boolean pause = false;
    static int backgroundY1 = 0; // bild koordrinate
    static int backgroundY2 = 600; // bild kordianten
    static Label lbl1;
    static JFrame jf1;
    static BufferedImage imgBackground1;  //Testhintergrund
    static BufferedImage sprite;
    static platformer.core.Player play = null;
    static boolean gameStarted = false;
    static long oldTime;
    static long newTime = System.nanoTime();

    public Var() {
        //background

        try {
            imgBackground1 = Image.getImage("/rsc/bProject.png");
            //imgBackground1 = ImageIO.read(getClass().getResource("/rsc/bProject.png").toURI().toURL()); // Bild wird aus der .jar Datei / dem Quellverzeichnis geladen
            //sprite = ImageIO.read(getClass().getResource("/rsc/b1.png").toURI().toURL());

        } catch (IOException | URISyntaxException e) {

            System.out.println("Bilder nicht geladen werden");

        }

    }
}
