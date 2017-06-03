package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {
    public static Day day1;
    public static Day day2;
    public static User usr1;
    public static User usr2;
    public static boolean curUser = false;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirect() {
        //System.out.println("im logging in");
        day1 = new Day(1,1);
        day2 = new Day(2,1);
        usr1 = new User(1);
        usr2 = new User(2);
        curUser = !curUser;
        //System.out.println(day1+"\n\n"+day2);
        //System.out.println(usr1+"\n\n"+usr2);
        return "login";
    }
}