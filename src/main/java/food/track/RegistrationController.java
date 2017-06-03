package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RegistrationController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String redirect() {
        System.out.println("COMMING !!");
        return "registration";
    }
}