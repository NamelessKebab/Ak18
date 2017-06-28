/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

/**
 * KeyHandler.java Zweck: Verarbeitet Tastenanschläge im Spiel durch speichern
 * aller gedrückter Tasten.
 *
 * @author Florian Rost
 */
public class KeyHandler implements KeyListener {

    /**
     * Ein Set welches alle gedrückten Tasten beinhaltet bis zu dem Zeitpunkt an
     * dem diese losgelassen werden.
     */
    public static final Set<Integer> KEYS_PRESSED = new HashSet<>();

    static void processKeys() {
        if (KEYS_PRESSED.size() > 0) {
            for (int c : KEYS_PRESSED) {
                if (c == KeyEvent.VK_W) {
                    KeyActions.w_pressed();
                }
                if (c == KeyEvent.VK_S) {
                    //KeyActions.movedown();
                }
                if (c == KeyEvent.VK_A) {
                    KeyActions.a_pressed();
                }
                if (c == KeyEvent.VK_D) {
                    KeyActions.d_pressed();
                }
                if (c == KeyEvent.VK_P) {
                    KeyActions.p_pressed();
                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KEYS_PRESSED.add(e.getKeyCode());

    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        KEYS_PRESSED.remove(e.getKeyCode());
    }

}
