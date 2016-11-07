package com.trusthiker.console.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rui on 16/10/31.
 */
@Controller
public class CityController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    String test(Model model) {
        model.addAttribute("name", "test");
        return "index";
    }
}
