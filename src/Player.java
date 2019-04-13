import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player extends Entity {
    private int score;
    private double speedFrame; // Speed per frame
    private Paint color = Color.BLACK;


    public Player(double x, double y) {
        super(x, y, 150, 0, 0, 500, new Image("img/ghost.png", 60, 60, false, false), 30);
        this.score = 0;
    }

    public void jump() {
        this.setVy(-300);

    }

    public void update(double dt) {

        setSpeedFrame(getVx() * dt);
        setVy(getVy() + dt * getAy());
        setY(getY() + dt * getVy());

        if (getVy() > 300) {
            setVy(300);
        }

        if (getVy() < -300) {
            setVy(-300);
        }

        if ((getY() + getR() * 2) > FlappyGhost.BGHEIGHT || getY() < 0) {
            setVy(getVy() * -1);
        }

        setY(Math.min(getY(), FlappyGhost.BGHEIGHT - getR() * 2));
        setY(Math.max(getY(), 0));

    }

    public void addVX() {
        this.setVx(this.getVx() + 15);
    }

    public void addAY() {
        this.setAy(this.getAy() + 15);
    }

    public void updateScore() {
        this.score += 5;
    }

    public int getScore () {
            return this.score;
    }

    public double getSpeedFrame() {
        return speedFrame;
    }

    public void setSpeedFrame(double speedFrame) {
        this.speedFrame = speedFrame;
    }

    public Paint getColor() {
        return color;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

