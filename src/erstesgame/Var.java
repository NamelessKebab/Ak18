/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Florian Rost
 */
public class Var {
   static JFrame jf1;
    static int screenwidth = 800;
    static int  screenheight = 600;
    static boolean moveup = false;
    static boolean movedown = false;
    static boolean moveleft = false;
    static boolean moveright = false;
    static int backgroundY1 = 0; // bild koordrinate
    static int backgroundY2 = 600; // bild kordianten
    static Label lbl1;
    static BufferedImage bProject;  // Die bewegenden Hintergründe
    // static BufferedImage bProject2 //2tes bild was abläuft
    public Var(){
   //background
       
        try {
            
            bProject = ImageIO.read(new File("rsc/bProject.png"));
          //ib1 = ImageIO.read(new File("rcs/b1.png"));
                 
} catch (IOException e){
    e.printStackTrace();
    System.out.println("Bilder nicht geladen werden");


}
    
}
}