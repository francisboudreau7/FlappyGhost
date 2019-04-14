import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

/**
 * The type Entity.
 */
public abstract class Entity {
    private double x, y;
    private double vx, vy; // Speed per second
    private double ay;
    private final Image img;
    private final int r;
    private Boolean Intersected = false;//True when the Entity is currently intersected by another Entity.


    /**
     * Instancie une nouvelle Entity
     *
     * @param x   la position en x
     * @param y   la position en  y
     * @param vx  la vitesse en x
     * @param vy  la vitesse en y
     * @param ay  l'acceleration y
     * @param img l'image qui represente l'entite
     * @param r   le rayon
     */
    public Entity(double x, double y, double vx, double vy, double ay, Image img, int r) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ay = ay;
        this.img = img;
        this.r = r;


    }

    /**
     * Verifie si l'entite intesecte l'entite en parametre
     *
     * @param other l'autre entite
     * @return vrai, si intersecte, faux sinon
     */
    public Boolean intersects(Entity other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double d2 = dx * dx + dy * dy;

        return d2 < (this.r + other.r) * (this.r + other.r);
    }


    /**
     * Getter de la position en x.
     *
     * @return la position en x
     */
    public double getX() {
        return x;
    }

    /**
     * Setter de la position en x.
     *
     * @param x la position en  x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter de la position en y.
     *
     * @return la position en y
     */
    public double getY() {
        return y;
    }

    /**
     * Setter de la position en y
     *
     * @param y la position en y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter de la vitesse en x
     *
     * @return la vitesse en x
     */
    public double getVx() {
        return vx;
    }

    /**
     * Setter de la vitesse en x
     *
     * @param vx la vitesse en x
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * Getter de la vitesse en y
     *
     * @return la vitesse en y
     */
    public double getVy() {
        return vy;
    }

    /**
     * Setter de la vitesse en y
     *
     * @param vy la vitesse en y
     */
    public void setVy(double vy) {
        this.vy = vy;
    }


    /**
     * Getter de l'acceleration en y
     *
     * @return ay l'accelaration en y
     */
    public double getAy() {
        return ay;
    }

    /**
     * Setter de l'acceleration en y
     *
     * @param ay l'acceleration en y
     */
    public void setAy(double ay) {
        this.ay = ay;
    }

    /**
     * Getter de l'image
     *
     * @return l'image
     */
    public Image getImg() {
        return this.img;
    }

    /**
     * Getter du rayon
     *
     * @return le rayon
     */
    public int getR() {
        return r;
    }

    /**
     * Getter de l'attribut intersected
     *
     * @return vrai si intersecte, faux sinon
     */
    public Boolean isIntersected() {
        return Intersected;
    }

    /**
     * Setter pour l'attribut Intersected
     *
     * @param intersected l'attribut Intersected
     */
    public void setIntersected(Boolean intersected) {
        Intersected = intersected;
    }

    /**
     * Getter de la couleur de l'entité(en mode Debug)
     *
     * @return la couleur
     */
    public abstract Paint getColor();

}
