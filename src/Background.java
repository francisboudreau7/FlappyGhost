import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Background {

    public final int bgHeight;
    public final int bgWidth;

    private Player ghost;
    private Image img1 = new Image("img/bg.png");
    private Image img2 = new Image("img/bg.png");

    private ImageView bg1 = new ImageView(img1);
    private ImageView bg2 = new ImageView(img2);

    public Background(int bgHeight, int bgWidth) {
        this.bgHeight = bgHeight;
        this.bgWidth = bgWidth;
        bg2.setX(bgWidth);
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

}
