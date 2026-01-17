package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
/*
These are:
    instance variables (fields)
    they live inside the Player object
    they are references, not objects
    You dont see "GamePanel gp = new GamePanel()" do you? No.
At this point:
    no GamePanel object is created
    no KeyHandler object is created
    space is reserved to store a reference later
 */

    //constructors don't have return types.
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if (keyH.upPressed == true) {
            y -= speed;
        }
        else if (keyH.downPressed) {
            y += speed;
        }
        else if (keyH.leftPressed) {
            x -= speed;
        }
        else if (keyH.rightPressed) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize); //player rn
    }

}
