package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirect() {
        System.out.println("im logging in");
        Day day1 = new Day(1,1);
        Day day2 = new Day(2,1);
        User usr1 = new User(1);
        User usr2 = new User(2);
        System.out.println(day1+"\n\n"+day2);
        System.out.println(usr1+"\n\n"+usr2);
        return "login";
    }
}