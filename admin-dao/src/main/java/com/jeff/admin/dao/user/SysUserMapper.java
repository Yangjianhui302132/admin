package com.jeff.admin.dao.user;

import com.jeff.admin.entity.user.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 杨剑辉
 * @since 2019-12-19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
