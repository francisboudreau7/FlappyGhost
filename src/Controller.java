import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Controller {

    FlappyGhost view= new FlappyGhost();
    Player ghost = new Player(view.getSceneWidth()/2,view.getSceneHeight()/2);

    public void handleSpace(){

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if((event.getCode())==KeyCode.SPACE) {
                    ghost.jump();
                }
            }
        });

        }
}

