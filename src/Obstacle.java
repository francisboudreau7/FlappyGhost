import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Obstacle extends Entity {

    private Boolean counted = false;
    private Paint color = Color.YELLOW;

    public Obstacle(double x, double y, double vx, double vy, double ax, double ay) {
        super(x, y, vx, vy, ax, ay, new Image("img/" + (int) (Math.random() * 26) + ".png", 60, 60, false, false),
                (int) (Math.random() * 35) + 10);
    }

    public static Obstacle newObstacle(double ghostSpeed) {
        int choose = (int) (Math.random() * 3);
        Obstacle result = null;
        double y = Math.random() * (FlappyGhost.BGHEIGHT - 70) + 35;
        double x = FlappyGhost.SCENEWIDTH + 45;
        switch (choose) {
            case 0:
                result = new ObstacleQuantum(x, y, ghostSpeed);
                break;

            case 1:

                result = new ObstacleSimple(x, y, ghostSpeed);
                break;

            case 2:

                result = new ObstacleSinus(x, y, ghostSpeed);
                break;
        }

        return result;
    }

    public abstract void update(double dt, double ghostSpeed);

    public Boolean isCounted() {
        return this.counted;
    }

    public void setCounted() {
        this.counted = true;
    }

    public Paint getColor() {
        return color;
    }
}




