package hello;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
//import net.codejava.spring.model.User;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
         
        // List<String> professionList = new ArrayList<>();
        // professionList.add("Developer");
        // professionList.add("Designer");
        // professionList.add("IT Manager");
        // model.put("professionList", professionList);
         
        return "Registration";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
        System.out.println("nick: " + user.getNick());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());

         
        return "RegistrationSuccess";
    }
}