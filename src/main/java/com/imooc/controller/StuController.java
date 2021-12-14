package com.imooc.controller;

import com.imooc.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.Map;
@RestController //@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@Slf4j
@RequestMapping(value = "stu")
public class StuController {
    @GetMapping(value = "get")
    public String get() {
        return "get";
    }

    @PostMapping(value = "post")
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
    @GetMapping(value = "put")
    public String put() {
        return "put";
    }
    @GetMapping(value = "delete")
    public String delete() {
        return "delete";
    }

    @PostMapping(value = "upload")
    public String upload(MultipartFile file) throws Exception{
        file.transferTo(new File("E:/360downloads/imooc-spring-starter/src/main/resources/static/css/"+file.getOriginalFilename()));
        return "上传成功";
    }
}
