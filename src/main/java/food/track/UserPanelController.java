package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michał Treter on 03.06.2017.
 */
@Controller
public class UserPanelController {

    @RequestMapping("/userpanel")
    public ModelAndView showUserPanel(){
        if(true){
            System.out.println("Login clicked");
            String weightProgress = "(+0.75)";
            String nick = "Adimus11";
            String age = "21";
            String weight = "82";
            String activity = "Weight loss";
            String height = "183";
            int dailyCalories = 2000;

            ModelAndView newMaV = new ModelAndView("user-panel");

            newMaV.addObject("nickname", nick);
            newMaV.addObject("age", age);
            newMaV.addObject("weight", weight);
            newMaV.addObject("height", height);
            newMaV.addObject("dailyCal", Integer.toString(dailyCalories));
            newMaV.addObject("weightProgress", weightProgress);
            newMaV.addObject("activity", activity);

            return newMaV;

        }
        else{
            //TODO: if no user is logged then show error page
            String errorMessage = "Youre have to be loged in before proceding to this site";
            return new ModelAndView("errorpage", "message", errorMessage);
        }
    }

}
