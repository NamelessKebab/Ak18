/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import java.awt.Graphics; // Graphicen werden importiert
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel; // import GUI

/**
 *
 * @author Florian Rost
 */
public class Label extends JLabel { //JLabel wird extendet
   private static final long serialVersionUID = 1L;

 protected void  paintComponent(Graphics g){ //hier drinn können wir zeichnen
 super.paintComponent(g);

Graphics2D g2d = (Graphics2D) g;

g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
g.drawImage(Var.bProject,0 , Var.backgroundY1, 800,600, null); // letzten 3 und 2 die bild pixel
 //g.drawImage(Var.ib1,0 , Var.backgroundY2, null); /7später 2 bild was wiederholt wird
 
 repaint (); // Immer wieder gezeichnet
 }  
   
}
