package com.jeff.admin.entity.login;

import lombok.Data;
@Data
public class UserSession {
    //用户会话token key
    public static String ADMIN_USER_SESSION_TOKEN = "SYS_USER_SESSION";
    //用户会话过期时间
    public static Long ADMIN_USER_SESSION_TIMEOUT = 30*60*1000L;
    //用户cookie的key
    public static String ADMIN_USER_COOKIE_TOKEN = "JEFF_TOKEN";

    private String userName;
    private String password;
}
