/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

/**
 * Image.java
 * Zweck: Eine Klasse mit Tools für Bilder.
 * 
 * @author Julian Blazek
 * @version 1.0 14.03.2017
 */
public class Image {
    /**
     * Gebe ein Bild abhängig von einem Pfad zurück.
     * 
     * @param path Pfad zur Bild-Datei
     * @return Gibt das Bild als BufferedImage zurück
     * @throws URISyntaxException
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static BufferedImage getImage(String path) throws URISyntaxException, MalformedURLException, IOException{
        return ImageIO.read(Image.class.getResource(path).toURI().toURL()); 
    }
    
}
