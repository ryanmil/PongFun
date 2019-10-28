package rmillerdev;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main( String[] args )
    {
        Window window = new Window();
        App app = new App();

        window.add(app);
        window.setVisible(true);

        app.run();
    }

}
