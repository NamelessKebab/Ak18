/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

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
            Var.moveup = true;

            System.out.println("teeeetst");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Var.movedown = true;
            KeyActions.movedown();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Var.moveleft = true;
            KeyActions.moveleft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Var.moveright = true;
            KeyActions.moveright();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            Var.pause = true;
            KeyActions.pause();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) { // losgelassen wird
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Var.moveup = false;
            KeyActions.moveup();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Var.moveup = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Var.moveup = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Var.moveup = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            Var.pause = false;

        }

    }

}
