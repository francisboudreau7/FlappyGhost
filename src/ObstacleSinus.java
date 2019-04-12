public class ObstacleSinus extends Obstacle {
    private double initY;

    public ObstacleSinus(double x, double y, double ghostSpeed) {
        super(x, y, ghostSpeed, 0, 0, 0);
        initY = y;
    }

    @Override
    public void update(double dt) {
        setX(getX() + dt * getVx());
        double frequencyCoefficient = 0.05;
        int amplitude = 25;
        setY(amplitude * Math.sin(frequencyCoefficient * getX() - dt) + initY);


    }
}
