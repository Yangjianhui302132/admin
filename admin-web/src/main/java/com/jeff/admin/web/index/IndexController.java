package com.jeff.admin.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/main")
    public String pageMain(){
        return "page/main";
    }

    @RequestMapping
    public String hello(){
        return "index";
    }
}
