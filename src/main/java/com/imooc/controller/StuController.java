package com.imooc.controller;

import com.imooc.pojo.MyConfig;
import com.imooc.pojo.Stu;
import com.imooc.pojo.Student;
import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@Slf4j
@RequestMapping("stu")
public class StuController {
    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @PostMapping("/post")
    public JSONResult post(
            @RequestBody Map<String,Object> map,
            @RequestHeader("token") String token,
            @CookieValue("clientId") String clientId
    ) {
        log.info(map.toString());
        log.info(token);
        log.info(clientId);
        return JSONResult.ok(map);
    }
    @GetMapping("/put")
    public String put() {
        return "put";
    }
    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception{
        file.transferTo(new File("E:/360downloads/imooc-spring-starter/src/main/resources/static/css/"+file.getOriginalFilename()));
        return "上传成功";
    }
}
