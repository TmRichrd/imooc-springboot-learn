package com.imooc.mapper;

import com.imooc.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserCustomMapper {
    public List<SysUser> getByUserId(String sid);
}