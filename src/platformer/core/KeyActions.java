/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import platformer.physics.PlayerPhysics;

/**
 *
 * @author Julian Blazek
 */
public class KeyActions {

    static void moveup() {
        PlayerPhysics.springe(Var.play);
    }

    static void movedown() {
        Var.play.setY(Var.play.getY()+3);
    }

    static void moveleft() {
        Var.play.setX(Var.play.getX()-3);
    }

    static void moveright() {
        Var.play.setX(Var.play.getX()+3);
    }
    
}
