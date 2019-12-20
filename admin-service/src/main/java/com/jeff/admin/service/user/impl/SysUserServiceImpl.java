package com.jeff.admin.service.user.impl;

import com.jeff.admin.entity.user.SysUser;
import com.jeff.admin.user.mapper.SysUserMapper;
import com.jeff.admin.service.user.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 杨剑辉
 * @since 2019-12-19
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public String sayHello() {
        return "你好啊";
    }
}
