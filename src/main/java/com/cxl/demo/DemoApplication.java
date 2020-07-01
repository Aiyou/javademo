package com.cxl.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ClassName DemoApplication
 * @Description demo project run class
 * @Author chenxiaoling
 * @Date 2020/6/16 11:05 上午
 **/
@SpringBootApplication
@MapperScan("com.cxl.demo.mapper")
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
