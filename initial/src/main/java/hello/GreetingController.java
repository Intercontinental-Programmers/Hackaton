package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {
    @RequestMapping()
    public String home() {
        System.out.println("HELLO !!");
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String redirect() {
        System.out.println("COMMING !!");
        return "registration";
    }
}