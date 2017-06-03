package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SettingsController {
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String redirect() {
        System.out.println("im loading settings");
        return "settings";
    }
}