package com.cxl.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Chenxiaoling
 * @date 2020/7/1 2:28 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoDo implements Serializable {
    private static final long serialVersionUID = 5050948022924112878L;
    private int id;
    private String userName;
}
