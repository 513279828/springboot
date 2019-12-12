package com.qfedu.config;

import com.qfedu.filter.SmsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    //SpringBoot项目注册过滤器
    @Bean
    public FilterRegistrationBean createFR(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new SmsFilter());
        bean.addUrlPatterns("/sendcode.do");
        return bean;
    }
}
