import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;

public class Controller {

    private FlappyGhost view;
    private Player ghost;
    private static double time;
    private ArrayList<Obstacle> ObstacleList;
    private Background background;
    Boolean restarting = false;


    public Controller(FlappyGhost view) {
        this.view = view;
        this.ghost = new Player(FlappyGhost.SCENEWIDTH / 2 - 30, FlappyGhost.BGHEIGHT / 2);
        ObstacleList = new ArrayList<>();
        background = new Background(FlappyGhost.BGHEIGHT, FlappyGhost.SCENEWIDTH);
    }

    public Player getGhost() {
        return this.ghost;
    }

    public void draw(Entity entity) {//Universal entity drawing method
        if (view.isModeDebug()) {
            if (entity instanceof Obstacle && entity.isIntersected()) {
                view.getContext().setFill(Color.RED);
                view.getContext().fillOval(entity.getX(), entity.getY(), entity.getR() * 2, entity.getR() * 2);
            } else {
                view.getContext().setFill(entity.getColor());
                view.getContext().fillOval(entity.getX(), entity.getY(), entity.getR() * 2, entity.getR() * 2);
            }
        } else {
            view.getContext().drawImage(entity.getImg(), entity.getX(), entity.getY());
        }
    }

    public static double getTime() {
        return time;
    }

    public Background getBackground() {
        return this.background;
    }

    public void manageObstacles(double dt) {//
        time += dt;
        if (!restarting) {
            if (((long) time) % 3 == 0 && ((long) (time - dt)) % 3 != 0) {//Adds obstacles each 3 seconds
                ObstacleList.add(Obstacle.newObstacle(-ghost.getVx()));
            }

            for (int i = 0; i < ObstacleList.size(); i++) {//Iterates through each obstacle
                ObstacleList.get(i).update(dt, -ghost.getVx());
                draw(ObstacleList.get(i));

                Boolean intersection = ghost.intersects(ObstacleList.get(i));//checks if intersected and changes
                // intersected attribute
                ghost.setIntersected(intersection);
                ObstacleList.get(i).setIntersected(intersection);


                if (ghost.getX() > ObstacleList.get(i).getX() && !ObstacleList.get(i).isCounted()) {//Updates score if
                    // obstacles hasn't been counted
                    ghost.updateScore();
                    view.getRightScore().setText("Score: " + ghost.getScore());
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

        } else {
        }

    }

    public void checkIfLost() {
        if (ghost.isIntersected()) {
            restart();
        }
    }


    public void handleKeyboard(Scene scene) {//add keyboard input functionnality

        scene.setOnKeyPressed(event -> {
            if ((event.getCode()) == KeyCode.SPACE) {
                ghost.jump();
            }
            if ((event.getCode()) == KeyCode.ESCAPE) {
                System.exit(0);
            }

        });
    }

    public void handlePause(ToggleButton pause) {
        pause.setOnAction((event) -> {
            if (pause.isSelected()) {
                try {
                    view.getTimer().stop();
                    pause.setText("Resume");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    view.getTimer().start();
                    pause.setText("Pause");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Pour ne pas que la barre d'espace active le bouton.
            Platform.runLater(() -> {
                view.getCanvas().requestFocus();
            });
        });
    }

    public void handleDebug(CheckBox debug) {
        debug.setOnAction((event) -> {
            if (debug.isSelected()) {
                view.setModeDebug(true);
            } else {
                view.setModeDebug(false);
            }
            Platform.runLater(() -> {
                // Pour ne pas que la barre d'espace active le bouton.
                view.getCanvas().requestFocus();

                // Pour que l'affichage soit mis à jour même quand le jeu est sur pause.
                view.getContext().clearRect(0, 0, FlappyGhost.SCENEWIDTH, FlappyGhost.BGHEIGHT);
                draw(ghost);
                manageObstacles(0);
            });
        });

    }

    public void restart() {


        restarting = true;
        ghost.setScore(0);
        view.getRightScore().setText("Score: 0   ");
        ghost.setVy(0);
        ghost.setVx(150);
        ghost.setX(FlappyGhost.SCENEWIDTH / 2.0);
        ghost.setY(FlappyGhost.BGHEIGHT / 2.0);
        ghost.setAy(500);
        background.getBg1().setX(0);
        background.getBg2().setX(background.getInitX());

        ObstacleList = new ArrayList<>();
        restarting = false;

        //try {
            //view.getStage().close();
            // view.getStage().close();

            //Platform.runLater( () -> {
            //  try {
            //        view.start(new Stage());
            //    } catch (Exception e) {
            //        e.printStackTrace();
            //     }
            //  });
        //  } catch (Exception e) {
        //     e.printStackTrace();
        // }


    }


}


