/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Julian Blazek
 */
public class TimerClass {
    Timer timer;
    public TimerClass() {
        timer = new Timer(17,new TimerActionPerformed());
        timer.start();
    }
    
}

class TimerActionPerformed implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        Var.oldTime = Var.newTime;
        Var.newTime = System.nanoTime();
        if(Var.gameStarted){
            platformer.physics.PlayerPhysics.update(Var.play, 98.1, diffTime());
        }  
        platformer.core.Var.lbl1.repaint();
    }
    private double diffTime(){
        return  (Var.newTime - Var.oldTime)/(1*(Math.pow(10, 9)));
    }
}
