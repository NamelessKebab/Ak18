/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erstesgame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Florian Rost
 */
public class Var  {
  
   
   
    static int screenwidth = 800;
    static int  screenheight = 600;
    static boolean moveup = false;
    static boolean movedown = false;
    static boolean moveleft = false;
    static boolean moveright = false;
    static int backgroundY1 = 0; // bild koordrinate
    static int backgroundY2 = 600; // bild kordianten
    static Label lbl1;
    static JFrame jf1;
    static BufferedImage bProject;  // Die bewegenden HintergrÃ¼nde
    // static BufferedImage bProject2 //2tes bild was ablÃ¤uft
    public Var(){
   //background
       
        try {
            System.out.println(getClass().getResource("/rsc/bProject.png").toString());
            bProject = ImageIO.read(getClass().getResource("/rsc/bProject.png").toURI().toURL()); // Bild wird aus der .jar Datei / dem Quellverzeichnis geladen
          //ib1 = ImageIO.read(new File("rcs/b1.png"));
                 
        } catch (IOException | URISyntaxException e){
            e.printStackTrace();
            System.out.println("Bilder nicht geladen werden");


        }
    
}
}