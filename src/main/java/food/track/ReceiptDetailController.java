package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michał Treter on 03.06.2017.
 */
@Controller
public class ReceiptDetailController {
    @RequestMapping("/receipt")
    public String receipt(@RequestParam(value="type", required=false, defaultValue="") String name, Model model) {
        if(name.equals("breakfast")){

        }
        else{
            if(name.equals("dinner")){

            }
            else{
                if(name.equals("supper")){

                }
                else{
                    return "index";
                }
            }
        }
        return "receipt";
    }
}