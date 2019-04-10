public class ObstacleQuantum extends Obstacle {

    public ObstacleQuantum(double x, double y) {
        super(x, y, 0, 0, 0, 0);


    }

    ;


    public void update() {// TODO:Il ne faut pas que les points monte si l'obstacle redépasse peut être ajouter un
        // attribut boolean counted.
        setX(getX() + Math.random() * 60 - 30);
        setY(getY() + Math.random() * 60 - 30);
    }
}
