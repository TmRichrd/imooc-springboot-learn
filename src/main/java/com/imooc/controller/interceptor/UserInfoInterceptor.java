package com.imooc.controller.interceptor;

import com.imooc.exception.GraceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");
        if (!StringUtils.hasLength(userId) || !StringUtils.hasLength(userToken)) {
            GraceException.display("用户校验不通过，信息不完整");
            return false;
        }
        if (!userId.equalsIgnoreCase("1001") || !userToken.equalsIgnoreCase("abcd")) {
            GraceException.display("用户校验不通过");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
