/**
 * The type Obstacle sinus.
 */
public class ObstacleSinus extends Obstacle {
    private final double initY;

    /**
     * Instancie un nouvel obstacle sinus
     *
     * @param x          la position en x
     * @param y          la position en y
     * @param ghostSpeed la vitesse du fantome
     * @param radius     le rayon
     * @param number     le numero de l'image
     */
    public ObstacleSinus(double x, double y, double ghostSpeed, int radius, int number) {
        super(x, y, ghostSpeed, 0, 0, radius, number);
        initY = y;
    }

    /**
     * Mets a jour l'objet
     *
     * @param dt         le temps écoulé depuis la dernière update
     * @param ghostSpeed la vitesse du fantome
     */
    public void update(double dt, double ghostSpeed) {

        setVx(ghostSpeed);
        setX(getX() + dt * getVx());
        double frequencyCoefficient = 0.05;
        int amplitude = 25;
        setY(amplitude * Math.sin(frequencyCoefficient * getX() - dt) + initY);

    }
}
