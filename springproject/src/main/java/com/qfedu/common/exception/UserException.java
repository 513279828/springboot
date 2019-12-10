package com.qfedu.common.exception;

public class UserException extends Exception {
    public UserException() {
        super(); // 执行继承父类的方法
    }

    public UserException(String msg) {
        super(msg);
    }
}
