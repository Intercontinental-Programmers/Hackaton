package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


/**
 * Created by Michał Treter on 03.06.2017.
 */
@Controller
public class ReceiptDetailController {
    @RequestMapping("/receipt")
    public String receipt(@RequestParam(value="type", required=false, defaultValue="") String name, Model model) {
        String [] ingridients = new String[10];
        String [] steps = new String[10];
        String titleString = "", photoImg = "";

        for(int i = 0; i < 10; i ++){
            ingridients[i] = "";
            steps[i] = "";
        }

        if(name.equals("breakfast")){
            ArrayList<String> ingridientList = UserPanelController.currentDay.getIngredients_breakfast();
            titleString = UserPanelController.currentDay.getBreakfast();
            photoImg = UserPanelController.currentDay.getImg_breakfast();

            for(int i = 0; i < ingridientList.size(); i++){
                ingridients[i] = ingridientList.get(i);
            }

            int j = 0;
            for(int i = 0; i < UserPanelController.currentDay.getDesc_breakfast().length(); i++){
                if(UserPanelController.currentDay.getDesc_breakfast().charAt(i) =='.'){
                    steps[j] += UserPanelController.currentDay.getDesc_breakfast().charAt(i);
                    j++;
                }
                else {
                    steps[j] += UserPanelController.currentDay.getDesc_breakfast().charAt(i);
                }
            }

        }
        else{
            if(name.equals("dinner")){
                ArrayList<String> ingridientList = UserPanelController.currentDay.getIngredients_dinner();
                titleString = UserPanelController.currentDay.getDinner();
                photoImg = UserPanelController.currentDay.getImg_dinner();

                for(int i = 0; i < ingridientList.size(); i++){
                    ingridients[i] = ingridientList.get(i);
                }

                int j = 0;
                for(int i = 0; i < UserPanelController.currentDay.getDesc_dinner().length(); i++){
                    if(UserPanelController.currentDay.getDesc_dinner().charAt(i) =='.'){
                        steps[j] += UserPanelController.currentDay.getDesc_dinner().charAt(i);
                        j++;
                    }
                    else{
                        steps[j] += UserPanelController.currentDay.getDesc_dinner().charAt(i);
                    }
                }
            }
            else{
                if(name.equals("supper")){
                    ArrayList<String> ingridientList = UserPanelController.currentDay.getIngredients_supper();
                    titleString = UserPanelController.currentDay.getSupper();
                    photoImg = UserPanelController.currentDay.getImg_supper();

                    for(int i = 0; i < ingridientList.size(); i++){
                        ingridients[i] = ingridientList.get(i);
                    }
                    int j = 0;
                    for(int i = 0; i < UserPanelController.currentDay.getDesc_supper().length(); i++){
                        if(UserPanelController.currentDay.getDesc_supper().charAt(i) == '.'){
                            steps[j] += UserPanelController.currentDay.getDesc_supper().charAt(i);
                            j++;
                        }else {
                            steps[j] += UserPanelController.currentDay.getDesc_supper().charAt(i);
                        }
                    }
                }
                else{
                    return "index";
                }
            }
        }
        model.addAttribute("title", titleString);
        model.addAttribute("image", photoImg);

        model.addAttribute("in1", ingridients[0]);
        model.addAttribute("in2", ingridients[1]);
        model.addAttribute("in3", ingridients[2]);
        model.addAttribute("in4", ingridients[3]);
        model.addAttribute("in5", ingridients[4]);
        model.addAttribute("in6", ingridients[5]);
        model.addAttribute("in7", ingridients[6]);
        model.addAttribute("in8", ingridients[7]);
        model.addAttribute("in9", ingridients[8]);
        model.addAttribute("in10", ingridients[9]);

        model.addAttribute("s1", steps[0]);
        model.addAttribute("s2", steps[1]);
        model.addAttribute("s3", steps[2]);
        model.addAttribute("s4", steps[3]);
        model.addAttribute("s5", steps[4]);
        model.addAttribute("s6", steps[5]);
        model.addAttribute("s7", steps[6]);
        model.addAttribute("s8", steps[7]);
        model.addAttribute("s9", steps[8]);
        model.addAttribute("s10", steps[9]);


        return "receipt";
    }
}