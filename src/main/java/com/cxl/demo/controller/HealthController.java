package com.cxl.demo.controller;

import com.cxl.demo.annotation.PassToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 健康检查
 * @author Chenxiaoling
 * @date 2020/6/28 10:41 上午
 */
@Controller
public class HealthController {
    @RequestMapping(value = "/health")
    @ResponseBody
    @PassToken
    public String heath() {
        return "ok";
    }
}
