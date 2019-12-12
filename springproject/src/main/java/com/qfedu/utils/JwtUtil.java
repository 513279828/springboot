package com.qfedu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

// 生成和解析token
public class JwtUtil {
    // 生成
    public static String createJWT(String id, int minutes, String content) {
        // 创建加密的技术  sha-256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 创建JWT建造对象
        JwtBuilder jwtBuilder = Jwts.builder();

        //设置JWt相关信息
        jwtBuilder.setId(id); // 唯一
        jwtBuilder.setIssuedAt(new Date()); // 开始时间
        jwtBuilder.setSubject(content); // 设置JWT中的内容
        jwtBuilder.signWith(signatureAlgorithm, createKey());
        // 生成JWT
        return jwtBuilder.compact();
    }

    public static String createJWT(String content) {
        // 创建加密的技术  sha-256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 创建JWT建造对象
        JwtBuilder jwtBuilder = Jwts.builder();

        //设置JWt相关信息
        jwtBuilder.setIssuedAt(new Date()); // 开始时间
        jwtBuilder.setSubject(content); // 设置JWT中的内容
        jwtBuilder.signWith(signatureAlgorithm, createKey());
        // 生成JWT
        return jwtBuilder.compact();
    }

    // 解析
    public static String parseJWT(String token) {
        SecretKey key = createKey();
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.getSubject();

    }

    // 创建
    private static SecretKey createKey() {
        byte[] keys = "yardtoken".getBytes();
        SecretKey key = new SecretKeySpec(keys, 0, keys.length, "AES");
        return key;
    }
}
