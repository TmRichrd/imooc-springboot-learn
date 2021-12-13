package com.imooc.exception;

import com.imooc.utils.JSONResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 统一异常拦截处理
*
* */
@ControllerAdvice
public class GraceExceptionHandler {
    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public JSONResult returnMaxFileSizeLimit(){
        return JSONResult.errorMsg("文件大小不能超过500kb");
    }

    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JSONResult returnMyCustomException(MyCustomException e){
        return JSONResult.errorMsg(e.getMessage());
    }
}
