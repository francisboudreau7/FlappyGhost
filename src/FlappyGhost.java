


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlappyGhost extends Application {

    int largeurScene = 640, hauteurScene = 400;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        primaryStage.setTitle("Flappy Ghost");
        primaryStage.setScene(new Scene(root, largeurScene, hauteurScene));


        Image img = new Image("../bng.png");
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(hauteurScene);
        imageView.setFitWidth(largeurScene);
        root.getChildren().add(imageView);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
