package com.jeff.admin.web.index;

import com.jeff.admin.entity.common.BaseResponse;
import com.jeff.admin.entity.user.SysUser;
import com.jeff.admin.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;

    @RequestMapping("")
    public String loginIndex(){
        return "page/login/login";
    }

    @RequestMapping("/submit")
    @ResponseBody
    public BaseResponse submit(SysUser user){
        return loginService.login(user);
    }
}
