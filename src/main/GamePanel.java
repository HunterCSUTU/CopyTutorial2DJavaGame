package main;

import javax.swing.*;
import java.awt.*;
/* (instead of import javax.swing.JPanel
Wildcard imports are resolved at compile time
Important misconception:
        * does not import “everything into memory”
It just tells the compiler:
        “If you see an unknown class name, check this package.”
No performance hit. No runtime cost. */

public class GamePanel extends JPanel implements Runnable { //inherets from JPanel
    //screen settings
    final int originalTileSize = 16;  //16x16 tile.  and final int is like a const
    //but modern computers have higher resolution so 16x16 looks small on the screen. So we scale.
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //now it will look 48x48. much bigger on screen

        //how many tiles can be displayed on a single screen? Horizontal and vertical.
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    //create Constructor of GamePanel
    /* 
     * This constructor runs automatically when a GamePanel object is created using `new`.
     * It initializes the panel’s starting state, such as size, background, and settings.
    */
    
    Thread gameThread;  //the game "clock",  FPS

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight)); // "this" = this object (the current GamePanel)
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //enabling this improves the Games rendering
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() { //gameloop
        while (gameThread != null) {
            //System.out.println("The gameloop is running");
            //Update: update information such as character position
            //Draw: Draw the screen to reflect updated information
        }
    } 
    
    public void update() {}
    public void paintComponent() {}



}
