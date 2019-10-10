package jinspect;

public class SpotCheck {

    private final Boolean[][] plate;
    private Integer total_area = 0;
    private Integer number_of_spots = 0;
    private Integer biggest_spot_area = 0;
    private Double spots_average_area = 0.0;
    private Spot[] spots = new Spot[];

    public SpotCheck(Boolean[][] plate) {
        this.plate = plate;
        for (Boolean[] row : plate) {
            for (Boolean pixel : row) {
                if (pixel) {
                    String pixelIndex = plate.indexOf(row).toString() + plate.indexOf(row).toString();
                    //TODO 
                    this.total_area++;
                }
            }
        }

    }

    public Integer gettotal_area() {
        return this.total_area;
    }

    public Integer getnumber_of_spots() {
        return this.number_of_spots;
    }

    public Integer getbiggest_spot_area() {
        return this.biggest_spot_area;
    }

    public Integer getspots_average_area() {
        return this.number_of_spots;
    }
}
