import javafx.scene.image.Image;

public abstract class Obstacle extends Entity {

    public Obstacle(double x, double y, double vx, double vy, double ax, double ay) {
        super(x, y, vx, vy, ax, ay, new Image("file:../" + (int) (Math.random() * 26) + ".png"), (int) (Math.random() * 35 + 10));


    }

    public Obstacle newObstacle() {
        int choose = (int) Math.random() * 3;
        Obstacle result = null;
        double y = Math.random() * 400;
        double x = 640 + 45; //TODO:Verifier si on peut aller chercher le background width.
        switch (choose) {
            case 0:
                result = new ObstacleQuantum(x, y);
                break;

            case 1:
                result = new ObstacleSimple(x, y);
                break;

            case 2:
                result = new ObstacleSinus(x, y, 10);
                break;
        }

        return result;
    }
}




