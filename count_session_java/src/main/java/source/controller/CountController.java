package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import source.model.MyCount;

@Controller
@SessionAttributes("mycount")
public class CountController {

    /* add MyCounter in model attribute */
    @ModelAttribute("mycount")
    public MyCount setUpCount() {
        return new MyCount();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycount") MyCount myCount) {
        myCount.increment();
        return "index";
    }
}
