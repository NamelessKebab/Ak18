/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //erstesgame.Player.update();
        erstesgame.Var.lbl1.repaint();
    }

}
