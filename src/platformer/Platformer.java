/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer;

import platformer.objekte.Level;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import platformer.gui.NewGUI;

/**
 * Platformer.java Zweck: Diese Klasse ist die Start und Hauptklasse des
 * Platformers
 *
 * @author Florian Rost & Julian Blazek
 */
public class Platformer {

    final private static int TARGETFPS = 60; // Empfohlen: 60 FPS. Unter 30 kann es zu Berechnungsfehlern in der Physik kommen.
    final public static String VERSION = "v0.1.1.0-alpha";
    private static Thread gameThread;
    private static NewGUI menu;
    public static Level level = new Level();
    private static GameLoop gameLoop;

    // Methode die aufgerufen wird falls der Spieler gewonnen hat.
    public static void won() {
        gameLoop.setRunning(false);
        JOptionPane.showMessageDialog(null, "Du hast gewonnen!!");
        backToMenu();
    }

    public static void backToMenu() {
        gameLoop.frame.dispose();
        gameLoop = null;
        KeyHandler.KEYS_PRESSED.clear();
        gameThread = null;
        level = new Level();
        System.gc();
        menu.setVisible(true);
    }

    public Platformer() {
        init();
    }

    /**
     * Das Menü wird erstellt und sichtbar gemacht.
     */
    private static void init() {
        menu = new platformer.gui.NewGUI();
        menu.setVisible(true);
    }

    /**
     * Falls das Programm direkt über diese Klasse gestartet wird so erzeugt
     * diese ein Objekt ebendieser.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Platformer();
    }

    /**
     * Diese Methode wird aufgerufen sobald der Benutzer auf dem Menü auf
     * "Start" klickt.
     */
    public static void startClicked() {

        gameLoop = new GameLoop(TARGETFPS);

        /**
         * Das Auswahlmenü für Level in Form eines JFileChoosers wird erstellt
         * und mit einem Filter versehen sodass nur die entsprechenden Dateien
         * angezeigt werden.
         */
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Level Dateien (*.lvl)", "lvl");
        chooser.setFileFilter(filter);

        // Zeigt den Dateibrowser und führt folgendes aus wenn der Benutzer eine Datei ausgewählt hat.
        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {

            // Erstellt einen Thread der GameLoop Klasse.
            gameThread = new Thread(gameLoop);

            // Liest die ausgewählte Datei mithilfe des LevelParsers.
            File leveldatei = chooser.getSelectedFile();
            level = new LevelParser(leveldatei).readLevel();
            menu.dispose();

            // Startet den Thread und somit das Spiel.
            gameThread.start();
        } else {
            // Zeigt das durch den Start Button versteckte Menü wieder.
            menu.setVisible(true);
        }

    }

}
