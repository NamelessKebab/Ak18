/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.data;

import platformer.gui.GamePanel;
import platformer.gui.Gui;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import platformer.objects.Objekt;
import platformer.util.Image;

/**
 *
 * @author Florian Rost & Julian Blazek
 */
public class Var {
    // sollen wir objekte für die GUIs machen oder sie einfach immer neu ablaufen lassen?
    // sollten wir ein Package für die ganzen GUI dateien machen?
    public static final String version = "v0.0.2.3-alpha";
    private static int screenwidth = 800;
    private static int screenheight = 600;
    private static boolean moveup = false;
    private static boolean movedown = false;
    private static boolean moveleft = false;
    private static boolean moveright = false;
    private static boolean pause = false;
    private static int backgroundY1 = 0; // bild koordrinate
    private static int backgroundY2 = 600; // bild kordianten
    private static GamePanel lbl1;
    private static Gui jf1;
    private static BufferedImage imgBackground1;  //Testhintergrund
    private static BufferedImage sprite;
    private static platformer.objects.Player play = null;
    private static boolean gameStarted = false;
    private static long oldTime;
    private static ArrayList<Objekt> objekte = new ArrayList<Objekt>();
    private static long newTime = System.nanoTime();

    public Var() {
        Level level = platformer.objects.ReadLevel.readLevel("");
        objekte = level.getObjekte();
        play = level.getPlayer();
//        objekte.add(new platformer.objects.Bloecke(0, 550, 400, 40, Color.yellow));
//        objekte.add(new platformer.objects.Bloecke(400,480,100,10,Color.BLUE));
        //background

        try {
            imgBackground1 = Image.getImage("/rsc/images/bProject.png");
            //imgBackground1 = ImageIO.read(getClass().getResource("/rsc/bProject.png").toURI().toURL()); // Bild wird aus der .jar Datei / dem Quellverzeichnis geladen
            //sprite = ImageIO.read(getClass().getResource("/rsc/b1.png").toURI().toURL());

        } catch (IOException | URISyntaxException e) {

            System.out.println("Bilder konnten nicht geladen werden");

        }

    }

    /**
     * @return the screenwidth
     */
    public static int getScreenwidth() {
        return screenwidth;
    }

    /**
     * @param aScreenwidth the screenwidth to set
     */
    public static void setScreenwidth(int aScreenwidth) {
        screenwidth = aScreenwidth;
    }

    /**
     * @return the screenheight
     */
    public static int getScreenheight() {
        return screenheight;
    }

    /**
     * @param aScreenheight the screenheight to set
     */
    public static void setScreenheight(int aScreenheight) {
        screenheight = aScreenheight;
    }

    /**
     * @return the moveup
     */
    public static boolean isMoveup() {
        return moveup;
    }

    /**
     * @param aMoveup the moveup to set
     */
    public static void setMoveup(boolean aMoveup) {
        moveup = aMoveup;
    }

    /**
     * @return the movedown
     */
    public static boolean isMovedown() {
        return movedown;
    }

    /**
     * @param aMovedown the movedown to set
     */
    public static void setMovedown(boolean aMovedown) {
        movedown = aMovedown;
    }

    /**
     * @return the moveleft
     */
    public static boolean isMoveleft() {
        return moveleft;
    }

    /**
     * @param aMoveleft the moveleft to set
     */
    public static void setMoveleft(boolean aMoveleft) {
        moveleft = aMoveleft;
    }

    /**
     * @return the moveright
     */
    public static boolean isMoveright() {
        return moveright;
    }

    /**
     * @param aMoveright the moveright to set
     */
    public static void setMoveright(boolean aMoveright) {
        moveright = aMoveright;
    }

    /**
     * @return the pause
     */
    public static boolean isPause() {
        return pause;
    }

    /**
     * @param aPause the pause to set
     */
    public static void setPause(boolean aPause) {
        pause = aPause;
    }

    /**
     * @return the backgroundY1
     */
    public static int getBackgroundY1() {
        return backgroundY1;
    }

    /**
     * @param aBackgroundY1 the backgroundY1 to set
     */
    public static void setBackgroundY1(int aBackgroundY1) {
        backgroundY1 = aBackgroundY1;
    }

    /**
     * @return the backgroundY2
     */
    public static int getBackgroundY2() {
        return backgroundY2;
    }

    /**
     * @param aBackgroundY2 the backgroundY2 to set
     */
    public static void setBackgroundY2(int aBackgroundY2) {
        backgroundY2 = aBackgroundY2;
    }

    /**
     * @return the lbl1
     */
    public static GamePanel getLbl1() {
        return lbl1;
    }

    /**
     * @param aLbl1 the lbl1 to set
     */
    public static void setLbl1(GamePanel aLbl1) {
        lbl1 = aLbl1;
    }

    /**
     * @return the jf1
     */
    public static Gui getJf1() {
        return jf1;
    }

    /**
     * @param aJf1 the jf1 to set
     */
    public static void setJf1(Gui aJf1) {
        jf1 = aJf1;
    }

    /**
     * @return the imgBackground1
     */
    public static BufferedImage getImgBackground1() {
        return imgBackground1;
    }

    /**
     * @param aImgBackground1 the imgBackground1 to set
     */
    public static void setImgBackground1(BufferedImage aImgBackground1) {
        imgBackground1 = aImgBackground1;
    }

    /**
     * @return the sprite
     */
    public static BufferedImage getSprite() {
        return sprite;
    }

    /**
     * @param aSprite the sprite to set
     */
    public static void setSprite(BufferedImage aSprite) {
        sprite = aSprite;
    }

    /**
     * @return the play
     */
    public static platformer.objects.Player getPlay() {
        return play;
    }

    /**
     * @param aPlay the play to set
     */
    public static void setPlay(platformer.objects.Player aPlay) {
        play = aPlay;
    }

    /**
     * @return the gameStarted
     */
    public static boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * @param aGameStarted the gameStarted to set
     */
    public static void setGameStarted(boolean aGameStarted) {
        gameStarted = aGameStarted;
    }

    /**
     * @return the oldTime
     */
    public static long getOldTime() {
        return oldTime;
    }

    /**
     * @param aOldTime the oldTime to set
     */
    public static void setOldTime(long aOldTime) {
        oldTime = aOldTime;
    }

    /**
     * @return the newTime
     */
    public static long getNewTime() {
        return newTime;
    }

    /**
     * @param aNewTime the newTime to set
     */
    public static void setNewTime(long aNewTime) {
        newTime = aNewTime;
    }

    /**
     * @return the objekte
     */
    public static ArrayList<Objekt> getObjekte() {
        return objekte;
    }

    /**
     * @param aObjekte the objekte to set
     */
    public static void setObjekte(ArrayList<Objekt> aObjekte) {
        objekte = aObjekte;
    }
}
