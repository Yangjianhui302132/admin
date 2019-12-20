package com.jeff.admin.service.user;

import com.jeff.admin.entity.user.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 杨剑辉
 * @since 2019-12-19
 */
public interface SysUserService extends IService<SysUser> {

    String sayHello();
}
