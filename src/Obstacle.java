import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * The type Obstacle.
 */
public abstract class Obstacle extends Entity {

    private Boolean counted = false;
    private final Paint color = Color.YELLOW;


    /**
     * Instancie une nouvelle Entity
     *
     * @param x      la position en x
     * @param y      la position en  y
     * @param vx     la vitesse en x
     * @param vy     la vitesse en y
     * @param ay     l'acceleration y
     * @param r      le rayon
     * @param number le numero de l'image qui represente l'obstacle
     */
    public Obstacle(double x, double y, double vx, double vy, double ay, int r, int number) {
        super(x, y, vx, vy, ay, new Image("img/" + number + ".png", r * 2, r * 2, false,
                false), r);

    }


    /**
     * Mets a jour l'objet selon le temps d'un frame
     *
     * @param dt         le temps écoulé depuis la dernière update
     * @param ghostSpeed la vitesse du fantome
     */
    public abstract void update(double dt, double ghostSpeed);

    /**
     * Getter de la l'attribut Counted
     *
     * @return vrai s'il a été compté au score, faux sinon
     */
    public Boolean isCounted() {
        return this.counted;
    }

    /**
     * Setter de l'attribut counted
     */
    public void setCounted() {
        this.counted = true;
    }

    /**
     * Getter de la couleur de l'entité(en mode Debug)
     *
     * @return la couleur
     */
    public Paint getColor() {
        return color;
    }
}




