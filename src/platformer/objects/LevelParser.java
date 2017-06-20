/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.yaml.snakeyaml.Yaml;
import platformer.data.Level;

/**
 *
 * @author Julian Blazek
 */
public class LevelParser {

    private Yaml yaml = new Yaml();
    private Object level;
    private Level lvlobject;
    private File leveldat;

    public Level readLevel() {
        lvlobject = new Level();
        Object load = null;
        try {
            load = yaml.load(new FileInputStream(leveldat));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LevelParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Map map = (Map) load;

        ReadMeta((Map) map.get("meta"));
        ReadPlayer((Map) map.get("player"));
        ReadBlocks((Map) map.get("blocks"));

        return lvlobject;
    }

    public void writeLevel(Level level) {

        lvlobject = level;
        FileWriter writer = null;
        try {
            writer = new FileWriter(leveldat);
        } catch (IOException ex) {
            Logger.getLogger(LevelParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Map map = new HashMap();
        Map metaMap = WriteMeta();
        Map playerMap = WritePlayer();
        Map blockMap = WriteBlocks();
        map.put("meta", metaMap);
        map.put("player", playerMap);
        map.put("blocks", blockMap);
        try {
            writer.write(yaml.dump(map));
        } catch (IOException ex) {
            Logger.getLogger(LevelParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(LevelParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LevelParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public LevelParser(File leveldatei) {
        leveldat = leveldatei;
        lvlobject = new Level();
    }

    private void ReadPlayer(Map player) {
        Map spawn = (Map) player.get("spawn");
        int X = (int) spawn.get("X");
        int Y = (int) spawn.get("Y");
        lvlobject.setPlayer(new Player(X, Y, 20, 20, null));

    }

    private void ReadBlocks(Map blocks) {
        ArrayList<Objekt> blockliste = new ArrayList();
        for (Object blockname : blocks.keySet()) {
            Map blockdata = (Map) blocks.get(blockname);
            BufferedImage Sprite = null;
            Color color = null;
            if (blockdata.get("Sprite") != null) {
                try {
                    Sprite = ImageIO.read(getClass().getResource((String) blockdata.get("Sprite")));
                } catch (Exception ex) {
                    System.out.println("Konnte Resource nicht laden: " + blockdata.get("Sprite"));
                }
            }
            if (blockdata.containsKey("Color")) {
                color = new Color((int) blockdata.get("Color"));
            }
            ArrayList positionlist = (ArrayList) blockdata.get("positions");
            for (Object position : positionlist) {
                ArrayList pos = ((ArrayList) position);
                int X = (int) pos.get(0);
                int Y = (int) pos.get(1);
                int W = (int) pos.get(2);
                int H = (int) pos.get(3);
                if (Sprite == null) {
                    blockliste.add(new Bloecke(X, Y, W, H, color));
                } else {
                    blockliste.add(new Bloecke(X, Y, W, H, Sprite));
                }

            }

        }
        lvlobject.setObjekte(blockliste);
    }

    private void ReadMeta(Map meta) {
        lvlobject.setLvlname((String) meta.get("name"));
        int lvlwidth = (int) meta.get("width");
        int lvlheigth = (int) meta.get("height");
        lvlobject.setSize(new Dimension(lvlwidth, lvlheigth));
    }

    private Map WriteMeta() {
        Map map = new HashMap();
        map.put("name", lvlobject.getLvlname());
        map.put("width", lvlobject.getSize().width);
        map.put("height", lvlobject.getSize().height);

        return map;
    }

    private Map WritePlayer() {
        Map map = new HashMap();
        Player playerobj = lvlobject.getPlayer();
        Map spawnmap = new HashMap();
        spawnmap.put("X", playerobj.getX());
        spawnmap.put("Y", playerobj.getY());
        spawnmap.put("Sprite", null);
        map.put("spawn", spawnmap);
        return map;
    }

    private Map WriteBlocks() {
        Map map = new HashMap();
        ArrayList<Objekt> blockliste = lvlobject.getObjekte();
        for (Objekt block : blockliste) {
            Map blockmap = new HashMap();
            if (block.getCOLOR() != null) {
                blockmap.put("Color", block.getCOLOR().getRGB());
            }
            List blocklist = new ArrayList();
            List positions = new ArrayList();
            positions.add(block.getX());
            positions.add(block.getY());
            positions.add(block.getWIDTH());
            positions.add(block.getHEIGHT());
            blocklist.add(positions);
            blockmap.put("positions", blocklist);
            String uuid = String.valueOf(UUID.randomUUID());
            map.put(uuid, blockmap);
        }
        return map;
    }
}
