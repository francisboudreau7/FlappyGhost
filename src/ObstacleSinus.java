public class ObstacleSinus extends Obstacle {
    private final int amplitude = 25;
    private final double frequencyCoefficient = 0.05;
    private double initY;

    public ObstacleSinus(double x, double y, double ghostSpeed) {
        super(x, y, ghostSpeed, 0, 0, 0);
        initY = y;
    }

    ;

    @Override
    public void update(double dt) {//TODO: peut etre vy en fonction de vx;
        setX(getX() + dt * getVx());
        setY(amplitude * Math.sin(frequencyCoefficient * getX() - dt) + initY);


    }
}
