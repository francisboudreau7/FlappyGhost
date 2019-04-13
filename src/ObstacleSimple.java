public class ObstacleSimple extends Obstacle {

    public ObstacleSimple(double x, double y, double ghostSpeed,int radius, int number) {

        super(x, y, ghostSpeed, 0, 0, 0,radius,number);

    }

    @Override
    public void update(double dt, double ghostSpeed) {

        setVx(ghostSpeed);
        setX(getX() + dt * getVx());
    }
}
