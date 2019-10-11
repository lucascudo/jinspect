package jinspect;
import java.util.ArrayList;

public class Spot {

    private ArrayList<String> pixels = new ArrayList();

    public ArrayList<String> getPixels() {
        return this.pixels;
    }

    public void addPixel(String pixel) {
        this.pixels.add(pixel);
    }
}