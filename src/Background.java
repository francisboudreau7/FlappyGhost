import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Background {

    public final int bgHeight;
    public final int bgWidth;

    private Player ghost;
    private final Image img1 = new Image("img/bg.png");
    private final Image img2 = new Image("img/bg.png");
    private final double initX;

    private final ImageView bg1 = new ImageView(img1);
    private final ImageView bg2 = new ImageView(img2);

    public Background(int bgHeight, int bgWidth) {
        this.bgHeight = bgHeight;
        this.bgWidth = bgWidth;
        bg2.setX(bgWidth);
        initX = bgWidth;
    }

    public ImageView getBg1() {
        return bg1;
    }

    public ImageView getBg2() {
        return bg2;
    }

    public void moveBg(Double speed) {
        bg1.setX(bg1.getX() - speed);
        bg2.setX(bg2.getX() - speed);

        if (bg2.getX() <= -bgWidth + speed) {
            bg2.setX(bgWidth);
        }

        if (bg2.getX() <= speed) {
            bg1.setX(bg2.getX() + bgWidth);
        }
    }

    public double getInitX() {
        return this.initX;
    }

}
