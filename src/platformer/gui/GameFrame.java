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
 *
 * @author Florian Rost
 */
public class GameFrame extends JFrame { //Spielfenster

    PaintPanel panel;
    private Level level;

    public GameFrame() {
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(800, 600));
        setSize(800, 600); // GUI breite und dicke
        setLocationRelativeTo(null);//Objekt wird in die Mitte geschoben
        setVisible(false);
        setLayout(null);
        setTitle("Jump and Run");
        setResizable(false);
        requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel = new PaintPanel();
        panel.setBounds(0, 0, getWidth(), getHeight());
        add(panel);
        setPreferredSize(new Dimension(getWidth(),getHeight()));
        addKeyListener(new KeyHandler());
    }

    public void render(Level level) {
        setLevel(level);
        panel.repaint();
    }

    public void forceRender(Level level) {
        setLevel(level);
        panel.paintComponent(panel.getGraphics());
    }

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
        g.setColor(player.getCOLOR());
        g.fillRect(player.getX(), player.getY(), player.getHEIGHT(), player.getWIDTH());
    }

    private void setLevel(Level level) {
        this.level = level;
    }

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
         * @param objekte the objekte to set
         */
        /**
         * @return the antialisingEnabled
         */
        public boolean isAntialisingEnabled() {
            return antialisingEnabled;
        }

        /**
         * @param antialisingEnabled the antialisingEnabled to set
         */
        public void setAntialisingEnabled(boolean antialisingEnabled) {
            this.antialisingEnabled = antialisingEnabled;
        }

    }
}
