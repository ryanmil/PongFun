package rmillerdev;

import java.awt.*;

public class Ball {

    private Float posX = 250f;
    private Float posY = 250f;

    private Float velX = 3f;
    private Float velY = 3f;

    private Integer size = 20;


    public Ball() {

    }

    public float getPosX() {
        return posX;
    }

    public void update(Paddle paddle1, Paddle paddle2) {
        posX += velX;
        posY += velY;

        if (posY < 0f) {
            velY *= -1f;
            posY = 0f;
        }
        if (posY > Window.HEIGHT - size * 2) {
            velY *= -1f;
            posY =  (float)Window.HEIGHT - size * 2;
        }

        collide(paddle1);
        collide(paddle2);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(posX.intValue(), posY.intValue(), size, size);
    }

    private void collide(Paddle paddle) {

        float cirLeft = posX;
        float cirRight = posX + size;
        float cirTop = posY;
        float cirBot = posY + size;


        float padLeft = paddle.getPosX();
        float padRight = paddle.getPosX() + paddle.getWidth();
        float padTop = paddle.getPosY();
        float padBot = paddle.getPosY() + paddle.getHeight();

        boolean horizontal = (cirRight < padRight && cirRight > padLeft) || (cirLeft < padRight && cirLeft > padLeft);
        boolean vertical =   (cirBot < padBot && cirBot > padTop) || (cirTop < padBot && cirTop > padTop);

        if(horizontal && vertical) {

            float delta = 0;
            if(velX > 0) {
                delta = posX - (padLeft - size);
            } else {
                delta = posX - padRight;
            }
            System.out.println(Math.abs(delta));
            if(Math.abs(delta) < 10) {
                if (velX > 0) {
                    posX = padLeft - size;

                } else {
                    posX = padRight;
                }

                float ratio = padTop + ((padBot - padTop) / 2f);
                ratio = ratio - (cirTop + ((cirBot - cirTop) / 2f));
                ratio = ratio / ((padBot - padTop) / 2f);

                //System.out.println((Math.abs(ratio) / 2) + .75f);

                velX *= -1f * ((Math.abs(ratio) / 2) + .75f);
                velY -= 2f * ratio;
            }
        }
    }
}
