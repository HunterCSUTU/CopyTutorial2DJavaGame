package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            //ImageIO.read(InputStream).  ImageIO.read() is a static method that takes an InputStream and returns a BufferedImage
            /*
             * Loading an image from the classpath:
             *
             * getClass() → gets the Class object of this current class (TileManager).
             *               This is used as a reference point for finding resources.
             *
             * "/player/boy_up1.png" → the path to the image starting from the root of the classpath.
             *                          The leading '/' tells Java to ignore the package of this class
             *                          and look from the top of the classpath.
             *
             * The JVM doesn’t care where TileManager.class is in the folder structure.
             * It uses the ClassLoader of the class to locate the resource inside the classpath.
             *
             * So even if the images are in a separate 'res' folder, as long as they are included
             * in the classpath, this will correctly load the image.
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try{
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // Load a text file from the classpath as bytes (InputStream), convert it to characters(InputStreamReader),
            // then wrap it in a BufferedReader so we can read it line-by-line (BufferedReader).

            int col = 0;
            int row = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine(); //readLine() is method of BufferedReader class.
                while (col < gp.maxScreenCol) {
                    String[] numbers = line.split(" "); //java does have a char datatype too. But I'm assuming there is a reason for the String datatype.
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){

        }

    }
    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }

        //g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[1].image, (gp.tileSize * 1), 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[2].image, (gp.tileSize * 2), 0, gp.tileSize, gp.tileSize, null);
        //This is not an efficient way to draw tiles. We need a better tile drawing system.
    }


}



