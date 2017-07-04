/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer;

import java.util.ArrayList;
import static platformer.KeyHandler.processKeys;
import platformer.gui.GameFrame;
import platformer.objekte.Objekt;

/**
 * GameLoop.java Zweck: Beinhaltet die Loop die über einen Thread gestartet
 * wird.
 *
 * @author Julian Blazek
 */
public class GameLoop implements Runnable {

    GameFrame frame;
    private boolean running = true;
    private final int targetFPS;
    private boolean debug = true;

    /**
     * Der Konstruktor dieser Klasse welcher sowohl die zu erzielenden FPS
     * speichert, als auch ein GameFrame Objekt erzeugt.
     *
     * @param targetFPS
     */
    public GameLoop(int targetFPS) {
        frame = new GameFrame();
        this.targetFPS = targetFPS;

    }

    /**
     * Ruft in allen Objekten und dem Player die update(delta) Methode auf.
     *
     * @param delta Die Zeit zwischen der letzten und dieser Ausführung der Loop
     */
    private void updateGame(double delta) {
        ArrayList<Objekt> objekte = Platformer.level.getObjekte();
        for (Objekt objekt : objekte) {
            objekt.update(delta);
        }
        Platformer.level.getPlayer().update(delta);
    }

    /**
     * Rendert das spezifische Level welches in render(Level lvl) übergeben wird
     */
    private void render() {
        frame.render(Platformer.level);
    }

    /**
     * Die Threadmethode welche bei java.lang.Thread.start() aufgerufen wird.
     */
    @Override
    public void run() {
        // Setzt die Größe des Frames auf die Größe des Levels
        frame.setPreferredSize(Platformer.level.getSize());
        frame.pack();
        
        frame.setVisible(true);
        long lastTime = System.nanoTime();
        // Optimale Laufzeit der Loop in Nanosekunden sodass die Loop targetFPS mal in der Sekunde läuft. (0x3B9ACA00 = 1 Milliarde)
        final long optimalTime = 0x3B9ACA00 / targetFPS;
        int n = 0;
        // Eigentliche Loop
        while (isRunning()) {
            long nowTime = System.nanoTime();
            long loopLength = nowTime - lastTime;
            double delta = loopLength / (double) 33333332;
            lastTime = nowTime;
            double accuracy = loopLength / ((double) optimalTime); //Prüfwert.. Umso näher an 1 umso besser war die Loop in der Zeit.

            // Die eigentlichen Aktionen in der Loop
            KeyHandler.processKeys();
            
            updateGame(delta);
            render();
            
            // Berechnung der Optimalen Zeit die der Thread dann schläft. Die 0xF4240 (1'000'000) dienen zur Konvertierung der ns in ms.
            long sleepTime = (lastTime - System.nanoTime() + optimalTime) / 0xF4240;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            // Nur zum Debuggen...
            if (n == 60 && isDebug() == true) {
                System.out.println("" + accuracy + ";" + delta + ";" + optimalTime + ";" + lastTime + ";" + Platformer.level.getPlayer().getySpeed());
                n = 0;
            }
            n++;
        }
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

}
