package com.cxl.demo.service.impl;

import com.cxl.demo.entity.DemoDo;
import com.cxl.demo.mapper.DemoMapper;
import com.cxl.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/6/17 11:37 上午
 */

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);


    private DemoMapper demoMapper;

    @Autowired
    public DemoServiceImpl(DemoMapper demoMapper) {

        this.demoMapper = demoMapper;
    }

    public List<DemoDo> getList(){
        return demoMapper.getList();
    }

}
