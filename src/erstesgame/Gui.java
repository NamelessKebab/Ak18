/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import javax.swing.JFrame;

/**
 *
 * @author Florian Rost
 */
public class Gui { //Spielfenster
  public Gui(){
  Var.jf1 = new JFrame();
  Var.jf1.setSize(Var.screenwidth, Var.screenheight); // GUI breite und dicke
  Var.jf1.setLocationRelativeTo(null);//Objekt wird in die Mitte geschoben
  Var.jf1.setVisible(false);
  Var.jf1.setLayout(null);
  Var.jf1.setTitle("Jump and Run");
  Var.jf1.setResizable(false);
  Var.jf1.requestFocus();
   
  Var.lbl1 = new Label ();
  Var.lbl1.setBounds(0,0,Var.screenwidth, Var.screenheight);
   Var.jf1.add(Var.lbl1); 
   Var.lbl1.setVisible(true);
         }  

  
  }
