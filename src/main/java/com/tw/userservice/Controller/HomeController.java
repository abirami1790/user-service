package com.tw.userservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String welcome(Model model){
        model.addAttribute("Username","Deepti");
        return "index";
    }


}
