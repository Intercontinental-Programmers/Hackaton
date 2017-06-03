package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class SettingsController {
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView redirect() {

        return new ModelAndView("settings", "photo", UserPanelController.photoPath);
    }
}