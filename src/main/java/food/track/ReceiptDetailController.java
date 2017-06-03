package food.track;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Michał Treter on 03.06.2017.
 */
@Controller
public class ReceiptDetailController {
    @RequestMapping("/receipt")
    public ModelAndView receipt() {
        ModelAndView receiptView = new ModelAndView("receipt");
        return receiptView;
    }
}