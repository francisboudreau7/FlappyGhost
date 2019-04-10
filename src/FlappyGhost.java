


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FlappyGhost extends Application {

    // Attributs
    private int sceneWidth = 640;
    private int sceneHeight = 440;
    private int bgHeight = 400;
    private String title = "Flappy Ghost";
    private String pause = "Pause";
    private String debug = "Mode debug";
    private String score = "Score: ";


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);

        Image img = new Image("file:bg.png");
        BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(sceneWidth, bgHeight, false, false, false, false ));
        root.setBackground(new Background(bgImg));

        Canvas canvas = new Canvas(sceneWidth, bgHeight);
        root.getChildren().add(canvas);

        GraphicsContext context = canvas.getGraphicsContext2D();

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


        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        AnimationTimer timer = createTimer();
        timer.start();
    }

    private AnimationTimer createTimer() {

        return new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                double deltaTime = (now - lastTime) * 1e-9; // en secondes
            }
        };
    }
    public static void main(String[] args) {
        launch(args);
    }
}
