public class ObstacleSimple extends Obstacle {

    public ObstacleSimple(double x, double y, double ghostSpeed) {

        super(x, y, ghostSpeed, 0, 0, 0);

    }

    @Override
    public void update(double dt, double ghostSpeed) {

        setVx(ghostSpeed);
        setX(getX() + dt * getVx());
    }
}
