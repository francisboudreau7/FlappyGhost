


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotResult;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FlappyGhost extends Application {

    // Attributs
    public static final int SCENEWIDTH = 640, SCENEHEIGHT = 440, BGHEIGHT = 400;
    private String title = "Flappy Ghost";
    private String pause = "Pause";
    private String debug = "Mode debug";
    private String score = "Score: ";

    private Canvas canvas = new Canvas(SCENEWIDTH, BGHEIGHT);
    private GraphicsContext context = canvas.getGraphicsContext2D();

    private Controller controller;
    private Player ghost;

    private boolean modeDebug = false;

    /*private BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(sceneWidth, bgHeight, false, false, false, false ));*/





    @Override
    public void start(Stage primaryStage) throws Exception {

        Image img = new Image("img/bg.png");
        ImageView bg = new ImageView();

        VBox root = new VBox();
        Scene scene = new Scene(root, SCENEWIDTH, SCENEHEIGHT);

        bg.setImage(img);

        StackPane stackPane = new StackPane(bg, canvas);
        root.getChildren().add(stackPane);


        root.getChildren().add(new Separator());

        HBox menu = new HBox();
        Button leftPause = new Button(pause);
        //leftPause.setStyle("-fx-background-color: -fx-outer-border, -fx-inner-border, -fx-body-color; ");
        CheckBox centerCheckBox = new CheckBox(debug);
        Text rightScore = new Text(score);

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

        root.getChildren().add(menu);
        controller = new Controller(this);
        ghost = controller.getGhost();

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                double deltaTime = (now - lastTime) * 1e-9;
                context.clearRect(0, 0, SCENEWIDTH, BGHEIGHT);

                controller.draw(ghost);
                ghost.update(deltaTime);

                lastTime = now;
            }
        };
        timer.start();

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        Platform.runLater(() -> {
            canvas.requestFocus();
        });
        scene.setOnMouseClicked((event) -> {
            canvas.requestFocus();
        });

        controller.handleSpace(scene);


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







}
