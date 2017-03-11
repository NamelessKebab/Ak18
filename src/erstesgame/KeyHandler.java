/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author Florian Rost
 */
public class KeyHandler implements KeyListener {

@Override 
public void keyTyped(KeyEvent e){ // gedrückt und wieder losgelassen wird
   
   }

@Override    
public void keyPressed(KeyEvent e){ // gehalten wird

    if (e.getKeyCode()==KeyEvent.VK_UP){
Var.moveup = true;
}
    if (e.getKeyCode()==KeyEvent.VK_DOWN){
Var.movedown = true;
}
    if (e.getKeyCode()==KeyEvent.VK_LEFT){
Var.moveleft = true;
}
    if (e.getKeyCode()==KeyEvent.VK_RIGHT){
Var.moveright = true;
}

}    


@Override 
public void keyReleased(KeyEvent e){ // hochgelassen wird
if (e.getKeyCode()==KeyEvent.VK_UP){
Var.moveup = false;
}

if (e.getKeyCode()==KeyEvent.VK_DOWN){
Var.moveup = false;
}

if (e.getKeyCode()==KeyEvent.VK_LEFT){
Var.moveup = false;
}

if (e.getKeyCode()==KeyEvent.VK_RIGHT){
Var.moveup = false;
}


}


}


