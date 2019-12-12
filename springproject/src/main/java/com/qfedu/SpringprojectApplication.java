package com.qfedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 开关类
@SpringBootApplication// 标记 这是SpringBoot项目
@EnableSwagger2 // 启动Swagger的扫描
@MapperScan("com.qfedu.user.dao")
public class SpringprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringprojectApplication.class, args);
    }

}
