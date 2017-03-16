/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.physics;

import platformer.core.Player;

/**
 *
 * @author Julian Blazek
 */
public class PlayerPhysics {
    
    public static void update(platformer.core.Player player, double ortsfaktor, double deltaTime){
        int alty,y;
        double ySpeed;
        alty = player.getY();
        ySpeed = player.getySpeed() + ortsfaktor * deltaTime;
        player.setySpeed(ySpeed);
        y = (int) (player.getY() + player.getySpeed() * deltaTime);
        player.setY(y);
        if(y > 550) player.setY(alty);
        System.out.println("Y: "+y+" ySpeed: "+ySpeed);
    }

    public static void springe(Player play) {
        play.setySpeed(-100);
    }
    
}
