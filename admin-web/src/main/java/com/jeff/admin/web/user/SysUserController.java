package com.jeff.admin.web.user;


import com.jeff.admin.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 杨剑辉
 * @since 2019-12-19
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    @Qualifier("sysUserServiceImpl")
    private SysUserService sysUserService;
}

