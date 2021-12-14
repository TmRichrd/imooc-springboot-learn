package com.imooc.service.impl;

import com.imooc.mapper.SysUserCustomMapper;
import com.imooc.mapper.SysUserMapper;
import com.imooc.pojo.SysUser;
import com.imooc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserCustomMapper sysUserCustomMapper;

    @Override
    public void remove(String id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void customerPage(SysUser user) {

    }

    @Override
    public List<SysUser> queryByCondition(String name, Integer sex) {
//        //构造条件
//        Example example = new Example(SysUser.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("name", name);
//        criteria.andEqualTo("sex", sex);
//        //实现查询
//        List<SysUser> list = sysUserMapper.selectByExample(example);
        SysUser user = new SysUser();
        user.setName(name);
        user.setSex(sex);
        List<SysUser> list = sysUserMapper.select(user);
        return list;
    }

    @Override
    public SysUser detailById(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveSysUser(SysUser user) {
        sysUserMapper.insert(user);
    }

//    事务回滚注解
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void trans() {
        String sid = UUID.randomUUID().toString();
        SysUser user = new SysUser();
        user.setId(sid);
        user.setName(sid);
        user.setSex(3);
        sysUserMapper.insert(user);

        int a = 100 / 0;

        SysUser userDb = new SysUser();

        userDb.setId("382b1dec-55a4-46cc-ab79-6edb289a9991");
        user.setName("修改后的name");
        user.setSex(4);
        sysUserMapper.updateByPrimaryKeySelective(userDb);
    }

    @Override
    public List<SysUser> customer(String id) {
        List<SysUser> users = sysUserCustomMapper.getByUserId(id);
        return users;
    }
}
