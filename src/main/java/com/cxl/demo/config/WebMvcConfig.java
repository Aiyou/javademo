package com.cxl.demo.config;

import com.cxl.demo.interceptor.PermissionInterceptor;
import com.cxl.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chenxiaoling
 * @date 2020/6/19 3:42 下午
 */

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(permissionInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/swagger-ui/**","/v1/api-docs","/v1/api-docs/**","/error");
    }
    @Bean
    public PermissionInterceptor permissionInterceptor(){
        return new PermissionInterceptor(redisUtils);
    }
}
