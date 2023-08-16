package teammatching.teammatching;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoMainPageController {
    @GetMapping("/")
    public String goMainPage(){
        return "redirect:/team-matching";
    }
}
