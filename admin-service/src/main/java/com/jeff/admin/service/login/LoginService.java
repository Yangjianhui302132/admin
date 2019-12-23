package com.jeff.admin.service.login;

import com.jeff.admin.entity.common.BaseResponse;
import com.jeff.admin.entity.user.SysUser;

public interface LoginService {
    BaseResponse login(SysUser user);
}
