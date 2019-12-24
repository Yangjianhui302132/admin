package com.jeff.admin.common.config.interceptor;

import com.jeff.admin.common.utils.SpringUtils;
import com.jeff.admin.entity.login.UserSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ViewContextInterceptor implements HandlerInterceptor {
    @Value("${spring.profiles.active}")
    private String environment;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("handler", handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {
            if(!modelAndView.getViewName().startsWith("forward:")) {
                //当前环境
                modelAndView.getModel().put("environment", environment);
                //用户session信息
                modelAndView.getModel().put("SYS_USER_INFO", SpringUtils.getSession().getAttribute(UserSession.ADMIN_USER_SESSION_TOKEN));
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
