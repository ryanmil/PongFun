package rmillerdev;

import org.w3c.dom.events.Event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private Boolean wPressed = false;
    private Boolean sPressed = false;
    private Boolean oPressed = false;
    private Boolean lPressed = false;

    public Keyboard() {

    }

    public Boolean wPressed() {
        return wPressed;
    }
    public Boolean sPressed() {
        return sPressed;
    }
    public Boolean oPressed() {
        return oPressed;
    }
    public Boolean lPressed() {
        return lPressed;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            sPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_O) {
            oPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            lPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            wPressed = false;
        }
        if (e.getKeyChar() == 's') {
            sPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_O) {
            oPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_L) {
            lPressed = false;
        }
    }
}
