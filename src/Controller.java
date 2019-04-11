import javafx.event.EventHandler;
import javafx.scene.control.Control;
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

    private FlappyGhost view;
    private Player ghost;

    public Controller(FlappyGhost view) {
        this.view = view;
        this.ghost = new Player(FlappyGhost.SCENEWIDTH / 2 - 30, FlappyGhost.BGHEIGHT / 2);
    }

    public Player getGhost() {
        return this.ghost;
    }

    public void draw(Player ghost) {
        if (view.isModeDebug()) {

        } else {
            view.getContext().drawImage(ghost.getImg(), ghost.getX(), ghost.getY());
        }
    }

    public void draw(Obstacle obstacle) {

    }

  //  public void handleSpace(Scene scene) {

   //     scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
   //         @Override
    //        public void handle(KeyEvent event) {
    //            if ((event.getCode()) == KeyCode.SPACE) {
    //                ghost.jump();
    //            }
     //       }
     //   });


    }


