package com.imooc.controller;

import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@Slf4j
@RequestMapping(value = "demo")
public class HelloController {
    public String hello() {
        return "Hello World!";
    }

//    //    注入
//    @Autowired
//    private Stu stu;
//
//    @GetMapping("getStu")
//    public Object getStu() {
//        return stu;
//    }

    @Autowired
    private MyConfig myConfig;

    @GetMapping(value = "getMyConfig")
    public Object getMyConfig() {
        return myConfig;
    }


    @GetMapping(value = "getStudent")
    public Object getStudent() {
            Student stu = new Student();
            stu.setName("jack");
            stu.setAge(18);
            System.out.println(stu.toString());
            log.info(stu.toString());
            return stu;
    }
}
