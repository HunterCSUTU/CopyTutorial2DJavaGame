package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2d Adventure");
	      
        GamePanel gamePanel = new GamePanel();
	    window.add(gamePanel);
        /*
        JFrame is the window.
        JPanel (gamePanel inherits from JPanel) is the drawable surface inside the window.

        Adding the JPanel to the JFrame makes it a child component.
        The JFrame handles the window,
        and the JPanel handles rendering the game.
        */

        window.pack(); //window fits gamePanel size

        window.setLocationRelativeTo(null); //centers on screen
        window.setVisible(true); //“Show this window to the user right now.”. This prevents half-built UI from flashing on screen.
        //gamePanel.requestFocusInWindow(); chatgpt told me to do this but it didnt work.
        gamePanel.startGameThread();

    }
}
