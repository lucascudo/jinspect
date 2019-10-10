package jinspect;

public class Spot {

    private String[] pixels = new String[];
    private Integer size = 0;

    public String[] getPixels() {
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