import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
FlappyGhost.scene.addEventHandler(KeyEvent.KEY_PRESSED,(key)->

    {
        if (key.getCode() == KeyCode.SPACE) {
            Player.jump();
        }
    });

}
