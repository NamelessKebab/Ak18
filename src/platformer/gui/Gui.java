/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.gui;

import javax.swing.JFrame;
import platformer.core.KeyHandler;
import platformer.data.Var;

/**
 *
 * @author Florian Rost
 */
public class Gui extends JFrame { //Spielfenster

    public Gui() {
        init();
    }

    private void init() {
        setSize(Var.getScreenwidth(), Var.getScreenheight()); // GUI breite und dicke
        setLocationRelativeTo(null);//Objekt wird in die Mitte geschoben      
        setVisible(false);
        setLayout(null);
        setTitle("Jump and Run");
        setResizable(false);
        requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Var.setLbl1(new GamePanel());
        Var.getLbl1().setBounds(0, 0, Var.getScreenwidth(), Var.getScreenheight());

        add(Var.getLbl1());
        addKeyListener(new KeyHandler());
        Var.getLbl1().setVisible(true);
    }
}
