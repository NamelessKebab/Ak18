/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import platformer.data.Var;
import platformer.gui.NewGUIPause;
import platformer.physics.PlayerPhysics;

/**
 *
 * @author Julian Blazek
 */
public class KeyActions {

    static void moveup() {
        PlayerPhysics.springe(Var.getPlay());
    }

    static void movedown() {
        Var.getPlay().setY(Var.getPlay().getY() + 3);
    }

    static void moveleft() {
        Var.getPlay().setX(Var.getPlay().getX() - 3);
    }

    static void moveright() {
        Var.getPlay().setX(Var.getPlay().getX() + 3);
    }

    static void pause() {
        new NewGUIPause().setVisible(true);

    }

}
