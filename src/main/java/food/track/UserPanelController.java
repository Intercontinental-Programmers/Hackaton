package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michał Treter on 03.06.2017.
 */
@Controller
public class UserPanelController {
    public static User currentUser;
    public static Day currentDay;

    @RequestMapping("/userpanel")
    public ModelAndView showUserPanel(){
        if(true){

            if(LoginController.curUser){
                currentUser = LoginController.usr1;
                currentDay = LoginController.day1;
            }
            else{
                currentUser = LoginController.usr2;
                currentDay = LoginController.day2;
            }

            String weightProgress = currentUser.getDelta();
            String nick = currentUser.getNick();
            String age = currentUser.getAge();
            String weight = currentUser.getWeight();
            String activity = "";
            String height = currentUser.getHeight();
            String color = "";
            int dailyCalories = 0;
            String photoPath;

            String breakfastName = currentDay.getBreakfast();
            String dinnerName = currentDay.getDinner();
            String supperName = currentDay.getSupper();

            if(currentUser.getNick().equals("Adi")){
                activity = "Lose weight";
                dailyCalories = 1900;
                photoPath = "./images/adi.jpg";

            }
            else{
                activity = "Gain muscle mass";
                photoPath = "./images/maku.jpg";
                dailyCalories = 2230;
            }

            if(weightProgress.startsWith("-")){
                color = "color: green";
            }
            else{
                color = "color: red";
            }

            ModelAndView newMaV = new ModelAndView("user-panel");

            newMaV.addObject("dinner", dinnerName);
            newMaV.addObject("breakfast", breakfastName);
            newMaV.addObject("supper", supperName);

            newMaV.addObject("nickname", nick);
            newMaV.addObject("age", age);
            newMaV.addObject("weight", weight);
            newMaV.addObject("height", height);
            newMaV.addObject("dailyCal", Integer.toString(dailyCalories));
            newMaV.addObject("weightProgress", weightProgress);
            newMaV.addObject("activity", activity);
            newMaV.addObject("color", color);
            newMaV.addObject("photo", photoPath);

            return newMaV;

        }
        else{
            //TODO: if no user is logged then show error page
            String errorMessage = "Youre have to be loged in before proceding to this site";
            return new ModelAndView("errorpage", "message", errorMessage);
        }
    }

}
