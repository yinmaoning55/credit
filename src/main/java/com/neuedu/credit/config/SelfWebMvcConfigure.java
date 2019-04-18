package com.neuedu.credit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName SelfMvcConfigureAdapter
 * @Description TODO SpringMvc Configurer
 * @Author elvin yuan
 * @Date 2018/9/9 21:49
 * @Version 1.0
 **/
@Configuration
public class SelfWebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("other/index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/user/add").setViewName("/user/add");
        registry.addViewController("/register").setViewName("/login/register");
        registry.addViewController("/info/entindex").setViewName("/info/entindex");
    }
}
