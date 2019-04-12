import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {

    private FlappyGhost view;
    private Player ghost;
    private static double time;
    private LinkedList<Obstacle> ObstacleList;

    public Controller(FlappyGhost view) {
        this.view = view;
        this.ghost = new Player(FlappyGhost.SCENEWIDTH / 2 - 30, FlappyGhost.BGHEIGHT / 2);
        ObstacleList = new LinkedList();
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

    public static double getTime() {
        return time;
    }

    public void manageObstacles(double dt) {
        time += dt;
        if (((long) time) % 3 == 0 && ((long) (time - dt)) % 3 != 0) {
            ObstacleList.add(Obstacle.newObstacle(-ghost.getVx()));
        }

        for (int i = 0; i < ObstacleList.size(); i++) {
            ObstacleList.get(i).update(dt);
            draw(ObstacleList.get(i));
            if (ObstacleList.get(i).getX() + 100 < 0) {
                ObstacleList.remove(i);
            }
            if (ghost.intersects(ObstacleList.get(i))) {
                System.out.println("yolo");
            }
        }


    }

    public void draw(Obstacle obstacle) {
        if (view.isModeDebug()) {

        } else {
            view.getContext().drawImage(obstacle.getImg(), obstacle.getX(), obstacle.getY());
        }
    }


    public void handleSpace(Scene scene) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ((event.getCode()) == KeyCode.SPACE) {
                    ghost.jump();
                }
            }
        });
    }

    }


