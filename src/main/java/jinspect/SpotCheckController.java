package jinspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotCheckController {

    @RequestMapping(value = "/spot_check", produces = "application/json")
    public @ResponseBody SpotCheck spotcheck(@RequestBody Boolean[][] plate) {
        return new SpotCheck(plate);
    }
}
