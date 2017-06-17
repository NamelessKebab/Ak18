/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import platformer.data.Var;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * TimerClass.java Zweck: Erzeugt einen Timer und steuert mit diesem die Klasse
 * TimerActionPerformed an welche das Spiel am laufen hält.
 *
 * @author Julian Blazek
 * @version 1.0 13.03.2017
 */
public class TimerClass {

    Timer timer;

    public TimerClass() {
        timer = new Timer(18, new TimerActionPerformed());
        timer.start();
    }

}

class TimerActionPerformed implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Var.setOldTime(Var.getNewTime());
        Var.setNewTime(System.nanoTime());
        KeyHandler.processKeys();
        if (Var.isGameStarted()) {
            platformer.physics.PlayerPhysics.update(Var.getPlay(), 50, diffTime());
        }
        platformer.data.Var.getLbl1().repaint();
    }

    private double diffTime() {
        return (Var.getNewTime() - Var.getOldTime()) / (1 * (Math.pow(10, 9)));
    }
}
