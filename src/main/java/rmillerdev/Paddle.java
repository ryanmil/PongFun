package rmillerdev;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle {

    private Float posX;
    private Float posY;
    Boolean second = false;

    private Integer width = 20;
    private Integer height = 100;

    public Paddle(Integer posX, Integer posY) {
        this.posX = (float)posX;
        this.posY = (float)posY;
    }

    public Paddle(Integer posX, Integer posY, Boolean second) {
        this.posX = (float)posX;
        this.posY = (float)posY;
        this.second = second;
    }

    public void update() {
        if(!second) {
            if (Window.KEYBOARD.sPressed()) {
                posY += 5;
            }
            if (Window.KEYBOARD.wPressed()) {
                posY -= 5;
            }
        } else {
            if (Window.KEYBOARD.oPressed()) {
                posY -= 5;
            }
            if (Window.KEYBOARD.lPressed()) {
                posY += 5;
            }
        }

        if (posY < 5) {
            posY = 5f;
        }
        if (posY > Window.HEIGHT - (height + 25)) {
            posY = (float)Window.HEIGHT - (height + 25);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(posX.intValue(), posY.intValue(), width, height);
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
