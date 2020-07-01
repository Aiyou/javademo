package com.cxl.demo.controller;

import com.cxl.demo.annotation.PassToken;
import com.cxl.demo.entity.DemoDo;
import com.cxl.demo.service.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/7/1 2:27 下午
 */
@RestController
@Tag(name = "demo", description = "demo API")
@RequestMapping("/demo")
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @Operation(summary = "demo", description = "Application of demo version 1.0", tags = {"demo"})
    @GetMapping("v1/getList")
    @PassToken
    public ResponseEntity<List<DemoDo>> getDeviceList() {
        List<DemoDo> list = demoService.getList();
        return ResponseEntity.ok(list);
    }
}
