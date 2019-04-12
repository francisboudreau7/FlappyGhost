import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {

    private FlappyGhost view;
    private Player ghost;
    private static double time;
    private ArrayList<Obstacle> ObstacleList;

    public Controller(FlappyGhost view) {
        this.view = view;
        this.ghost = new Player(FlappyGhost.SCENEWIDTH / 2 - 30, FlappyGhost.BGHEIGHT / 2);
        ObstacleList = new ArrayList<>();
    }

    public Player getGhost() {
        return this.ghost;
    }

    public void draw(Entity entity) {//Universal entity drawing method
        if (view.isModeDebug()) {

            if (entity.isIntersected()) {
                view.getContext().setFill(Color.RED);
            } else {
                view.getContext().setFill(Color.YELLOW);
            }

            view.getContext().fillOval(entity.getX(), entity.getY(), entity.getR() * 2, entity.getR() * 2);
        } else {
            view.getContext().drawImage(entity.getImg(), entity.getX(), entity.getY());
        }
    }

    public static double getTime() {
        return time;
    }

    public void manageObstacles(double dt) {//
        time += dt;

        if (((long) time) % 3 == 0 && ((long) (time - dt)) % 3 != 0) {//Adds obstacles each 3 seconds
            ObstacleList.add(Obstacle.newObstacle(-ghost.getVx()));
        }

        for (int i = 0; i < ObstacleList.size(); i++) {//Iterates through each obstacle
            ObstacleList.get(i).update(dt);
            draw(ObstacleList.get(i));

            Boolean intersection = ghost.intersects(ObstacleList.get(i));//checks if intersected and changes
            // intersected attribute
            ghost.setIntersected(intersection);
            ObstacleList.get(i).setIntersected(intersection);

            if (ghost.getX() > ObstacleList.get(i).getX() && !ObstacleList.get(i).isCounted()) {//Updates score if
                // obstacles hasn't been counted
                ghost.updateScore();
                ObstacleList.get(i).setCounted();
                System.out.println(ghost.getScore());
                if (ghost.getScore() % 10 == 0) {//If 2 obstacles have been passed,increments gravity and speed
                    ghost.addAY();
                    ghost.addVX();
                }
            }
            if (ObstacleList.get(i).getX() + 100 < 0) {//If obstacle is out of frame(left), removes the obstacle.
                ObstacleList.remove(i);
            }
        }


    }
    // public void checkIfLost(){
    //    if(ghost.isIntersected()){
    //         restart();
    //     }
    // }


    public void handleSpace(Scene scene) {//add keyboard input functionnality

        scene.setOnKeyPressed(event -> {
            if ((event.getCode()) == KeyCode.SPACE) {
                ghost.jump();
            }
        });
    }

    // public void restart(){//TODO:Broken. Il faut le faire dune autre manière.
    //     ObstacleList= new ArrayList<>();
    //     ghost = new Player(FlappyGhost.SCENEWIDTH / 2 - 30, FlappyGhost.BGHEIGHT / 2);
    //  }


    }


