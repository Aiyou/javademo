package com.cxl.demo.mapper;

import com.cxl.demo.entity.DemoDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Chenxiaoling
 * @date 2020/6/18 10:51 上午
 */
@Repository
public interface DemoMapper {
    List<DemoDo> getList() ;
}
