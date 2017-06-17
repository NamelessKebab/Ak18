/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import platformer.data.Var;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Florian Rost & Julian Blazek
 */
public class KeyHandler implements KeyListener {

    static void processKeys() {
        if (Var.KeysPressed.size() > 0) {
            for (int c : Var.KeysPressed) {
                if (c == KeyEvent.VK_W) {
                    Var.setMoveup(true);
                    KeyActions.moveup();
                }
                if (c == KeyEvent.VK_S) {
                    Var.setMovedown(true);
                    KeyActions.movedown();
                }
                if (c == KeyEvent.VK_A) {
                    Var.setMoveleft(true);
                    KeyActions.moveleft();
                }
                if (c == KeyEvent.VK_D) {
                    Var.setMoveright(true);
                    KeyActions.moveright();
                }
                if (c == KeyEvent.VK_P) {
                    Var.setPause(true);
                    KeyActions.pause();
                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) { // gedrückt und wieder losgelassen wird

    }

    @Override
    public void keyPressed(KeyEvent e) { // gehalten wird
        Var.KeysPressed.add(e.getKeyCode());

    }

    @Override
    public synchronized void keyReleased(KeyEvent e) { // losgelassen wird
        Var.KeysPressed.remove(e.getKeyCode());
    }

}
