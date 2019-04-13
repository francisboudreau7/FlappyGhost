public class ObstacleSinus extends Obstacle {
    private double initY;

    public ObstacleSinus(double x, double y, double ghostSpeed,int radius, int number) {
        super(x, y, ghostSpeed, 0, 0, 0,radius,number);
        initY = y;
    }

    @Override
    public void update(double dt, double ghostSpeed) {

        setVx(ghostSpeed);
        setX(getX() + dt * getVx());
        double frequencyCoefficient = 0.05;
        int amplitude = 25;
        setY(amplitude * Math.sin(frequencyCoefficient * getX() - dt) + initY);

    }
}
