import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

public abstract class Entity {
    private double x, y;
    private double vx, vy;
    private double ax, ay;
    private Image img;
    private int r;
    private Boolean Intersected = false;//True when the Entity is currently intersected by another Entity.


    public Entity(double x, double y, double vx, double vy, double ax, double ay, Image img, int r) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.ax = ax;
        this.ay = ay;
        this.img = img;
        this.r = r;


    }


    public abstract void update(double dt);

    public Boolean intersects(Entity other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double d2 = dx * dx + dy * dy;

        return d2 < (this.r + other.r) * (this.r + other.r);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public Image getImg() {
        return this.img;
    }

    public int getR() {
        return r;
    }

    public Boolean isIntersected() {
        return Intersected;
    }

    public void setIntersected(Boolean intersected) {
        Intersected = intersected;
    }
}
