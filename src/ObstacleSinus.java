public class ObstacleSinus extends Obstacle {
    private int amplitude = 50;

    public ObstacleSinus(double x, double y, double vy) {
        super(x, y, 0, vy, 0, 0);
    }

    ;

    @Override
    public void update(double dt) {//TODO: peut etre vy en fonction de vx;
        double y = getY();
        y += amplitude * Math.sin(getVy() * System.nanoTime());
        setY(y);

    }
}
