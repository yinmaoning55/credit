package com.neuedu.credit.util.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by elvin on 2018/9/26 10:11.
 * @Describe:
 */
@Configuration
public class EmailConfig {

    @Value("${spring.mail.username}")
    private String emailFrom;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;

    }
}
