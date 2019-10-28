package rmillerdev;
import java.awt.*;

public class App extends Canvas
{
    private Boolean running = false;
    private Ball ball = new Ball();
    private Paddle paddle1 = new Paddle(20, 200);
    private Paddle paddle2 = new Paddle(450, 200, true);

    public App() {
        super();
        setSize(400, 400);
    }

    public void run() {
        running = true;
        runLoop();
    }

    private void runLoop() {
        while (running) {
            update(0.0f);

            try { Thread.sleep(15); }
            catch (InterruptedException e) {
                System.out.println("I was interrupted!");
                e.printStackTrace();
            }

            repaint();
        }
    }

    private void update(Float delta) {
        ball.update(paddle1, paddle2);
        paddle1.update();
        paddle2.update();


        if(ball.getPosX() < -20 || ball.getPosX() > Window.WIDTH + 30) {
            ball = new Ball();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 2000, 2000);

        g.setColor(Color.WHITE);
        ball.draw(g);
        paddle1.draw(g);
        paddle2.draw(g);
    }
}
