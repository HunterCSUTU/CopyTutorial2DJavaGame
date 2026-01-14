package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //We dont use this. But we need these three methods for the class.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //each key on the keyboard has an int code assigned to it

        if (code == KeyEvent.VK_W) { // KeyEvent represents a keyboard action (press/release/type), not the key itself
        /*
        KeyEvent e;            // event object
        e.getKeyCode();        // returns an int (like 87)
        KeyEvent.VK_W;         // named constant to compare against

        the KeyEvent object e is made as a key is pressed. We get the code and compare it agaist
        a Constant that the KeyEvent object holds. The KeyEvent class has a bunch of Constants (VK_W  etc)
        */

        /*
        VK = "Virtual Key"
        KeyEvent.VK_* constants represent physical keys on the keyboard,
        not the characters they produce.

        Example:
        - KeyEvent.VK_W → the W key
        - 'w'           → the character w

        This is why movement input uses VK_* instead of raw int values or characters.
        */

        }

        if (code == KeyEvent.VK_S) {

        }
        if (code == KeyEvent.VK_A) {

        }
        if (code == KeyEvent.VK_D) {

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
