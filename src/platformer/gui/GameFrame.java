/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import platformer.KeyHandler;
import platformer.objekte.Level;
import platformer.objekte.Objekt;
import platformer.objekte.Player;

/**
 * GameFrame.java Zweck: Das Frame auf dem das Spiel gezeichnet wird.
 *
 * @author Florian Rost
 */
public class GameFrame extends JFrame { //Spielfenster

    PaintPanel panel;
    private Level level;

    /**
     * Der Konstruktor
     */
    public GameFrame() {
        init();
    }

    /**
     * Initialisiert das JFrame
     */
    private void init() {
        setLocationRelativeTo(null);//Objekt wird in die Mitte geschoben
        setVisible(false);
        getContentPane().setLayout(new java.awt.GridLayout());
        setTitle("Platformer");
        setResizable(false);
        requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel = new PaintPanel();
        panel.setBounds(0, 0, getWidth(), getHeight());
        getContentPane().add(panel);
        addKeyListener(new KeyHandler());
        pack();
    }

    /**
     * Ruft die repaint() Methode des Panels auf um dieses neu zu zeichnen. Das
     * zu zeichnende findet sich in GameFrame.PaintPanel.paintComponent().
     *
     * @param level Das zu zeichnende Level
     */
    public void render(Level level) {
        setLevel(level);
        panel.repaint();
    }

    /**
     * Erzwingt das zeichnen des Levels ohne dass es erst in die
     * Swing-Event-Queue gelegt wird
     *
     * @param level Das zu zeichnende Level
     */
    public void forceRender(Level level) {
        setLevel(level);
        panel.paintComponent(panel.getGraphics());
    }

    /**
     * Methode die zuständig ist für das Rendern des Frames. Wird von
     * paintComponent() im Panel aufgerufen.
     *
     * @param g
     */
    private void renderFrame(Graphics2D g) {
        ArrayList<Objekt> objekte = level.getObjekte();
        for (Objekt objekt : objekte) {
            g.setColor(objekt.getCOLOR());
            if (objekt.getSPRITE() == null) {
                g.fillRect(objekt.getX(), objekt.getY(), objekt.getWIDTH(), objekt.getHEIGHT());
            } else {
                g.drawImage(objekt.getSPRITE(), objekt.getX(), objekt.getY(), objekt.getWIDTH(), objekt.getHEIGHT(), null);
            }
        }
        Player player = level.getPlayer();
        if (player.getSPRITE() != null) {
            g.drawImage(player.getSPRITE(), player.getX(), player.getY(), player.getWIDTH(), player.getHEIGHT(), this);
        } else {
            g.setColor(player.getCOLOR());
            g.fillRect(player.getX(), player.getY(), player.getHEIGHT(), player.getWIDTH());
        }
    }

    private void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Setzt das PaintPanel auf die erwünschte Größe.
     *
     * @param size Die erwünschte Größe des PaintPanels
     */
    public void setPanelSize(Dimension size) {
        panel.setPreferredSize(size);
        this.pack();
        setLocationRelativeTo(null);
    }

    /**
     * GameFrame.PaintPanel Zweck: Das eigentliche Panel auf welches gezeichnet
     * wird.
     */
    protected class PaintPanel extends JPanel {

        private boolean antialisingEnabled = false;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if (isAntialisingEnabled()) {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            } else {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            }
            renderFrame(g2d);
        }

        /**
         * @return the antialisingEnabled
         */
        public boolean isAntialisingEnabled() {
            return antialisingEnabled;
        }

        /**
         * Aktiviere oder Deaktiviere Antialising
         *
         * @param antialisingEnabled the antialisingEnabled to set
         */
        public void setAntialisingEnabled(boolean antialisingEnabled) {
            this.antialisingEnabled = antialisingEnabled;
        }

    }
}
