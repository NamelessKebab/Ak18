/*
 * To change this license header, choose License Headers in Project properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformereditor;

import platformer.objekte.Level;
import platformer.objekte.Player;
import platformer.objekte.Objekt;
import platformer.objekte.Bloecke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import platformer.LevelParser;
import platformer.objekte.Ziel;

/**
 * Editor.java Zweck: Die Steuerungsklasse des Editors.
 *
 * @author Flo & Julian
 */
public class Editor {

    private EditorGUI GUI;
    private PropsGUI properties;
    private LevelPropsGUI levelProperties;
    private Level currentLevel = new Level();
    private Objekt selectedObj;

    /**
     * Falls "alleinstehend" aufgerufen, so startet der Editor.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        setLaF();
        new Editor();
    }

    /**
     * Zeigt einen JFileChooser Dialog und gibt die darin gewählte *.png Datei
     * als File Objekt zurück.
     *
     * @return File Objekt: repräsentiert Ort der Spritedatei
     */
    static File openSprite() {
        JFileChooser chooser = new javax.swing.JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Sprites (*.png)", "png"); // Dateifilter
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) { // Wenn "Öffnen" gedrückt, sonst return null
            return chooser.getSelectedFile();
        }
        return null;
    }

    /**
     * Methode die aufgerufen wird, falls im Menü auf Öffnen oder Strg+O
     * gedrückt wird.
     */
    void openClicked() {
        JFileChooser chooser = new javax.swing.JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Level Dateien (*.lvl)", "lvl"); // Dateifilter
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) { // Wenn "Öffnen" gedrückt
            File leveldatei = chooser.getSelectedFile();
            currentLevel = readLevel(leveldatei);
        }
        refreshLevelPropsValues(); // Aktualisiert die "Leveleinstellungen" im Einstellungsfenster.
        GUI.setPanelSize(currentLevel.getSize());
        GUI.reRender();

    }

    /**
     * Zeichnet das Level im gegeben Grafikkontext
     *
     * @param g2d Grafikkontext
     */
    public void Render(Graphics2D g2d) {
        ArrayList<Objekt> objects = currentLevel.getObjekte();
        for (Objekt objekt : objects) {
            g2d.setColor(objekt.getCOLOR());
            if (objekt.getSPRITE() == null) {
                g2d.fillRect(objekt.getX(), objekt.getY(), objekt.getWIDTH(), objekt.getHEIGHT());
            } else {
                g2d.drawImage(objekt.getSPRITE(), objekt.getX(), objekt.getY(), objekt.getWIDTH(), objekt.getHEIGHT(), null);
            }

        }
        Player player = currentLevel.getPlayer();
        if (player.getSPRITE() != null) {
            g2d.drawImage(player.getSPRITE(), player.getX(), player.getY(), player.getWIDTH(), player.getHEIGHT(), null);
        } else {
            g2d.setColor(player.getCOLOR());
            g2d.fillRect(player.getX(), player.getY(), player.getHEIGHT(), player.getWIDTH());
        }
    }

    /**
     * Liest ein Level und gibt die Datei zurück.
     *
     * @param leveldatei
     * @return levelobjekt
     */
    private Level readLevel(File leveldatei) {
        LevelParser parser = new LevelParser(leveldatei);
        Level level = parser.readLevel();
        return level;
    }

    /**
     * Konstruktor des Editors der die Einstellungsfenster und die GUI erzeugt
     * und ein neues Level generiert.
     */
    public Editor() {
        init();
        newClicked();
        updateProps();
    }

    /**
     * Setzt das Nimbus Look and Feel
     */
    private static void setLaF() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Erstellt die GUI und die Einstellungsfenster
     */
    private void init() {
        GUI = new EditorGUI(this);
        GUI.setVisible(true);
        properties = new PropsGUI(this);
        properties.setVisible(true);
        levelProperties = new LevelPropsGUI(this);
        levelProperties.setVisible(true);
    }

    /**
     * Wird aufgerufen wenn auf das Panel auf der GUI geklickt wird.
     *
     * @param evt
     */
    public void panelClicked(MouseEvent evt) {
        if (SwingUtilities.isLeftMouseButton(evt)) { // Linker Mausbutton?
            Point clickedPoint = new Point(evt.getX(), evt.getY());
            ArrayList<Objekt> objects = currentLevel.getObjekte();
            if (GUI.getRightClickMenuStatus() == 1) { // Hinzufügen?
                Objekt obj = addObjekt(evt);
                if (obj != null) {
                    objects.add(obj);
                }
            } else {
                for (Objekt objekt : objects) {
                    if (objekt.getREKT().contains(clickedPoint)) {
                        if (GUI.getRightClickMenuStatus() == 3) { // Entfernen?
                            objects.remove(objekt);
                        }
                        if (GUI.getRightClickMenuStatus() == 2) { // Auswählen?
                            selectedObj = objekt; // Setzt ausgewähltes Objekt
                            properties.setXYEnabled(true);
                            properties.setUpdateEnabled(true);
                        }
                        break;
                    }
                }
            }
            currentLevel.setObjekte(objects);
            GUI.reRender();
        }

        if (SwingUtilities.isRightMouseButton(evt)) { // Rechter Mausbutton?
            GUI.showRightClickMenu(evt);
        }
    }

    /**
     * Öffnet Objekteinstellungen erneut
     */
    public void openProps() {
        properties.dispose();
        properties.pack();
        properties.setVisible(true);
    }

    /**
     * Konstruiert das gewünschte Objekt aus den Daten des Einstellungsfenster
     * und der Typ Auswahl
     *
     * @param evt
     * @return Objekt
     */
    private Objekt addObjekt(MouseEvent evt) {
        if (properties.error) { // Falls ein Feld einen Fehler aufweist
            return null;
        }
        int x, y;
        /*
         * Liest die Dazen aus dem Eigenschaften Fenster. 
         */
        if (properties.getXYEnabled()) {
            x = properties.getXProp();
            y = properties.getYProp();
        } else {
            x = evt.getX();
            y = evt.getY();
        }
        int width = properties.getWidthProp();
        int height = properties.getHeightProp();
        Color color = properties.getColor();
        Boolean solid = properties.getSolid();
        BufferedImage sprite = properties.getSprite();
        Objekt obj = null;
        int type = GUI.getRightClickMenuTypeStatus();
        switch (type) {
            case 1: // Spieler
                currentLevel.setPlayer(new Player(x, y, width, height, sprite));
                break;
            case 2: // Block
                if (sprite != null) {
                    obj = new Bloecke(x, y, width, height, true, true, sprite);
                } else {
                    obj = new Bloecke(x, y, width, height, solid, false, color);
                }
                break;
            case 3: // Ziel
                if (sprite != null) {
                    obj = new Ziel(x, y, width, height, sprite);
                } else {
                    obj = new Ziel(x, y, width, height, color);
                }
                break;
            default:
                break;
        }

        return obj;
    }

    /**
     * Ruft einen JFileChooser auf und speichert das Level in der Gewählten
     * Datei.
     */
    void saveClicked() {
        JFileChooser chooser = new javax.swing.JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Level Dateien (*.lvl)", "lvl"); // Dateifilter
        chooser.setFileFilter(filter);
        int option = chooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) { // "Speichern" gedrückt
            File leveldatei = chooser.getSelectedFile();
            String fname = leveldatei.getAbsolutePath();

            if (!fname.endsWith(".lvl")) { // Falls die Endung nicht besteht wird sie angefügt
                leveldatei = new File(fname + ".lvl");
            }
            LevelParser parser = new LevelParser(leveldatei);
            parser.writeLevel(currentLevel); // Schreibt das Level in die Datei
        }
    }

    /**
     * Erstellt ein neues Level
     */
    void newClicked() {
        currentLevel = new Level();
        currentLevel.setPlayer(new Player(0, 0, 20, 20, null));
        currentLevel.setSize(new Dimension(800, 600));
        currentLevel.setLvlname("Neues Level");
        GUI.setPanelSize(currentLevel.getSize());
        GUI.reRender();
    }

    /**
     * Hat man nicht Block ausgewählt so kann man das Objekt auch nicht massiv
     * setzen. -> Die Checkbox "Solid" wird deaktiviert.
     */
    void updateProps() {
        int status = GUI.getRightClickMenuTypeStatus();
        if (status == 1 || status == 3) {
            properties.setSolidEnabled(false);
        } else {
            properties.setSolidEnabled(true);
        }
    }

    /**
     * Falls "Auswählen" nicht mehr als Aktion gewählt ist, so wird die Kopie
     * des ausgewählten Objekts gelöscht und der Button "Setze eigenschaften"
     * wieder deaktiviert.
     */
    void checkAuswaehl() {
        int status = GUI.getRightClickMenuStatus();
        if (status != 2) {
            selectedObj = null;
            properties.setUpdateEnabled(false);
        }
    }

    /**
     * Wird durch den Buttonklick "Setze Eigenschaften" aufgerufen und
     * aktualisiert das Gewählte Objekt.
     */
    void updateBlockPerformed() {
        if (properties.error) {
            return;
        }
        ArrayList<Objekt> objekte = currentLevel.getObjekte();
        int index = objekte.indexOf(selectedObj); // Index des Objekts im Objekte-Array
        int x, y;
        if (properties.getXYEnabled()) {
            x = properties.getXProp();
            y = properties.getYProp();
        } else {
            return;
        }
        int width = properties.getWidthProp();
        int height = properties.getHeightProp();
        Color color = properties.getColor();
        Boolean solid = properties.getSolid();
        BufferedImage sprite = properties.getSprite();

        selectedObj.setX(x);
        selectedObj.setY(y);
        selectedObj.setHEIGHT(height);
        selectedObj.setWIDTH(width);
        selectedObj.setCOLOR(color);
        selectedObj.setSPRITE(sprite);
        selectedObj.setIsSolid(solid);
        objekte.set(index, selectedObj); // Objekt wird an Index mit neuem Objekt ersetzt
        currentLevel.setObjekte(objekte);
        selectedObj = null;
        properties.setUpdateEnabled(false); // Deaktiviert wieder den "Setze Eigenschaften" Button
        GUI.reRender();
    }

    /**
     * Öffnet Leveleinstellungen erneut
     */
    void openLevelProps() {
        levelProperties.dispose();
        levelProperties.pack();
        levelProperties.setVisible(true);
    }

    /**
     * Aktualisiert das Level mit den Daten aus dem Level-Eigenschaften Fenster
     */
    void updateLevel() {
        if (levelProperties.error) {
            return;
        }
        int width = levelProperties.getWidthProp();
        int height = levelProperties.getHeightProp();
        int gravity = levelProperties.getGravity();
        int jump = levelProperties.getJump();
        Dimension size = new Dimension(width, height);
        currentLevel.setSize(size);
        currentLevel.getPlayer().setGravity(gravity);
        currentLevel.getPlayer().setSprungStaerke(jump);
        GUI.setPanelSize(currentLevel.getSize());
        GUI.reRender();
        levelProperties.dispose(); // Schließt das Level-Eigenschaften Fenster
    }

    /**
     * Aktualisiert die Daten im Level-Eigenschaften Fenster
     */
    private void refreshLevelPropsValues() {
        int width = currentLevel.getSize().width;
        int height = currentLevel.getSize().height;
        int gravity = (int) currentLevel.getPlayer().getGravity();
        int jump = currentLevel.getPlayer().getSprungStaerke();
        levelProperties.setHeightProp(height);
        levelProperties.setWidthProp(width);
        levelProperties.setJumpProp(jump);
        levelProperties.setGravityProp(gravity);
    }

}
