package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2d Adventure");
        window.setLocationRelativeTo(null); //centers on screen
        window.setVisible(true); //“Show this window to the user right now.”. This prevents half-built UI from flashing on screen.



    }
}