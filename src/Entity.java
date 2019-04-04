import javafx.scene.image.Image;

public abstract class Entity {
    private double x, y;
    private double vx, vy;
    private double ax, ay;
    private Image img;
    private int r;

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

    public void update(double dt) {
        vx += dt * ax;
        vy += dt * ay;

        x += dt * vx;
        y += dt * vy;

        if (vy > 300) {
            vy = 300;
        }

        if (vy < -300) {
            vy = 300;
        }

//        x = Math.min(x, JavaFXBall.WIDTH - getW() / 2);
//        x = Math.max(x, getW() / 2);
//
//        y = Math.min(y, JavaFXBall.HEIGHT - getH() / 2);
//        y = Math.max(y, getH() / 2);
//TODO
        //Ajuster selon les grandeurs de la fenetre
    }

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
}
