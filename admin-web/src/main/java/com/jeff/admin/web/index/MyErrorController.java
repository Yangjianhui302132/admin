package com.jeff.admin.web.index;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "page/401";
        }else if(statusCode == 404){
            return "page/404";
        }else if(statusCode == 403){
            return "page/403";
        }else{
            return "page/500";
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}