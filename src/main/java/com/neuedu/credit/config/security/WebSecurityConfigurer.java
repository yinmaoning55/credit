package com.neuedu.credit.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName WebSecurityConfigure
 * @Description TODO 自定义 web security configurer
 * @Author elvin yuan
 * @Date 2018/9/9 21:32
 * @Version 1.0
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService userService() { //注册UserDetailsService 的bean
        return new UserDetailsServiceImp();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行
     *我们指定任何用户都可以访问多个URL的模式。以"/resources/","/user", 或者 "/about"开头。
     * 以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问。
     * 尚未匹配的任何URL都要求用户进行身份验证
     * 请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀。
     *  任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
     和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
     .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
     任何以"/db/" 开头的URL只需要拥有 "ROLE_ADMIN" 和 "ROLE_DBA"其中一个权限的用户才可以访问。
     和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
     .antMatchers("/db/**").hasAnyRole("ADMIN", "DBA")
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .antMatchers("/user/**").hasAnyRole("USER","ADMIN","CUSTOMSERVICE")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error")
                .successForwardUrl("/user/index")
        .and().csrf().disable();
              /*  .and()
                .logout().logoutSuccessUrl("/login?logout")*/
               /* .and()
                .csrf()*/
               /* .and()
                .sessionManagement()
                    .invalidSessionUrl("/login")
                    .maximumSessions(1)
                    .expiredUrl("/login")*/
                ;

    }
}
