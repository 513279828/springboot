package com.qfedu.test;

import com.qfedu.utils.JwtUtil;
import org.junit.Test;

public class Jwt_Test {
    @Test
    public void t1() {
        String m = "admin";
        String t = JwtUtil.createJWT(1 + "", 30, m);
        System.out.println(t);

        // 解析
        System.out.println(JwtUtil.parseJWT(t));
    }
}
