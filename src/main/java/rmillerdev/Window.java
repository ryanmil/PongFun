package rmillerdev;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static final Integer WIDTH = 500;
    public static final Integer HEIGHT = 500;
    public static final Keyboard KEYBOARD = new Keyboard();

    public Window() {
        super("Testing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(KEYBOARD);
    }

}
