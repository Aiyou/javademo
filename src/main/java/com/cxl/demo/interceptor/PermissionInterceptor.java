package com.cxl.demo.interceptor;

import com.cxl.demo.annotation.PassToken;
import com.cxl.demo.exception.BusinessException;
import com.cxl.demo.utils.Consts;
import com.cxl.demo.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName PermissionInterceptor
 * @Description certification of message pusher
 * @Author wood
 * @Date 2020/5/12 9:00 上午
 **/
public class PermissionInterceptor implements HandlerInterceptor {


    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionInterceptor.class);

    private RedisUtils redisUtils;

    @Autowired
    public PermissionInterceptor(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        String token = request.getHeader(Consts.AUTHORIZATION);

        if (StringUtils.isEmpty(token)) {
            LOGGER.error("token is empty，requestUrl={}", request.getRequestURI());
            throw new BusinessException("token is empty，requestUrl : " + request.getRequestURI());
        }
        if (redisUtils.getValue(token) == null || redisUtils.getValue(token)== "") {
            throw new BusinessException("Token authentication failed");
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

}
