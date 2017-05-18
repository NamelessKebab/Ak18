/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.data;

import java.util.ArrayList;
import platformer.objects.Objekt;
import platformer.objects.Player;

/**
 *
 * @author Julian Blazek
 */
public class Level {
    private ArrayList<Objekt> objekte = new ArrayList<Objekt>();
    private String lvlname;

    private Player player;
    
    public Blocks bloecke;

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
    
    public class Blocks {

        private ArrayList<Objekt> bloecke;

        public Blocks() {
            bloecke = new ArrayList<>();
        }

        public void addBlock(Objekt obj) {
            bloecke.add(obj);
        }

        public ArrayList<Objekt> getBloecke() {
            return bloecke;
        }
    }
}
