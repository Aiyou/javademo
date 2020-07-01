package com.cxl.demo.exception;

/**
 * @author Chenxiaoling
 * @date 2020/6/30 3:20 下午
 */
public class BusinessException extends RuntimeException{


    private static final long serialVersionUID = 2528764459007664370L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

