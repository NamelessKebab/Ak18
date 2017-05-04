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

    @Override
    public void keyTyped(KeyEvent e) { // gedrückt und wieder losgelassen wird

    }

    @Override
    public void keyPressed(KeyEvent e) { // gehalten wird

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Var.setMoveup(true);

            System.out.println("teeeetst");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Var.setMovedown(true);
            KeyActions.movedown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Var.setMoveleft(true);
            KeyActions.moveleft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Var.setMoveright(true);
            KeyActions.moveright();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            Var.setPause(true);
            KeyActions.pause();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) { // losgelassen wird
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Var.setMoveup(false);
            KeyActions.moveup();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Var.setMoveup(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Var.setMoveup(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Var.setMoveup(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            Var.setPause(false);

        }

    }

}
