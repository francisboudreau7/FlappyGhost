


import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;


public class FlappyGhost extends Application {

    // Attributs
    public static final int SCENEWIDTH = 640;
    private static final int SCENEHEIGHT = 440;
    public static final int BGHEIGHT = 400;
    private String title = "Flappy Ghost";
    ToggleButton leftPause = new ToggleButton("Pause");
    CheckBox centerCheckBox = new CheckBox("Mode debug");
    private Text rightScore = new Text("Score: 0   ");
    Image icon = new Image("/img/ghost.png");

    String musicFile = "The_Entertainer_-_1902_-_By_Scott_Joplin.ogg";     // For example

    Media sound ;


    private Background background;
    private Canvas canvas = new Canvas(SCENEWIDTH, BGHEIGHT);
    private GraphicsContext context = canvas.getGraphicsContext2D();

    private AnimationTimer timer;

    private Controller controller;
    private Player ghost;

    private boolean modeDebug;

    /*private BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(sceneWidth, bgHeight, false, false, false, false ));*/

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Image img = new Image("img/bg.png");
        //ImageView bg = new ImageView(img);





        VBox root = new VBox();
        Scene scene = new Scene(root, SCENEWIDTH, SCENEHEIGHT);
        HBox menu = new HBox();

        Separator sep1 = new Separator(Orientation.VERTICAL);
        sep1.setValignment(VPos.CENTER);
        sep1.setPrefHeight(40);

        Separator sep2 = new Separator(Orientation.VERTICAL);
        sep2.setValignment(VPos.CENTER);
        sep2.setPrefHeight(40);

        menu.getChildren().add(leftPause);
        menu.getChildren().add(sep1);
        menu.getChildren().add(centerCheckBox);
        menu.getChildren().add(sep2);
        menu.getChildren().add(rightScore);
        menu.setAlignment(Pos.CENTER);

        //root.getChildren().add(menu);
        // Instanciation de controller
        controller = new Controller(this);
        ghost = controller.getGhost();
        background = controller.getBackground();

        Pane pane = new Pane(background.getBg1(), background.getBg2(), canvas);
        root.getChildren().add(pane);
        root.getChildren().add(new Separator());
        root.getChildren().add(menu);

        timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start();

            }

            @Override
            public void handle(long now) {
                // modeDebug = centerCheckBox.isSelected();
                controller.playMusic();
                double deltaTime = (now - lastTime) * 1e-9;
                context.clearRect(0, 0, SCENEWIDTH, BGHEIGHT);
                controller.draw(ghost);
                ghost.update(deltaTime);
                controller.manageObstacles(deltaTime);
                background.moveBg(ghost.getSpeedFrame());

                controller.checkIfLost();
                lastTime = now;
            }

        };
        timer.start();

        //stage.initModality(Modality.WINDOW_MODAL);
        // stage.initOwner(primaryStage);


        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(icon);

        Platform.runLater(() -> {
            canvas.requestFocus();
        });
        scene.setOnMouseClicked((event) -> {
            canvas.requestFocus();
        });


        controller.handleKeyboard(scene);
        controller.handlePause(leftPause);
        controller.handleDebug(centerCheckBox);



    }


    public GraphicsContext getContext() {
        return context;
    }


    public FlappyGhost getFlappyGhost() {
        return this;
    }


    public boolean isModeDebug() {
        return modeDebug;
    }

    public void setModeDebug(boolean modeDebug) {
        this.modeDebug = modeDebug;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Text getRightScore() {
        return rightScore;
    }

    public AnimationTimer getTimer() {
        return timer;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public CheckBox getCheckBox() {
        return centerCheckBox;
    }

    // public Stage getStage() {
    //      return stage;
    //   }
}
