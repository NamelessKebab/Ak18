/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objekte;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Level.java Zweck: Definiert den Aufbau eines Level-Objekts. Inhalt: Objekte,
 * Levelname, Größe, Spieler
 *
 * @author Julian Blazek
 */
public class Level implements Serializable{

    static final long serialVersionUID = 3;
    private ArrayList<Objekt> objekte;

    private String lvlname;
    private Dimension size;

    private Player player;

    public Level() {
        this.player = new Player(0, 0, 0, 0, null);
        this.objekte = new ArrayList<>();
    }

    public void setObjekte(ArrayList<Objekt> objekte) {
        this.objekte = objekte;
    }

    public ArrayList<Objekt> getObjekte() {
        return objekte;
    }

    public String getLvlname() {
        return lvlname;
    }

    public void setLvlname(String lvlname) {
        this.lvlname = lvlname;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }
}
