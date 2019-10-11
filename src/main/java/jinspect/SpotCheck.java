package jinspect;
import java.util.ArrayList;

public class SpotCheck {

    private final Boolean[][] plate;
    private Integer total_area = 0;
    private ArrayList<Spot> spots = new ArrayList();

    public SpotCheck(Boolean[][] plate) {
        this.plate = plate;
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                if (plate[i][j]) {
                    this.mapSpot(plate, i, j);
                    this.total_area++;
                }
            }
        }

    }

    public Integer gettotal_area() {
        return this.total_area;
    }

    public ArrayList<Spot> getnumber_of_spots() {
        return this.spots;
    }

    public Integer getbiggest_spot_area() {
        return 0;
    }

    public Integer getspots_average_area() {
        return 0;
    }

    private void mapSpot(Boolean[][] plate, Integer x, Integer y) {
        Integer spotIndex;
        Integer tempX = x;
        Integer tempY = y;
        String pixel = x.toString() + y.toString();
        for (Spot spot : this.spots) {
            if (spot.getPixels().contains(pixel)) {
                return;
            }
        }
        this.spots.add(new Spot());
        spotIndex = this.spots.size() - 1;
        this.spots.get(spotIndex).addPixel(pixel);
        tempX = x - 1;
        if (tempX >= 0 && plate[tempX][y]) { //top
            this.addPixelToSpot(spotIndex, plate, tempX, y);
        }
        tempX = x + 1;
        if (tempX < plate.length && plate[tempX][y]) { //down
            this.addPixelToSpot(spotIndex, plate, tempX, y);
        }
        tempY = y - 1;
        if (tempY >= 0 && plate[x][tempY]) { //left
            this.addPixelToSpot(spotIndex, plate, x, tempY);
        }
        tempY = y + 1;
        if (tempY < plate[x].length && plate[x][tempY]) { //right
            this.addPixelToSpot(spotIndex, plate, x, tempY);
        }
    }

    private void addPixelToSpot(Integer spotIndex, Boolean[][] plate, Integer x, Integer y) {
        Boolean registered = false;
        String pixel = x.toString() + y.toString();
        for (Spot spot : this.spots) {
            if (spot.getPixels().contains(pixel)) {
                registered = true;
                break;
            }
        }
        if (!registered) {
            this.spots.get(spotIndex).addPixel(pixel);
            this.mapSpot(plate, x, y);
        }
    }
}
