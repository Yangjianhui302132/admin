package com.jeff.admin.common.config.interceptor;

import com.jeff.admin.common.utils.CookieUtils;
import com.jeff.admin.common.utils.RedisUtils;
import com.jeff.admin.common.utils.SpringUtils;
import com.jeff.admin.entity.login.UserSession;
import com.jeff.admin.entity.user.SysUser;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截逻辑
        String token = CookieUtils.getCookieValue(SpringUtils.getRequest(), UserSession.ADMIN_USER_COOKIE_TOKEN);
        String key = UserSession.ADMIN_USER_SESSION_TOKEN + ":" + token;
        Object user = redisUtils.get(key);
        if (user == null) {
            log.error("没有权限请先登陆");
            //未登陆，返回登陆界面
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        } else {
            //已登陆，放行请求并重置会话过期时长
            redisUtils.expire(key,UserSession.ADMIN_USER_SESSION_TIMEOUT);
            //重置session中的对象
            SpringUtils.getSession().setAttribute(UserSession.ADMIN_USER_SESSION_TOKEN,user);
            //重置cookie
            CookieUtils.setCookie(SpringUtils.getRequest(),SpringUtils.getResponse(),UserSession.ADMIN_USER_COOKIE_TOKEN, token,UserSession.ADMIN_USER_SESSION_TIMEOUT.intValue());
            return true;
        }
    }
}
