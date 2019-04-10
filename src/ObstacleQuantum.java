public class ObstacleQuantum extends Obstacle {

    public ObstacleQuantum(double x, double y) {
        super(x, y, 0, 0, 0, 0);


    }

    ;


    public void update() {
        setX(getX() + Math.random() * 60 - 30);
        setY(getY() + Math.random() * 60 - 30);
    }
}
