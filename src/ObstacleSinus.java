public class ObstacleSinus extends Obstacle {
    private int amplitude = 50;

    public ObstacleSinus(double x, double y, double vy) {
        super(x, y, 0, vy, 0, 0);
    }

    ;

    @Override
    public void update(double dt) {//TODO vérifier
        double y = getY();
        y += amplitude * Math.sin(getVy() * dt);
        setY(y);

    }
}
