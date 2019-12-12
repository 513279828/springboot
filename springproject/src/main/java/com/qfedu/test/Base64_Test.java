package com.qfedu.test;

import org.junit.Test;

import java.util.Base64;

public class Base64_Test {
    @Test
    public void t1() {
        String abc = "Hello, Java";
        // 编码 将内容变为base64格式
        String b = Base64.getEncoder().encodeToString(abc.getBytes());
        System.out.println("base64:" + b);

        // 解码
        System.out.println(new String(Base64.getDecoder().decode(b)));
    }
}
