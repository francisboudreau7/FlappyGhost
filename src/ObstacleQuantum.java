public class ObstacleQuantum extends Obstacle {

    double lastTimeTeleport;



    public ObstacleQuantum(double x, double y, double ghostSpeed) {
        super(x, y, ghostSpeed, 0, 0, 0);


    }


    public void update(double dt) {

        setX(getX() + dt * getVx());
        if (Controller.getTime() - lastTimeTeleport >= 0.2) {
            setX(getX() + Math.random() * 60 - 30);
            setY(getY() + Math.random() * 60 - 30);
            lastTimeTeleport = Controller.getTime();
        }




    }
}
