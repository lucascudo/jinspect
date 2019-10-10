package jinspect;
import java.util.ArrayList;

public class Spot {

    private ArrayList<String> pixels = new ArrayList();
    private Integer size = 0;

    public ArrayList<String> getPixels() {
        return this.pixels;
    }

    public void addPixel(String pixel) {
        this.pixels.add(pixel);
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}