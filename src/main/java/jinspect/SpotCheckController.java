package jinspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotCheckController {

    @RequestMapping(value = "/spot_check", method = RequestMethod.POST)
    public @ResponseBody Object spotCheck(@RequestBody Boolean[][] plate) {
        Integer plateRows = plate.length; 
        for (Boolean[] row: plate) {
            if (row.length != plate.length) {
                return "Invalid Matrix Format";
            }    
        }
        return new SpotCheck(plate);
    }

    @RequestMapping(value = "/spot_check", method = RequestMethod.GET)
    public @ResponseBody String spotCheckInvalidMethod(@RequestBody Boolean[][] plate) {
        return "Invalid Method";
    }
}
