package com.imooc.service;

import com.imooc.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    /*
    * 新增sysuser到数据库
    * @param user
    * */
    public void saveSysUser(SysUser user);

    /*
    * 分页查询
    * @param pageSize,PageNum
    */
    public void customerPage(SysUser user);

    /*
     * 根据主键id去查询信息
     * @param id
    */
    public SysUser detailById(String id);

    /**
     * 根据条件去查询list
     */
    public List<SysUser> queryByCondition(String name, Integer sex);

    /*
    * 根据id删除
    * */
    public void remove(String id);

    /*
    * 事务回滚
    * */
    public void trans();

    /*
    * 自定义mapper
    * */
    public List<SysUser> customer(String id);
}
