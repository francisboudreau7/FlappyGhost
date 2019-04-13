import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Obstacle extends Entity {

    private Boolean counted = false;
    private Paint color = Color.YELLOW;


    public Obstacle(double x, double y, double vx, double vy, double ax, double ay,int r, int number) {
        super(x, y, vx, vy, ax, ay, new Image("img/" + number + ".png", r*2, r*2, false,
                        false),r);

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




