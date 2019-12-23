package com.jeff.admin.service.login.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jeff.admin.common.utils.CookieUtils;
import com.jeff.admin.common.utils.RedisUtils;
import com.jeff.admin.common.utils.SpringUtils;
import com.jeff.admin.entity.common.BaseResponse;
import com.jeff.admin.entity.login.UserSession;
import com.jeff.admin.entity.user.SysUser;
import com.jeff.admin.service.login.LoginService;
import com.jeff.admin.service.user.SysUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import sun.security.provider.MD5;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    @Qualifier("sysUserServiceImpl")
    private SysUserService sysUser;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public BaseResponse login(SysUser user) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_name",user.getUserName());
        qw.eq("password",user.getPassword());
        SysUser loginUser = sysUser.getOne(qw);
        if(loginUser!=null){//存在用户，登录，存储与redis,session中
            String cookieVal = RandomStringUtils.randomAlphabetic(10);
            String key = UserSession.ADMIN_USER_SESSION_TOKEN +":"+cookieVal;
            //存储redis中
            redisUtils.set(key,loginUser,UserSession.ADMIN_USER_SESSION_TIMEOUT);
            //存储session中
            SpringUtils.getSession().setAttribute(UserSession.ADMIN_USER_SESSION_TOKEN,loginUser);
            //向前端设置随机生成的字符串cookie
            CookieUtils.setCookie(SpringUtils.getRequest(),SpringUtils.getResponse(),UserSession.ADMIN_USER_COOKIE_TOKEN, cookieVal,UserSession.ADMIN_USER_SESSION_TIMEOUT.intValue());
            return BaseResponse.getSuccessResponse("登录成功");
        }else{
            return BaseResponse.getFailResponse("账号或密码不正确");
        }
    }
}
