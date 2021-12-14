package com.imooc.controller;

import com.imooc.pojo.SysUser;
import com.imooc.pojo.bo.SysUserBO;
import com.imooc.service.SysUserService;
import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
@Slf4j
@RequestMapping(value = "sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "save")
    public JSONResult save() {
        SysUser user = new SysUser();
        String sid = UUID.randomUUID().toString();
        user.setId(sid);
        user.setName("王八");
        user.setSex(1);
        sysUserService.saveSysUser(user);
        return JSONResult.ok(sid);
    }

    @PostMapping(value = "create")
    public JSONResult create(@Valid @RequestBody() SysUserBO userBO, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return JSONResult.errorMap(map);
        }
        String sid = UUID.randomUUID().toString();
        SysUser user = new SysUser();
        // 从userBO属性拷贝到user
        BeanUtils.copyProperties(userBO, user);
        user.setId(sid);
        sysUserService.saveSysUser(user);
        return JSONResult.ok();
    }

    @GetMapping(value = "detail")
    public JSONResult detail(@RequestParam String id) {
        SysUser user = sysUserService.detailById(id);
        return JSONResult.ok(user);
    }

    //条件查询list
    @GetMapping(value = "list")
    public JSONResult list(@RequestParam String name, Integer sex) {
        List<SysUser> list = sysUserService.queryByCondition(name, sex);
        return JSONResult.ok(list);
    }

    //根据id删除
    @PostMapping(value = "remove")
    public JSONResult remove(String id) {
        sysUserService.remove(id);
        return JSONResult.ok();
    }

    //测试事务回滚
    @GetMapping(value = "testTrans")
    public JSONResult testTrans(){
        sysUserService.trans();
        return JSONResult.ok();
    }
    //自定义mapper 测试
    @GetMapping(value = "customer")
    public JSONResult customer (@RequestParam String id){
       List<SysUser> users =  sysUserService.customer(id);
        return JSONResult.ok(users);
    }
    public Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            String field = error.getField();
            String msg = error.getDefaultMessage();
            map.put(field, msg);
        }
        return map;
    }
}
