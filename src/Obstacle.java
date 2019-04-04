import javafx.scene.image.Image;

public abstract class Obstacle extends Entity {

    public Obstacle(double x, double y, double vx, double vy, double ax, double ay) {
        super(x, y, vx, vy, ax, ay, new Image("file:../" + (int) (Math.random() * 26) + ".png"), (int) (Math.random() * 35 + 10));


    }
}
