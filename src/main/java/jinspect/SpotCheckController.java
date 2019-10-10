package jinspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotCheckController {

    @RequestMapping("/spot_check")
    public SpotCheck spotcheck(@RequestParam(value = "plate", defaultValue = " ") String plate) {
        //return new SpotCheck(plate);
    }
}
